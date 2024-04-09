package main.service;

import avro.AdminRequest;
import main.dto.BookingDTO;
import main.mapper.BookingMapper;
import main.mapper.avro.AdminRequestMapper;
import main.mapper.avro.PaymentRequestMapper;
import main.model.Booking;
import main.producer.BookingProducerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import main.repository.BookingRepository;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRequestMapper paymentRequestMapper;

    @Autowired
    private AdminRequestMapper adminRequestMapper;
    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private BookingProducerService bookingProducerService;

    /**
     *
     * logic:
     * 1. endpoint call
     *         -> booking has an expiry time. when receiving payment message, a check must be made
     *         to verify that the expiry time (15 min) has passed. if not, only then proceed with step 4.
     * 2. if booking creation is successful -> send message to admin topic
     * 3. listen to admin-request topic -> if message OK, send message to payment topic
     *                          -> if not OK, throw error, e.g. not enough seats available
     * 4. listen to response from payment-details topic
     *                          -> if status field == succeeded
     *                                  --> update booking STATUS
     *                                  --> send OK to notification topic
     *                          -> if not, update booking status == failed
     *                                  --> send notification as failed,
     *                                  --> send back to admin topic so that it modifies
     *                                  the number of remaining seats accordingly
     */


    @Override
    public Mono<BookingDTO> createBooking(Mono<BookingDTO> bookingDTOMono) {
        return bookingDTOMono
                .map(bookingMapper::toEntity)
                .flatMap(booking -> {
                    // Set initial status and expiration time as needed
                    booking.setStatus("PENDING");
                    booking.setCreatedAt(LocalDateTime.now());
                    booking.setExpiresAt(LocalDateTime.now().plusMinutes(15)); // Set expiration 15 minutes from now
                    return bookingRepository.save(booking);
                })
                .map(bookingMapper::toDTO)
                .doOnSuccess(bookingDTO -> {
                    // Preparing admin request based on the booking details
                    AdminRequest adminRequest = adminRequestMapper.toAdminRequest(bookingMapper.toEntity(bookingDTO));
                    // Sending to admin topic for initial processing
                    bookingProducerService.sendAdminRequest("admin-request-topic", adminRequest);
                });
    }

    @Override
    public Mono<BookingDTO> getBookingById(String id) {
        return bookingRepository.findById(id)
                .map(bookingMapper::toDTO);
    }

    @Override
    public Flux<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .map(bookingMapper::toDTO);
    }

    @Override
    public Mono<BookingDTO> updateBooking(String id, Mono<BookingDTO> bookingDTOMono) {
        return bookingRepository.findById(id)
                .flatMap(existingBooking -> bookingDTOMono
                        .map(bookingMapper::toEntity)
                        .doOnNext(updatedBooking -> {
                            String[] ignoreProperties = {"id"};
                            BeanUtils.copyProperties(updatedBooking, existingBooking, ignoreProperties);
                        })
                        .then(Mono.just(existingBooking)))
                .flatMap(bookingRepository::save)
                .map(bookingMapper::toDTO);
    }

    @Override
    public Mono<Void> deleteBooking(String id) {
        return bookingRepository.deleteById(id);
    }
}

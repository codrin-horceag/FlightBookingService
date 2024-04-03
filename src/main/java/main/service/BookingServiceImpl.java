package main.service;

import avro.PaymentDetailsBookingRecord;
import main.dto.BookingDTO;
import main.mapper.BookingMapper;
import main.mapper.avro.PaymentDetailsBookingRecordMapper;
import main.producer.BookingProducerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import main.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentDetailsBookingRecordMapper paymentDetailsBookingRecordMapper;
    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private BookingProducerService bookingProducerService;

    @Override
    public Mono<BookingDTO> createBooking(Mono<BookingDTO> bookingDTOMono) {
        return bookingDTOMono.map(bookingMapper::toEntity)
                .flatMap(bookingRepository::save)
                .map(bookingMapper::toDTO)
                .doOnSuccess(bookingDTO -> {
                    PaymentDetailsBookingRecord paymentDetailsBookingRecord = paymentDetailsBookingRecordMapper.toAvroRecord(bookingDTO);
                    bookingProducerService.sendPaymentDetailsBookingRecord("payment-details-booking-topic", paymentDetailsBookingRecord);
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

package service;

import dto.BookingDTO;
import mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public Mono<BookingDTO> createBooking(Mono<BookingDTO> bookingDTOMono) {
        return bookingDTOMono.map(bookingMapper::toEntity)
                .flatMap(bookingRepository::save)
                .map(bookingMapper::toDTO);
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
                .flatMap(p -> bookingDTOMono.map(bookingMapper::toEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(bookingRepository::save)
                .map(bookingMapper::toDTO);
    }

    @Override
    public Mono<Void> deleteBooking(String id) {
        return bookingRepository.deleteById(id);
    }
}

package repository;

import model.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookingRepository extends ReactiveMongoRepository<Booking, String> {
}

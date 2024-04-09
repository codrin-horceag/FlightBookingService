package main.consumer;
import avro.AdminRequest;
import avro.PaymentRequest;
import main.mapper.BookingMapper;
import main.mapper.avro.AdminRequestMapper;
import main.mapper.avro.PaymentRequestMapper;
import main.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminRequestConsumer {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRequestMapper paymentRequestMapper;

    @Autowired
    private AdminRequestMapper adminRequestMapper;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "admin-response-topic", groupId = "admin-response-group")
    public void handleAdminResponse(AdminRequest adminResponse) {
        bookingRepository.findById(adminResponse.getBookingId()).flatMap(booking -> {
            if (adminResponse.getStatus().equals("SUCCEEDED")) {
                // Check if booking hasn't expired
                if (booking.getExpiresAt().isAfter(LocalDateTime.now())) {
                    // Prepare and send payment request
                    PaymentRequest paymentRequest = paymentRequestMapper
                            .toAvroRecord(bookingMapper.toDTO(booking));
                    // Set other fields accordingly
                    kafkaTemplate.send("payment-details-topic", paymentRequest);
                } else {
                    // Handle expired booking
                    booking.setStatus("EXPIRED");
                    AdminRequest adminRequest = adminRequestMapper.toAdminRequest(booking);
                    adminRequest.setStatus("FAILED");
                    kafkaTemplate.send("admin-response-topic", adminRequest);
                    return bookingRepository.save(booking);

                }
            } else {
                // Handle admin rejection
                booking.setStatus("FAILED");
                return bookingRepository.save(booking);
            }
            return null;
        }).subscribe();
    }
}


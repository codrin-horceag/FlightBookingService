package main.consumer;

import avro.AdminRequest;
import avro.PaymentRequest;
import main.mapper.PaymentDetailsMapper;
import main.mapper.avro.AdminRequestMapper;
import main.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class PaymentRequestConsumer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PaymentDetailsMapper paymentDetailsMapper;

    @Autowired
    private AdminRequestMapper adminRequestMapper;

    @KafkaListener(topics = "payment-details-topic", groupId = "payment-details-response-group")
    public void handlePaymentDetailsResponse(PaymentRequest paymentResponse) {
        bookingRepository.findById(paymentResponse.getBookingId()).flatMap(booking -> {
            if (paymentResponse.getStatus().equals("SUCCEEDED")) {
                // Update booking status and notify
                booking.setStatus("COMPLETED");
                //TODO: Replace with actual notification message
                kafkaTemplate.send("notification-topic", "Your booking is confirmed: " + booking.getBookingId());
            } else {
                // Update booking status, notify, and inform admin to revert seats
                booking.setStatus("FAILED");
                kafkaTemplate.send("notification-topic", "Your booking has failed: " + booking.getBookingId());
                AdminRequest revertRequest = adminRequestMapper.toAdminRequest(booking);
                revertRequest.setStatus("FAILED");
                // Set other fields to revert the operation
                kafkaTemplate.send("admin-topic", revertRequest);
            }
            return bookingRepository.save(booking);
        }).subscribe();
    }
}

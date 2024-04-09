package main.consumer;

import avro.PaymentRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.mapper.PaymentDetailsMapper;
import main.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PaymentRequestConsumer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PaymentDetailsMapper paymentDetailsMapper; // Assuming you have a mapper for PaymentDetails

    @KafkaListener(topics = "payment-response-topic", groupId = "payment-details-group")
    public void listenToPaymentResponse(PaymentRequest response) {
        if ("SUCCEEDED".equals(response.getStatus())) {
            // Update booking in the database to reflect payment success
            bookingRepository.findById(response.getBookingId()).subscribe(booking -> {
                booking.setStatus("CONFIRMED");
                bookingRepository.save(booking);
            });
            // Assume a method to send OK notification exists
        } else {
            // Update booking status to FAILED and handle accordingly
            bookingRepository.findById(response.getBookingId()).subscribe(booking -> {
                booking.setStatus("FAILED");
                bookingRepository.save(booking);
                // Handle sending notification of failure
            });
        }
    }
}

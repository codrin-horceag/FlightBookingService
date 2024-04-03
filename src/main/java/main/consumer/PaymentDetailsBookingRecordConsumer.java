package main.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import avro.PaymentDetailsBookingRecord;

@Service
public class PaymentDetailsBookingRecordConsumer {

    @KafkaListener(topics = "payment-details-booking-topic", groupId = "payment-details-group")
    public void listen(PaymentDetailsBookingRecord record) {
        System.out.println("Received a payment details booking record:");
        System.out.println("Booking ID: " + record.getBookingId());
    }
}

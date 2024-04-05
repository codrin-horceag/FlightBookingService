package main.producer;


import avro.BookingRecord;
import avro.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducerService {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendBookingRecord(String topic, BookingRecord bookingRecord) {
        template.send(topic, bookingRecord);
    }

    public void sendPaymentRequest(String topic, PaymentRequest PaymentRequest) {
        template.send(topic, PaymentRequest);
    }
}


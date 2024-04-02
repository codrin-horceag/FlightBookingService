package main.producer;

import avro.BookingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducerService {

    @Autowired
    private KafkaTemplate<String, BookingRecord> kafkaTemplate;

    public void sendBookingRecord(String topic, BookingRecord bookingRecord) {
        kafkaTemplate.send(topic, bookingRecord);
    }
}


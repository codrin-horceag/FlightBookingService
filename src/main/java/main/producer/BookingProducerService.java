package main.producer;


import avro.BookingRecord;
import avro.PaymentDetailsBookingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducerService {

    @Autowired
    private KafkaTemplate<String, BookingRecord> kafkaBookingRecordTemplate;

    @Autowired
    private KafkaTemplate<String, PaymentDetailsBookingRecord> kafkaPaymentDetailsBookingRecordTemplate;

    public void sendBookingRecord(String topic, BookingRecord bookingRecord) {
        kafkaBookingRecordTemplate.send(topic, bookingRecord);
    }

    public void sendPaymentDetailsBookingRecord(String topic, PaymentDetailsBookingRecord paymentDetailsBookingRecord) {
        kafkaPaymentDetailsBookingRecordTemplate.send(topic, paymentDetailsBookingRecord);
    }
}


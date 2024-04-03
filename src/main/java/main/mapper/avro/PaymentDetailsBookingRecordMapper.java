package main.mapper.avro;
import avro.PaymentDetailsBookingRecord;
import avro.FlightDetailsRecord;
import avro.PaymentDetailsRecord;
import main.dto.BookingDTO;
import main.dto.FlightDetailsDTO;
import main.dto.PaymentDetailsDTO;
import org.springframework.stereotype.Component;


@Component
public class PaymentDetailsBookingRecordMapper {

    public PaymentDetailsBookingRecord toAvroRecord(BookingDTO bookingDto) {
        FlightDetailsDTO flightDetailsDto = bookingDto.getFlightDetails();
        FlightDetailsRecord flightDetailsRecord = FlightDetailsRecord.newBuilder()
                .setStandardPrice(flightDetailsDto.getStandardPrice())
                .build();

        PaymentDetailsDTO paymentDetailsDto = bookingDto.getPaymentDetails();
        PaymentDetailsRecord paymentDetailsRecord = PaymentDetailsRecord.newBuilder()
                .setCardNumber(paymentDetailsDto.getCardNumber())
                .setCardHolderName(paymentDetailsDto.getCardHolderName())
                .setExpirationMonth(paymentDetailsDto.getExpirationMonth())
                .setExpirationYear(paymentDetailsDto.getExpirationYear())
                .setCvv(paymentDetailsDto.getCvv())
                .setCurrency(paymentDetailsDto.getCurrency())
                .setStatus(paymentDetailsDto.getStatus())
                .build();

        return PaymentDetailsBookingRecord.newBuilder()
                .setId(null)
                .setBookingId(bookingDto.getBookingId())
                .setFlightDetails(flightDetailsRecord)
                .setPaymentDetails(paymentDetailsRecord)
                .build();
    }
}


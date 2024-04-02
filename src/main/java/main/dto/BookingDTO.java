package main.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BookingDTO {
    private String bookingId;
    private String userId;
    private LocalDateTime createdAt;
    private PaymentDetailsDTO paymentDetails;
    private List<PassengerDetailsDTO> passengerDetails;
    private FlightDetailsDTO flightDetails;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PaymentDetailsDTO getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsDTO paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<PassengerDetailsDTO> getPassengerDetails() {
        return passengerDetails;
    }

    public void setPassengerDetails(List<PassengerDetailsDTO> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    public FlightDetailsDTO getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(FlightDetailsDTO flightDetails) {
        this.flightDetails = flightDetails;
    }
}
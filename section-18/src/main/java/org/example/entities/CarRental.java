package org.example.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CarRental {
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private Vehicle vehicle;
    private Invoice invoice;


    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = LocalDateTime.parse(pickupDate, formatter);
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = LocalDateTime.parse(returnDate, formatter);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {

        String summary = """
                Basic payment: %.2f
                Tax: %.2f
                Total payment: %.2f
                """;

        return String.format(summary, invoice.getBasicPayment(), invoice.getTax(), invoice.getTotalPayment());
    }
}

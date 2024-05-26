package org.example.services;

import org.example.entities.CarRental;
import org.example.entities.Invoice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RentalServices {
    private double pricePerHour;
    private double pricePerDay;
    private BrazilTaxServices taxService;

    public RentalServices() {
        taxService = new BrazilTaxServices();
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getRentalHours(LocalDateTime pickupDate, LocalDateTime returnDate) {
        return (int) Math.ceil(ChronoUnit.MINUTES.between(pickupDate, returnDate) / 60.0);
    }

    public void processInvoice(CarRental carRental) {
        int rentalHours = this.getRentalHours(carRental.getPickupDate(), carRental.getReturnDate());
        Invoice invoice = new Invoice();
        if (rentalHours > 12) {
            double days = Math.ceil(rentalHours / 24.0);
            invoice.setBasicPayment(days * this.pricePerDay);
        } else {
            invoice.setBasicPayment(rentalHours * this.pricePerHour);
        }

        invoice.setTax(this.taxService.tax(invoice.getBasicPayment()));

        carRental.setInvoice(invoice);
    }
}

package org.example.services;

public interface IOnlinePaymentServices {
    double interest(double amount, int month);
    double paymentFee(double amount);
}

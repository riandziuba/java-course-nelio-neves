package org.example.services;

public class PayPalServices implements IOnlinePaymentServices {
    private static final double interestRate = 0.01;
    private static final double paymentFeeRate = 0.02;

    @Override
    public double interest(double amount, int month) {
        return amount * (interestRate * month);
    }

    @Override
    public double paymentFee(double amount) {
        return amount * paymentFeeRate;
    }
}

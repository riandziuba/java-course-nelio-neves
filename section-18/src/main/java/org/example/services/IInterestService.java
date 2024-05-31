package org.example.services;

import java.security.InvalidParameterException;

public interface IInterestService {
    double getInterestRate();

    default double payment(double amount, int months) {
        if (months < 1) {
            throw new InvalidParameterException("months must be greater than zero");
        }
        return amount * Math.pow((1 + getInterestRate() / 100), months);
    }
}

package org.example.services;

import java.security.InvalidParameterException;

public class BrazilianInterestService implements IInterestService{
    private double interestRate;

    public BrazilianInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}

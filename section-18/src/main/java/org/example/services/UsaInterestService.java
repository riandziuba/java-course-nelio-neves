package org.example.services;

import java.security.InvalidParameterException;

public class UsaInterestService implements IInterestService{
    private double interestRate;

    public UsaInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}

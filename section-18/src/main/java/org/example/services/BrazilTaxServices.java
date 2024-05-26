package org.example.services;

public class BrazilTaxServices implements ITaxServices {
    public double tax(double amount) {
        double taxRate = 0;
        if (amount > 100) taxRate = 0.15;
        else taxRate = 0.20;

        return amount * taxRate;
    }


}

package org.withclass.utils;

public class CurrencyConverter {
    public static double buyDollar(double price, double amount) {
        return price * amount * 1.06;
    }
}

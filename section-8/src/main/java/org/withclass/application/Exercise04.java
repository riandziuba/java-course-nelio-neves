package org.withclass.application;

import org.withclass.utils.CurrencyConverter;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        double price = scanner.nextDouble();
        System.out.print("How many dollars do you want to buy? ");
        double amount = scanner.nextDouble();

        System.out.print("Amount to be paid in reais is: " + CurrencyConverter.buyDollar(price, amount));
    }
}

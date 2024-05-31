package org.example;

import org.example.services.BrazilianInterestService;
import org.example.services.IInterestService;
import org.example.services.UsaInterestService;

import java.util.Scanner;

public class DefaultMethodsExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Months: ");
        int months = scanner.nextInt();

        IInterestService service = new BrazilianInterestService(2.0);

        double payment = service.payment(amount, months);

        System.out.println("Payment after " + months + " months in Brazil:");
        System.out.printf("%.2f%n", payment);

        service = new UsaInterestService(1.0);
        payment = service.payment(amount, months);

        System.out.println("Payment after " + months + " months in USA:");
        System.out.printf("%.2f%n", payment);


        scanner.close();
    }
}

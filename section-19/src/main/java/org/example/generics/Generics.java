package org.example.generics;

import org.example.generics.services.PrintService;

import java.util.Scanner;

public class Generics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PrintService printService = new PrintService();

        System.out.print("How many values?");
        int numberOfValues = scanner.nextInt();

        for (int i = 0; i < numberOfValues; i++) {
            int value = scanner.nextInt();
            printService.addValue(value);
        }

        printService.print();

        System.out.println("First: " + printService.first());

        scanner.close();
    }
}

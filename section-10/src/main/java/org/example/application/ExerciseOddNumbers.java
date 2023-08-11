package org.example.application;

import org.example.entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class ExerciseOddNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos pessoas vai digitar? ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Digite o número:");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Números pares:");
        int count = 0;
        for (int number: numbers) {
            if (number % 2 == 0) {
                count++;
                System.out.print(number + "  ");
            }
        }

        System.out.println("\nQuantidade de Pares: " + count);
    }
}

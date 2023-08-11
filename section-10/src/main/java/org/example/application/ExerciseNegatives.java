package org.example.application;

import java.util.Locale;
import java.util.Scanner;

public class ExerciseNegatives {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos número vai digitar? (max: 10) ");
        int n = scanner.nextInt();

        while (n > 10) {
            System.out.println("O número máximo é 10 digite novamente: ");
            n = scanner.nextInt();
        }

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Digite um número: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("NUMEROS NEGATIVOS:");

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
               System.out.println(array[i]);
            }
        }


    }
}

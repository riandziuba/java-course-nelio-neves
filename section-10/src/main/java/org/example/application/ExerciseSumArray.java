package org.example.application;

import java.util.Scanner;

public class ExerciseSumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos número você vai digitar");
        int n = scanner.nextInt();

        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println("Digite um valor: ");
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        System.out.print("Valores:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("Soma: " + sum);

        System.out.println("Media:" + sum/array.length);
    }
}

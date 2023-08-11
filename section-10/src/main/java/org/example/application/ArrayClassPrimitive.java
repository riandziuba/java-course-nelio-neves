package org.example.application;

import java.util.Scanner;

public class ArrayClassPrimitive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        double[] vect = new double[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            vect[i] = scanner.nextDouble();
            sum += vect[i];
        }

        System.out.println("Average height: " + sum/n);


    }
}

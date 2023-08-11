package org.example.application;

import java.util.Locale;
import java.util.Scanner;

public class MatrizExercise {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of lines and columns?");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matriz = new int[n][m];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Number to search for:");
        int number = scanner.nextInt();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (number == matriz[i][j]) {
                    System.out.println("Position(" + i + "," + j + ")");
                    if (j - 1 >= 0) {
                        System.out.println("Left:" + matriz[i][j - 1]);
                    }
                    if (j + 1 < matriz[i].length) {
                        System.out.println("Right:" + matriz[i][j + 1]);
                    }
                    if (i - 1 >= 0) {
                        System.out.println("Up:" + matriz[i - 1][j]);
                    }
                    if (i + 1 < matriz.length) {
                        System.out.println("Down:" + matriz[i + 1][j]);
                    }

                }
            }
        }
        scanner.close();
    }
}

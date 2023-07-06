package org.example.forloop;

import java.util.Scanner;

public class teachingClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y;
        int sum = 0;

        for (int i = 0; i < x; i++) {
            y = scanner.nextInt();
            sum += y;
        }

        System.out.println("Sua soma é " + sum);
        scanner.close();
    }
}
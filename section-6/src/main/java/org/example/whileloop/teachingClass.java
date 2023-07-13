package org.example.whileloop;

import java.util.Scanner;

public class teachingClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int sum = 0;

        while (x != 0) {
            sum += x;
            x = scanner.nextInt();
        }

        System.out.println("Sua soma é " + sum);
        scanner.close();
    }
}
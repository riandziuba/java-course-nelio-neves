package org.example.whileloop;

import java.util.Scanner;

public class question02 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        while (x != 0 && y != 0) {
            if (x > 0) {
                if (y > 0) {
                    System.out.println("Primeiro");
                } else {
                    System.out.println("Quarto");
                }
            } else {
                if (y > 0) {
                    System.out.println("Segundo");
                } else {
                    System.out.println("Terceiro");
                }
            }

            x = scanner.nextInt();
            y = scanner.nextInt();
        }

        scanner.close();
    }
}

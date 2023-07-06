package org.example.forloop;

import java.util.Scanner;

public class question02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y;
        int in = 0;
        int out = 0;

        for (int i = 0; i < x; i++) {
            y = scanner.nextInt();
            if (y > 9 && y < 21) {
                in++;
            } else {
                out++;
            }
        }

        System.out.println("In " + in);
        System.out.println("Out " + out);
        scanner.close();
    }
}

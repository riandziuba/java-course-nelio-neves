package org.example.forloop;

import java.util.Scanner;

public class question01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();

        for (int i = 0; i < x; i++) {
            if(i % 2 != 0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }

}

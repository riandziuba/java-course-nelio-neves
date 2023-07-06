package org.example.whileloop;

import java.util.Scanner;

public class question01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userPassword = scanner.nextInt();
        int correctPassword = 2002;

        while (userPassword != correctPassword) {
            System.out.println("Senha incorreta");
            userPassword = scanner.nextInt();
        }

        System.out.println("Acesso Permitido");
        scanner.close();
    }
}

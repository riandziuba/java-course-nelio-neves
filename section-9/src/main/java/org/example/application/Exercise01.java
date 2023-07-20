package org.example.application;

import org.example.entities.Account;

import java.util.Scanner;

public class Exercise01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account;
        System.out.print("Digite o número da conta: ");
        int number = scanner.nextInt();
        System.out.print("Digite o nome do dono da conta: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Gostaria de fazer um deposito inicial? (Digite 1 para sim e 2 para não) ");

        if(scanner.nextInt() == 1) {
            System.out.print("Qual o valor do deposito inicial? ");
            double initialBalance = scanner.nextDouble();
            account = new Account(number, name, initialBalance);
        } else {
            account = new Account(number, name);
        }
        System.out.println("Os dados inicias são: " + account);

        System.out.print("Qual o valor do deposito? ");
        double value = scanner.nextDouble();
        account.deposit(value);
        System.out.println("Os dados atulizados são: " + account);

        System.out.print("Qual o valor do saque? ");
        value = scanner.nextDouble();
        account.withdraw(value);
        System.out.println("Os dados atulizados são: " + account);

    }
}

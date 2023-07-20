package org.example.entities;

public class Account {
    private final int number;
    private String ownerName;
    private double balance;

    public Account(int number, String ownerName, double initialBalance) {
        this.number = number;
        this.ownerName = ownerName;
        this.deposit(initialBalance);
    }

    public Account(int number, String ownerName) {
        this.number = number;
        this.ownerName = ownerName;
    }

    public void withdraw(double value) {
        this.balance -= value + 5;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public String toString() {
        return "Número: " + number + " Nome: " + ownerName + " Saldo: R$" + balance;
    }
}

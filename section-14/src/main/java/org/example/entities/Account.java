package org.example.entities;

public class Account {
    private Integer number;
    private String holder;
    protected Double balance = 0.0;

    public Account(Integer number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount + 5;
    }

    public Double getBalance() {
        return balance;
    }
}

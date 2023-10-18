package org.example.entities;

public class SavingsAccount extends Account {

    private Double interestRate;
    public SavingsAccount(Integer number, String holder, double interestRate) {
        super(number, holder);
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        double interest = this.getBalance() * interestRate;
        this.deposit(interest);
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}

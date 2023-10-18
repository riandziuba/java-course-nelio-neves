package org.example.entities;

public class BusinessAccount extends Account {
    private Double loanLimit;
    public BusinessAccount(Integer number, String holder, Double loanLimit) {
        super(number, holder);
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount) {
        if (this.loanLimit >= amount) {
            this.deposit(amount);
        }
    }

}

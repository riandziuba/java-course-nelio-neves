package org.example;

import org.example.entities.Account;
import org.example.entities.BusinessAccount;
import org.example.entities.SavingsAccount;

public class Casting {
    public static void main(String[] args) {
        Account account = new Account(21312, "Bino");
        BusinessAccount businessAccount = new BusinessAccount(1002, "Bana", 300.0);

        Account upCastingAccount = businessAccount;
        Account upCastingAccount2 = new BusinessAccount(1002, "Bana", 300.0);
        Account upCastingAccount3 = new SavingsAccount(1002, "Bana", 0.01);


        BusinessAccount downCastingAccount = (BusinessAccount) upCastingAccount2;

        // BusinessAccount downCastingAccount2 = (BusinessAccount) upCastingAccount3;

        if (upCastingAccount3 instanceof BusinessAccount) {
            BusinessAccount downCastingAccount2 = (BusinessAccount) upCastingAccount3;
            downCastingAccount2.loan(200.0);
            System.out.println("Loan!");
        }


        if (upCastingAccount3 instanceof SavingsAccount) {
            SavingsAccount downCastingAccount3 = (SavingsAccount) upCastingAccount3;
            downCastingAccount3.updateBalance();
            System.out.println("Interested!");
        }
    }
}

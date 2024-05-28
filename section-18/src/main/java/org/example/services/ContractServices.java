package org.example.services;

import org.example.entities.Contract;
import org.example.entities.Instalment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class ContractServices {
    private final IOnlinePaymentServices paymentServices;

    public ContractServices(IOnlinePaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }

    public void processContract(Contract contract, int months) {

        for (int i = 1; i <= months; i++) {
            double amount = contract.getValue() / months;
            Instalment instalment = new Instalment();

            amount += this.paymentServices.interest(amount, i);
            amount += this.paymentServices.paymentFee(amount);
            instalment.setAmount(amount);

            LocalDate dueDate = contract.getDate().plusMonths(i);
            instalment.setDueDate(dueDate);

            contract.addInstalment(instalment);
        }
    }
}

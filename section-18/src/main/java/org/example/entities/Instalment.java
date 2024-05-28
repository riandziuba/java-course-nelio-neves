package org.example.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Instalment {
    private LocalDate dueDate;
    private double amount;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        String summary = """
                %s - %.2f
                """;

        return String.format(summary, this.dueDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), this.amount);
    }
}

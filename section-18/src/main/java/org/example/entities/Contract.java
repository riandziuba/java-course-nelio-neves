package org.example.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private int number;
    private LocalDate date;
    private double value;
    private final List<Instalment> instalments;

    public Contract() {
        this.instalments = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<Instalment> getInstalments() {
        return instalments;
    }

    public void addInstalment(Instalment instalment) {
        this.instalments.add(instalment);
    }

    public void instalmentsSummary() {
        System.out.println("Parcelas:");
        for (Instalment instalment : instalments) {
            System.out.println(instalment);
        }
    }
}

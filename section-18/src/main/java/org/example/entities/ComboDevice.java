package org.example.entities;

public class ComboDevice extends Device implements IPrinter, IScanner {
    @Override
    public void print(String doc) {
        System.out.println("Combo printing: " + doc);
    }

    @Override
    public String scan() {
        return "Combo scan result";
    }

    @Override
    public void processDoc(String doc) {
        System.out.println("Combo processing: " + doc);
    }
}

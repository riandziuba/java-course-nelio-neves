package org.example.entities;

public class Printer extends Device implements IPrinter {

    @Override
    public void processDoc(String doc) {
        System.out.println("Printer processing: " + doc);
    }

    public void print(String doc) {
        System.out.println("Printing: " + doc);
    }
}

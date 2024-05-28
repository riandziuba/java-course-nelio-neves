package org.example;

import org.example.entities.ComboDevice;
import org.example.entities.Printer;
import org.example.entities.Scanner;

public class MultiplesInterfaces {
    public static void main(String[] args) {

        Printer printer = new Printer();
        printer.processDoc("My letter");
        printer.print("My letter");

        Scanner scanner = new Scanner();
        printer.processDoc("My email");
        System.out.println("Scan result: " + scanner.scan());

        ComboDevice comboDevice = new ComboDevice();
        comboDevice.print("My dissertation");
        comboDevice.processDoc("My dissertation");
        System.out.println("scan result: " + comboDevice.scan());
    }
}

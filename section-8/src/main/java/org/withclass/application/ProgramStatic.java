package org.withclass.application;

import org.withclass.utils.Calculator;

import java.util.Scanner;

public class ProgramStatic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Radius");
        double radius = scanner.nextDouble();

        System.out.println("Circumference: " + Calculator.circumference(radius));
        System.out.println("Volume: " + Calculator.volume(radius));
        System.out.println("PI: " + Calculator.PI);
    }
}

package org.withclass.application;

import org.withclass.entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Triangle x, y;
        double a, b, c;

        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter the measures of triangle X:");
        x = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());

        System.out.println("Enter the measures of triangle Y:");
        y = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());

        if (x.area() > y.area()) {
            System.out.println("The larger area is triangle X");
        } else {
            System.out.println("The larger area is triangle Y");
        }
    }
}

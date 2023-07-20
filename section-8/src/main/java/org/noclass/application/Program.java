package org.noclass.application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        double xA, xB, xC, yA, yB, yC, pX, pY, aX, aY;
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter the measures of triangle X:");
        xA = scanner.nextDouble();
        xB = scanner.nextDouble();
        xC = scanner.nextDouble();

        System.out.println("Enter the measures of triangle Y:");
        yA = scanner.nextDouble();
        yB = scanner.nextDouble();
        yC = scanner.nextDouble();

        pX = (xA + xB + xC) / 2;
        pY = (yA + yB + yC) / 2;

        aX = Math.sqrt(pX * (pX - xA) * (pX - xB) * (pX - xC));
        aY = Math.sqrt(pY * (pY - yA) * (pY - yB) * (pY - yC));

        if (aX > aY) {
            System.out.println("The larger area is triangle X");
        } else {
            System.out.println("The larger area is triangle Y");
        }
    }
}

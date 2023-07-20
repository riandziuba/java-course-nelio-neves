package org.withclass.utils;

public class Calculator {
    public static final double PI = 3.14;

    public static double circumference(double radius) {
        return 2 * Calculator.PI * radius;
    }

    public static double volume(double radius) {
        return 4 * Calculator.PI * Math.pow(radius, 3) / 3;
    }
}

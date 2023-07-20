package org.withclass.entities;

public class Triangle {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return  (a + b + c) / 2;
    }

    public double area() {
        double perimeter = this.perimeter();

        return Math.sqrt(perimeter * (perimeter - c) * (perimeter - b) * (perimeter - c));
    }

}

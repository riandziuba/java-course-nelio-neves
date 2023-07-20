package org.withclass.application;


import org.withclass.entities.Rectangle;

import java.util.Scanner;

public class Exercise01 {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the width and height of rectangle:");
        rectangle.width = scanner.nextDouble();
        rectangle.height = scanner.nextDouble();

        System.out.println("AREA: " + rectangle.area());
        System.out.println("PERIMETER: " + rectangle.perimeter());
        System.out.println("DIAGONAL: " + rectangle.diagonal());
    }
}

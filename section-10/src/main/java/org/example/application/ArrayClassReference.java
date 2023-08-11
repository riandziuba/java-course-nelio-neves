package org.example.application;

import org.example.entities.Product;

import java.util.Scanner;

public class ArrayClassReference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Product[] vect = new Product[n];
        int sum = 0;
        for (int i = 0; i < vect.length; i++) {
            scanner.nextLine();
            String name = scanner.nextLine();
            double price = scanner.nextDouble();
            vect[i] = new Product(name, price);
            sum += vect[i].getPrice();
        }

        System.out.println("Average price: " + sum/vect.length);


    }
}

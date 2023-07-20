package org.example.application;

import org.example.entities.Product;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the product data:");
        System.out.print("Name:");
        String name = scanner.next();
        System.out.print("Price:");
        double price = scanner.nextDouble();
        System.out.print("Quantity:");
        int quantity = scanner.nextInt();

        Product product = new Product(name, price, quantity);

        System.out.println("Product data: " + product);

        System.out.print("Enter the number of products to be added in Stock:");
        product.addInStock(scanner.nextInt());
        System.out.println("Updated data: " + product);

        System.out.print("Enter the number of products to be removed from Stock:");
        product.removeFromStock(scanner.nextInt());
        System.out.println("Updated data: " + product);
    }
}

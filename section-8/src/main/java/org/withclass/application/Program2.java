package org.withclass.application;

import org.withclass.entities.Product;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the product data:");
        System.out.print("Name:");
        product.name = scanner.next();
        System.out.print("Price:");
        product.price = scanner.nextDouble();
        System.out.print("Quantity:");
        product.quantity = scanner.nextInt();

        System.out.println("Product data: " + product);

        System.out.print("Enter the number of products to be added in Stock:");
        product.addInStock(scanner.nextInt());
        System.out.println("Updated data: " + product);

        System.out.print("Enter the number of products to be removed from Stock:");
        product.removeFromStock(scanner.nextInt());
        System.out.println("Updated data: " + product);
    }
}

package org.example;

import org.example.entities.*;
import org.example.entities.enums.OrderStatus;
import org.example.entities.enums.WorkerLevel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the customer data:");
        System.out.print("Name:");
        String customerName = scanner.next();
        System.out.print("Email:");
        scanner.next();
        String customerEmail = scanner.next();
        System.out.print("Birth Date (DD/MM/YYYY):");
        String birthDay = scanner.next();
        Custumer custumer = new Custumer(customerName, customerEmail, birthDay);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = scanner.next();
        System.out.print("How many items to this order?");
        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), custumer);
        int quantity = scanner.nextInt();
        for (int i = 0; i < quantity; i++) {
            System.out.print("Product Name: ");
            String productName = scanner.next();
            System.out.print("Product price: ");
            Double productPrice = scanner.nextDouble();
            System.out.print("Product quantity: ");
            int productQuantity = scanner.nextInt();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(product, productQuantity);
            order.addItem(orderItem);
        }

        System.out.print(order.summary());
    }
}

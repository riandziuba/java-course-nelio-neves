package org.example.comparators;

import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ComparatorExternalClass {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.00));
        products.add(new Product("Notebook", 1200.00));
        products.add(new Product("Tablet", 450.00));
        products.sort(new MyComparator());

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
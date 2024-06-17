package org.example.comparators;

import org.example.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorAnonymousClass {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.00));
        products.add(new Product("Notebook", 1200.00));
        products.add(new Product("Tablet", 450.00));
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getName().toUpperCase().compareTo(product2.getName().toUpperCase());
            }
        };

        products.sort(comparator);

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
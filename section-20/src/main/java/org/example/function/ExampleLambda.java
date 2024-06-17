package org.example.function;

import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ExampleLambda {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 350.50));
        products.add(new Product("HD case", 80.90));

        List<String> names = products.stream().map(product -> product.getName().toUpperCase()).toList();

        names.forEach(System.out::println);
    }
}

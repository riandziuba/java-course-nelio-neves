package org.example.customMethods;

import org.example.entities.Product;
import org.example.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 350.50));
        products.add(new Product("HD case", 80.90));

        ProductService service = new ProductService();

        double sum = service.filteredSum(products, product -> product.getName().charAt(0)  == 'T');

        System.out.println("the sum is " + sum);
    }
}

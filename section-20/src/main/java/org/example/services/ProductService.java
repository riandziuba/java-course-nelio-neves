package org.example.services;

import org.example.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(List<Product> products, Predicate<Product> criteria) {
        double sum = 0;
        for (Product product : products) {
            if (criteria.test(product)) {
                sum += product.getValue();
            }
        }

        return sum;
    }
}

package org.example.consumer;

import org.example.entities.Product;

import java.util.function.Consumer;

public class ConsumerProduct implements Consumer<Product> {

    @Override
    public void accept(Product product) {
        product.setValue(product.getValue() * 1.1);
    }
}

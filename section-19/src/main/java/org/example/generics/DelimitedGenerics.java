package org.example.generics;

import org.example.generics.entities.Product;
import org.example.generics.services.CalculationServices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DelimitedGenerics {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        String path = "src/main/resources/dataGenerics.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Product product = new Product();
                product.setName(data[0]);
                product.setPrice(Double.parseDouble(data[1]));
                products.add(product);

                line = bufferedReader.readLine();
            }

            Product max = CalculationServices.max(products);
            System.out.println(max);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

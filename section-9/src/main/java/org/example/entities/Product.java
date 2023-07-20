package org.example.entities;

public class Product {
    private String name;
    private double price;

    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double totalValueInStock() {
        return this.quantity * this.price;
    }

    public void addInStock(int quantity) {
        this.quantity += quantity;
    }

    public void removeFromStock(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() {
        return this.name + ", $" + this.price + ", " + this.quantity + " units, Total: $" + this.totalValueInStock();
    }
}

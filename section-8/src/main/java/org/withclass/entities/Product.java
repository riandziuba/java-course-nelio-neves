package org.withclass.entities;

public class Product {
    public String name;
    public double price;
    public int quantity;

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

package org.Fawry.Ecommerce.Entities;

import java.time.LocalDate;
import java.util.Date;

public class Product {
    private String name;
    private double price;
    private LocalDate expDate = null; 
    private int quantity;
    private boolean shipping = false;
    private double weightInGrams = 0.0;

    
    public Product(String name, double price, LocalDate expDate, int quantity) {
        this.name = name;
        this.price = price;
        this.expDate = expDate;
        this.quantity = quantity;
    }

    // TV
    public Product(String name, double price, int quantity, boolean shipping, double weightInGrams) {
        this.name = name;
        this.price = price;
        this.expDate = expDate;
        this.quantity = quantity;
        this.shipping = shipping;
        this.weightInGrams = weightInGrams;
    }

    // cheese
    public Product(String name, double price, LocalDate expDate, int quantity, boolean shipping, double weightInGrams) {
        this.name = name;
        this.price = price;
        this.expDate = expDate;
        this.quantity = quantity;
        this.shipping = shipping;
        this.weightInGrams = weightInGrams;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double  getWeightInGrams() {
        return  weightInGrams;
    }

    public LocalDate getExpDate() {
        return expDate;
    }
    public int getQuantity() {
        return quantity;
    }
}

package org.Fawry.Ecommerce.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Cart {
    private HashMap<Product, Integer> products;
    private double SubTotal;
    private double  totalWeight;
    public boolean shippingRequired;
    
    public Cart() {
        this.products = new HashMap<>();
        this.SubTotal = 0.0;
        this.totalWeight = 0.0;
    }

    public  void add(Product product, int quantity) {
        // Logic to add product to the cart
        if (products.containsKey(product)) {
            int currentQuantity = (int) products.get(product);
            products.put(product, currentQuantity + quantity);
        } else {
            products.put(product, quantity);
        }
        if (product.getWeightInGrams() > 0) {
            shippingRequired = true;
        }
        SubTotal += product.getPrice() * quantity;
        totalWeight += product.getWeightInGrams() * quantity; 
    }


    public List<String> validate() {
        List<String> warnings = new ArrayList<>();
        if (SubTotal == 0.0) {
            warnings.add("Cart is empty, please add products to the cart.");
        }
        for (Product product : products.keySet()) {
            int quantityInCart = products.get(product);
            if (product.getExpDate() != null && LocalDate.now().isAfter(product.getExpDate())) {
                warnings.add("Product " + product.getName() + " is expired.");
            }
            if (product.getQuantity() <= 0) {
                warnings.add("Product " + product.getName() + " is out of stock.");
            }
            
            if (quantityInCart > product.getQuantity()) {
                warnings.add("Requested quantity for " + product.getName() + " exceeds available stock. Available: " + product.getQuantity());
            }
        }
        return warnings;
    }

    public double getSubTotal() {
        return SubTotal;
    }
    public HashMap<Product, Integer> getProducts() {
        return products;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

}

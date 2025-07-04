package org.Fawry.Ecommerce.Entities;

import org.Fawry.Ecommerce.Services.Contracts.IShippingProducts;
import org.Fawry.Ecommerce.Services.Shipping;
import org.Fawry.Ecommerce.Services.ShippingProductsImpl;


public class Customer {
    protected  Cart cart;
    protected Product product;
    private double balance;

    public Customer(double balance) {
        this.balance = balance;
        this.cart = new Cart();
    }

    public void addProductToCart(Product product, int quantity) {
        cart.add(product, quantity);
    }

    public Cart getCart() {
        return cart;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }


}

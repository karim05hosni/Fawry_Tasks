/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.Fawry.Ecommerce.Views;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import org.Fawry.Ecommerce.Entities.Cart;
import org.Fawry.Ecommerce.Entities.Customer;
import org.Fawry.Ecommerce.Entities.Product;


/**
 *
 * @author Karim
 */
public class cartView {
    protected  Customer customer;
    protected Product product;
    protected Cart cart;
    
    public cartView(Customer customer) {
        this.customer = customer;
        this.cart = customer.getCart();
    }

    public boolean validationWarnings(List<String> warnings){
        if (warnings.isEmpty()) {
            return true;
        } else {
            System.out.println("Errors:");
            for (String warning : warnings) {
                System.out.println(warning);
            }
            return false;
        }

    }

    public void displayCart(){
        System.out.println("Cart contents:");
        HashMap<Product, Integer> products = customer.getCart().getProducts();
        for (Product product : products.keySet()) {
            int quantity = products.get(product);
            // package weight
            System.out.println(quantity + " x " + product.getName() + " - Weight: " + product.getWeightInGrams()*quantity + " grams");
        }
        System.out.println("Total Weight: " + cart.getTotalWeight() + " grams");

        for (Product product : products.keySet()) {
            int quantity = products.get(product);
            // package price
            System.out.println(quantity + " x " + product.getName() + " - Price: " + product.getPrice()*quantity);
        }
        System.out.println("SubTotal : " + cart.getSubTotal());
        if (cart.shippingRequired) {
            System.out.println("Shipping: "+ 40.0);
            System.out.println("Total: " + (cart.getSubTotal() + 40.0));
        }
        else {
            System.out.println("Total: " + cart.getSubTotal());
        }
    }

    public void shippingDetails() {
        System.out.println("Shipping details:");
        for (Product item : cart.getProducts().keySet()) {
            int quantityInCart = cart.getProducts().get(item);
            System.out.println("Product: " + item.getName() + " Weight: " + item.getWeightInGrams()*quantityInCart + " grams");
        }
    }

    public void invoiceFoot(){
        System.out.println("Updated Wallet Balance: " + customer.getBalance());
        System.out.println("Thank you for your purchase!");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.Fawry.Ecommerce.Services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.Fawry.Ecommerce.Entities.Cart;
import org.Fawry.Ecommerce.Entities.Customer;
import org.Fawry.Ecommerce.Entities.Product;
import org.Fawry.Ecommerce.Services.Contracts.IShippingProducts;
import org.Fawry.Ecommerce.Views.cartView;

/**
 *
 * @author Karim
 */
public class customerServices {
    protected  Customer customer;
    protected Product product;
    protected Cart cart;
    protected cartView cartView;;
    protected Shipping shippingService;
    
    public customerServices(Customer customer) {
        this.customer = customer;
        this.cart = customer.getCart();
        this.cartView = new cartView(customer);
        if (cart.shippingRequired){
            this.shippingService = new Shipping();
        }
    }


    public  void displayCart(){
        cartView.displayCart();
    }

    public void checkout(){
        cart.validate();
        List<String> warnings = cart.validate();
        if (!cartView.validationWarnings(warnings)) {
            System.out.println("Checkout failed due to validation errors.");
            return;
        }

        if (cart.shippingRequired) {
            for (Product item : cart.getProducts().keySet()) {
                IShippingProducts Shipped = new ShippingProductsImpl(item.getName(), item.getWeightInGrams());
                shippingService.add(Shipped);
            }
            cartView.shippingDetails();
        }
        displayCart();
        double balance = customer.getBalance();
        balance -= cart.getSubTotal() + (cart.shippingRequired ? 40.0 : 0.0); // Deduct total amount from balance
        customer.setBalance(balance);
        cartView.invoiceFoot();
    }


}

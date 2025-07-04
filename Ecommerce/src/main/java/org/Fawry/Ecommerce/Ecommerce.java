package org.Fawry.Ecommerce;

import java.time.LocalDate;
import java.util.Date;
import org.Fawry.Ecommerce.Entities.Customer;
import org.Fawry.Ecommerce.Entities.Product;
import org.Fawry.Ecommerce.Services.customerServices;
/**
 *
 * @author Karim
 */
public class Ecommerce {

    public static void main(String[] args) {
        Product milk = new Product("Milk", 3.0, LocalDate.now().plusDays(5), 10, false, 1000.0);
        
        Product oldBread = new Product("Bread", 1.0, LocalDate.of(2023, 10, 1), 100, false, 500.0);
        
        Product eggs = new Product("Eggs", 2.0, LocalDate.now().plusDays(10), 1, true, 50.0);
        Product cheese = new Product("Cheese", 50.0, LocalDate.of(2025, 12, 4), 5, true, 200.0);
        Product tv = new Product("TV", 300.0, 1, true, 15000.0);
        Product laptop = new Product("Laptop", 1000.0, 2, true, 2500.0);

        Customer customer = new Customer(3000.0);
        customer.addProductToCart(milk, 3);
        customer.addProductToCart(oldBread, 1); // This should not be added due to expiration
        customer.addProductToCart(eggs, 2); // This should not be added due to insufficient stock
        customer.addProductToCart(cheese, 2);
        customer.addProductToCart(tv, 1);
        customer.addProductToCart(laptop, 1);
        
        
        // Checkout
        customerServices customerService = new customerServices(customer);
        customerService.checkout();
    }
}


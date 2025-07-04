/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.Fawry.Ecommerce.Services;

import java.util.LinkedList;
import java.util.List;
import org.Fawry.Ecommerce.Services.Contracts.IShippingProducts;

/**
 *
 * @author Karim
 */
public class Shipping {
    private List<IShippingProducts> shippedProducts;

    public Shipping() {
        shippedProducts = new LinkedList<IShippingProducts>();
    }


    public void add(IShippingProducts item){
        shippedProducts.add(item);
    }

    public List<IShippingProducts> getShippedProducts() {
        return shippedProducts;
    }
}

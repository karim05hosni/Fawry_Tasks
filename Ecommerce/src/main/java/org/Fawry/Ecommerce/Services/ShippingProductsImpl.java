package org.Fawry.Ecommerce.Services;

import org.Fawry.Ecommerce.Services.Contracts.IShippingProducts;

public class ShippingProductsImpl implements IShippingProducts {

    private String productName;
    private double productWeight;
    
    public ShippingProductsImpl(String name, double Weight) {
        this.productName = name;
        this.productWeight = Weight;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public double  getWeight() {
        return productWeight;
    }
    

}

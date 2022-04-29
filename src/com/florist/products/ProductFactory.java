package com.florist.products;

import java.io.Serializable;

public class ProductFactory implements Serializable {
    public Product getProduct(String productType){
        if(productType == null){
            return null;
        }
        if(productType.equalsIgnoreCase("Tree")){
            return new Tree();

        } else if(productType.equalsIgnoreCase("Flower")){
            return new Flower();

        } else if(productType.equalsIgnoreCase("Decoration")){
            return new Decoration();
        }

        return null;
    }
}

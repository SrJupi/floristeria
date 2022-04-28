package com.florist.products;

import java.io.Serializable;

public abstract class Product implements Serializable{
	
    
    /**
   	 * 
   	 */
   	private static final long serialVersionUID = 1L;
	protected float price;
	
        Product(float price){
			this.price=price;
		}

       public float getPrice() {
           return price;
       }

       public void setPrice(float price) {
           this.price = price;
       }


}

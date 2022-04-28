package com.florist;

import com.florist.products.Product;

import java.util.*;

public class Florist {

	private static Florist instance;
	private final String name;
	private ArrayList<Product> stock;
	//private ProductsFactory fabrica;

	private Florist(String name) {
		this.name = name;
		stock = new ArrayList<Product>();
		//fabrica = new ProductsFactory();
	}

	public String getName() {
		return name;
	}

	public static Florist getInstance(String name) { // Singleton
		if (instance == null) {
			instance = new Florist(name);
		}
		return instance;
	}

	public void getStock() {
		for (Product p : stock) {
			System.out.println(p.getClass());
		}
	}

	public void getStockValue() {
		float totalStock = 0;
		for (Product p : stock) {
			totalStock += p.getPrice();
		}
		System.out.printf("Total stock value: %.2f%n", totalStock);
	}

	/*public void addItemToStock(String productType) {
		com.florist.products.Product newProduct = fabrica.getProduct(productType);
		stock.add(newProduct);
	}*/

}

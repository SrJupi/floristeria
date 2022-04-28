package com.florist;

import com.florist.products.*;

import java.util.*;

public class Florist {

	private static Florist instance;
	private final String name;
	private ArrayList<Product> stock;
	// private ProductsFactory fabrica;

	private Florist(String name) {
		this.name = name;
		stock = new ArrayList<Product>();
		// fabrica = new ProductsFactory();
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

	public void addItemStock(Product product) {
		stock.add(product);
	}

	public void deleteItemStock(Product product) {
		stock.remove(findItemStock(product));
	}

	public int findItemStock(Product product) {
		int i = 0;
		int index = 0;
		boolean match = false;
		while (match) {
			match = stock.get(i).equals(product);
			if (match == true) {
				index = i;
			}
			i++;
		}
		return index;
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

}

package com.florist;

import com.florist.products.*;

import java.util.*;

public class Florist {

	private static Florist instance;
	private final String name;
	private ArrayList<Product> stock;
	private ProductFactory fabrica;

	private Florist(String name) {
		this.name = name;
		stock = new ArrayList<>();
		fabrica = new ProductFactory();
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

	public void addItemStock(String product) {
		stock.add(fabrica.getProduct(product));
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
		int flowers = 0;
		int trees = 0;
		int decoration = 0;
		for (Product p : stock) {
			if (p instanceof Tree) trees++;
			else if (p instanceof Decoration) decoration++;
			else if (p instanceof Flower) flowers++;
		}
		System.out.printf("Current Stock:\nDecoration items: %d\nFlowers: %d\nTrees: %d\n",
				decoration, flowers, trees);
	}

	public void getStock(String product) {
		System.out.printf("Current stock of %s:\n", product);
		for (Product p : stock) {
			if (p.getClass().getSimpleName().equalsIgnoreCase(product)) {
				if(p instanceof Flower) System.out.print(((Flower) p).getColor());
				if(p instanceof Decoration) System.out.print(((Decoration) p).getDeco());
				if(p instanceof Tree) System.out.print(((Tree) p).getHeight());
				System.out.printf(" - price: %.02f\n", p.getPrice());
			}
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

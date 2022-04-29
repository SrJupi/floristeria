package com.florist;

import com.florist.products.*;

import java.io.Serializable;
import java.util.*;

public class Florist implements Serializable{

	private static Florist instance;
	private final String name;
	private ArrayList<Product> stock;
	private ProductFactory fabrica;

	private Florist() {
		name = "Florwers'house";
		;
		stock = new ArrayList<>();
		fabrica = new ProductFactory();
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Product> getList() {
		return stock;
	}

	public static Florist getInstance() { // Singleton
		if (instance == null) {
			instance = new Florist();
		}
		return instance;
	}

	public void addItemStock(String product) {
		stock.add(fabrica.getProduct(product));
	}

	public void getStock() {
		int flowers = 0;
		int trees = 0;
		int decoration = 0;
		for (Product p : stock) {
			if (p instanceof Tree)
				trees++;
			else if (p instanceof Decoration)
				decoration++;
			else if (p instanceof Flower)
				flowers++;
		}
		System.out.printf("Current Stock:\nDecoration items: %d\nFlowers: %d\nTrees: %d\n", decoration, flowers, trees);
	}

	public void getStockValue() {
		float totalStock = 0;
		for (Product p : stock) {
			totalStock += p.getPrice();
		}
		System.out.printf("Total stock value: %.2f%n", totalStock);
	}

	public void getTotalStock() {
		for (Product p : stock) {
			if (p instanceof Flower)
				System.out.print(((Flower) p).toString());
			if (p instanceof Decoration)
				System.out.print(((Decoration) p).toString());
			if (p instanceof Tree)
				System.out.print(((Tree) p).toString());
		}
	}
	
	public List<Integer> getStock(String product) {
		ArrayList<Integer> validID = new ArrayList<>();
		System.out.printf("Current stock of %s:\n", product);
		for (int i = 0; i < stock.size(); i++){
			Product p = stock.get(i);
			if (p.getClass().getSimpleName().equalsIgnoreCase(product)) {
				if(p instanceof Flower) System.out.print("Id: " + i + " - " + ((Flower) p).getColor());
				if(p instanceof Decoration) System.out.print("Id: " + i + " - " + ((Decoration) p).getDeco());
				if(p instanceof Tree) System.out.print("Id: " + i + " - " + ((Tree) p).getHeight());
				System.out.printf(" - price: $ %.2f\n", p.getPrice());
				validID.add(i);
			}
		}
		return validID;
	}

	public void deleteItemStock(String product) {
		Scanner sc = new Scanner(System.in);
		List<Integer> infoStock = getStock(product);
		if (!infoStock.isEmpty()) {
			System.out.printf("Which %s do you want to remove? Select Id\n", product);
			int i = sc.nextInt();
			sc.nextLine();
			if (infoStock.contains(i)) {
				stock.remove(i);
				System.out.println("The product was removed succesfully.");
			} else {
				System.out.println("Invalid item ID!");
			}
		} else {
			System.out.printf("There are no items of the %s type\n", product);
		}

	}

}

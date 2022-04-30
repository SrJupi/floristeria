package com.florist.orders;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.florist.Florist;
import com.florist.products.*;

public class Ticket {

	private List<Product> products;
	private Florist florist;

	public Ticket() {
		products = new ArrayList<Product>();
		florist = Florist.getInstance();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void purchaseItem(String product) {
		Scanner sc = new Scanner(System.in);
		List<Integer> infoStock = florist.getStock(product);
		if (!infoStock.isEmpty()) {
			System.out.printf("Which %s do you want to purchase? Select Id\n", product);
			int i = sc.nextInt();
			sc.nextLine();
			if (infoStock.contains(i)) {
				products.add(florist.getList().get(i));
				florist.getList().remove(i);
				System.out.println("The product was purchased succesfully.");
			} else {
				System.out.println("Invalid item ID!");
			}
		} else {
			System.out.printf("There are no items of the %s type\n", product);
		}

	}
	
	public void getPurchase() {
		for (Product p : products) {
			if (p instanceof Flower)
				System.out.print(((Flower) p).toString());
			if (p instanceof Decoration)
				System.out.print(((Decoration) p).toString());
			if (p instanceof Tree)
				System.out.print(((Tree) p).toString());
		}
	}
	
	public float getPurchaseValue() {
		float totalPurchase = 0;
		for (Product p : products) {
			totalPurchase += p.getPrice();
		}
		return totalPurchase;
		//System.out.printf("Total stock value: %.2f%n", totalPurchase);
	}
	
	
	
	
	
	
	

}

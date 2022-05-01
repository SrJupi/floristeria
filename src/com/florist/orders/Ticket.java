package com.florist.orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.florist.Florist;
import com.florist.products.*;

public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
				florist.setStockValue(-(florist.getList().get(i).getPrice()));
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
		int i = 0;
		for (Product p : products) {
			System.out.printf("%02d - %s\n", ++i, p);
		}
		System.out.printf("Final Price: %.02f€\n", getPurchaseValue());
	}

	public float getPurchaseValue() {
		float totalPurchase = 0;
		for (Product p : products) {
			totalPurchase += p.getPrice();
		}
		return totalPurchase;
	}

}

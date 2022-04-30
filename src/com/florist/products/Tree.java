package com.florist.products;

import java.util.Scanner;

public class Tree extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float height;

	public Tree() {
		this.height = setInitialHeight();
		this.price = setInitialPrice();
		System.out.println("The tree has been added successfully.");
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	public String toString() {
		return "\nTree:" + height + ", " + price + "€.\n";
	}

	@Override
	public float setInitialPrice() {
		return Math.round((23.33f * height * height + 12.5f) * 100.0f) / 100.0f;
	}

	private float setInitialHeight() {
		Scanner sc = new Scanner(System.in);
		float info = 0;
		while (info < 0.5 || info > 5) {
			System.out.println("Which size of tree do you want to buy? We have trees from 0.5m to 5m.");
			try {
				info = Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Use only numbers!");
			}
		}
		return info;
	}
}

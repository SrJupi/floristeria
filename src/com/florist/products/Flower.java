package com.florist.products;

import java.util.Scanner;

public class Flower extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;

	public Flower() {
		this.color = setInitialColor();
		this.price = setInitialPrice();
		System.out.println("The flower has been added successfully.");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "\nFlower:" + color + ", " + price + "€.\n";
	}

	@Override
	public float setInitialPrice() {
		float value = 0;
		for (int i = 0; i < color.length(); i++) {
			value += color.charAt(i);
		}
		while (value > 5) {
			value /= 10f;
		}
		return value;
	}

	private String setInitialColor() {
		Scanner sc = new Scanner(System.in);
		String info = "";
		while (!info.contains("1") && !info.contains("2") && !info.contains("3") && !info.contains("4")
				&& !info.contains("5")) {
			System.out.println("Which color of flower do you want to buy?\n1 = Pink\n2 = Purple\n"
					+ "3 = Red\n4 = White\n5 = Yellow");
			info = sc.nextLine();
		}
		if (info.contains("1")) {
			return "Pink";
		}
		if (info.contains("2")) {
			return "Purple";
		}
		if (info.contains("3")) {
			return "Red";
		}
		if (info.contains("4")) {
			return "Yellow";
		} else {
			return "White";
		}
	}
}

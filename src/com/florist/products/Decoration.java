package com.florist.products;

import java.util.Scanner;

public class Decoration extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public enum Material {
		PLASTIC, WOOD
	}
	private Material deco;

	Decoration() {
		this.deco = setInitialDeco();
		this.price = setInitialPrice();
	}

	public Material getDeco() {
		return deco;
	}

	public void setDeco(Material deco) {
		this.deco = deco;
	}

	@Override
	public float setInitialPrice() {
		if (deco == Material.PLASTIC){
			return 2.15f;
		}
		else if (deco == Material.WOOD) {
			return 1.80f;
		}
		return 0;
	}

	private Material setInitialDeco() {
		Scanner sc = new Scanner(System.in);
		String info = "";
		while (!info.contains("1") && !info.contains("2")){
			System.out.println("Which kind of decoration do you want to buy?\n1 = Plastic\n2 = Wood");
			info = sc.nextLine();
		}
		if (info.contains("1")){
			return Material.PLASTIC;
		}
		else{
			return Material.WOOD;
		}
	}

}

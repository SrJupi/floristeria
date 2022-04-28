package com.florist.products;

public class Tree extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float height;

	public Tree(float height, float price) {
		super(price);
		this.height = height;

	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}

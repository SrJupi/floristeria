package com.florist;

import com.florist.orders.Order;
import com.florist.products.*;

import java.io.Serializable;
import java.util.*;

public class Florist implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Florist instance;
	private final String name;
	private ArrayList<Product> stock;
	private ProductFactory fabrica;
	private float stockValue;
	private Order order;

	private Florist(String name) {
		this.name = name;
		stock = new ArrayList<>();
		stockValue = 0;
		fabrica = new ProductFactory();
		order = Order.getInstance();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Product> getList() {
		return stock;
	}
	
	public Order getOrder() {
		return order;
	}

	public static Florist getInstance() { // Singleton
		if (instance == null) {
			instance = new Florist("Flowers' house");
		}
		return instance;
	}

	public void loadedFlorist(){
		instance = this;
	}

	public void addItemStock(String product) {
		Product tmpProduct = fabrica.getProduct(product);
		if (tmpProduct != null){
			stockValue += tmpProduct.getPrice();
			stock.add(tmpProduct);
		}
	}



	public void deleteItemStock(String product) {
		Scanner sc = new Scanner(System.in);
		List<Integer> infoStock = getStock(product);
		if (!infoStock.isEmpty()) {
			System.out.printf("Which %s do you want to remove? Select Id\n", product);
			try{
				int i = sc.nextInt();
				sc.nextLine();
				if (infoStock.contains(i)) {
					stockValue -= stock.get(i).getPrice();
					stock.remove(i);
				} else {
					System.out.println("Invalid item ID!");
				}
			}
			catch (Exception e){
				System.out.println("Please insert a number!");
			}
		} else {
			System.out.printf("There are no items of the %s type\n", product);
		}
	}

	public int getStockSize(){
		return stock.size();
	}

	//print stock quantities for each category
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


	//Print all itens in a category with its atributes.
	public List<Integer> getStock(String product) {
		ArrayList<Integer> validID = new ArrayList<>();
		System.out.printf("Current stock of %s:\n", product);
		for (int i = 0; i < stock.size(); i++) {
			Product p = stock.get(i);
			if (p.getClass().getSimpleName().equalsIgnoreCase(product)) {
				System.out.printf("Id: %d - %s\n", i, p);
				validID.add(i);
			}
		}
		return validID;
	}

	//return value of stock
	public float getStockValue() {
		return stockValue;
	}

	public void setStockValue(float value){
		stockValue += value;
	}

	//calculate and return the value of a category stock
	public float getStockValue(String product) {
		float productStock = 0;
		for (Product p : stock)
			if (p.getClass().getSimpleName().equalsIgnoreCase(product))
				productStock += p.getPrice();
		return productStock;
	}

	public void getTotalStock() {
		for (Product p : stock) {
			System.out.println(p);
		}
	}
}

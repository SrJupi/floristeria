import java.util.*;

public class Florist {

	private static Florist instance;
	private final String name;
	private ArrayList<Product> stock;
	//private ProductsFactory fabrica;

	private Florist() {
		name = "Floristeria";
		stock = new ArrayList<Product>();
		//fabrica = new ProductsFactory();
	}

	public String getName() {
		return name;
	}

	public static Florist getInstance() { // Singleton
		if (instance == null) {
			instance = new Florist();
		}
		return instance;
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

	/*public void addItemToStock(String productType) {
		Product newProduct = fabrica.getProduct(productType);
		stock.add(newProduct);
	}*/

}

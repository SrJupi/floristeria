import java.util.ArrayList;
import java.util.List;

import com.florist.products.*;

public class Ticket {

	private List<Product> products;

	Ticket() {
		products = new ArrayList<Product>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addItem(Product product) {
		products.add(product);
	}

	public void deleteItem(Product product) {
		products.remove(findItem(product));
	}

	public int findItem(Product product) {
		int i = 0;
		int index = 0;
		boolean match = false;
		while (match) {
			match = products.get(i).equals(product);
			if (match == true) {
				index = i;
			}
			i++;
		}
		return index;
	}

}

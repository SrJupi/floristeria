import com.florist.Florist;

public class App_Mock {

	public static void main(String[] args) {

		Florist florist = Florist.getInstance("Casa de las flores");
		florist.getStock();
		florist.addItemStock("Tree");
		florist.addItemStock("Tree");
		florist.addItemStock("Tree");
		florist.addItemStock("Flower");
		florist.addItemStock("Flower");
		florist.addItemStock("Decoration");
		florist.addItemStock("Decoration");
		System.out.println(florist.getName());
		florist.getStock();
		florist.getStockValue();
		florist.getStock("flower");
		florist.getStock("tree");
		florist.getStock("decoration");





	}

}

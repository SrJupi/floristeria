import com.florist.Florist;

public class App_Mock {

	public static void main(String[] args) {

		Florist florist = Florist.getInstance("Casa de las flores");
		florist.getStock();
		florist.addItemStock("Tree");
		florist.addItemStock("Tree");
		florist.addItemStock("Tree");
		florist.addItemStock("Decoration");
		florist.addItemStock("Decoration");
		florist.getStock();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n\n~~~~~~~~~~~~~~~~~~~\n\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n\n~~~~~~~~~~~~~~~~~~~\n\n");

		florist.deleteItemStock("flower");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n\n~~~~~~~~~~~~~~~~~~~\n\n");

		florist.getStock();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n\n~~~~~~~~~~~~~~~~~~~\n\n");
	}

}

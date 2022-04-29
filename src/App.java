import java.util.Scanner;

import com.florist.Florist;
import com.florist.orders.Order;
import com.florist.orders.Ticket;
import com.florist.products.Product;
import com.florist.save_load.SaveLoad;

public class App {

	public static void main(String[] args) {
		menu();

	}

	static void menu() {
		int option;
		do {
			option = askNum(
					"Choose an option: \n1: Create flower shop. \n2: Add items. \n3: Check information about your stock. \n4: Delete items.\n5: Orders \n0: Exit");
			switch (option) {

			case 1:
				Florist f = Florist.getInstance();
				System.out.println("The flower shop has been created successfully.");
				SaveLoad.saveFlorist(f);
				break;

			case 2:
				f = Florist.getInstance();
				f.addItemStock(askWord("What item do you want to add? (Tree/Flower/Decoration)"));
				SaveLoad.saveFlorist(f);
				break;

			case 3:
				int option1;
				do {
					option1 = askNum(
							"Choose an option: \n1: Show all products in stock. \n2: Show quantities of each product. \n3: Show total value \n0: Return to main menu");
					switch (option1) {
					case 1:
						f = Florist.getInstance();
						f.getTotalStock();
						break;
					case 2:
						f = Florist.getInstance();
						f.getStock();
						break;
					case 3:
						f = Florist.getInstance();
						f.getStockValue();
						break;
					case 0:
						System.out.println("Return");
						break;
					default:
						System.out.println("The chosen option isn't correct");
					}
				} while (option1 != 0 || option1 < 0 && option1 > 3);
				break;

			case 4:
				f = Florist.getInstance();
				f.deleteItemStock(askWord("What kind of product do you want to remove?"));
				SaveLoad.saveFlorist(f);
				break;
			case 5:
				do {
					option1 = askNum(
							"Choose an option: \n1: Create a ticket. \n2: Show history of orders. \n3: Show total order's value \n0: Return to main menu");
					switch (option1) {
					case 1:
						Order o= Order.getInstance();
						Ticket t=new Ticket();
						int times=askNum("How many items do you want to purchase?");
						for (int i=1;i<=times;i++) {
							t.purchaseItem(askWord("What kind of product do you want to purchase?"));
						}						
						o.addTicket(t);
						System.out.println("The ticket was created successfully.");
						break;
					case 2:
						o= Order.getInstance();
						o.history();
						break;
					case 3:
						o= Order.getInstance();
						o.moneyRaising();						
						break;
					default:
						System.out.println("The chosen option isn't correct");
					}
				} while (option1 != 0 || option1 < 0 && option1 > 3);
				break;

			case 0:
				System.out.println("Bye!");
				break;

			default:
				System.out.println("The chosen option isn't correct");
			}
		} while (option != 0 || option < 0 && option > 5);
	}

	static String askWord(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		String dato = sc.nextLine();
		return dato;
	}

	static int askNum(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		int dato = sc.nextInt();
		sc.nextLine();
		return dato;
	}

}

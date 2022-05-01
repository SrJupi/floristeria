import java.util.Scanner;

import com.florist.Florist;
import com.florist.orders.Order;
import com.florist.orders.Ticket;
import com.florist.save_load.SaveLoad;

import static com.florist.save_load.SaveLoad.searchFlorist;

public class App {

	public static void main(String[] args) {
		Florist f = startProgram();
		if (f != null) {
			menu(f);
		}
	}

	private static Florist startProgram() {
		System.out.println("Welcome to Flower App 2.0!\nPlease wait while we check you system...");
		Florist tmp = searchFlorist();
		if (tmp == null) {
			int option = askNum(
					"It was not found any backup file for a florist. Do you want to create a new one?\n1 - Yes\n2 - No");
			if (option == 1) {
				tmp = Florist.getInstance();
			} else {
				System.out.println("Sorry that we could not help you this time! See you soon!");
			}
		}
		return tmp;
	}

	static void menu(Florist f) {
		int option;
		do {
			option = askNum(
					"Choose an option: \n1: Add items. \n2: Check information about your stock. \n3: Delete items.\n4: Orders. \n0: Exit.");
			switch (option) {

			case 1:
				f.addItemStock(askWord("What item do you want to add? (Tree/Flower/Decoration)"));
				SaveLoad.saveFlorist(f);
				break;

			case 2:
				int option1;
				do {
					option1 = askNum(
							"Choose an option: \n1: Show all products in stock. \n2: Show quantities of each product. \n3: Show total value \n0: Return to main menu");
					switch (option1) {
					case 1:
						f.getTotalStock();
						break;
					case 2:
						f.getStock();
						break;
					case 3:
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

			case 3:
				f.deleteItemStock(askWord("What kind of product do you want to remove?"));
				SaveLoad.saveFlorist(f);
				break;
			case 4:
				do {
					Order o = f.getOrder();
					option1 = askNum(
							"Choose an option: \n1: Create a ticket. \n2: Show history of orders. \n3: Show total order's value \n0: Return to main menu");
					switch (option1) {
					case 1:
						Ticket t = new Ticket();
						int times = askNum("How many items do you want to purchase?");
						for (int i = 1; i <= times; i++) {
							t.purchaseItem(askWord("What kind of product do you want to purchase?"));
						}
						o.addTicket(t);
						SaveLoad.saveFlorist(f);
						System.out.println("The ticket was created successfully.");
						break;
					case 2:
						o.history();
						break;
					case 3:
						o.moneyRaising();
						break;
					case 0:
						System.out.println("Return");
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
		int dato = 5;
		try {
			dato = sc.nextInt();
			sc.nextLine();
			return dato;
		} catch (Exception e) {
			System.err.println("Please enter a number.");
			return dato;
		}

	}

}

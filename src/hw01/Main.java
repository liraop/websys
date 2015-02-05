package hw01;

import java.util.Scanner;

/**
 * Class to handle I/O.
 * The user can add, remove and list items in a inventory.
 * User inputs are sanitized. 
 * @author Pedro de Oliveira Lira - pdeolive@syr.edu
 *
 */
public class Main {

	private static Inventory inv;
	private static Scanner is;
	
	public static void main(String[] args) {
		initialize();
		menu();
	}
	
	private static void initialize(){
		inv = new Inventory();
		is = new Scanner(System.in);
	}
	
	private static void menu(){
		System.out.println("Hi! Input (1) to add items (2) to remove items (3) to show the inventory (0) to exit");
		
		int d = 0;
		
		d = testInput(is, "menu");
	
		switch (d){
		case 0: System.exit(0);
		case 1: addItemsMenu();
				break;
		case 2: removeItemsMenu();
				break;
		case 3: showInventory();
				break;
		default : System.out.println("Invalid Input. Please select a valid one.\n");
					menu();
		}
		
	}
	
	private static void removeItemsMenu() {
		System.out.println("Remove items menu.\n Input (1) to remove one item (2) to clean the inventory (0) to go back");
	
		int d = 0;
		
		d = testInput(is,"rim");

		switch (d){
		case 0: menu();
				break;
		case 1: removeItem();
				break;
		case 2: cleanInv();
				break;
		default : System.out.println("Invalid Input. Please select a valid one.\n");
					addItemsMenu();
		}
		
	}

	private static void cleanInv() {
		inv.cleanInv();
		System.out.println("\nINVENTORY IS NOW EMPTY!!!\n");
		menu();
	}

	private static void removeItem() {
		int id = 0;
		System.out.println("\nInsert the item ID to be removed:\n");
		id = testInput(is,"rim");
		
		try {
			inv.remove(id);
			System.out.println("\n ITEM SUCCESSFULLY REMOVED!!!\n");
		} catch (Exception e){
			System.out.println("\n ITEM NOT SUCCESSFULLY REMOVED!!!\nWrong ID or item already out of inventory.\n");
		}
		
		removeItemsMenu();
			
	}

	private static void showInventory(){
		System.out.println(inv.toString());
		menu();
	}
	
	private static void addItemsMenu(){
		System.out.println("Add items menu.\n Input (1) to add one item (0) to go back");
		
		int d = 0;
		
		d = testInput(is,"adim");
	
		switch (d){
		case 0: menu();
				break;
		case 1: addItemQ(d);
				break;
		default : System.out.println("Invalid Input. Please select a valid one.\n");
				addItemsMenu();
		}
	}

	private static void addItemQ(int opt) {
		System.out.println("Item ID:\n");
		int id = is.nextInt();
		
		if (inv.containsItem(id)){
			System.out.println("\nItem already on inventory!!!");
			addItemsMenu();
		}
		
		System.out.println("Name of the item:\n");
		String name = is.next();
		System.out.println("Description of the item:\n");
		String desc = is.next();
		System.out.println("Weight of the item:\n");
		float wgt = testWeight(is,"adim");

		
		try{
			inv.add(new Item(id,name,desc,wgt));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nITEM SUCCESSFULLY ADDED!!!\n");
		addItemsMenu();
	}

	private static int testInput(Scanner is, String method){
		int in = 0;
		
		if (is.hasNextInt()){
			in = is.nextInt();	
		} else {
			System.out.println("\nPlease: USE INTEGERS!!!!!!\n");
			is.next();
			
			switch (method){
			case "menu": menu(); break;
			case "adim": addItemsMenu(); break;
			case "rim": removeItemsMenu(); break;
			}
		}
		return in;
	}
	
	private static float testWeight(Scanner is, String method){
		float in = 0;
		
		if (is.hasNextFloat()){
			in = is.nextFloat();	
		} else {
			System.out.println("\nPlease: USE FLOAT FOR WEIGHT!!!!!!\n");
			is.next();
			
			switch (method){
			case "menu": menu(); break;
			case "adim": addItemsMenu(); break;
			case "rim": removeItemsMenu(); break;
			}
		}
		return in;
	}
}

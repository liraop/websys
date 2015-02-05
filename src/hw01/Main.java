package hw01;

import java.util.Scanner;

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
		System.out.println("Remove items menu.\n Input (1) to remove one item (2) to remove all the same items\n(4) to clean the inventory (0) to go back");
	
		int d = 0;
		
		d = testInput(is,"rim");

		switch (d){
		case 0: menu();
				break;
		case 1: removeItem();
				break;
		case 2: removeItemQ();
				break;
		default : System.out.println("Invalid Input. Please select a valid one.\n");
					addItemsMenu();
		}
		
	}

	private static void removeItemQ() {
		// TODO Auto-generated method stub
		
	}

	private static void removeItem() {
		// TODO Auto-generated method stub
		
	}

	private static void showInventory(){
		System.out.println(inv.toString());
		menu();
	}
	
	private static void addItemsMenu(){
		System.out.println("Add items menu.\n Input (1) to add one item (2) to add a item with quantity (0) to go back");
		
		int d = 0;
		
		d = testInput(is,"adim");
	
		switch (d){
		case 0: menu();
				break;
		case 1: addItemQ(d);
				break;
		case 2: addItemQ(d);
				break;
		default : System.out.println("Invalid Input. Please select a valid one.\n");
				addItemsMenu();
		}
	}

	private static void addItemQ(int opt) {
		int q = 1;
		System.out.println("Name of the item:\n");
		String name = is.next();
		System.out.println("Description of the item:\n");
		String desc = is.next();
		if (opt == 2){
			System.out.println("Quantity:");
			q = is.nextInt();
		} 

		try{
			inv.add(new Item(name,desc), q);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n ITEM SUCCESSFULLY ADDED!!!\n");
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
}

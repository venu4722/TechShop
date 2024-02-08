package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.InventoryController;

public class InventoryView {
	InventoryController ic = new InventoryController();
	Scanner scan = new Scanner(System.in);

	/**
	 * Displays the main menu for inventory-related operations and processes user
	 * input.
	 */
	public void displayMenu() {
		
		String string = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. View Product in inventory");
		    System.out.println("2. View Product Quantity in Stock");
		    System.out.println("3. Add Quantity of Product");
		    System.out.println("4. Remove Quantity of Product");
		    System.out.println("5. Update Quantity");
		    System.out.println("6. Check Product Availability");
		    System.out.println("7. View Total Inventory Value");
		    System.out.println("8. View List Low Stock Products");
		    System.out.println("9. View Out of Stock Products");
		    System.out.println("10. View List of All Products");


		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
		            ic.getProduct();
		            break;
		        }
		        case 2:{
		        	ic.getStockQuantity();
		        	break;
		        }
		        case 3:{
		        	ic.addToInventory();
		        	break;
		        }
		        case 4:{
		        	ic.removeFromInventory();
		        	break;
		        }
		        case 5:{
		        	ic.updateStockQuantity();
		        	break;
		        }
		        case 6:{
		        	ic.isProductAvailable();
		        	break;
		        }
		        case 7:{
		        	ic.getInventoryValue();
		        	break;
		        }
		        case 8:{
		        	ic.listLowStockProducts();
		        	break;
		        }
		        case 9:{
		        	ic.listOutOfStockProducts();
		        	break;
		        }
		        case 10:{
		        	ic.listAllProducts();
		        	break;
		        }
		        default: {
		            System.out.println("Choose a proper choice");
		            break;
		        }
		    }
		    
		    System.out.println("Do you want to continue Type -y");
		    string = scan.next();

		} while (string.equalsIgnoreCase("y"));
	}
}

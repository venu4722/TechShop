package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.OrdersController;

public class OrderView {
	Scanner scan = new Scanner(System.in);
	OrdersController oc = new OrdersController();
	
	/**
	 * Displays the menu for managing orders and handles user interactions. The user
	 * can choose options such as calculating total amounts, viewing order details,
	 * updating order status, and canceling orders.
	 */
	public void displayMenu() {
		String string = null;
		
		do {
		    System.out.println("Enter your choice");
			System.out.println("1. Calculate Total Amount For an Order");
			System.out.println("2. View Order Details");
			System.out.println("3. Update Order Status");
			System.out.println("4. Cancel an Order");
		    
		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
					oc.calculateTotalAmount();
		            break;
		        }
		        case 2: {
					oc.getOrderDetails();
		            break;
		        }
		        case 3: {
					oc.updateOrderStatus();
		        	break;
		        }
				case 4: {
					oc.cancelOrder();
					break;
				}
		        default: {
		            System.out.println("Invalid Choice..");
		            break;
		        }
		    }
		    
		    System.out.println("Do you want to continue Type -y");
		    string = scan.next();

		} while (string.equalsIgnoreCase("y"));
	}
}

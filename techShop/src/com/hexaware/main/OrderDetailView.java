package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.OrderDetailController;

public class OrderDetailView {
	Scanner scan = new Scanner(System.in);
	OrderDetailController orderDetails = new OrderDetailController();

	/**
	 * Displays the menu for managing order details and handles user interactions.
	 * The user can choose options such as viewing order detail information,
	 * calculating subtotals, updating product quantities, and adding discounts.
	 */
	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. View Order Detail Info");
		    System.out.println("2. Calculate Order Detail Subtotal");
		    System.out.println("3. Update product quantity");
		    System.out.println("4. Add Discount");
		    
		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
		            orderDetails.getOrderDetailInfo();
		            break;
		        }
		        case 2: {
		            orderDetails.calculateSubTotal();
		            break;
		        }
		        case 3: {
		            orderDetails.updateQuantity();
		            break;
		        }
		        case 4: {
		            orderDetails.addDiscount();
		            break;
		        }
		        default: {
		            System.out.println("Invalid Choice.");
		            break;
		        }
		    }
		    
		    System.out.println("Do you want to continue Type -Y");
		    ch = scan.next();

		} while (ch.equalsIgnoreCase("y"));
	}
}

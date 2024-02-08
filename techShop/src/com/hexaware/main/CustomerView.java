package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.CustomersController;

public class CustomerView {
	Scanner scan = new Scanner(System.in);
	CustomersController cc = new CustomersController();

	/**
	 * Displays the main menu for customer-related operations and processes user
	 * input.
	 */
	public void displayMenu() {
		String string = null;
		
		do {
			System.out.println("1. Register");
			System.out.println("2. View Specific Customer Details");
			System.out.println("3. Update Customer");
			System.out.println("4. View All Customers");
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				cc.registerCustomer();
				break;
			case 2:
				cc.getCustomerDetails();
				break;
			case 3:
				cc.updateCustomer();
				break;
			case 4:
				cc.getCustomerList();
				break;
			default:
				System.out.println("Invalid Choice.");
				break;
			}
			System.out.println("Do you Want to continue Type-y");
			string = scan.next();

		} while (string.equalsIgnoreCase("y"));
	}
}

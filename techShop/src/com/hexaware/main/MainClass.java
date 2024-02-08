package com.hexaware.main;

import java.util.Scanner;
import com.hexaware.exception.InsufficientStockException;
import com.hexaware.exception.InvalidDataException;

public class MainClass {
	public static void main(String[] args) throws InvalidDataException, InsufficientStockException {
		CustomerView cv = new CustomerView();
		ProductView pv = new ProductView();
		OrderView ov = new OrderView();
		OrderDetailView odv = new OrderDetailView();
		InventoryView iv = new InventoryView();
		
		Scanner scan=new Scanner(System.in);

		System.out.println(" ********** TECHSHOP (AN ELECTRONIC GADGET PLATFORM) **********");
		
		String string = null;
		do {
			System.out.println("1. Customr's Page");
			System.out.println("2. Product's Page");
			System.out.println("3. Order's Page");
			System.out.println("4. Order Details Page");
			System.out.println("5. Inventory Page");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				cv.displayMenu();
				break;
			}
			case 2: {
				pv.displayMenu();
				break;
			}
			case 3: {
				ov.displayMenu();
				break;
			}
			case 4: {
				odv.displayMenu();
				break;
			}
			case 5: {
				iv.displayMenu();
				break;
			}
			default: {
				System.out.println("Choose a proper choice");
				break;
			}
			}
			System.out.println("Do you want to continue techshop Page Type-y");
			string = scan.next();
			
		} while (string.equalsIgnoreCase("y"));
		

		System.out.println("**************** THANKS FOR USING (COME AGAIN) ***************");

		scan.close();
	}
}

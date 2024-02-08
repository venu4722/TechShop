package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.ProductsController;

public class ProductView {
	Scanner scan = new Scanner(System.in);
	ProductsController product = new ProductsController();
	
	/**
	 * Displays the menu for managing products and handles user interactions. The
	 * user can choose options such as adding products, viewing product details,
	 * updating product information, checking product availability, and viewing the
	 * list of all products.
	 */
	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. Add Product");
		    System.out.println("2. View Product Details");
		    System.out.println("3. Update Product");
		    System.out.println("4. Is Product in Stock");
			System.out.println("5. View All Products");
		    int choice = scan.nextInt();
		    
		    switch (choice) {
			case 1:
		            product.addProduct(); 
		            break;
				case 2:
		            product.getProductDetails();
		            break;
				case 3:
		            product.updateProductInfo();
		            break;
				case 4:
		            product.isProductInStock();
		            break;
				case 5:
					product.getAllProducts();
					break;
		        default: {
		            System.out.println("Choose a proper choice");
		            break;
		        }
		    }
		    
		    System.out.println("Do you want to continue Type-y");
		    ch = scan.next();

		} while (ch.equalsIgnoreCase("y"));
	}
}

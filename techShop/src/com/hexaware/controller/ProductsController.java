package com.hexaware.controller;


import java.util.Scanner;

import com.hexaware.dao.serviceImpl.ProductServiceImpl;


import com.hexaware.model.Products;

public class ProductsController {
	Scanner scanner = new Scanner(System.in);
	Products products;
	ProductServiceImpl dao = new ProductServiceImpl();
	
	public void addProduct() {
		System.out.print("Enter Product ID: ");
		int productId = scanner.nextInt();

		System.out.print("Enter Product Name: ");
		String productName = scanner.next();

		scanner.nextLine(); // To avoid breaking input due to /n character

		System.out.print("Enter Description: ");
		String description = scanner.nextLine();

		System.out.print("Enter Price: ");
		float price = scanner.nextFloat();

		Products product = new Products(productId, productName, description, price);
		dao.insertProduct(product);

	}

	public void getProductDetails() {
		System.out.print("Enter Product ID ");
		int productID = scanner.nextInt();
		dao.showProductDetails(productID);
	
	}

	public void updateProductInfo() {
		Products product = new Products();
		
		System.out.print("Enter Product ID ");
		int productId = scanner.nextInt();
		product.setProductID(productId);
		
		scanner.nextLine();
		
		System.out.print("Enter Description ");
		String description = scanner.nextLine().trim();
		if (!description.isEmpty()) {
			product.setDescription(description);
		}
		
		System.out.print("Enter Price ");
		dao.updateProduct(product);
	}
	
	public void isProductInStock() {
		System.out.print("Enter Product ID ");
		int productID = scanner.nextInt();

		boolean stockCheck = dao.isProductInStock(productID);

		if (stockCheck) {
			System.out.println("The Product " + productID + " is available in Stock!");
		} else {
			System.out.println("The Product " + productID + " is not available in Stock!");
		}

	}
	
	

	public void getProductByName() {
		System.out.println("Enter the productName:");
		String productName = scanner.next();
		dao.getProductByName(productName);
	}
	
	public void getAllProducts() {
		dao.getAllProducts();
	}

}

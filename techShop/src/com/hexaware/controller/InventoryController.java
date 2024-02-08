package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.serviceImpl.InventoryServiceImpl;

public class InventoryController {
	Scanner scan = new Scanner(System.in);
	InventoryServiceImpl inventoryDao=new InventoryServiceImpl();
	
	public void getProduct() {
		System.out.println("Enter Inventory ID ");
		int inventoryId = scan.nextInt();
		
		inventoryDao.showProduct(inventoryId);
	}
	
	public void getStockQuantity() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		inventoryDao.showStockQuantity(productId);

	}
	
	public void addToInventory() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		System.out.println("Enter quantity ");
		int quantity = scan.nextInt();
				
		inventoryDao.updateAddQuantity(productId, quantity);
	}
	
	public void removeFromInventory() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		
		System.out.println("Enter quantity ");
		int quantity = scan.nextInt();		
		
		inventoryDao.updateRemoveQuantity(productId, quantity);
	}
	
	public void updateStockQuantity() {
		System.out.println("Enter Inventory ID ");
		int inventoryId = scan.nextInt();
		
		System.out.println("Enter quantity ");
		int quantity = scan.nextInt();
		
		inventoryDao.updateStockQuantity(inventoryId, quantity);
	}
	
	public void isProductAvailable() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		System.out.println("Enter quantity to check ");
		int quantity = scan.nextInt();	
		
		int availableQuantity = inventoryDao.showAvailableQuantity(productId);
		
		if( availableQuantity >= quantity) {
			System.out.println("Product is available!");
		}else {
			System.out.println("Selected quantity is not available!");
		}
		
	}
	
	public void getInventoryValue() {
		int totalValue = inventoryDao.showInventoryValue();
		System.out.println("Total Inventory Value: Rs. "+totalValue);
	}
	
	public void listLowStockProducts() {
		System.out.println("Enter low quantity threshold ");
		int threshold = scan.nextInt();
		inventoryDao.showLowStockProducts(threshold);

	}
	
	public void listOutOfStockProducts() {
		inventoryDao.showOutOfStockProdcuts();

	}
	
	public void listAllProducts() {
		inventoryDao.showAllProducts();
	}
	
}

package com.hexaware.dao;

public interface IInventoryService {
	void showProduct(int inventoryId);
	void showStockQuantity(int productId);
	void updateAddQuantity(int productId,int quantity);
	void updateRemoveQuantity(int productId,int quantity);
	void updateStockQuantity(int inventoryId,int quantity);
	int showAvailableQuantity(int productId);
	int showInventoryValue();
	void showLowStockProducts(int threshold);
	void showOutOfStockProdcuts();
	void showAllProducts();
}

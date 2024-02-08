package com.hexaware.dao;

import com.hexaware.model.Products;

public interface IProductsService {
	void updateProduct(Products products);
	void getProductByName(String productName);
	boolean isProductInStock(int productId);
}

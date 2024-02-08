package com.hexaware.model;

import java.util.Date;

public class Inventory {
	private int inventoryID;
	private Products product;
	private int quantityInStock;
	private Date lastStockUpDate;
	
	public Inventory() {
		super();
	}

	public Inventory(int inventoryID, Products product, int quantityInStock, Date lastStockUpDate) {
		super();
		this.inventoryID = inventoryID;
		this.product = product;
		this.quantityInStock = quantityInStock;
		this.lastStockUpDate = lastStockUpDate;
	}

	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Date getLastStockUpDate() {
		return lastStockUpDate;
	}

	public void setLastStockUpDate(Date lastStockUpDate) {
		this.lastStockUpDate = lastStockUpDate;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", product=" + product + ", quantityInStock=" + quantityInStock
				+ ", lastStockUpDate=" + lastStockUpDate + "]";
	}
	
}

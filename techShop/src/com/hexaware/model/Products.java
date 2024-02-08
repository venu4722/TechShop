package com.hexaware.model;

public class Products {
	private int productID;
	private String productName;
	private String description;
	private float price;
	
	public Products() {
		super();
	}
	
	public Products(int productID, String productName, String description, float price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
	
	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", inStock=" + "]";
	}

	 
}

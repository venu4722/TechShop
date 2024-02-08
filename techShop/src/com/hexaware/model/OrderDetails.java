package com.hexaware.model;

public class OrderDetails {
	private int orderDetailID;
	private Orders order;
	private Products product;
	private int quantity;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int orderDetailID, Orders order, Products product, int quantity) {
		super();
		this.orderDetailID = orderDetailID;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailID=" + orderDetailID + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
	
}

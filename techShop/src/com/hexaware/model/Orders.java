package com.hexaware.model;

import java.util.Date;

public class Orders{
	private int OrderID;
	private Customers customer;
	private Date orderDate;
	private float totalAmount;
	private String status;
	
	
	public Orders() {
		super();
	}
	public Orders(int orderID, Customers customer, Date orderDate, float totalAmount,String status) {
		super();
		OrderID = orderID;
		this.customer = customer;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status=status;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Orders [OrderID=" + OrderID + ", customer=" + customer + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", status=" + status + "]";
	}
}

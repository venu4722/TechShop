package com.hexaware.dao;


public interface IOrderService {
	String trackStatus(int orderID);
	void calculateTotalAmount(int orderId);
}

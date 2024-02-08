package com.hexaware.dao;

import com.hexaware.model.Customers;

public interface ICustomerService {
	void registerCustomer(Customers customers);
	void showCustomerDetails(int customerid);
	void showCustomer();
	void updateCustomer(Customers customers);
	void calculateTotalOrders(int customerId);
	
}

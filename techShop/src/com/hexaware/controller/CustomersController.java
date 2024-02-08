package com.hexaware.controller;

import com.hexaware.dao.serviceImpl.CustomerServiceImpl;
import com.hexaware.model.Customers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomersController {
	Scanner scanner = new Scanner(System.in);
	List<Customers> customersList = new ArrayList<Customers>();
	Customers customers;
	CustomerServiceImpl dao = new CustomerServiceImpl();

	public void registerCustomer() {
		Customers customers = new Customers();
		System.out.println("Enter the CustomerID:");
		int customerID = scanner.nextInt();
		customers.setCustomerID(customerID);
		System.out.println("Enter the FirstName:");
		String firstName = scanner.next();
		customers.setFirstName(firstName);
		System.out.println("Enter the lastName:");
		String lastName = scanner.next();
		customers.setLastName(lastName);
		System.out.println("Enter the email:");
		String email = scanner.next();
		customers.setEmail(email);
		System.out.println("Enter the phonenum:");
		String phone = scanner.next();
		customers.setPhone(phone);
		System.out.println("Enter the Address:");
		String address = scanner.next();
		customers.setAddress(address);
		dao.registerCustomer(customers);
	}
	
	
	public void calculateTotalOrders() {
		System.out.print("Enter Customer ID ");
		int customerId = scanner.nextInt();
		dao.calculateTotalOrders(customerId);
	}
	
	public void getCustomerDetails() {
		System.out.print("Enter Customer ID ");
		int customerId = scanner.nextInt();
		dao.showCustomerDetails(customerId);
	}

	public void updateCustomer() {
		Customers customers = new Customers();
		System.out.println("Enter customerID:");
		int customerId = scanner.nextInt();
		customers.setCustomerID(customerId);
		System.out.println("Enter the email:");
		String email = scanner.next();
		customers.setEmail(email);
		System.out.println("Enter the phone:");
		String phone = scanner.next();
		customers.setPhone(phone);
		System.out.println("Enter the address:");
		String address = scanner.next();
		customers.setAddress(address);
		dao.updateCustomer(customers);
	}
	
	public void getCustomerList() {
		dao.showCustomer();
	}

}

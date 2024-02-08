package com.hexaware.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.serviceImpl.OrderServiceImpl;

import com.hexaware.model.Orders;

public class OrdersController {
	Scanner scanner = new Scanner(System.in);
	CustomersController cs = new CustomersController();
	List<Orders> ordersList = new ArrayList<Orders>();
	Orders orders;
	OrderServiceImpl dao=new OrderServiceImpl();

	
	public void calculateTotalAmount() {
		System.out.print("Enter Order ID ");
		int orderId = scanner.nextInt();
		dao.calculateTotalAmount(orderId);
	}
	
	public void getOrderDetails() {
		System.out.print("Enter Order ID ");
		int orderId = scanner.nextInt();
		dao.showOrderDetails(orderId);
	}
	public void updateOrderStatus() {
		Orders order = new Orders();
		
		System.out.print("Enter Order ID ");
		int orderId = scanner.nextInt();
		order.setOrderID(orderId);
		System.out.println("Enter Order Status:(Processing,shipped,cancelled)");
		String orrderStatus=scanner.next();
		order.setOrderID(orderId);
		order.setStatus(orrderStatus);
//		if (choice == 1) order.setStatus("PROCESSING");
//		if (choice == 2) order.setStatus("SHIPPED");
//		if (choice == 3) order.setStatus("CANCELLED");
		dao.updateOrderStatus(order);
	}
	
	public void cancelOrder() {
		System.out.print("Enter Order ID ");
		int orderId = scanner.nextInt();
		dao.cancelOrder(orderId);

	}

}

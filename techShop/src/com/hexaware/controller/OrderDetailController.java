package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.serviceImpl.OrderDetailServiceImpl;
import com.hexaware.model.OrderDetails;


public class OrderDetailController {
	Scanner scan=new Scanner(System.in);
	OrderDetailServiceImpl orderDetailsDao=new OrderDetailServiceImpl();
	
	public void calculateSubTotal() {
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		orderDetailsDao.calculateSubTotal(orderDetailsId);
	}
	
	public void getOrderDetailInfo() {
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		orderDetailsDao.showOrderDetails(orderDetailsId);
	}
	
	public void updateQuantity() {
		OrderDetails orderDetail = new OrderDetails();
		
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		
		System.out.println("Enter Quantity ");
		int quantity = scan.nextInt();
		
		orderDetail.setOrderDetailID(orderDetailsId);
		orderDetail.setQuantity(quantity);
		
		orderDetailsDao.updateQuantity(orderDetail);
	}
	
	public void addDiscount() {
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		
		System.out.println("Enter Discount Percentage ");
		int discountPercent = scan.nextInt();
		
		orderDetailsDao.addDiscount(orderDetailsId, discountPercent);
		
	}
	
}

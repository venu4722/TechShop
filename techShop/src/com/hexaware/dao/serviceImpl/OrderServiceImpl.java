package com.hexaware.dao.serviceImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.hexaware.dao.IOrderService;
import com.hexaware.model.Orders;
import com.hexaware.util.DBConnection;

public class OrderServiceImpl implements IOrderService{
	
	/**
	 * Shows the details of a specific order.
	 * 
	 * @param orderId The ID of the order for which details are to be shown.
	 */
	public void showOrderDetails(int orderId) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT Orders.orderId, firstname, lastname, email FROM Orders JOIN Customers ON Customers.customerID = Orders.customerID WHERE orderID = ?");
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("OrderId:" + rs.getInt(1));
				System.out.println("Order Customer First Name:" +rs.getString(2));
				System.out.println("Order Customer Last Name: "+ rs.getString(3));
				System.out.println("Customer Email: "+ rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String trackStatus(int orderID) {
		String status=null;
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select status from orders where orderid=?");
			ps.setInt(1, orderID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				status=rs.getString("status");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * Updates the status of a specific order.
	 * 
	 * @param order The order object containing updated status and order ID.
	 */
	public void updateOrderStatus(Orders order) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE Orders SET status = ? WHERE orderID = ?");
			ps.setString(1, order.getStatus());
			ps.setInt(2, order.getOrderID());
			int k = ps.executeUpdate();
			if(k>0)System.out.println("Order Status Updated Successfully..");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void calculateTotalAmount(int orderId) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT SUM(Price * Quantity) AS TotalAmount FROM OrderDetails D JOIN Products P ON D.productID = P.productID WHERE D.orderID = ?");
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Total Amount for "+ orderId +":"+ " "+ rs.getFloat(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Cancels a specific order by updating its status to "CANCELLED".
	 * 
	 * @param orderId The ID of the order to be canceled.
	 */
	public void cancelOrder(int orderId) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE Orders SET status = ? WHERE orderID = ?");
			ps.setString(1, "cancelled");
			ps.setInt(2, orderId);
			int k = ps.executeUpdate();
			if(k>0) {
				System.out.println("Order Cancelled Successfully.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}

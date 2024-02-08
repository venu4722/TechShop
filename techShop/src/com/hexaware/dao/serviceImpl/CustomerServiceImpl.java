package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.dao.ICustomerService;
import com.hexaware.model.Customers;
import com.hexaware.util.DBConnection;

public class CustomerServiceImpl implements ICustomerService{
	
	@Override
	public void registerCustomer(Customers customers) {
		try {
			Connection  con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into customers values(?,?,?,?,?,?)");
			ps.setInt(1, customers.getCustomerID());
			ps.setString(2, customers.getFirstName());
			ps.setString(3, customers.getLastName());
			ps.setString(4, customers.getEmail());
			ps.setString(5, customers.getPhone());
			ps.setString(6, customers.getAddress());
			int k=ps.executeUpdate();
			if(k>0) {
				System.out.println("Customer Registered Successfully....");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Shows the details of a specific customer.
	 * 
	 * @param customerID The ID of the customer whose details are to be shown.
	 */
	@Override
	public void showCustomerDetails(int customerID) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Customers WHERE customerID = ?");
			System.out.println(customerID);
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCustomer(Customers customers) {
		try {
			Connection con =DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update customers set email=?,phone=?,address=? where customerid=?");
			ps.setString(1, customers.getEmail());
			ps.setString(2, customers.getPhone());
			ps.setString(3, customers.getAddress());
			ps.setInt(4, customers.getCustomerID());
			int k=ps.executeUpdate();
			if(k>0) {
				System.out.println("Customer Updated Successfully....");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void showCustomer() {
		try {
			Connection con = DBConnection.getCon();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from Customers");
			while(rs.next()) {
				System.out.println("Customer ID : "+ rs.getInt(1));
				System.out.println("First Name : "+ rs.getString(2));
				System.out.println("Last Name : "+ rs.getString(3));
				System.out.println("Email: "+rs.getString(4));
				System.out.println("Phone: "+rs.getString(5));
				System.out.println("Address: "+rs.getString(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculates the total number of orders for a specific customer.
	 * 
	 * @param customerId The ID of the customer for whom total orders are to be
	 *                   calculated.
	 */
	@Override
	public void calculateTotalOrders(int customerId) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT count(*) as Total_Orders FROM orders joins "
					+ "Customers on orders.customerID = Customers.customerID WHERE Customers.customerID = ?");
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	
}

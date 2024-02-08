package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.dao.IOrderDetails;
import com.hexaware.model.OrderDetails;
import com.hexaware.util.DBConnection;



public class OrderDetailServiceImpl implements IOrderDetails {
	
	/**
	 * Shows the details of a specific order detail.
	 * 
	 * @param orderDetailId The ID of the order detail for which details are to be
	 *                      shown.
	 */
	public void showOrderDetails(int orderDetailId) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT OrderDetails.orderDetailID, productname,OrderDetails.quantity FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetailId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("OrderDetailsId:"+ resultSet.getInt(1));
				System.out.println("ProductName:"+ resultSet.getString(2));
				System.out.println("OrderDetails Quantity:"+ resultSet.getInt(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculates the sub-total of a specific order detail.
	 * 
	 * @param orderDetailId The ID of the order detail for which the sub-total is to
	 *                      be calculated.
	 */
	public void calculateSubTotal(int orderDetailId) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT (price*quantity) AS SubTotal FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetailId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("SubTotal: "+ resultSet.getFloat(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates the quantity of a specific order detail.
	 * 
	 * @param orderDetail The order detail object containing updated quantity and
	 *                    order detail ID.
	 */
	public void updateQuantity(OrderDetails orderDetail) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OrderDetails SET quantity = ? WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetail.getQuantity());
			preparedStatement.setInt(2, orderDetail.getOrderDetailID());
			int k = preparedStatement.executeUpdate();
			if(k>0)System.out.println("Quantity Updated Succesfully..");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Adds a discount to the sub-total of a specific order detail.
	 * 
	 * @param orderDetailId   The ID of the order detail to which the discount is to
	 *                        be added.
	 * @param discountPercent The percentage of discount to be applied.
	 */
	public void addDiscount(int orderDetailId, int discountPercent) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement= connection.prepareStatement("SELECT (price*quantity)* ? AS DiscountedSubTotal FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			
			double discount = discountPercent/100.00;
			System.out.println(discount);
			preparedStatement.setDouble(1, 1-discount);
			preparedStatement.setInt(2, orderDetailId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Total Amount After Discount: "+ resultSet.getFloat(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

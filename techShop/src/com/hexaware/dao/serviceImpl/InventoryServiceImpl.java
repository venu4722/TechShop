package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.dao.IInventoryService;
import com.hexaware.model.*;
import com.hexaware.util.DBConnection;



public class InventoryServiceImpl implements IInventoryService{
	
	Inventory Inventory = new Inventory();

	/**
	 * Shows the details of a specific product in the inventory.
	 * 
	 * @param inventoryId The ID of the inventory for which details are to be shown.
	 */
	@Override
	public void showProduct(int InventoryId) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT Inventory.productId, Products.productname FROM Inventory JOIN Products ON Products.productId = Inventory.productId WHERE Inventory.InventoryId = ?");
			preparedStatement.setInt(1, InventoryId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("ProductId Associated with Inventory: "+ resultSet.getInt(1));
				System.out.println("ProductName Associated with Inventory: "+ resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
	
	/**
	 * Shows the stock quantity of a specific product in the inventory.
	 * 
	 * @param productId The ID of the product for which stock quantity is to be
	 *                  shown.
	 */
	@Override
	public void showStockQuantity(int productId) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(quantityinstock) AS ProductStock FROM Inventory WHERE productId = ?");
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("StockQuanity: "+ resultSet.getFloat(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates the quantity of a specific product in the inventory by adding.
	 * 
	 * @param productId The ID of the product for which quantity is to be updated.
	 * @param quantity  The quantity to be added.
	 */
	@Override
	public void updateAddQuantity(int productId, int quantity) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = quantityinstock+? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
			int k = preparedStatement.executeUpdate();
			if(k>0)System.out.println("QuantityInStock updated Sucessfully..");
			
		}catch(SQLException e) {
			e.printStackTrace();	
		}
	}
	
	/**
	 * Updates the quantity of a specific product in the inventory by removing.
	 * 
	 * @param productId The ID of the product for which quantity is to be updated.
	 * @param quantity  The quantity to be removed.
	 */
	@Override
	public void updateRemoveQuantity(int productId, int quantity) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = quantityinstock-? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
			int k = preparedStatement.executeUpdate();
			if(k>0)System.out.println("Updated Removed Quantity In Stock Successfully..");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates the quantity of a specific product in the inventory by setting a
	 * specific value.
	 * 
	 * @param inventoryId The ID of the inventory for which quantity is to be
	 *                    updated.
	 * @param quantity    The quantity to be set.
	 */
	@Override
	public void updateStockQuantity(int InventoryId, int quantity) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = ? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, InventoryId);
			int k = preparedStatement.executeUpdate();
			if(k>0)System.out.println("QuantityInStock Updated Successfully..");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows the available quantity of a specific product in the inventory.
	 * 
	 * @param productId The ID of the product for which available quantity is to be
	 *                  shown.
	 * @return The available quantity of the product.
	 */
	@Override
	public int showAvailableQuantity(int productId) {
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement preparedStatement= connection.prepareStatement("SELECT SUM(quantityinstock) FROM Inventory WHERE productId = ?");
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Calculates the total value of the entire inventory.
	 * 
	 * @return The total value of the inventory.
	 */
	@Override
	public int showInventoryValue() {
		int totalInventoryValue = 0;
		try {
			Connection connection = DBConnection.getCon();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT SUM(quantityinstock*price) FROM Inventory JOIN Products ON Inventory.productId = Products.productId");
			if(resultSet.next()) {
				totalInventoryValue = resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return totalInventoryValue;
	}
	
	/**
	 * Shows products in the inventory that have stock below a specified threshold.
	 * 
	 * @param threshold The threshold value for low stock.
	 */
	@Override
	public void showLowStockProducts(int threshold) {
		try {
			Connection connection =DBConnection.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT InventoryId, Inventory.productId, productname FROM Inventory JOIN Products ON Products.productId = Inventory.InventoryId WHERE quantityInStock <= ?");
			preparedStatement.setInt(1, threshold);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("InventoryId: "+ resultSet.getInt(1));
				System.out.println("ProductId: "+ resultSet.getInt(2));
				System.out.println("ProductName: "+ resultSet.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows products in the inventory that are out of stock.
	 */
	@Override
	public void showOutOfStockProdcuts() {
		try {
			Connection connection = DBConnection.getCon();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT DISTINCT(Inventory.productId), productname FROM Inventory JOIN Products ON Products.productId = Inventory.InventoryId WHERE quantityInStock = 0");
			while(resultSet.next()) {
				System.out.println("ProductId Assoicate with Inventory: "+  resultSet.getInt(1));
				System.out.println("ProdutName: "+ resultSet.getString(2));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows details of all products in the inventory.
	 */
	@Override
	public void showAllProducts() {
		try {
			Connection connection = DBConnection.getCon();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT DISTINCT(Inventory.productId), productname FROM Inventory JOIN Products ON Products.productId = Inventory.InventoryId");
			while(resultSet.next()) {
				System.out.println("ProductId Assoicate with Inventory: "+  resultSet.getInt(1));
				System.out.println("ProdutName: "+ resultSet.getString(2));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}

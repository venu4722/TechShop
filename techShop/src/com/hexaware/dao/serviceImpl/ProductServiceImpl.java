package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.dao.IProductsService;


import com.hexaware.model.Products;
import com.hexaware.util.DBConnection;

public class ProductServiceImpl implements IProductsService{
	
	/**
	 * Inserts a new product into the database.
	 * 
	 * @param product The product object to be inserted.
	 */
	public void insertProduct(Products product) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO Products(ProductID, ProductName, Descriptions, Price) VALUES (?, ?, ?, ?)");

			ps.setInt(1, product.getProductID());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());

			int totalRows = ps.executeUpdate();
			System.out.println(totalRows + " rows affected!");

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	@Override
	public void updateProduct(Products products) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update products set price=?,description=? where productid=? ");
			ps.setInt(1, products.getProductID());
			ps.setFloat(2, products.getPrice());
			ps.setString(3, products.getDescription());
			int k=ps.executeUpdate();
			if(k>0) {
				System.out.println("Product Updated Successfully...");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void getProductByName(String productName) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from products where productname=? ");
			ps.setString(1, productName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("ProducId: "+ rs.getInt(1));
				System.out.println("ProductName: "+ rs.getString(2));
				System.out.println("ProductDescription: "+ rs.getString(3));
				System.out.println("ProductPrice: "+ rs.getFloat(4));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isProductInStock(int productID) {
		int quantityInStock = 0;

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(
					"SELECT inventory.quantityInStock FROM Products join inventory on Products.ProductID = inventory.ProductID WHERE Products.ProductID = ?");
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				quantityInStock = rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return quantityInStock > 0;
	}
	
	/**
	 * Shows the details of a specific product.
	 * 
	 * @param productID The ID of the product for which details are to be shown.
	 */
	public void showProductDetails(int productID) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE ProductID = ?");
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ProducId: "+ rs.getInt(1));
				System.out.println("ProductName: "+ rs.getString(2));
				System.out.println("ProductDescription: "+ rs.getString(3));
				System.out.println("ProductPrice: "+ rs.getFloat(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void getAllProducts() {
		try {
			Connection connection=DBConnection.getCon();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("Select * from products");
			while(rs.next()) {
				System.out.println("ProducId: "+ rs.getInt(1));
				System.out.println("ProductName: "+ rs.getString(2));
				System.out.println("ProductDescription: "+ rs.getString(3));
				System.out.println("ProductPrice: "+ rs.getFloat(4));
				System.out.println("-------------------------------------");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.hexaware.util;
import java.sql.*;
public class DBConnection {
	private static Connection con = null;
	private DBConnection() {}
	
	static
	{
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection
	("jdbc:mysql://localhost:3306/techshop","root","admin");
	}
	catch(Exception e) {e.printStackTrace();}

	}
	
	public static Connection getCon() {
		return con;
	}
}

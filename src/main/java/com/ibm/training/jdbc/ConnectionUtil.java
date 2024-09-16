package com.ibm.training.jdbc;

import java.sql.*;

public class ConnectionUtil {
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm_b3", "root", "secret");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void main(String[] args) throws SQLException {
		Connection c = getConnection();
		//System.out.println(c);
		
		DatabaseMetaData meta = c.getMetaData();

		System.out.println(meta.getDatabaseProductName());
		System.out.println(meta.getDatabaseProductVersion());
	}

}

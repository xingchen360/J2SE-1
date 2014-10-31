package com.somnus.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
		private static final String url = "jdbc:mysql://localhost:3306/demo";
		private static final String user = "root";
		private static final String password = "pass";
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				System.out.println(ce);
			}
		}

		public static Connection getConn() {
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
			return con;
		}
		public static void main(String[] args)
		{
			
			System.out.println(getConn());
		}

		
}

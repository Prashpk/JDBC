package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/edudb";
	static String un = "root";
	static String pa = "root";
	static Connection conn = null;
	
	static public Connection getConnection() {
		
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,un,pa);
		if(conn==null) {
			System.out.println("Null connection");
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return conn;
	}
}

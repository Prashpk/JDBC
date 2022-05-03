package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		
		String myTable = "create table cloud(cid int primary key, cname varchar(40) not null)";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/edudb";
		String un = "root";
		String pass = "root";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,un,pass);
			 Statement st = conn.createStatement();
			 st.execute(myTable);
			
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
	}
}

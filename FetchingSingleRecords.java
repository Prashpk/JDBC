package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FetchingSingleRecords {

	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3307/edudb";
		String un = "root";
		String pass = "prashsam";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs= null; 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to Fetch Records");
		int id = sc.nextInt();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pass);
			st = conn.createStatement();
			
			String sql = "select * from login where id = "+id;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+ " " +rs.getString("email"));
			}else {
			  System.out.println("user not exists");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
}

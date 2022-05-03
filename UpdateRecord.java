package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pa = "root";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to UPDATE Record ");
		int Id = sc.nextInt();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pa);
			st = conn.createStatement();
			
			String sel = "select * from emp where eid = "+Id;  //get only one row
			rs = st.executeQuery(sel);
			
			//check if id Exists
	        if(rs.next()) {
	        	//if true record Exists Then only we can perform Delete & Update
	        	//Update operation when record Exists
	          System.out.println("Enter the name to be updated");
	    	  String name = sc.next();
	          String upd = "update emp set ename = '"+name+"' where eid = "+Id;
	          int i = st.executeUpdate(upd);
	          
	        if(i>0) {
	        	System.out.println("Record is Updated");
	        }
	        }//if
	        else {
	        	System.out.println("Record not exists");
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

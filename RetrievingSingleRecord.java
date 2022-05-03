package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RetrievingSingleRecord {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pa = "root";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id Fetch Records ");
		int Id = sc.nextInt();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pa);
			st = conn.createStatement();
			
			String sel = "select * from emp where eid = "+Id;  //get only one row
			rs = st.executeQuery(sel);
			
			System.out.println("EID\tENAME\tJOB\tSALARY\tEMAIL");
	        if(rs.next()) {
	        	System.out.println(rs.getInt("eid")+"\t" +rs.getString("ename")+ "\t" 
	        +rs.getString("job")+ "\t"+rs.getInt("salary")+"\t"+rs.getNString("email"));
	        	
	        }
	        else {
	        	System.out.println("User Not Exists");
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	

	}
}

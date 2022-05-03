package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecords {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		int eid = 0;
		String ename = null;
		String job = null;
		float salary = 0;
		String email = null;
		ResultSet rs = null;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pa = "root";
		try {
			//load Driver for connection
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pa);
			st = conn.createStatement();
			
			String sel = "select * from emp";
			rs = st.executeQuery(sel);
			
			System.out.println("EID\tENAME\tJOB\tSALARY\t\tEMAIL");
			while(rs.next()) {
				int Id = rs.getInt("eid"); //column position
				String n = rs.getString("ename");
				String j = rs.getString("job");
				Float s = rs.getFloat("salary");
				String e = rs.getString("email");
				System.out.println(Id+ "\t" +n+ "\t" +j+ "\t" +s+ "\t" +e);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	

	}
}

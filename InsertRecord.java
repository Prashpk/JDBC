package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecord {

	public static void main(String[] args) {
		String name = null;
	    int id = 0;
	    
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/edudb";
	    String un = "root";
	    String pa = "root";
	    Connection conn = null;
	    Statement st = null;
	    Scanner sc= new Scanner(System.in);
	    
    	System.out.println("Enter the id ");
    	id = sc.nextInt();
	    String sel = "select * from login where id = " +id;
	    
	    try {
	    Class.forName(driver);
    	conn = DriverManager.getConnection(url,un,pa);
    	st = conn.createStatement();
    	ResultSet rs = st.executeQuery(sel);
    
    	if(!rs.next()) {
        System.out.println("Enter the name ");
    	name = sc.next();
    	String ins = " insert into login values("+id+",'"+name+"')";
    	int i = st.executeUpdate(ins);
    	
    	if(i>0) {
    		System.out.println("Record Inserted Successfully");
    	}
    	}
    	else {
    		System.out.println("Id Already Exists choose different Id");
    	}
    	}
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}

}
 
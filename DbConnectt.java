package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnect {

	public static void main(String[] args) {
		//Make a connection with Database
		int Id;
		String Name;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id ");
		Id = sc.nextInt();
		System.out.println("Enter name ");
		Name = sc.next();
		
		String Driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/edudb";
		String un = "root";
		String pass = "root";
		
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(url,un,pass);
			Statement st = conn.createStatement(); 
			//try to insert name with single & double quotes please
			String ins = "insert into login values("+Id+",'"+Name+"')";
			int i = st.executeUpdate(ins);
			if(i>0) {
				System.out.println("Record Inserted");
			}
			else {
				System.out.println("Failed to Connect!");
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
	}
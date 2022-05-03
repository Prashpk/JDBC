package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DataBaseOperations {

	static Connection myconn = null; 
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void addRecords() { 
		try {
			System.out.println("Enter id ");
			int sid = sc.nextInt();
			System.out.println("Enter name ");
			String n = sc.next();
			System.out.println("Enter course ");
			String c = sc.next();
			
			myconn = DbConnect.getConnection();
			
			String selsql = "select * from edustudent where sid = ?";
			ps= myconn.prepareStatement(selsql);
			ps.setInt(1, sid);
			
			rs = ps.executeQuery();
			
			if(!rs.next()) {
			
			
			String sql = "insert into edustudent values(?,?,?)";//?->sid, ?->sname->, ?->scourse
			PreparedStatement ps = myconn.prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setString(2, n);
			ps.setString(3, c);
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Record inserted Successfully");
			}
		}
			else {
				System.out.println(sid+" Already exists");
			}
	} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void displayRecords() {
	
		try {
		myconn = DbConnect.getConnection();
		String sql = "select * from edustudent";
		ps = myconn.prepareStatement(sql);
		rs = ps.executeQuery();
		System.out.println("ID\tNAME\tCOURSE");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+ "\t" +rs.getString(3));
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void updateRecords() {
		
		System.out.println("Enter the id to update records");
		int id = sc.nextInt();
		
		
		try {
			//check for record existence
		myconn = DbConnect.getConnection();
		String sel = "select * from edustudent where sid = ?";
		ps = myconn.prepareStatement(sel);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
	
		if(rs.next()) {
			System.out.println("Which field you want to update ?");
			System.out.println("1. to update name ");
			System.out.println("2. to update course ");
			System.out.println("3. to update name and course ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the name to change");
				String n = sc.next();
				String  update = "update edustudent set sname = ?  where sid = ?";
				ps = myconn.prepareStatement(update);
				ps.setString(1, n);
				ps.setInt(2, id);
				
				int j = ps.executeUpdate();
				if(j>0) {
					System.out.println("Name is changed ");
			}
			case 2:
				System.out.println("Enter the course to change");
				String c = sc.next();
				String  cup = "update edustudent set scourse = ?  where sid = ?";
				ps = myconn.prepareStatement(cup);
				ps.setString(1, c);
				ps.setInt(2, id);
				
				int k = ps.executeUpdate();
				if(k>0) {
					System.out.println("course name is changed ");
			}
				break;
			case 3:
				System.out.println("Enter the name to change");
				String nm = sc.next();
				System.out.println("Enter the course to change");
				String cr = sc.next();
				String  nc = "update edustudent set sname = ? , scourse = ? where sid = ?";
				ps = myconn.prepareStatement(nc);
				
				 
				ps.setString(1, nm);
				ps.setString(2, cr);
				ps.setInt(3, id);
				
				int l = ps.executeUpdate();
				if(l>0) {
					System.out.println("Name and Course is changed ");
			}
				break;
		}
			
			
		}
		else {
			System.out.println(id+ " not Exists");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	public static void deleteRecords() {
		System.out.println("Enter id to delete Records ");
		int id = sc.nextInt();
		try {
		myconn = DbConnect.getConnection();
		
		String  sel = "select * from edustudent where sid = ?";
		ps = myconn.prepareStatement(sel);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			
			String dsql = "delete from edustudent where sid = ?";
			ps = myconn.prepareStatement(dsql);
			
			int k = ps.executeUpdate(dsql);
			if(k>0) {
				System.out.println(id+" is Deleted");
			}
		}
		else {
			System.out.println(id+ " Not Exists in database ");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void displaySingleRecords() {
		System.out.println("Enter id to Display Records ");
		int id = sc.nextInt();
			try {
			myconn = DbConnect.getConnection();
			String sql = "select * from edustudent where sid = "+id;
			ps = myconn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("ID\tNAME\tCOURSE");
			if(rs.next()) {
				System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+ "\t" +rs.getString(3));
			}
		else {
			System.out.println(id+ " Not Exists in database ");
		}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
package com.edu;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {

				Scanner sc = new Scanner(System.in);
				
				while(true) {
				System.out.println("Database Operations : ");
				System.out.println("1. To Display All Student Information");
				System.out.println("2. Insert Student Record");
				System.out.println("3. Update Student Information based on id");
				System.out.println("4. Delete Student Information based on id");
				System.out.println("5. Display Student Information based on Id");
				System.out.println("Enter your choice ?");
				int ch = sc.nextInt();
				
				switch(ch) {
				case 1:
					DataBaseOperations.displayRecords();
					break;
				
				case 2: 
					DataBaseOperations.addRecords();
					break;
				case 3: 
					DataBaseOperations.updateRecords();
					break;
				case 4: 
					DataBaseOperations.deleteRecords();
					break;
				case 5:
					DataBaseOperations.displaySingleRecords();
					break;
					
				default :
					System.out.println("Invalid choice");
				}
				
				System.out.println("Do you want to continue yes/no ?");
				String choice = sc.next();
				
				if(choice.equalsIgnoreCase("no")) {
					break;
				}
				}
				System.out.println("Program Terminated!");
			}
	}
package com.rana.jdbc;

/*
 *	Develop a program to insert rows in course table with dynamic values
 *  read those values from the keyboard
 *  
 *    query syntax:
 *    	
 *    	"INSERT INTO course(course_id, course_name, course_fee)\n" +
 *      "VALUES("+courseId+", '"+courseName+"', "+couseFee+")";
 */

//Test15_Stmt_DynamicValues.java 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test15_Stmt_DynamicValues
{
	public static void main(String[] args) 
	{
        try(
				
				Connection cns=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rana752580","harindra");
				Statement stmt=cns.createStatement();
			)
		{
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			String option="N";
			do 
			{
				System.out.println("Enter the course Id:");
				int courseId=sc.nextInt();
				sc.nextLine();
				
				
				System.out.println("Enter the course name:");
				String courseName=sc.nextLine();
				
				System.out.println("Enter the course fee:");
				double courseFee=sc.nextDouble();
				
				stmt.executeUpdate(
						
						"INSERT into course1(Course_Id,courseName,courseFee)\n"+
						"values("+courseId+",'"+courseName+"',"+courseFee+")"
						);
				System.out.println("\n 1 Rows inserted.");
				
				System.out.println("\n Do you wants to continue.(Y/N)?:");
				option=sc.next();
				sc.nextLine();
				
			} 
			while (option.equalsIgnoreCase("Y"));
			System.out.println("_/\\_ Thanku you ,Visit Again_/\\_");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

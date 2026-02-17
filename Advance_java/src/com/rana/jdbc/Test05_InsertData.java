package com.rana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test05_InsertData {

	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		//driver class loading
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loading");
		
		//Establishing Connection
		Connection cns=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rana752580","harindra");
		System.out.println("Establishing Connection");
		
		//Create Statement
		Statement stmt=cns.createStatement();
		System.out.println("Statement is created:");
		
		//Preparing query 
		stmt.executeUpdate(
				"""
				insert into course1(course_id,coursename,courseFee)
				values(courseseq.nextval,'Core Java',3500)
				"""				
				);
		stmt.executeUpdate(
				"""
				insert into course1(course_id,coursename,courseFee)
				values(courseseq.nextval,'Advance Java',4000)
				"""				
				);
		stmt.executeUpdate(
				"""
				insert into course1(course_id,coursename,courseFee)
				values(courseseq.nextval,'Oracle',3800)
				"""				
				);
		stmt.executeUpdate(
				"""
				insert into course1(course_id,coursename,courseFee)
				values(courseseq.nextval,'HTML,CSS,JAVASCRIPT',3800)
				"""				
				);		
		
		System.out.println("Rows are inserted");
		
		//5. closing connection
		stmt.close();
		cns.close();
		

	}

}

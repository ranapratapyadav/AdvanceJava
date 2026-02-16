package com.rana.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Test04_SequenceCreation 
{
	public static void main(String[] args) throws ClassNotFoundException ,SQLException
	{
		//Loading class driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded.");
		
		//Establishing Connection
		Connection cns=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rana752580","harindra");
		System.out.println("Connection established.");
		
		//Creating statement
		Statement stmt=cns.createStatement();
		System.out.println("Statement is create.");
		
		//Preparing query
		
		String courseSequence="""
				CREATE SEQUENCE courseseq
				start with 1
				increment by 1
				""";
		String studentSequence="""
				CREATE SEQUENCE studentSeq
				start with 101
				increment by 1
				""";
		
		//Execute Queries
		stmt.execute(courseSequence);
		stmt.execute(studentSequence);
		
		
		//Close  Connection
		stmt.close();
		cns.close();
	}
}

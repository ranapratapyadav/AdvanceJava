package com.rana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test06_UpdateData {

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
		
		
		int rows=stmt.executeUpdate(
				"""
				update  course1 set courseFee=courseFee+1000 where coursename like '%crs%'
				"""				
				);
//		int rows1=stmt.executeUpdate(
//				"""
//				delete from course1 where coursename='Core Java'
//				
//				""");
//		
//		System.out.println(rows1);
		
		
		
		System.out.println(rows + " row(s) updated");
			
		
//		System.out.println("Rows are updated");
		
		//5. closing connection
		stmt.close();
		cns.close();
		

	}

}

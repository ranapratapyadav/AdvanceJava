package com.rana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test07_DeleteData {

	public static void main(String[] args)  throws ClassNotFoundException,SQLException
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
				
				//preparing query
				int rows=stmt.executeUpdate
						(
								"""
								delete from course1 where coursename like '%cr%' 
								"""
						);
				System.out.println(rows+"rows deleted");
				System.out.println("Rows are updated");
				
				//Close Connection
				
				stmt.close();
				cns.close();
				
	}

}

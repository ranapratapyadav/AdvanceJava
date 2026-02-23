package com.rana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Test09_Stmt_ColumnsDetails {

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
		
		//Execute query for select rows
		ResultSet rs=stmt.executeQuery("Select * from course1");
		
		//Obtaining rsmd object
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//retrieving and printing columns		
		int columnCount=rsmd.getColumnCount(); 
		
		System.out.println("Number of column available in course table are : "+columnCount);
		System.out.println("Column name \t column type \t column size");
		System.out.println("==================================================================================");
		for(int i=1;i<=columnCount;i++)
		{
			System.out.println(
					rsmd.getColumnName(i)  + "\t"+
					rsmd.getColumnTypeName(i)+"\t"+
					rsmd.getPrecision(i)
					);
		}
		
		System.out.println("===================================================================================");
		
		
		//close connection
		rs.close();
		stmt.close();
		cns.close();

	}

}

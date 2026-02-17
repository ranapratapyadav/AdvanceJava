package com.rana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test08_Stmt_DisplayRowsAndColumn {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
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
				ResultSet rs=stmt.executeQuery("Select COURSE_ID,COURSENAME,COURSEFEE  from course1 ORDER by COURSE_ID");
				
				//Running Query
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
				}
				
				rs.close();
				stmt.close();
				cns.close();
				

	}

}

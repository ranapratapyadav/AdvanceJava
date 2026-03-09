/*
 *	Develop a program to insert rows in course table with dynamic values
 *  read those values from the keyboard by using Java 25v IO.readln()
 *  
 *    query syntax by using TextBlock and format specifiers:
 *    	"""
 *    	INSERT INTO course(course_id, course_name, course_fee)
 *    	VALUES(%d, '%s', %f)
 *    	""";
 *    	
 *    for replacing format specifies, 
 *       we must call string.formatted(Object... args) method
 *       
 *    for example: we must call above method as 
 *    	query = query.formatted(courseId, courseName, courseFee); 
 *    	   
 */

//Test16_Stmt_DyVs_with_IO_TextBlocks.java
package com.rana.jdbc;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test16_Stmt_DyVs_with_IO_TextBlocks {
	
	public static void main(String[] args) {
		
		try(
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rana752580","harindra");
			Statement  stmt = con.createStatement();	
		){
			String option = "N";
			
			do {

				int courseId 		= Integer.parseInt(IO.readln("Enter courseId\t: "));
				String courseName 	= IO.readln("Enter courseName\t: ");
				double courseFee 	= Double.parseDouble(IO.readln("Enter courseFee\t: "));
				
				String query = 
						"""
				        INSERT INTO course1(course_id, coursename, coursefee)
					    VALUES(%d, '%s', %f)
					    """;
				
				query = query.formatted(courseId, courseName, courseFee);
				
				stmt.executeUpdate(query);
				
				System.out.println("1 row inserted.");
				
				option = IO.readln("\nDo you want to continue(Y/N)?:");
				
			}while(option.equalsIgnoreCase("Y"));
			
			System.out.println("_/\\_ Thank you, Visit Again _/\\_");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
	}//main close
}//class close






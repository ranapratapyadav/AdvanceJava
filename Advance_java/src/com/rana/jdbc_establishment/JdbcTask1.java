package com.rana.jdbc_establishment;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class JdbcTask1 
{
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		//loading the driver
		@SuppressWarnings("rawtypes")
		Class cls=Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Loading the oracle driver");
		
		//Establish the connection
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","rana752580","harindra");
		System.out.println("Connection established");
		
		
		//create statement
		Statement stmt=con.createStatement();
		
		System.out.println("Statement created.");
		
		//Execute Query
		ResultSet rs=stmt.executeQuery("Select * from Student_info");
		
		//Running Query
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		for(int i = 1;i<=columnCount;i++)
		{
			String columnClassName = metaData.getColumnName(i);
			System.out.print(columnClassName+"\t");
		}
		System.out.println();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}

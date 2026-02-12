package com.rana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Test01_Connection 
{
	public static void main(String[] args){
		//1.loading driver
		try {
			
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println("Driver class is loading");
			
//	Oracle
//		String url="jdbc:oracle:thin:@localhost:1521:xe";
//		String user="rana123";
//		String pwd="AWLESH";
			
//	MySQL
		String url="jdbc:mysql://localhost:3306/firstdb";
		String user="root";
		String pwd="root";
		
		Connection cns=DriverManager.getConnection(url,user,pwd);
		System.out.println("connection establishment"+cns);
		
			PreparedStatement ps = cns.prepareStatement("select *from student");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rq = rs.getMetaData();
			
			while(rs.next()) {
				
				for(int i=1; i<=rq.getColumnCount(); i++) {
					System.out.print(rs.getString(i)+" ");
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

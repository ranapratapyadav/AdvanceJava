package com.rana.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Test02_Statement
{

	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		//Loading Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading.");
		
		

	}

}

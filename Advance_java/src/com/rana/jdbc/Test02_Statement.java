package com.rana.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Test02_Statement {

    public static void main(String[] args) 
            throws ClassNotFoundException, SQLException {

        // 1. Loading Driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver Loading.");

        // 2. Establish Connection
        try (Connection cns = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "rana752580",
                "harindra");

             Statement stmt = cns.createStatement()) {

            System.out.println("Connection Establishment.");
            System.out.println("Statement is created.");

            // Drop tables if already exist
            try {
                stmt.execute("DROP TABLE student9 CASCADE CONSTRAINTS");
            } catch (SQLException e) { }

            try {
                stmt.execute("DROP TABLE course1 CASCADE CONSTRAINTS");
            } catch (SQLException e) { }

            // Create parent table first
            String courseTableQuery =
                    """
                    CREATE TABLE course1(
                        course_id NUMBER(4) PRIMARY KEY,
                        courseName VARCHAR2(50) UNIQUE NOT NULL,
                        courseFee NUMBER(7,2)
                    )
                    """;

            // Create child table (fixed reference)
            String studentTableQuery =
                    """
                    CREATE TABLE student9(
                        sid NUMBER(4) PRIMARY KEY,
                        sname VARCHAR2(20) NOT NULL,
                        course_id NUMBER(4) REFERENCES course1(course_id),
                        fee NUMBER(7,2)
                    )
                    """;

            stmt.execute(courseTableQuery);
            stmt.execute(studentTableQuery);

            System.out.println("Tables created successfully.");

        } // auto close

    }
}

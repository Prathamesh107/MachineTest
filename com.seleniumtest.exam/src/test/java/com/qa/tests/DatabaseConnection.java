package com.qa.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatabaseConnection {

	Connection conn;
	Statement stmt;

	@BeforeTest
	public void setUp() throws Exception {
		String dbURL = "jdbc:sqlserver://Systemname:1433;" + "databaseName=MyDatab;user=Prathamesh;password=Rathod";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbURL);
		stmt = conn.createStatement();

	}

	@Test
	public void test() {
		try {
			String query = "select * from Asset";
			ResultSet res = stmt.executeQuery(query);
			while (res.next())
				System.out.println(res.getInt(1) + "  " + res.getString(2) + "  " + res.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		System.out.println(" Database Connected");
		conn.close();

	}

}

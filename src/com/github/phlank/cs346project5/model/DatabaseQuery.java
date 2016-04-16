package com.github.phlank.cs346project5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQuery {
	
	private static String serverName = "csor6.dhcp.bsu.edu";
	private static String portNumber = "1521";
	private static String sid = "or6db";
	private static String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
	private static Connection connection;
	private static Statement statement;
	
	public DatabaseQuery() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		connection = DriverManager.getConnection(url, "cledbetter", "5381");
		statement = connection.createStatement();
	}
	
	public static ResultSet query(String query) {
		try {
			return statement.executeQuery("select * from siteuser");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

package com.github.phlank.cs346project5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseQuery {
	
	private static final String serverName = "csor6.dhcp.bsu.edu";
	private static final String portNumber = "1521";
	private static final String sid = "or6db";
	private static final String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
	private static Connection connection;
	private static Statement statement;
	
	public DatabaseQuery() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		connection = DriverManager.getConnection(url, "cledbetter", "5381");
		statement = connection.createStatement();
	}
	
	public static ResultSet queryDatabase(String query) {
		try {
			statement = connection.createStatement();
			ResultSet output = statement.executeQuery(query);
			return output;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

package com.github.phlank.cs346project5;
/*
 * Try this progam and make it working first.
 *
 * This sample can be used to check the JDBC installation.
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

class JdbcCheckup3 {
	public static void main(String args[]) throws SQLException, IOException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

		String serverName = "csor6.dhcp.bsu.edu";
		String portNumber = "1521";
		String sid = "or6db";
		String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		Connection connection = DriverManager.getConnection(url, "cledbetter", "5381");
		Statement statement = connection.createStatement();
		
		ResultSet queryResult = statement.executeQuery("select * from game");
		System.out.println("Game table:");
		System.out.println("---------------------------------------------------------------------------");
		while (queryResult.next()) {
			System.out.println();
		}
		queryResult.close();
		statement.close();
		connection.close();
	}

}
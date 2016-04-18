package com.github.phlank.cs346project5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ResultSetInterpreter {

	public static String interpretResultSet(ResultSet set) throws SQLException {
		int numCols = set.getMetaData().getColumnCount();
		String output = "";
		//Get the column names into the output string
		for (int i = 1; i <= numCols; i++) {
			output += set.getMetaData().getColumnLabel(i) + "   ";
		}
		output += "\n";
		//Add rows to output
		while (set.next()) {
			for (int i = 1; i <= numCols; i++) {
				output += set.getNString(i) + "   ";
			}
			output += "\n";
		}
		return output;
	}
	
}

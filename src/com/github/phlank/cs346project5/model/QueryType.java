package com.github.phlank.cs346project5.model;

import java.sql.SQLException;
import java.util.ArrayList;

import static com.github.phlank.cs346project5.model.ResultSetInterpreter.interpretResultSet;
import static com.github.phlank.cs346project5.model.DatabaseQuery.queryDatabase;

public enum QueryType {

	SELECT_ALL("Select All"), //
	SUBSTRING_MATCHING("Substring Match"), //
	DISTINCT("Distinct"), //
	GROUPS("Groups by Entities"), //
	SORTING("Sorting"), //
	SUM("Sum"), //
	MIN("Minimum"), //
	MAX("Maximum"), //
	AVG("Average"), //
	SELECT_COL("Select Column");

	private String menuText;

	QueryType(String menuText) {
		this.menuText = menuText;
	}

	@Override
	public String toString() {
		return menuText;
	}
	
	public String query(ArrayList<String> valuesList) throws SQLException {
		String[] values = new String[valuesList.size()];
		values = valuesList.toArray(values);
		switch (this.toString()) {
		case ("Select All"):
			return interpretResultSet(queryDatabase("select * from " + values[0]));
		case ("Substring Match"):
			return interpretResultSet(queryDatabase("select * from " + values[0] + " where " + values[1] + " like '" + values[2] + "'"));
		case ("Distinct"):
			return interpretResultSet(queryDatabase("select distinct " + values[1] + " from " + values[0]));
		case ("Groups by Entities"):
			break;
		case ("Sorting"):
			break;
		case ("Sum"):
			break;
		case ("Minimum"):
			break;
		case ("Maximum"):
			break;
		case ("Average"):
			break;
		case ("Select Column"):
			break;
		}
		return null;
	}

}

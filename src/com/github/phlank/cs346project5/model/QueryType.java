package com.github.phlank.cs346project5.model;

public enum QueryType {

	SELECT_ALL("Select All"),
	SUBSTRING_MATCHING("Substring Match"),
	COUNT_ENTRIES("Count Entries"),
	GROUPS("Groups by Entities"),
	SORTING("Sorting"),
	SUM("Sum"),
	MIN("Minimum"),
	MAX("Maximum"),
	AVG("Average"),
	SELECT_COL("Select Column");
	
	private String menuText;
	
	QueryType(String menuText) {
		this.menuText = menuText;
	}
	
	@Override
	public String toString() {
		return menuText;
	}
	
}

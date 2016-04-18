package com.github.phlank.cs346project5.model;

import java.util.ArrayList;
import static com.google.common.collect.Lists.newArrayList;

public enum Table {

	SITEUSER("Siteuser", newArrayList("Username", "FName", "MInit", "LName")), //
	MODERATOR("Moderator", newArrayList("MUsername", "Email")), //
	REVIEWER("Reviewer", newArrayList("RUsername")), //
	GAME("Game", newArrayList("GameID", "Title", "Platform0", "Platform1", "Platform2", "Platform3", "Platform4", "Developer", "Release_Date", "Genre")), //
	PLATFORM("Platform", newArrayList("PName", "Developer", "PDate")), //
	REVIEW("Review", newArrayList("ReviewID", "RUsername", "RGameID", "Content", "Rating")), //
	REVIEW_VIEW("Review_View", newArrayList("VUsername", "VReviewID", "Num_Views"));

	private String name;
	private ArrayList<String> headers;

	Table(String name) {
		this.name = name;
	}

	Table(String name, ArrayList<String> headers) {
		this.name = name;
		this.headers = newArrayList(headers);
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getHeaders() {
		return headers;
	}
	
	@Override
	public String toString() {
		return name;
	}

}

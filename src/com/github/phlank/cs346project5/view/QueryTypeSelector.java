package com.github.phlank.cs346project5.view;

import com.github.phlank.cs346project5.model.QueryType;

public class QueryTypeSelector extends javax.swing.JComboBox<QueryType> {

	private static final long serialVersionUID = 1636273198353865496L;

	public QueryTypeSelector() {
		super();
		this.addItem(QueryType.SELECT_ALL);
		this.addItem(QueryType.SUBSTRING_MATCHING);
		this.addItem(QueryType.COUNT_ENTRIES);
		this.addItem(QueryType.GROUPS);
		this.addItem(QueryType.SORTING);
		this.addItem(QueryType.SUM);
		this.addItem(QueryType.MIN);
		this.addItem(QueryType.MAX);
		this.addItem(QueryType.AVG);
		this.addItem(QueryType.SELECT_COL);
		this.setVisible(true);
	}

}
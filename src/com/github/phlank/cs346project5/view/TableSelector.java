package com.github.phlank.cs346project5.view;

import javax.swing.JComboBox;

import com.github.phlank.cs346project5.model.Table;

public class TableSelector extends JComboBox<Table> {

	private static final long serialVersionUID = -7951074262472220374L;

	public TableSelector() {
		super();
		this.addItem(Table.SITEUSER);
		this.addItem(Table.MODERATOR);
		this.addItem(Table.REVIEWER);
		this.addItem(Table.GAME);
		this.addItem(Table.PLATFORM);
		this.addItem(Table.REVIEW);
		this.addItem(Table.REVIEW_VIEW);
		this.setVisible(true);
	}

}

package com.github.phlank.cs346project5.view;

import javax.swing.JComboBox;

import com.github.phlank.cs346project5.model.Table;

public class TablePropertySelector extends JComboBox<String> {

	private static final long serialVersionUID = 333072732242432233L;

	public TablePropertySelector(Table table) {
		super();
		for (String s : table.getHeaders()) {
			this.addItem(s);
		}
	}

}

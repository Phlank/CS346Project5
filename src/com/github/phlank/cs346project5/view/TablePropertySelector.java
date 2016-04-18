package com.github.phlank.cs346project5.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.github.phlank.cs346project5.model.Table;

public class TablePropertySelector extends JComboBox<String> {

	private static final long serialVersionUID = 333072732242432233L;

	private TableSelector parentSelector;

	public TablePropertySelector(TableSelector parentSelector) {
		super();
		for (String s : ((Table) parentSelector.getSelectedItem()).getHeaders()) {
			this.addItem(s);
		}
		this.parentSelector = parentSelector;
		parentSelector.addActionListener(listener);
	}

	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "comboBoxChanged") {
				updateSelectorValues();
				System.out.println("comboBoxChanged");
			}
		}
	};
	
	private void updateSelectorValues() {
		this.removeAllItems();
		for (String s : ((Table) parentSelector.getSelectedItem()).getHeaders()) {
			this.addItem(s);
		}
	}

	public TableSelector getParentSelector() {
		return parentSelector;
	}

}

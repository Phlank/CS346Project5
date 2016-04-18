package com.github.phlank.cs346project5.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.github.phlank.cs346project5.model.DatabaseQuery;
import com.github.phlank.cs346project5.model.QueryType;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showMessageDialog;

import static com.google.common.collect.Lists.newArrayList;

public class GameReviewSiteExplorer extends JFrame {

	private static final long serialVersionUID = -9025005152165679008L;

	private class QueryTypeActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "comboBoxChanged") {
				onQueryChange();
			}
		}

	}

	private class SubmitButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				onSubmit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private class QueryPanelBorder implements Border {

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(10, 10, 10, 10);
		}

		@Override
		public boolean isBorderOpaque() {
			return false;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			return;
		}

	}

	private JPanel mainPanel;
	private JPanel queryPanel;
	private QueryTypeSelector queryTypeSelector;
	private QueryType currentType = QueryType.SELECT_ALL;
	private JButton submitButton;
	private DatabaseQuery dbQuery;
	private JTextArea queryTypeSelectorLabel = new JTextArea("Query type");

	public GameReviewSiteExplorer() throws SQLException {
		super();
		dbQuery = new DatabaseQuery();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initializeQuerySelectors();
		initializePanels();
		updateQueryPanel();
	}

	private void initializeQuerySelectors() {
		queryTypeSelectorLabel.setEditable(false);
		queryTypeSelector = new QueryTypeSelector();
		queryTypeSelector.addActionListener(new QueryTypeActionListener());
		queryTypeSelector.setVisible(true);
		queryTypeSelector.repaint();
	}

	private void initializePanels() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(queryTypeSelectorLabel);
		mainPanel.add(queryTypeSelector);
		mainPanel.setVisible(true);
		queryPanel = new JPanel();
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.Y_AXIS));
		queryPanel.setBorder(new QueryPanelBorder());
		mainPanel.add(queryPanel);
		submitButton = new JButton("Submit Query");
		submitButton.addActionListener(new SubmitButtonActionListener());
		mainPanel.add(submitButton);
		this.add(mainPanel);
		mainPanel.repaint();
	}

	private void onQueryChange() {
		currentType = (QueryType) queryTypeSelector.getSelectedItem();
		updateQueryPanel();
	}

	private void updateQueryPanel() {
		switch (currentType) {
		case SELECT_ALL:
			updateSelectAll();
			break;
		case SUBSTRING_MATCHING:
			updateSubstringMatching();
			break;
		case DISTINCT:
			updateDistinct();
			break;
		case GROUPS:
			// TODO: updateGroups()
			break;
		case MIN:
			// TODO: updateMin()
			break;
		case MAX:
			// TODO: updateMax()
			break;
		case AVG:
			// TODO: updateAvg()
			break;
		case SUM:
			// TODO: updateSum()
			break;
		case SELECT_COL:
			// TODO: updateSelectCol()
			break;
		case SORTING:
			// TODO: updateSorting()
			break;
		}
		this.pack();
	}

	private void updateSelectAll() {
		queryPanel.removeAll();
		JTextArea tableSelectorLabel = new JTextArea("Table:");
		tableSelectorLabel.setEditable(false);
		queryPanel.add(tableSelectorLabel);
		queryPanel.add(new TableSelector());
	}

	private void updateSubstringMatching() {
		queryPanel.removeAll();
		JTextArea tableSelectorLabel = new JTextArea("Table:");
		TableSelector table0 = new TableSelector();
		JTextArea propertySelectorLabel = new JTextArea("Property:");
		TablePropertySelector property0 = new TablePropertySelector(table0);
		JTextArea substringLabel = new JTextArea("Substring:");
		JTextField substring = new JTextField();
		queryPanel.add(tableSelectorLabel);
		queryPanel.add(table0);
		queryPanel.add(propertySelectorLabel);
		queryPanel.add(property0);
		queryPanel.add(substringLabel);
		queryPanel.add(substring);
	}

	private void updateDistinct() {
		queryPanel.removeAll();
		JTextArea tableSelectorLabel = new JTextArea("Table:");
		TableSelector table0 = new TableSelector();
		JTextArea propertySelectorLabel = new JTextArea("Property:");
		TablePropertySelector property0 = new TablePropertySelector(table0);
		queryPanel.add(tableSelectorLabel);
		queryPanel.add(table0);
		queryPanel.add(propertySelectorLabel);
		queryPanel.add(property0);
	}

	private void onSubmit() throws SQLException {
		String output = "";

		switch (currentType) {
		case SELECT_ALL:
			output = currentType
					.query(newArrayList(((TableSelector) queryPanel.getComponent(1)).getSelectedItem().toString()));
			break;
		case SUBSTRING_MATCHING:
			output = currentType
					.query(newArrayList((((TableSelector) queryPanel.getComponent(1)).getSelectedItem().toString()),
							((TablePropertySelector) queryPanel.getComponent(3)).getSelectedItem().toString(),
							((JTextField) queryPanel.getComponent(5)).getText()));
			break;
		case DISTINCT:
			output = currentType
					.query(newArrayList(((TableSelector) queryPanel.getComponent(1)).getSelectedItem().toString(),
							((TablePropertySelector) queryPanel.getComponent(3)).getSelectedItem().toString()));
		default:
			break;
		}
		showMessageDialog(null, output);
	}

	public static void main(String[] args) {
		GameReviewSiteExplorer siteExplorer;
		try {
			siteExplorer = new GameReviewSiteExplorer();
			siteExplorer.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

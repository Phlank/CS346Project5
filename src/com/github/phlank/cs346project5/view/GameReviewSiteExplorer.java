package com.github.phlank.cs346project5.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.phlank.cs346project5.model.DatabaseQuery;
import com.github.phlank.cs346project5.model.QueryType;

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

	private JPanel mainPanel;
	private JPanel queryPanel;
	private QueryTypeSelector queryTypeSelector;
	private QueryType currentType = QueryType.SELECT_ALL;
	private JButton submitButton;
	private DatabaseQuery dbQuery;

	public GameReviewSiteExplorer() throws SQLException {
		super();
		dbQuery = new DatabaseQuery();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		initializeQuerySelectors();
		initializePanels();
		updateQueryPanel();
	}

	private void initializeQuerySelectors() {
		queryTypeSelector = new QueryTypeSelector();
		queryTypeSelector.addActionListener(new QueryTypeActionListener());
		queryTypeSelector.setVisible(true);
		queryTypeSelector.repaint();
	}

	private void initializePanels() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(queryTypeSelector);
		mainPanel.setVisible(true);
		queryPanel = new JPanel();
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.Y_AXIS));
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
			//TODO: updateSubstringMatching()
			break;
		case COUNT_ENTRIES:
			//TODO: updateCountEntries()
			break;
		case GROUPS:
			//TODO: updateGroups()
			break;
		case MIN:
			//TODO: updateMin()
			break;
		case MAX:
			//TODO: updateMax()
			break;
		case AVG:
			//TODO: updateAvg()
			break;
		case SUM:
			//TODO: updateSum()
			break;
		case SELECT_COL:
			//TODO: updateSelectCol()
			break;
		case SORTING:
			//TODO: updateSorting()
			break;
		}
	}

	private void updateSelectAll() {
		queryPanel.removeAll();
		queryPanel.add(new TableSelector());
		queryPanel.repaint();
	}

	private void onSubmit() throws SQLException {
		String output = "";

		switch (currentType) {
		case SELECT_ALL:
			output = currentType
					.query(newArrayList(((TableSelector) queryPanel.getComponent(0)).getSelectedItem().toString()));
			System.out.println(queryPanel.getComponents()[0]);
			System.out.println(((TableSelector) queryPanel.getComponent(0)).getSelectedItem().toString());
			break;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

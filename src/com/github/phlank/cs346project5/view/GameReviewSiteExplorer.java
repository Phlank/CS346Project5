package com.github.phlank.cs346project5.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameReviewSiteExplorer extends JFrame {
	
	private JPanel panel;
	private QueryTypeSelector queryTypeSelector;
	
	public GameReviewSiteExplorer() {
		super();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		panel = new JPanel();
		this.add(panel);
		queryTypeSelector = new QueryTypeSelector();
		panel.add(queryTypeSelector);
	}

	public static void main(String[] args) {
		GameReviewSiteExplorer siteExplorer = new GameReviewSiteExplorer();
	}

}

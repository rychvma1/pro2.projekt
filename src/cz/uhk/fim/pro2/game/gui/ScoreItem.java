package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel{

	JLabel jLabelIndex, jLabelScore;
	
	public ScoreItem(int index, int score){
		jLabelIndex = new JLabel(index + ".");
		jLabelIndex.setBounds(0, 0, 100, 50);
		jLabelIndex.setFont(new Font("Arial", Font.BOLD, 40));
		add(jLabelIndex);
		
		
		jLabelScore = new JLabel(String.valueOf(score) + "!");
		jLabelScore.setBounds(120, 0, 200, 50);
		jLabelScore.setFont(new Font("Arial", Font.BOLD, 40));
		add(jLabelScore);
	}
}

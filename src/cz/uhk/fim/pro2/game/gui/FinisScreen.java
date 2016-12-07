package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.World;

public class FinisScreen extends Screen{

	JLabel jLabelScore;
	
	
	public FinisScreen(MainFrame mainFrame, World world) {
		super(mainFrame);
		
		int score = world.getBird().getScore();
		
		jLabelScore = new JLabel(score + "!");
		jLabelScore.setBounds(180, 120, 150, 160);
		jLabelScore.setFont(new Font("Arial", Font.BOLD, 24));
		add(jLabelScore);
		
		JButton JButtonHome = new JButton("Home");
		add(JButtonHome);
		ActionListener lsn1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
						}
		};
		JButtonHome.addActionListener(lsn1);
		JButtonHome.setBounds(100,600,280,50);
		JButtonHome.setFont(new Font("Arial", Font.PLAIN, 24));
		JButtonHome.setBackground(Color.RED);
		
		JButton JButtonStart = new JButton("Start");
		add(JButtonStart);
		ActionListener lsn2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
						}
		};
		JButtonStart.addActionListener(lsn2);
		
		//umiestnenie tlacitok
				JButtonStart.setBounds(100,500,280,50);
				
				JButtonStart.setFont(new Font("Arial", Font.PLAIN, 24));
				JButtonStart.setBackground(Color.RED);
				
				ScoreManager.putScore(score);
	}
	
	
	
}

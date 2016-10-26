package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomeScreen extends Screen {
	
	public HomeScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton JButtonPlay = new JButton("play");
		add(JButtonPlay);
		
		ActionListener lsn1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
						}
		};
		JButtonPlay.addActionListener(lsn1);
		
		
		JButton JButtonScore = new JButton("score");
		add(JButtonScore);
		ActionListener lsn2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
						}
		};
		JButtonScore.addActionListener(lsn2);
		
		JButton JButtonSound = new JButton("sound");
		add(JButtonSound);
		ActionListener lsn3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
						}
		};
		JButtonSound.addActionListener(lsn3);
		
		
		
	}
	
}

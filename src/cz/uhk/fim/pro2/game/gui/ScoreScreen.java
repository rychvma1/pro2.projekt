package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen {
	
	
	public ScoreScreen(MainFrame mainFrame){
		super(mainFrame);
		
		for(int i=0; i < ScoreManager.putAll().size();i++){
			System.out.println(ScoreManager.getInstance().putAll().get(i));
		}
		
		JButton JButtonBack = new JButton("back");
		add(JButtonBack);
		ActionListener lsn1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
						}
		};
		JButtonBack.addActionListener(lsn1);
		
		//umiestnenie tlacitok
				JButtonBack.setBounds(100,600,280,50);
				
				JButtonBack.setFont(new Font("Arial", Font.PLAIN, 24));
				JButtonBack.setBackground(Color.RED);
	}
}

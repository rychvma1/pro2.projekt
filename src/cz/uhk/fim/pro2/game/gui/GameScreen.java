package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameScreen extends Screen {
	
	public GameScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton JButtonBack = new JButton("back");
		add(JButtonBack);
		ActionListener lsn1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
						}
		};
		JButtonBack.addActionListener(lsn1);
		
		JButton JButtonPause = new JButton("pouse");
		add(JButtonPause);
		
		//umiestnenie tlacitok
				JButtonBack.setBounds(100,400,280,50);
				JButtonPause.setBounds(100,460,280,50);
				
				
	}
}

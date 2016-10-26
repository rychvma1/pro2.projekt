package cz.uhk.fim.pro2.game.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public static final int height = 800;
	public static final int width = 480;
	
	public MainFrame(){
		setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}
	
	
}

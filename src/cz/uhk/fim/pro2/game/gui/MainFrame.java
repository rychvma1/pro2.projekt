package cz.uhk.fim.pro2.game.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public static final int height = 800;
	public static final int width = 480;
	protected Screen actualScreen;

	public MainFrame() {
		setTitle("Flappy Bird");
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

	}

	public void setScreen(Screen screen) {
		if (actualScreen != null) {
			remove(actualScreen);
		}
		actualScreen = screen;
		add(screen);
		revalidate();
	}
}

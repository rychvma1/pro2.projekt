package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Srdce;
import cz.uhk.fim.pro2.game.model.Trubka;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainFrame) {
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

		// umiestnenie tlacitok
		JButtonBack.setBounds(100, 400, 280, 50);
		JButtonPause.setBounds(100, 460, 280, 50);

		Bird bird = new Bird("Flapy", 240, 400);
		World world = new World(bird);
		
		//trubky vo svete
		world.addTube(new Trubka(400, 400, Color.green));
		world.addTube(new Trubka(600, 300, Color.green));
		world.addTube(new Trubka(800, 500, Color.green));
		
		//srdcia vo svete
		world.addHearts(new Srdce(500, 450));
		world.addHearts(new Srdce(700, 600));
		
		GameCanvas gameCanvas = new GameCanvas(world);
		add(gameCanvas);
		gameCanvas.setBounds(0, 0, MainFrame.width, MainFrame.height);
		
		//System.out.println(world.toString());

	}
}

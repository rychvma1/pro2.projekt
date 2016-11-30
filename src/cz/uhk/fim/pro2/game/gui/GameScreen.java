package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.interfaces.WorldLisener;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Srdce;
import cz.uhk.fim.pro2.game.model.Trubka;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen implements WorldLisener {

	private long lastTimeMillies;
	private Timer timer;
	private Bird bird;
	private JLabel jLabelScore, jLabelLives;

	

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);

		JButton JButtonBack = new JButton("back");
		add(JButtonBack);
		ActionListener lsn1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		};
		JButtonBack.addActionListener(lsn1);

		JButton JButtonPause = new JButton("pouse");
		add(JButtonPause);

		JButtonPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (timer.isRunning()) {
					timer.stop();
				} else {
					lastTimeMillies = System.currentTimeMillis();
					timer.start();
				}
			}
		});

		// umiestnenie tlacitok
		JButtonBack.setBounds(50, 50, 100, 50);
		JButtonPause.setBounds(250, 50, 200, 50);

		JButtonBack.setFont(new Font("Arial", Font.PLAIN, 24));
		JButtonBack.setBackground(Color.RED);
		JButtonPause.setFont(new Font("Arial", Font.PLAIN, 24));
		JButtonPause.setBackground(Color.RED);

		bird = new Bird("Flapy", 240, 400);
		World world = new World(bird, this);

		jLabelLives = new JLabel("Lives: " + bird.getLives());
		jLabelScore = new JLabel("Score: " + bird.getScore());

		jLabelLives.setBounds(30, 720, 50, 50);
		jLabelScore.setBounds(230, 720, 150, 50);

		add(jLabelLives);
		add(jLabelScore);
		
		/*
		 * // trubky vo svete world.addTube(new Trubka(400, 400, Color.green));
		 * world.addTube(new Trubka(600, 300, Color.green)); world.addTube(new
		 * Trubka(800, 500, Color.green));
		 */
		
		world.generateRandom();
		// srdcia vo svete
		/*
		world.addHearts(new Srdce(500, 250));
		world.addHearts(new Srdce(700, 600));
*/
		
		GameCanvas gameCanvas = new GameCanvas(world);
		add(gameCanvas);
		gameCanvas.setBounds(0, 0, MainFrame.width, MainFrame.height);

		gameCanvas.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				bird.goUp();

			}

		});

		// System.out.println(world.toString());

		timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();

				float delta = (currentTimeMillis - lastTimeMillies) / 1000F;
				world.update(delta);

				jLabelLives.setText("Lives: " + bird.getLives());
				jLabelScore.setText("Score: " + bird.getScore());

				if (!bird.isAlive()) {
					timer.stop();
				}

				gameCanvas.repaint();

				lastTimeMillies = currentTimeMillis;

			}
		});

		lastTimeMillies = System.currentTimeMillis();
		timer.start();
		

	}

	@Override
	public void crashTube(Trubka tube) {
		bird.removeLive();
		bird.setPozY(tube.getCenterY());
		System.out.println("Naraz do trubky. Lives: " + bird.getLives());

	}

	@Override
	public void crashHeart(Srdce sr) {
		sr.setPozY(-100);
		bird.addLive();
		System.out.println("Vzal si srdce. Lives: " + bird.getLives());

	}

	@Override
	public void outOf() {
		System.out.println("Si mimo svet");
		bird.setPozY(400);
		bird.setSpeed(bird.JUMP / 2);
		bird.setLives(0);
		bird.isAlive();

	}
}

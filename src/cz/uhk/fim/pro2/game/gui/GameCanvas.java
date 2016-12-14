package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {

	private World world;
	public static final int UP = 20;
	public static final int DOWN = 50;
	private static final Color pozadie = Color.cyan;
	private static final Color zem = Color.DARK_GRAY;
	private static final Color nebo = Color.orange;
	private BufferedImage imgBird, imgHeart, imgBottom, imgBack, imgTop, imgTube;

	public GameCanvas(World world) {
		this.world = world;

		try {
			imgBird = ImageIO.read(new File("assets/bird.png"));
			imgTop = ImageIO.read(new File("assets/top.png"));
			imgHeart = ImageIO.read(new File("assets/heart.png"));
			imgBottom = ImageIO.read(new File("assets/bottom.png"));
			imgTube = ImageIO.read(new File("assets/tube.png"));
			imgBack = ImageIO.read(new File("assets/background.png")); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Nenacitalo obr");
		}

	
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	//	g.setColor(pozadie);
	//	g.fillRect(0, 0, MainFrame.width, MainFrame.height);
		g.drawImage(imgBack, 0, 0,  MainFrame.width, MainFrame.height, null);
		//g.setColor(nebo);
		//g.fillRect(0, 0, MainFrame.width, UP);
		g.drawImage(imgTop, 0, 0, MainFrame.width, UP, null);
		//g.setColor(zem);
		// g.fillRect(0, MainFrame.height-DOWN, MainFrame.width, DOWN);
		g.drawImage(imgBottom, 0, MainFrame.height - DOWN, MainFrame.width, DOWN, null);

		g.setColor(Color.BLUE);
		Bird bird = world.getBird();

		bird.paint(g, imgBird);
		List<Heart> hearts = world.getHearts();

		for (Heart h : hearts) {
			h.paint(g, imgHeart);

		}

		List<Tube> tubes = world.getTubes();

		for (Tube t : tubes) {
			t.paint(g, imgTube);
		}
	}

}

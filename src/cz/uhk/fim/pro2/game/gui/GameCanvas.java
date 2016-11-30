package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Srdce;
import cz.uhk.fim.pro2.game.model.Trubka;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {

	private World world;
	public static final int UP = 20;
	public static final int DOWN = 50;
	private static final Color pozadie = Color.cyan;
	private static final Color zem = Color.DARK_GRAY;
	private static final Color nebo = Color.orange;
	
	public GameCanvas(World world) {
		this.world = world;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(pozadie);
		g.fillRect(0, 0, MainFrame.width, MainFrame.height);
		g.setColor(nebo);
		g.fillRect(0, 0,  MainFrame.width, UP);
		g.setColor(zem);
		g.fillRect(0, MainFrame.height-DOWN,  MainFrame.width, DOWN);
		
		
		g.setColor(Color.BLUE);
		Bird bird = world.getBird();
		bird.paint(g);
		List<Srdce> hearts = world.getHearts();

		for (Srdce h : hearts) {
			h.paint(g);
		}
		
		List<Trubka> tubes = world.getTubes();
		
		for (Trubka t: tubes){
			t.paint(g);
		}
	}

}

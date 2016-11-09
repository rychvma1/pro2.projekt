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

	public GameCanvas(World world) {
		this.world = world;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
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

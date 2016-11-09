package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;

public class Srdce {

	private float pozX, pozY;

	public Srdce(float pozX, float pozY) {
		this.pozX = pozX;
		this.pozY = pozY;
	}

	public float getPozX() {
		return pozX;
	}

	public void setPozX(float pozX) {
		this.pozX = pozX;
	}

	public float getPozY() {
		return pozY;
	}

	public void setPozY(float pozY) {
		this.pozY = pozY;
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect((int) getPozX() - 25, (int) getPozY() - 25, 50, 50);
	}
	
	

}

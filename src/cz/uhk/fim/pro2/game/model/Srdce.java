package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

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
		Rectangle rect = getRect();
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public Rectangle getRect() {
		return new Rectangle((int) getPozX() - 25, (int) getPozY() - 25, 50, 50);
	}
	
		public void update(float deltaTime){
		pozX -= World.SPEED * deltaTime;
	}
		
		public static float getRandomY() {
			return (new Random().nextFloat() * 300) + 200;
		}

}

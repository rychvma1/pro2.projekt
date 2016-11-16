package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Trubka {

	private float pozX, pozY;
	private int height;
	private Color color;
	private static final int GAP = 200;

	public Trubka(float pozX, int height, Color color) {
		this.color = color;
		this.pozX = pozX;
		this.height = height;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		Rectangle rectH = getRectH();
		g.fillRect((int)rectH.getX(), (int)rectH.getY(), (int)rectH.getWidth(), (int) rectH.getHeight());
		
	//	g.fillRect((int) getPozX() - 25,  height, 50, (int) (MainFrame.height - height));
		//System.out.println((int) getPozX() - 25 + " " +  height + " " + 50 + " " + (int) (MainFrame.height - height));

		Rectangle rectD = getRectD();
		g.fillRect(rectD.x, rectD.y, rectD.width, rectD.height);
		//g.fillRect((int) getPozX() - 25, 0, 50,  (height - GAP));
	}
	
	public Rectangle getRectH() {
		return new Rectangle((int) getPozX() - 25,  height, 50, (int) (MainFrame.height - height));
	}
	
	public Rectangle getRectD() {
		return new Rectangle((int) getPozX() - 25, 0, 50,  (height - GAP));
	}
	
	public void update(float deltaTime){
		pozX -= World.SPEED * deltaTime;
		
	}

}

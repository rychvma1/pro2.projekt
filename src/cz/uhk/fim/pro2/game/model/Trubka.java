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
	private static final int WIDTH = 25;
	private boolean points;

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

	public boolean getPoints() {
		return points;
	}

	public void setPoints(boolean points) {
		this.points = points;
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

		Rectangle rectD = getRectD();
		g.fillRect(rectD.x, rectD.y, rectD.width, rectD.height);
	
	}
	
	public Rectangle getRectH() {
		return new Rectangle((int) getPozX() - WIDTH,  height, 50, (int) (MainFrame.height - height));
	}
	
	public Rectangle getRectD() {
		return new Rectangle((int) getPozX() - WIDTH, 0, 50,  (height - GAP));
	}
	
	public void update(float deltaTime){
		pozX -= World.SPEED * deltaTime;
		
	}
	
	public int getCenterY(){
		return (int) (height - GAP/2.0);
	}

	public int getMinX(){
		return (int) pozX - (WIDTH/2);
	}
	
	public int getMaxX(){
		return (int) pozX + (WIDTH/2);
	}
	
}

package cz.uhk.fim.pro2.game.model;

import java.awt.Color;

public class Trubka {

	private float pozX, pozY;
	private int height;
	private Color color;
	public Trubka(float pozX, float pozY, Color color) {
		this.color = color;
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
	
	
}

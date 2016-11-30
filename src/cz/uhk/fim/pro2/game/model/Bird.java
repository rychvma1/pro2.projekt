package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird {

	public static final int DEFAULT_SCORE=0;
	public static final int DEFAULT_LIVES=3;
	private String name;
	private float pozX, pozY;
	private int speed;
	private int lives;
	private int score;
	private static final int GRAVITY = 150;
	public static final int JUMP = 350;

	public Bird(String name, float pozX, float pozY) {
		this.name = name;
		this.speed = 0;
		this.lives = DEFAULT_LIVES;
		this.score = DEFAULT_SCORE;
		this.pozX = pozX;
		this.pozY = pozY;
	}

	public void goUp() {
		speed = JUMP;
	}

	public void take() {
		/*
		 * if(collideWith(Srdce sr)){ lives++; }
		 */

	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		Rectangle rect = getRect();
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}

	public Rectangle getRect() {
		return new Rectangle((int) getPozX() - 25, (int) getPozY() - 25, 50, 50);
	}

	public boolean collideWith(Trubka tube) {
		Rectangle rect = getRect();
		return rect.intersects(tube.getRectD()) || rect.intersects(tube.getRectH());
	}

	public boolean collideWith(Srdce sr) {
		return getRect().intersects(sr.getRect());
	}

	public boolean isOut() {
		// System.out.println(pozY);
		return pozY < 0 || pozY > 800;

	}
	
	public boolean isAlive(){
		return lives>0;
	}
	
	public void addPoint(){
		score++;
	}
	
	public void addLive() {
		this.lives++;
	}

	public void removeLive() {
		this.lives--;
	}

	public void update(float deltaTime) {
		// pozX += World.SPEED * deltaTime;
		pozY -= speed * deltaTime;
		pozY += GRAVITY * deltaTime;
		speed -= speed * deltaTime;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLives() {
		return this.lives;
	}

	public void setLives(int lifes) {
		this.lives = lifes;
	}

	public String getName() {
		return this.name;
	}

	
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

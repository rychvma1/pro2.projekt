package cz.uhk.fim.pro2.game.model;

public class Bird {

	private String name;
	private float pozX, pozY;
	private int speed;
	private int lives;
	
	public Bird(String name, float pozX, float pozY){
		this.name = name;
		this.speed = 0;
		this.lives = 3;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getName() {
		return name;
	}

	public void goUp(){
		
	}
	
	public void take(){
		
	}
	
	public void Hraj(){
		
	}
	
	public void addLive(){
		lives++;
	}
	
	public void removeLive(){
		lives--;
	}
}

package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {

	private Bird bird;
	private List<Trubka> tubes;
	private List<Srdce> hearts;
	public static final int SPEED = 100;
	
	public World(Bird bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}

	public void addTube(Trubka tube) {
		tubes.add(tube);
	}

	public void addHearts(Srdce srdce) {
		hearts.add(srdce);
	}

	public String toString() {
		/*
		 * meno vtaka pocet trubiek pocet srdci
		 */

		String meno = bird.getName();
		float pozX = bird.getPozX();
		float pozY = bird.getPozY();
		int pocetTrubiek = tubes.size();
		int pocetSrdci = hearts.size();

		return meno + " " + pozX + ";" + pozY + "\n" + " trubiek: " + pocetTrubiek + "\n" + " srdci: " + pocetSrdci;
	}

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}
	
	public List<Srdce> getHearts(){
		return hearts;
	}
	
	public List<Trubka> getTubes(){
		return tubes;
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);
	}
}

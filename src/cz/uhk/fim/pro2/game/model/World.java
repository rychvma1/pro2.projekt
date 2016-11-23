package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.interfaces.WorldLisener;

public class World {

	private Bird bird;
	private WorldLisener worldLisener;
	private List<Trubka> tubes;
	private List<Srdce> hearts;
	public static final int SPEED = 100;

	public World(Bird bird, WorldLisener worldLisener) {
		this.bird = bird;
		this.worldLisener = worldLisener;
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

	public List<Srdce> getHearts() {
		return hearts;
	}

	public List<Trubka> getTubes() {
		return tubes;
	}

	public void update(float deltaTime) {
		bird.update(deltaTime);

		if (bird.isOut()) {
			worldLisener.outOf();
		}

		for (Trubka tr : tubes) {
			tr.update(deltaTime);

			if (bird.collideWith(tr)) {
				worldLisener.crashTube(tr);
			} else {
				if (!tr.getPoints() && bird.getPozX() > tr.getMinX() && bird.getPozX() < tr.getMaxX()) {

					tr.setPoints(true);
					bird.addPoint();
					System.out.println("Skore:" + bird.getScore());
					System.out.println("--------");

				}
			}
		}
		for (Srdce sr : hearts) {
			sr.update(deltaTime);

			if (bird.collideWith(sr)) {
				worldLisener.crashHeart(sr);

			}
		}

	}
}

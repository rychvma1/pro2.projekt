package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.interfaces.WorldLisener;

public class World {

	private Bird bird;
	private WorldLisener worldLisener;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEARTS = 450;
	public static final int SPEED = 100;
	private boolean genereted;

	public World(Bird bird, WorldLisener worldLisener) {
		this.bird = bird;
		this.worldLisener = worldLisener;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}

	public void addTube(Tube tube) {
		tubes.add(tube);
	}

	public void addHearts(Heart srdce) {
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

	public List<Heart> getHearts() {
		return hearts;
	}

	public List<Tube> getTubes() {
		return tubes;
	}

	public void generateRandom() {
		for (int i = 0; i < 3; i++) {
			Tube tube = new Tube(SPACE_BETWEEN_TUBES + i * SPACE_BETWEEN_TUBES, (int) Tube.getRandomHeight(),
					Color.green);
			addTube(tube);
		}

		addHearts(new Heart(SPACE_BETWEEN_HEARTS, Heart.getRandomY()));

		genereted = true;
	}

	private void regenerate() {
		for (Tube tube : tubes) {
			if (tube.getPozX() < -100) {
				tube.setPozX(tube.getPozX() + tubes.size() * SPACE_BETWEEN_TUBES);
				tube.setHeight((int) Tube.getRandomHeight());
				tube.setPoints(false);
			}
		}

		for (Heart sr : hearts) {
			if (sr.getPozX() < -100) {
				sr.setPozX(sr.getPozX() + ((hearts.size()) + 2) * SPACE_BETWEEN_HEARTS);
				sr.setPozY(sr.getRandomY());
			}
		}
	}

	public void update(float deltaTime) {
		if(genereted){
			regenerate();
		}
		
		bird.update(deltaTime);

		
		if (bird.isOut()) {
			worldLisener.outOf();
		}

		for (Tube tr : tubes) {
			tr.update(deltaTime);

			if (bird.collideWith(tr)) {
				worldLisener.crashTube(tr);
			} else {
				if (!tr.getPoints() && bird.getPozX() > tr.getMinX() && bird.getPozX() < tr.getMaxX()) {

					tr.setPoints(true);
					bird.addPoint();

				}
			}
		}
		for (Heart sr : hearts) {
			sr.update(deltaTime);

			if (bird.collideWith(sr)) {
				worldLisener.crashHeart(sr);

			}
		}

	}
	
}

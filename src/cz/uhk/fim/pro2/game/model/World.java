package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {

	private Bird bird;
	private List<Trubka> tubes;
	private List<Srdce> hearts;
	
	public World(Bird bird){
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void addTube(Trubka tube){
		tubes.add(tube);
	}

	
	public void addHearts(Srdce srdce){
		hearts.add(srdce);
	}
}

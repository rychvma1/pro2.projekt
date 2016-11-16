package cz.uhk.fim.pro2.game.interfaces;

import cz.uhk.fim.pro2.game.model.Srdce;
import cz.uhk.fim.pro2.game.model.Trubka;

public interface WorldLisener {

	public void crashTube(Trubka tube);
	
	public void crashHeart(Srdce sr);
	
	public void outOf();
}

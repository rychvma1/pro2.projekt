package cz.uhk.fim.pro2.game.interfaces;

import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;

public interface WorldLisener {

	public void crashTube(Tube tube);
	
	public void crashHeart(Heart sr);
	
	public void outOf();
}

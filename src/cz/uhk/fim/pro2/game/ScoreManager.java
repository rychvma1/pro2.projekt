package cz.uhk.fim.pro2.game;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager {

	private List<Integer> scoreList;

	private ScoreManager() {
		this.scoreList = new ArrayList<Integer>();
	}
	
	public void addScore(int score){
		scoreList.add(score);
	}
	
	public List<Integer> getAll(){
		return scoreList;
	}
	
	//singelton
	private static ScoreManager instance;

	public static ScoreManager getInstance() {
		if (instance == null) {
			instance = new ScoreManager();
		}
		return instance;
	}


	public static void putScore(int score) {
		getInstance().addScore(score);
	}
	
	public static List<Integer> putAll(){
		return getInstance().getAll();
	}
}

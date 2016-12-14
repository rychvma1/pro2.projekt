package cz.uhk.fim.pro2.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreManager {

	private List<Integer> scoreList;

	private ScoreManager() {
		this.scoreList = new ArrayList<Integer>();
	}
	
	public void addScore(int score){
		
		List<Integer> scoreList = getAll();
		scoreList.add(score);
		
		try {
		//	FileWriter fileWriter = new FileWriter(Game.SCORE_FILE, true);
			FileWriter fileWriter = new FileWriter(Game.SCORE_FILE);
			
			for(int value : scoreList){
			fileWriter.append(String.valueOf(value));
			fileWriter.append(";");
			fileWriter.append(new Date().toGMTString());
			fileWriter.append("\n");
			
			fileWriter.flush();
			fileWriter.close();
			}
		} catch (IOException e) {
			System.out.println("Chyba pri zapise");
		}

		scoreList.add(score);
	}
	
	public List<Integer> getAll(){
		
		List<Integer> scoreList = new ArrayList<>();
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(Game.SCORE_FILE);
	
		BufferedReader bufferReader = new BufferedReader(fileReader);
		
		String line;
		while ((line = bufferReader.readLine()) != null){
			String[] values = line.split(";");
			scoreList.add(Integer.valueOf(values[0]));
		}
		} catch (Exception e) {
			System.out.println("Chyba pri nacitani");
		}
		
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
	
	public static int getScore(int index){
		return instance.putAll().get(index);
	}
	
	public static int size(){
		return instance.getAll().size();
	}
}

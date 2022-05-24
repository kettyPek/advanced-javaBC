package ajbc.pools_exercise;

import java.util.Map;

public class SeparateWordsToMap implements Runnable{
	
	Map<String,Integer> wordsMap;
	String [] wordsInLine;

	public SeparateWordsToMap(Map<String, Integer> wordsMap, String [] wordsInLine) {
		this.wordsMap = wordsMap;
		this.wordsInLine = wordsInLine;
	}

	@Override
	public void run() {
		for(var word : wordsInLine) {
			if(wordsMap.containsKey(word))
				wordsMap.put(word, wordsMap.get(word)+1);
			else
				wordsMap.put(word,1);
		}
	}
}

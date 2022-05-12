package ajbc.runner;

import java.util.PriorityQueue;

import ajbc.board.ScoreBoard;
import ajbc.gamers.Gamer;

public class Runner {

	public static void main(String[] args) {
		
		PriorityQueue<Gamer> gamers = new PriorityQueue<Gamer>();
		
		gamers.add(new Gamer("ketty","israel",50,2.5));
		gamers.add(new Gamer("dani","belarus",90,7));
		gamers.add(new Gamer("nikol","russia",90,5.8));
		gamers.add(new Gamer("lu","germany",100,2.5));
		
		
		ScoreBoard board = new ScoreBoard(gamers);
		
		board.displayTopGamers();
		
		board.sortedByNameList();
		board.sortedByCountryList();
		board.sortedByRankList();
		
		

	}

}

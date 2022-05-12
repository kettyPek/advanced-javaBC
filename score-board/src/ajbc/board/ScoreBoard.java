package ajbc.board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import ajbc.gamers.Gamer;

public class ScoreBoard {

	protected final int TOP_PLAYERS_NUM = 3;
	protected PriorityQueue<Gamer> gamers;
	protected ArrayList<Gamer> topGamers;
	protected Iterator<Gamer> gmaersIterator;

	public ScoreBoard(PriorityQueue<Gamer> gamers) {
		this.gamers = gamers;
		topGamers = new ArrayList<Gamer>(TOP_PLAYERS_NUM);
		updateTopPlayers();
	}

	public void addGamer(Gamer gamer) {
		gamers.add(gamer);
	}

	public void updateTopPlayers() {
		gmaersIterator = gamers.iterator();
		for (int i = 0; i < TOP_PLAYERS_NUM; i++)
			if (topGamers.size() == i)
				topGamers.add(gmaersIterator.next());
			else
				topGamers.set(i, gmaersIterator.next());
	}

	@Override
	public String toString() {
		return "top gamers: " + topGamers;
	}

	public void displayTopGamers() {
		updateTopPlayers();
		System.out.println(topGamers);
	}

	public void sortedByNameList() {

		Comparator<Gamer> nameComparator = new Comparator<Gamer>() {
			@Override
			public int compare(Gamer gamer1, Gamer gamer2) {
				return gamer1.getName().compareTo(gamer2.getName());
			}
		};
		System.out.println("Sorted by name:");
		sortGamersLis(nameComparator);
	}

	public void sortedByCountryList() {

		Comparator<Gamer> countryComparator = new Comparator<Gamer>() {
			@Override
			public int compare(Gamer gamer1, Gamer gamer2) {
				return gamer1.getCountry().compareTo(gamer2.getCountry());
			}
		};
		System.out.println("Sorted by country:");
		sortGamersLis(countryComparator);
	}
	
	public void sortedByRankList() {

		Comparator<Gamer> rankComparator = new Comparator<Gamer>() {
			@Override
			public int compare(Gamer gamer1, Gamer gamer2) {
				return -1*(int)(gamer1.getRank()-gamer2.getRank());
			}
		};
		System.out.println("Sorted by rank:");
		sortGamersLis(rankComparator);
	}
	
	
	
	private void sortGamersLis(Comparator<Gamer> nameComparator) {
		ArrayList<Gamer> gamersByName = new ArrayList<Gamer>();
		gamersByName.addAll(gamers);
		gamersByName.sort(nameComparator);
		System.out.println(gamersByName);
	}

}

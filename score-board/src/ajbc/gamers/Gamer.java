package ajbc.gamers;

import java.util.Objects;

public class Gamer implements Comparable<Gamer>{
	
	protected String name;
	protected String country;
	protected int score;
	protected float rank;
	
	public Gamer(String name, String country, int score, double rank) {
		this.name = name;
		this.country = country;
		this.score = score;
		setRank(rank);
	}
	
	private void setRank(double rank) {
		this.rank = (float)rank;
	}
	
	public float getRank() {
		return rank;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Gamer [name=" + name + ", country=" + country + ", score=" + score + ", rank=" + rank + "]\n";
	}
	

	@Override
	public int compareTo(Gamer gamer) {
        if(this.getScore()<gamer.getScore())
        	return 1;
        else if(this.getScore()>gamer.getScore())
        	return -1;
        else
        	return 0;
    }
	
	
	
	

}

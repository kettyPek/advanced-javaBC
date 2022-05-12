package javabootcamp.oop.player;

public class Player {
	
	private static int totalPoints;
	private static int numPlayers;
	private int points;
	private int lives;
	
	static {
		totalPoints = 0;
		numPlayers = 0;
	}
	
	public  Player() {
		setLives(3);
		setNumPlayers(numPlayers+1);

	}
	
	
	//methods
	private static void  setNumPlayers(int newNumPlayers) {
		if(newNumPlayers>=0 && newNumPlayers<=3)
			numPlayers = newNumPlayers;
	}
	
	private void setLives(int lives) {
		if(lives>=0 && lives<=5)
			this.lives = lives;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getLives() {
		return lives;
	}
	
	public static int getNumPlayer() {
		return numPlayers;
	}
	
	public static int getTotalPoints() {
		return totalPoints;
	}
	
	
	//Adding 100 or 150 points
	public void eatBonus() {
		int pointsToAdd = (int)(Math.random()*2)*50+100;
		addPoints(pointsToAdd);
	}
	
	//Subtracting 100 or 200 points, if more then 100 subtracted the player looses a live
	public void hitObstacale() {
		int pointsToSubtract = (int)(Math.random()*2)*100+100;
		subtractPoints(pointsToSubtract);
	}
	
	//Printing all values
	public void printAllValues()
	{
		System.out.println("points for player: " + points);
		System.out.println("lives left: "+ lives);
		System.out.println("total points: "+ totalPoints);
		System.out.println("currently playing: "+numPlayers);
	}
	
	//Adding numPoints to points and totalPoints, if numPoints bigger than 150 a live is added
	private void addPoints(int numPoints) {
		this.points += numPoints;
		totalPoints += numPoints;
		if(numPoints>150) 
			setLives(this.lives + 1);	
	}
	//Subtracting numPoints off points and totalPoints, if numPoints bigger than 100 a live is taken
	private void subtractPoints(int numPoints) {
		this.points -= numPoints;
		totalPoints -= numPoints;
		if(numPoints>100) 
			setLives(this.lives - 1);
		playerStatus();
	}
	
	private  void playerStatus() {
		if(this.lives == 0)
			setNumPlayers(numPlayers-1);
	}
	
}

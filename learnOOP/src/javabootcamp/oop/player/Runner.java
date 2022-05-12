package javabootcamp.oop.player;

public class Runner {

	public static void main(String[] args) {
		
		Player player1 = new Player();
		player1.printAllValues();
		
		Player player2 = new Player();
		player2.printAllValues();
		
		for(int i=1; i<=3; i++)
		{
			player1.eatBonus();
			player1.hitObstacale();
			System.out.println(player1.getPoints());
		}
		
		player1.printAllValues();
		
		

	}

}

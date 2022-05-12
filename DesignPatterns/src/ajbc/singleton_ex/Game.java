package ajbc.singleton_ex;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	
	private List<Player> players;
	private CardsPack cardsPack;
	
	public Game() {
		players = new ArrayList<Player>();
		this.cardsPack = CardsPack.getCardPack();
	}
	
	public void addPlayer(String name) {
		players.add(new Player(name));
	}
	
	
	public void playGame() {
		while(!cardsPack.getCards().isEmpty()) {
			battle();
		}
	}


	private void battle() {
		players.forEach(player -> player.takeRandomCard());
		System.out.println("------------------");
		players.forEach(System.out::println);
	}
	
	
}

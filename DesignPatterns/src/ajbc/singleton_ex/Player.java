package ajbc.singleton_ex;

public class Player {
	
	private String name;
	private int points;
	private int currentCard;
	private CardsPack cardsPack ;
	
	public Player(String name) {
		this.name = name;
		points = 0;
		currentCard = 0;
		this.cardsPack = CardsPack.getCardPack();
	}
	
	public void setCurrentCard(int currentCard) {
		this.currentCard = currentCard;
	}
	
	public int getCurretnCard() {
		return currentCard;
	}
	
	public void addPoint() {
		points++;
	}
	
	public void takeRandomCard() {
		currentCard = cardsPack.getRandomeCard();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", points=" + points + ", currentCard=" + currentCard + "]";
	}
	

}

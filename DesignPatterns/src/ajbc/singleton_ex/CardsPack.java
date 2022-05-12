package ajbc.singleton_ex;

import java.util.ArrayList;
import java.util.Collections;

public class CardsPack {
	
	private final int PACK_SIZE = 10;
	private ArrayList<Integer> cards;
	private static CardsPack instance = null;
	
	public static CardsPack getCardPack() {
		if(instance==null) {
			instance = new CardsPack();
		}
		return instance;	
	}
	
	public ArrayList<Integer> getCards(){
		return cards;
	}
	
	private CardsPack() {
		cards = new ArrayList<Integer>();
		for(int i=1; i<=PACK_SIZE; i++)
			cards.add(i);
	}
	
	public int getRandomeCard() {
		Collections.shuffle(cards);
		return cards.remove(0);
	}
	

}

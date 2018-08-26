import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

	ArrayList<Card> deck;
	
	 
	
	Deck() {
		makeDeck();
	} 
	
	public void makeDeck() {
		deck = new ArrayList<Card>();
		for (int i=0; i < 52; i++) {
			String suit = "Schoppen";
			int points = 6;
			String type = "9";
			deck.add(new Card(suit, type, points));
			Collections.shuffle(deck);
		}
	}
	
	
	
	

}

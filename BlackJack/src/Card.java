
public class Card {
	String suit;
	Value value;
	
	public Card(String suit, String type, int points){
		this.suit = suit;
		value = new Value(type, points);
	}
	
	
} 
 
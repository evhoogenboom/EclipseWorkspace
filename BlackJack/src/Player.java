import java.util.ArrayList;

public class Player {
	
	int handPoints;
	ArrayList<Card> handCards = new ArrayList(); // waarom moet "new arraylist"? kreeg anders nullpointer exception bij functie game.initialDraw
	boolean bank;
	
	
	Player() {
		System.out.println("gewone speler");
		
	}
	
	Player(String type) {
		if (type.equals("bank")) {
			System.out.println("bank!");
			bank = true;
		}
	}
	
	 
	void updateHand(Card card) {
		handCards.add(card);
		handPoints = calcHandPoints();
	}
	
	
	private int calcHandPoints() {
		int handPoints = 0;
		for (Card card : handCards) {
			handPoints += card.value.points;
		}
		return handPoints;
	}
	

}










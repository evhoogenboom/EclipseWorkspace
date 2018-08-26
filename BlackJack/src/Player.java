import java.util.ArrayList;

public class Player {
	
	int handPoints;
	ArrayList<Card> handCards = new ArrayList(); // waarom moet "new arraylist"? kreeg anders nullpointer exception bij functie game.initialDraw
	boolean bank;
	
	
	Player() {}
	
	Player(String type) {
		if (type.equals("bank")) {
			bank = true;
		}
	}
	
	 
	void updateHand(Card card) {
		handCards.add(card);
		handPoints = calcHandPoints();
		printHand();
	}
	
	
	private int calcHandPoints() {
		int handPoints = 0;
		for (Card card : handCards) {
			handPoints += card.value.points;
		}
		return handPoints;
	}
	
	
	public void printHand() {
		String type = bank ? "Bank" : "Player";
		System.out.print(type + ": ");
		for (int i=0;i<handCards.size();i++) {
			if (bank && i==0) {
				System.out.print("--" + "  " );
			} else {
				System.out.print(handCards.get(i).suit + "  " + handCards.get(i).value.type + " ");
			}
		}
		System.out.println();
	}

	
	public void printPoints() {
		System.out.println("Points: " + handPoints);
	}
	
}










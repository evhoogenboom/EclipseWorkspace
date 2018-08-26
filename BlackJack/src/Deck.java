
public class Deck {

	Card[] deck;
	 
	Deck() {
		deck = new Card[52];
		String[] suits = {"H","S","R","K"};
		String[] types = {"Boer", "Vrouw", "Koning", "Aas"};
		int addition = 0;
		for (String suit : suits) {
			int index = 0;
			for (int i=0, j=2; i<13; i++, j++) {
				int points;
				String type;
				if (i<9) {
					points = j;
					type = Integer.toString(j);
				} else {
					points = 10;
					type = types[index++];
					if (type.equals("Aas")) {
						points = 11;  // beetje lelijk maar ik had geen tijd meer
					}
				}
				Card card = new Card(suit,type,points);
				deck[i+addition] = card;
			}
			addition += 13;
		}
	} 
}

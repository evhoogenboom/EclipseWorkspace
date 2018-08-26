import java.util.ArrayList;

public class Game {

	Deck deck = new Deck(); // wordt deze elke keer aangemaakt als playGame wordt aangeroepen?
	
	ArrayList<Card> gameDeck = new ArrayList<Card>();
	Player player = new Player();
	Player bank = new Player("bank");
	
	public void playGame() {
		System.out.println("hoi");
		gameDeck = deck.deck; // als ik deze verander, verandert deck.deck dan ook?
		printCards(gameDeck);
		initialDraw();
		
	}
	
	
	public void printCards(ArrayList<Card> arrayList) {
		for (Card card : arrayList) {
			System.out.print(card.suit + " " + card.value.type + "  ");
		}
		System.out.println();
	}
	
	
	public void printBankCards(ArrayList<Card> arrayList) {
		for (int i=0;i<arrayList.size();i++) {
			if (i==0) {
				System.out.print("--" + "  " );
			} else {
				System.out.print(arrayList.get(i).suit + "  " + arrayList.get(i).value.type + " ");
			}
			
		}
	}
	
	
	public void initialDraw() {
		player.handCards.add(drawCard());
		bank.handCards.add(drawCard());
		player.handCards.add(drawCard());
		bank.handCards.add(drawCard());
		
		printCards(player.handCards);
		printBankCards(bank.handCards);
		
		bank.updateHandPoints();
		player.updateHandPoints();
		System.out.println(player.handPoints);
		
	}
	
	
	public Card drawCard() {
		Card card = gameDeck.get(0);
		gameDeck.remove(0);
		return card;
	}
	
/*
	public void drawCard(Player player) {
		Card card = gameDeck.get(0);
		gameDeck.remove(0);
		player.handCards.add(card);   // dit werkt niet zeker? Kan ik player.handCards aanspreken vanuit deze class op een andere manier?
	}
	
*/
	
		public void hit() {
			player.handCards.add(drawCard());
		}
		
		public void pass() {
			
		}
	
	
	
}

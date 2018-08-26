import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck(); // wordt deze elke keer aangemaakt als playGame wordt aangeroepen?
	ArrayList<Card> gameDeck = new ArrayList<Card>();
	Player player = new Player();
	Player bank = new Player("bank");
	boolean playAgain = true;
	
	
	
	public void playGame() {
		gameDeck = deck.deck; // als ik deze verander, verandert deck.deck dan ook? ja
		printCards(gameDeck);
		initialDraw();
		boolean oneMoreCard = makeMove();
		while (oneMoreCard) {
			hit();
			oneMoreCard = makeMove();
		}
		
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
		//player.handCards.add(drawCard());
		
		player.updateHand(drawCard());
		bank.updateHand(drawCard());
		player.updateHand(drawCard());
		bank.updateHand(drawCard());
		
		printCards(player.handCards);
		printBankCards(bank.handCards);
		
		System.out.println(player.handPoints);
		
	}
	
	
	public boolean makeMove() {
		String move = getPlayersMove();
		while (!move.equals("k") && !move.equals("p") && !move.equals("q")) {
			move = getPlayersMove();
		}
		System.out.println("out of while loop");
		boolean proceed = true;
		switch(move) {
		case "k":
			System.out.println("case k");
			//boolean proceed = true;  lijkt of deze out of scope gaat na switch statement
			// waarom niet proceed in statement declareren? kan wel met if-statement toch?
			break;
		case "q":
			playAgain = false;
			System.out.println("case q");
			// break expres weggelaten
		case "p": 
			proceed = false;  
			System.out.println("case p");
			break;
		}
		return proceed;
	}
	
	
	public String getPlayersMove() {
		System.out.println("What's your next move? (hit \"k\", pass \"p\" or quit \"q\")");
		return sc.nextLine();
	}
	
	
/*
	public void drawCard(Player player) {
		Card card = gameDeck.get(0);
		gameDeck.remove(0);
		player.handCards.add(card);   // dit werkt niet zeker? Kan ik player.handCards aanspreken vanuit deze class op een andere manier?
	}
	
*/
	
		public void hit() {
			player.updateHand(drawCard());
			System.out.println(gameDeck.size());
		}
		
		
		public Card drawCard() {
			Card card = gameDeck.get(0);
			gameDeck.remove(0);
			return card;
		}
	
	
}

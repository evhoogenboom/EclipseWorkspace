import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck(); // wordt deze elke keer aangemaakt als playGame wordt aangeroepen?
	// wat kan ik doen dat dit niet gebeurt?
	ArrayList<Card> gameDeck = new ArrayList<Card>();
	Player player = new Player();
	Player bank = new Player("bank");
	boolean play = true;
	
	
	 
	public void playGame() {
		setup();
		initialDraw();
		while (player.handPoints < 21 && hit()) {
			player.updateHand(drawCard());
			player.printPoints();
		}
		while (play && bank.handPoints <= 16) {
			bank.updateHand(drawCard());
		}
		if (play) {
			printWinner();
			askPlayAgain();
		}
	}

	
	public void setup() {
		gameDeck = deck.deck; // als ik deze verander, verandert deck.deck dan ook? ja
		printCards(gameDeck);
		player.handCards.clear();
		bank.handCards.clear();
		player.handPoints = 0;
		bank.handPoints = 0;
	}
	
	
	public void printCards(ArrayList<Card> arrayList) {
		for (Card card : arrayList) {
			System.out.print(card.suit + " " + card.value.type + "  ");
		}
		System.out.println();
	}
	
	
	public void initialDraw() {
		player.updateHand(drawCard());
		bank.updateHand(drawCard());
		player.updateHand(drawCard());
		bank.updateHand(drawCard());
	}
	
	
	public String getPlayersMove() {
		System.out.println("What's your next move? (hit \"k\", pass \"p\" or quit \"q\")");
		String move = sc.nextLine();
		while (invalidInput(move)) {
			System.out.println("invalid input");
			System.out.println("What's your next move? (hit \"k\", pass \"p\" or quit \"q\")");
			move = sc.nextLine();
			// getPlayersMove(); waarom print hij nog een keer invalid move voordat hij loop verlaat?
		}
		return move;
	}
	
	
	public boolean invalidInput(String move) {
		return !move.equals("k") && !move.equals("p") && !move.equals("q");
	}
	 
/*
	public void drawCard(Player player) {
		Card card = gameDeck.get(0);
		gameDeck.remove(0);
		player.handCards.add(card);   // dit werkt niet zeker? Kan ik player.handCards aanspreken vanuit deze class op een andere manier?
	}
	
*/
	/*
		public void hit() {
			player.updateHand(drawCard());
			System.out.println(gameDeck.size());
		}
		*/
		
		public Card drawCard() {
			Card card = gameDeck.get(0);
			gameDeck.remove(0);
			return card;
		}
	
		
		public boolean hit() {
			boolean hit = true;
			String move = getPlayersMove();
			switch(move) {
			case "k":
				//boolean hit = true;  lijkt of deze out of scope gaat na switch statement
				// waarom niet hit in statement declareren? kan wel met if-statement toch?
				break;
			case "q":
				play = false;
				// break expres weggelaten
			case "p": 
				hit = false;  
				break;
			}
			return hit;
		}
		
		
		public void askPlayAgain() {
			System.out.println("Play again? (yes or no) ");
			String answer = sc.nextLine();
			play = answer.equals("yes") ? true : false;
		}
		
		
		public void printWinner() {
			String winner = getWinner();
			System.out.println("The " + winner + " wins.");
		}
		
		
		public String getWinner() {
			String winner; // snap niet waarom dit werkt
			if (player.handPoints > 21) {
				winner = "bank";
			} else if (bank.handPoints <= 21 && bank.handPoints > player.handPoints){
				winner = "bank";
			} else {
				winner = "player";
			}
			return winner;
		}
}

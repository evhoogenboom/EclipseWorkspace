import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class home {
	

	
	public static void main(String[] args) {
		home hhome = new home();
		Game game = new Game(); 
		
		boolean continuePlaying = true;
		
		while (continuePlaying) {
			game.playGame();
			continuePlaying = hhome.askContinue();
		}
		
		
	}
	
	
	public boolean askContinue() {
		return false;
	}
	
	public void play(ArrayList<Card> deck) {
		
		drawCards(4);
		String move = getPlayersMove();
		System.out.println("you chose: " + move);
	}
	
	
	public void drawCards(int amount) {
		for (int i=0; i < amount; i++) {
			System.out.println(amount);
		}
	}
	
	
	public String getPlayersMove() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What's your next move? (q, x or y)");
		return sc.nextLine();
	}
	
	
	
	
}  

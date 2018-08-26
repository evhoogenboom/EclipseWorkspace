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
		
		
	
	}
	
	

	
	
	
	
}  

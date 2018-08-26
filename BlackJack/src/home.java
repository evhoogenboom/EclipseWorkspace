import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class home {
	
	public static void main(String[] args) {
		home hhome = new home();
		Game game = new Game(); 
		
		while (game.play) {
			game.playGame();
		}
		System.out.println("The game has ended.");
		
	}
	
	 
}  

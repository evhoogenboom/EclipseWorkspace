

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

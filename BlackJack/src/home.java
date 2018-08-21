import java.util.Scanner;
import java.util.Random;

public class home {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("voer woord in");
		String woord = sc.nextLine();
		System.out.println("voer letter in");
		String letter = sc.nextLine();
		
		Random random = new Random();
		int a = random.nextInt(35);
		System.out.println(a);
	}
} 

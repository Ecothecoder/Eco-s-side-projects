package ecocodingpackage;

import java.util.Scanner;

public class DndCharacterCreator {
private String name ="";
	public static void main(String[] args) {
		//pick name
		//pick class (determines health and stat boost)
		//pick weapon (how much attack you have)
		//get stats (choose which 3 you prefer)
		//print out sheet

	}
	
	public void nameGenerator() {
		System.out.println("Whats the name of our character?");
		Scanner input = new Scanner(System.in);
		name = input.next();
	}

}

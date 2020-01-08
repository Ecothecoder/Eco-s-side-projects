package ecocodingpackage;

import java.util.Scanner;

public class battlemap {
	Scanner input = new Scanner(System.in);
	private Menu menu;
	PKMNSHELL gaming = new PKMNSHELL();

	public battlemap(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		System.out.println("Whats your name?");
		String name = input.next();

		System.out.println("Whats the name of your opponent?");
		String opName = input.next();

		System.out.println("Who are you fighting with?");
		System.out.println("1) Corwin");
		System.out.println("2) Alina");
		System.out.println("3) Rai");
		System.out.println("4) Reilly");
		String pkmnname = input.next();
		pkmnname = pkmnname.toUpperCase();
		if (pkmnname.contains("CORWIN") || pkmnname.contains("1")) {
			System.out.println();
			System.out.println("Corwin's stats are: ATK 8 DEF 5 SPD 5 HP 45");
			System.out.println("Is this okay? Y/N");
			String answer = input.next();
			answer = answer.toUpperCase();
			if (answer.charAt(0) == 'Y') {
				answer = "corwin";
			}

			else if (pkmnname.contains("ALINA") || pkmnname.contains("2")) {
				System.out.println();
				System.out.println("Alina's stats are: ATK 9 DEF 4 SPD 4 HP 50");
				System.out.println("Is this okay? Y/N");
				answer = input.next();
				answer = answer.toUpperCase();
				if (answer.charAt(0) == 'Y') {
					answer = "alina";
				}
			} else if (pkmnname.contains("RAI") || pkmnname.contains("3")) {
				System.out.println();
				System.out.println("Rai's stats are: ATK 5 DEF 9 SPD 6 HP 45");
				System.out.println("Is this okay? Y/N");
				answer = input.next();
				answer = answer.toUpperCase();
				if (answer.charAt(0) == 'Y') {
					answer = "rai";
				}

				else if (pkmnname.contains("REILLY") || pkmnname.contains("4")) {
					System.out.println();
					System.out.println("Reilly stats are: ATK 6 DEF 5 SPD 9 HP 40");
					System.out.println("Is this okay? Y/N");
					answer = input.next();
					answer = answer.toUpperCase();
					if (answer.charAt(0) == 'Y') {
						answer = "reilly";
					}

					gaming.characterPicker(answer);
					gaming.badcharacterPicker();
					gaming.bonus();
					gaming.firstFighter();
					gaming.fight();
				}
			}
		}
	}
}

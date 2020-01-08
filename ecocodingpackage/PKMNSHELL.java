package ecocodingpackage;

import java.util.Scanner;

public class PKMNSHELL {// Make the methods return the Strings with what happened?

	public String name = "";

	public String opName = "";
	private String firstFighter = "";
	public String pkmnname = "";
	private String mainPKMN = "";
	private String badPKMN = "";
	private int giveUp = 0;
	private Scanner input = new Scanner(System.in);
	private int mainATK = 0;
	private int mainDEF = 0;
	private int mainSPD = 0;//make two classes that holds these items
	public int mainHP = 0;
	public int badHP = 0;
	private int badATK = 0;
	private int badDEF = 0;
	private int badSPD = 0;
	private double atkbo = -10;
	private double badatkbo = -10;
	private double blobo = -10;
	private double badblobo = -10;
	private String bonus = "";
	private String badbonus = "";
	private int item = 1;

	public void characterPicker(String answer) {// just sets the stats to the character
		if (answer == "corwin") {
			mainPKMN = "Corwin";
			mainATK = 8;
			mainDEF = 5;
			mainSPD = 5;
			mainHP = 45;
		} else if (answer == "alina") {
			mainPKMN = "Alina";
			mainATK = 19;
			mainDEF = 14;
			mainSPD = 2;
			mainHP = 150;
		}

		else if (answer == "rai") {
			mainPKMN = "Rai";
			mainATK = 5;
			mainDEF = 9;
			mainSPD = 6;
			mainHP = 45;
		}

		if (answer == "reilly") {
			mainPKMN = "Reilly";
			mainATK = 6;
			mainDEF = 5;
			mainSPD = 9;
			mainHP = 40;
		}

	}

	public void badcharacterPicker() {
		int done = 0;
		while (done == 0) {
			int choice = (int) (Math.random() * 4);
			if (choice == 0) {
				badPKMN = "Colt";
				badATK = 8;
				badDEF = 5;
				badSPD = 5;
				badHP = 45;
				done++;
			}

			if (choice == 1) {
				badPKMN = "Hex";
				badATK = 9;
				badDEF = 4;
				badSPD = 4;
				badHP = 50;
				done++;
			}

			if (choice == 2) {
				badPKMN = "Mia";
				badATK = 5;
				badDEF = 9;
				badSPD = 6;
				badHP = 45;
				done++;
			}

			if (choice == 3) {
				badPKMN = "Teanna";
				badATK = 6;
				badDEF = 5;
				badSPD = 9;
				badHP = 40;
				done++;
			}

		}

	}

	public void firstFighter() {
		System.out.println();
		System.out.println("**************");
		System.out.println("CHANCE TIME!");
		System.out.println("**************");
		System.out.println();
		System.out.println("Let's see who goes first!");
		if (mainSPD > badSPD) {
			System.out.println("It's : " + name + " with " + mainPKMN);
			firstFighter = name;
		} else if (mainSPD < badSPD) {
			System.out.println("It's : " + opName + " with " + badPKMN);
			firstFighter = opName;
		} else if (mainSPD == badSPD) {
			System.out.println("It's a draw! FLIP THE COIN!");
			double coin = Math.random();
			if (coin > 0.5) {
				System.out.println("It's : " + name + " with " + mainPKMN);
				firstFighter = name;
			} else {
				System.out.println("It's : " + opName + " with " + badPKMN);
				firstFighter = opName;
			}
		}
		System.out.println("Press enter to continue!");
		String space = input.next();
	}

	public void bonus() {
		System.out.println();
		System.out.println("**************");
		System.out.println("BONUS TIME!");
		System.out.println("**************");
		System.out.println();
		System.out.println("Now let's see what our bonus add on is!");
		double ran = Math.random();
		if (ran >= 0 && ran <= .2) {
			bonus = "ATK+";
			mainATK += mainATK / 2;
		} else if (ran > .2 && ran <= .4) {
			bonus = "DEF+";
			mainDEF += mainDEF / 2;
		} else if (ran > .4 && ran <= .6) {
			bonus = "ITEM+";
			item++;
		} else if (ran > .6 && ran <= .8) {
			bonus = "2ATK";
			double atkbo = .2;
		} else if (ran > .8 && ran <= 1) {
			bonus = "BLOCK";
			double blobo = .2;
		}
		System.out.println("Your bonus is: " + bonus);
		System.out.println("Press enter to continue!");
		String space = input.next();

		ran = Math.random();
		if (ran >= 0 && ran <= .2) {
			badbonus = "ATK+";
			badATK += badATK / 2;
		} else if (ran > .2 && ran <= .4) {
			badbonus = "DEF+";
			badDEF += badDEF / 2;
		} else if (ran > .4 && ran <= .6) {
			badbonus = "ITEM+";
			item++;
		} else if (ran > .6 && ran <= .8) {
			badbonus = "2ATK";
			double badatkbo = .2;
		} else if (ran > .8 && ran <= 1) {
			badbonus = "BLOCK";
			double badblobo = .2;
		}
		System.out.println("Your opponent's bonus is: " + badbonus);
		System.out.println("Press enter to continue!");
		space = input.next();

	}

	public void fight() {
		System.out.println();
		System.out.println("**************");
		System.out.println("BATTLE TIME!");
		System.out.println("**************");
		System.out.println();
		if (firstFighter == name) {
			while (mainHP > 0 || badHP > 0 || giveUp == 1) {
				mainAttack();

				if (badHP <= 0 || giveUp == 1) {
					break;
				} else {
					badAttack();

				}
			}
		} else if (firstFighter == opName) {
			while (mainHP > 0 || badHP > 0 || giveUp == 1) {
				badAttack();
				if (badHP <= 0 || giveUp == 1) {
					break;
				} else {
					mainAttack();

				}
			}
		}

		if (mainHP <= 0) {
			System.out.println("Thanks for playing, but " + opName + " won, try again next time!");
		} else if (badHP <= 0) {
			System.out.println("CONGLATURATIONS! " + name + " YOU'RE WINNER!");
		}
	}

	private void badAttack() {
		double ran = Math.random();
		double ranbo = Math.random();
		System.out.println();
		System.out.println(badPKMN + " Attacks!");
		if (badHP < 15 && item > 0) {
			item--;
			badHP += 20;
			System.out.println(badPKMN + " healed! Current HP : " + badHP);
		} else if (ran < .1) {
			System.out.println("THEY MISSED! FANTASTIC!");
		} else if (ran >= .1 && ran <= .9) {
			if (ranbo <= blobo) {
				System.out.println("YOU BLOCKED!");
			} else
				mainHP -= badATK;
			System.out.println("They hit! " + mainPKMN + " now has " + mainHP + "HP!");
			if (ranbo <= badatkbo) {
				mainHP -= badATK;
				System.out.println(ranbo);
				System.out.println("THEY HIT TWICE! " + mainPKMN + " HAS " + mainHP + "HP!");
			}

		} else if (ran > .9) {
			mainHP -= badATK * 2;
			System.out.println("CRITICAL HIT! " + mainPKMN + " now has " + mainHP + "HP!");
		}
	}

	private void mainAttack() {
		int choice;
		System.out.println();
		System.out.println("What will you do?!");
		System.out.println("1) Attack!");
		System.out.println("2) Heal!");
		System.out.println("3) GIVE UP!");
		choice = input.nextInt();
		System.out.println();
		if (choice == 1) {
			double ran = Math.random();
			double ranbo = Math.random();
			if (ran < .1) {
				System.out.println("YOU MISSED! OH NO!");
			} else if (ran >= .1 && ran <= .9) {
				if (ranbo <= badblobo) {
					System.out.println("THEY BLOCKED!");
				} else
					badHP = badHP - mainATK;
				System.out.println("You hit! " + badPKMN + " now has " + badHP + "HP!");
				if (ranbo <= atkbo) {
					badHP -= mainATK;
					System.out.println("YOU HIT TWICE! " + badPKMN + " HAS " + badHP + "HP!");
				}
			} else if (ran > .9) {
				badHP = badHP - mainATK * 2;
				System.out.println("CRITICAL HIT! " + badPKMN + " now has " + badHP + "HP!");
			}

		} else if (choice == 2 && item >= 0) {
			if (item > 0) {
				item--;
				mainHP = mainHP + 20;
				System.out.println("You healed! Now you have " + mainHP + "HP!");
			} else {
				System.out.println("You are out of heals!");
			}
		} else if (choice == 3) {
			System.out.println("IT'S OKAY YOU WILL GET THEM NEXT TIME!!");
			giveUp = 1;
		} else {
			System.out.println("THAT'S NOT A COMMAND LOSE A TURN!");
		}
	}

}

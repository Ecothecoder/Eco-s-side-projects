package ecocodingpackage;

import java.util.Scanner;

public class WeatherChecker {

	public WeatherChecker() {
	}

	public static void main(String[] args) {
		// public String printTheWeather() {

		System.out.println("Which temperature type do you prefer? (F) or (C)");
		Scanner input = new Scanner(System.in);
		String temper = input.next();
		// String response = "";
		System.out.println("Sweet, now what is the temperature?");
		int degrees = input.nextInt();

		if (degrees < 32 && temper.charAt(0) == 'F') {
			System.out.println("STAY INSIDE IT'S FREEZING!");}
		else if (degrees > 32 && temper.charAt(0) =='F' && degrees <= 65 && temper.charAt(0) == 'F') {
			System.out.println("Add some layers, it's still cold or breezy");}
		else if (degrees > 65 && temper.charAt(0) == 'F' && degrees <= 90 && temper.charAt(0) == 'F') {
			System.out.println("Today is the day for a t-shirt and shorts!");}
		else if (degrees > 90 && temper.charAt(0) == 'F' && degrees <= 100 && temper.charAt(0) == 'F') {
			System.out.println("STAY HYDRATED! It's gonna be a scorcher");}
		else if (degrees > 100 && temper.charAt(0) == 'F') {
			System.out.println("It's hell on Earth! Don't leave the house! Pray for forgiveness!");}
		else
			System.out.println("lol what are you trying to pull?");
		// tell you the fun fact of how it converts to the other type
	}

}

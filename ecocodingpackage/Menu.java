package ecocodingpackage;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options,String[] options2) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options,options2);
			choice = getChoiceFromUserInput(options,options2);
			}

		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options, String[] options2) {
		Object choice = null;
		Object zero = 0;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption <= options.length) {
				if (selectedOption==0) {
					System.exit(0);}
				choice = options[selectedOption - 1];
		
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}

		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options,String[] options2) {
		out.println();
		
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		if(i==options.length-1) {
			if (options2.length==0) {
				out.println("");}
			else
			out.println("0) "+options2[0]);
		}}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
}

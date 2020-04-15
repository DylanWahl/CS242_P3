package spellchecker;

import java.io.File;
import java.util.Scanner;

public class ConsoleInterface {

	public static void main(String[] args) {
		int editDistance;
		Scanner scanner = new Scanner(System.in);
		if(args.length == 0) {
			editDistance = 2;
		}else {
			editDistance = Integer.valueOf(args[0]);			
		}
		
		System.out.println("Please input a word to check the spelling: ");
		String word = scanner.nextLine();
		
		File file = new File("resources\\lexicon.txt");
	}

}

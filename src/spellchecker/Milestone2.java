package spellchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Milestone2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("resources\\lexicon.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> lex = new ArrayList<String>();
		
		while(scanner.hasNext()) {
			lex.add(scanner.next());
		}
		
		SpellChecker spellChecker = new SpellChecker(lex);
		boolean thisFound = spellChecker.spelledCorrectly("tod");
		System.out.println(thisFound);
	}

}

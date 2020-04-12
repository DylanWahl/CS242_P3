package spellchecker;

import java.util.Scanner;

public class Milestone1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your first word ('0' to exit): ");
		String firstWord = scanner.nextLine();
		while(!firstWord.equals("0")) {
			System.out.print("Please enter your second word: ");
			String secondWord = scanner.nextLine();
			System.out.println(SpellChecker.editDistance(firstWord, secondWord));
			System.out.print("Please enter your first word ('0' to exit): ");
			firstWord = scanner.nextLine();
		}

	}

}


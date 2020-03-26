package spellchecker;

import java.util.List;

public class SpellChecker {

	public SpellChecker(List<String> list) {

	}

	public boolean spelledCorrectly(String word) {
		return false;
	}

	public List<String> suggestWords(String word, int maxEditDistance) {
		return null;
	}

	public static int editDistance(String s1, String s2) {
		int distance = 0;
		

		return distance;
	}
	
	private int distance(String s1, String s2, int distance) {
		if (s1.length() == 0) {
			distance = s2.length();
		} else if (s2.length() == 0) {
			distance = s1.length();
		} else if (!s1.equalsIgnoreCase(s2)) {
			
		}
	}

	public static List<String> suggestWordsTest(String word, int maxEditDistance, List<String> lexicon) {
		return null;
	}
}

package spellchecker;

import java.util.ArrayList;
import java.util.Collections;
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
		int d = 0;
		return distance(s1.toLowerCase(), s2.toLowerCase(), d);
	}

	private static int distance(String s1, String s2, int d) {
		if (s1.length() == 0) {
			d += s2.length();
		} else if (s2.length() == 0) {
			d += s1.length();
		} else if (!s1.equals(s2)) {
			char s1Last = s1.charAt(s1.length() - 1);
			char s2Last = s2.charAt(s2.length() - 1);

			if (s1Last == s2Last) {
				d += distance(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), d);
			} else {
				ArrayList<Integer> RCValues = new ArrayList<Integer>(3);

				RCValues.add(distance(s1.substring(0, s1.length() - 1), 
						s2.substring(0, s2.length() - 1), d) + 1);
				RCValues.add(distance(s1, s2.substring(0, s2.length() - 1), d));
				RCValues.add(distance(s1.substring(0, s2.length() - 1), s2, d));
				d += Collections.min(RCValues);

			}
		}
		return d;
	}

	public static List<String> suggestWordsTest(String word, int maxEditDistance, List<String> lexicon) {
		return null;
	}
}

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
		
		int[][] table  = new int [s1.length()+ 1][s2.length() + 1];
		
		table[0][0] = 0;
		for(int i = 0; i <= s1.length(); i++) {
			table[i][0] = i;
		}
		for(int j = 0; j <= s2.length(); j++) {
			table[0][j] = j;
		}
		
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				ArrayList<Integer> RCValues = new ArrayList<Integer>(3);
				int removeBothOffset = 1;
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					removeBothOffset = 0;
				}
				
				RCValues.add(table[i-1][j] + 1);
				RCValues.add(table[i][j-1] + 1);
				RCValues.add(table[i - 1][j - 1] + removeBothOffset);
				table[i][j] = Collections.min(RCValues);
			}
		}
		
		return table[s1.length()][s2.length()];
	}

	public static List<String> suggestWordsTest(String word, int maxEditDistance, List<String> lexicon) {
		return null;
	}
}

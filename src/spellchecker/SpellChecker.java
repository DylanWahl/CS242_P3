package spellchecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SpellChecker {

	List<String> lexicon;
	Node root;

	public SpellChecker(List<String> list) {
		lexicon = list;
		root = new Node();
	}

	private void buildTree() {

		for (String s : lexicon) {
			addWord(root, s, 0);
		}
	}
	//base case........ 
	private void addWord(Node root, String word, int edgeIndex) {
		boolean edgeFound = false;
		Node newRoot = null;
		LinkedList<Node> rootChildren = root.getChildren();
		
		for (int i = 0; i < rootChildren.size() && edgeFound == false; i++) {
			if (word.charAt(edgeIndex) == rootChildren.get(i).getEdge()) {
				edgeFound = true;
				newRoot = rootChildren.get(i);
			}
		}
		if (!edgeFound) {
			newRoot = new Node(word.charAt(edgeIndex), word.substring(0, edgeIndex++));
			rootChildren.add(newRoot);
			
		}
		addWord(newRoot, word, edgeIndex++);
	}

	public boolean spelledCorrectly(String word) {
		boolean found = false;

		return found;
	}

	public List<String> suggestWords(String word, int maxEditDistance) {
		return null;
	}

	public static int editDistance(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int[][] table = new int[s1.length() + 1][s2.length() + 1];

		table[0][0] = 0;
		for (int i = 0; i <= s1.length(); i++) {
			table[i][0] = i;
		}
		for (int j = 0; j <= s2.length(); j++) {
			table[0][j] = j;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				ArrayList<Integer> RCValues = new ArrayList<Integer>(3);
				int removeBothOffset = 1;
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					removeBothOffset = 0;
				}

				RCValues.add(table[i - 1][j] + 1);
				RCValues.add(table[i][j - 1] + 1);
				RCValues.add(table[i - 1][j - 1] + removeBothOffset);
				table[i][j] = Collections.min(RCValues);
			}
		}

		return table[s1.length()][s2.length()];
	}

	public static List<String> suggestWordsTest(String word, int maxEditDistance, List<String> lexicon) {
		return null;
	}

	private class Node {

		private LinkedList<Node> children;
		private String word;
		private char edgeLetter;
		private boolean isPartial;

		Node() {
		}

		Node(char edgeLetter, String word) {
			this.edgeLetter = edgeLetter;
			word = word;
			isPartial = lexicon.contains(word);
		}

		public void addChild(Node newChild) {
			children.add(newChild);
		}

		public LinkedList<Node> getChildren() {
			return children;
		}

		public boolean isPartial() {
			return isPartial;
		}

		public String getData() {
			return word;
		}
		public char getEdge() {
			return edgeLetter;
		}

	}

}

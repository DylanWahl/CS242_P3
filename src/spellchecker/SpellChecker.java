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
		buildTree();
	}

	private void buildTree() {

		for (String s : lexicon) {
			addWord(root, s, 0);
		}
	}

	private void addWord(Node root, String word, int edgeIndex) {
		// base case
		// possible alternate base case (edgeIndex == word.length() - 1
		//if (edgeIndex == word.length() - 1) {
		if (root.getData().equals(word)) {
			root.setIsPartial();
		} else {
			Node newRoot = null;
			ArrayList<Node> rootChildren = root.getChildren();

			boolean edgeFound = false;
			if (rootChildren != null) {
				for (int i = 0; i < rootChildren.size() && edgeFound == false; i++) {
					if (rootChildren.get(i).getEdge() == word.charAt(edgeIndex)) {
						newRoot = rootChildren.get(i);
						edgeFound = true;
					}
				}
			}
			if (!edgeFound) {
				newRoot = new Node(word.substring(0, edgeIndex + 1));
			}
			root.addChild(newRoot);
			addWord(newRoot, word, edgeIndex + 1);
		}
	}

	public boolean spelledCorrectly(String word) {
		boolean found = false;

		return findWord(root, word);
	}

	private boolean findWord(Node root, String word) {
		boolean found = false;
		if (root.getData().equals(word) && !root.isPartial()) {
			found = true;
		} else {
			ArrayList<Node> rootChildren = root.getChildren();
			Node newRoot = null;

			if (rootChildren != null) {
				boolean edgeFound = false;
				for (int i = 0; i < rootChildren.size() && edgeFound == false; i++) {
					if (word.equals(rootChildren.get(i).getData())) {
						if(!rootChildren.get(i).isPartial()) {
							found = true;
						}
					} else if (word.startsWith(rootChildren.get(i).getData())) {
						newRoot = rootChildren.get(i);
						edgeFound = true;
						found = findWord(newRoot, word);
					}
				}
			}
		}

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

		private ArrayList<Node> children;
		private String word;
		private char edgeLetter;
		private boolean isPartial;

		Node() {
			children = null;
			word = "";
		}

		Node(String word) {
			children = new ArrayList<Node>();
			this.word = word;
			edgeLetter = word.charAt(word.length() - 1);
			isPartial = true;
		}

		public void addChild(Node newChild) {
			if (children == null) {
				children = new ArrayList<Node>();
			}
			children.add(newChild);
		}

		public ArrayList<Node> getChildren() {
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

		public void setIsPartial() {
			isPartial = false;
		}

	}

}

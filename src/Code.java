package src;

import java.util.*;

public class Code{
	public String DictionarySearch(String letters){
		String Words = "";
		private Dictionary dictMal;
		
		public Code(Dictionary dc) {
			this.dictMal = dc;
		}
		
		boolean[] Used = new boolean[letters.length()];
		String ActualWord;
		int Number = letters.length();
		
		for (int i = 0; i <= letters.length(); i++) {
			Used[i] = false;
		}
		
		for (int i = 0; i <= letters.length(); i++) {
			DictionarySearchRec(Used, "", i, letters);
		}
		
		return "";
	}
	
	public String DictionarySearchRec(boolean[] Used, String ActualWord, int Number, String letters) {
		for (int i = 0; i<= letters.length(); i++) {
			if (Used[i] == false) {
				String NewWord = ActualWord + letters[i];
				if (Number-1 == 0 ) {
					if (Dictionary.contains(NewWord)) {
						Words += NewWord;
					}
				}
			}
			Used[i] = true;
			DictionarySearchRec(letters, Used, NewWord, Number-1);
			Used[i] = false;
		}
	}
}
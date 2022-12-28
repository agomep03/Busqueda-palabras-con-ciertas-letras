package src;

import java.util.*;

public class Code{
	private Dictionary dictMal;
	
	public Code(Dictionary dc) {
		this.dictMal = dc;
	}
	
	public String DictionarySearch(String letters){
		String Words = "";
		boolean[] Used = new boolean[letters.length()];
		String ActualWord;
		int Number = letters.length();
		
		for (int i = 0; i < letters.length(); i++) {
			Used[i] = false;
		}
		
		for (int i = 0; i < letters.length(); i++) {
			Words += DictionarySearchRec(Used, "", i, letters );
		}
		
		return Words;
	}
	
	public String DictionarySearchRec(boolean[] Used, String ActualWord, int Number, String letters) {
		String Words = "";
		for (int i = 0; i<= letters.length(); i++) {
			if (Used[i] == false) {
				String NewWord = ActualWord + letters.charAt(i);
				if (Number-1 == 0 ) {
					if (dictMal.contains(NewWord)) {
						Words += NewWord;
					}
				}
				Used[i] = true;
				Words += DictionarySearchRec(Used, NewWord, Number-1, letters );
				Used[i] = false;
			}
		}
		return Words;
	}
}
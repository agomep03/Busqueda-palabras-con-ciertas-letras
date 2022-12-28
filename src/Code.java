import java.util.*;

public class Code{
	String letters = "Alo";
	boolean[] Used = new boolean[letters.length()];
	String ActualWord;
	int Number = letters.length();
	String Words;
	public String DictionarySearch(){
		
		for (int i = 0; i <= letters.length(); i++) {
			Used[i] = false;
		}
		
		for (int i = 0; i <= letters.length(); i++) {
			DictionarySearchRec(Used[i], "", i);
		}
		
		return "";
	}
	
	public String DictionarySearchRec(Used[], ActualWord, Number) {
		for (int i = 0; i<= letters.length(); i++) {
			if (Used[i] == false) {
				NewWord = ActualWord + letters[i];
				if ((Number-1) =0 ) {
					if (Dictionary.contains(NewWord)) {
						Words += NewWord;
					}
				}
			}
			Used[i] = True;
			DictionarySearchRec(Letters, Used, NewWord, Number-1);
			Used[i] = False;
		}
	}
}
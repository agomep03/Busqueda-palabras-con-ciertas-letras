package src;

public class Code2 {
	
	private Dictionary dict;
	
	public Code2(Dictionary dc) {
		this.dict = dc;
	}
	
	
	public String DictionarySearch(char[] letters) {
		boolean[] used = new boolean[letters.length];
		
		for(int i = 0; i < used.length; i++) {
			used[i] = false;
		}
		
		return DictionarySearchRec(letters, used, "");
	}
	
	public String DictionarySearchRec(char[] letters, boolean[] used, String actualWord) {
		StringBuffer words = new StringBuffer();
		
		StringBuffer newWord = new StringBuffer();
		
		for(int i = 0; i < letters.length; i++) {
			if(used[i] = false) {				
				newWord.append(actualWord + letters[i]);				
				used[i] = true;
				
				if(this.dict.contains(newWord.toString())) {
					words.append(newWord);
				}
				
				if(words.length() < (letters.length + 1)) {
					words.append(DictionarySearchRec(letters, used , newWord.toString()));
				}	
				used[i] = false;
			}
		}
		
		return words.toString();
	}
	
	
	
}

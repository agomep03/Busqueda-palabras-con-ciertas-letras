package src;

import java.util.ArrayList;

public class Dictionary {
	ArrayList<String> palabras;
	
	public Dictionary(String dicFile) {
		palabras = new ArrayList<String>();
		
		try {
			Source source = new Source(dicFile);
			while(source.hasNext()) {
				String pal = source.getNext();
				StringBuffer palabra = new StringBuffer(pal);
				palabra.replace(palabra.length() - 1, palabra.length(), "");
				palabras.add(palabra.toString());
			}
		} catch (Exception e) {
			System.out.println("Error en el constructor de diccionario: "+e.getMessage());
		}
		
	}
	
	public boolean contains(String palabra) {
		return palabras.contains(palabra);
	}
	
	public String getRandowWord(int number) {
		int num = decreaseNumber(number);
		System.out.println(palabras.get(num));
		return palabras.get(num);
	}
	
	public int decreaseNumber(int number) {
		while(number > palabras.size()) {
			//System.out.println(number);
			number = number / 2;
		}
		while(palabras.get(number).length() > 7) {
			//System.out.println(palabras.get(number).length() + "-----");
			number = number / 2;
		}
		//System.out.println(palabras.get(number).length() + "--A--");
		return number;
	}
	
}
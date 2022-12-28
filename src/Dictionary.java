package src;

import java.util.ArrayList;

public class Dictionary {
	ArrayList<String> palabras;
	
	public Dictionary() {
		palabras = new ArrayList<String>();
		
		try {
			Source source = new Source("Diccionario.txt");
			while(source.hasNext()) {
				palabras.add(source.getNext());
			}
		} catch (Exception e) {
			System.out.println("Error en el constructor de diccionario: "+e.getMessage());
		}
		
	}
	
	public boolean contains(String palabra) {
		return palabras.contains(palabra);
	}
	
}
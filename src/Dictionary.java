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
	
}
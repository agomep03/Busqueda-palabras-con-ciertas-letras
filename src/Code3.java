package src;

import src.Code;
import src.Code2;

import java.io.BufferedReader;
import java.util.*;

public class Code3 {
	
	private Dictionary dict3;
	
	private Code cod1;
	private Code2 cod2;
	
	public Code3(Dictionary dc) {
		cod1 = new Code(dc);
		cod2 = new Code2(dc);
		this.dict3 = dc;
	}
	
	public String test() {
		Random randomNumber = new Random();
		randomNumber.setSeed(System.currentTimeMillis());
		int r = randomNumber.nextInt(108790);
		String word = dict3.getRandowWord(r);
		return "TEST:" + devuelto(pruebaCode1(word),pruebaCode2(word));
	}
	
	//Genera una palabra aleatoria
	public String RandomWord() {
		Random randomNumber = new Random();
		randomNumber.setSeed(System.currentTimeMillis());
		int r = randomNumber.nextInt(108790);
		switch (r) {
		case 1:
			return "abanico";
		case 2:
			return "cables";
		case 3:
			return "arrumbador";
		case 4:
			return "padre";
		case 5:
			return "patron";
		case 6:
			return "berrar";
		case 7:
			return "castro";
		case 8:
			return "caro";
		case 9:
			return "sopa";
		default:
			return "soldar";
		}
	}
	
	//Prueba el codigo 1 (menos optimo) 
	public long pruebaCode1(String palabra) {
		Calendar rightNow = Calendar.getInstance();
		long time = rightNow.getTimeInMillis();
		System.out.println("Code1 empieza en:" + time);
		
		String sol = cod1.DictionarySearch(palabra);
		
		Calendar rightNow2 = Calendar.getInstance();
		long time2 = rightNow2.getTimeInMillis();
		System.out.println("Code1 termina en:" + time2);
		long terminado = time2 - time;
		
		return terminado;
	}
	
	public long pruebaCode2(String palabra) {
		Calendar rightNow3 = Calendar.getInstance();
		long time3 = rightNow3.getTimeInMillis();
		System.out.println("Code2 empieza en:" + time3);
		
		String[] letrasDivididas = palabra.split("");	
		String sol2 = cod2.DictionarySearch(letrasDivididas);
		
		Calendar rightNow4 = Calendar.getInstance();
		long time4 = rightNow4.getTimeInMillis();
		System.out.println("Code2 termina en:" + time4);
		long terminado2 = time4 - time3;
		
		return terminado2;
	}
	
	public String devuelto(long terminado, long terminado2){
		return("El codigo 1 ha tardado un total de "+ terminado +" milisegundos, y el codigo 2 ha tardado un total de "+ terminado2 +" milisegundos.");
	}
}

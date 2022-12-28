package src;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Dictionary diccionario = new Dictionary();
		
		int queHacer=1;
		Scanner input = new Scanner(System.in);
//		if(args.length==0) {
//			//Si no recibe argumentos pregunta que quiere el usuario hacer
//			queHacer=preguntarQueHacer(input);
//		}else {
//			try {
//				//Recoge la accion del argumento
//				queHacer = Integer.parseInt(args[0]);
//				if(queHacer<1 || queHacer>3) {
//					//Si la opcion no es valida lanza excepciom
//					throw new Exception("Opcion no valida");
//				}
//			}catch(Exception e) {
//				//Si el argumento no es valido pregunta al usuario
//				queHacer=preguntarQueHacer(input);
//			}
//		}
		
		String letras;
		switch (queHacer) {
		case 1:
			letras = obtenerLetras(args, input);
			Code codigo = new Code(diccionario);
			String sol = codigo.DictionarySearch(letras);
			System.out.println(sol);
			break;
		case 2:
			letras = obtenerLetras(args, input);
			String[] letrasDivididas = letras.split("");
			Code2 codigo2 = new Code2(diccionario);
			String sol2 = codigo2.DictionarySearch(letrasDivididas);
			System.out.println(sol2);
			break;
		case 3:
			System.out.println("Aqui llamaría a las pruebas...");
			System.out.println("Si tuvieramos pruebas");
		default:
			break;
		}
		
		input.close();
	}


	private static String obtenerLetras(String[] args, Scanner input) {
		String letras="padre";
//		if(args.length<2) {
//			//Si no recibe argumentos pregunta que letras emplea
//			System.out.println("Inserta las letras que quieras comprobar sin emplear espacios y presiona Enter.");
//			letras = input.nextLine() + input.nextLine();
//		}else {
//			//Si recibe argumentos recoge las letras de este
//			letras = args[1];
//		}
		return letras;
	}


	private static int preguntarQueHacer(Scanner input) {
		int queHacer;
		do {
			System.out.println("¿Que quiere hacer?");
			System.out.println("Pulse 1 -> Para ejecutar el primer código (menos óptimo).");
			System.out.println("Pulse 2 -> Para ejecutar el segundo código (más óptimo).");
			System.out.println("Pulse 3 -> Para hacer pruebas de ejecución de ambos códigos.");
			queHacer=input.nextInt();
		}while(queHacer<1 || queHacer>3);
		return queHacer;
	}
}

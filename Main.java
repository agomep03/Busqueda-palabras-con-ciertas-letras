import java.util.Scanner;

public class Main {
	public static void Main(String args[]) {
		int queHacer=0;
		Scanner input = new Scanner(System.in);
		if(args.length==0) {
			//Si no recibe argumentos pregunta que quiere el usuario hacer
			queHacer=preguntarQueHacer(input);
		}else {
			try {
				//Recoge la accion del argumento
				queHacer = Integer.parseInt(args[0]);
				if(queHacer<1 || queHacer>3) {
					//Si la opcion no es valida lanza excepciom
					throw new Exception("Opcion no valida");
				}
			}catch(Exception e) {
				//Si el argumento no es valido pregunta al usuario
				queHacer=preguntarQueHacer(input);
			}
		}
		
		String letras;
		switch (queHacer) {
		case 1:
			letras = obtenerLetras(args, input);
			System.out.println("Aqui iria el codigo 1");
			//Codigo1(letras)
			break;
		case 2:
			letras = obtenerLetras(args, input);
			System.out.println("Aqui iria el codigo 2");
			//Codigo2(letras)
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
		String letras;
		if(args.length<2) {
			//Si no recibe argumentos pregunta que letras emplea
			System.out.println("Inserta las letras que quieras comprobar sin emplear espacios y presiona Enter.");
			letras = input.nextLine();
		}else {
			//Si recibe argumentos recoge las letras de este
			letras = args[1];
		}
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

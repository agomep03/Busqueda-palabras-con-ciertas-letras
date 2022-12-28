package src;
import java.io.BufferedReader;
import java.io.IOException;


public class FileReader {
	private String fileName;

	public FileReader(String fileName) {
		this.fileName = fileName;
	}

	public String read() throws Exception {
		java.io.FileReader fr = null;
		BufferedReader br = null;
		StringBuilder content = new StringBuilder();
		String line = "";

		try {
			/*
			 * Apertura del fichero y creacion de BufferedReader para poder hacer una
			 * lectura comoda (disponer del metodo readLine()).
			 */
			fr = new java.io.FileReader(fileName);
			br = new BufferedReader(fr);

			// Lectura del fichero
			line = br.readLine();
			while (line != null) {
				content.append(line + System.getProperty("line.separator"));
				line = br.readLine();
			}
		} catch (IOException iOE) {
			System.err.println(new IOException(
					"FileReader:read - Un error de entrada o salida ha imposibilitado que se pudiera abrir el fichero " + this.fileName));

			
			throw new Exception("Un error de entrada o salida ha imposibilitado que se pudiera abrir el fichero " + this.fileName);
		} finally {
			/*
			 * En el finally cerramos el fichero, para asegurarnos que se cierra tanto si
			 * todo va bien como si salta una excepcion.
			 */
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (IOException iOE) {
				System.err.println(new IOException(
						"FileReader:read - Un error de entrada o salida ha imposibilitado que se pudiera cerrar el fichero " + this.fileName));

				throw new Exception("Un error de entrada o salida ha imposibilitado que se pudiera cerrar el fichero " + this.fileName);
			}
		}
		return content.toString();
	}

}

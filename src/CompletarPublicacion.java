import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Hashtable;

/**
 * @(#)CompletarPublicacion.java
 * 
 *                               El objetivo de esta clase es completar los
 *                               nombres de las publicaciones de referencias y
 *                               de documentos principales de la informaci�n
 *                               proveniente de Scopus. Dispone de dos m�todos,
 *                               uno que utiliza la lista de abreviaturas ISSN y
 *                               el otro que usa la lista de ISI.
 * 
 * @author EGarciaCanoCa
 * @version 1.0 (09/Ocutbre/2013)
 */
public class CompletarPublicacion {

	public static Hashtable<String, String> abbrs = new Hashtable<String, String>();
	public String[] palabras;

	// Para el patr�n de dise�o Singleton
	private static CompletarPublicacion instancia = null;

	private static File issnFile = null;
	private static RandomAccessFile issnRaf = null;
	private static String pathToISSNFile = "";

	/**
	 * Constructor privado de la clase. Este m�todo es invocado desde el m�todo
	 * <code>getInstancia</code>.
	 * 
	 * @author EGarciaCanoCa
	 * @param path
	 *            Ruta del archivo de las abreviaturas ISSN o ISI
	 */
	private CompletarPublicacion(String path) {

		String linea;
		String[] keys;

		pathToISSNFile = path;

		issnFile = new File(pathToISSNFile);

		// Se crea una hashtable de la lista de abreviaciones
		try {
			issnRaf = new RandomAccessFile(issnFile, "r");

			while (issnRaf.getFilePointer() < issnRaf.length()) {

				linea = issnRaf.readLine();
				keys = linea.split("\t");
				if(!abbrs.containsKey(keys[0]))
					abbrs.put(keys[0], keys[1]);
			}
			
			issnRaf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(">>>>>>>>>>>>>>>El archivo ISSN no pudo ser abierto");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(">>>>>>>>>>>>>>>>Error al leer el archivo");
		}

	}

	/**
	 * Esta clase est� desarrollada con el patr�n de dise�o Singleton por lo que
	 * s�lo existir� una �nica instancia de ella. Dicha instancia ser� obtenida
	 * a trav�s de este m�todo.
	 * 
	 * @author EGarciaCanoCa
	 * @param path
	 *            Ruta del archivo de las abreviaturtas ISSN o ISI.
	 * @return Una instancia de la clase <code>CompletarPublicacion</code>.
	 */
	public synchronized static CompletarPublicacion getInstnacia(String path) {

		if (instancia == null)
			instancia = new CompletarPublicacion(path);

		return instancia;
	}

	/**
	 * Este m�todo completa los nombres de las publicaciones a partir de la
	 * lista de abreviaturas ISSN.
	 * 
	 * @author EGarciaCanoCa
	 * @param cadena
	 *            El nombre de la publicaci�n que ser� completado.
	 * @return El nombre de la publicaci�n completado a partir de la lista ISSN.
	 */	
	public String completaISSN(String publicacion) {
		String linea = "";
		String[] abbr;
		String[] tokens;

		// Se quitan todos los puntos del nombre de la publicacion
		publicacion.replace(".", "");
		publicacion.replace("/", " ");
		tokens = publicacion.split("\\s");

		// Se revisa token por token de la publicacion
		for (int i = 0; i < tokens.length; i++) {			

			// Se quitan todos los signos de puntuaci�n del token
			tokens[i] = tokens[i].replaceAll("\\p{Punct}", "");
			tokens[i] = tokens[i].trim();
			
			if(abbrs.containsKey(tokens[i]))
				tokens[i] = abbrs.get(tokens[i]);			
		}
		
		publicacion = "";

		// Se reconstruye la cadena original pero ya con los reemplazos hechos
		for (String token : tokens)
			publicacion += token + " ";

		publicacion = publicacion.trim();

		System.out.println(publicacion);
		return publicacion;
	}
}

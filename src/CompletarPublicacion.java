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
 *                               de documentos principales de la información
 *                               proveniente de Scopus. Dispone de dos métodos,
 *                               uno que utiliza la lista de abreviaturas ISSN y
 *                               el otro que usa la lista de ISI.
 * 
 * @author EGarciaCanoCa
 * @version 1.0 (09/Ocutbre/2013)
 */
public class CompletarPublicacion {

	public static Hashtable<String, String> abbrs = new Hashtable<String, String>();
	public String[] palabras;

	// Para el patrón de diseño Singleton
	private static CompletarPublicacion instancia = null;

	private static File issnFile = null;
	private static RandomAccessFile issnRaf = null;
	private static String pathToISSNFile = "";

	/**
	 * Constructor privado de la clase. Este método es invocado desde el método
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
	 * Esta clase está desarrollada con el patrón de diseño Singleton por lo que
	 * sólo existirá una única instancia de ella. Dicha instancia será obtenida
	 * a través de este método.
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
	 * Este método completa los nombres de las publicaciones a partir de la
	 * lista de abreviaturas ISSN.
	 * 
	 * @author EGarciaCanoCa
	 * @param cadena
	 *            El nombre de la publicación que será completado.
	 * @return El nombre de la publicación completado a partir de la lista ISSN.
	 */	
	public String completaISSN(String publicacion) {
		String linea = "";
		String[] abbr;
		String[] tokens;

		// Se quitan todos los puntos del nombre de la publicacion
		publicacion.replace(".", "");
		publicacion.replace("/", " ");
		
		//Quitamos valores como VOL 1, VOL I VOLS 1&2, etc:
		// Números arábigos
		publicacion = publicacion.replaceAll(
				"(,? ?VOLS? \\d\\d? ?(&|AND|,)? ?\\d\\d? ?,?)", " ");
		publicacion = publicacion.replaceAll(
				",? ?VOL \\d\\d?\\d? ?,? ?(\\d\\d?\\d?([^A-Z]|$))?,?", " ");

		// Números romanos
		publicacion = publicacion
				.replaceAll(
						"(,? ?VOLS? III ?(&|AND|,)? ?IV ?,?)|(,? ?VOLS? II ?(&|AND|,)? ?III ?,?)|(,? ?VOLS? IV ?(&|AND|,)? ?V ?,?)|(,? ?VOLS? IX ?(&|AND|,)? ?X ?,?)|(,? ?VOLS? VIII ?(&|AND|,)? ?IX ?,?)|(,? ?VOLS? VII ?(&|AND|,)? ?VIII ?,?)|(,? ?VOLS? VI ?(&|AND|,)? ?VII ?,?)|(,? ?VOLS? V ?(&|AND|,)? ?VI ?,?)|(,? ?VOLS? I ?(&|AND|,)? ?II ?,?)",
						" ");
		publicacion = publicacion
				.replaceAll(
						"(,? ?VOL III ?,?)|(,? ?VOL II ?,?)|(,? ?VOL IV ?,?)|(,? ?VOL IX ?,?)|(,? ?VOL VIII ?,?)|(,? ?VOL VII ?,?)|(,? ?VOL VI ?,?)|(,? ?VOL V ?,?)|(,? ?VOL X ?,?)|(,? ?VOL I ?,?)",
						" ");

		// Quitamos valores como PART 1, PT I PARTS 1&2, etc:
		// letra
		publicacion = publicacion
				.replaceAll(
						"(,? ?(PARTS?|PTS?) A ?(&|AND|,)? ?B ?,?)|(,? ?(PARTS?|PTS?) B ?(&|AND|,)? ?C ?,?)|(,? ?(PARTS?|PTS?) C ?(&|AND|,)? ?D ?,?)|(,? ?(PARTS?|PTS?) D ?(&|AND|,)? ?E ?,?)|(,? ?(PARTS?|PTS?) E ?(&|AND|,)? ?F ?,?)|(,? ?(PARTS?|PTS?) F ?(&|AND|,)? ?G ?,?)|(,? ?(PARTS?|PTS?) G ?(&|AND|,)? ?H ?,?)|(,? ?(PARTS?|PTS?) H ?(&|AND|,)? ?I ?,?)|(,? ?(PARTS?|PTS?) I ?(&|AND|,)? ?J ?,?)",
						" ");
		publicacion = publicacion
				.replaceAll(
						"(,? ?(PART|PT) A ?,?)|(,? ?(PART|PT) B ?,?)|(,? ?(PART|PT) C ?,?)|(,? ?(PART|PT) D ?,?)|(,? ?(PART|PT) E ?,?)|(,? ?(PART|PT) F ?,?)|(,? ?(PART|PT) G ?,?)|(,? ?(PART|PT) H ?,?)|(,? ?(PART|PT) I ?,?)|(,? ?(PART|PT) J ?,?)",
						" ");

		// números romanos
		publicacion = publicacion
				.replaceAll(
						"(,? ?(PARTS?|PTS?) III ?(&|AND|,)? ?IV ?,?)|(,? ?(PARTS?|PTS?) II ?(&|AND|,)? ?III ?,?)|(,? ?(PARTS?|PTS?) IV ?(&|AND|,)? ?V ?,?)|(,? ?(PARTS?|PTS?) IX ?(&|AND|,)? ?X ?,?)|(,? ?(PARTS?|PTS?) VIII ?(&|AND|,)? ?IX ?,?)|(,? ?(PARTS?|PTS?) VII ?(&|AND|,)? ?VIII ?,?)|(,? ?(PARTS?|PTS?) VI ?(&|AND|,)? ?VII ?,?)|(,? ?(PARTS?|PTS?) V ?(&|AND|,)? ?VI ?,?)|(,? ?(PARTS?|PTS?) I ?(&|AND|,)? ?II ?,?)",
						" ");
		publicacion = publicacion
				.replaceAll(
						"(,? ?(PART|PT) III ?,?)|(,? ?(PART|PT) II ?,?)|(,? ?(PART|PT) IV ?,?)|(,? ?(PART|PT) IX ?,?)|(,? ?(PART|PT) VIII ?,?)|(,? ?(PART|PT) VII ?,?)|(,? ?(PART|PT) VI ?,?)|(,? ?(PART|PT) V ?,?)|(,? ?(PART|PT) X ?,?)|(,? ?(PART|PT) I ?,?)",
						" ");

		// Números arábigos
		publicacion = publicacion.replaceAll(
				"(,? ?(PARTS?|PTS?) \\d\\d? ?(&|AND|,)? ?\\d\\d? ?,?)", " ");
		publicacion = publicacion.replaceAll(",? ?(PART|PT) \\d\\d?\\d? ?,?", " ");

		// QUITAMOS Números Romanos I-XX
		publicacion = publicacion
				.replaceAll(
						"[^A-Z0-9]III[^A-Z0-9]|[^A-Z0-9]II[^A-Z0-9]|[^A-Z0-9]IV[^A-Z0-9]|[^A-Z0-9]IX[^A-Z0-9]|[^A-Z0-9]VIII[^A-Z0-9]|[^A-Z0-9]VII[^A-Z0-9]|[^A-Z0-9]VI[^A-Z0-9]|[^A-Z0-9]V[^A-Z0-9]|[^A-Z0-9]XIII[^A-Z0-9]|[^A-Z0-9]XII[^A-Z0-9]|[^A-Z0-9]XIV[^A-Z0-9]|[^A-Z0-9]XIX[^A-Z0-9]|[^A-Z0-9]XVIII[^A-Z0-9]|[^A-Z0-9]XVII[^A-Z0-9]|[^A-Z0-9]XVI[^A-Z0-9]|[^A-Z0-9]XV[^A-Z0-9]|[^A-Z0-9]XX[^A-Z0-9]|[^A-Z0-9]XI[^A-Z0-9]|[^A-Z0-9]X[^A-Z0-9]|[^A-Z0-9]I[^A-Z0-9]",
						" ");
		publicacion = publicacion
				.replaceAll(
						"^III[^A-Z0-9]|^II[^A-Z0-9]|^IV[^A-Z0-9]|^IX[^A-Z0-9]|^VIII[^A-Z0-9]|^VII[^A-Z0-9]|^VI[^A-Z0-9]|^V[^A-Z0-9]|^XIII[^A-Z0-9]|^XII[^A-Z0-9]|^XIV[^A-Z0-9]|^XIX[^A-Z0-9]|^XVIII[^A-Z0-9]|^XVII[^A-Z0-9]|^XVI[^A-Z0-9]|^XV[^A-Z0-9]|^XX[^A-Z0-9]|^XI[^A-Z0-9]|^X[^A-Z0-9]|^I[^A-Z0-9]",
						" ");

		//Se quitan todas las cadenas que contienen 2 o más dígitos
		publicacion = publicacion.replaceAll("[0-9]{2,}", "");
		
		// Quitamos años: Probablemente esto pierde sentido después de la línea anterior
		publicacion = publicacion
				.replaceAll(
						"\\((2000|2001|2002|2003|2004|2005|2006|2007|2008|2009|2010|2011|2012|2013|2014|2015)\\)",
						" ");
		publicacion = publicacion
				.replaceAll(
						"^?[^A-Z0-9\\(]?(2000|2001|2002|2003|2004|2005|2006|2007|2008|2009|2010|2011|2012|2013|2014|2015)[^A-Z0-9\\)]?$?",
						" ");
				
		
		
		publicacion = publicacion.replaceAll("[0-9]+(\\s)?(RD|TH|ND)"," ");
		
		
		
		tokens = publicacion.split("\\s");
		
		// Se revisa token por token de la publicacion
		for (int i = 0; i < tokens.length; i++) {			

			// Se quitan todos los signos de puntuación del token
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
		//System.out.println(publicacion);

		return publicacion;
	}
}

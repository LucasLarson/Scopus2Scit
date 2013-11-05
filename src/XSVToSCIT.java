import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

import java.awt.Color;

import javax.swing.JTextArea;

//import XSVToSCIT.thread1;




import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.io.*;
import java.util.regex.*;
import java.util.*;


public class XSVToSCIT extends JFrame {
	
	
	private String[] archivosOriginales;
	private String[] archivosOriginales_conRuta;
	private JProgressBar progressBar;
	private JTextArea areaTexto;
	private JButton botonSeleccionadorArchivos;
	private JButton botonIniciar;
	private JComboBox<String> source;
	private JTextField txtPublicacionHomolodaga;
	
	String pubHomologada = "";
	int cycles = 1;

	private String[] renglones;
	private final int MAX_NUMERO_AUTORES = 8;
	private final int MAX_NUMERO_PALABRAS = 6;
	private String sourceName = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XSVToSCIT frame = new XSVToSCIT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// El hilo para el manejo del progressBar y el TextArea
	public class thread1 implements Runnable {
			// int cycles = 1;

			public void run() {			
				
				if(source.getSelectedItem().toString().compareTo("Scopus") == 0){
					sourceName = "{SCOPUS}";
					fromScopus();				
				}else if(source.getSelectedItem().toString().compareTo("Web Of Science") == 0){
					sourceName = "{WOS}";
					fromWOS();				
				}else{
					JOptionPane.showMessageDialog(null,"No hay nada que hacer");
					archivosOriginales = null;
					archivosOriginales_conRuta = null;
					botonSeleccionadorArchivos.setEnabled(true);
				}
			}
		}
	/**
	 * Este m�todo realiza el procesamiento del archivo de entrada considerando
	 * que proviene de Scopus. Es el comportamiento por defecto del programa.
	 * 
	 * @author EGarciaCanoCa (17/Octubre/2013)
	 * */
	public void fromScopus() {
		int contador = 0;
		int indice = 0;
		// int cycles = 1;

		CatalogoPaises catalogoPaises;

		catalogoPaises = new CatalogoPaises();

		String nombreArchivoLimpio = "";
		String[] nombre_aux;

		String[] autores;
		String[] referencias;

		indice = archivosOriginales[0].indexOf('.');
		nombreArchivoLimpio = archivosOriginales[0].substring(0, indice);
		nombre_aux = nombreArchivoLimpio.split("_");
		nombreArchivoLimpio = nombre_aux[0];

		LeerArchivoTexto lectura;

		String[] entradasSeparadas;
		String[] encabezado;
		String cadenaArchivo = "";
		String cadena = "";

		String renglonSalida = "";

		String cadenaReferencias = "";

		String apellidoA = "";
		String nombreA = "";
		String[] autor;
		String palabra = "";
		String[] palabras;
		String nada = "";
		String tituloAcutal;

		String institucion = "";
		String pais = "";
		int tipo = 0;
		int columnaActual = 0;
		int cuentaAutores = 0;
		int cuentaPalabras = 0;
		boolean datosEsenciales = true;
		boolean banderaCorrespondingAuthor = false;
		String[] afiliacion;
		String[] apellidosIngresados;
		String[] nombresIngresados;

		areaTexto.setText("");
		progressBar.setValue(10);
		areaTexto.append("Separando por Tabuladores...");

		new ConvierteCvsATab(
				archivosOriginales_conRuta[0], "Salidas\\Scopus\\SalidasTABS");

		lectura = new LeerArchivoTexto("Salidas\\Scopus\\SalidasTABS\\"
				+ nombreArchivoLimpio + ".txt");

		String salidaCompleta = "";

		// lectura = new LeerArchivoTexto( archivosOriginales_conRuta[0] );
		cadenaArchivo = lectura.getArchivoEnCadena();
		progressBar.setValue(25);
		areaTexto.append(" OK!");
		areaTexto.append("\nLimpiando texto...");		
		
		cadenaArchivo = quitaCaracteresEspeciales(cadenaArchivo);
		cadenaArchivo = cadenaArchivo.toUpperCase();

		progressBar.setValue(50);
		areaTexto.append(" OK!");
		areaTexto.append("\nAcomodando columnas recorridas...");

		AcomodaTABScopus acomodaTABScopus = new AcomodaTABScopus(cadenaArchivo);
		cadenaArchivo = acomodaTABScopus.getSalidaCorrecta();

		/*******/

		// Crea la carpeta de resultados
		File folder;
		String ruta_resultados = "Salidas\\Scopus\\";
		folder = new File(ruta_resultados);
		folder.mkdirs();
				
		String ruta_rep_institcuiones = "Salidas\\Scopus\\ReporteInstituciones\\";
		folder = new File(ruta_rep_institcuiones);
		folder.mkdirs();

		// cadena =
		// "Autores\tT�tulo\tA�o\tPublicaci�n\tVolumen\tN�mero\tInstituci�n\tPa�sC�digo\tPa�sNombre\tKeyWords\tTipo\n";
		// cadenaArchivo="";
		// cadena += salidaCompleta;
		new EscribirEnArchivoTexto(cadenaArchivo,
				"Salidas\\Scopus\\SalidasTABS" + "\\" + nombreArchivoLimpio
						+ "_TABSBIEN.txt");

		/*******/

		renglones = cadenaArchivo.split("\n");

		// guardo los valores del encabezado para conocer las posiciones de
		// cada elemento
		encabezado = renglones[0].split("\t");

		contador = 1; // la primera l�nea es el encabezado

		progressBar.setValue(75);
		areaTexto.append(" OK!");
		areaTexto.append("\n\nProcesando informaci�n...");

		int cuentaAutoresIngresados = 0;
		int cuentaPalabrasIngresadas = 0;
		boolean banderaAutor = false;
		int banderaCasoEspecial = 0;
		String cadenaAutores = "";
		String[] auxAutor;
		String cadenaInstituciones = "";
		String auxInstitucion = "";
		int inicio = 0;

		// Imprime encabezado
		salidaCompleta = "";
		salidaCompleta += "REF. ORIGINAL COMPLETA" + "\t";
		salidaCompleta += "ES PRINCIPAL" + "\t";
		for (int i = 0; i < MAX_NUMERO_AUTORES; i++)
			salidaCompleta += "AUTOR " + (i + 1) + "\t";
		for (int i = 0; i < MAX_NUMERO_AUTORES; i++)
			salidaCompleta += "INSTITUCION " + (i + 1) + "\t";
		salidaCompleta += "TITULO" + "\t";
		salidaCompleta += "ANIO" + "\t";
		salidaCompleta += "PUBLICACION" + "\t";
		salidaCompleta += "VOLUMEN" + "\t";
		salidaCompleta += "NUMERO" + "\t";
		salidaCompleta += "TIPO" + "\t";
		for (int i = 0; i < MAX_NUMERO_PALABRAS; i++)
			salidaCompleta += "PALABRA_CLAVE " + (i + 1) + "\t";
		salidaCompleta += "IDIOMA ORIGINAL" + "\t";
		salidaCompleta += "CORRESPONDING AUTHOR" + "\t";
		salidaCompleta += "ABSTRACT" + "\t";
		salidaCompleta += "REF. TOTALES" + "\t";
		salidaCompleta += "REF. ACTUALES" + "\t";
		salidaCompleta += "PATRON DE REF." + "\t";
		salidaCompleta += "DESCONOCIDO EN REF." + "\n";
		

		apellidosIngresados = new String[MAX_NUMERO_AUTORES];
		nombresIngresados = new String[MAX_NUMERO_AUTORES];

		while (contador < renglones.length) {
			datosEsenciales = true;
			entradasSeparadas = renglones[contador].split("\t");
			if (entradasSeparadas.length >= 40)// Si hay datos suficientes en el rengl�n
			{		
				if(contador == 1)
					renglonSalida = sourceName+"\t";
				else
					renglonSalida = "\t";// Como es principal, el campo REF. ORIGINAL COMPLETA va vac�o 
				renglonSalida += "GRRRU\t";// Como es principal, el campo ES PRINCIPAL lleva una marca

				// Autores CON AFILIACIONES
				columnaActual = encuentraIndice(encabezado,
						"AUTHORS WITH AFFILIATIONS");
				entradasSeparadas[columnaActual] = entradasSeparadas[columnaActual]
						.trim();

				if (columnaActual != -1)
					autores = entradasSeparadas[columnaActual].split(";");
				else
					autores = nada.split(";");

				cuentaAutores = 0;
				cadenaAutores = "";
				cuentaAutoresIngresados = 0;
				cadenaInstituciones = "";
				auxInstitucion = "";

				for (int i = 0; i < MAX_NUMERO_AUTORES; i++)
					apellidosIngresados[i] = "";
				for (int i = 0; i < MAX_NUMERO_AUTORES; i++)
					nombresIngresados[i] = "";

				columnaActual = encuentraIndice(encabezado, "TITLE");

				if (columnaActual != -1)
					tituloAcutal = entradasSeparadas[columnaActual];
				else
					tituloAcutal = nada;

				while (cuentaAutores < autores.length
						&& cuentaAutores < MAX_NUMERO_AUTORES) {
					// Se parte de la suposici�n que se sigu� la forma
					// "apellidoA, nombreA, AFILIACI�N"
					// (Ver casos especiales abajo)
					banderaCasoEspecial = 0;
					banderaAutor = false;
					apellidoA = "";
					nombreA = "";

					autores[cuentaAutores] = autores[cuentaAutores].replace(
							".", "");
					autores[cuentaAutores] = autores[cuentaAutores].replace(
							"\'", "");

					autor = autores[cuentaAutores].split(",");

					if (autor.length >= 2) {
						apellidoA = autor[0].trim();
						nombreA = autor[1].trim();
						// quita los espacio en el nombre como
						// "LENNON, J W O" -> "LENNON,JWO", pero no como
						// "LENNON, JOHN W O" -> "LENNON,JOHN WO"
						auxAutor = nombreA.split(" ");
						nombreA = "";
						for (int a = 0; a < auxAutor.length; a++) {
							// Se trata de una inicial
							if (auxAutor[a].length() == 1)
								nombreA += auxAutor[a];
							// Se trata de un nombre o prefijo (pongo un
							// espacio posterior)
							else
								nombreA += auxAutor[a] + " ";
						}

						// aux = nombreA.replace(" ","");
						nombreA = nombreA.trim();
						nombreA = nombreA.replace("_", "");

						// ******************************************************
						// //
						// CASO ESPECIAL 1 "nombreA apellidoA, AFILIACI�N"
						// Se corrobora con la longitud del nombre propio;
						// se supera 15 caracteres, se considera
						// que hubo alguien que puso su nombre mal; ejemplo:
						// "YANRUI WU, CHINESE ECONOMY RESEARCH UNIT".
						// En lugar de
						// "WU, YANRUI, CHINESE ECONOMY RESEARCH UNIT"
						// S�lo para ese caso:
						if (nombreA.length() >= 15 && apellidoA.length() > 0) {
							banderaCasoEspecial = 1;
							auxAutor = apellidoA.split(" ");

							if (auxAutor.length > 1) {
								apellidoA = auxAutor[1];
								nombreA = auxAutor[0];
							} else // S�lo tiene el apellido
							{
								apellidoA = auxAutor[0];
								nombreA = "DESCONOCIDO";
							}
						}

						// ******************************************************
						// //

						if ((nombreA.length() + apellidoA.length()) > 0
								&& (!nombreA.matches(".*[0-9].*") && !apellidoA
										.matches(".*[0-9].*"))) // Si no es un nombre sin sentido (s�lo apellido o nombre o vac�o)
						{
							// Juntamos el nombre del autor con su apellido
							cadenaAutores += apellidoA + "," + nombreA + "\t";
							apellidosIngresados[cuentaAutoresIngresados] = apellidoA;
							nombresIngresados[cuentaAutoresIngresados] = nombreA;
							cuentaAutoresIngresados++;
							banderaAutor = true;
						}
					} else // El autor no tiene instituci�n
					{
						if (autor.length == 1) // S�lo viene el apellido del
												// autor
						{
							if (autor[0].length() > 0) {
								cadenaAutores += autor[0] + ",DESCONOCIDO"
										+ "\t";
								apellidosIngresados[cuentaAutoresIngresados] = apellidoA;
								nombresIngresados[cuentaAutoresIngresados] = "DESCONOCIDO";
								cuentaAutoresIngresados++;
								banderaAutor = true;

								banderaCasoEspecial = 2;
							}
						}
					}

					new EscribirEnArchivoTexto("@" + Integer.toString(cycles++)
							+ "{", "Salidas\\Scopus\\ReporteInstituciones\\" + nombreArchivoLimpio
							+ "_INTITUCIONES.LOG");
					if (banderaAutor)// Si se ingres� al autor, ahora
										// ingreso su instituci�n
					{
						if (banderaCasoEspecial == 2) { // No hay
														// instituci�n
							cadenaInstituciones += "NO DISPONIBLE, NO DISPONIBLE"
									+ "\t";
							new EscribirEnArchivoTexto(
									"SIN INFORMACION DE LA FUENTE >>> "
											+ apellidoA + "," + nombreA
											+ " >>> " + tituloAcutal,
									"Salidas\\Scopus\\ReporteInstituciones\\" + nombreArchivoLimpio
											+ "_INTITUCIONES.LOG");
						}

						else {
							inicio = 2;
							if (banderaCasoEspecial == 1) // La instituci�n comienza a partir de la primera coma
								inicio = 1;

							auxInstitucion = "";
							for (int inst = inicio; inst < autor.length; inst++) {
								if (inst != inicio)
									auxInstitucion += ", ";
								auxInstitucion += autor[inst];
							}

							if (inicio >= autor.length) {// No hay instituci�n para este autor
								cadenaInstituciones += "NO DISPONIBLE, NO DISPONIBLE"
										+ "\t";
								new EscribirEnArchivoTexto(
										"SIN INFORMACION DE LA FUENTE >>> "
												+ apellidoA + "," + nombreA
												+ " >>> " + tituloAcutal,
										"Salidas\\Scopus\\ReporteInstituciones\\"
												+ nombreArchivoLimpio
												+ "_INTITUCIONES.LOG");
							} else {
								auxInstitucion = analizaAfiliaciones(
										auxInstitucion, nombreArchivoLimpio);

								afiliacion = auxInstitucion.split(",");

								if (afiliacion.length > 1) {
									institucion = afiliacion[0].trim(); // Instituci�n
									pais = afiliacion[1].trim(); // Pa�s
									pais = catalogoPaises.validaPais(pais);
									
									if(institucion.compareTo("UNIVERSIDAD NACIONAL AUTONOMA DE MEXICO") == 0)
										pais = "MEXICO";

									if (institucion.compareTo("NO DISPONIBLE") == 0
											&& pais.compareTo("NO DISPONIBLE") != 0) {
										institucion = "NO DISPONIBLE" + " - "
												+ pais; // Para
														// distinguir
														// "NO DISPONIBLE"
														// en varios
														// pa�ses

										new EscribirEnArchivoTexto(
												"NO ENTENDIBLE >>> "
														+ apellidoA + ","
														+ nombreA + " >>> "
														+ tituloAcutal,
												"Salidas\\Scopus\\ReporteInstituciones\\"
														+ nombreArchivoLimpio
														+ "_INTITUCIONES.LOG");
									}
									auxInstitucion = institucion + "," + pais;
									cadenaInstituciones += auxInstitucion
											+ "\t";
								} else {
									cadenaInstituciones += "NO DISPONIBLE, NO DISPONIBLE"
											+ "\t";
									new EscribirEnArchivoTexto(auxInstitucion
											+ " >>> " + apellidoA + ","
											+ nombreA + " >>> " + tituloAcutal,
											"Salidas\\Scopus\\ReporteInstituciones\\"
													+ nombreArchivoLimpio
													+ "_INTITUCIONES.LOG");
								}
							}
						}
					}
					cuentaAutores++;
					new EscribirEnArchivoTexto("}", "Salidas\\Scopus\\ReporteInstituciones\\"
							+ nombreArchivoLimpio + "_INTITUCIONES.LOG");
				}

				for (int i = cuentaAutoresIngresados; i < MAX_NUMERO_AUTORES; i++) {
					cadenaAutores += "\t";
					cadenaInstituciones += "\t";
				}

				if (cuentaAutoresIngresados > 0) // Si hay autores; si no, no vale la pena ingresar el dato
				{
					renglonSalida += cadenaAutores;
					renglonSalida += cadenaInstituciones;

					// T�tulo (posici�n 2)
					columnaActual = encuentraIndice(encabezado, "TITLE");

					if (columnaActual != -1)
						cadena = entradasSeparadas[columnaActual];
					else
						cadena = nada;

					cadena = cadena.replace("\'", "");
					cadena = cadena.replace("-", "");
					cadena = cadena.replace("\"", "");
					cadena = cadena.replace(".", "");
					cadena = cadena.replace(":", "");
					cadena = cadena.replace("?", "");
					cadena = cadena.replace("!", "");
					cadena = cadena.replace("&", "AND");
					cadena = cadena.trim();

					if (cadena.length() > 0) // Si hay un t�tulo
					{

						renglonSalida += cadena + "\t";

						// A�o (posici�n 3)
						columnaActual = encuentraIndice(encabezado, "YEAR");

						if (columnaActual != -1)
							cadena = entradasSeparadas[columnaActual];
						else
							cadena = nada;

						cadena = cadena.trim();

						if (cadena.length() > 0) // Si hay un a�o
						{
							renglonSalida += cadena + "\t";

							// TIPO (SE AGREGA AL FINAL)
							// Tipo de documento (posici�n 39)
							columnaActual = encuentraIndice(encabezado,
									"DOCUMENT TYPE");

							if (columnaActual != -1)
								cadena = entradasSeparadas[columnaActual];
							else
								cadena = nada;

							// Tipo por defecto: Art�culo
							tipo = 1;

							if (cadena.compareTo("ARTICLE") == 0)// ART�CULO
								tipo = 1;
							if (cadena.compareTo("BOOK") == 0) // LIBRO
								tipo = 2;
							if (cadena.compareTo("BOOK CHAPTER") == 0) // CAP�TULO
																		// DE
																		// LIBRO
								tipo = 3;
							if (cadena.compareTo("REVIEW") == 0)// RESE�A
								tipo = 4;
							if (cadena.compareTo("MEETING ABSTRACT") == 0)// ART�CULO
																			// DE
																			// CONGRESO
								tipo = 7;
							if (cadena.compareTo("CONFERENCE PAPER") == 0)// ART�CULO
																			// DE
																			// CONGRESO
								tipo = 7;

							// Publicaci�n (posici�n 4)
							columnaActual = encuentraIndice(encabezado,
									"SOURCE TITLE");
							
							// Se asigna una publicacion por dafault, proveniente del formulario
							if (columnaActual != -1 && pubHomologada.isEmpty())
								cadena = entradasSeparadas[columnaActual];
							else if(!pubHomologada.isEmpty())
								cadena = pubHomologada;
							else
								cadena = nada;

							cadena = cadena.replace("\'", "");
							cadena = cadena.replace("\"", "");
							// cadena = cadena.replace(".","");
							cadena = cadena.replace(":", "");
							cadena = cadena.replace("?", "");
							cadena = cadena.replace("!", "");
							cadena = cadena.replace("&", "AND");
							cadena = cadena.trim();

							// Se crea el objeto limpiador de nombres de
							// publicaciones
							/**
							 * @author EGarciaCanoCa (10/10/2013)
							 */
							CompletarPublicacion pubs = CompletarPublicacion
									.getInstnacia("ISSN.txt");
							cadena = pubs.completaISSN(cadena);

							if (tipo == 7 || tipo == 1) // Es una
														// conferencia; hay
														// que quitar el a�o
														// y cosas como 1st,
														// 2nd, 3rd, 4th,
														// etc.
							{
								cadena = limpiaConferencia(cadena);
							}

							if (cadena.length() > 0) // Si hay una
														// publicaci�n
							{

								renglonSalida += cadena + "\t";

								// Volumen (posici�n 40)
								columnaActual = encuentraIndice(encabezado,
										"VOLUME");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual];
								else
									cadena = nada;

								cadena = cadena.replace(" ", "-");
								cadena = cadena.replace(":", "-");
								cadena = cadena.replace("&", "-");
								cadena = cadena.trim();

								if (cadena.length() == 0) // Si no hay un
															// volumen
									cadena = "";

								renglonSalida += cadena + "\t";

								// ISSUE (posici�n 41)
								columnaActual = encuentraIndice(encabezado,
										"ISSUE");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual];
								else
									cadena = nada;

								cadena = cadena.replace(" ", "-");
								cadena = cadena.replace(":", "-");
								cadena = cadena.replace("&", "-");
								cadena = cadena.trim();

								if (cadena.length() == 0) // Si no hay un
															// n�mero
									cadena = "";

								renglonSalida += cadena + "\t";

								// TIPO
								renglonSalida += tipo + "\t";

								// KEY WORDS (posici�n 16)
								columnaActual = encuentraIndice(encabezado,
										"AUTHOR KEYWORDS");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual];
								else
									cadena = nada;

								cadena = cadena.replace(".", "");
								cadena = cadena.replace("\'", "");
								cadena = cadena.replace("\"", "");
								cadena = cadena.replace(":", "");
								cadena = cadena.replace(",", "");

								// Cuando no hay keyWords, �stas no se ponen
								palabras = cadena.split(";");

								cuentaPalabras = 0;
								cuentaPalabrasIngresadas = 0;
								while (cuentaPalabras < palabras.length
										&& cuentaPalabras < MAX_NUMERO_PALABRAS) {
									palabra = palabras[cuentaPalabras].trim();

									if (palabra.length() > 0) // Si no es
																// una
																// palabra
																// vac�a
									{
										/*
										 * if( cuentaPalabras==0 ) renglonSalida
										 * += ""; else renglonSalida += "\t";
										 * 
										 * // AGREGAMOS LA PALABRA
										 */
										renglonSalida += palabra + "\t";
										cuentaPalabrasIngresadas++;
									}
									cuentaPalabras++;
								}

								// renglonSalida += "\t";
								for (int i = cuentaPalabrasIngresadas; i < MAX_NUMERO_PALABRAS; i++) {
									renglonSalida += "\t";
								}

								// IDIOMA (posici�n 37)
								columnaActual = encuentraIndice(encabezado,
										"LANGUAGE OF ORIGINAL DOCUMENT");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual];
								else
									cadena = nada;

								// Valores:
								// 1 INGLES
								// 2 ESPA�OL
								// 9 NO DISPONIBLE
								// 10 OTRO

								if (cadena.compareTo("ENGLISH") == 0)
									cadena = "1"; // Ingl�s
								else {
									if (cadena.length() == 0)
										cadena = "9"; // No disponible
									else {
										if (cadena.compareTo("SPANISH") == 0)
											cadena = "2";// Espa�ol
										else
											cadena = "10";// Otro
									}
								}

								renglonSalida += cadena + "\t";

								// CORRESPONDING AUTHOR (posici�n 24)
								// NOTA: est� validado para que no haya un
								// corresponding auhtor
								// que no haya sido ingresado como autor en
								// la lista de autores
								// y para que el nombre del corresponding
								// author se escriba exactamente
								// como se ingres� en un inicio
								columnaActual = encuentraIndice(encabezado,
										"CORRESPONDENCE ADDRESS");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual];
								else
									cadena = nada;

								autores = cadena.split(";");
								cadena = "";

								if (autores.length > 0) // El primer
														// elemento que
														// aparece
								{
									apellidoA = "";
									nombreA = "";

									autores[0] = autores[0].replace(".", "");
									autores[0] = autores[0].replace("\'", "");
									autor = autores[0].split(",");

									if (autor.length >= 2) {
										apellidoA = autor[0].trim();
										nombreA = autor[1].trim();
										// quita los espacio en el nombre
										// como "LENNON, J W O" ->
										// "LENNON,JWO", pero no como
										// "LENNON, JOHN W O" ->
										// "LENNON,JOHN WO"
										auxAutor = nombreA.split(" ");
										nombreA = "";
										for (int a = 0; a < auxAutor.length; a++) {
											// Se trata de una inicial
											if (auxAutor[a].length() == 1)
												nombreA += auxAutor[a];
											// Se trata de un nombre o
											// prefijo (pongo un espacio
											// posterior)
											else
												nombreA += auxAutor[a] + " ";
										}

										// aux = nombreA.replace(" ","");
										nombreA = nombreA.trim();
										nombreA = nombreA.replace("_", "");

										banderaCorrespondingAuthor = false;
										for (int i = 0; i < MAX_NUMERO_AUTORES; i++) {
											if (apellidoA
													.compareTo(apellidosIngresados[i]) == 0) {
												nombreA = nombresIngresados[i];
												banderaCorrespondingAuthor = true;
												break;
											}
										}

										if (banderaCorrespondingAuthor)
											cadena = apellidoA + "," + nombreA;
										else
											cadena = "";
									}
								}

								renglonSalida += cadena + "\t";

								// ABSTRACT (posici�n 15)
								columnaActual = encuentraIndice(encabezado,
										"ABSTRACT");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual];
								else
									cadena = nada;

								renglonSalida += cadena + "\t";

								// REFERENCIAS (posici�n 23)
								{
									cadenaReferencias = "";
									columnaActual = encuentraIndice(encabezado,
											"REFERENCES");

									if (columnaActual != -1)
										cadena = entradasSeparadas[columnaActual]
												.trim();
									else
										cadena = nada;

									// Eric Gcc: Lo puse para tratar de
									// limpiar el nombre de las
									// publicaciones en las referencias
									/**
									 * @author EGarciaCanoCa (03/10/2013)
									 */
									cadena = cadena.replaceAll(
											"PROCEEDINGS OF THE", " ");
									cadena = cadena.replaceAll(
											"PROCEEDINGS OF [0-9]{4}", " ");
									cadena = cadena.replaceAll(
											"PROCEEDINGS OF", " ");
									cadena = cadena.replaceAll("PROCEEDINGS,",
											" ");
									cadena = cadena.replaceAll("PROCEEDINGS",
											" ");

									cadena = cadena.replaceAll(
											"PROCEEDING OF THE", " ");
									cadena = cadena.replaceAll(
											"PROCEEDING OF [0-9]{4}", " ");
									cadena = cadena.replaceAll("PROCEEDING OF",
											" ");
									cadena = cadena.replaceAll("PROCEEDING,",
											" ");
									cadena = cadena.replaceAll("PROCEEDING",
											" ");
									cadena = cadena.replaceAll("PROCEEDING",
											" ");

									cadena = cadena.replaceAll(
											"PROC. OF CONF.", " ");
									cadena = cadena.replaceAll("PROC.", " ");

									cadena = cadena.replaceAll(
											"[0-9]+(\\s)?(RD|TH|ND)", " ");

									// Contamos las referencias totales (van
									// separadas por ';') y las imprimimos
									if (cadena.length() == 0)
										renglonSalida += "0\t";
									else {
										referencias = cadena.split(";");
										renglonSalida += referencias.length
												+ "\t";

										Referencias ref = new Referencias();
										cadenaReferencias = ref
												.analizaReferencias(cadena,	MAX_NUMERO_AUTORES,	MAX_NUMERO_PALABRAS);
									}
								}

								// Marca de final
								renglonSalida += "***\t";

							}// if( cadena.length() > 0 ) // Si hay una
								// publicaci�n
							else
								datosEsenciales = false;
						}// if( cadena.length() > 0 ) // Si hay un a�o
						else
							datosEsenciales = false;
					}// if( cadena.length() > 0 ) // Si hay un t�tulo
					else
						datosEsenciales = false;
				}// if( renglonSalida.length()>0 ) // Si hay autores; si no,
					// no vale la pena ingresar el dato
				else
					datosEsenciales = false;

				if (datosEsenciales) {
					salidaCompleta += renglonSalida;
					salidaCompleta += cadenaReferencias + "\n";
				}

			}// if( entradasSeparadas.length>=45 )// Si hay datos
				// suficientes en el rengl�n
			contador++;
		}// while( contador<renglones.length )

		areaTexto.append("\t OK!");
		areaTexto.append("\n\nEscribiendo en archivos...");

		// Crea la carpeta de resultados		
		String ruta_resultados2 = "Salidas\\Scopus\\";
		folder = new File(ruta_resultados);
		folder.mkdirs();
				
		// cadena =
		// "Autores\tT�tulo\tA�o\tPublicaci�n\tVolumen\tN�mero\tInstituci�n\tPa�sC�digo\tPa�sNombre\tKeyWords\tTipo\n";
		cadena = "";
		cadena += salidaCompleta;
		new EscribirEnArchivoTexto(cadena, ruta_resultados + "\\"
				+ nombreArchivoLimpio + "_Scopus_ingreso_BD.txt");

		// System.out.println( ruta_resultados + "\\" + nombreArchivoLimpio
		// + "_ingreso_BD.txt" );

		progressBar.setValue(100);
		progressBar.repaint();

		areaTexto.append("\t OK!");
		areaTexto.append("\n\n\n\n>> Listo para procesar otro archivo.\n\n\n");

		botonSeleccionadorArchivos.setEnabled(true);
		botonIniciar.setEnabled(true);
		source.setSelectedIndex(0);
	}
	
	/**
	 * Este m�todo realiza el procesamiento del archivo de entraa considerando
	 * que proviene de WOS.
	 * 
	 * @author EGarciaCanoCa (17/Octubre/2013)
	 */
	public void fromWOS() {
		int contador = 0;
		int indice = 0;

		String nombreArchivoLimpio = "";
		String[] nombre_aux;

		indice = archivosOriginales[0].indexOf('.');
		nombreArchivoLimpio = archivosOriginales[0].substring(0, indice);
		nombre_aux = nombreArchivoLimpio.split("_");
		nombreArchivoLimpio = nombre_aux[0];

		LeerArchivoTexto lectura;

		String[] entradasSeparadas;
		String[] encabezado;
		String cadenaArchivo = "";
		String cadena = "";

		String renglonSalida = "";

		String cadenaReferencias = "";

		String palabra = "";
		String[] palabras;
		String nada = "";
		int tipo = 0;
		int columnaActual = 0;
		int cuentaPalabras = 0;
		boolean datosEsenciales = true;
		String salidaCompleta = "";

		lectura = new LeerArchivoTexto(archivosOriginales_conRuta[0]);

		lectura = new LeerArchivoTexto(archivosOriginales_conRuta[0]);

		cadenaArchivo = lectura.getArchivoEnCadena();

		progressBar.setValue(0);

		areaTexto.append("\nLimpiando texto...");

		cadenaArchivo = quitaCaracteresEspeciales(cadenaArchivo);
		cadenaArchivo = cadenaArchivo.toUpperCase();

		progressBar.setValue(15);

		// Crea la carpeta de resultados
		File folder2;
		String ruta_resultados2 = "Salidas\\WOS\\";
		folder2 = new File(ruta_resultados2);
		folder2.mkdirs();

		// Se leen todos los renglones del archivo
		renglones = cadenaArchivo.split("\n");

		// guardo los valores del encabezado para conocer las posiciones de
		// cada elemento
		encabezado = renglones[0].split("\t");

		contador = 1; // la primera l�nea es el encabezado

		progressBar.setValue(20);
		areaTexto.append("\t\t OK!");
		areaTexto.append("\n\nProcesando informaci�n...");

		int cuentaPalabrasIngresadas = 0;
		String cadenaAutores = "";
		// Imprime encabezado
		salidaCompleta = "";
		salidaCompleta += "REF. ORIGINAL COMPLETA" + "\t";
		salidaCompleta += "ES PRINCIPAL" + "\t";
		for (int i = 0; i < MAX_NUMERO_AUTORES; i++)
			salidaCompleta += "AUTOR " + (i + 1) + "\t";
		for (int i = 0; i < MAX_NUMERO_AUTORES; i++)
			salidaCompleta += "INSTITUCION " + (i + 1) + "\t";
		salidaCompleta += "TITULO" + "\t";
		salidaCompleta += "ANIO" + "\t";
		salidaCompleta += "PUBLICACION" + "\t";
		salidaCompleta += "VOLUMEN" + "\t";
		salidaCompleta += "NUMERO" + "\t";
		salidaCompleta += "TIPO" + "\t";
		for (int i = 0; i < MAX_NUMERO_PALABRAS; i++)
			salidaCompleta += "PALABRA_CLAVE " + (i + 1) + "\t";
		salidaCompleta += "IDIOMA ORIGINAL" + "\t";
		salidaCompleta += "CORRESPONDING AUTHOR" + "\t";
		salidaCompleta += "ABSTRACT" + "\t";
		salidaCompleta += "REF. TOTALES" + "\t";
		salidaCompleta += "REF. ACTUALES" + "\t";
		salidaCompleta += "PATRON DE REF." + "\t";
		salidaCompleta += "DESCONOCIDO EN REF." + "\n";

		while (contador < renglones.length) {
			datosEsenciales = true;
			entradasSeparadas = renglones[contador].split("\t");

			if (entradasSeparadas.length >= 40)// Si hay datos suficientes
												// en el rengl�n
			{
				
				if(contador == 1)
					renglonSalida = sourceName+"\t";
				else
					renglonSalida = "\t"; // Como es principal, el campo REF. ORIGINAL COMPLETA va vac�o 
				renglonSalida += "GRRRU\t"; // Como es principal, el campo ES PRINCIPAL lleva una marca

				// Autores CON AFILIACIONES
				columnaActual = encuentraIndice(encabezado, "C1");
				entradasSeparadas[columnaActual] = entradasSeparadas[columnaActual].trim();
							
				if (columnaActual != -1 && !entradasSeparadas[columnaActual].isEmpty()){

					//Eric Gcc
					String [] resultado = parseC1Wos(entradasSeparadas[columnaActual],true);
					cadenaAutores = resultado[0] + resultado[1];
				}				
				else if (columnaActual != -1){
					columnaActual = encuentraIndice(encabezado, "AF");
					entradasSeparadas[columnaActual] = entradasSeparadas[columnaActual].trim();
					String [] resultado = parseC1Wos(entradasSeparadas[columnaActual],false);
					cadenaAutores = resultado[0] + resultado[1];
				} else {
				}

				// ENCUENTRA EL TITULO DEL DOCUMENTO
				columnaActual = encuentraIndice(encabezado, "TI");
				
				if (columnaActual != -1) {
				} else {
				}

				if (cadenaAutores.length() > 0) // Si hay autores; si no, no vale la pena ingresar el dato
				{
					renglonSalida += cadenaAutores;
					//renglonSalida += cadenaInstituciones;

					// T�tulo (posici�n 2)
					columnaActual = encuentraIndice(encabezado, "TI");

					if (columnaActual != -1)
						cadena = entradasSeparadas[columnaActual].toUpperCase();
					else
						cadena = nada;

					cadena = cadena.replace("\'", "");
					cadena = cadena.replace("-", "");
					cadena = cadena.replace("\"", "");
					cadena = cadena.replace(".", "");
					cadena = cadena.replace(":", "");
					cadena = cadena.replace("?", "");
					cadena = cadena.replace("!", "");
					cadena = cadena.replace("&", "AND");
					cadena = cadena.trim();

					if (cadena.length() > 0) // Si hay un t�tulo
					{

						renglonSalida += cadena + "\t";							
						
						// A�o (posici�n 3)
						columnaActual = encuentraIndice(encabezado, "PY");

						if (columnaActual != -1)
							cadena = entradasSeparadas[columnaActual].toUpperCase();
						else
							cadena = nada;

						cadena = cadena.trim();

						if (cadena.length() > 0) // Si hay un a�o
						{							
							renglonSalida += cadena + "\t";							
							
							// TIPO (SE AGREGA AL FINAL)
							// Tipo de documento (posici�n 39)
							columnaActual = encuentraIndice(encabezado, "DT");

							if (columnaActual != -1)
								cadena = entradasSeparadas[columnaActual].toUpperCase();
							else
								cadena = nada;

							// Tipo por defecto: Art�culo
							tipo = 1;

							if(cadena.contains("MEETING") || cadena.contains("PROCEEDINGS"))
								tipo = 7;
							else
								tipo = 1;
							
							// Publicaci�n (posici�n 4)
							columnaActual = encuentraIndice(encabezado,"SO");

							if (columnaActual != -1 && pubHomologada.isEmpty())
								cadena = entradasSeparadas[columnaActual].toUpperCase();
							else if(!pubHomologada.isEmpty())
								cadena = pubHomologada;
							else
								cadena = nada;

							cadena = cadena.replace("\'", "");
							cadena = cadena.replace("\"", "");
							// cadena = cadena.replace(".","");
							cadena = cadena.replace(":", "");
							cadena = cadena.replace("?", "");
							cadena = cadena.replace("!", "");
							cadena = cadena.replace("&", "AND");
							cadena = cadena.trim();

							// Se crea el objeto limpiador de nombres de
							// publicaciones
							
							/**
							 * @author EGarciaCanoCa (10/10/2013)
							 */
							// Para WOS esto no ser� necesario
							CompletarPublicacion pubs = CompletarPublicacion.getInstnacia("ISSN.txt");
							cadena = pubs.completaISSN(cadena);

							if (tipo == 7 || tipo == 1) // Es una conferencia; hay que quitar el a�o y cosas como 1st, 2nd, 3rd, 4th, etc.
							{
								cadena = limpiaConferencia(cadena);
							}

							if (cadena.length() > 0) // Si hay una publicaci�n
							{

								renglonSalida += cadena + "\t";

								// Volumen (posici�n 40)
								columnaActual = encuentraIndice(encabezado,"VL");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual].toUpperCase();
								else
									cadena = nada;

								cadena = cadena.replace(" ", "-");
								cadena = cadena.replace(":", "-");
								cadena = cadena.replace("&", "-");
								cadena = cadena.trim();

								if (cadena.length() == 0) // Si no hay un
															// volumen
									cadena = "";

								renglonSalida += cadena + "\t";

								// ISSUE (posici�n 41)
								columnaActual = encuentraIndice(encabezado,"IS");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual].toUpperCase();
								else
									cadena = nada;

								cadena = cadena.replace(" ", "-");
								cadena = cadena.replace(":", "-");
								cadena = cadena.replace("&", "-");
								cadena = cadena.trim();

								if (cadena.length() == 0) // Si no hay un n�mero
									cadena = "";

								renglonSalida += cadena + "\t";

								// TIPO
								renglonSalida += tipo + "\t";

								// KEY WORDS (posici�n 16)
								columnaActual = encuentraIndice(encabezado,"DE");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual].toUpperCase();
								else
									cadena = nada;

								cadena = cadena.replace(".", "");
								cadena = cadena.replace("\'", "");
								cadena = cadena.replace("\"", "");
								cadena = cadena.replace(":", "");
								cadena = cadena.replace(",", "");

								// Cuando no hay keyWords, �stas no se ponen
								palabras = cadena.split(";");

								cuentaPalabras = 0;
								cuentaPalabrasIngresadas = 0;
								while (cuentaPalabras < palabras.length
										&& cuentaPalabras < MAX_NUMERO_PALABRAS) {
									palabra = palabras[cuentaPalabras].trim();

									if (palabra.length() > 0) // Si no es  una palabra vac�a
									{
										/*
										 * if( cuentaPalabras==0 ) renglonSalida
										 * += ""; else renglonSalida += "\t";
										 * 
										 * // AGREGAMOS LA PALABRA
										 */
										renglonSalida += palabra + "\t";
										cuentaPalabrasIngresadas++;
									}
									cuentaPalabras++;
								}

								// renglonSalida += "\t";
								for (int i = cuentaPalabrasIngresadas; i < MAX_NUMERO_PALABRAS; i++) {
									renglonSalida += "\t";
								}

								// IDIOMA (posici�n 37)
								columnaActual = encuentraIndice(encabezado,"LA");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual].toUpperCase();
								else
									cadena = nada;

								// Valores:
								// 1 INGLES
								// 2 ESPA�OL
								// 9 NO DISPONIBLE
								// 10 OTRO

								if (cadena.compareTo("ENGLISH") == 0)
									cadena = "1"; // Ingl�s
								else {
									if (cadena.length() == 0)
										cadena = "9"; // No disponible
									else {
										if (cadena.compareTo("SPANISH") == 0)
											cadena = "2";// Espa�ol
										else
											cadena = "10";// Otro
									}
								}

								renglonSalida += cadena + "\t";

								// Lo quite
								// CORRESPONDING AUTHOR (posici�n 24)
								// NOTA: est� validado para que no haya un
								// corresponding auhtor
								// que no haya sido ingresado como autor en
								// la lista de autores
								// y para que el nombre del corresponding
								// author se escriba exactamente
								// como se ingres� en un inicio
								renglonSalida += "SIN CORRESPONDIG" + "\t";

								// ABSTRACT (posici�n 15)
								columnaActual = encuentraIndice(encabezado,"AB");

								if (columnaActual != -1)
									cadena = entradasSeparadas[columnaActual].toUpperCase();
								else
									cadena = nada;

								renglonSalida += cadena + "\t";							

								// Marca de final
								renglonSalida += "***\t";

							}// if( cadena.length() > 0 ) // Si hay una
								// publicaci�n
							else
								datosEsenciales = false;
						}// if( cadena.length() > 0 ) // Si hay un a�o
						else
							datosEsenciales = false;
					}// if( cadena.length() > 0 ) // Si hay un t�tulo
					else
						datosEsenciales = false;
				}// if( renglonSalida.length()>0 ) // Si hay autores; si no,
					// no vale la pena ingresar el dato
				else
					datosEsenciales = false;

				if (datosEsenciales) {
					salidaCompleta += renglonSalida;
					salidaCompleta += cadenaReferencias + "\n";
				}

			}// if( entradasSeparadas.length>=45 )// Si hay datos
				// suficientes en el rengl�n
			contador++;
		}// while( contador<renglones.length )

		areaTexto.append("\t OK!");
		areaTexto.append("\n\nEscribiendo en archivos...");

		// Crea la carpeta de resultados
		File folder;
		String ruta_resultados = "Salidas\\WOS\\";
		folder = new File(ruta_resultados);
		folder.mkdirs();
		// cadena =
		// "Autores\tT�tulo\tA�o\tPublicaci�n\tVolumen\tN�mero\tInstituci�n\tPa�sC�digo\tPa�sNombre\tKeyWords\tTipo\n";
		cadena = "";
		cadena += salidaCompleta;
		new EscribirEnArchivoTexto(cadena, ruta_resultados + "\\"
				+ nombreArchivoLimpio + "_WOS_ingreso_BD.txt");

		// System.out.println( ruta_resultados + "\\" + nombreArchivoLimpio
		// + "_ingreso_BD.txt" );

		progressBar.setValue(100);
		progressBar.repaint();

		areaTexto.append("\t OK!");
		areaTexto.append("\n\n\n\n>> Listo para procesar otro archivo.\n\n\n");

		botonSeleccionadorArchivos.setEnabled(true);
		botonIniciar.setEnabled(true);
		source.setSelectedIndex(0);
	}

	/**
	 * 
	 * Este m�todo parse el campo C1(autores con afiliaciones) de los documentos
	 * provenientes de WOS. De tal manera que regresa un arreglo que contiene
	 * los autores de un determinado documento y la insituci�n a la que
	 * pertencen.
	 * 
	 * @author EGarciaCanoCa (18/Octubre/2013)
	 * @param C1
	 *            Es la cadena que contiene a los autores con sus respectivas
	 *            instituciones, el parametro se llama C1 por conservar el
	 *            nombre que WOS le asigna a dicha columna.
	 * @return Un par de cadenas donde el primer elemento del arreglo representa
	 *         la cadena de autores y el segundo elemento representa a la cadena
	 *         de afiliaciones
	 */
	public String [] parseC1Wos(String C1, boolean isC1){
		int character; 
		int cuentaAutores;
		int cuentaAfiliaciones;
		String [] autores = null;
		String cadenaAutores = "";
		String cadenaAfiliaciones = "";
		CatalogoPaises cp = new CatalogoPaises();
			
				
		Hashtable<String, String> autoresConAfiliacion = new Hashtable<String, String>();
		CompletarPublicacion pubs = CompletarPublicacion.getInstnacia("ISSN.txt");
		
		int beginIndex = 0;
		boolean terminaronAutores = false;
		cuentaAutores = 0;
		cuentaAfiliaciones = 0;
		
		if(isC1){
			// Se recorre toda la cadena
			for(character = 0; character < C1.length(); character++){			
				// Los corchetes identifican a los autores de una institucion
				if(C1.charAt(character) == '['){
					beginIndex = character;
					terminaronAutores = false;
				}
				if(C1.charAt(character) == ']'){						
					terminaronAutores = true;
					
					// Se sapara cada autor
					autores = C1.substring(beginIndex+1, character).split(";");			
					
					// Se le quitan los espaciones y se convierte a may�scula
					for(int i = 0; i < autores.length; i++){
						autores[i] = autores[i].trim().toUpperCase();		
						autores[i] = autores[i].replace(".", "");
						autores[i] = autores[i].replace("\'", "");
						
						
						// Para juntar iniciales en el nombre, por ejemplo: DAY, S A => DAY,SA ; SHIN, PAUL J K => SHIN, PAUL JK
						//Se separa el nombre del autor por apellido y nombre
						String [] tokensAutor = autores[i].split(",");
						
						// Si efectivamente, tiene apellido y nombre
						if(tokensAutor.length > 1 && tokensAutor[1].length() > 1){// tokens[1] son los nombres
							String [] auxAutor = tokensAutor[1].split(" ");
							
							if(auxAutor.length > 1){
								String nombre = "";
								for(int j = 0; j < auxAutor.length; j++){ 
									
									if(auxAutor[j].length() > 1){
										nombre += auxAutor[j] + " ";
									}else{
										nombre += auxAutor[j];									
									}
								}
								autores[i] = tokensAutor[0]+","+nombre.trim();
							}						
						}
					}
					for(String autor : autores){					
						if(!autoresConAfiliacion.containsKey(autor)){
							//System.out.println(!autoresConAfiliacion.contains(autor.trim()) + " " + autor);
							autoresConAfiliacion.put(autor, "");
							
							if(cuentaAutores < MAX_NUMERO_AUTORES){
								cadenaAutores += autor + "\t";
								cuentaAutores++;
							}
						}
					}				
					beginIndex = character+1;			
				}
				// El ; separa a los autores de una institucion de los autores de otra
				if((C1.charAt(character) == ';' && terminaronAutores == true) || character == C1.length()-1){
					String [] afiliaciones = null;
					String afiliacion = null;
					
					afiliaciones = C1.substring(beginIndex, character+1).trim().split(",");	
					
					for(int i = 0; i < afiliaciones.length; i++)
						afiliaciones[i] = afiliaciones[i].trim().toUpperCase();	
					
					afiliaciones[afiliaciones.length-1] = afiliaciones[afiliaciones.length-1].replace(";", "").replaceAll("[0-9]+", "");
										
					afiliaciones[afiliaciones.length-1] = cp.validaPais(afiliaciones[afiliaciones.length-1]);
					
					afiliacion = pubs.completaISSN(afiliaciones[0]) + "," + afiliaciones[afiliaciones.length-1];							
					
					for(String autor : autores){
						if(autoresConAfiliacion.get(autor).isEmpty()){						
							autoresConAfiliacion.put(autor, afiliacion.trim());
							
							if(cuentaAfiliaciones < MAX_NUMERO_AUTORES){						
								cadenaAfiliaciones += autoresConAfiliacion.get(autor) + "\t";
								cuentaAfiliaciones++;
							}
						}
					}
						
				}	
				
				// Caso especial de un solo autor
				if(character == 0 && C1.charAt(character) != '['){
					String [] singleAuthor = null;
					singleAuthor = C1.trim().split(",");
					cadenaAutores = singleAuthor[0].trim() + "\t";

					singleAuthor[singleAuthor.length-1] = cp.validaPais(singleAuthor[singleAuthor.length-1]);

					cadenaAfiliaciones = singleAuthor[0].trim()+","+singleAuthor[singleAuthor.length-1].trim() + "\t";	
					cuentaAutores++;
					break;
				}
			}// Fin for	
		}// Fin if(isC1)
		else{
			// Se sapara cada autor
			autores = C1.split(";");		
			
			for(int i = 0; i < autores.length; i++){
				autores[i] = autores[i].trim().toUpperCase();		
				autores[i] = autores[i].replace(".", "");
				autores[i] = autores[i].replace("\'", "");
				autores[i] = autores[i].replace("[", "");
				autores[i] = autores[i].replace("]", "");
				
				// Para juntar iniciales en el nombre, por ejemplo: DAY, S A => DAY,SA ; SHIN, PAUL J K => SHIN, PAUL JK
				//Se separa el nombre del autor por apellido y nombre
				String [] tokensAutor = autores[i].split(",");
				
				// Si efectivamente, tiene apellido y nombre
				if(tokensAutor.length > 1 && tokensAutor[1].length() > 1){// tokens[1] son los nombres
					String [] auxAutor = tokensAutor[1].split(" ");
					
					if(auxAutor.length > 1){
						String nombre = "";
						for(int j = 0; j < auxAutor.length; j++){ 
							
							if(auxAutor[j].length() > 1){
								nombre += auxAutor[j] + " ";
							}else{
								nombre += auxAutor[j];									
							}
						}
						autores[i] = tokensAutor[0]+","+nombre.trim();
					}						
				}
			}
			for(String autor : autores){					
				if(!autoresConAfiliacion.containsKey(autor)){
					//System.out.println(!autoresConAfiliacion.contains(autor.trim()) + " " + autor);
					autoresConAfiliacion.put(autor, "");
					
					if(cuentaAutores < MAX_NUMERO_AUTORES){
						cadenaAutores += autor + "\t";						
						cadenaAfiliaciones += "\t";
						//cadenaAfiliaciones += "NO DISPONIBLE,NO DISPONIBLE\t";
						cuentaAutores++;
					}
				}			
			}
		}	
		
		
		for (int i = cuentaAutores; i < MAX_NUMERO_AUTORES; i++) {
			cadenaAutores += "\t";
			cadenaAfiliaciones += "\t";
		}

		
		/*
		for(String autor: autores){
			cadenaAutores += autor + "\t";			
			cadenaAfiliaciones += autoresConAfiliacion.get(autor) + "\t";
		}*/		
		
		/*
		Set set = autoresConAfiliacion.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry entry = (Entry<String, String>) it.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
			
		}*/
		
		return new String[]{cadenaAutores,cadenaAfiliaciones};
	}	
	
	int encuentraIndice(String[] arreglo, String cadenaAencontrar) {
		int indice = 0;

		while (indice < arreglo.length) {
			if (arreglo[indice].compareTo(cadenaAencontrar) == 0)
				return indice;
			indice++;
		}
		return -1;
	}
	
	String limpiaConferencia(String cadena) {
		cadena = cadena.concat(" ");

		// Eric Gcc: Mejora a la limpieza de conferencias
		// Quitamos "PROCEEDINGS OF THE"
		// System.out.println(cadena);
		cadena = cadena.replaceAll("PROCEEDINGS OF THE", " ");
		cadena = cadena.replaceAll("PROCEEDINGS OF", " ");
		cadena = cadena.replaceAll("PROCEEDINGS,", " ");
		cadena = cadena.replaceAll("PROCEEDINGS", " ");

		cadena = cadena.replaceAll("PROCEEDING OF THE", " ");
		cadena = cadena.replaceAll("PROCEEDING OF", " ");
		cadena = cadena.replaceAll("PROCEEDING,", " ");
		cadena = cadena.replaceAll("PROCEEDING", " ");

		cadena = cadena.replaceAll("PROC. OF CONF.", " ");
		cadena = cadena.replaceAll("PROC.", " ");

		cadena = cadena.replaceAll("[0-9]+(\\s)?(RD|TH|ND|ST)", " ");

		/*
		 * cadena = cadena.replaceAll("(\\s)?(PROCEEDINGS OF (THE )?)"," ");
		 * cadena = cadena.replaceAll(",(\\s)?PROCEEDINGS( OF (THE )?)?"," ");
		 */

		// Quitamos algunos n�meros ordinales con letra
		// letra
		cadena = cadena
				.replaceAll(
						"FIRST |SECOND |THIRD |FOURTH |FIFTH |SIXTH |SEVENTH |EIGHTH |NINTH |TENTH |ELEVENTH |TWELFTH |THIRTEENTH |FOURTEENTH |FIFTEENTH |SIXTEENTH |SEVENTEENTH |EIGHTEENTH |NINETEENTH |TWENTIETH ",
						" ");
		// n�meros ordinales del 1st al 999th
		cadena = cadena.replaceAll(
				"(\\d\\d?\\d?ST|\\d\\d?\\d?ND|\\d\\d?\\d?RD|\\d\\d?\\d?TH) ",
				" ");

		// Quitamos valores como VOL 1, VOL I VOLS 1&2, etc:
		// N�meros ar�bigos
		cadena = cadena.replaceAll(
				"(,? ?VOLS? \\d\\d? ?(&|AND|,)? ?\\d\\d? ?,?)", " ");
		cadena = cadena.replaceAll(
				",? ?VOL \\d\\d?\\d? ?,? ?(\\d\\d?\\d?([^A-Z]|$))?,?", " ");

		// N�meros romanos
		cadena = cadena
				.replaceAll(
						"(,? ?VOLS? III ?(&|AND|,)? ?IV ?,?)|(,? ?VOLS? II ?(&|AND|,)? ?III ?,?)|(,? ?VOLS? IV ?(&|AND|,)? ?V ?,?)|(,? ?VOLS? IX ?(&|AND|,)? ?X ?,?)|(,? ?VOLS? VIII ?(&|AND|,)? ?IX ?,?)|(,? ?VOLS? VII ?(&|AND|,)? ?VIII ?,?)|(,? ?VOLS? VI ?(&|AND|,)? ?VII ?,?)|(,? ?VOLS? V ?(&|AND|,)? ?VI ?,?)|(,? ?VOLS? I ?(&|AND|,)? ?II ?,?)",
						" ");
		cadena = cadena
				.replaceAll(
						"(,? ?VOL III ?,?)|(,? ?VOL II ?,?)|(,? ?VOL IV ?,?)|(,? ?VOL IX ?,?)|(,? ?VOL VIII ?,?)|(,? ?VOL VII ?,?)|(,? ?VOL VI ?,?)|(,? ?VOL V ?,?)|(,? ?VOL X ?,?)|(,? ?VOL I ?,?)",
						" ");

		// Quitamos valores como PART 1, PT I PARTS 1&2, etc:
		// letra
		cadena = cadena
				.replaceAll(
						"(,? ?(PARTS?|PTS?) A ?(&|AND|,)? ?B ?,?)|(,? ?(PARTS?|PTS?) B ?(&|AND|,)? ?C ?,?)|(,? ?(PARTS?|PTS?) C ?(&|AND|,)? ?D ?,?)|(,? ?(PARTS?|PTS?) D ?(&|AND|,)? ?E ?,?)|(,? ?(PARTS?|PTS?) E ?(&|AND|,)? ?F ?,?)|(,? ?(PARTS?|PTS?) F ?(&|AND|,)? ?G ?,?)|(,? ?(PARTS?|PTS?) G ?(&|AND|,)? ?H ?,?)|(,? ?(PARTS?|PTS?) H ?(&|AND|,)? ?I ?,?)|(,? ?(PARTS?|PTS?) I ?(&|AND|,)? ?J ?,?)",
						" ");
		cadena = cadena
				.replaceAll(
						"(,? ?(PART|PT) A ?,?)|(,? ?(PART|PT) B ?,?)|(,? ?(PART|PT) C ?,?)|(,? ?(PART|PT) D ?,?)|(,? ?(PART|PT) E ?,?)|(,? ?(PART|PT) F ?,?)|(,? ?(PART|PT) G ?,?)|(,? ?(PART|PT) H ?,?)|(,? ?(PART|PT) I ?,?)|(,? ?(PART|PT) J ?,?)",
						" ");

		// n�meros romanos
		cadena = cadena
				.replaceAll(
						"(,? ?(PARTS?|PTS?) III ?(&|AND|,)? ?IV ?,?)|(,? ?(PARTS?|PTS?) II ?(&|AND|,)? ?III ?,?)|(,? ?(PARTS?|PTS?) IV ?(&|AND|,)? ?V ?,?)|(,? ?(PARTS?|PTS?) IX ?(&|AND|,)? ?X ?,?)|(,? ?(PARTS?|PTS?) VIII ?(&|AND|,)? ?IX ?,?)|(,? ?(PARTS?|PTS?) VII ?(&|AND|,)? ?VIII ?,?)|(,? ?(PARTS?|PTS?) VI ?(&|AND|,)? ?VII ?,?)|(,? ?(PARTS?|PTS?) V ?(&|AND|,)? ?VI ?,?)|(,? ?(PARTS?|PTS?) I ?(&|AND|,)? ?II ?,?)",
						" ");
		cadena = cadena
				.replaceAll(
						"(,? ?(PART|PT) III ?,?)|(,? ?(PART|PT) II ?,?)|(,? ?(PART|PT) IV ?,?)|(,? ?(PART|PT) IX ?,?)|(,? ?(PART|PT) VIII ?,?)|(,? ?(PART|PT) VII ?,?)|(,? ?(PART|PT) VI ?,?)|(,? ?(PART|PT) V ?,?)|(,? ?(PART|PT) X ?,?)|(,? ?(PART|PT) I ?,?)",
						" ");

		// N�meros ar�bigos
		cadena = cadena.replaceAll(
				"(,? ?(PARTS?|PTS?) \\d\\d? ?(&|AND|,)? ?\\d\\d? ?,?)", " ");
		cadena = cadena.replaceAll(",? ?(PART|PT) \\d\\d?\\d? ?,?", " ");

		// QUITAMOS N�meros Romanos I-XX
		cadena = cadena
				.replaceAll(
						"[^A-Z0-9]III[^A-Z0-9]|[^A-Z0-9]II[^A-Z0-9]|[^A-Z0-9]IV[^A-Z0-9]|[^A-Z0-9]IX[^A-Z0-9]|[^A-Z0-9]VIII[^A-Z0-9]|[^A-Z0-9]VII[^A-Z0-9]|[^A-Z0-9]VI[^A-Z0-9]|[^A-Z0-9]V[^A-Z0-9]|[^A-Z0-9]XIII[^A-Z0-9]|[^A-Z0-9]XII[^A-Z0-9]|[^A-Z0-9]XIV[^A-Z0-9]|[^A-Z0-9]XIX[^A-Z0-9]|[^A-Z0-9]XVIII[^A-Z0-9]|[^A-Z0-9]XVII[^A-Z0-9]|[^A-Z0-9]XVI[^A-Z0-9]|[^A-Z0-9]XV[^A-Z0-9]|[^A-Z0-9]XX[^A-Z0-9]|[^A-Z0-9]XI[^A-Z0-9]|[^A-Z0-9]X[^A-Z0-9]|[^A-Z0-9]I[^A-Z0-9]",
						" ");
		cadena = cadena
				.replaceAll(
						"^III[^A-Z0-9]|^II[^A-Z0-9]|^IV[^A-Z0-9]|^IX[^A-Z0-9]|^VIII[^A-Z0-9]|^VII[^A-Z0-9]|^VI[^A-Z0-9]|^V[^A-Z0-9]|^XIII[^A-Z0-9]|^XII[^A-Z0-9]|^XIV[^A-Z0-9]|^XIX[^A-Z0-9]|^XVIII[^A-Z0-9]|^XVII[^A-Z0-9]|^XVI[^A-Z0-9]|^XV[^A-Z0-9]|^XX[^A-Z0-9]|^XI[^A-Z0-9]|^X[^A-Z0-9]|^I[^A-Z0-9]",
						" ");

		// Quitamos a�os:
		cadena = cadena
				.replaceAll(
						"\\((2000|2001|2002|2003|2004|2005|2006|2007|2008|2009|2010|2011|2012|2013|2014|2015)\\)",
						" ");
		cadena = cadena
				.replaceAll(
						"^?[^A-Z0-9\\(]?(2000|2001|2002|2003|2004|2005|2006|2007|2008|2009|2010|2011|2012|2013|2014|2015)[^A-Z0-9\\)]?$?",
						" ");

		// Quitamos posibles dobles espacios:
		cadena = cadena.replaceAll("  ", " ");
		cadena = cadena.replaceAll("  ", " ");
		cadena = cadena.replaceAll("  ", " ");

		// Quitamos espacios extra al inicio o final:
		cadena = cadena.trim();

		// Quitamos la ABREVIATURA al final del tipo: CONFERENCIA (CONF 09)
		cadena = cadena.concat("FINDENOMBRECONF");
		// System.out.println(cadena);
		cadena = cadena.replaceAll(
				"\\(([A-Z0-9])+ ?(\\d\\d)?\\)FINDENOMBRECONF", " ");
		cadena = cadena.replaceAll("FINDENOMBRECONF", " ");

		// Quitamos posibles dobles espacios:
		cadena = cadena.replaceAll("  ", " ");
		cadena = cadena.replaceAll("  ", " ");
		cadena = cadena.replaceAll("  ", " ");

		// Quitamos espacios extra al inicio o final:
		cadena = cadena.trim();
		// System.out.println("\t>>>"+cadena);
		/*
		 * String testea=
		 * "OMAE 2008 PROCEEDINGS OF THE 27TH INTERNATIONAL CONFERENCE ON OFFSHORE MECHANICS AND ARCTIC ENGINEERING 2008, VOL 2"
		 * ; testea=testea.replaceAll(
		 * "(\\dST|\\d\\dST|\\d\\d\\dST|\\dNd|\\d\\dNd|\\d\\d\\dNd|\\dRd|\\d\\dRd|\\d\\d\\dRd|\\dTH|\\d\\dTH|\\d\\d\\dTH) "
		 * ,""); System.out.println(testea);
		 */
		return cadena;
	}
	
	public String analizaAfiliaciones(String afiliacionCompleta,
			String nombreArchivoLimpio) {
		String afiliacion = "";
		CatalogoInstituciones catalogo;

		catalogo = new CatalogoInstituciones();

		// Analizamos el campo de afiliaci�n y extraemos �nicamente el valor de
		// la instituci�n
		afiliacion = catalogo.extraeAfiliacion(afiliacionCompleta,
				nombreArchivoLimpio);

		return afiliacion;
	}
	
	String ordenaFrecuencias(Hashtable frecuencias) {
		String resultado = "";
		// Put keys and values in to an arraylist using entryset
		ArrayList myArrayList = new ArrayList(frecuencias.entrySet());

		// Sort the values based on values first and then keys.
		Collections.sort(myArrayList, new MiComparador());

		// Show sorted results
		Iterator itr = myArrayList.iterator();
		String key = "";
		int value = 0;

		while (itr.hasNext()) {
			Map.Entry e = (Map.Entry) itr.next();

			key = (String) e.getKey();
			value = ((Integer) e.getValue()).intValue();

			resultado += key + "\t" + value + "\n";
		}
		return resultado;
	}// String ordenaFrecuencias( Hashtable frecuencias, int frecTotal )


	
	/**
	 * Create the frame.
	 */
	public XSVToSCIT() {
		setResizable(false);
		setAutoRequestFocus(false);
		getContentPane().setBackground(new Color(51, 51, 51));
		setTitle("SCIT - Importador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 594);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		botonSeleccionadorArchivos = new JButton("Seleccionar archivo");
		springLayout.putConstraint(SpringLayout.WEST, botonSeleccionadorArchivos, 24, SpringLayout.WEST, getContentPane());
		botonSeleccionadorArchivos.setForeground(Color.WHITE);
		botonSeleccionadorArchivos.setBackground(new Color(51, 51, 51));
		getContentPane().add(botonSeleccionadorArchivos);
		
		botonIniciar = new JButton("Iniciar");
		springLayout.putConstraint(SpringLayout.WEST, botonIniciar, 38, SpringLayout.EAST, botonSeleccionadorArchivos);
		springLayout.putConstraint(SpringLayout.EAST, botonIniciar, -21, SpringLayout.EAST, getContentPane());
		botonIniciar.setForeground(Color.WHITE);
		botonIniciar.setBackground(new Color(51, 51, 51));
		getContentPane().add(botonIniciar);
		
		JLabel lblNewLabel = new JLabel("SCIT");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 24, SpringLayout.WEST, getContentPane());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Importador de documentos");
		springLayout.putConstraint(SpringLayout.EAST, botonSeleccionadorArchivos, -7, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 11, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 24, SpringLayout.WEST, getContentPane());
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblVersion = new JLabel("1.8.3.1311rc");
		springLayout.putConstraint(SpringLayout.NORTH, lblVersion, 6, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblVersion, 0, SpringLayout.WEST, botonSeleccionadorArchivos);
		lblVersion.setForeground(Color.GRAY);
		lblVersion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		getContentPane().add(lblVersion);
		
		JLabel lblSeleccionarFuente = new JLabel("Seleccionar fuente");
		springLayout.putConstraint(SpringLayout.SOUTH, botonSeleccionadorArchivos, -21, SpringLayout.NORTH, lblSeleccionarFuente);
		springLayout.putConstraint(SpringLayout.WEST, lblSeleccionarFuente, 24, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblSeleccionarFuente, 170, SpringLayout.NORTH, getContentPane());
		lblSeleccionarFuente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSeleccionarFuente.setForeground(Color.WHITE);
		getContentPane().add(lblSeleccionarFuente);
		
		source = new JComboBox();
		source.setForeground(Color.BLACK);
		source.setBackground(SystemColor.menu);
		springLayout.putConstraint(SpringLayout.SOUTH, botonIniciar, -47, SpringLayout.NORTH, source);
		springLayout.putConstraint(SpringLayout.WEST, source, 24, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, source, -21, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, source, 6, SpringLayout.SOUTH, lblSeleccionarFuente);
		springLayout.putConstraint(SpringLayout.SOUTH, source, 29, SpringLayout.SOUTH, lblSeleccionarFuente);
		source.setModel(new DefaultComboBoxModel<String>(new String[]{"","Scopus","Web Of Science", "Otros"}));
		getContentPane().add(source);
		
		JLabel lblPublicacinHomologada = new JLabel("Publicaci\u00F3n homologada (opcional)");
		springLayout.putConstraint(SpringLayout.NORTH, lblPublicacinHomologada, 13, SpringLayout.SOUTH, source);
		springLayout.putConstraint(SpringLayout.WEST, lblPublicacinHomologada, 24, SpringLayout.WEST, getContentPane());
		lblPublicacinHomologada.setForeground(Color.WHITE);
		lblPublicacinHomologada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getContentPane().add(lblPublicacinHomologada);
		
		txtPublicacionHomolodaga = new JTextField();
		txtPublicacionHomolodaga.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, txtPublicacionHomolodaga, 6, SpringLayout.SOUTH, lblPublicacinHomologada);
		springLayout.putConstraint(SpringLayout.WEST, txtPublicacionHomolodaga, 24, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtPublicacionHomolodaga, 34, SpringLayout.SOUTH, lblPublicacinHomologada);
		springLayout.putConstraint(SpringLayout.EAST, txtPublicacionHomolodaga, -21, SpringLayout.EAST, getContentPane());
		txtPublicacionHomolodaga.setBackground(new Color(51, 51, 51));
		getContentPane().add(txtPublicacionHomolodaga);
		txtPublicacionHomolodaga.setColumns(10);
		
		progressBar = new JProgressBar(0,100);
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 11));
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 18, SpringLayout.SOUTH, txtPublicacionHomolodaga);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 0, SpringLayout.WEST, botonSeleccionadorArchivos);
		springLayout.putConstraint(SpringLayout.EAST, progressBar, 0, SpringLayout.EAST, botonIniciar);
		getContentPane().add(progressBar);
		
		areaTexto = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, areaTexto, 342, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, areaTexto, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, -15, SpringLayout.NORTH, areaTexto);
		springLayout.putConstraint(SpringLayout.WEST, areaTexto, 0, SpringLayout.WEST, botonSeleccionadorArchivos);
		springLayout.putConstraint(SpringLayout.EAST, areaTexto, -21, SpringLayout.EAST, getContentPane());
		getContentPane().add(areaTexto);
		

		// Agregar funcionalidad al bot�n Iniciar
		botonSeleccionadorArchivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonSeleccionadorArchivos.setEnabled(false);
				SeleccionadorArchivosGrafico seleccionador = new SeleccionadorArchivosGrafico(
						"Archivos provenientes de Scopus/WOS (*.csv)",
						new String[] { "csv", "txt" }); // Archivos con extensi�n csv y txt
				archivosOriginales = seleccionador.getArchivosSeleccionados();
				archivosOriginales_conRuta = seleccionador.getArchivosSeleccionados_ruta();
				
				if(archivosOriginales.length <= 0)
					botonSeleccionadorArchivos.setEnabled(true);
					
			}
		});

		botonIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				pubHomologada = txtPublicacionHomolodaga.getText().trim().toUpperCase();

				if (archivosOriginales.length > 0){
					botonIniciar.setEnabled(false);					
					new Thread(new thread1()).start();
				}else{
					botonSeleccionadorArchivos.setEnabled(true);
					botonIniciar.setEnabled(true);
				}
			}
		});		
		
	}
	
	public String quitaCaracteresEspeciales(String cadena) {

		// Quita guiones
		cadena = Pattern.compile("-").matcher(cadena).replaceAll(" ");

		// Quita signos de puntuaci�n no �tiles: (EXCEPTO , . ; : ( )
		cadena = Pattern.compile("[\\p{Punct}&&[^,.;:)(]]]").matcher(cadena)
				.replaceAll("");
		cadena = cadena.replace("=", ""); // =
		cadena = cadena.replace("\'", ""); // '
		cadena = cadena.replace("\"", ""); // "

		// Quita espacios m�ltiples
		cadena = Pattern.compile(" {2,}").matcher(cadena).replaceAll(" ");

		// Quita caracteres especiales
		cadena = cadena.replace("�", "A"); // �
		cadena = cadena.replace("\u00c2\u00a1", ""); // �
		cadena = cadena.replace("\u00c2\u00a5", "Y"); // �
		cadena = cadena.replace("\u00c2\u00a9", ""); // �
		cadena = cadena.replace("\u00c2\u00ae", ""); // �
		cadena = cadena.replace("\u00c2\u00b0", ""); // �
		cadena = cadena.replace("\u00c2\u00b1", ""); // (mas-menos)�
		cadena = cadena.replace("\u00c2\u00b7", "."); // �
		cadena = cadena.replace("\u00c2\u00bf", "");// �
		cadena = cadena.replace("\u00c3\u00a0", "a");// �
		cadena = cadena.replace("\u00c3\u00a1", "a");// �
		cadena = cadena.replace("\u00c3\u00a2", "a");// �
		cadena = cadena.replace("\u00c3\u00a3", "a");// �
		cadena = cadena.replace("\u00c3\u00a4", "a");// �
		cadena = cadena.replace("\u00c3\u00a5", "a");// �
		cadena = cadena.replace("\u00c3\u00a6", "ae");// �
		cadena = cadena.replace("\u00c3\u00a7", "c"); // �
		cadena = cadena.replace("\u00c3\u00a8", "e");// �
		cadena = cadena.replace("\u00c3\u00a9", "e");// �
		cadena = cadena.replace("\u00c3\u00aa", "e");// �
		cadena = cadena.replace("\u00c3\u00ab", "e");// �
		cadena = cadena.replace("\u00c3\u00ac", "i");// �
		cadena = cadena.replace("\u00c3\u00ad", "i");// �
		cadena = cadena.replace("\u00c3\u00ae", "i");// �
		cadena = cadena.replace("\u00c3\u00af", "i");// �
		cadena = cadena.replace("\u00c3\u00b0", "");// �
		cadena = cadena.replace("\u00c3\u00b1", "n");// �
		cadena = cadena.replace("\u00c3\u00b2", "o");// �
		cadena = cadena.replace("\u00c3\u00b3", "o");// �
		cadena = cadena.replace("\u00c3\u00b4", "o");// �
		cadena = cadena.replace("\u00c3\u00b5", "o");// �
		cadena = cadena.replace("\u00c3\u00b6", "o");// �
		cadena = cadena.replace("\u00c3\u00b8", "o");// �
		cadena = cadena.replace("\u00c3\u00b9", "u");// �
		cadena = cadena.replace("\u00c3\u00ba", "u");// �
		cadena = cadena.replace("\u00c3\u00bb", "u");// �
		cadena = cadena.replace("\u00c3\u00bc", "u");// �
		cadena = cadena.replace("\u00c3\u00bd", "y");// �
		cadena = cadena.replace("\u00c3\u00be", "");// �
		cadena = cadena.replace("\u00c3\u00bf", "y");// �
		cadena = cadena.replace("\u00c3\u0152", "I");// �, �n
		cadena = cadena.replace("\u00c3\u0153", "U");// �
		cadena = cadena.replace("\u00c3\u0160", "E");// �
		cadena = cadena.replace("\u00c3\u0161", "U");// �
		cadena = cadena.replace("\u00c3\u0178", "B");// �
		cadena = cadena.replace("\u00c3\u017d", "I");// �
		cadena = cadena.replace("\u00c3\u017e", "");// �
		cadena = cadena.replace("\u00c3\u0192", "A");// �
		cadena = cadena.replace("\u00c3\u02c6", "E");// �
		cadena = cadena.replace("\u00c3\u02dc", "O");// �
		cadena = cadena.replace("\u00c3\u2013", "O");// �
		cadena = cadena.replace("\u00c3\u2014", "x");// �
		cadena = cadena.replace("\u00c3\u2018", "N");// �
		cadena = cadena.replace("\u00c3\u2019", "O");// �
		cadena = cadena.replace("\u00c3\u201a", "A");// �
		cadena = cadena.replace("\u00c3\u201c", "O");// �
		cadena = cadena.replace("\u00c3\u201d", "O");// �
		cadena = cadena.replace("\u00c3\u201e", "A");// �, c??
		cadena = cadena.replace("\u00c3\u2020", "AE");// �
		cadena = cadena.replace("\u00c3\u2021", "C");// �
		cadena = cadena.replace("\u00c3\u2022", "O");// �
		cadena = cadena.replace("\u00c3\u2026", "A"); // �
		cadena = cadena.replace("\u00c3\u2030", "E");// �
		cadena = cadena.replace("\u00c3\u2039", "E");// �
		cadena = cadena.replace("\u00c3\u203a", "U");// �
		cadena = cadena.replace("\u00c3\u20ac", "A"); // �
		cadena = cadena.replace("\u00c3\u2122", "U");// �
		cadena = cadena.replace("\u00c3\ufffd", "I");// �, �, �,�
		cadena = cadena.replace("\u00c4\u00ab", "i"); // i??
		cadena = cadena.replace("\u00c4\u00b0", "I"); // I??
		cadena = cadena.replace("\u00c4\u00ba", "l"); // l??
		cadena = cadena.replace("\u00c4\u0152", "C"); // C??
		cadena = cadena.replace("\u00c4\u2021", "c");// c?
		cadena = cadena.replace("\u00c4\u203a", "e"); // e??
		cadena = cadena.replace("\u00c4\ufffd", "c");// c?
		cadena = cadena.replace("\u00c5\u00a0", "S");// �
		cadena = cadena.replace("\u00c5\u00a1", "s");// �
		cadena = cadena.replace("\u00c5\u00a3", "t");// t?
		cadena = cadena.replace("\u00c5\u00af", "u"); // u??
		cadena = cadena.replace("\u00c5\u00b8", "Y");// �
		cadena = cadena.replace("\u00c5\u00bd", "Z"); // �.
		cadena = cadena.replace("\u00c5\u00be", "z"); // �
		cadena = cadena.replace("\u00c5\u0178", "s");// s?
		cadena = cadena.replace("\u00c5\u017e", "S");// S
		cadena = cadena.replace("\u00c5\u2019", "OE");// �
		cadena = cadena.replace("\u00c5\u201a", "l"); // l??
		cadena = cadena.replace("\u00c5\u201c", "oe");// �
		cadena = cadena.replace("\u00c5\u201e", "n");// n
		cadena = cadena.replace("\u00c5\u2022", "r"); // r??
		cadena = cadena.replace("\u00c5\u2122", "r"); // r??
		cadena = cadena.replace("\u00c5\ufffd", "o"); // o??
		cadena = cadena.replace("\u00c6\u2019", "f");// �
		cadena = cadena.replace("\u00c7\u00a6", "G");// G
		cadena = cadena.replace("\u00c7\u00a7", "g"); // g??
		cadena = cadena.replace("\u00c7\u00b9", "n"); // �n
		cadena = cadena.replace("\u00c7\u017d", "a"); // a??
		cadena = cadena.replace("\u00c7\u201d", "u"); // u??
		cadena = cadena.replace("\u00c8\u00a9", "e");// ?
		cadena = cadena.replace("\u00cc\u0192", "4"); // 4??
		cadena = cadena.replace("\u00cc\u02c6", ""); // �
		cadena = cadena.replace("\u00cc\u20ac", "a"); // a??
		cadena = cadena.replace("\u00cc\ufffd", "n");// �n
		cadena = cadena.replace("\u00ce\u00a0", "PI");// ?
		cadena = cadena.replace("\u00ce\u00a1", "RHO");// ?
		cadena = cadena.replace("\u00ce\u00a3", "SIGMA");// S
		cadena = cadena.replace("\u00ce\u00a4", "TAU");// ?
		cadena = cadena.replace("\u00ce\u00a5", "IPSILON");// ?
		cadena = cadena.replace("\u00ce\u00a6", "FI");// F
		cadena = cadena.replace("\u00ce\u00a7", "JI");// ?
		cadena = cadena.replace("\u00ce\u00a8", "PSI");// ?
		cadena = cadena.replace("\u00ce\u00a9", "OMEGA");// O
		cadena = cadena.replace("\u00ce\u00b1", "alfa");// a
		cadena = cadena.replace("\u00ce\u00b2", "beta");// �
		cadena = cadena.replace("\u00ce\u00b3", "gamma");// ?
		cadena = cadena.replace("\u00ce\u00b4", "delta");// delta
		cadena = cadena.replace("\u00ce\u00b5", "epsilon");// e
		cadena = cadena.replace("\u00ce\u00b6", "dseta");// ?
		cadena = cadena.replace("\u00ce\u00b7", "eta");// ?
		cadena = cadena.replace("\u00ce\u00b8", "theta");// ?
		cadena = cadena.replace("\u00ce\u00b9", "iota");// ?
		cadena = cadena.replace("\u00ce\u00ba", "kappa");// ?
		cadena = cadena.replace("\u00ce\u00bb", "lambda");// ?
		cadena = cadena.replace("\u00ce\u00bc", "mi");// �
		cadena = cadena.replace("\u00ce\u00bd", "ni");// ?
		cadena = cadena.replace("\u00ce\u00be", "xi");// ?
		cadena = cadena.replace("\u00ce\u00bf", "omicron");// ?
		cadena = cadena.replace("\u00ce\u0153", "MI");// ?
		cadena = cadena.replace("\u00ce\u0161", "KAPPA");// ?
		cadena = cadena.replace("\u00ce\u0178", "OMICRON");// ?
		cadena = cadena.replace("\u00ce\u017e", "XI");// ?
		cadena = cadena.replace("\u00ce\u02dc", "THETA");// T
		cadena = cadena.replace("\u00ce\u2013", "DSETA");// ?
		cadena = cadena.replace("\u00ce\u2014", "ETA");// ?
		cadena = cadena.replace("\u00ce\u2018", "ALFA");// ?
		cadena = cadena.replace("\u00ce\u2019", "BETA");// ?
		cadena = cadena.replace("\u00ce\u201c", "GAMMA");// G
		cadena = cadena.replace("\u00ce\u201d", "DELTA");// ?
		cadena = cadena.replace("\u00ce\u2022", "EPSILON");// ?
		cadena = cadena.replace("\u00ce\u203a", "LAMBDA");// ?
		cadena = cadena.replace("\u00ce\u2122", "IOTA");// ?
		cadena = cadena.replace("\u00ce\ufffd", "NI");// ?
		cadena = cadena.replace("\u00cf\u0192", "sigma");// s
		cadena = cadena.replace("\u00cf\u02c6", "psi");// ?
		cadena = cadena.replace("\u00cf\u201a", "sigma");// ?
		cadena = cadena.replace("\u00cf\u201e", "tau");// t, i??
		cadena = cadena.replace("\u00cf\u2020", "phi");// f
		cadena = cadena.replace("\u00cf\u2021", "ji");// ?
		cadena = cadena.replace("\u00cf\u2026", "ipsilon");// ?
		cadena = cadena.replace("\u00cf\u2030", "omega");// ?
		cadena = cadena.replace("\u00cf\u20ac", "pi");// p
		cadena = cadena.replace("\u00cf\ufffd", "rho");// ?
		cadena = cadena.replace("\u00e1\u00b8\u00be", "M"); // M??
		cadena = cadena.replace("\u00e1\u00b8\u00bf", "m"); // m??
		cadena = cadena.replace("\u00e1\u00b9\u2022", "p");// ?
		cadena = cadena.replace("\u00e1\u00ba\u2018", "z");// ?
		cadena = cadena.replace("\u00e1\u00bb\u00b3", "y");// ?
		cadena = cadena.replace("\u00e2\u02c6\u00bc", ""); // ??
		cadena = cadena.replace("\u00e2\u02c6\u017e", ""); // (infinito)
		cadena = cadena.replace("\u00e2\u02c6\u02c6", "E");// ?
		cadena = cadena.replace("\u00e2\u2030\u00a4", ""); // (menor/igual)
		cadena = cadena.replace("\u00e2\u2030\u00a5", ""); // (mayor/igual)
		cadena = cadena.replace("\u00e2\u20ac\u00a2", ""); // �
		cadena = cadena.replace("\u00e2\u20ac\u00b2", "");// '
		cadena = cadena.replace("\u00e3\u20ac\u02c6", "<");// <
		cadena = cadena.replace("\u00e3\u20ac\u2030", ">");// >

		return cadena;
	}
}// public class XVSToSCIT

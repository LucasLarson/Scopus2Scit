import java.util.Calendar;
import java.util.TimeZone;

/**	
 * @(#)Referencias.java
 *
 * Devuelve una cadena con varios renglones (una referencia por renglón) con las referencias decodificadas.
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (25/Julio/2013)
 */


public class Referencias
{
	private CompletarPublicacion pubs = null;
	private String salidaRefs="";
	private int MAX_NUMERO_PALABRAS;
	private int MAX_NUMERO_AUTORES;
	
	public String analizaReferencias( String cadenaReferencias, int max_autores, int max_pal )
	{
		String []referencias;
		
		MAX_NUMERO_AUTORES = max_autores;
		MAX_NUMERO_PALABRAS = max_pal;
		
		if( cadenaReferencias.length()==0 )
			return "";
		
		//Las referencias vienen separadas por ';'
		referencias = cadenaReferencias.split(";");
		//System.out.println("\n" + referencias.length + "\n");
		
		for( int i=0; i<referencias.length; i++ )
		{
			salidaRefs += decodificaReferencia( referencias[i] );
			//System.out.println( salidaRefs );
		}
		
		return salidaRefs;
	}
	
	
	public String decodificaReferencia( String referencia )
	{
		String salida="";
		
		String [] partes;
		String [] datos;
		
		String [] autores = new String [MAX_NUMERO_AUTORES];
		String [] afiliaciones = new String [MAX_NUMERO_AUTORES];
		
		String anio="";
		String titulo="";
		String publicacion="";
		String volumen="";
		String numero="";
		String aux="";
		String tipo="";
		String resto="";
		String caso="";
		int bandera=0;
		boolean no_poner=false;			
		int indice=0, indice2=0;
		tipo = "1";
		
		for(int i=0; i<MAX_NUMERO_AUTORES; i++)
		{
			autores[i] = " ";
			afiliaciones[i] = " ";
		}
		
			partes = referencia.split("\\., ");
			
			int p=0;
			while ( p<partes.length && partes[p].length()<25 ) // Recorro todos los "autores"
			{
				//pero sólo guardo los primeros MAX_NUMERO_AUTORES
				if( p<MAX_NUMERO_AUTORES )
				{
					// Junto las iniciales del primer y segundo nombre
					partes[p]=partes[p].replace(". ","");
					partes[p]=partes[p].replace(".-","");
					partes[p]=partes[p].replace(".","");
				
					autores[p]=partes[p];
				}
				
				p++;
			}
			if( p!=0 ) //Contiene autores
			{
				caso="A_";
				//En caso de que se haya separado, vuelvo a unir el resto:
				for( int i=p; i<partes.length; i++ )
					resto+=partes[i]+"., ";
				
				//Comienza con el año
				if( resto.startsWith("(") )
				{
					caso=caso+"(Anioo)_T?";
					tipo = "2";
					anio = resto.substring(1,5);
					resto = resto.substring(7);
					
					//sigue el título
					indice = resto.indexOf(',');
					if( indice>0 && (indice+7)<resto.length() )
					{
						titulo = resto.substring(0,indice-1);
						resto = resto.substring(indice);
						
						resto = resto.replace(";","");
						
						datos = resto.split(", |[()]");
						
						for( int d=0; d<datos.length; d++ )
						{
							if( datos[d].contains( "UNIVERSITY" ) || datos[d].contains( "SOCIETY" ) || datos[d].contains( "INSTITUTE" ) || datos[d].contains( "PRESS" ) || datos[d].contains( "INST." ) || datos[d].contains( "UNIV." ) || datos[d].contains( "CENTER" ) || datos[d].contains( "PUBLISHING" ) )
							{
								datos[d].trim();
							}
							
							if( datos[d].contains( "BULLETIN" ) || datos[d].contains( "JOURNAL" ) || datos[d].contains( "CONFERENCE" ) || datos[d].contains( "CONF." ) || datos[d].contains( "JOUR." ) || datos[d].contains( "BULL." ) )
							{
								if(datos[d].trim().length() > 5)
									publicacion = datos[d].trim();
								else if(datos[d].trim().matches("^[0-9]+$"))
									publicacion = "NO DISPONIBLE";
								else
									publicacion = "NO DISPONIBLE";
							}
						}
						
					}
					
				}// if( resto.startsWith("(") )
				else
				{
					//comienza por el título
					indice = resto.indexOf('(');
					if( indice>0 && (indice+7)<resto.length() )
					{
						anio = resto.substring(indice+1,indice+5);
						if( anio.matches("\\d\\d\\d\\d") )
						{
							caso=caso+"T_(Anio)_";
							//Efectivamente, es el año
							titulo = resto.substring(0,indice-1);
							resto = resto.substring(indice+7);
							bandera=1;// Se tienen ya autores, año, título y resto
						}// if anios
						else
						{
							//Es otra cosa entre paréntesis que forma parte del	título
							caso=caso+"T_(P)_";
							aux = resto.substring(0,indice);
							resto = resto.substring(indice+1);
							
							indice = resto.indexOf('(');
							if( indice>0 && (indice+7)<resto.length() )
							{
								anio = resto.substring(indice+1,indice+5);
								if( anio.matches("\\d\\d\\d\\d") )
								{
									//Ahora sí, es el año
									caso=caso+"T_(Anio)_";
									titulo = aux + resto.substring(0,indice-1);
									resto = resto.substring(indice+7);
									bandera=1;// Se tienen ya autores, año, título y resto
								}
								else
								{// Quién sabe con qué se está tratando; vuelvo a unir lo que ya tengo
									caso=caso+"T_(P)+????";
									resto=aux+resto;
								}
							}// if( indice>0 && (indice+7)<resto.length() )

						}// else de // if anios
						
						if( bandera==1 )// Si se tienen ya autores, año, título y resto
						{
							//Se analiza el resto. Lo que sigue debería ser "publicación"+", "+"número"+["(volumen)"]+resto
							indice = resto.indexOf(',');
							if( indice!=-1 && (indice+2)<resto.length() )
							{
								//confiable=true;
								caso=caso+"Pub_";
								if(resto.substring(0,indice).trim().length() < 15 && (resto.substring(0,indice).trim().contains("P.") || resto.substring(0,indice).trim().contains("PP.")))
									publicacion = "NO DISPONIBLE";
								else if(resto.substring(0,indice).trim().matches("^[0-9]+$"))
									publicacion = "NO DISPONIBLE";
								else
									publicacion = resto.substring(0,indice).trim();
									
								resto = resto.substring(indice+2);
								
								indice = resto.indexOf(',');
								if( indice!=-1 )
								{
									//Se cuenta con el volumen de la obra
									aux = resto.substring(0,indice);
									resto = resto.substring(indice);
																
									indice = aux.indexOf('(');
									if( indice!=-1 )
									{
										//Se cuenta con el número de la publicación
										indice2 = aux.indexOf(')');
										volumen = aux.substring(0,indice);
										
										/**
										 * @author EGarciaCanoCa (24/Octubre/2013)
										 */
										try{
											if( indice2 != -1 ){
												numero = aux.substring(indice+1,indice2);
											}
										}catch(Exception e){					
											// No se pudo procesar el numero
											numero = "";
											System.out.println(referencia);
										}
										caso=caso+"Num_(Vol)_";
									}//if( indice!=-1 )
									else
									{
										volumen = aux;
										caso=caso+"Num_,";
									}// else de if( indice!=-1 )
								}//if( indice!=-1 )
								else
								{
									indice = resto.indexOf(';');
									if( indice!=-1 )
									//Probablemente se cuenta con el volumen de la obra
									aux = resto.substring(0,indice);
									resto = resto.substring(indice);
																
									indice = aux.indexOf('(');
									if( indice!=-1 )
									{
										//Se cuenta con el número de la publicación
										indice2 = aux.indexOf(')');
										volumen = aux.substring(0,indice);
										if( indice2 != -1 )
											numero = aux.substring(indice+1,indice2);
										caso=caso+"Num_Vol;";
									}
									else
									{
										volumen = aux;
										caso=caso+"Num_;";
									}
								}// else de if( indice!=-1 )
							}// if( indice!=-1 && (indice+2)<resto.length() )
						}// if( bandera==1 )// Si se tienen ya autores, año, título y resto
					}// if( indice>0 && (indice+7)<resto.length() )
				}// else de if( resto.startsWith("(") )
				
			}
			else // No contiene autores o se encuentran en otra parte que no es la inicial
			{
				if( referencia.startsWith("(") && referencia.length()>7 )
				{
					anio = referencia.substring(1,5);
					resto = referencia.substring(7);
					
					if( anio.matches("\\d\\d\\d\\d") )
					{
						caso="(anio)_T?";
						tipo = "2";
						//Efectivamente, es el año
						
						//sigue el título
						indice = resto.indexOf(',');
						if( indice>0 && (indice+7)<resto.length() )
						{
							titulo = resto.substring(0,indice-1);
							resto = resto.substring(indice);
							
							resto = resto.replace(";","");
							
							datos = resto.split(",|[()]");
							
							for( int d=0; d<datos.length; d++ )
							{
								if( datos[d].contains( "UNIVERSITY" ) || datos[d].contains( "SOCIETY" ) || datos[d].contains( "INSTITUTE" ) || datos[d].contains( "PRESS" ) || datos[d].contains( "INST." ) || datos[d].contains( "UNIV." ) || datos[d].contains( "CENTER" ) || datos[d].contains( "PUBLISHING" ) )
								{
									datos[d].trim();
								}
								
								if( datos[d].contains( "BULLETIN" ) || datos[d].contains( "JOURNAL" ) || datos[d].contains( "CONFERENCE" ) || datos[d].contains( "CONF." ) || datos[d].contains( "JOUR." ) || datos[d].contains( "BULL." ) )
								{
									if(datos[d].trim().length() > 5)
										publicacion = datos[d].trim();									
									else
										publicacion =  "NO DISPONIBLE";
								}
							}
						}
					}// if anios
					else
					{
						if( referencia.contains( "HTTP" ) || referencia.contains( "WWW" ) )
						{	// Lo más seguro es que se trate de una referencia electrónica
							tipo = "10";
						}	
						//No se sabe con qué se está tratando
						no_poner=true;
						
						resto = referencia;
						anio = "";
						caso = "NA_?";
					}
				}
				else
				{
					// Comienza con el título
					resto=referencia;
					caso="NA_?";
				}
			}
			
			//	-> ELEGIR EL TIPO DE PUBLICACION CON PALABRAS CLAVE: 
			
			//Se pone primero esta condición, porque a veces puede ser una referencia completa, de otro tipo,
			// pero que incluya una URL al final.
			if( referencia.contains( "HTTP" ) || 
				referencia.contains( "WWW" )
			 ) //CONSEGUIR NOMBRES DE EDITORIALES MÁS COMUNES
				tipo="10";
			
			if( referencia.contains( "STANDARD" ) || 
				referencia.contains( "MANUAL" ) || 
				referencia.contains( "GUIDE" )  ) //CONSEGUIR NOMBRES DE EDITORIALES MÁS COMUNES
				tipo="5";
			
			if( referencia.contains( "TECHNICAL REPORT" ) ) //CONSEGUIR NOMBRES DE EDITORIALES MÁS COMUNES
				tipo="6";
				
			if( referencia.contains( "PUBLISH" ) ||
				referencia.contains( "EDITORS" ) ) //CONSEGUIR NOMBRES DE EDITORIALES MÁS COMUNES
				tipo="2";
			
			if( referencia.contains( "CHAPTER" ) || referencia.contains( "CHAP." ) ) 
				tipo="3";
			
			if( referencia.contains( "THESIS" ) || referencia.contains( "DISSERTATION" ) )
				tipo = "8";

			if( referencia.contains( "CONFERENCE" ) || referencia.contains( "CONF." ) ||
				referencia.contains( "PROCEEDINGS" ) || referencia.contains( "PROC." ) ||
				referencia.contains( "MEETING" ) ||
				referencia.contains( "SYMPOSIUM" ) || referencia.contains( "SYMP." ) ||
				referencia.contains( "COLLOQUIUM" ) ||
				referencia.contains( "INTERNATIONAL" ) || referencia.contains( "INT." ) ||
				referencia.contains( "WORKSHOP" ) ||
				referencia.contains( "CONGRESS" ) )
				tipo="7";
			
			if( referencia.contains( "JOURNAL" ) || referencia.contains( "JOUR." ) ||
				referencia.contains( "LETTERS" ) || referencia.contains( "LETT." ) )
				tipo="1";

			if( no_poner==false )
			{
				//orden++;
				//cuentaRefsParciales++;
				salida += "\n"+referencia+"\t";
			
				//No es principal
				salida+=" \t";

				
				for(int i=0; i< autores.length; i++){
					
					if(autores[i].contains("(") && autores[i].contains(")")){
						
						int begin = autores[i].indexOf("(");
						int end = autores[i].indexOf(")");
						
						if(end > begin){
							try{
								autores[i] = autores[i].substring(end+1);
							}catch(ArrayIndexOutOfBoundsException aioobe){							
								autores[i] = "";
							}							
						}
					}
					
					autores[i] = autores[i].replaceAll("[0-9]", "");
					autores[i] = autores[i].replaceAll("[()]", "");
					System.out.println(autores[i]);
				}
				
				for(int i=0; i<MAX_NUMERO_AUTORES; i++)
					salida+=autores[i]+"\t";
					
				for(int i=0; i<MAX_NUMERO_AUTORES; i++)
					salida+=afiliaciones[i]+"\t";	
			
				// Se crea el objeto limpiador de nombres de publicaciones
				/**
				 * @author EGarciaCanoCa
				 * (10/10/2013)				
				 */
				pubs = CompletarPublicacion.getInstnacia("ISSN.txt");
				publicacion = pubs.completaISSN(publicacion);
				
				publicacion = limpiarPublicacion(publicacion);
				
				if(anio.length() == 4){
					try{
						int auxAnio = Integer.parseInt(anio);
						Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
						int currentYear = localCalendar.get(Calendar.YEAR);
						
						if(auxAnio < 1850 || auxAnio > currentYear)
							anio = "";
					}catch(NumberFormatException nfe){
						anio = "";
					}
				}else
					anio = "";				
				
				salida += titulo+"\t";
				salida += anio+"\t";
				salida += publicacion+"\t";
				salida += volumen+"\t";
				salida += numero+"\t";
				//salida += editorial+"\t";
				salida += tipo+"\t";
				
				//No hay palabras cave en las referencias
				for(int i=0; i<MAX_NUMERO_PALABRAS; i++)
					salida+=" \t";
				
				//Idioma, Corresponding author, abstract, referencias totales, referencias actuales
				salida += " \t \t \t \t \t";
				
				// PATRON DE REF
				salida += "\t"+caso;
				
				// DESCONOCIDO EN REF
				salida += "\t"+resto;		
			}
		
		return salida;
	}// public void decodificaReferencia( String referencia)

	public String limpiarPublicacion(String cadena){
		
		if(cadena.matches("^[0-9]+$"))
			cadena = "NO DISPONIBLE";
		
		cadena = cadena.replaceAll("[0-9]+(\\s)?(RD|TH|ND|ST)", " ");
		
		cadena = cadena.replaceAll(
				"FIRST |SECOND |THIRD |FOURTH |FIFTH |SIXTH |SEVENTH |EIGHTH |NINTH |TENTH |ELEVENTH |TWELFTH |THIRTEENTH |FOURTEENTH |FIFTEENTH |SIXTEENTH |SEVENTEENTH |EIGHTEENTH |NINETEENTH |TWENTIETH ",
				" ");
		
		cadena = cadena.replaceAll(
				"(,? ?VOLS? \\d\\d? ?(&|AND|,)? ?\\d\\d? ?,?)", " ");
		cadena = cadena.replaceAll(
				",? ?VOL \\d\\d?\\d? ?,? ?(\\d\\d?\\d?([^A-Z]|$))?,?", " ");

		// Números romanos
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

		// números romanos
		cadena = cadena
				.replaceAll(
						"(,? ?(PARTS?|PTS?) III ?(&|AND|,)? ?IV ?,?)|(,? ?(PARTS?|PTS?) II ?(&|AND|,)? ?III ?,?)|(,? ?(PARTS?|PTS?) IV ?(&|AND|,)? ?V ?,?)|(,? ?(PARTS?|PTS?) IX ?(&|AND|,)? ?X ?,?)|(,? ?(PARTS?|PTS?) VIII ?(&|AND|,)? ?IX ?,?)|(,? ?(PARTS?|PTS?) VII ?(&|AND|,)? ?VIII ?,?)|(,? ?(PARTS?|PTS?) VI ?(&|AND|,)? ?VII ?,?)|(,? ?(PARTS?|PTS?) V ?(&|AND|,)? ?VI ?,?)|(,? ?(PARTS?|PTS?) I ?(&|AND|,)? ?II ?,?)",
						" ");
		cadena = cadena
				.replaceAll(
						"(,? ?(PART|PT) III ?,?)|(,? ?(PART|PT) II ?,?)|(,? ?(PART|PT) IV ?,?)|(,? ?(PART|PT) IX ?,?)|(,? ?(PART|PT) VIII ?,?)|(,? ?(PART|PT) VII ?,?)|(,? ?(PART|PT) VI ?,?)|(,? ?(PART|PT) V ?,?)|(,? ?(PART|PT) X ?,?)|(,? ?(PART|PT) I ?,?)",
						" ");

		// Números arábigos
		cadena = cadena.replaceAll(
				"(,? ?(PARTS?|PTS?) \\d\\d? ?(&|AND|,)? ?\\d\\d? ?,?)", " ");
		cadena = cadena.replaceAll(",? ?(PART|PT) \\d\\d?\\d? ?,?", " ");

		// QUITAMOS Números Romanos I-XX
		cadena = cadena
				.replaceAll(
						"[^A-Z0-9]III[^A-Z0-9]|[^A-Z0-9]II[^A-Z0-9]|[^A-Z0-9]IV[^A-Z0-9]|[^A-Z0-9]IX[^A-Z0-9]|[^A-Z0-9]VIII[^A-Z0-9]|[^A-Z0-9]VII[^A-Z0-9]|[^A-Z0-9]VI[^A-Z0-9]|[^A-Z0-9]V[^A-Z0-9]|[^A-Z0-9]XIII[^A-Z0-9]|[^A-Z0-9]XII[^A-Z0-9]|[^A-Z0-9]XIV[^A-Z0-9]|[^A-Z0-9]XIX[^A-Z0-9]|[^A-Z0-9]XVIII[^A-Z0-9]|[^A-Z0-9]XVII[^A-Z0-9]|[^A-Z0-9]XVI[^A-Z0-9]|[^A-Z0-9]XV[^A-Z0-9]|[^A-Z0-9]XX[^A-Z0-9]|[^A-Z0-9]XI[^A-Z0-9]|[^A-Z0-9]X[^A-Z0-9]|[^A-Z0-9]I[^A-Z0-9]",
						" ");
		cadena = cadena
				.replaceAll(
						"^III[^A-Z0-9]|^II[^A-Z0-9]|^IV[^A-Z0-9]|^IX[^A-Z0-9]|^VIII[^A-Z0-9]|^VII[^A-Z0-9]|^VI[^A-Z0-9]|^V[^A-Z0-9]|^XIII[^A-Z0-9]|^XII[^A-Z0-9]|^XIV[^A-Z0-9]|^XIX[^A-Z0-9]|^XVIII[^A-Z0-9]|^XVII[^A-Z0-9]|^XVI[^A-Z0-9]|^XV[^A-Z0-9]|^XX[^A-Z0-9]|^XI[^A-Z0-9]|^X[^A-Z0-9]|^I[^A-Z0-9]",
						" ");

		// Quitamos años:
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

		// Quitamos espacios extra al inicio o final:
		cadena = cadena.trim();
	
		return cadena;
	}
	
}// public class Referencia
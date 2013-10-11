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
		String editorial="";
		String tipo="";
		String resto="";
		String caso="";
		int bandera=0;
		boolean no_poner=false;			
		int indice=0, indice2=0;
		boolean confiable=false;
		
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
								editorial = datos[d].trim();
							}
							
							if( datos[d].contains( "BULLETIN" ) || datos[d].contains( "JOURNAL" ) || datos[d].contains( "CONFERENCE" ) || datos[d].contains( "CONF." ) || datos[d].contains( "JOUR." ) || datos[d].contains( "BULL." ) )
							{
								publicacion = datos[d].trim();
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
								publicacion = resto.substring(0,indice);
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
										if( indice2 != -1 )
											numero = aux.substring(indice+1,indice2);
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
									editorial = datos[d].trim();
								}
								
								if( datos[d].contains( "BULLETIN" ) || datos[d].contains( "JOURNAL" ) || datos[d].contains( "CONFERENCE" ) || datos[d].contains( "CONF." ) || datos[d].contains( "JOUR." ) || datos[d].contains( "BULL." ) )
								{
									publicacion = datos[d].trim();
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
			
			/*
			if( confiable )
			{
				// soloReferencias= "\tOriginal\tAutor 1\tAutor 2\tAutor 3\tAutor 4\tAautor 5\tTítulo\tAño\tPublicación\tVolumen\tNúmero\tEditorial\tTipo\tCaso";
				
				salida += "\n"+referencia+"\t";
				for(int i=0; i<5; i++)
					salida+=autores[i]+"\t";
				
				salida += titulo+"\t";
				salida += anio+"\t";
				salida += publicacion+"\t";
				salida += volumen+"\t";
				salida += numero+"\t";
				salida += editorial+"\t";
				salida += tipo+"\t";

				salida += "\t"+caso;
				salida += "\n";
			}
			*/
		
		return salida;
	}// public void decodificaReferencia( String referencia)

	
}// public class Referencia
import javax.swing.JTextArea;

/**	
 * @(#)AcomodaTABScopus.java
 *
 * Acomoda el archivo de salida de Scopus separado por comas de sus desfases habituales 
 * Ocasionados en las columnas previas al Link y posteriores a la Publicación.
 * (Codificación UTF-8)
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (11/Junio/2013)

 */

public class AcomodaTABScopus
{
	private String [] renglones;
	private String salidaCorrecta = "";

	public AcomodaTABScopus( String cadenaArchivo, JTextArea areaTexto )
	{
		int contador=0;
		int columnaActual=0;
		int posicionLink=0;
		String [] entradasSeparadas;
		String [] encabezado;
		String renglon="";
		salidaCorrecta = "";

		renglones = cadenaArchivo.split("\n");

		// guardo los valores del encabezado para conocer las posiciones de cada elemento
		encabezado = renglones[0].split("\t");

		contador=1; // la primera línea es el encabezado y se supone que está bien

		for( int i=0; i<encabezado.length; i++ )
		{
			if( encabezado[i].compareTo("Ï»¿AUTHORS")==0 )
				salidaCorrecta += "AUTHORS" + "\t";
			else
				salidaCorrecta += encabezado[i] + "\t";
		}
		salidaCorrecta += "\n";

		// Buscamos Link (la columna que suele desfasarse en Scopus debido a los campos anteriores)
		posicionLink = encuentraIndice(encabezado,"LINK");

		while( contador<renglones.length )
		{
			
			areaTexto.setText("Acomodando columnas recorridas...\n");
			areaTexto.append(renglones[contador]);
			
			renglon="";
			entradasSeparadas = renglones[contador].split("\t");

			columnaActual = posicionLink;

			if( columnaActual != -1)
			{
				//Copio la primera parte íntegra
				for(int i=0; i<columnaActual; i++)
					renglon += entradasSeparadas[i] + "\t";

				// Ahora, verifico si el dato en la columna actual corresponde a un link:
				// En caso afirmativo, copio tal cual el resto del renglón
				if( entradasSeparadas[columnaActual].startsWith("HTTP") || entradasSeparadas[columnaActual].startsWith("http") )
				{
					//Copio la segunda parte íntegra
					for(int i=columnaActual; i<entradasSeparadas.length; i++)
						renglon += entradasSeparadas[i] + "\t";
				}
				else
				{
					//Busco el dato que comienza con HTTP:
					while( !entradasSeparadas[columnaActual].startsWith("HTTP") && columnaActual<entradasSeparadas.length )
						columnaActual++;

					//Copio la segunda parte íntegra
					for(int i=columnaActual; i<entradasSeparadas.length; i++)
						renglon += entradasSeparadas[i] + "\t";
				}

			}
			else
			{
				//Si no existe el campo LINK, no hay campo de referencia, por lo que copio todo tal cual
				for(int i=0; i<entradasSeparadas.length; i++)
					renglon += entradasSeparadas[i] + "\t";

			}


			salidaCorrecta += renglon + "\n";
			contador++;
		}
	}

	public String getSalidaCorrecta()
	{
		return salidaCorrecta;
	}

	int encuentraIndice( String [] arreglo, String cadenaAencontrar )
	{
		int indice=0;

		while( indice<arreglo.length )
		{
			if( arreglo[indice].compareTo(cadenaAencontrar)==0 )
				return indice;
			indice++;
		}
		return -1;

	}


}//public class AcomodaTABScopus 

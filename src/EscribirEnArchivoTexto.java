/**	
 * @(#)ObtenerFrecuencias.java
 *
 * Guarda en un archivo de texto el contenido de una cadena
 * (reemplaza el contenido actual del archivo)
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (25/Febrero/2012)
 */

import java.io.*;

//Devuelve el contenido de un archivo de texto en una cadena
public class EscribirEnArchivoTexto
{
	public  EscribirEnArchivoTexto( String cadena, String nombreArchivoDestino )
	{
		FileWriter archivo = null;
        PrintWriter pw = null;
        try
        {
            		
			if(nombreArchivoDestino.contains("_INTITUCIONES.LOG")){
				archivo = new FileWriter( nombreArchivoDestino,true );
				pw = new PrintWriter(archivo);
				pw.println( cadena+"\n");
			}	
			else{
				archivo = new FileWriter( nombreArchivoDestino );
				pw = new PrintWriter(archivo);
				pw.print( cadena );
			}
        }
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		finally 
		{
           try 
		   {
				// aseguramos que se cierra el archivo.
				if (null != archivo)
					archivo.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
        }
	}
}
 
 
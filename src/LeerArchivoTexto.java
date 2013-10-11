/**	
 * @(#)ObtenerFrecuencias.java
 *
 * Guarda el contenido de un archivo de texto en una cadena
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (25/Febrero/2012)
 */

 import java.io.*;

//Devuelve el contenido de un archivo de texto en una cadena
public class LeerArchivoTexto
{
	private String archivoEnCadena;
	
	public  LeerArchivoTexto( String nombreArchivo )
	{
		FileReader entrada=null;
		StringBuffer cadena=new StringBuffer();

		try
		{
			entrada = new FileReader( nombreArchivo );
			int c;
			
			while( (c=entrada.read())!=-1 )
			{
				cadena.append((char)c);
			}
			entrada.close();
		}
		catch ( IOException ex )
		{
			System.out.println("Error con el archivo: " + ex);
		}
		
		archivoEnCadena =  cadena.toString();
	}
	
	public String getArchivoEnCadena()
	{
		return archivoEnCadena;
	}
}
 
 
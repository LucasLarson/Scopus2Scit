/**	
 * @(#)ConvierteCvsATab.java
 *
 * Convierte un archivo tipo CVS a uno separado por tabuladores de WINDOWS
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (04/Junio/2013)
 */

 import java.io.*;

public class ConvierteCvsATab
{

	public  ConvierteCvsATab( String nombreArchivoConRuta, String rutaResultado )
	{
		LeerArchivoTexto lectura;
		String cadenaArchivo = "";
		String [] renglones;
		String nombreArchivoLimpio = "";
		String cadenaSalida="";
		String cadena="";
		int indice=0;
		int contador=0;
		boolean bandera=false;
		boolean bandera2=false;
		
		lectura = new LeerArchivoTexto( nombreArchivoConRuta );
		cadenaArchivo = lectura.getArchivoEnCadena();
		
		renglones = cadenaArchivo.split("\n");
		
		indice = nombreArchivoConRuta.lastIndexOf('.');
		nombreArchivoLimpio = nombreArchivoConRuta.substring(0,indice);
		indice = nombreArchivoLimpio.lastIndexOf('\\');
		nombreArchivoLimpio = nombreArchivoLimpio.substring( indice+1, nombreArchivoLimpio.length() );
		System.out.println(nombreArchivoLimpio);
		
		
		while( contador<renglones.length )
		{
			cadena="";
			bandera=false;
			renglones[contador] = renglones[contador].replace("\t","");
			
			for( int i=0; i<renglones[contador].length(); i++)
			{
				if( renglones[contador].charAt(i)=='\"' )
				{
					if( bandera )
					{
						if( !bandera2 )
						{
							if( renglones[contador].charAt(i+1)==',' )
								bandera=false;
							else
								bandera2=true;
						}
						else
						{
							bandera2=false;
						}
					}
					else
						bandera=true;
				}
				else
				{
					if( renglones[contador].charAt(i)==',' && !bandera )
						cadena += "\t";
					else
					{
						cadena += String.valueOf(renglones[contador].charAt(i)); 
					}
				}
			}
			
			cadenaSalida +=cadena + "\n";
			
			contador++;
		}
		
		
		// Crea la carpeta de resultados
		File folder;
		folder = new File( rutaResultado+ "\\" );
		folder.mkdirs();
		new EscribirEnArchivoTexto( cadenaSalida, rutaResultado + "\\" + nombreArchivoLimpio + ".txt" );
		
	}
	
	public static void main( String[] args )
	{
		new ConvierteCvsATab( "C:\\Users\\LHernandezD\\Dropbox\\Java\\ProyectoLEI\\Decodificadores2\\Entradas\\scopus.csv", "SalidasTABS" );
	}
	
}// class ConvierteCvsATab
 
 
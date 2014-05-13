/**	
 * @(#)ConvierteCvsATab.java
 *
 * Convierte un archivo tipo CVS a uno separado por tabuladores de WINDOWS
 *
 * @author Hernández Domínguez Laura Elena
 * @author Eric Garcia Cano Castillo
 * @version 1.0 (04/Junio/2013)
 * @version 2.0 (10/Diciembre/2013)
 * 
 */
import java.io.*;

import javax.swing.JTextArea;

/**
 * Refactorizada para usar el modelo Singleton
 * @author EGarciaCanoCa
 *
 */
public class ConvierteCvsATab
{
	static boolean rcr, cnv = false;	
	
	public ConvierteCvsATabData data = new ConvierteCvsATabData("", "", "",
			-1);


	
	
	
	/*public synchronized  static ConvierteCvsATab getInstance(String nombreArchivoConRuta, String rutaResultado, JTextArea areaTexto){
	
		singleton = new ConvierteCvsATab(nombreArchivoConRuta, rutaResultado, areaTexto);	
		status = 0;

		return singleton;
	}*/
	
	/*
	public synchronized  static ConvierteCvsATab getInstance() throws NullPointerException{
		if(singleton == null){
			status = -1;
			throw new NullPointerException("No se ha creado una instancia de este objeto");
		}
		
		return singleton;
	}*/
	
	/**
	 * @since 10/Diciembre/2013
	 * @param nombreArchivoConRuta Archivo a procesar
	 * @param rutaResultado	Ruta donde se almacena el resultado
	 * @param areaTexto	Area de texto donde se muestra el avance
	 */
	public ConvierteCvsATab( String nombreArchivoConRuta, String rutaResultado, JTextArea areaTexto )
	{
		cnv = rcr = false;		
		
		this.data.nombreArchivoConRuta = nombreArchivoConRuta;
		this.data.rutaResultado = rutaResultado;
		this.data.areaTexto = areaTexto;
	
		
		data.lectura = new LeerArchivoTexto( nombreArchivoConRuta );
		data.cadenaArchivo = data.lectura.getArchivoEnCadena();
		data.renglones = data.cadenaArchivo.split("\n");
		
		data.lectura = null;
		data.status = 0;
	}
	
	public int getStatus(){
		return data.status;
	}
	/**
	 * @since	10/Diciembre/2013
	 */
	public void recordToFile(){
		
		int indice = 0;

		indice = data.nombreArchivoConRuta.lastIndexOf('.');
		data.nombreArchivoLimpio = data.nombreArchivoConRuta.substring(0, indice);
		indice = data.nombreArchivoLimpio.lastIndexOf('\\');
		data.nombreArchivoLimpio = data.nombreArchivoLimpio.substring(indice + 1,	data.nombreArchivoLimpio.length());
				
		//System.out.println(nombreArchivoLimpio);
		
		File folder;
		folder = new File( data.rutaResultado+ "\\" );
		folder.mkdirs();
		new EscribirEnArchivoTexto( data.cadenaSalida, data.rutaResultado + "\\" + data.nombreArchivoLimpio + ".txt" );
		
		//ya se proceso
		rcr = true;
		
		if(rcr & cnv)
			data.status = 2;
	}
	
	/**
	 * @since	10/Dicimebre/2013
	 */
	public void convert(boolean showprocess){
		
		int contador=0;
		boolean bandera=false;
		boolean bandera2=false;
		
		while( contador<data.renglones.length )
		{			
			if(showprocess){
				//Se limpian el area de texto
				data.areaTexto.setText("Separando por Tabuladores...\n");
				data.areaTexto.append(data.renglones[contador]);
			}			
			
			data.cadena="";
			bandera=false;
			data.renglones[contador] = data.renglones[contador].replace("\t","");
			
			for( int i=0; i<data.renglones[contador].length(); i++)
			{
				if( data.renglones[contador].charAt(i)=='\"' )
				{
					if( bandera )
					{
						if( !bandera2 )
						{
							if( data.renglones[contador].charAt(i+1)==',' )
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
					if( data.renglones[contador].charAt(i)==',' && !bandera )
						data.cadena += "\t";
					else
					{
						data.cadena += String.valueOf(data.renglones[contador].charAt(i)); 
					}
				}
			}
			data.cadenaSalida +=data.cadena + "\n";			
			contador++;
		}
		
		// ya se convirtio
		cnv = true;
		
		//Si ambos son 1, el archivo ya se proceso
		if(cnv & rcr)
			data.status = 2;
	}	
	
	/**
	 * @since 10/Diciembre/2013
	 * @return Archivo para leer.
	 */
	public LeerArchivoTexto getTabs(boolean showprocess){
		
		convert(showprocess);
		
		recordToFile();
		
		data.lectura = new LeerArchivoTexto("Salidas\\Scopus\\SalidasTABS\\"
				+ data.nombreArchivoLimpio + ".txt");
		
		data.status = 2;
		return data.lectura;	
	}
}// class ConvierteCvsATab
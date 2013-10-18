/**	
 * @(#)SeleccionadorArchivosGrafico.java
 *
 * Abre una ventana para seleccionar múltiples archivos
 * en forma gráfica y devuelve en un arreglo de Strings
 * los archivos seleccionados por el usuario.
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (25/Febrero/2012)
 */

import javax.swing.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.*;
import java.io.File;

public class SeleccionadorArchivosGrafico 
{
	private String [] archivosSeleccionados;
	private String [] archivosSeleccionados_ruta;
	
	private String ruta;
	
	public SeleccionadorArchivosGrafico (String mensaje, String ... extension)
	{
		archivosSeleccionados = new String[0];
		archivosSeleccionados_ruta = new String[0];
		LeerArchivoTexto lectura = new LeerArchivoTexto( "rutaDefecto.conf" );
		String rutaDefecto = lectura.getArchivoEnCadena();
		
		JFileChooser chooser = new JFileChooser(rutaDefecto);
		//JFileChooser chooser = new JFileChooser("Z:\\Dropbox\\Java\\GIL\\ProyectoSimilitudTextual\\PruebasFreeling\\ArchivosEntradaFreeLing");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter( mensaje, extension );
		chooser.setFileFilter(filter);
		chooser.setMultiSelectionEnabled(true);
		
		int returnVal = chooser.showOpenDialog(null);

		if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
			File archivos [] = chooser.getSelectedFiles();
			ruta = chooser.getCurrentDirectory().toString();
			
			archivosSeleccionados = new String[archivos.length];
			archivosSeleccionados_ruta = new String[archivos.length];
			for( int f=0; f<archivos.length; f++ )
			{
				archivosSeleccionados_ruta[f]=ruta + "\\" + archivos[f].getName(); //archivos con todo y ruta
				//System.out.println("RUTA" + ruta);
				archivosSeleccionados[f]= archivos[f].getName();
			}
			
			//System.out.println("RUTA: " + ruta);
			new EscribirEnArchivoTexto( ruta,"rutaDefecto.conf" );
		}
	}
	
	public String[] getArchivosSeleccionados ()
	{
		return archivosSeleccionados;
	}
	
	public String[] getArchivosSeleccionados_ruta ()
	{
		return archivosSeleccionados_ruta;
	}
	
	public String[] getRutaArchivosSeleccionados ()
	{
		return archivosSeleccionados;
	}
	
}

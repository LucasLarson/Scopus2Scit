import javax.swing.JTextArea;


public class ConvierteCvsATabData {
	public LeerArchivoTexto lectura;
	public String cadenaArchivo;
	public String[] renglones;
	public String nombreArchivoLimpio;
	public String cadenaSalida;
	public String cadena;
	/**
	 * -1 sin construir
	 *  0 construido, sin procesar
	 *  2 construido y procesado
	 */
	public int status;
	public String nombreArchivoConRuta;
	public String rutaResultado;
	public JTextArea areaTexto;

	public ConvierteCvsATabData(String nombreArchivoLimpio,
			String cadenaSalida, String cadena, int status) {
		this.nombreArchivoLimpio = nombreArchivoLimpio;
		this.cadenaSalida = cadenaSalida;
		this.cadena = cadena;
		this.status = status;
	}
}
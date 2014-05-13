import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.SpringLayout;
import java.awt.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.SwingConstants;

public class VerificarPublicaion extends JFrame {
	
	static String[] theseRenglones;
	static String pHomologada; 
	public static HashMap<String, String> publicaciones = new HashMap<String, String>();
	static HashMap<String, String> homologarEstas;
	
	/**
	 * Launch the application.
	 */
	public static void launch(String [] renglones, String homologada, HashMap<String, String> homologar)  {
			
		theseRenglones = renglones;
		pHomologada = homologada;
		homologarEstas = homologar;
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {					
					VerificarPublicaion frame = new VerificarPublicaion();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	
	public void extract(){
		int i = 1;
		int current;
		String [] columnas;
		String [] encabezado; 
		
		//Se extraen los encabezados
		encabezado = theseRenglones[0].split("\t");
		
		while(i < theseRenglones.length){
			 // Busca la columna de los nombres de las publicaciones
			current = encuentraIndice(encabezado,	"SOURCE TITLE");
			
			//Columnas del renglón actual
			columnas = theseRenglones[i++].split("\t");
			publicaciones.put(columnas[current],null); //Se almacena el nombre de la publicacion			
		}		
	}

	/**
	 * Create the frame.
	 */
	public VerificarPublicaion() {
		setAlwaysOnTop(true);
		
		//Extrae las publicaciones del archivo
		extract();
		Iterator it = publicaciones.entrySet().iterator();		
		
		getContentPane().setBackground(new Color(51, 51, 51));
		setTitle("Verficador de Publicaciones");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 391);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		
		JButton btnHomologar = new JButton("Homologar seleccionados");
		btnHomologar.setForeground(Color.WHITE);
		btnHomologar.setBackground(new Color(51, 51, 51));
		getContentPane().add(btnHomologar);
		
		JButton btnNoHomologar = new JButton("No homologar nada");
		springLayout.putConstraint(SpringLayout.EAST, btnHomologar, -6, SpringLayout.WEST, btnNoHomologar);
		springLayout.putConstraint(SpringLayout.NORTH, btnNoHomologar, 0, SpringLayout.NORTH, btnHomologar);
		btnNoHomologar.setForeground(Color.WHITE);
		btnNoHomologar.setBackground(new Color(51, 51, 51));
		getContentPane().add(btnNoHomologar);
		
		final List list = new List();
		springLayout.putConstraint(SpringLayout.NORTH, list, 96, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -62, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -26, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNoHomologar, 0, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.NORTH, btnHomologar, 17, SpringLayout.SOUTH, list);
			
		while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        //Se agregan los elementos del HashMap al modelo
	          list.add(pairs.getKey().toString());
	        it.remove(); // avoids a ConcurrentModificationException
	    }

		list.setMultipleMode(true);		
		getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("Selecciona las publicaciones que ser\u00E1n homologadas con el siguiente nombre:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -331, SpringLayout.SOUTH, getContentPane());
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel);
		
		JLabel lblhomologarSeleccionadosO = new JLabel("Publicaciones de documentos principales en este archivo.");
		springLayout.putConstraint(SpringLayout.WEST, lblhomologarSeleccionadosO, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblhomologarSeleccionadosO, -2, SpringLayout.NORTH, list);
		lblhomologarSeleccionadosO.setForeground(new Color(255, 255, 255));
		lblhomologarSeleccionadosO.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getContentPane().add(lblhomologarSeleccionadosO);
		
		JLabel lblPubHom = new JLabel(pHomologada);
		lblPubHom.setForeground(Color.WHITE);
		lblPubHom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, lblPubHom, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblPubHom, 0, SpringLayout.WEST, list);
		getContentPane().add(lblPubHom);
		
		// Para que no funcione el botón cerrar
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		btnNoHomologar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub								
				dispose();
			}
		});
		
		btnHomologar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String [] resultado = list.getSelectedItems();
				
				for(String pub : resultado)
					homologarEstas.put(pub.trim(), null);
				dispose();
			}
		});
		
		
	}
}

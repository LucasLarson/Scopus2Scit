/**	
 * @(#)ObtenerFrecuencias.java
 *
 * Guarda el contenido de un archivo de texto en una cadena
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (25/Febrero/2012)
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Devuelve el contenido de un archivo de texto en una cadena
public class CatalogoInstituciones{	

	ConnectionFactory db = null;
	
	public CatalogoInstituciones(){
		db = new ConnectionFactory();	
	}
	
	public boolean excluir(String token){
		
		// CASOS DE EXLCUSION
		if( token.matches(".*\\bUNIV(ERSITY)?\\b\\s+\\bWAY\\b.*") || //UNIV WAY | UNIVERSITY WAY
				token.matches(".*\\bWAY\\b.*") ||
				token.matches(".*\\bHALL\\b.*") ||
				token.matches(".*\\bSQUARE\\b.*") ||
				token.matches(".*\\bPLACE\\b.*") ||
				token.matches(".*\\bROW\\b.*") ||
				token.matches(".*\\bCRESCENT\\b.*") ||
				token.matches(".*\\bVIA\\b.*") ||
				token.matches(".*\\bCAMPUS\\b.*") ||
				token.matches(".*\\bCOURT\\b.*") ||
				token.matches(".*\\bC(IUDA)?D\\b.*") || //CD | CIUDAD 				
				token.matches(".*\\bAVE(NUE)?\\b.*") || //AVE | AVENUE
				token.matches(".*\\bAV\\b.*") ||
				token.matches(".*\\bPARK\\b.*") ||
				token.matches(".*\\bR(OA)?D\\b.*") || //RD | ROAD
				token.matches(".*\\bRUE\\b.*") ||
				token.matches(".*\\bBOULEVARD\\b.*") ||
				token.matches(".*\\bSTR\\b.*") ||
				token.matches(".*\\bUNIVERSITATSSTR(A(B|SS)E)?\\b.*") ||
				token.matches(".*SSTR(A(B|SS)E)?\\b.*") ||
				token.matches(".*\\bTECHNIKERSTRABE\\b.*") ||
				token.matches(".*\\bDR(IVE)?\\b.*") ||
				token.matches(".*\\bBLVD\\b.*") ||
				token.matches(".*\\bPLAZA\\b.*") ||
				token.matches(".*\\bLANE\\b.*") ||
				token.matches(".*\\bCOL\\b.*") ||
				token.matches(".*\\bST\\b.*") ||
				token.matches(".*\\bSTREET\\b.*") ||
				token.matches(".*\\bPKWY\\b.*") ||
				token.matches(".*\\bPO\\b\\s+\\bBOX\\b.*") ||
				token.matches(".*\\bUNIV(ERSITY)?\\b\\s+\\bSTATION\\b.*")){		return true;	}
		
		return false;		
	}
	
	public String [] infiereAfiliacion(String [] auxdatos){
		
		List<String> datos;
		String afiliacion="";
		boolean encontrada = false;
		
		datos = new LinkedList<String>(Arrays.asList(auxdatos));
		
		/*if( datos.size() > 0 )
		{*/
			//Búsqueda de una Universidad
			for( int d=0; d<datos.size(); d++ )
			{	
				if(excluir(datos.get(d))){
					datos.remove(d);
					continue;
				}
					
				if(datos.get(d).matches(".*\\bUNIV.*")){		
					afiliacion = datos.get(d);
					encontrada = true;
					break;
				}
			}
			
			//Búsqueda de la palabra Ecole
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{	
					if(datos.get(d).matches(".*\\bECOLE\\b.*")){
						afiliacion = datos.get(d);
						encontrada = true;
						break;
						
					}
				}
			
			//Búsqueda de un Instituto
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{	
					if(datos.get(d).matches(".*\\bINST.*")){	
						
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}
			
			//Búsqueda de la palabra Polit o Polyt
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{	
					if(datos.get(d).matches(".*\\bPOL(I|Y)T.*")){
						
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}		
		

			//Búsqueda de una Academia
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{
					
					if(datos.get(d).matches(".*\\bACAD.*")){
						
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}
			
			//Búsqueda de un Centro
			if(!encontrada)				
				for( int d=0; d<datos.size(); d++ )
				{	
					if(excluir(datos.get(d))){
						datos.remove(d);
						continue;
					}
					
					if(datos.get(d).matches(".*\\bCTR\\b.*") ||
						datos.get(d).matches(".*\\bCENT(ER|RE|RO)?\\b.*") ||
						datos.get(d).matches(".*\\bRESEARCH\\b.*")){
						
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}
			
			
			//Búsqueda de la palabra School
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{				
					if(datos.get(d).matches(".*\\bSCHOOL\\b.*")){
												
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}
				
			//Búsqueda de un Colegio
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{				
					if(datos.get(d).matches(".*\\bCOLL(EGE)?\\b.*")){
											
						afiliacion = datos.get(d);
						encontrada = true;
					}
				}
			
			//Búsqueda de inidicio de una organización
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{		
					
					if(datos.get(d).matches(".*\\bLTD\\b.*") || 
					   datos.get(d).matches(".*\\bINC(ORPORATED)?\\b.*") ||
					   datos.get(d).matches(".*\\bLLC\\b.*") || 
					   datos.get(d).matches(".*\\bNV\\b.*") || 
					   datos.get(d).matches(".*\\bGMBH\\b.*") ||
					   datos.get(d).matches(".*\\bSA\\b.*")){
					
						//afiliacion = afiliacionCompleta.split(",")[0].trim();						
						
						//Si la cadena es mayor a 3 caracteres, seguramente la abreviatura y el nombre estan juntos
						if(datos.get(d).trim().length() > 4 && !datos.get(d).trim().equals("INCORPORATED")) {
							afiliacion = datos.get(d).trim();
							encontrada = true;						
							break;							
						}
						else if(d > 0){
							afiliacion = datos.get(d-1).trim() + " " + datos.get(d).trim();
							encontrada = true;
							break;
						}					
					}
					
					if(datos.get(d).matches(".*\\bBUREAU\\b.*") ||
						datos.get(d).matches(".*\\bOFFICE\\b.*") ||
						datos.get(d).matches(".*\\bAGENCY\\b.*") ||
						datos.get(d).matches(".*\\bORG(ANI)?.*") ||
						datos.get(d).matches(".*\\bMINISTRY\\b.*") ||
						datos.get(d).matches(".*\\bCOMPANY\\b.*") ||
						datos.get(d).matches(".*\\bLIMITED\\b.*") ||
						datos.get(d).matches(".*\\bCORP.*") ||
						datos.get(d).matches(".*\\bCONSULT.*") ||
						datos.get(d).matches(".*\\bCOMISSION\\b.*") ||
						datos.get(d).matches(".*\\bASSOCIATION\\b.*") ||						
						datos.get(d).matches(".*\\bLAB.*") ||						
						datos.get(d).matches(".*\\bINTERNATIONAL\\b.*")){
						
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}
				
			//Búsqueda de un Departamentos
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{				
					if(datos.get(d).matches(".*\\bDEP.*") || datos.get(d).matches(".*\\bDIV.*")){
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}	
			
			//Búsqueda de nombres de organizaciones conocidos
			if(!encontrada)
				for( int d=0; d<datos.size(); d++ )
				{				
					if(datos.get(d).matches(".*\\bIIT\\b.*") ||
						datos.get(d).matches(".*\\bAMD\\b.*") ||
						datos.get(d).matches(".*\\bARUP\\b.*") ||
						datos.get(d).matches(".*\\bASCE\\b.*") ||
						datos.get(d).matches(".*\\bCERN\\b.*") ||
						datos.get(d).matches(".*\\bIBM\\b.*") ||
						datos.get(d).matches(".*\\bGEODATA\\b.*") ||
						datos.get(d).matches(".*\\bHATCH MOTT MACDONALD\\b.*") ||
						datos.get(d).matches(".*\\bIEEE\\b.*") ||
						datos.get(d).matches(".*\\bIMEC\\b.*") ||
						datos.get(d).matches(".*\\bMETROPROJEKT\\b.*") ||
						datos.get(d).matches(".*\\bPRAHA\\b.*") ||
						datos.get(d).matches(".*\\bMOTT MACDONALD\\b.*") ||
						datos.get(d).matches(".*\\bPARSONS BRINCKERHOFF\\b.*") ||
						datos.get(d).matches(".*\\bRAIL LINK ENGINEERING\\b.*") ||
						datos.get(d).matches(".*\\bACM\\b.*") ||
						datos.get(d).matches(".*\\bNASA\\b.*") ||
						datos.get(d).matches(".*\\bFNAL\\b.*") ||						
						datos.get(d).matches(".*\\bGRIET\\b.*") ||
						datos.get(d).matches(".*\\bBITS.*") ||
						datos.get(d).matches(".*\\bUQAC\\b.*") ||
						datos.get(d).matches(".*\\bNIT\\b.*") ||
						datos.get(d).matches(".*\\bKAIST\\b.*") ||
						datos.get(d).matches(".*\\bHILTON MINE\\b.*")){
						
						afiliacion = datos.get(d);
						encontrada = true;
						break;
					}
				}	
			
			if(encontrada){
				afiliacion = afiliacion.trim();
				
				//Quita alguos signos de puntuacion
				afiliacion.replaceAll("[.:,;]", "");
				
				//Identifica las cadenas que comienzan con números. Generalmente son direcciones.
				if (afiliacion.matches("^#?[0-9].*"))
					//Si contiene algún indicio de que es una dirección
					if(excluir(afiliacion)){
						afiliacion = "DOMICILIO";
						return(new String [] {afiliacion.toUpperCase(), "DOMICILIO"});
					}
				return(new String [] {afiliacion.toUpperCase(), "INSTITUCION"});
			}else
				// Si no se detecta la institucion, pero no está vacía. Con el fin de disminuir los "NO DISPONIBLE"			
				afiliacion = auxdatos[0].trim().toUpperCase();
			
			return (new String [] {afiliacion, "NO IDENTIFICADO"});
			
		/*}*/
		
		//return "NO CONTIENE";
	}
	
	public String buscaXInstitucion(String afiliacion, String pais){
		
		ResultSet rs =  null;		
		PreparedStatement pstmt = null;
		String sql = "";		
		int registros = 0;	
		
		//Se abre la conexión a la BD
		db.conn = db.getConnection();
			
		try {
			
			sql = 	"SELECT institucion "
					+ "FROM INSTITUCION i, PAIS_X_INSTITUCION pxi, PAIS p "
					+ "WHERE institucion = ? "
					+ "and pais = ? "
					+ "and i.idinstitucion = pxi.idinstitucion "
					+ "and	p.idpais = pxi.idpais";							
			
			pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, afiliacion);
			pstmt.setString(2, pais);					
			
			rs = pstmt.executeQuery();
			
			// Para saber cuántos registros devolvió la consulta
			if(rs.last()){
				registros = rs.getRow();
				rs.beforeFirst();						
			}
			
			if(registros > 1)
				afiliacion = "MAS DE UNA INSTITUCION(+)";
				//afiliacion = "MAS DE UNA INSTITUCION(+)";
			
			else if( registros == 1 && rs.next() ) 
				//afiliacion = rs.getString(1) + "(+)";
				afiliacion = rs.getString(1);
			else
				afiliacion = "";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeConnection();
		}
	
		return afiliacion;
	}

	public String buscaXVariante(String variante, String pais){
		
		ResultSet rs =  null;		
		PreparedStatement pstmt = null;
		String sql = "";
		String afiliacion = "";
		int registros = 0;	
		
		//Se abre la conexión a la BD
		db.conn = db.getConnection();
				
		try {			
			sql = 	"SELECT institucion "
					+ "FROM		variante v, institucion i, pais p, pais_x_variante pxv, variante_x_institucion vxi "
					+ "WHERE v.idvariante = pxv.idvariante "
					+ "and pxv.idvariante = vxi.idvariante "
					+ "and p.idpais = pxv.idpais "
					+ "and	pxv.idpais = vxi.idpais "
					+ "and  vxi.idinstitucion = i.idinstitucion "
					+ "and	variante = ? "
					+ "and	pais = ?";		
			
			pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, variante);
			pstmt.setString(2, pais);					
			
			rs = pstmt.executeQuery();
			registros = 0;
			
			// Para saber cuántos registros devolvió la consulta
			if(rs.last()){
				registros = rs.getRow();
				rs.beforeFirst();						
			}
			//(1,4,6,9,12), Salida F
			if(registros > 1) 
				afiliacion = "MAS DE UNA INSTITUCION";
				//afiliacion = "MAS DE UNA INSTITUCION(++)";
			
			//(1,4,6,9,10)
			else if( registros == 1 && rs.next() ){ 							
				//afiliacion = rs.getString(1) + "(++)";
				afiliacion = rs.getString(1);
			}else //(1,4,6,9,11)
				afiliacion = "";
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeConnection();
		}	
		return afiliacion;
	}
	
	public String buscaXInstitucion(String afiliacion, int caso){
		
		ResultSet rs =  null;		
		PreparedStatement pstmt = null;
		String sql = "";
		String pais="";
		int registros = 0;		

		//Se abre la conexión a la BD
		db.conn = db.getConnection();
		
		if(caso == 1){			
			
			try {
				
				sql = 	"SELECT pais "
						+ "FROM INSTITUCION i, PAIS_X_INSTITUCION pxi, PAIS p "
						+ "WHERE institucion = ? "
						+ "and i.idinstitucion = pxi.idinstitucion "
						+ "and	p.idpais = pxi.idpais";	
								
				pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, afiliacion);				
				rs = pstmt.executeQuery();
				
				// Para saber cuántos registros devolvió la consulta
				if(rs.last()){
					registros = rs.getRow();
					rs.beforeFirst();						
				}
				
				if(registros > 1) 
					pais = "EN MAS DE UN PAIS";		
				
				else if( registros == 1 && rs.next() ) 
					pais = rs.getString(1); // Se obtiene el nombre del pais
				
				else
					pais = ""; // Cadena vacía
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				db.closeConnection();
			}				
			
			return pais;
		}		
		
		if(caso == 2){
			try {				
				sql = 	"SELECT institucion, pais "
						+ "FROM VARIANTE v, INSTITUCION i, PAIS p, PAIS_X_VARIANTE pxv, VARIANTE_X_INSTITUCION vxi "
						+ "WHERE v.idvariante = pxv.idvariante "
						+ "and pxv.idvariante = vxi.idvariante "
						+ "and	p.idpais = pxv.idpais "
						+ "and	pxv.idpais = vxi.idpais "
						+ "and	vxi.idinstitucion = i.idinstitucion "
						+ "and	variante = ?";
				
				pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
				pstmt.setString(1, afiliacion);
				
				rs = pstmt.executeQuery();
				registros = 0;
											
				// Para saber cuántos registros devolvió la consulta
				if(rs.last()){
					registros = rs.getRow();
					rs.beforeFirst();						
				}
				
				if(registros > 1) 
					pais = "EN MAS DE UN PAIS"; 		
				
				else if( registros == 1 && rs.next() ){						
					afiliacion = rs.getString(1);
					pais = rs.getString(2);
				}else 
					pais = "NO IDENTIFICADO";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				db.closeConnection();
			}	
			
			return afiliacion + "," + pais;
		}
				
		return "";
	}
			
	public String [] buscaCompleto(String afiliacion, int caso){
		
		ResultSet rs =  null;		
		PreparedStatement pstmt = null;
		String sql = "";
		String pais = "";
		int registros = 0;		
		
		//Se abre la conexión a la BD
		db.conn = db.getConnection();
		//(1,4,6,9,11,13)
		if(caso == 1){	
			try {			
				sql = 	"SELECT institucion, pais "
						+ "FROM INSTITUCION i, PAIS_X_INSTITUCION pxi, PAIS p "
						+ "WHERE institucion = ? "
						+ "and i.idinstitucion = pxi.idinstitucion "
						+ "and	p.idpais = pxi.idpais";	
								
				pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, afiliacion);				
				rs = pstmt.executeQuery();
				
				// Para saber cuántos registros devolvió la consulta
				if(rs.last()){
					registros = rs.getRow();
					rs.beforeFirst();						
				}

				//(1,4,6,9,11,13,14), Salida B 
				if(registros > 1){
					//afiliacion += "(+)";
					pais = "EN MAS DE UN PAIS";		
				}
				
				
				//(1,4,6,9,11,13,15), Salida A
				else if( registros == 1 && rs.next() ){
					//afiliacion = rs.getString(1) + "(+)"; // Se obtiene el nombre del pais
					afiliacion = rs.getString(1);
					pais = rs.getString(2); // Se obtiene el nombre del pais
				}
				else //Lleva a la ruta (1,4,6,9,11,13,16)
					return null; // No se encontró nada			
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				db.closeConnection();
			}			
			return new String []{afiliacion, pais};
		}		
		
		//(1,4,6,9,11,13,16)
		if(caso == 2){
			try {				
				sql = 	"SELECT institucion, pais "
						+ "FROM VARIANTE v, INSTITUCION i, PAIS p, PAIS_X_VARIANTE pxv, VARIANTE_X_INSTITUCION vxi "
						+ "WHERE v.idvariante = pxv.idvariante "
						+ "and pxv.idvariante = vxi.idvariante "
						+ "and	p.idpais = pxv.idpais "
						+ "and	pxv.idpais = vxi.idpais "
						+ "and	vxi.idinstitucion = i.idinstitucion "
						+ "and	variante = ?";	
				
				pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, afiliacion);
				rs = pstmt.executeQuery();
				registros = 0;
											
				// Para saber cuántos registros devolvió la consulta
				if(rs.last()){
					registros = rs.getRow();
					rs.beforeFirst();						
				}
				
				//(1,4,6,9,11,13,16,17), Salida C 
				if(registros > 1){ 
					//afiliacion += "(++)";					
					pais = "EN MAS DE UN PAIS"; 		
				}
				//(1,4,6,9,11,13,16,18), Salida A
				else if( registros == 1 && rs.next() ){ 						
					//afiliacion = rs.getString(1) + "(++)";
					afiliacion = rs.getString(1);
					pais = rs.getString(2);
				}else{
					return null;
				}				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				db.closeConnection();
			}	
			
			//(1,4,6,9,11,13,16,19a|19b), Salidas D o E
			return new String []{afiliacion, pais};
		}
		
		return new String []{afiliacion, pais};
	}	
	
	public String extraeAfiliacion( String afiliacionCompleta, String nombreArchivoLimpio)
	{
		CatalogoPaises paises = new CatalogoPaises();
		String pais="";
		String afiliacion="";
		String [] patrones= null;
		String [] auxdatos;		
		
		afiliacionCompleta = afiliacionCompleta.replace(".","");
		auxdatos = afiliacionCompleta.split(",");
		
		//System.out.println(afiliacionCompleta);
		
		/* No viene separado por comas 
		 * CASO C: La cadena no viene separada por comas y no fue posible
		 * identificar el pais. 
		 */ 
		//(3)
		if(auxdatos.length < 2){			
			
			auxdatos = afiliacionCompleta.split(" ");

			// Setrata de inferir el pais			
			pais = paises.infierePais(afiliacionCompleta.trim().toUpperCase());					
			
			if(pais.equals("NO IDENTIFICADO")){
				
				ResultSet rs =  null;		
				Statement stmt = null;
				PreparedStatement pstmt = null;
				String sql = "";				
				boolean encontrado = false, encontrada = false;	
				
				//Se abre la conexión a la BD
				db.conn = db.getConnection();
				 
				try {					
					sql = 	"SELECT pais FROM pais";

					stmt = db.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					rs = stmt.executeQuery(sql);										
					
					while(rs.next()){						
						if(afiliacionCompleta.contains(rs.getString(1))){
							pais = rs.getString(1);
							encontrado = true;
							break;
						}
					}	
					
					// Si se identifico el pais, se hacen las respectivas busquedas "inversas"
					if(encontrado){
						
						sql = 	"SELECT institucion  "
								+ "FROM INSTITUCION i, PAIS_X_INSTITUCION pxi, PAIS p "
								+ "WHERE i.idinstitucion = pxi.idinstitucion "
								+ "and	p.idpais = pxi.idpais "
								+ "and pais = ?";

						pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						pstmt.setString(1, pais);
						rs = pstmt.executeQuery();										
						
						while(rs.next()){						
							if(afiliacionCompleta.contains(rs.getString(1))){
								//afiliacion = rs.getString(1) + "(*)";
								afiliacion = rs.getString(1);
								encontrada = true;
								break;
							}
						}
						
						if(!encontrada){
							sql = 	"SELECT variante, institucion "
									+ "FROM variante v, institucion i, pais p, pais_x_variante pxv, variante_x_institucion vxi "
									+ "WHERE v.idvariante = pxv.idvariante "
									+ "and pxv.idvariante = vxi.idvariante "
									+ "and p.idpais = pxv.idpais "
									+ "and	pxv.idpais = vxi.idpais "
									+ "and  vxi.idinstitucion = i.idinstitucion "
									+ "and	pais = ?";							
							
							pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							pstmt.setString(1, pais);
							rs = pstmt.executeQuery();			
							
							while(rs.next()){						
								if(afiliacionCompleta.contains(rs.getString(1))){
									//afiliacion = rs.getString(2) + "(**)";
									afiliacion = rs.getString(2);
									encontrada = true;
									break;
								}
							}
						}								
														
					}else{
						afiliacion = "NO IDENTIFICADO";
						pais = "NO IDENTIFICADO";						
					}					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					db.closeConnection();
				}
				
				return afiliacion + "," + pais;
			}else{
				ResultSet rs =  null;		
				PreparedStatement pstmt = null;
				String sql = "";				
				boolean encontrada = false;	
				
				//Se abre la conexión a la BD
				db.conn = db.getConnection();
				 
				try {					
					sql = 	"SELECT institucion  "
							+ "FROM INSTITUCION i, PAIS_X_INSTITUCION pxi, PAIS p "
							+ "WHERE i.idinstitucion = pxi.idinstitucion "
							+ "and	p.idpais = pxi.idpais "
							+ "and pais = ?";

					pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					pstmt.setString(1, pais);
					rs = pstmt.executeQuery();										
					
					while(rs.next()){						
						if(afiliacionCompleta.contains(rs.getString(1))){
							//afiliacion = rs.getString(1) + "(*P)";
							afiliacion = rs.getString(1);
							encontrada = true;
							break;
						}
					}
					
					if(!encontrada){
						sql = 	"SELECT variante, institucion "
								+ "FROM variante v, institucion i, pais p, pais_x_variante pxv, variante_x_institucion vxi "
								+ "WHERE v.idvariante = pxv.idvariante "
								+ "and pxv.idvariante = vxi.idvariante "
								+ "and p.idpais = pxv.idpais "
								+ "and	pxv.idpais = vxi.idpais "
								+ "and  vxi.idinstitucion = i.idinstitucion "
								+ "and	pais = ?";							
						
						pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						pstmt.setString(1, pais);
						rs = pstmt.executeQuery();								
					}
					
					while(rs.next()){						
						if(afiliacionCompleta.contains(rs.getString(1))){
							//afiliacion = rs.getString(2) + "(**P)";
							afiliacion = rs.getString(2);
							encontrada = true;
							break;
						}
					}
					
					if(!encontrada)
						afiliacion = "NO IDENTIFICADO?";
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					db.closeConnection();
				}				
			}
			return afiliacion + "," + pais;
			
		}else{// Si viene separado por comas			
			//(1)
			// Patrones de identificacion del nombre de la institucion
			patrones = infiereAfiliacion(auxdatos);
			afiliacion = patrones[0];
			
			// Se identifico el nombre de una posible institucion
			//(1,4)
			if(patrones[1].equals("INSTITUCION") || patrones[1].equals("NO IDENTIFICADO")){
				// Se extrae el pais, que es la última cadena
				String afiliacionTmp;			
				
				pais = auxdatos[auxdatos.length - 1].trim().toUpperCase();
				pais = paises.validaPais(pais);
				
				//(1,4,6)
				if(!pais.equals("NO IDENTIFICADO")){ 
					
					//(1,4,6,8)
					afiliacionTmp = buscaXInstitucion(afiliacion, pais);
					
					if(afiliacionTmp.isEmpty()){ //No se encontró el nombre oficial x pais						

						//(1,4,6,9)
						afiliacionTmp = buscaXVariante(afiliacion, pais);
						
						if(afiliacionTmp.isEmpty()){ //No se encontró una variante x pais
									
							//(1,4,6,9,11,13)
							String [] afiliacionTmp2 = buscaCompleto(afiliacion, 1);
							
							if(afiliacionTmp2 == null){//No se encontro el nombre oficial sin filtrar por pais
								
								//Se busca en las variante, y si no se encuentra, se deja el texto original
								//(1,4,6,9,11,16)
								// Ver rutas y salidas en la función buscaCompleto()								
								//(1,4,6,9,11,13,16,17), Salida C o (1,4,6,9,11,13,16,18), Salida A
								
								
								afiliacionTmp2 = buscaCompleto(afiliacion, 2);
								
								if(afiliacionTmp2 != null){
									afiliacion = afiliacionTmp2[0];
									
									if(!afiliacionTmp2[1].isEmpty())
										pais = afiliacionTmp2[1];									
								}else{		
									
									// Busqueda inversa de la institucion, pero filtrada por el pais identificado
									ResultSet rs =  null;
									PreparedStatement pstmt = null;
									String sql = "";				
									boolean encontrada = false;	
									
									//Se abre la conexión a la BD
									db.conn = db.getConnection();
									 
									try {	
										
										sql = 	"SELECT institucion  "
												+ "FROM INSTITUCION i, PAIS_X_INSTITUCION pxi, PAIS p "
												+ "WHERE i.idinstitucion = pxi.idinstitucion "
												+ "and	p.idpais = pxi.idpais "
												+ "and pais = ? "
												+ "order by institucion";

										pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
										pstmt.setString(1, pais);
										rs = pstmt.executeQuery();										
										
										while(rs.next()){						
											if(afiliacion.contains(rs.getString(1))){
												//afiliacion = rs.getString(1) + "(+-)";
												afiliacion = rs.getString(1);
												encontrada = true;
												break;
											}
										}
										
										if(!encontrada){
											sql = 	"SELECT variante, institucion "
													+ "FROM variante v, institucion i, pais p, pais_x_variante pxv, variante_x_institucion vxi "
													+ "WHERE v.idvariante = pxv.idvariante "
													+ "and pxv.idvariante = vxi.idvariante "
													+ "and p.idpais = pxv.idpais "
													+ "and	pxv.idpais = vxi.idpais "
													+ "and  vxi.idinstitucion = i.idinstitucion "
													+ "and	pais = ? "
													+ "order by variante";							
											
											pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
											pstmt.setString(1, pais);
											rs = pstmt.executeQuery();								
										}								
										while(rs.next()){						
											if(afiliacion.contains(rs.getString(1))){
												//afiliacion = rs.getString(2) + "(++-)";
												afiliacion = rs.getString(2);
												encontrada = true;
												break;
											}
										}	
										
										if(!encontrada){
											afiliacion += "?";
											//Escribirlo en la bitacora
											new EscribirEnArchivoTexto(afiliacion + "\t" + pais,
													"Salidas\\Scopus\\ReporteInstituciones\\"
															+ nombreArchivoLimpio + "_INTITUCIONES2.LOG");
										}
																	
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}finally{
										db.closeConnection();
									}
								}
											 																
							}else{
								
								// Ver rutas y salidas en la función buscaCompleto()
								//(1,4,6,9,11,13,14), Salida B o (1,4,6,9,11,13,15), Salida A
								afiliacion = afiliacionTmp2[0];
								pais = afiliacionTmp2[1];								
							}
						}else{//Se encontro el nombre oficial a partir de su variante x pais							

							//(1,4,6,9,10), Salida A o (1,4,6,9,12), Salida F
							afiliacion = afiliacionTmp;
						}
					}else{// Si se encontró el nombre oficial x pais

						//(1,4,6,8,10), Salida A
						afiliacion = afiliacionTmp;
					}
				}else{ // No se encuentra el pais 
					
					boolean comprobacion1 = false, comprobacion2 = false;
					
					String [] afiliacionTmp2 = buscaCompleto(afiliacion, 1);
										
					if(afiliacionTmp2 == null){//No se encontro el nombre oficial sin filtrar por pais
						//Se busca en las variante, y si no se encuentra, se deja el texto original
						
						afiliacionTmp2 = buscaCompleto(afiliacion, 2);
																				
						if(afiliacionTmp2 != null){
							//afiliacion = afiliacionTmp2[0] + "*";
							afiliacion = afiliacionTmp2[0];
							if(!afiliacionTmp2[1].isEmpty()){
								pais = afiliacionTmp2[1];
								
								if(!pais.equals("NO IDENTIFICADO"))
									comprobacion1 = true;
							}
						}else{
							afiliacion += "?";
							comprobacion1 = false;
						}
								
					}else{				
						comprobacion1 = true;
						//afiliacion = afiliacionTmp2[0] + "*";
						afiliacion = afiliacionTmp2[0];
						pais = afiliacionTmp2[1];								
					}
					
					/* Si al final de todo, el país sigue siendo "NO IDENTIFICADO", se hace un ultimo intento
					 * por encontrar el pais y la institucion
					 */ 
					if(pais.equals("NO IDENTIFICADO")){
						ResultSet rs =  null;		
						Statement stmt = null;
						PreparedStatement pstmt = null;
						String sql = "";				
						boolean encontrado = false, encontrada = false;	
						
						//Se abre la conexión a la BD
						db.conn = db.getConnection();
						 
						try {					
							sql = 	"SELECT pais FROM pais";

							stmt = db.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							rs = stmt.executeQuery(sql);										
							
							while(rs.next()){						
								if(afiliacionCompleta.contains(rs.getString(1))){
									pais = rs.getString(1);
									encontrado = true;
									break;
								}
							}	
							
							// Si se identifico el pais, se hacen las respectivas busquedas "inversas"
							if(encontrado){
								
								sql = 	"SELECT institucion  "
										+ "FROM INSTITUCION i, PAIS_X_INSTITUCION pxi, PAIS p "
										+ "WHERE i.idinstitucion = pxi.idinstitucion "
										+ "and	p.idpais = pxi.idpais "
										+ "and pais = ?";

								pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
								pstmt.setString(1, pais);
								rs = pstmt.executeQuery();										
								
								while(rs.next()){						
									if(afiliacionCompleta.contains(rs.getString(1))){
										//afiliacion = rs.getString(1) + "(+-)";
										afiliacion = rs.getString(1);
										encontrada = true;
										comprobacion2 = true;
										break;
									}
								}
								
								if(!encontrada){
									sql = 	"SELECT variante, institucion "
											+ "FROM variante v, institucion i, pais p, pais_x_variante pxv, variante_x_institucion vxi "
											+ "WHERE v.idvariante = pxv.idvariante "
											+ "and pxv.idvariante = vxi.idvariante "
											+ "and p.idpais = pxv.idpais "
											+ "and	pxv.idpais = vxi.idpais "
											+ "and  vxi.idinstitucion = i.idinstitucion "
											+ "and	pais = ?";							
									
									pstmt = db.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
									pstmt.setString(1, pais);
									rs = pstmt.executeQuery();
									
									while(rs.next()){						
										if(afiliacionCompleta.contains(rs.getString(1))){
											//afiliacion = rs.getString(2) + "(++-)";
											afiliacion = rs.getString(2);
											encontrada = true;
											comprobacion2 = true;
											break;
										}
									}	
								}								
								
								
								if(!encontrada){			
									//afiliacion += "(+++-)";
									comprobacion2 = false;
								}
							}else{
								//afiliacion += "(+++-)";
								comprobacion2 = false;								
							}							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							db.closeConnection();
						}	
					}else{
						comprobacion2 = true;
					}
					
					//Escribir en la bitacora
					if(!comprobacion1 && !comprobacion2)
						new EscribirEnArchivoTexto(afiliacion + "\t" + pais,
								"Salidas\\Scopus\\ReporteInstituciones\\"
										+ nombreArchivoLimpio + "_INTITUCIONES2.LOG");					
				}
			}
		}
		
		/*System.out.println("F: "+afiliacion + "," + pais);
		System.out.println("===========");*/
		
		return afiliacion + "," + pais;
	}		
}

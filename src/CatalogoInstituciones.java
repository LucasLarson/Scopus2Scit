/**	
 * @(#)ObtenerFrecuencias.java
 *
 * Guarda el contenido de un archivo de texto en una cadena
 *
 * @author Hernández Domínguez Laura Elena
 * @version 1.0 (25/Febrero/2012)
 */

 
//Devuelve el contenido de un archivo de texto en una cadena
public class CatalogoInstituciones
{
	
	public CatalogoInstituciones( )
	{
		
	}
	
	public String extraeAfiliacion( String afiliacionCompleta, String nombreArchivoLimpio)
	{
		String afiliacion="";
		String [] datos;
		int bandera=0;
		
		afiliacionCompleta = afiliacionCompleta.replace(".","");
		
		datos = afiliacionCompleta.split(",");
		
		if( datos.length>0 )
		{
			for( int d=0; d<datos.length; d++ ) // Busco la afiliación principal, que es la Universidad
			{
				datos[d] = datos[d].trim();
				
				if( ( datos[d].contains( "UNIV" ) || datos[d].contains( "UNAM" ) ) && !datos[d].contains( "UNIVERSITY WAY" ) && !datos[d].contains( "CIUDAD" ) && !datos[d].contains( "UNIV WAY" ) && !datos[d].contains( " RD" ) && !datos[d].contains( " ROAD" ) && !datos[d].contains( " STR" ) && !datos[d].contains( "UNIVERSITATSSTR" ) && !datos[d].contains( " AVENUE" ) && !datos[d].contains( " UNIVERSITATSSTRABE" ) && !datos[d].contains( "TECHNIKERSTRABE" ) && !datos[d].contains( " DRIVE" ) && !datos[d].contains( "PO BOX" ) && !datos[d].contains( " BLVD" ) && !datos[d].contains( " PLAZA" ) )//University tiene prioridad sobre todo lo demás
				{
					afiliacion = datos[d];
					bandera = 1;
				}
			}
			
			if( bandera!= 1) // No está el nombre de la universidad
			{
				for( int d=0; d<datos.length; d++ ) 
				{
					datos[d] = datos[d].trim();
					
					if( ( datos[d].contains( "ACAD" ) ) && !datos[d].contains( " STATION" ) && !datos[d].contains( " RD" ) && !datos[d].contains( " ROAD" ) && !datos[d].contains( " STR" ) && !datos[d].contains( " AVENUE" ) && !datos[d].contains( "TECHNIKERSTRABE" ) && !datos[d].contains( " DRIVE" ) && !datos[d].contains( "PO BOX" ) && !datos[d].contains( " BLVD" ) && !datos[d].contains( " PLAZA" ) )//Academy
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // No está el nombre de la universidad
			{
				for( int d=0; d<datos.length; d++ ) 
				{
					datos[d] = datos[d].trim();
					
					if( ( datos[d].contains( "COLL" ) ) && !datos[d].contains( " STATION" ) && !datos[d].contains( " RD" ) && !datos[d].contains( " ROAD" ) && !datos[d].contains( " STR" ) && !datos[d].contains( " AVENUE" ) && !datos[d].contains( "TECHNIKERSTRABE" ) && !datos[d].contains( " DRIVE" ) && !datos[d].contains( "PO BOX" ) && !datos[d].contains( " BLVD" ) && !datos[d].contains( " PLAZA" ) )//Academy
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // No está el nombre de la universidad
			{
				for( int d=0; d<datos.length; d++ ) 
				{
					datos[d] = datos[d].trim();
					
					if( ( datos[d].contains( "ACAD" ) ) && !datos[d].contains( " STATION" ) && !datos[d].contains( " RD" ) && !datos[d].contains( " ROAD" ) && !datos[d].contains( " STR" ) && !datos[d].contains( " AVENUE" ) && !datos[d].contains( "TECHNIKERSTRABE" ) && !datos[d].contains( " DRIVE" ) && !datos[d].contains( "PO BOX" ) && !datos[d].contains( " BLVD" ) && !datos[d].contains( " PLAZA" ) )//Academy
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // No está el nombre de la universidad
			{
				for( int d=0; d<datos.length; d++ ) // Busco la afiliación principal, que es la Universidad
				{
					datos[d] = datos[d].trim();
					
					if( ( datos[d].contains( "ACAD" ) ) && !datos[d].contains( " STATION" ) && !datos[d].contains( "UNIVERSITY WAY" ) && !datos[d].contains( "UNIV WAY" ) && !datos[d].contains( " RD" ) && !datos[d].contains( " ROAD" ) && !datos[d].contains( " STR" ) && !datos[d].contains( "UNIVERSITATSSTR" ) && !datos[d].contains( " AVENUE" ) && !datos[d].contains( " UNIVERSITATSSTRABE" ) && !datos[d].contains( "TECHNIKERSTRABE" ) && !datos[d].contains( " DRIVE" ) && !datos[d].contains( "PO BOX" ) && !datos[d].contains( " BLVD" ) && !datos[d].contains( " PLAZA" ) )//University 
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // No está el nombre de la universidad
			{
				for( int d=0; d<datos.length; d++ ) // Busco la afiliación principal, que es la Universidad
				{
					datos[d] = datos[d].trim();
					
					if( ( datos[d].contains( "UNIV" ) || datos[d].contains( "UNAM" ) ||
							datos[d].contains( "ACAD" ) ) && !datos[d].contains( " STATION" ) && !datos[d].contains( "UNIVERSITY WAY" ) && !datos[d].contains( "CIUDAD" )  && !datos[d].contains( "UNIV WAY" ) && !datos[d].contains( " RD" ) && !datos[d].contains( " ROAD" ) && !datos[d].contains( " STR" ) && !datos[d].contains( "UNIVERSITATSSTR" ) && !datos[d].contains( " AVENUE" ) && !datos[d].contains( " UNIVERSITATSSTRABE" ) && !datos[d].contains( "TECHNIKERSTRABE" ) && !datos[d].contains( " DRIVE" ) && !datos[d].contains( "PO BOX" ) && !datos[d].contains( " BLVD" ) && !datos[d].contains( " PLAZA" ) )//University 
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			if( bandera!= 1) // No está el nombre de la universidad
			{
				for( int d=0; d<datos.length; d++ )
				{
					datos[d] = datos[d].trim();
					
					if( datos[d].contains( "IN	ST" ) || datos[d].contains( "COLLEGE" ) || datos[d].contains( "ECOLE" ) || datos[d].contains( "SCHOOL" )
					)// "INSTITUTE" || 
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // No está el nombre de la universidad
			{
				for( int d=0; d<datos.length; d++ ) 
				{
					datos[d] = datos[d].trim();
					
					if( ( datos[d].contains( "TECH" ) ) && !datos[d].contains( " STATION" ) && !datos[d].contains( " RD" ) && !datos[d].contains( " ROAD" ) && !datos[d].contains( " STR" ) && !datos[d].contains( " AVENUE" ) && !datos[d].contains( "TECHNIKERSTRABE" ) && !datos[d].contains( " DRIVE" ) && !datos[d].contains( "PO BOX" ) && !datos[d].contains( " BLVD" ) && !datos[d].contains( " PLAZA" ) )//Academy
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			
			if( bandera!= 1) // Tampoco está el nombre del Instituto
			{
				for( int d=0; d<datos.length; d++ )
				{
					datos[d] = datos[d].trim();
					
					if( datos[d].contains( "CTR" ) || datos[d].contains( "CENT" ) || datos[d].contains( "RESEARCH" ) ) // "CENTER" || 
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // Tampoco está el nombre del Centro
			{
				for( int d=0; d<datos.length; d++ )
				{
					datos[d] = datos[d].trim();
					
					if( datos[d].contains( "DEP" ) || datos[d].contains( "FAC"  )  || datos[d].contains( "DIV" )) // "DEPARTMENT" || "FACULTY" || DIVISION
					{
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // buscamos indicio de otras instituciones
			{
				for( int d=0; d<datos.length; d++ )
				{
					datos[d] = datos[d].trim();
					
					if( datos[d].contains( "BUREAU" ) || datos[d].contains( "OFFICE"  ) ||
					datos[d].contains( "AGENCY" ) || datos[d].contains( "ORGANI"  ) ||
					datos[d].contains( "MINISTRY" ) || datos[d].contains( "COMPANY"  ) ||
					datos[d].contains( "CORP"  ) || datos[d].contains( "CONSULT"  ) ||
					datos[d].contains( "CO LTD" ) || datos[d].contains( "GMBH"  ) ||
					datos[d].contains( "COMISSION" ) || datos[d].contains( "ASSOCIATION"  ) ||
					datos[d].endsWith( "INC" ) || datos[d].endsWith( "LTD" ) ||
					datos[d].endsWith( " CO" ) || datos[d].endsWith( "INCORPORATED" ) ||
					datos[d].endsWith( "LLC" ) || datos[d].endsWith( "ORG" ) ||
					datos[d].contains( "LAB"  ) || datos[d].contains( "INTERNATIONAL" ) || 
					datos[d].endsWith( " SA" ) || datos[d].endsWith( "SA DE CV" ) ||
					datos[d].endsWith( " AG" )					
						) 
					{
						datos[d] = datos[d].trim();
						if( ( datos[d].compareTo("INC")==0 || datos[d].compareTo("ORG")==0 || 
						datos[d].compareTo("CO")==0 || datos[d].compareTo("SA")==0  || 
						datos[d].compareTo("CO LTD")==0 || datos[d].compareTo("LTD")==0  || 
						datos[d].compareTo("LLC")==0 || datos[d].compareTo("AG")==0 || 
						datos[d].compareTo("SA")==0 || datos[d].compareTo("SA DE CV")==0 || 
						datos[d].compareTo("GMBH")==0 
						) && (d>0) 	)
							afiliacion = datos[d-1];
						else
							afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			if( bandera!= 1) // buscamos indicio de las instituciones más comunes
			{
				for( int d=0; d<datos.length; d++ )
				{
					datos[d] = datos[d].trim();
					
					if( datos[d].contains( "AMD" ) || datos[d].contains( "ARUP"  ) ||
					datos[d].contains( "ASCE" ) || datos[d].contains( "CERN"  ) || datos[d].contains( "IBM" ) ||
					datos[d].contains( "GEODATA" ) || datos[d].contains( "HATCH MOTT MACDONALD"  ) ||
					datos[d].contains( "IEEE"  ) || datos[d].contains( "IMEC"  ) ||
					datos[d].contains( "METROPROJEKT PRAHA" ) || datos[d].contains( "MOTT MACDONALD"  ) ||
					datos[d].contains( "PARSONS BRINCKERHOFF" ) || datos[d].contains( "RAIL LINK ENGINEERING"  ) ||
					datos[d].endsWith( "ACM" ) || datos[d].contains( "NASA"  ) || datos[d].contains( "FNAL"  ) || 
					datos[d].contains( "GEODATA SPA"  ) || datos[d].contains( "HILTON MINE"  )
						) 
					{
						datos[d] = datos[d].trim();
						afiliacion = datos[d];
						bandera = 1;
					}
				}
			}
			
			// Buscamos el nombre completo u oficial de la institución
			afiliacion = getNombreCompletoInstitucion(afiliacion, bandera);
			
			//afiliacion = detectaAfiliacion( afiliacion );
			afiliacion = afiliacion.trim();
			
			if( afiliacion.compareTo("*")==0 ){
				afiliacion="NO DISPONIBLE";
				new EscribirEnArchivoTexto(afiliacionCompleta,"Salidas\\Scopus\\"+nombreArchivoLimpio+"_INTITUCIONES.LOG");
			}
			//Agrego el país, que es lo último que se menciona -si se menciona-:
			if( datos.length>1 )
				afiliacion += ", " + datos[ datos.length-1 ];
			
			return afiliacion;
		}
		new EscribirEnArchivoTexto(afiliacionCompleta,"Salidas\\Scopus\\"+nombreArchivoLimpio+"_INTITUCIONES.LOG");
		return "NO DISPONIBLE";
	}//extraeAfiliacion
	
	public String getNombreCompletoInstitucion( String afiliacion, int bandera )
	{
		afiliacion = afiliacion.replace(".","");
		afiliacion = afiliacion.replace("+"," AND ");
		afiliacion = afiliacion.replace(" & "," AND ");
		afiliacion = afiliacion.replace("&"," AND ");
		afiliacion = afiliacion.replace("THE UNIVERSITY","UNIVERSITY");
		afiliacion = afiliacion.replace("  "," ");
		afiliacion = afiliacion.replace("  "," ");
		
		afiliacion = afiliacion.trim();
		
		
		/* --------- CHINAS ---------- */
			if( (afiliacion.contains("THREE")||afiliacion.contains("3")) && afiliacion.contains("GORGE") && afiliacion.contains("UNIV") )
					return "THREE GORGES UNIVERSITY";
			
			if( (afiliacion.contains("THREE")||afiliacion.contains("3")) && afiliacion.contains("GORGE") && afiliacion.contains("COLL") )
					return "THREE GORGES UNIVERSITY";
			
			if( (afiliacion.contains("THREE")||afiliacion.contains("3")) && afiliacion.contains("GORGE") && afiliacion.contains("CORP") )
					return "THREE GORGES CORPORATION";
					
			
			if( afiliacion.contains("YELLOW") && afiliacion.contains("RIVER") && afiliacion.contains("INST") && afiliacion.contains("HYD") )
					return "YELLOW RIVER INSTITUTE OF HYDRAULIC RESEARCH";
			
			if( afiliacion.contains("YELLOW") && afiliacion.contains("RIVER") && afiliacion.contains("WATER") && afiliacion.contains("HYD") )
					return "YELLOW RIVER WATER AND HYDROELECTRIC POWER DEVELOPMENT CORPORATION";
			
			
			if( afiliacion.contains("CHANGJIANG") && afiliacion.contains("SURV") && afiliacion.contains("INST") )
					return "CHANGJIANG INSTITUTE OF SURVEY";
			
			if( afiliacion.contains("CHANGJIANG") && afiliacion.contains("RIVER") && afiliacion.contains("SCI") && afiliacion.contains("RES") )
					return "CHANGJIANG RIVER SCIENTIFIC RESEARCH INSTITUTE";
			if( afiliacion.contains("CRSRI") )
					return "CHANGJIANG RIVER SCIENTIFIC RESEARCH INSTITUTE";
			if( afiliacion.contains("YANGTZE") && afiliacion.contains("RIVER") && afiliacion.contains("SCI") && afiliacion.contains("RES") )
					return "CHANGJIANG RIVER SCIENTIFIC RESEARCH INSTITUTE";
			if( afiliacion.contains("YRSRI") )
					return "CHANGJIANG RIVER SCIENTIFIC RESEARCH INSTITUTE";
			
			
			if( afiliacion.contains("SHOUGANG") && afiliacion.contains("TECH") && afiliacion.contains("INST") )
				return "SHOUGANG INSTITUTE OF TECHNOLOGY";
			
			if( afiliacion.contains("SHENYANG") && afiliacion.contains("JIAN") && afiliacion.contains("ZHU") && afiliacion.contains("UNIV") )
				return "SHENYANG JIANZHU UNIVERSITY";
			
			if( afiliacion.contains("SHENYANG") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
				return "SHENYANG UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("SHENYANG") && afiliacion.contains("NORM") && afiliacion.contains("UNIV") )
				return "SHENYANG NORMAL UNIVERSITY";
			
			if( afiliacion.contains("SHENYANG") && afiliacion.contains("AER") && afiliacion.contains("UNIV") )
				return "SHENYANG AEROSPACE UNIVERSITY";
			
			if( afiliacion.contains("SHENYANG") && afiliacion.contains("UNIV") )
				return "SHENYANG UNIVERSITY";
			
			if( afiliacion.contains("CHENGDU") && afiliacion.contains("HYD") && afiliacion.contains("ELEC") && afiliacion.contains("INVEST") && afiliacion.contains("DES") && afiliacion.contains("INST") )
				return "CHENGDU HYDROELECTRIC INVESTIGATION AND DESIGN INSTITUTE";
			
			if( afiliacion.contains("QINGDAO") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
				return "QINGDAO TECHNOLOGICAL UNIVERSITY";
			
			if( (afiliacion.contains("SOUTH") || afiliacion.contains("S ")) && afiliacion.contains("MID") && afiliacion.contains("DES") && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "MID SOUTH DESIGN AND RESEARCH INSTITUTE";
			if( afiliacion.compareTo("CHECC")==0 )
					return "MID SOUTH DESIGN AND RESEARCH INSTITUTE";
			
			if( afiliacion.contains("KUNMING") && afiliacion.contains("HYDRO") && afiliacion.contains("ELEC")  && (afiliacion.contains("INV")||afiliacion.contains("RES"))  && afiliacion.contains("DES") && afiliacion.contains("INST")   )
				return "KUNMING HYDROELECTRIC INVESTIGATION DESIGN AND RESEARCH INSTITUTE";
			
			if( afiliacion.contains("KYUSHU") && afiliacion.contains("ELEC") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) )
				return "KYUSHU ELECTRIC POWER COMPANY";
			
			if( afiliacion.contains("LAR") && afiliacion.contains("CONSULT") && afiliacion.contains("ENG") )
				return "LAR CONSULTING ENGINEERS";
			
			if( afiliacion.contains("LANZHOU") && afiliacion.contains("SEISM") && afiliacion.contains("INST") )
				return "LANZHOU INSTITUTE OF SEISMOLOGY";
			
			if( afiliacion.contains("CHIN") && (afiliacion.contains("E ") || afiliacion.contains("EAST")) && afiliacion.contains("INV") && afiliacion.contains("DES") && afiliacion.contains("INST"))
					return "EAST CHINA INVESTIGATION AND DESIGN INSTITUTE";
			
			if( afiliacion.contains("CHINA") && afiliacion.contains("HYDRO") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) )
				return "CHINA HYDROPOWER ENGINEERING CONSULTING GROUP";
			
			if( afiliacion.contains("GUANGXI") && afiliacion.contains("UNIV") && afiliacion.contains("TECH") )
				return "GUANGXI UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("GUANGXI") && afiliacion.contains("UNIV") )
				return "GUANGXI UNIVERSITY";
			
			if( afiliacion.contains("HEBEI") && afiliacion.contains("POLY") && afiliacion.contains("UNIV") )
					return "HEBEI POLYTECHNIC UNIVERSITY";
			
			if( afiliacion.contains("HEBEI") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "HEBEI UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("HEBEI") && afiliacion.contains("UNITED")  && afiliacion.contains("UNIV") )
					return "HEBEI UNITED UNIVERSITY";
				
			if( afiliacion.contains("HEBEI") && afiliacion.contains("NORMAL")  && afiliacion.contains("UNIV") )
					return "HEBEI NORMAL UNIVERSITY";			
			
			if( afiliacion.contains("HEBEI") && afiliacion.contains("UNIV") )
					return "HEBEI UNIVERSITY";
			
			
			if( afiliacion.contains("AGR") && afiliacion.contains("UNIV") && afiliacion.contains("HEBEI") )
					return "AGRICULTURAL UNIVERSITY OF HEBEI";
			
			if( afiliacion.contains("AGR") && afiliacion.contains("UNIV") && afiliacion.contains("CHINA") )
					return "CHINA AGRICULTURAL UNIVERSITY";
			
			if( (afiliacion.contains("NORTH") || afiliacion.contains("N ")) && afiliacion.contains("CHINA") && afiliacion.contains("CONS") && afiliacion.contains("WATER") && afiliacion.contains("RES") && afiliacion.contains("HYD") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) )
					return "NORTH CHINA INSTITUTE OF WATER CONSERVANCY AND HYDROELECTRIC POWER";
			 
			if( afiliacion.contains("WATER") && (afiliacion.contains("RES")||afiliacion.contains("RSR")) && afiliacion.contains("HYD") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) )
					return "CHINA INSTITUTE OF WATER RESOURCES AND HYDROPOWER RESEARCH";
			if( afiliacion.compareTo("IWHR")==0 )
					return "CHINA INSTITUTE OF WATER RESOURCES AND HYDROPOWER RESEARCH";
			
			if( afiliacion.contains("SHI") && afiliacion.contains("JIA") && afiliacion.contains("ZHUANG") && afiliacion.contains("RAILWAY") )
					return "SHIJIAZHUANG RAILWAY INSTITUTE";
			
			if( afiliacion.contains("FUSHAN") && afiliacion.contains("UNIV") )
					return "FUSHAN UNIVERSITY";
			
			if( afiliacion.contains("SHI") && afiliacion.contains("JIA") && afiliacion.contains("ZHUANG") && afiliacion.contains("RAILWAY") && afiliacion.contains("TIE") && afiliacion.contains("DAO") )
					return "SHIJIAZHUANG TIEDAO UNIVERSITY";
			
			if( afiliacion.contains("WORK") && afiliacion.contains("SAFE") && afiliacion.contains("RES") && afiliacion.contains("ADMIN") )
					return "RESEARCH CENTER OF STATE ADMINISTRATION OF WORK SAFETY";
			
			if( afiliacion.contains("HIGHWAY") && afiliacion.contains("INST") && afiliacion.contains("RES"))
					return "RESEARCH INSTITUTE OF HIGHWAY OF THE MINISTRY OF TRANSPORT";
			
			if( afiliacion.contains("GEO") && afiliacion.contains("COAL") && afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("EXP"))
					return "RESEARCH INSTITUTE OF COAL GEOPHYSICAL EXPLORATION";
					
			if(afiliacion.contains("GEOTECH") && afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("ENG"))
					return "RESEARCH INSTITUTE OF GEOTECHNICAL ENGINEERING";
			
			if(afiliacion.contains("BEIJING") && afiliacion.contains("UNIV") && afiliacion.contains("POST") && afiliacion.contains("TEL"))
					return "BEIJING UNIVERSITY OF POSTS AND TELECOMMUNICATIONS";
			
			if(afiliacion.contains("XIAN") && afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("HI") && afiliacion.contains("TECH"))
					return "XIAN RESEARCH INSTITUTE OF HIGH TECHNOLOGY";
			
			if(afiliacion.contains("XIAN") && afiliacion.contains("TECH") && afiliacion.contains("UNIV"))
					return "XIAN UNIVERSITY OF TECHNOLOGY";
					
			if(afiliacion.contains("ERTAN") && afiliacion.contains("HYDR") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("DEV"))
					return "ERTAN HYDROPOWER DEVELOPMENT COMPANY LIMITED";
			
			if(afiliacion.contains("MIN") && afiliacion.contains("TECH") && afiliacion.contains("CHINA") && afiliacion.contains("UNIV"))
					return "CHINA UNIVERSITY OF MINING AND TECHNOLOGY CHINA";
			
			if(afiliacion.contains("FOSHAN") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "FOSHAN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if(afiliacion.contains("BEIJING") && afiliacion.contains("FORESTRY") && afiliacion.contains("UNIV"))
					return "BEIJING FORESTRY UNIVERSITY";
			
			if(afiliacion.contains("BEIJING") && afiliacion.contains("AERO") && afiliacion.contains("ASTRO") && afiliacion.contains("UNIV"))
					return "BEIJING UNIVERSITY OF AERONAUTICS AND ASTRONAUTICS";
					
			if(afiliacion.contains("BEIJING") && afiliacion.contains("NORMAL") && afiliacion.contains("UNIV"))
					return "BEIJING NORMAL UNIVERSITY";
					
			if(afiliacion.contains("BEIJING") && afiliacion.contains("CHEM") && afiliacion.contains("TECH")&& afiliacion.contains("UNIV"))
					return "BEIJING UNIVERSITY OF CHEMICAL TECHNOLOGY";
					
			if(afiliacion.contains("BEIJING") && afiliacion.contains("TECH") && afiliacion.contains("UNIV"))
					return "BEIJING UNIVERSITY OF TECHNOLOGY";
			
			if(afiliacion.contains("BEIJING") && afiliacion.contains("SCI") && afiliacion.contains("TECH") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF SCIENCE AND TECHNOLOGY BEIJING";
					
			if(afiliacion.contains("CHIN") && afiliacion.contains("GEOSCI") && afiliacion.contains("UNIV") )
					return "CHINA UNIVERSITY OF GEOSCIENCES";
					
			if(afiliacion.contains("CHIN") && afiliacion.contains("UNIV") && afiliacion.contains("MINING") && afiliacion.contains("TECH"))
					return "CHINA UNIVERSITY OF MINING AND TECHNOLOGY";
			
			if(afiliacion.contains("CHIN") && afiliacion.contains("ACAD") && afiliacion.contains("FORESTRY"))
					return "CHINESE ACADEMY OF FORESTRY";
					
			if(afiliacion.contains("CHIN") && afiliacion.contains("ACAD") && afiliacion.contains("SCI"))
					return "CHINESE ACADEMY OF SCIENCES";
					
			if(afiliacion.contains("CHIN") && afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("ENVIRON") && afiliacion.contains("SCI"))
					return "CHINA INSTITUTE OF ENVIRONMENTAL SCIENCES";
					
			if(afiliacion.contains("CHONGQING") && afiliacion.contains("UNIV"))
					return "CHONGQING UNIVERSITY";
					
			if( afiliacion.contains("CHIN") && (afiliacion.contains("E ") || afiliacion.contains("EAST")) && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "EAST CHINA UNIVERSITY OF SCIENCE AND TECHNOLOGY";
					
			if( afiliacion.contains("CHIN") && (afiliacion.contains("N ")||afiliacion.contains("NORTH")) &&  afiliacion.contains("ELECT") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("UNIV"))
					return "NORTH CHINA ELECTRIC POWER UNIVERSITY";
					
			if( afiliacion.contains("CHIN") && (afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("UNIV") && afiliacion.contains("NORMAL"))
					return "SOUTH CHINA NORMAL UNIVERSITY";
			
			if( afiliacion.contains("CHIN") && (afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("UNIV") )
					return "SOUTH CHINA UNIVERSITY OF TECHNOLOGY";
					
			if( afiliacion.contains("CHIN") && (afiliacion.contains("W ")||afiliacion.contains("WEST")) && afiliacion.contains("UNIV") && afiliacion.contains("TECH") )
					return "WEST CHINA UNIVERSITY OF TECHNOLOGY";
					
			if(afiliacion.contains("CHIN") && afiliacion.contains("SCI") && afiliacion.contains("TECH") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF SCIENCE AND TECHNOLOGY OF CHINA";
					
			if(afiliacion.contains("HARBIN") && afiliacion.contains("INST"))
					return "HARBIN INSTITUTE OF TECHNOLOGY";
					
			if( afiliacion.contains("CENT") && (afiliacion.contains("S ")|| afiliacion.contains("SOUTH")) && afiliacion.contains("UNIV"))
					return "CENTRAL SOUTH UNIVERSITY";
					
			if(afiliacion.contains("DALIAN") && afiliacion.contains("NAT") && afiliacion.contains("LAB") && afiliacion.contains("CLEAN") && afiliacion.contains("ENERGY"))
					return "DALIAN NATIONAL LABORATORY OF CLEAN ENERGY";
					
			if(afiliacion.contains("DALIAN") && afiliacion.contains("UNIV") && afiliacion.contains("TECH"))
					return "DALIAN UNIVERSITY OF TECHNOLOGY";
					
			if(afiliacion.contains("DONGHUA") && afiliacion.contains("UNIV"))
					return "DONGHUA UNIVERSITY";
					
			if( afiliacion.contains("MED") && afiliacion.contains("MIL") && afiliacion.contains("UNIV") && (afiliacion.contains("FOURTH")||afiliacion.contains("4")||afiliacion.contains("THIRD")||afiliacion.contains("3")||afiliacion.contains("SECOND")||afiliacion.contains("2")||afiliacion.contains("FIRST")||afiliacion.contains("1")||afiliacion.contains("SOUTH")) )
					return "FOURTH MILITARY MEDICAL UNIVERSITY";
			
			if(afiliacion.contains("FUDAN") && afiliacion.contains("UNIV"))
					return "FUDAN UNIVERSITY";
					
			if( (afiliacion.contains("HOHAI")||afiliacion.contains("HEHAI")) && afiliacion.contains("UNIV"))
					return "HOHAI UNIVERSITY";
			
			if( (afiliacion.contains("CHANGAN")||afiliacion.contains("CHANG AN")) && afiliacion.contains("UNIV"))
					return "CHANGAN UNIVERSITY";
			
			if(afiliacion.contains("CITY") && afiliacion.contains("UNIV") && afiliacion.contains("HONG") && afiliacion.contains("KONG"))
					return "CITY UNIVERSITY OF HONG KONG";
					
			if(afiliacion.contains("HONG") && afiliacion.contains("KONG") && afiliacion.contains("POLYTECH") && afiliacion.contains("UNIV"))
					return "HONG KONG POLYTECHNIC UNIVERSITY";
					
			if(afiliacion.contains("HONG") && afiliacion.contains("KONG") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "HONG KONG UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if(afiliacion.contains("HONG") && afiliacion.contains("KONG") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF HONG KONG";
					
			if(afiliacion.contains("HUAZHONG") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "HUAZHONG UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			if( afiliacion.compareTo("HUST")==0 )
				return "HUAZHONG UNIVERSITY OF SCIENCE AND TECHNOLOGY";
					
			if(afiliacion.contains("HUNAN") && afiliacion.contains("TECH") && afiliacion.contains("UNIV"))
					return "HUNAN UNIVERSITY OF TECHNOLOGY";
					
			if(afiliacion.contains("HUNAN") && afiliacion.contains("NORMAL") && afiliacion.contains("UNIV"))
					return "HUNAN NORMAL UNIVERSITY";
					
			if(afiliacion.contains("HUNAN") && afiliacion.contains("UNIV"))
					return "HUNAN UNIVERSITY";
					
			if( (afiliacion.contains("NANJING")|| afiliacion.contains("NANKIN")) && afiliacion.contains("UNIV"))
					return "NANJING UNIVERSITY";
					
			if(afiliacion.contains("NANKAI") && afiliacion.contains("UNIV"))
					return "NANKAI UNIVERSITY";
					
			if(afiliacion.contains("NAT") && afiliacion.contains("SUN") && afiliacion.contains("YAT") && afiliacion.contains("SEN") && afiliacion.contains("UNIV"))
				return "NATIONAL SUN YAT SEN UNIVERSITY";
			if(afiliacion.contains("NAT") && afiliacion.contains("ZHONGSHAN") && afiliacion.contains("UNIV"))
				return "NATIONAL SUN YAT SEN UNIVERSITY";
			
			if(afiliacion.contains("SUN") && afiliacion.contains("YAT") && afiliacion.contains("SEN") && afiliacion.contains("UNIV"))
				return "SUN YAT SEN UNIVERSITY";
			if(afiliacion.contains("ZHONGSHAN") && afiliacion.contains("UNIV"))
				return "SUN YAT SEN UNIVERSITY";//// se conoce también como Zhongshan UNIV
				
			if(afiliacion.contains("PEKING") && afiliacion.contains("UNIV"))
					return "PEKING UNIVERSITY";
			if(afiliacion.compareTo("BEIDA")==0)
					return "PEKING UNIVERSITY";
					
			if(afiliacion.contains("SHAANXI") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH") )
					return "SHAANXI UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if(afiliacion.contains("SHAANXI") && afiliacion.contains("UNIV") && afiliacion.contains("NORMAL") )
					return "SHAANXI NORMAL UNIVERSITY";
			
			if( afiliacion.contains("CHINA") && (afiliacion.contains("E ")||afiliacion.contains("EAST")) && afiliacion.contains("UNIV") && afiliacion.contains("NORMAL") )
					return "EAST CHINA NORMAL UNIVERSITY";
			
			if( afiliacion.contains("RAILWAY") && (afiliacion.contains("SOUTHWEST") || afiliacion.contains("SW")) && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "CHINA RAILWAY SOUTHWEST RESEARCH INSTITUTE COMPANY LIMITED";
			
			if( (afiliacion.contains("SOUTHWEST") || afiliacion.contains("SW")) && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "SOUTHWEST RESEARCH INSTITUTE";
			
			if( afiliacion.contains("JIAO") && afiliacion.contains("TONG") && (afiliacion.contains("SOUTHWEST") || afiliacion.contains("SW")) &&  afiliacion.contains("UNIV") )
					return "SOUTHWEST JIAOTONG UNIVERSITY";
			if(afiliacion.contains("SWJTU"))
					return "SOUTHWEST JIAOTONG UNIVERSITY";
			
			if(afiliacion.contains("XIAN") && afiliacion.contains("JIAO") && afiliacion.contains("TONG") && afiliacion.contains("UNIV"))
					return "XIAN JIAOTONG UNIVERSITY";
			if(afiliacion.contains("XJTU"))
					return "XIAN JIAOTONG UNIVERSITY";
			
			if(afiliacion.contains("SHANGHAI") && afiliacion.contains("JIAO") && afiliacion.contains("TONG") && afiliacion.contains("UNIV"))
					return "SHANGHAI JIAOTONG UNIVERSITY";
			if(afiliacion.contains("SJTU"))
					return "SHANGHAI JIAOTONG UNIVERSITY";
			
			if( afiliacion.contains("JIAO") && afiliacion.contains("TONG") &&  afiliacion.contains("UNIV") )
					return "BEIJING JIAOTONG UNIVERSITY";
			if(afiliacion.contains("BJTU"))
					return "BEIJING JIAOTONG UNIVERSITY";
					
			if( afiliacion.contains("TIANJIN") && afiliacion.contains("UNIV") && ( afiliacion.contains("SCI") || afiliacion.contains("TECH") ) )
					return "TIANJIN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if( afiliacion.startsWith("TIANJIN UNIV") )
					return "TIANJIN UNIVERSITY";
					
			if( afiliacion.startsWith("TONGJI UNIV") )
					return "TONGJI UNIVERSITY";
			
			if( (afiliacion.contains("TSING HUA") || afiliacion.contains("TSINGHUA")) && afiliacion.contains("NAT") && afiliacion.contains("UNIV") )
					return "NATIONAL TSINGHUA UNIVERSITY";
			if( (afiliacion.contains("TSING HUA") || afiliacion.contains("TSINGHUA")) && afiliacion.contains("UNIV") )
					return "TSINGHUA UNIVERSITY";
			
			
			if(afiliacion.contains("SHANGHAI") && afiliacion.contains("ENG") && afiliacion.contains("SCI") && afiliacion.contains("UNIV"))
					return "SHANGHAI UNIVERSITY OF ENGINEERING SCIENCE";
			if(afiliacion.contains("SHANGHAI") && afiliacion.contains("UNIV"))
					return "SHANGHAI UNIVERSITY";
			
			if(afiliacion.contains("SICHUAN") && afiliacion.contains("UNIV"))
					return "SICHUAN UNIVERSITY";
			
			if(afiliacion.contains("WUHAN") && afiliacion.contains("UNIV"))
					return "WUHAN UNIVERSITY";
			if(afiliacion.compareTo("WHU")==0)
					return "WUHAN UNIVERSITY";// WHU
					
			if(afiliacion.contains("WUHAN") && afiliacion.contains("UNIV") && afiliacion.contains("TECH"))
					return "WUHAN UNIVERSITY OF TECHNOLOGY";
					
			if(afiliacion.contains("XIAMEN") && afiliacion.contains("UNIV"))
					return "XIAMEN UNIVERSITY";
					
			if(afiliacion.contains("XIAN") && afiliacion.contains("UNIV") && afiliacion.contains("ARCHITECTURE") && afiliacion.contains("TECH"))
					return "XIAN UNIVERSITY OF ARCHITECTURE AND TECHNOLOGY";
					
			if( (afiliacion.contains("XIANGFAN")||afiliacion.contains("XIANGYANG")) && afiliacion.contains("UNIV"))
					return "XIANGFAN UNIVERSITY"; // //Xiangfan || Xiangyang
					
			if((afiliacion.contains("ZHEJIANG")||afiliacion.contains("CHEKIANG")) && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "ZHEJIANG UNIVERSITY OF SCIENCE AND TECHNOLOGY"; 
			if(afiliacion.compareTo("ZUST")==0)
					return "ZHEJIANG UNIVERSITY OF SCIENCE AND TECHNOLOGY"; // (ZHEJIANG ||Chekiang) - ZUST
			
					
			if( (afiliacion.contains("ZHEJIANG")||afiliacion.contains("CHEKIANG")) && afiliacion.contains("UNIV") && afiliacion.contains("TECH"))
					return "ZHEJIANG UNIVERSITY OF TECHNOLOGY"; // Chekiang || ZHEJIANG
					
			if((afiliacion.contains("ZHEJIANG")||afiliacion.contains("CHEKIANG")) && afiliacion.contains("UNIV"))
					return "ZHEJIANG UNIVERSITY"; //  also known as Chekiang University
				
		/* ------------ ESTADOUNIDENSES --------- */
			if( afiliacion.contains("WASHINGTON") && (afiliacion.contains("GROUP")||afiliacion.contains("GRP")) && afiliacion.contains("INT"))
				return "WASHINGTON GROUP INTERNATIONAL";
			
			if(afiliacion.contains("MIL") && afiliacion.contains("ACAD") && (afiliacion.contains("US") || afiliacion.contains("UNITED") || afiliacion.contains("USA") ))
					return "US MILITARY ACADEMY";
			
			if( afiliacion.contains("CORPS ") && afiliacion.contains("ENG") )
					return "CORPS OF ENGINEERS";
			
			if( (afiliacion.contains("US") || afiliacion.contains("UNITED") || afiliacion.contains("USA") ) && afiliacion.contains("DEP") && afiliacion.contains("AGR"))
					return "US DEPARTMENT OF AGRICULTURE";
			
			if(  afiliacion.contains("INTERIOR") && (afiliacion.contains("DEPARTMENT")||afiliacion.contains("DEPT")))
					return "DEPARTMENT OF THE INTERIOR";
			
			if( afiliacion.contains("ENVIRON") && afiliacion.contains("AG") && afiliacion.contains("PROTEC"))
					return "ENVIRONMENTAL PROTECTION AGENCY";
		
			if(afiliacion.contains("SCHNABEL") && afiliacion.contains("ENG") )
				return "SCHNABEL ENGINEERING INCORPORATED";
			
			if(afiliacion.contains("HAY") && afiliacion.contains("WARD") && afiliacion.contains("BAKER"))
					return "HAYWARD BAKER INCORPORATED";
			
			if(afiliacion.contains("LONG") && afiliacion.contains("ISL") && afiliacion.contains("UNIV"))
					return "LONG ISLAND UNIVERSITY";
			
			if(afiliacion.contains("RHODE") && afiliacion.contains("ISL") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF RHODE ISLAND";
			
			if(afiliacion.contains("GEOSYNTEC") && afiliacion.contains("CONSULT"))
					return "GEOSYNTEC CONSULTANTS INCORPORATED";
			
			if(afiliacion.contains("GANNETT") && afiliacion.contains("FLEMING"))
					return "GANNETT FLEMING INCORPORATED";
			
			if(afiliacion.contains("GEI ") && afiliacion.contains("CONSULT"))
					return "GEI CONSULTANTS INCORPORATED";
			
			if(afiliacion.contains("SHANNON") && afiliacion.contains("WILSON"))
					return "SHANNON AND WILSON INCORPORATED";
			
			if(afiliacion.contains("DEERE") && afiliacion.contains("AULT"))
					return "DEERE AND AULT CONSULTANTS";
			
			if(afiliacion.contains("WAVIEN"))
					return "WAVIEN INCORPORATED";
			
			if(afiliacion.contains("BECHTEL"))
					return "BECHTEL CORPORATION";
			
			if(afiliacion.contains("FREIGHT") && afiliacion.contains("PIPELINE"))
					return "FREIGHT PIPELINE COMPANY";
					
			if(afiliacion.contains("EXXONMOBIL") && afiliacion.contains("UPST") && afiliacion.contains("RES"))
					return "EXXONMOBIL UPSTREAM RESEARCH COMPANY";
			
			if(afiliacion.contains("US") && afiliacion.contains("ARMY") && afiliacion.contains("ENG") && afiliacion.contains("RES") && afiliacion.contains("DEV") && (afiliacion.contains("CTR") || afiliacion.contains("CENT")) )
					return "US ARMY ENGINEERING RESEARCH AND DEVELOPMENT CENTER";
			
			if(afiliacion.contains("ENG") && afiliacion.contains("RES") && afiliacion.contains("DEV") && (afiliacion.contains("CTR") || afiliacion.contains("CENT")) )
					return "ENGINEERING RESEARCH AND DEVELOPMENT CENTER";
			if( afiliacion.compareTo("ERDC")==0 )
					return "ENGINEERING RESEARCH AND DEVELOPMENT CENTER";
			
			
			if(afiliacion.contains("AEROTHERMAL") && afiliacion.contains("AERO") && afiliacion.contains("OPTIC") && afiliacion.contains("EVAL"))
					return "AEROTHERMAL AND AERO OPTIC EVALUATION CENTER";
			if( afiliacion.compareTo("AAEC")==0 )
					return "AEROTHERMAL AND AERO OPTIC EVALUATION CENTER";
					
			if(afiliacion.contains("HRL") && afiliacion.contains("LAB"))
					return "HRL LABORATORIES";
			
			if( afiliacion.contains("CUNY") )
					return "CITY UNIVERSITY OF NEW YORK";
					
			if( afiliacion.compareTo("NYU")==0 )
					return "NEW YORK UNIVERSITY";
					
			if( afiliacion.contains("SUNY") )
					return "STATE UNIVERSITY OF NEW YORK";
					
			if(afiliacion.contains("CALIFORNIA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "CALIFORNIA STATE UNIVERSITY";
			if(afiliacion.contains("UNIV") && (afiliacion.contains("SO ")||afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("CALIF"))
					return "UNIVERSITY OF SOUTHERN CALIFORNIA";
			if( afiliacion.contains("CALTECH") )
					return "CALIFORNIA INSTITUTE OF TECHNOLOGY";
			
			if(afiliacion.contains("ARIZONA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "ARIZONA STATE UNIVERSITY";
			if( afiliacion.contains("ARIZONA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ARIZONA";
					
			if(afiliacion.contains("AUBURN") && afiliacion.contains("UNIV"))
					return "AUBURN UNIVERSITY";
			
			if(afiliacion.contains("BAYLOR") && afiliacion.contains("COLL") && afiliacion.contains("MED"))
					return "BAYLOR COLLEGE OF MEDICINE";
					
			if(afiliacion.contains("BIOMASS") && afiliacion.contains("CONVERS") && afiliacion.contains("RES") && afiliacion.contains("LAB"))
					return "BIOMASS CONVERSION RESEARCH LABORATORY";
					
			if(afiliacion.contains("BOSTON") && afiliacion.contains("UNIV"))
					return "BOSTON UNIVERSITY";
					
			if(afiliacion.contains("BROWN") && afiliacion.contains("UNIV"))
					return "BROWN UNIVERSITY";
					
			if(afiliacion.contains("CARNEGIE") && afiliacion.contains("MELLON") && afiliacion.contains("UNIV"))
					return "CARNEGIE MELLON UNIVERSITY";
					
			if(afiliacion.contains("CASE") && afiliacion.contains("WESTERN") && afiliacion.contains("RES") && afiliacion.contains("UNIV"))
					return "CASE WESTERN RESERVE UNIVERSITY";
			
			if(afiliacion.contains("INDIANA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "INDIANA STATE UNIVERSITY";
			if(afiliacion.contains("INDIANA") && afiliacion.contains("UNIV"))
				return "INDIANA UNIVERSITY";
				
			if(afiliacion.contains("COLORADO") && afiliacion.contains("SCH") && afiliacion.contains("MINES"))
				return "COLORADO SCHOOL OF MINES";
			if(afiliacion.contains("COLORADO") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "COLORADO STATE UNIVERSITY";
			if( afiliacion.contains("COLORADO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF COLORADO";
					
			if( afiliacion.contains("COLUMBIA UNIV") )
					return "COLUMBIA UNIVERSITY";
					
			if(afiliacion.contains("CORNELL") && afiliacion.contains("UNIV"))
					return "CORNELL UNIVERSITY";
					
			if(afiliacion.contains("BRIGHAM") && afiliacion.contains("WOMEN") && afiliacion.contains("HOSP"))
					return "BRIGHAM WOMENS HOSPITAL";
					
			if(afiliacion.contains("DARTMOUTH") && afiliacion.contains("COLL"))
					return "DARTMOUTH COLLEGE";
					
			if(afiliacion.contains("DREXEL") && afiliacion.contains("UNIV"))
					return "DREXEL UNIVERSITY";
					
			if(afiliacion.contains("DUKE") && afiliacion.contains("UNIV"))
					return "DUKE UNIVERSITY";
					
			if(afiliacion.contains("EMORY") && afiliacion.contains("UNIV"))
					return "EMORY UNIVERSITY";
					
			if(afiliacion.contains("FLORIDA") && (afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF SOUTH FLORIDA";
			if(afiliacion.contains("FLORIDA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "FLORIDA STATE UNIVERSITY";
			if( afiliacion.contains("FLORIDA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF FLORIDA";
					
			if(afiliacion.contains("GEORGE") && afiliacion.contains("MASON") && afiliacion.contains("UNIV"))
					return "GEORGE MASON UNIVERSITY";
					
			if(afiliacion.contains("GEORGE") && afiliacion.contains("WASHINGTON") && afiliacion.contains("UNIV"))
					return "GEORGE WASHINGTON UNIVERSITY";

			if(afiliacion.contains("WASHINGTON") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "WASHINGTON STATE UNIVERSITY";
					
			if(afiliacion.contains("WASHINGTON") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF WASHINGTON";
					
			if(afiliacion.contains("GEORGIA") && afiliacion.contains("INST") && afiliacion.contains("TECH"))
					return "GEORGIA INSTITUTE OF TECHNOLOGY";
			if(afiliacion.contains("GEORGIA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "GEORGIA STATE UNIVERSITY";
			if( afiliacion.contains("GEORGIA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GEORGIA";
					
			if(afiliacion.contains("HARVARD") && afiliacion.contains("UNIV"))
					return "HARVARD UNIVERSITY";
					
			if(afiliacion.contains("IDAHO") && afiliacion.contains("NAT") && afiliacion.contains("LAB"))
					return "IDAHO NATIONAL LABORATORY";
			if(afiliacion.contains("IDAHO") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "IDAHO STATE UNIVERSITY";
			if(afiliacion.contains("IDAHO") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF IDAHO";
					
			if( afiliacion.compareTo("IIT")==0 )
					return "ILLINOIS INSTITUTE OF TECHNOLOGY";
			if(afiliacion.contains("ILLINOIS") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "ILLINOIS STATE UNIVERSITY";
			if(afiliacion.contains("ILLINOIS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ILLINOIS";
					
			if(afiliacion.contains("INST") && afiliacion.contains("ENERGY") && afiliacion.contains("RES"))
					return "INSTITUTE FOR ENERGY RESEARCH";
					
			if(afiliacion.contains("IOWA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "IOWA STATE UNIVERSITY";
			if(afiliacion.contains("IOWA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF IOWA";
					
			if(afiliacion.contains("JOHNS") && afiliacion.contains("HOPKINS") && afiliacion.contains("UNIV"))
					return "JOHNS HOPKINS UNIVERSITY";
					
			if(afiliacion.contains("JOINT") && afiliacion.contains("BIOENERGY") && afiliacion.contains("INST"))
					return "JOINT BIOENERGY INSTITUTE";
					
			if(afiliacion.contains("KANSAS") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "KANSAS STATE UNIVERSITY";
					
			if(afiliacion.contains("LEHIGH") && afiliacion.contains("UNIV"))
					return "LEHIGH UNIVERSITY";
					
			if(afiliacion.contains("LOS") && afiliacion.contains("ALAMOS") && afiliacion.contains("NAT") && afiliacion.contains("LAB"))
					return "LOS ALAMOS NATIONAL LABORATORY";
					
			if(afiliacion.contains("LOUISIANA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "LOUISIANA STATE UNIVERSITY";
					
			if(afiliacion.contains("MASSACHUSETTS") && afiliacion.contains("GEN") && afiliacion.contains("HOSP"))
					return "MASSACHUSETTS GEN HOSP";
			if( afiliacion.compareTo("MIT")==0 )
					return "MASSACHUSETTS INSTITUTE OF TECHNOLOGY";
			if(afiliacion.contains("MASSACHUSETTS") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "MASSACHUSETTS STATE UNIVERSITY";
			if(afiliacion.contains("MASSACHUSETTS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MASSACHUSETTS";
					
			if(afiliacion.contains("MAYO") && afiliacion.contains("CLIN"))
					return "MAYO CLINIC";
					
			if(afiliacion.contains("MICHIGAN") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "MICHIGAN STATE UNIVERSITY";
					
			if(afiliacion.contains("MICHIGAN") && afiliacion.contains("TECH") && afiliacion.contains("UNIV"))
					return "MICHIGAN TECHNOLOGY UNIVERSITY";
					
			if(afiliacion.contains("MISSISSIPPI") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "MISSISSIPPI STATE UNIVERSITY";
					
			if(afiliacion.contains("MONTANA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "MONTANA STATE UNIVERSITY";
					
			if( (afiliacion.contains("N ")||afiliacion.contains("NORTH")) && afiliacion.contains("CAROLINA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "NORTH CAROLINA STATE UNIVERSITY";
					
			if( afiliacion.contains("NASA") )
					return "NASA";
					
			if(afiliacion.contains("NAT") && afiliacion.contains("INST") && afiliacion.contains("STAND") && afiliacion.contains("TECH"))
					return "NATIONAL INSTITUTE OF STANDARDS AND TECHNOLOGY";
			
			if(afiliacion.contains("NAT") && afiliacion.contains("RENEWABLE") && afiliacion.contains("ENERGY") && afiliacion.contains("LAB"))
					return "NATIONAL RENEWABLE ENERGY LABORATORY";
					
			if( afiliacion.contains("NREL") )
					return "NATIONAL RENEWABLE ENERGY LABORATORY";
			
			if(afiliacion.contains("NAT") && afiliacion.contains("SCI") && (afiliacion.contains("FDN")||afiliacion.contains("FOUND")))
					return "NATIONAL SCIENCE FOUNDATION";
					
			if( afiliacion.compareTo("NSF")==0 )
					return "NATIONAL SCIENCE FOUNDATION";
					
			if(afiliacion.contains("NEW") && afiliacion.contains("JERSEY") && afiliacion.contains("INST") && afiliacion.contains("TECH"))
					return "NEW JERSEY INSTITUTE OF TECHNOLOGY";
					
			if(afiliacion.contains("NORTHEASTERN") && afiliacion.contains("UNIV"))
					return "NORTHEASTERN UNIVERSITY";
					
			if(afiliacion.contains("NORTHWESTERN") && afiliacion.contains("UNIV"))
					return "NORTHWESTERN UNIVERSITY";
					
			if(afiliacion.contains("OAK") && afiliacion.contains("RIDGE") && afiliacion.contains("NAT") && afiliacion.contains("LAB"))
					return "OAK RIDGE NATIONAL LABORATORY";
					
			if(afiliacion.contains("OHIO") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "OHIO STATE UNIVERSITY";
					
			if(afiliacion.contains("OKLAHOMA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "OKLAHOMA STATE UNIVERSITY";
			if( afiliacion.contains("OKLAHOMA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF OKLAHOMA";
					
			if(afiliacion.contains("OLD") && afiliacion.contains("DOMINION") && afiliacion.contains("UNIV"))
					return "OLD DOMINION UNIVERSITY";
					
			if(afiliacion.contains("OREGON") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "OREGON STATE UNIVERSITY";
					
			if(afiliacion.contains("PACIFIC") && (afiliacion.contains("NW")||afiliacion.contains("NORTHW")) && afiliacion.contains("NAT") && afiliacion.contains("LAB"))
					return "PACIFIC NORTHWEST NATIONAL LABORATORY";
					
			if(afiliacion.contains("PENN") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "PENNSYLVANIA STATE UNIVERSITY";
			if( afiliacion.contains("PENN") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PENNSYLVANIA";
			if( afiliacion.contains("UPENN") )
					return "UNIVERSITY OF PENNSYLVANIA";
					
			if(afiliacion.contains("PRINCETON") && afiliacion.contains("UNIV"))
					return "PRINCETON UNIVERSITY";
					
			if(afiliacion.contains("PURDUE") && afiliacion.contains("UNIV"))
					return "PURDUE UNIVERSITY";
					
			if(afiliacion.contains("RENSSELAER") && afiliacion.contains("POL") && afiliacion.contains("INST"))
					return "RENSSELAER POLYTECHNIC INSTITUTE";
			
			if( afiliacion.startsWith("RICE UNIV") )
					return "RICE UNIVERSITY";
			
			if(afiliacion.contains("ROCHESTER") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ROCHESTER";
			
			if(afiliacion.contains("RUTGERS") && afiliacion.contains("UNIV"))
					return "RUTGERS STATE UNIVERSITY";
			
			if( afiliacion.contains("SANDIA") && afiliacion.contains("NAT") && afiliacion.contains("LAB") )
					return "SANDIA NATIONAL LABS";
			
			if( afiliacion.contains("SCRIPPS") && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "SCRIPPS RESEARCH INSTITUTE";
					
			if( afiliacion.contains("STANFORD") )
					return "STANFORD UNIVERSITY";
			
			if( afiliacion.contains("STEVENS") && afiliacion.contains("INST") && afiliacion.contains("TECH") )
					return "STEVENS INSTITUTE OF TECHNOLOGY";
			
			if( afiliacion.startsWith("TEXAS A M UNIV") || afiliacion.startsWith("TEXAS A AND M UNIV") || afiliacion.startsWith("TEXAS AM UNIV") )
					return "TEXAS A AND M UNIVERSITY";
			
			if( afiliacion.contains("TEXAS") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TEXAS TECH UNIVERSITY";
		
			if(afiliacion.contains("TEXAS") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "TEXAS STATE UNIVERSITY";
			if( afiliacion.contains("TEXAS") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF TEXAS";
			
			if( afiliacion.startsWith("TUFTS UNIV") )
					return "TUFTS UNIVERSITY";
			
			if( afiliacion.contains("AKRON") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF AKRON";
		
			if(afiliacion.contains("ALABAMA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "ALABAMA STATE UNIVERSITY";
			if( afiliacion.contains("ALABAMA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ALABAMA";
			
			if(afiliacion.contains("ARKANSAS") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "ARKANSAS STATE UNIVERSITY";
			if( afiliacion.contains("ARKANSAS") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ARKANSAS";			
			
			if( afiliacion.contains("AUCKLAND") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF AUCKLAND";
			
			if(afiliacion.contains("CHICAGO") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "CHICAGO STATE UNIVERSITY";			
			if( afiliacion.contains("CHICAGO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CHICAGO";
			
			if(afiliacion.contains("CINCINNATI") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "CINCINNATI STATE UNIVERSITY";				
			if( afiliacion.contains("CINCINNATI") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CINCINNATI";
			
			if(afiliacion.contains("CONNECTICUT") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "CONNECTICUT STATE UNIVERSITY";		
			if( afiliacion.contains("CONNECTICUT") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CONNECTICUT";
			
			if(afiliacion.contains("DELAWARE") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "DELAWARE STATE UNIVERSITY";
			if( afiliacion.contains("DELAWARE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF DELAWARE";
			
			if(afiliacion.contains("KANSAS") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "KANSAS STATE UNIVERSITY";
			if(afiliacion.contains("KANSAS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF KANSAS";

			if(afiliacion.contains("HOUSTON") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF HOUSTON";
					
			if(afiliacion.contains("HAWAII") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "HAWAII STATE UNIVERSITY";
			if(afiliacion.contains("HAWAII") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF HAWAII";
			
			if(afiliacion.contains("MARYLAND") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MARYLAND";
			
			if(afiliacion.contains("MIAMI") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MIAMI";

			if(afiliacion.contains("MINNESOTA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "MINNESOTA STATE UNIVERSITY";
			if(afiliacion.contains("MINNESOTA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MINNESOTA";

			if(afiliacion.contains("MISSOURI") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "MISSOURI STATE UNIVERSITY";
			if(afiliacion.contains("MISSOURI") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MISSOURI";
			
			if( afiliacion.contains("CAROLINA") && afiliacion.contains("STATE") && (afiliacion.contains("NORTH")||afiliacion.contains("N ")) && afiliacion.contains("UNIV"))
				return "NORTH CAROLINA STATE UNIVERSITY";
			if( afiliacion.contains("CAROLINA") && (afiliacion.contains("NORTH")||afiliacion.contains("N ")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NORTH CAROLINA";
			if( afiliacion.contains("CAROLINA") && (afiliacion.contains("EAST")||afiliacion.contains("E ")) && afiliacion.contains("UNIV"))
					return "EAST CAROLINA UNIVERSITY";
			if( afiliacion.contains("CAROLINA") && (afiliacion.contains("WEST")||afiliacion.contains("W ")) && afiliacion.contains("UNIV"))
					return "WESTERN CAROLINA UNIVERSITY";
			if( afiliacion.contains("CAROLINA") && afiliacion.contains("STATE") && (afiliacion.contains("SOUTH")||afiliacion.contains("S ")) && afiliacion.contains("UNIV"))
					return "SOUTH CAROLINA STATE UNIVERSITY";
			if( afiliacion.contains("CAROLINA") && (afiliacion.contains("SOUTH")||afiliacion.contains("S ")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF SOUTH CAROLINA";

			if( (afiliacion.contains("N ")||afiliacion.contains("NORTH")) && afiliacion.contains("DAKOTA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "NORTH DAKOTA STATE UNIVERSITY";
			if( (afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("DAKOTA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "SOUTH DAKOTA STATE UNIVERSITY";
			if( afiliacion.contains("DAKOTA") && afiliacion.contains("SCH") && afiliacion.contains("MINES") && afiliacion.contains("TECH") && (afiliacion.contains("S ") || afiliacion.contains("SOUTH")) )
					return "SOUTH DAKOTA SCHOOL OF MINES AND TECHNOLOGY";
			if( afiliacion.contains("DAKOTA") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "DAKOTA STATE UNIVERSITY";
			if( afiliacion.contains("DAKOTA") && (afiliacion.contains("NORTH")||afiliacion.contains("N ")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NORTH DAKOTA";
			if( afiliacion.contains("DAKOTA") && (afiliacion.contains("SOUTH")||afiliacion.contains("S ")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF SOUTH DAKOTA";
			
			if( afiliacion.contains("PITTSBURG") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "PITTSBURG STATE UNIVERSITY";
			if( afiliacion.contains("PITTSBURG") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PITTSBURG";
			
			if( afiliacion.contains("NEBRASKA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NEBRASKA";
					
			if( afiliacion.contains("NEVADA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NEVADA";
			if( afiliacion.contains("NEVADA") && afiliacion.contains("STATE") && afiliacion.contains("COLL"))
					return "NEVADA STATE COLLEGE";
			
			if( afiliacion.contains("NEW") && afiliacion.contains("MEXICO") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "NEW MEXICO STATE UNIVERSITY";
			if( afiliacion.contains("NEW") && afiliacion.contains("MEXICO") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NEW MEXICO";
			
			
			if(afiliacion.contains("MAINE") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MAINE";
			
			if( afiliacion.contains("KENTUCKY") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "KENTUCKY STATE UNIVERSITY";
			if(afiliacion.contains("KENTUCKY") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF KENTUCKY";
			
			if( afiliacion.contains("TENNESSEE") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "TENNESSEE STATE UNIVERSITY";
			if( afiliacion.contains("TENNESSEE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF TENNESSEE";
					
			if(afiliacion.contains("UTAH") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "UTAH STATE UNIVERSITY";
			if( afiliacion.contains("UTAH") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF UTAH";
			
			if( afiliacion.contains("VIRGINIA") && (afiliacion.contains("WEST") || afiliacion.contains("W ")) && afiliacion.contains("UNIV") ) 
					return "WEST VIRGINIA UNIVERSITY";
			if( afiliacion.contains("VIRGINIA") && afiliacion.contains("TECH"))
					return "VIRGINIA POLYTECHNIC INSTITUTE AND STATE UNIVERSITY";
			if( afiliacion.contains("VIRGINIA") && afiliacion.contains("COMMONWEALTH") && afiliacion.contains("UNIV") ) 
					return "VIRGINIA COMMONWEALTH UNIVERSITY";
			if( afiliacion.contains("VIRGINIA") && afiliacion.contains("UNIV") ) //HAY WEST VIRGINA
					return "UNIVERSITY OF VIRGINIA";
					
			if( afiliacion.contains("WISCONSIN") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF WISCONSIN";
					
			if(afiliacion.contains("US") && afiliacion.contains("DOE"))
					return "US DEPARTMENT OF ENERGY";
			if(afiliacion.contains("US") && afiliacion.contains("DEP") && afiliacion.contains("ENERGY"))
					return "US DEPARTMENT OF ENERGY";
					
			if(afiliacion.contains("US EPA"))
					return "US ENVIRONMENTAL PROTECTION AGENCY";
			if(afiliacion.contains("US") && afiliacion.contains("ENVIRON") && afiliacion.contains("PROT") && afiliacion.contains("AG"))
					return "US ENVIRONMENTAL PROTECTION AGENCY";
					
			if(afiliacion.contains("US") && afiliacion.contains("FOREST") && afiliacion.contains("SERV"))
					return "US FOREST SERVICE";
					
			if(afiliacion.contains("US") && afiliacion.contains("GEOL") && afiliacion.contains("SURVEY"))
					return "US GEOLOGICAL SURVEY";
					
			if( afiliacion.compareTo("USAF")==0 )
					return "US AIR FORCE";
			
			if( afiliacion.contains("USDA ARS") )
					return "AGRICULTURAL RESEARCH SERVICE";
			if( afiliacion.contains("AGR") && afiliacion.contains("RES") && afiliacion.contains("SERV") )
					return "AGRICULTURAL RESEARCH SERVICE";
			if( afiliacion.compareTo("ARS")==0 )
					return "AGRICULTURAL RESEARCH SERVICE";
			
			if( afiliacion.compareTo("USDA")==0 )
					return "US DEPARTMENT OF AGRICULTURE";
			if(afiliacion.contains("US") && afiliacion.contains("DEP") && afiliacion.contains("AGR"))
					return "US DEPARTMENT OF AGRICULTURE";
					
			if( afiliacion.compareTo("USN")==0 )
					return "US NAVY";
					
			if(afiliacion.contains("VANDERBILT") && afiliacion.contains("UNIV"))
					return "VANDERBILT UNIVERSITY";
					
			if(afiliacion.contains("WAKE") && afiliacion.contains("FOREST") && afiliacion.contains("UNIV"))
					return "WAKE FOREST UNIVERSITY";
					
			if(afiliacion.contains("WAYNE") && afiliacion.contains("STATE") && afiliacion.contains("UNIV"))
					return "WAYNE STATE UNIVERSITY";
					
			if(afiliacion.contains("YALE") && afiliacion.contains("UNIV"))
					return "YALE UNIVERSITY";
			
			if(afiliacion.contains("NEW") && afiliacion.contains("MEXICO") && afiliacion.contains("INST") && afiliacion.contains("MIN") && afiliacion.contains("TECH"))
					return "NEW MEXICO INSTITUTE OF MINING AND TECHNOLOGY";

		
		// UK
			if( afiliacion.contains("LEUVEN") && (afiliacion.contains("KATHOLIEKE")||afiliacion.contains("CATH")) && afiliacion.contains("UNIV") )
					return "CATHOLIC UNIVERSITY OF LEUVEN";
					
			if( afiliacion.contains("SOUTHAMPTON") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SOUTHAMPTON";
					
			if( afiliacion.contains("SHEFFIELD") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SHEFFIELD";
					
			if( afiliacion.contains("STRATHCLYDE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF STRATHCLYDE";
					
			if( afiliacion.contains("SURREY") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SURREY";
					
			if( afiliacion.contains("SUSSEX") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SUSSEX";
					
			if( afiliacion.contains("WARWICK") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF WARWICK";
					
			if(afiliacion.contains("WORCESTER") && afiliacion.contains("POLYTECH") && afiliacion.contains("INST") ) 
					return "WORCESTER POLYTECHNIC INSTITUTE";
			if( afiliacion.contains("WPI") )
					return "WORCESTER POLYTECHNIC INSTITUTE";// Worcester Polytechnic Institute (WPI)
			
			if( afiliacion.contains("PROPEX") && afiliacion.contains("SYSTEM") && afiliacion.contains("CONCRETE") )
					return "PROPEX CONCRETE SYSTEMS CORPORATION";
			

		/* ------------ CANADIENSES --------- */
			if( afiliacion.contains("NEWFOUNDLAND") && afiliacion.contains("MEM") && afiliacion.contains("UNIV") )
					return "MEMORIAL UNIVERSITY OF NEWFOUNDLAND";
			
			if( afiliacion.contains("NAT") && afiliacion.contains("RES") && afiliacion.contains("COUN") && afiliacion.contains("CAN") )
					return "NATIONAL RESEARCH COUNCIL OF CANADA";
			if( afiliacion.compareTo("NRC")==0 )
					return "NATIONAL RESEARCH COUNCIL OF CANADA";
			
			if( afiliacion.contains("ALBERTA") && afiliacion.contains("AGR") && afiliacion.contains("RURAL") && afiliacion.contains("DEV") )
					return "ALBERTA AGRICULTURE AND RURAL DEVELOPMENT";
			
			if( afiliacion.contains("EBA") && afiliacion.contains("ENG") && afiliacion.contains("CONS") )
					return "EBA ENGINEERING CONSULTANTS";
					
			if( afiliacion.contains("ALBERTA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ALBERTA";
			
			if( afiliacion.contains("MONCTON") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF MONCTON";
					
			if(afiliacion.contains("MANITOBA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MANITOBA";
			
			if(afiliacion.contains("CARLETON") && afiliacion.contains("UNIV"))
					return "CARLETON UNIVERSITY";
			
			if( afiliacion.contains("BRITISH") && afiliacion.contains("COLUMBIA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BRITISH COLUMBIA";
			if( afiliacion.contains("UBC") )
					return "UNIVERSITY OF BRITISH COLUMBIA";
			
			if( afiliacion.contains("DALHOUSIE") && afiliacion.contains("UNIV") )
					return "DALHOUSIE UNIVERSITY";
			
			if(afiliacion.contains("GUELPH") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GUELPH";
			
			if(afiliacion.contains("OTTAWA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF OTTAWA";
			
			if(afiliacion.contains("QUEENS") && afiliacion.contains("UNIV"))
					return "QUEENS UNIVERSITY";
					
			if(afiliacion.contains("UNIV") && afiliacion.contains("WATERLOO"))
					return "UNIVERSITY OF WATERLOO";
					
			if(afiliacion.contains("UNIV") && afiliacion.contains("YORK"))
					return "UNIVERSITY OF YORK";
					
			if(afiliacion.contains("MCGILL") && afiliacion.contains("UNIV"))
					return "MCGILL UNIVERSITY";
					
			if(afiliacion.contains("MCMASTER") && afiliacion.contains("UNIV"))
					return "MCMASTER UNIVERSITY";
			
			if(afiliacion.contains("POLYTECH") && afiliacion.contains("MONTREAL"))
					return "ECOLE POLYTECHNIQUE DE MONTREAL";
					
			if(afiliacion.contains("MONTREAL") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MONTREAL";
					
			if(afiliacion.contains("UNIV") && afiliacion.contains("QUEBEC"))
					return "UNIVERSITY OF QUEBEC";
			
			if(afiliacion.contains("HYDRO") && afiliacion.contains("QUEBEC"))
					return "HYDRO QUEBEC RESEARCH INSTITUTE";
			if( afiliacion.compareTo("IREQ")==0 )
					return "HYDRO QUEBEC RESEARCH INSTITUTE";
			
			if( afiliacion.contains("EXPERT") && afiliacion.contains("HYDR") && (afiliacion.contains("CENT")||afiliacion.contains("CTR")) && afiliacion.contains("QUEBEC"))
					return "CENTRE DEXPERTISE HYDRIQUE DU QUEBEC";
			if( afiliacion.compareTo("CEHQ")==0 )
					return "CENTRE DEXPERTISE HYDRIQUE DU QUEBEC";
			
			if(afiliacion.contains("BRUNSWICK") && afiliacion.contains("NEW") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF NEW BRUNSWICK";
				
			if( afiliacion.contains("ONTARIO") && afiliacion.contains("UNIV") && (afiliacion.contains("WEST") || afiliacion.contains("W ")) )
					return "UNIVERSITY OF WESTERN ONTARIO";
			if( afiliacion.contains("ONTARIO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ONTARIO";
					
			if( afiliacion.contains("CALGARY") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CALGARY";
			
			if( afiliacion.contains("REGINA") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF REGINA";
			
			if( afiliacion.contains("SHERBROOKE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SHERBROOKE";
					
			if( afiliacion.contains("SASKATCHEWAN") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SASKATCHEWAN";
					
			if( afiliacion.contains("TORONTO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF TORONTO";
					
			if( (afiliacion.contains(" TRENT")||afiliacion.contains("TRENT ")) && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF TRENT";
	
		// ALEMANAS
			if( afiliacion.contains("RUHRVERBAND") )
					return "RUHR RIVER ASSOCIATION";
			if( afiliacion.contains("RUHR") && afiliacion.contains("RIVER") && afiliacion.contains("ASSOC") )
					return "RUHR RIVER ASSOCIATION";
					
			
			if(afiliacion.contains("KARLSRUHE") && afiliacion.contains("INST") && afiliacion.contains("TECH") )
				return "KARLSRUHE INSTITUTE OF TECHNOLOGY";
				
			if( (afiliacion.contains("RUHR")||afiliacion.contains("BOCHUM")) && afiliacion.contains("UNIV") )
					return "RUHR UNIVERSITY OF BOCHUM";
			
			if( afiliacion.contains("BAUHAUS") && afiliacion.contains("UNIV") )
					return "BAUHAUS UNIVERSITY";
			
			if( afiliacion.contains("GOETHE") && afiliacion.contains("UNIV") )
					return "JOHANN WOLFGANG GOETHE UNIVERSITY";
					
			if( afiliacion.contains("MARA") && (afiliacion.contains("TECH") || afiliacion.contains("TEK")) && afiliacion.contains("UNIV")  )
					return "UNIVERSITY OF TECHNOLOGY MARA";
			
			if(afiliacion.contains("WTM") && afiliacion.contains("ENG") && afiliacion.contains("GMBH") )
				return "WTM ENGINEERS GMBH";
			
			if(afiliacion.contains("WITTKE") && afiliacion.contains("CONSUL") && afiliacion.contains("ENG") && afiliacion.contains("TUNN") && afiliacion.contains("GEOTECH") )
				return "W WITTKE CONSULTING TUNNELING AND GEOTECHNICAL ENGINEERING";
			
			if( afiliacion.contains("AUGSBURG") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF AUGSBURG";
					
			if( afiliacion.contains("STUTTGART") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF STUTTGART";
					
			if( (afiliacion.contains("TUBINGEN")||afiliacion.contains("TUEBINGEN")) && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF TUBINGEN";
					
			if( afiliacion.contains("ZURICH") && afiliacion.contains("HOSP") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ZURICH HOSPITAL";
					
			if( afiliacion.contains("ZURICH") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ZURICH";
					
			if(afiliacion.contains("POTSDAM") && afiliacion.contains("UNIV") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF POTSDAM"; // ale && eng
			
			if(afiliacion.contains("GERMAN") && afiliacion.contains("AERO") && afiliacion.contains("CENT") )
					return "GERMAN AEROSPACE CENTER"; 
			if( afiliacion.compareTo("DLR")==0 )
					return "GERMAN AEROSPACE CENTER"; 
			
			
		
		// Koreanas
			if(afiliacion.contains("DANKOOK") && afiliacion.contains("UNIV"))
					return "DANKOOK UNIVERSITY";
					
			if(afiliacion.contains("DONGGUK") && afiliacion.contains("UNIVERSITY"))
					return "DONGGUK UNIVERSITY";
			
			if(afiliacion.contains("KOREA") && afiliacion.contains("WATER") && afiliacion.contains("RES") && afiliacion.contains("CO") )
					return "KOREA WATER RESOURCES CORPORATION";
			if( afiliacion.compareTo("KOWACO")==0 )
					return "KOREA WATER RESOURCES CORPORATION";
			
			if(afiliacion.contains("KOREA") && afiliacion.contains("WATER") && afiliacion.contains("ENVIRON") && afiliacion.contains("INST") )
					return "KOREA INSTITUTE OF WATER AND ENVIRONMENT";
			
			if(afiliacion.contains("IND") && afiliacion.contains("SCI") && afiliacion.contains("TECH") && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "RESEARCH INSTITUTE OF INDUSTRIAL SCIENCE AND TECHNOLOGY";
			if( afiliacion.compareTo("RIST")==0 )
					return "RESEARCH INSTITUTE OF INDUSTRIAL SCIENCE AND TECHNOLOGY";
			
			if(afiliacion.contains("KOREA") && afiliacion.contains("INF") && afiliacion.contains("SAF") && afiliacion.contains("TECH") )
					return "KOREA INFRASTRUCTURE SAFETY AND TECHNOLOGY CORPORATION";
			if( afiliacion.compareTo("KISTEC")==0 )
					return "KOREA INFRASTRUCTURE SAFETY AND TECHNOLOGY CORPORATION";
			
			if(afiliacion.contains("KOREA") && afiliacion.contains("INST") && afiliacion.contains("CONST") && afiliacion.contains("TECH") )
					return "KOREA INSTITUTE OF CONSTRUCTION TECHNOLOGY";
			if( afiliacion.compareTo("KICT")==0 )
					return "KOREA INSTITUTE OF CONSTRUCTION TECHNOLOGY";
			
			if(afiliacion.contains("KOREA") && afiliacion.contains("INST") && afiliacion.contains("GEOS") && afiliacion.contains("MIN") && afiliacion.contains("RES") )
					return "KOREA INSTITUTE OF GEOSCIENCE AND MINERAL RESOURCES";
			if( afiliacion.compareTo("KIGAM")==0 )
					return "KOREA INSTITUTE OF GEOSCIENCE AND MINERAL RESOURCES";
			
			if(afiliacion.contains("KOREA") && afiliacion.contains("INST") && afiliacion.contains("MAC") && afiliacion.contains("MAT") )
					return "KOREA INSTITUTE OF MACHINERY AND MATERIALS";
					
			if(afiliacion.contains("CHONBUK") && afiliacion.contains("NAT") && afiliacion.contains("UNIV"))
					return "CHONBUK NATIONAL UNIVERSITY";
					
			if(afiliacion.contains("CHONNAM") && afiliacion.contains("NAT") && afiliacion.contains("UNIV"))
					return "CHONNAM NATIONAL UNIVERSITY";
					
			if(afiliacion.contains("CHUNGBUK") && afiliacion.contains("NAT") && afiliacion.contains("UNIV"))
					return "CHUNGBUK NATIONAL UNIVERSITY";
					
			if(afiliacion.contains("GYEONGNAM") && afiliacion.contains("NAT") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "GYEONGNAM NATIONAL UNIVERSITY OF SCIENCE AND TECHNOLOGY";
					
			if(afiliacion.contains("HANYANG") && afiliacion.contains("UNIV"))
					return "HANYANG UNIVERSITY";
			if( afiliacion.compareTo("ERICA")==0 )
					return "HANYANG UNIVERSITY";
					
			if(afiliacion.contains("KOREA") && afiliacion.contains("ADV") && afiliacion.contains("INST") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "KOREA ADVANCED INSTITUTE OF SCIENCE AND TECHNOLOGY";
			if( afiliacion.contains("KAIST") )
					return "KOREA ADVANCED INSTITUTE OF SCIENCE AND TECHNOLOGY";
			if(afiliacion.contains("KOREA") && afiliacion.contains("INST") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "KOREA INSTITUTE OF SCIENCE AND TECHNOLOGY";
			if( afiliacion.contains("KIST") )
					return "KOREA INSTITUTE OF SCIENCE AND TECHNOLOGY";

			if(afiliacion.contains("KOREA") && afiliacion.contains("INST") && afiliacion.contains("ENERGY") && afiliacion.contains("RES"))
				return "KOREA INSTITUTE OF ENERGY RESEARCH";
				
			if(afiliacion.contains("KOREA") && afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("BIOSCI") && afiliacion.contains("BIOTECHNOL"))
					return "KOREA RESEARCH INSTITUTE OF BIOSCIENCE AND BIOTECHNOLOGY";
			
			if(afiliacion.contains("KYUNG") && afiliacion.contains("HEE") && afiliacion.contains("UNIV"))
					return "KYUNG HEE UNIVERSITY";
					
			if(afiliacion.contains("KYUNGPOOK") && afiliacion.contains("NAT") && afiliacion.contains("UNIV"))
					return "KYUNGPOOK NATIONAL UNIVERSITY";
			if( afiliacion.contains("KYUNGDAE") )
					return "KYUNGPOOK NATIONAL UNIVERSITY";
					
			if(afiliacion.contains("POHANG") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH"))
					return "POHANG UNIVERSITY OF SCIENCE AND TECHNOLOGY";
					
			if( (afiliacion.contains("PUSAN")||afiliacion.contains("BUSAN")) && afiliacion.contains("NAT") && afiliacion.contains("UNIV"))
					return "PUSAN NATIONAL UNIVERSITY";
			if( afiliacion.compareTo("PNU")==0 )
					return "PUSAN NATIONAL UNIVERSITY";
					
			if(afiliacion.contains("SEOUL") && afiliacion.contains("NAT") && afiliacion.contains("UNIV"))
					return "SEOUL NATIONAL UNIVERSITY";
					
			if(afiliacion.contains("SUNG") && afiliacion.contains("KYUN") && afiliacion.contains("KWAN") &&afiliacion.contains("UNIV"))
					return "SUNGKYUNKWAN UNIVERSITY";
			if( afiliacion.contains("SKKU") )
					return "SUNGKYUNKWAN UNIVERSITY";
			
			if(afiliacion.contains("KOREA") && afiliacion.contains("UNIV"))
					return "KOREA UNIVERSITY";
			
			if(afiliacion.contains("YONSEI") && afiliacion.contains("UNIV"))
				return "YONSEI UNIVERSITY";
		
		/* --------- INDIAs --------- */
		if(afiliacion.contains("INDIA") && afiliacion.contains("INST") && afiliacion.contains("CHEM") && afiliacion.contains("TECH"))
				return "INDIAN INSTITUTE OF CHEMICAL TECHNOLOGY";
		
		if(afiliacion.contains("INDIA") && afiliacion.contains("INST") && afiliacion.contains("TROP") && afiliacion.contains("METEOR"))
				return "INDIAN INSTITUTE OF TROPICAL METEOROLOGY";
		
		if((afiliacion.contains("CTR")||afiliacion.contains("CEN")) && afiliacion.contains("WATER") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("RES") && afiliacion.contains("ST"))
				return "CENTRAL WATER AND POWER RESEARCH STATION";
		if( afiliacion.contains("CWPRS") )
				return "CENTRAL WATER AND POWER RESEARCH STATION";
			
		
		if(afiliacion.contains("DELHI") && afiliacion.contains("METRO") && afiliacion.contains("RAIL") && afiliacion.contains("CORP"))
				return "DELHI METRO RAIL CORPORATION LIMITED";
				
		if(afiliacion.contains("INDIA") && afiliacion.contains("INST") && afiliacion.contains("PETR"))
				return "INDIAN INSTITUTE OF PETROLEUM";
		
		if(afiliacion.contains("ALLAHABAD") && afiliacion.contains("UNIV"))
				return "ALLAHABAD UNIVERSITY";
				
		if(afiliacion.contains("INDIA") && afiliacion.contains("INST") && afiliacion.contains("SCI"))
				return "INDIAN INSTITUTE OF SCIENCE";
				
		if(afiliacion.contains("INDIA") && afiliacion.contains("INST") && afiliacion.contains("TECH"))
				return "INDIAN INSTITUTE OF TECHNOLOGY";
				
		if(afiliacion.contains("NAT") && afiliacion.contains("ENVIRON") && afiliacion.contains("ENG") && afiliacion.contains("RES") && afiliacion.contains("INST"))
				return "NATIONAL ENVIRONMENTAL ENGINEERING RESEARCH INSTITUTE";
		
		if( afiliacion.contains("MINING") && afiliacion.contains("RES") && afiliacion.contains("INST") && (afiliacion.contains("CTR")||afiliacion.contains("CEN")) )
				return "CENTRAL MINING RESEARCH INSTITUTE";
				
		if( afiliacion.compareTo("NEERI")==0 )
				return "NATIONAL ENVIRONMENTAL ENGINEERING RESEARCH INSTITUTE";
		
		/* ---------- ITALIANAS ------------ */
			if( afiliacion.contains("UDINE") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF UDINE";
			
			if( afiliacion.contains("REGGIO") && afiliacion.contains("CALABRIA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF REGGIO CALABRIA";
			
			if( afiliacion.contains("CALABRIA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF CALABRIA";
			
			if( afiliacion.compareTo("CNR")==0 )
					return "CONSIGLIO NAZIONALE DELLE RICERCHE";
			
			if( afiliacion.contains("BARI") && (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITEC")) && afiliacion.contains("UNIV") )
				return "POLYTECHNICAL UNIVERSITY OF BARI";
			
			if( (afiliacion.contains(" BARI") || afiliacion.contains("BARI ")) && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF BARI";
			
			
			if( afiliacion.contains("BASILICATA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF BASILICATA";
			
			if( (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITEC")) && afiliacion.contains("MILAN") ) // incluye POLITECNICO DI MILANO, etc
				return "POLYTECHNIC INSTITUTE OF MILAN";
			
			if( (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITEC")) && afiliacion.contains("MILAN") ) // incluye POLITECNICO DI MILANO, etc
				return "POLYTECHNIC INSTITUTE OF MILAN";
			
			if(afiliacion.contains("MILAN") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MILAN";//Contiene Milan/Milano
			
			if(afiliacion.contains("BOCCONI") && afiliacion.contains("UNIV"))
					return "BOCCONI UNIVERSITY";//Contiene Milan/Milano
			
			if( afiliacion.contains("POLITECN") && afiliacion.contains("TORINO") ) 
				return "POLYTECHNIC UNIVERSITY OF TURIN";
			
			if( (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITEC")) && afiliacion.contains("TURIN") ) 
				return "POLYTECHNIC UNIVERSITY OF TURIN";
			
			if( (afiliacion.contains("TURIN")||afiliacion.contains("TORINO")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF TURIN";
			if( afiliacion.compareTo("UNITO")==0)
					return "UNIVERSITY OF TURIN"; // Università degli Studi di Torino, UNITO
			
			if( afiliacion.contains("SPERIMENTALE") && afiliacion.contains("CARTA") && afiliacion.contains("CARTONI") && afiliacion.contains("PASTE") && afiliacion.contains("CARTA") )
				return "STAZIONE SPERIMENTALE CARTA, CARTONI E PASTE PER CARTA";
			
			if( afiliacion.contains("BOLOGNA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF BOLOGNA"; // Italiano / Inglés
			
			if( afiliacion.contains("BRESCIA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF BRESCIA"; // Italiano / Inglés
			
			if( afiliacion.contains("CATANIA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF CATANIA"; // Italiano / Inglés
			
			if( afiliacion.contains("FERRARA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF FERRARA"; // Italiano / Inglés
			
			if( afiliacion.contains("CAGLIARI") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF CAGLIARI"; // Italiano / Inglés
			
			if( (afiliacion.contains("FLORENCE")||afiliacion.contains("FIRENZE")) && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF FLORENCE"; //Italiano e Inglés
			
			if( afiliacion.contains("PISA") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF PISA";
		
			if( (afiliacion.contains("PADUA")||afiliacion.contains("PADOVA")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PADUA"; // ITA & ENG
			
			if( (afiliacion.contains("NAPLES")||afiliacion.contains("NAPOLI")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NAPLES FEDERICO II";// ITA & ENG
					
			if(afiliacion.contains("ROM") && afiliacion.contains("SAPIENZA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ROME";
			
			if(afiliacion.contains("ROM") && afiliacion.contains("VERGATA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ROME";
			
			if(afiliacion.contains("ROM") && afiliacion.contains("TRE") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ROME";
			
			if(afiliacion.contains("FORO") && afiliacion.contains("ITALICO") && afiliacion.contains("ROM") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ROME";
			if(afiliacion.contains("SCI") && afiliacion.contains("MOTOR") && afiliacion.contains("INST") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ROME";// Istituto Universitario di Scienze Motorie (Universidad de Roma)
			
			if( afiliacion.contains("SALERNO") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF SALERNO";
					
			if( afiliacion.contains("SIENA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF SIENA";
			
				
		// ESPAÑOL
			if( afiliacion.contains("MARIA") && afiliacion.contains("FEDERICO") && afiliacion.contains("TEC") && afiliacion.contains("UNIV") )
					return "UNIVERSIDAD TECNICA FEDERICO SANTA MARIA";
			
			if( afiliacion.contains("PALMAS") && afiliacion.contains("CANARIAS") && afiliacion.contains("UNIV") )
					return "UNIVERSIDAD DE LAS PALMAS DE GRAN CANARIA";
			if(afiliacion.contains("ULPGC"))
					return "UNIVERSIDAD DE LAS PALMAS DE GRAN CANARIA";
			
			if( afiliacion.contains("ANDES") && afiliacion.contains("LOS") && afiliacion.contains("UNIV") )
					return "UNIVERSIDAD DE LOS ANDES";
			
			if( afiliacion.contains("PONTIF") && afiliacion.contains("UNIV") && afiliacion.contains("CHILE") )
					return "PONTIFICIA UNIVERSIDAD CATOLICA DE CHILE";
			
			if( afiliacion.contains("SIMON") && afiliacion.contains("BOLIVAR") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD SIMON BOLIVAR";
			
			if( afiliacion.contains("ANDRES") && afiliacion.contains("BELLO") && afiliacion.contains("CAT") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD CATOLICA ANDRES BELLO";
			
			if( afiliacion.contains("TUCUMAN") && afiliacion.contains("NA") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD NACIONAL DE TUCUMAN";
			
			if( afiliacion.contains("JUAN") && afiliacion.contains("CARLOS") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD REY JUAN CARLOS";
			
			if( afiliacion.contains("JUAN") && afiliacion.contains("SAN") && (afiliacion.contains("NAC")||afiliacion.contains("NAT")) && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD NACIONAL DE SAN JUAN";
			
			if( afiliacion.contains("NORDESTE") && (afiliacion.contains("NAC")||afiliacion.contains("NAT")) && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD NACIONAL DEL NORDESTE";
				
			if( afiliacion.contains("ARTURO") && afiliacion.contains("PRAT") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD ARTURO PRAT";
			
			if( afiliacion.contains("COMAHUE") && afiliacion.contains("NA") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD NACIONAL DEL COMAHUE";
			
			if( afiliacion.contains("ENDESA") && afiliacion.contains("GENERAC"))
				return "ENDESA GENERACION SA";
			
			if( afiliacion.contains("AMERICAS") && afiliacion.contains("UNIV"))
				return "UNIVERSIDAD DE LAS AMERICAS";
			
			if( afiliacion.contains("ESTUDIOS") && (afiliacion.contains("EXPT")||afiliacion.contains("EXPLOT")) && afiliacion.contains("OBRAS") && afiliacion.contains("PUB") )
					return "CENTRO DE ESTUDIOS Y EXPERIMENTACION DE OBRAS PUBLICAS";
			if(afiliacion.contains("CEDEX"))
					return "CENTRO DE ESTUDIOS Y EXPERIMENTACION DE OBRAS PUBLICAS";
				
			if(afiliacion.contains("CSIC"))
					return "CONSEJO SUPERIOR DE INVESTIGACIONES CIENTIFICAS";
					
			if( afiliacion.compareTo("ENCE")==0 )
					return "EMPRESA NACIONAL DE CELULOSAS DE ESPANA";
					
			if((afiliacion.contains("NAC")||afiliacion.contains("NAT")) && (afiliacion.contains("INVEST")||afiliacion.contains("RES")) && afiliacion.contains("TEC") && afiliacion.contains("AGR") && afiliacion.contains("INST"))
					return "INSTITUTO NACIONAL DE INVESTIGACIÓN Y TECNOLOGÍA AGRARIA Y ALIMENTARIA";
			if( afiliacion.compareTo("INIA")==0 )
					return "INSTITUTO NACIONAL DE INVESTIGACIÓN Y TECNOLOGÍA AGRARIA Y ALIMENTARIA";
					
			if(afiliacion.contains("CELAYA") && afiliacion.contains("INST") && afiliacion.contains("TEC") )
					return "INSTITUTO TECNOLOGICO DE CELAYA";
					
			if( afiliacion.contains("MEXICO") && afiliacion.contains("UNIV") && (afiliacion.contains("NAC")||afiliacion.contains("NAT")) )
					return "UNIVERSIDAD NACIONAL AUTONOMA DE MEXICO";
			if( afiliacion.contains("UNAM") )
					return "UNIVERSIDAD NACIONAL AUTONOMA DE MEXICO";
			
			if( afiliacion.contains("ELECTRICAS") && afiliacion.contains("INST") && afiliacion.contains("IVEST")  )
					return "INSTITUTO DE INVESTIGACIONES ELECTRICAS";
			
			if( afiliacion.contains("MEX") && (afiliacion.contains("AGUA")||afiliacion.contains("WATER")) && afiliacion.contains("INST") && afiliacion.contains("TEC") )
					return "INSTITUTO MEXICANO DE TECNOLOGIA DEL AGUA";
			if( afiliacion.compareTo("IMTA")==0 )
					return "INSTITUTO MEXICANO DE TECNOLOGIA DEL AGUA";
			
			if( afiliacion.contains("MEX") && afiliacion.contains("INST") && afiliacion.contains("PETR") )
					return "INSTITUTO MEXICANO DEL PETROLEO";
			if( afiliacion.compareTo("IMP")==0 )
					return "INSTITUTO MEXICANO DEL PETROLEO";
			
			if( afiliacion.contains("CONAGUA") )
					return "COMISION NACIONAL DEL AGUA";
			
			if( afiliacion.contains("BAJA") && afiliacion.contains("CALIFORNIA") && (afiliacion.contains("SUR")||afiliacion.contains("S ") || afiliacion.contains("SOUTH")) && afiliacion.contains("UNIV") )
					return "UNIVERSIDAD AUTONOMA DE BAJA CALIFORNIA SUR";
					
			if( afiliacion.contains("BAJA") && afiliacion.contains("CALIFORNIA") && afiliacion.contains("UNIV") )
					return "UNIVERSIDAD AUTONOMA DE BAJA CALIFORNIA";
			
			if( afiliacion.contains("CHAPINGO") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD AUTONOMA DE CHAPINGO";
			
			if( afiliacion.contains("METROPOLITAN") && afiliacion.contains("UNIV") && afiliacion.contains("AUTON") )
				return "UNIVERSIDAD AUTONOMA METROPILITANA";
			if( afiliacion.compareTo("UAM")==0 )
					return "UNIVERSIDAD AUTONOMA METROPILITANA";
			
			if( afiliacion.contains("GUANAJUATO") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD DE GUANAJUATO";
			
			if( afiliacion.contains("POTOSI") && afiliacion.contains("LUIS") && afiliacion.contains("UNIV") && afiliacion.contains("AUTON") )
				return "UNIVERSIDAD AUTONOMA DE SAN LUIS POTOSI";
			
			if( afiliacion.contains("ASTRO") && afiliacion.contains("OPTIC") && afiliacion.contains("ELECTRONIC") && afiliacion.contains("NA") && afiliacion.contains("INST"))
					return "INSTITUTO NACIONAL DE ASTROFISICA, OPTICA Y ELECTRONICA";
			if( afiliacion.compareTo("INAOE")==0 )
					return "INSTITUTO NACIONAL DE ASTROFISICA, OPTICA Y ELECTRONICA";
				
			if( afiliacion.contains("NAC") && afiliacion.contains("INST") && (afiliacion.contains("POLITEC")) )
					return "INSTITUTO POLITECNICO NACIONAL";
			if( afiliacion.contains("IPN") )
					return "INSTITUTO POLITECNICO NACIONAL";
			
			if( afiliacion.contains("FED") && afiliacion.contains("COMMIS") && afiliacion.contains("ELECTRICITY"))
					return "COMISION FEDERAL DE ELECTRICIDAD";
			
			
			if( (afiliacion.contains("CATALONIA") || afiliacion.contains("CATALUN") ) && (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITEC")) && afiliacion.contains("UNIV") ) // Cataluña, Catalunya, Catalonia
					return "POLYTECHNIC UNIVERSITY OF CATALONIA";
			if( (afiliacion.contains("CATALONIA") || afiliacion.contains("CATALUN") ) && afiliacion.contains("TEC") && afiliacion.contains("UNIV") ) // Cataluña, Catalunya, Catalonia
					return "TECHNICAL UNIVERSITY OF CATALONIA";
					
			if( afiliacion.contains("CORUNA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF A CORUNA";
				
			if( afiliacion.contains("ALMERIA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ALMERIA";
			
			if(  afiliacion.contains("BARCELONA") && afiliacion.contains("UNIV") && afiliacion.contains("AUTON") )
					return "AUTONOMOUS UNIVERSITY OF BARCELONA";
				
			if( afiliacion.contains("YUCATAN") && afiliacion.contains("UNIV") && afiliacion.contains("AUTON") )
					return "UNIVERSIDAD AUTONOMA DE YUCATAN";
			
			if( afiliacion.contains("BARCELONA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF BARCELONA";// Español, catalán, inglés
			
			if( afiliacion.contains("CADIZ") && afiliacion.contains("UNIV") )
				return "UNIVERSIDAD DE CADIZ";// Español, catalán, inglés
			
			if( afiliacion.contains("CASTIL") && afiliacion.contains("MANCHA") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF CASTILE LA MANCHA";
			if( afiliacion.contains("UCLM") )
				return "UNIVERSITY OF CASTILE LA MANCHA";
			
			if( afiliacion.contains("CORDOBA") && afiliacion.contains("PACCIOLI") && afiliacion.contains("UNIV") )
					return "PACCIOLI DE CORDOBA UNIVERSITY"; // PACCIOLI
			if( afiliacion.contains("CORDOBA") && (afiliacion.contains("NAC")||afiliacion.contains("NAT")) && afiliacion.contains("UNIV") )
					return "NATIONAL UNIVERSITY OF CORDOBA";//aRGENTINA
			if( afiliacion.contains("CORDOBA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CORDOBA";//eSPAÑA O cOLOMBIA

			if( afiliacion.contains("EXTREMADURA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF EXTREMADURA";
			
			if(afiliacion.contains("HUELVA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF HUELVA"; 
			
			if(afiliacion.contains("GRANADA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GRANADA";
			
			if(afiliacion.contains("GIRONA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GIRONA"; 
			
			if( (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITE")) && afiliacion.contains("VALENCIA") && afiliacion.contains("UNIV"))
					return "VALENCIA POLYTECHNIC UNIVERSITY";
			if( afiliacion.contains("VALENCIA") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF VALENCIA"; // También hay  Universidad Politécnica de Valencia (UPV)
					
			if( (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITE")||afiliacion.contains("TECH")) && afiliacion.contains("MADRID") && afiliacion.contains("UNIV"))
					return "MADRID POLYTECHNIC UNIVERSITY";
			
			if( afiliacion.contains("PALERMO") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PALERMO";
			
			if( afiliacion.contains("OVIEDO") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF OVIEDO";
			
			if( afiliacion.contains("COLOMBIA") && (afiliacion.contains("NAC")||afiliacion.contains("NAT")) && afiliacion.contains("UNIV") )
					return "UNIVERSIDAD NACIONAL DE COLOMBIA";
			
			if(afiliacion.contains("MICHOACAN") && afiliacion.contains("UNIV"))
					return "UNIVERSIDAD MICHOACANA DE SAN NICOLAS DE HIDALGO";
			
			if( afiliacion.contains("COMPLUTENSE") && afiliacion.contains("UNIV") )
					return "COMPLUTENSE UNIVERSITY OF MADRID";
		
			if( afiliacion.contains("CONCEPCION") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CONCEPCION";
			
			if( (afiliacion.contains("BASQUE")||afiliacion.contains("VASCO")) && (afiliacion.contains("COUNTRY")||afiliacion.contains("PAIS")) && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BASQUE COUNTRY";
			
			if(afiliacion.contains("ROVIRA") && afiliacion.contains("VIRGILI") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF ROVIRA VIRGILI";
			
			if( afiliacion.contains("SANTIAGO") && afiliacion.contains("COMPOSTELA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SANTIAGO DE COMPOSTELA";
					
			if( afiliacion.contains("SEVILL") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF SEVILLE";
					
			if( afiliacion.contains("VALLADOLID") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF VALLADOLID";
					
			if( afiliacion.contains("VIGO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF VIGO";
			
			if( afiliacion.contains("ZARAGOZA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ZARAGOZA";
			
		// FrancESAS
			if( afiliacion.contains("PONTS") && afiliacion.contains("CHAUSSEES") && (afiliacion.contains("CENT")||afiliacion.contains("REG")) && afiliacion.contains("LAB") )
					return "CENTRAL ROADS AND BRIDGES LABORATORY";
			if( afiliacion.contains("ROADS") && afiliacion.contains("BRIDGES") && (afiliacion.contains("CENT")||afiliacion.contains("CTRL")||afiliacion.contains("REG")) && afiliacion.contains("LAB") )
					return "CENTRAL ROADS AND BRIDGES LABORATORY";
			
			
			if( (afiliacion.contains("BRETAGNE")||afiliacion.contains("BRITTANY")) && afiliacion.contains("EUROP") && afiliacion.contains("UNIV") )
					return "EUROPEAN UNIVERSITY OF BRITTAN";
			
			if( (afiliacion.contains("BRETAGNE")||afiliacion.contains("BRITTANY")) && (afiliacion.contains("W")||afiliacion.contains("OCCIDEN")) && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF WESTERN BRITTANY";
			
			// todas forman parte de la  UNIV. DE BORDEAUX:
			if( afiliacion.contains("BORDEAUX") && (afiliacion.contains("ECOLE")||afiliacion.contains("SCH") ) && afiliacion.contains("CHEM") && afiliacion.contains("PHYS") )
					return "BORDEAUX UNIVERSITY";
			if( afiliacion.contains("BORDEAUX") && (afiliacion.contains("ECOLE")||afiliacion.contains("SCH") ) && afiliacion.contains("NAT") && afiliacion.contains("AGR") )
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("ENSCPB") )
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("ENITAB") )
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("ENSEIRB") && afiliacion.contains("MATMECA") )
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("BORDEAUX") && afiliacion.contains("UNIV"))
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("BORDEAUX") && afiliacion.contains("POLY") && afiliacion.contains("INST"))
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("VICTOR") && afiliacion.contains("SEGALEN") && afiliacion.contains("UNIV"))
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("MICHEL") && afiliacion.contains("MONTAIGNE") && afiliacion.contains("UNIV"))
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("MONTESQUIEU") && afiliacion.contains("UNIV"))
					return "BORDEAUX UNIVERSITY"; 
			if( afiliacion.contains("BORDEAUX") && afiliacion.contains("SCI") && afiliacion.contains("PO"))
					return "BORDEAUX UNIVERSITY"; 
			
			if( (afiliacion.contains("CENTRE")||afiliacion.contains("CENTER") ||afiliacion.contains("CTR") ) && (afiliacion.contains("STUD")||afiliacion.contains("ETUDE")) && afiliacion.contains("TUNN"))
					return "CENTER OF STUDIES ON TUNNELS"; //FR & ENG
			
			if( afiliacion.contains("LORRAINE") && afiliacion.contains("INST") && afiliacion.contains("POL"))
					return "NATIONAL POLYTECHNIC INSTITUTE OF LORRAINE"; //FR & ENG
			
			if( afiliacion.contains("ELECTRICITE") && afiliacion.contains("FRANCE"))
					return "ELECTRICITE DE FRANCE";
			
			if( afiliacion.contains("PARIS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PARIS";
			
			if( afiliacion.contains("POITIERS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF POITIERS";
			
			if( afiliacion.contains("DORLEANS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ORLEANS";
			
			if(afiliacion.contains("LYON") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LYON";
			
			if(afiliacion.contains("LIEGE") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LIEGE"; //FR & ENG
			
			if(afiliacion.contains("NANTES") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NANTES"; //FR & ENG
			
			if(afiliacion.contains("LAVAL") && afiliacion.contains("UNIV"))
					return "LAVAL UNIVERSITY"; //Fr & ENG
			
			if(afiliacion.contains("ANNABA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF ANNABA"; //Fr & ENG
			
			if( (afiliacion.contains("GENEVA") || afiliacion.contains("GENEVE")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GENEVA"; //FR & ENG
			
			if( (afiliacion.contains("LOUVAIN") || afiliacion.contains("LEUVEN")) && afiliacion.contains("UNIV"))
					return "CATHOLIC UNIVERSITY OF LEUVEN"; //FR & ENG		
			
			if( afiliacion.contains("MARNE") && afiliacion.contains("VALLEE") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MARNE LA VALLEE"; //FR & ENG
			
			if( afiliacion.contains("REIMS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF REIMS";
			
			if(afiliacion.contains("TOULOUSE") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF TOULOUSE";
			
			if(afiliacion.contains(" ROUEN") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF ROUEN";
			
			if(afiliacion.contains("LILLE") && afiliacion.contains("CAT") && afiliacion.contains("UNIV"))
				return "LILLE CATHOLIC UNIVERSITY";
			if(afiliacion.contains(" LILLE") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF LILLE";
			
			if(afiliacion.contains("GRENOBLE") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF GRENOBLE";
			
			if(afiliacion.contains("URGC") && afiliacion.contains("GEOTECH") )
				return "URGC GEOTECHNIQUE";
			
			if(afiliacion.contains("ECOLE") && (afiliacion.contains("CENT")||afiliacion.contains("CTRL")) && afiliacion.contains("PARIS") )
				return "ECOLE CENTRALE PARIS";
			
			if(afiliacion.contains("ECOLE") && (afiliacion.contains("CENT")||afiliacion.contains("CTRL")) && afiliacion.contains("NANTES") )
				return "ECOLE CENTRALE NANTES";
			
			if(afiliacion.contains("GUMUS") && afiliacion.contains("HANE") && afiliacion.contains("UNIV") )
				return "GUMUSHANE UNIVERSITY";
			
			
			

		// Brasileñas
			if( afiliacion.contains("NAT") && afiliacion.contains("ELECTRIC") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("AG") )
					return "NATIONAL ELECTRIC ENERGY AGENCY";
			if( afiliacion.compareTo("ANEEL")==0 )
					return "NATIONAL ELECTRIC ENERGY AGENCY";
			
			if( afiliacion.contains("STA") && afiliacion.contains("CAMPINAS") && afiliacion.contains("UNIV") )
					return "STATE UNIVERSITY OF CAMPINAS";
			if( afiliacion.contains("UNICAMP") )
					return "STATE UNIVERSITY OF CAMPINAS";
			
			if( afiliacion.contains("STA") && afiliacion.contains("PAULISTA") && afiliacion.contains("UNIV") )
					return "ESTADUAL PAULISTA UNIVERSITY";
			if( afiliacion.compareTo("UNESP")==0 )
					return "ESTADUAL PAULISTA UNIVERSITY";
			
			if( afiliacion.contains("FURNAS") && afiliacion.contains("CENT") && (afiliacion.contains("ELETRIC")||afiliacion.contains("ELECT")) )
					return "FURNAS CENTRAIS ELETRICAS SA";
			
			if( afiliacion.contains("PARANA") && afiliacion.contains("FED") && afiliacion.contains("UNIV") )
					return "FEDERAL UNIVERSITY OF PARANA";
			
			if( afiliacion.contains("ESPIRITO") && afiliacion.contains("SANTO") && afiliacion.contains("FED") && afiliacion.contains("UNIV") )
					return "FEDERAL UNIVERSITY OF ESPIRITO SANTO";
			
			if( afiliacion.contains("MATO") && afiliacion.contains("GROSSO") && afiliacion.contains("FED") && afiliacion.contains("UNIV") )
					return "FEDERAL UNIVERSITY OF MATO GROSSO";
			
			if( afiliacion.contains("ELETRONORTE") && afiliacion.contains("CENT") && (afiliacion.contains("ELETRIC")||afiliacion.contains("ELECT")) )
					return "ELETRONORTE CENTRAIS ELETRICAS SA";
			
			if( afiliacion.contains("MINAS") && afiliacion.contains("GERAIS") && afiliacion.contains("UNIV") && afiliacion.contains("FED") )
					return "FEDERAL UNIVERSITY OF MINAS GERAIS"; 
			if( afiliacion.contains("UFMG") )
					return "FEDERAL UNIVERSITY OF MINAS GERAIS"; 
			
			if( afiliacion.contains("RIO") && afiliacion.contains("JANEIRO") && afiliacion.contains("UNIV") && afiliacion.contains("FED") )
					return "FEDERAL UNIVERSITY OF RIO DE JANEIRO"; 
			if( afiliacion.contains("UFRJ") )
					return "FEDERAL UNIVERSITY OF RIO DE JANEIRO"; 
			
			if( afiliacion.contains("RIO") && afiliacion.contains("GRANDE") && afiliacion.contains("SUL") && afiliacion.contains("UNIV") && afiliacion.contains("FED") ) 
					return "FEDERAL UNIVERSITY OF RIO GRANDE DO SUL";
			if( afiliacion.contains("UFRGS") )
					return "FEDERAL UNIVERSITY OF RIO GRANDE DO SUL"; 

			if( afiliacion.contains("SANTA") && afiliacion.contains("CATARINA") && afiliacion.contains("UNIV") && afiliacion.contains("FED") )
					return "FEDERAL UNIVERSITY OF SANTA CATARINA"; 
			if( afiliacion.contains("UFSC") )
					return "FEDERAL UNIVERSITY OF SANTA CATARINA"; 

			if( afiliacion.contains("SAO") && afiliacion.contains("CARLOS") && afiliacion.contains("UNIV") && afiliacion.contains("FED"))
					return "FEDERAL UNIVERSITY OF SAO CARLOS"; 
			if( afiliacion.contains("UFSCAR") )
					return "FEDERAL UNIVERSITY OF SAO CARLOS"; 

			if( afiliacion.contains("VICOSA") && afiliacion.contains("UNIV") && afiliacion.contains("FED"))
					return "FEDERAL UNIVERSITY OF VICOSA";
			if( afiliacion.compareTo("UFV")==0 )
					return "FEDERAL UNIVERSITY OF VICOSA";
			
			if( afiliacion.contains("SAO") && afiliacion.contains("PAULO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SAO PAULO";
					
			if(afiliacion.contains("PORTO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF PORTO"; 
			
			if( afiliacion.contains("RIBEIRAO") && afiliacion.contains("UNIV") && afiliacion.contains("PRETO"))
					return "UNIVERSITY OF RIBEIRAO PRETO";
			if( afiliacion.contains("UNAERP") )
					return "UNIVERSITY OF RIBEIRAO PRETO";
		
		//Australianas
			if(afiliacion.contains("AUSTRALIA") && (afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SOUTH AUSTRALIA";
			
			if( afiliacion.contains("AUSTRALIA") && (afiliacion.contains("W ")||afiliacion.contains("WEST")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF WESTERN AUSTRALIA";
					
			if(afiliacion.contains("AUSTRALIA") && afiliacion.contains("CATH") && afiliacion.contains("UNIV"))
					return "AUSTRALIAN CATHOLIC UNIVERSITY";
			
			if(afiliacion.contains("AUSTRALIA") && afiliacion.contains("NAT") && afiliacion.contains("UNIV"))
					return "AUSTRALIAN NATIONAL UNIVERSITY";
			
			if( afiliacion.contains("ADELAIDE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ADELAIDE";
			
			if( afiliacion.contains("QUEENSLAND") && afiliacion.contains("UNIV") && afiliacion.contains("TECHNOL") )
					return "QUEENSLAND UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("QUEENSLAND") && afiliacion.contains("UNIV") && afiliacion.contains("CENT") )
					return "CENTRAL QUEENSLAND UNIVERSITY";
			
			if( afiliacion.contains("QUEENSLAND") && afiliacion.contains("UNIV") && (afiliacion.contains("SO ")||afiliacion.contains("S ")||afiliacion.contains("SOUTH")) )
					return "SOUTHERN QUEENSLAND UNIVERSITY";
					
			if( afiliacion.contains("QUEENSLAND") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF QUEENSLAND";
			
			if(afiliacion.contains("MELBOURNE") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MELBOURNE";
			
			if(afiliacion.contains("MURDOCH") && afiliacion.contains("UNIV"))
					return "MURDOCH UNIVERSITY";
			
			if( afiliacion.contains("NOTRE") && afiliacion.contains("DAME") && afiliacion.contains("UNIV"))
						return "UNIVERSITY OF NOTRE DAME";
			
			//Newcastle University es de UK
			if( afiliacion.contains("NEWCASTLE UNIV"))
					return "NEWCASTLE UNIVERSITY"; //Reino Unido
					
			if( afiliacion.contains("NEWCASTLE") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NEWCASTLE"; //Australiana
			
			if( afiliacion.contains("NEW") && (afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("WALES") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NEW SOUTH WALES";
			
			if(afiliacion.contains("TECH") && afiliacion.contains("SYDNEY") && afiliacion.contains("UNIV"))
					return "SYDNEY UNIVERSITY OF TECHNOLOGY";
					
			if( afiliacion.contains("SYDNEY") && (afiliacion.contains("WEST")||afiliacion.contains("W ")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF WESTERN SYDNEY";
					
			if(afiliacion.contains("UNIV") && afiliacion.contains("SYDNEY"))
					return "UNIVERSITY OF SYDNEY";
			
			if(afiliacion.contains("WOLLONGONG") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF WOLLONGONG";
		
		// JAPONESAS
			if( afiliacion.contains("PUBLIC") && (afiliacion.contains("WORKS")||afiliacion.contains("WRK")) && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "PUBLIC WORKS RESEARCH INSTITUTE";
			if( afiliacion.compareTo("PWRI")==0 )
					return "PUBLIC WORKS RESEARCH INSTITUTE";
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && afiliacion.contains("WATER") && (afiliacion.contains("AGENCY")||afiliacion.contains("AGCY")) )
					return "JAPAN WATER AGENCY";
			if( afiliacion.compareTo("JWA")==0 )
					return "JAPAN WATER AGENCY";
			
			if( afiliacion.contains("TOKYO") && afiliacion.contains("ELECT") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("CO") )
					return "TOKYO ELECTRIC POWER COMPANY";
			
			if( afiliacion.contains("INFO") && afiliacion.contains("TECH") && afiliacion.contains("D") && (afiliacion.contains("CTR") ||afiliacion.contains("CENT"))  )
					return "MITSUBISHI ELECTRIC CORPORATION"; // Information Technology R&D Center - Mitsubishi Electric
			if( afiliacion.contains("MITSUBISHI") && afiliacion.contains("EL") )
					return "MITSUBISHI ELECTRIC CORPORATION";
			
			if( afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("ELEC") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("IND") )
					return "CENTRAL RESEARCH INSTITUTE OF ELECTRIC POWER INDUSTRY";
			
			
			if( afiliacion.contains("RAILWAY") && afiliacion.contains("TECH") && (afiliacion.contains("RES")||afiliacion.contains("INST")) )
					return "RAILWAY TECHNICAL RESEARCH INSTITUTE";
		
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && (afiliacion.contains("W ")||afiliacion.contains("WEST")) && afiliacion.contains("EXPRESS") )
					return "WEST JAPAN EXPRESSWAY COMPANY";
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && (afiliacion.contains("E ")||afiliacion.contains("EAST")) && afiliacion.contains("EXPRESS") )
					return "EAST JAPAN EXPRESSWAY  COMPANY";
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && afiliacion.contains("CENT") && afiliacion.contains("EXPRESS") )
					return "CENTRAL JAPAN EXPRESSWAY  COMPANY";
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && afiliacion.contains("EXPRESSWAY") && afiliacion.contains("RES") )
					return "JAPAN EXPRESSWAY RESEARCH INSTITUTE COMPANY LIMITED";	
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && (afiliacion.contains("E ")||afiliacion.contains("EAST")) && afiliacion.contains("RAIL") )
					return "EAST JAPAN RAILWAY COMPANY";
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && (afiliacion.contains("W ")||afiliacion.contains("WEST")) && afiliacion.contains("RAIL") )
					return "WEST JAPAN RAILWAY COMPANY";
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && afiliacion.contains("CENT") && afiliacion.contains("RAIL") )
					return "CENTRAL JAPAN RAILWAY COMPANY";
			
			if( (afiliacion.contains("JAPAN")||afiliacion.contains("NIPPON")) && afiliacion.contains("CONST") && afiliacion.contains("RAIL") )
					return "JAPAN RAILWAY CONSTRUCTION PUBLIC CORPORATION";
			
			if( afiliacion.contains("KAKUDA") && afiliacion.contains("CENT"))
					return "KAKUDA SPACE CENTER";
			
			if( afiliacion.contains("INORGANIC") && afiliacion.contains("MAT") && afiliacion.contains("RES") )
					return "INORGANIC MATERIAL RESEARCH CENTER";
			
			if(afiliacion.contains("KAJIMA") && afiliacion.contains("CORP"))
					return "KAJIMA CORPORATION";
				
			if(afiliacion.contains("KEISOKU") && afiliacion.contains("RESEARCH") && afiliacion.contains("CO"))
				return "KEISOKU RESEARCH CONSULTANT COMPANY";
					
			if(afiliacion.contains("TSUKUBA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF TSUKUBA";
			
			if( afiliacion.contains("TOKYO") && afiliacion.contains("INST") && afiliacion.contains("TECH") )
					return "TOKYO INSTITUTE OF TECHNOLOGY";

			if(afiliacion.contains("TOKYO") && afiliacion.contains("UNIV") && afiliacion.contains("AGR") && afiliacion.contains("TECH"))
					return "TOKYO UNIVERSITY OF AGRICULTURE AND TECHNOLOGY";

			if( afiliacion.contains("TOKYO") && afiliacion.contains("WOMEN") && afiliacion.contains("MED") && afiliacion.contains("UNIV") )
					return "TOKYO WOMENS MEDICAL UNIVERSITY";
					
			if(afiliacion.contains("TOKYO") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF TOKYO";
					
			if(afiliacion.contains("WASEDA") && afiliacion.contains("UNIV"))
					return "WASEDA UNIVERSITY";
			
			if(afiliacion.contains("CHUO ") && afiliacion.contains("UNIV"))
					return "CHUO UNIVERSITY";
			
			if( afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("ELEC") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("INDUST") )
					return "CENTRAL RESEARCH INSTITUTE OF ELECTRIC POWER INDUSTRY";
			if( afiliacion.compareTo("CTRL")==0 )
					return "CENTRAL RESEARCH INSTITUTE OF ELECTRIC POWER INDUSTRY";
			
			if( afiliacion.contains("NTT") && afiliacion.contains("NET") && afiliacion.contains("ACCESS") && afiliacion.contains("SERV") && afiliacion.contains("SYST") )
					return "NTT ACCESS NETWORK SERVICE SYSTEMS LABORATORIES";
			
		//INTERNACIONALES
			if( afiliacion.contains("PARSONS") && (afiliacion.contains("BRINCKERHOFF")||afiliacion.contains("BQ")) )
					return "PARSONS BRINCKERHOFF QUADE AND DOUGLAS INCORPORATED";
			
			if( afiliacion.contains("PAUL") && afiliacion.contains("RIZZO") && afiliacion.contains("ASSOC") )
					return "PAUL C RIZZO ASSOCIATES INCORPORATED";
			
			if( afiliacion.contains("POYRY") && afiliacion.contains("ENERGY") )
					return "POYRY ENERGY LIMITED";
			
			if( afiliacion.contains("AECOM") )
					return "AECOM TECHNOLOGY CORPORATION";
			
			if( afiliacion.contains("GOLDER") && afiliacion.contains("ASSOC") )
					return "GOLDER ASSOCIATES INCORPORATED";

		
		// OTRAS
			if( afiliacion.contains("INDIES") && (afiliacion.contains("W ")||afiliacion.contains("WEST")) && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF THE WEST INDIES";
			
			if( afiliacion.contains("BARREIRO") && afiliacion.contains("SCH") && afiliacion.contains("TECH") )
					return "BARREIRO SCHOOL OF TECHNOLOGY";
			
			if( afiliacion.contains("AMER") && afiliacion.contains("UNIV") && afiliacion.contains("SHARJAH") )
					return "AMERICAN UNIVERSITY OF SHARJAH";
			
			
			if( afiliacion.contains("SOIL") && afiliacion.contains("CONSERVATION") && afiliacion.contains("WATERSHED") && afiliacion.contains("MANAGEMENT") && afiliacion.contains("RES") )
					return "SOIL CONSERVATION AND WATERSHED MANAGEMENT RESEARCH CENTER";
			if( afiliacion.contains("SCWMRC") )
					return "SOIL CONSERVATION AND WATERSHED MANAGEMENT RESEARCH CENTER";
			
			
			if( afiliacion.contains("ROMANIAN") && afiliacion.contains("ACAD") )
					return "ROMANIAN ACADEMY";
			if( afiliacion.contains("ROMANA") && afiliacion.contains("ACAD") )
					return "ROMANIAN ACADEMY";
			
			if( afiliacion.contains("YEREVAN") && afiliacion.contains("STATE") && afiliacion.contains("UNIV") )
					return "YEREVAN STATE UNIVERSITY";
			
			if( (afiliacion.contains("METHODIUS")||afiliacion.contains("METHUDIUS")) && afiliacion.contains("CYRIL") && afiliacion.contains("UNIV") )
					return "ST CYRIL AND ST METHODIUS UNIVERSITY";
			if( afiliacion.contains("SKOPJE") )
					return "ST CYRIL AND ST METHODIUS UNIVERSITY";
			
			if( afiliacion.contains("CRNE") && afiliacion.contains("GORE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF MONTENEGRO";//University of Montenegro - Univerzitet Crne Gore
			
			if( afiliacion.contains("FERDOWSI") && afiliacion.contains("UNIV") )
				return "FERDOWSI UNIVERSITY OF MASHHAD";
			
			if( afiliacion.contains("CUKUROVA") && afiliacion.contains("UNIV") )
				return "CUKUROVA UNIVERSITY";
			
			if( afiliacion.contains("BASEL") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF BASEL";
			
			if( (afiliacion.contains("TELEDJI")||afiliacion.contains("TELIDJI")) && afiliacion.contains("AMAR") && afiliacion.contains("UNIV") )
				return "AMAR TELIDJI UNIVERSITY";
			
			if(afiliacion.contains("KHIDER") && afiliacion.contains("MOHAMED") && afiliacion.contains("UNIV") )
				return "MOHAMED KHIDER UNIVERSITY";
			
			if(afiliacion.contains("ANKARA") && afiliacion.contains("UNIV") )
				return "ANKARA UNIVERSITY";
			
			if(afiliacion.contains("AEGEAN") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF THE AEGEAN";
			
			if(afiliacion.contains("ABERDEEN") && afiliacion.contains("UNIV") )
				return "UNIVERSITY OF ABERDEEN";
			
			if(afiliacion.contains("DUBLIN") && afiliacion.contains("COLL") && afiliacion.contains("UNIV") )
				return "UNIVERSITY COLLEGE DUBLIN";
			
			if( afiliacion.contains("BOZOK") && afiliacion.contains("UNIV") )
					return "BOZOK UNIVERSITY";
			
			if( afiliacion.contains("VRIJE") && afiliacion.contains("UNIV") )
					return "VRIJE UNIVERSITY";
			
			if( afiliacion.contains("YUZUNCU") && afiliacion.contains("UNIV") )
					return "YUZUNCU YIL UNIVERSITY";
			
			if( afiliacion.contains("NOUAKCHOTT") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF NOUAKCHOTT";
			
			if( afiliacion.contains("BOZOK") && afiliacion.contains("UNIV") )
					return "BOZOK UNIVERSITY";
			
			if( afiliacion.contains("SAKARYA") && afiliacion.contains("UNIV") )
					return "SAKARYA UNIVERSITY";
			
			if( afiliacion.contains("BELKAID") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ABOU BAKR BELKAID";
			
			if( afiliacion.contains("BEJAIA") && afiliacion.contains("UNIV") )
					return "BEJAIA UNIVERSITY";
			
			if( afiliacion.contains("TETRA") && afiliacion.contains("TECHNICAL") )
					return "TETRA TECHNICAL INCORPORATED";
			if( afiliacion.contains("TETRA TECH") )
					return "TETRA TECHNICAL INCORPORATED";
			
			if( afiliacion.contains("CLUJ") && afiliacion.contains("NAPOCA") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF CLUJ NAPOCA";
			
			if( afiliacion.contains("ORAN")  && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF SCIENCE AND TECHNOLOGY OF ORAN";
			
			if( afiliacion.contains("CLAUSTHAL")  && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "CLAUSTHAL UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.startsWith("DELFT") || (afiliacion.contains("DELFT")  && afiliacion.contains("TECH") && afiliacion.contains("UNIV")) )
					return "DELFT UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("TARBIAT") && (afiliacion.contains("MODARES") || afiliacion.contains("MODARRES")) && afiliacion.contains("UNIV") )
					return "TARBIAT MODARES UNIVERSITY";
			
			if( afiliacion.contains("LAUSANNE") && (afiliacion.contains("TECH") || afiliacion.contains("POLY")) )
					return "FEDERAL POLYTECHNIC SCHOOL OF LAUSANNE";
			if( afiliacion.contains("SWISS") && afiliacion.contains("FED") && afiliacion.contains("INST") && afiliacion.contains("TECH") )
					return "FEDERAL POLYTECHNIC SCHOOL OF LAUSANNE";
			if( afiliacion.compareTo("EPFL")==0 )
					return "FEDERAL POLYTECHNIC SCHOOL OF LAUSANNE";
			
			if( afiliacion.contains("STUCKY") )
					return "STUCKY CONSULTING ENGINEERS LIMITED";
			
			if( afiliacion.contains("SOKOINE") && afiliacion.contains("UNIV") )
					return "SOKOINE UNIVERSITY OF AGRICULTURE";
			
			if( afiliacion.contains("PAYAM") && afiliacion.contains("NOOR") && afiliacion.contains("UNIV") )
					return "PAYAME NOOR UNIVERSITY";
			
			if( afiliacion.contains("SHIRAZ") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "SHIRAZ UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.compareTo("SUTECH")==0 )
					return "SHIRAZ UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("SHIRAZ") && afiliacion.contains("MED") && afiliacion.contains("UNIV") )
					return "SHIRAZ UNIVERSITY OF MEDICAL SCIENCES";
			
			if( afiliacion.contains("SHIRAZ") && afiliacion.contains("UNIV") )
					return "SHIRAZ UNIVERSITY";
			if( afiliacion.contains("PAHLAVI") && afiliacion.contains("UNIV") )
					return "SHIRAZ UNIVERSITY";
				
			
			if( afiliacion.contains("SHARIF") && afiliacion.contains("UNIV") )
					return "SHARIF UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("SHAHID") && afiliacion.contains("BAHONAR") && afiliacion.contains("UNIV") )
					return "SHAHID BAHONAR UNIVERSITY";
			if( afiliacion.contains("SHAHID") && afiliacion.contains("BEHESHTI") && afiliacion.contains("UNIV") )
					return "SHAHID BEHESHTI UNIVERSITY";
			if( afiliacion.contains("SHAHID") && afiliacion.contains("CHAMRAN") && afiliacion.contains("UNIV") )
					return "SHAHID CHAMRAN UNIVERSITY";
			if( afiliacion.contains("SHAHID") && afiliacion.contains("RAJAEE") && afiliacion.contains("UNIV") )
					return "SHAHID RAJAEE UNIVERSITY";
			
			
			if( afiliacion.contains("MID") && (afiliacion.contains("EAST") || afiliacion.contains("E ")) && afiliacion.contains("TECH") && afiliacion.contains("UNIV"))
					return "MIDDLE EAST TECHNICAL UNIVERSITY";
			if( afiliacion.contains("ORTA") && afiliacion.contains("DOGU") && afiliacion.contains("UNIV") && (afiliacion.contains("TEK")||afiliacion.contains("TECH")) )
					return "MIDDLE EAST TECHNICAL UNIVERSITY";
			if( afiliacion.compareTo("METU")==0 )
					return "MIDDLE EAST TECHNICAL UNIVERSITY";
			if( afiliacion.compareTo("ODTU")==0 )
					return "MIDDLE EAST TECHNICAL UNIVERSITY";
			
			if( afiliacion.contains("ONDOKUZ") && afiliacion.contains("MAY") && afiliacion.contains("UNIV") )
					return "ONDOKUZ MAYIS UNIVERSITY";
				
			if( afiliacion.contains("NWFP") )
					return "UNIVERSITY OF ENGINEERING AND TECHNOLOGY";
			
			if( afiliacion.contains("MECHAT") && afiliacion.contains("MEASUR") && afiliacion.contains("NAT") && afiliacion.contains("INST") && afiliacion.contains("RES") && afiliacion.contains("DEV") )
					return "NATIONAL INSTITUTE OF RESEARCH AND DEVELOPMENT FOR MECHATRONICS AND MEASUREMENT TECHNIQUE";
			if( afiliacion.contains("CERCE") && afiliacion.contains("DEZVO") && afiliacion.contains("NAT") && afiliacion.contains("MECAT") && afiliacion.contains("MASUR") )
					return "NATIONAL INSTITUTE OF RESEARCH AND DEVELOPMENT FOR MECHATRONICS AND MEASUREMENT TECHNIQUE";
			if( afiliacion.compareTo("INCDMTM")==0 )
					return "NATIONAL INSTITUTE OF RESEARCH AND DEVELOPMENT FOR MECHATRONICS AND MEASUREMENT TECHNIQUE";
			
			if( afiliacion.contains("CHUNG") && afiliacion.contains("HSING") && afiliacion.contains("UNIV") && afiliacion.contains("NAT") )
					return "NATIONAL CHUNG HSING UNIVERSITY";
			
			if( (afiliacion.contains("SPACE")||afiliacion.contains("SPATIAL")) && afiliacion.contains("TECH") && afiliacion.contains("NAT") && (afiliacion.contains("CENT")||afiliacion.contains("CTR")) )
					return "NATIONAL CENTER FOR SPACE TECHNIQUES";
			if( afiliacion.compareTo("CNTS")==0 )
				return "NATIONAL CENTER FOR SPACE TECHNIQUES";
			
			if( afiliacion.contains("NANYANG") && afiliacion.contains("UNIV") && afiliacion.contains("TECH") )
					return "NANYANG TECHNOLOGICAL UNIVERSITY";
			
			if( afiliacion.contains("YUNLIN") && afiliacion.contains("NAT") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH") )
					return "NATIONAL YUNLIN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if( afiliacion.contains("TAIWAN") && afiliacion.contains("NAT") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH") )
					return "NATIONAL TAIWAN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if( afiliacion.contains("PRIRODO") && afiliacion.contains("UNIV"))
					return "MOSCOW STATE UNIVERSITY PRIRODOOBUSTROJSTVA";
			
			if( afiliacion.contains("MOSCOW") && (afiliacion.contains("POW") || afiliacion.contains("PWR")) && afiliacion.contains("INST"))
					return "MOSCOW POWER ENGINEERING INSTITUTE";
			
			if( afiliacion.contains("LUND") && afiliacion.contains("UNIV") )
					return "LUND UNIVERSITY";
			if( afiliacion.contains("LUND") && afiliacion.contains("INST") && afiliacion.contains("TECH") )
					return "LUND UNIVERSITY";
					
			if( afiliacion.contains("LITHUANIA") && afiliacion.contains("UNIV") && afiliacion.contains("AGR") )
					return "LITHUANIAN UNIVERSITY OF AGRICULTURE";
			
			if( afiliacion.contains("LAB") && (afiliacion.contains("NAC")||afiliacion.contains("NAT")) && afiliacion.contains("CIVIL") && afiliacion.contains("ENG") )// Laboratório Nacional de Engenharia Civil
					return "NATIONAL LABORATORY FOR CIVIL ENGINEERING";
			if( afiliacion.compareTo("LNEC")==0 )
				return "NATIONAL LABORATORY FOR CIVIL ENGINEERING";
					
			if( afiliacion.contains("KING") && afiliacion.contains("MONGKUT") && afiliacion.contains("UNIV") )
					return "KING MONGKUTS UNIVERSITY OF TECHNOLOGY THONBURI";
			
			if( afiliacion.contains("JACOBS ") && (afiliacion.contains("LTD")||afiliacion.contains("LIMITED")) )
					return "JACOBS LIMITED";
					
			if( afiliacion.contains("AZAD ") && afiliacion.contains("UNIV") )
					return "ISLAMIC AZAD UNIVERSITY";
			
			if( afiliacion.contains("JORDAN") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH") )
					return "JORDAN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if( afiliacion.contains("KARADENIZ") && (afiliacion.contains("TECH")||afiliacion.contains("TEK")) && afiliacion.contains("UNIV") )
					return "KARADENIZ TECHNICAL UNIVERSITY";

			if( afiliacion.contains("ISTANBUL") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "ISTANBUL TECHNICAL UNIVERSITY";		
					
			if( afiliacion.contains("ISFAHAN") && afiliacion.contains("UNIV") && afiliacion.contains("TECH") )
					return "ISFAHAN UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("ATHENS") && afiliacion.contains("NAT") && afiliacion.contains("TEC") && afiliacion.contains("UNIV") )
					return "NATIONAL TECHNICAL UNIVERSITY OF ATHENS";
			if( (afiliacion.contains("IROON")||afiliacion.contains("HEROON")) && afiliacion.contains("POLYTECH") )
					return "NATIONAL TECHNICAL UNIVERSITY OF ATHENS";
			
			if( afiliacion.contains("IRAN") && afiliacion.contains("WATER") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) && afiliacion.contains("DEV") )
					return "IRAN WATER AND POWER RESOURCES DEVELOPMENT COMPANY";
			if( afiliacion.compareTo("IWPC")==0 )
				return "IRAN WATER AND POWER RESOURCES DEVELOPMENT COMPANY";
			
			if( afiliacion.contains("IRAN") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("TECH") )
					return "IRAN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			if( afiliacion.compareTo("IUST")==0 )
				return "IRAN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if( afiliacion.contains("JAROSLAV") && afiliacion.contains("CERNI") && afiliacion.contains("WATER") )
					return "JAROSLAV CERNI INSTITUTE OF WATER RESOURCES";
					
			if( afiliacion.contains("HYDROPLUS") )
					return "HYDROPLUS";
			
			if( afiliacion.contains("GZA") && afiliacion.contains("GEOENVIRON") )
					return "GZA GEOENVIRONMENTAL INCORPORATED";
			
			if( afiliacion.contains("GUMUS") && afiliacion.contains("HANE") && afiliacion.contains("UNIV") )
					return "GUMUSHANE UNIVERSITY";
			
			if( afiliacion.contains("FINNISH") && afiliacion.contains("ENVIRON") && afiliacion.contains("INST") )
					return "FINNISH ENVIRONMENT INSTITUTE";
			
			if( afiliacion.contains("FIRAT") && afiliacion.contains("UNIV") )
					return "FIRAT UNIVERSITY";
					
					
			if( afiliacion.contains("DOLEXPERT") && afiliacion.contains("GEOTEC") )
					return "DOLEXPERT GEOTECHNICAL";
			
			if( afiliacion.contains("SWISS")&& afiliacion.contains("FED") && afiliacion.contains("LAB") && afiliacion.contains("MAT") && afiliacion.contains("TEST") && afiliacion.contains("RES") )
					return "SWISS FEDERAL LABORATORIES FOR MATERIALS TESTING AND RESEARCH";
			if( afiliacion.compareTo("EMPA")==0 )
					return "SWISS FEDERAL LABORATORIES FOR MATERIALS TESTING AND RESEARCH";
			
			if( afiliacion.contains("PETERSBURG") && (afiliacion.contains("STATE")||afiliacion.contains("STT")) && afiliacion.contains("MIN") && afiliacion.contains("INST") )
					return "SAINT PETERSBURG STATE MINING INSTITUTE";
			
			if( afiliacion.contains("PETERSBURG") && (afiliacion.contains("STATE")||afiliacion.contains("STT")) && afiliacion.contains("POLY") && afiliacion.contains("UNIV") )
					return "SAINT PETERSBURG STATE POLYTECHNICAL UNIVERSITY";
			
			if( afiliacion.contains("PETERSBURG") && (afiliacion.contains("STATE")||afiliacion.contains("STT")) && afiliacion.contains("POLY") && afiliacion.contains("UNIV") )
					return "SAINT PETERSBURG STATE POLYTECHNICAL UNIVERSITY";
			
			if( afiliacion.contains("BAHCESEHIR") && afiliacion.contains("UNIV") )
					return "BAHCESEHIR UNIVERSITY";
			
			if( afiliacion.contains("PETERSBURG") && afiliacion.contains("UNIV") )
					return "SAINT PETERSBURG STATE UNIVERSITY";
			
			if( afiliacion.contains("SWED") && afiliacion.contains("TECH") && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "SP TECHNICAL RESEARCH INSTITUTE OF SWEDEN";
			
			if( afiliacion.contains("SHIP") && afiliacion.contains("DESIGN") && afiliacion.contains("RESEARCH") &&                 (afiliacion.contains("CENT")||afiliacion.contains("CTR")) )
					return "SHIP DESIGN AND RESEARCH CENTER";
					
			if( (afiliacion.contains("GEOMECH")||afiliacion.contains("CIV")) && afiliacion.contains("ENG") && afiliacion.contains("GEOTECH")&& afiliacion.contains("DEP") )
					return "DEPARTMENT OF GEOMECHANICS CIVIL ENGINEERING AND GEOTECHICS";
			
			if( (afiliacion.contains("BLDG")||afiliacion.contains("BUILD")) && afiliacion.contains("MAT") && afiliacion.contains("COMP")&& afiliacion.contains("INST") )
					return "INSTITUTE OF TECHNOLOGY BUILDING MATERIALS AND COMPONENTS";
			
			if( afiliacion.contains("GEOINFORMAT") && afiliacion.contains("SCI") && afiliacion.contains("EARTH")&& afiliacion.contains("OBSERV") )
					return "INTERNATIONAL INSTITUTE OF GEOINFORMATIC SCIENCE AND EARTH OBSERVATION";
			
			if( afiliacion.contains("OSTRAVA") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF OSTRAVA";
					
			if( afiliacion.contains("VERBUND") && afiliacion.contains("HYDRO") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) )
					return "VERBUND HYDRO POWER AGENCY";
			
			if( afiliacion.contains("INNSBRUCK") && afiliacion.contains("UNIV") )
					return "INNSBRUCK UNIVERSITY";

			if( afiliacion.contains("ARUP") )
					return "OVE ARUP AND PARTNERS";
			
			if( afiliacion.contains("SAMSUNG") )
					return "SAMSUNG";
			
			if( afiliacion.contains("KLEINFELDER") )
					return "KLEINFELDER INCORPORATED";
			
			if( afiliacion.contains("LAHMEYER ") )
					return "LAHMEYER INTERNATIONAL";
			
			if( afiliacion.contains("BANGLADESH") && afiliacion.contains("AGRIC") && afiliacion.contains("RES") )
					return "BANGLADESH AGRICULTURAL RESEARCH INSTITUTE";
			if( afiliacion.compareTo("BARI")==0 )
					return "BANGLADESH AGRICULTURAL RESEARCH INSTITUTE";
			
			if( afiliacion.contains("DEF") && afiliacion.contains("SCI") && afiliacion.contains("TECH") && afiliacion.contains("AG") )
					return "DEFENCE SCIENCE AND TECHNOLOGY AGENCY";
			
			if( afiliacion.contains("BG") && afiliacion.contains("CONSULT") && afiliacion.contains("ENG") )
					return "BG CONSULTING ENGINEERS LIMITED";
			
			if( afiliacion.contains("CZECH") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "CZECH TECHNICAL UNIVERSITY";
			
			if( afiliacion.contains("BUTWAL") && (afiliacion.contains("POW")||afiliacion.contains("PWR")) )
					return "BUTWAL POWER COMPANY";
			
			if( afiliacion.contains("CZECH") && afiliacion.contains("ACAD") && afiliacion.contains("SCI") )
					return "ACADEMY OF SCIENCES OF THE CZECH REPUBLIC";
			
			if( afiliacion.contains("GAZI") && afiliacion.contains("UNIV") )
					return "GAZI UNIVERSITY";
			
			if( afiliacion.contains("NSA") && afiliacion.contains("GEOTECH") && afiliacion.contains("SERV") )
					return "NSA GEOTECHNICAL SERVICES INCORPORATED";
			
			if( afiliacion.contains("GEOTECH") && afiliacion.contains("SERV") )
					return "GEOTECHNICAL SERVICES AND GROUNDWATER DEPARTMENT";

			if( afiliacion.contains("NORW") && afiliacion.contains("UNIV") && afiliacion.contains("SCI") && afiliacion.contains("ECON") )
					return "NORWEGIAN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			if( afiliacion.compareTo("NTNU")==0 )
					return "NORWEGIAN UNIVERSITY OF SCIENCE AND TECHNOLOGY";
			
			if( afiliacion.contains("BUDAPEST") && afiliacion.contains("UNIV") && afiliacion.contains("TECH") && afiliacion.contains("ECON") )
					return "BUDAPEST UNIVERSITY OF TECHNOLOGY AND ECONOMICS";
			
			if( afiliacion.contains("LOMBARDI") && afiliacion.contains("ENG") )
					return "LOMBARDI CONSULTING ENGINEERS LIMITED";
					
			if( afiliacion.contains("MOH") && afiliacion.contains("ASSOCIATES") )
					return "MOH AND ASSOCIATES INCORPORATED";
					
			if( afiliacion.contains("METROPROJEKT") && afiliacion.contains("PRAHA") )
					return "METROPROJEKT PRAHA";
					
			if( afiliacion.contains("OBB") && afiliacion.contains("INFRASTRUKTUR") && afiliacion.contains("AG") )
					return "OBB INFRASTRUKTUR AGENCY";
					
			if( afiliacion.contains("LAABMAYR") && afiliacion.contains("PARTNER") && afiliacion.contains("CONSULTING") && afiliacion.contains("IL"))
					return "IL LAABMAYR AND PARTNER CONSULTING ENGINEERS";
		
			if( afiliacion.contains("GEOTECHNIK") && afiliacion.contains("TUNNELBAU") && (afiliacion.contains("ZT")||afiliacion.contains("ZIVILTECHNIKER")) && afiliacion.contains("GMBH"))
					return "GEOTECHNIK UND TUNNELBAU ZIVILTECHNIKER GMBH";
			if( afiliacion.contains("IGT") && (afiliacion.contains("ZT")||afiliacion.contains("ZIVILTECHNIKER")) && afiliacion.contains("GMBH"))
					return "GEOTECHNIK UND TUNNELBAU ZIVILTECHNIKER GMBH";
		
			if( (afiliacion.contains("LUXEMBURG")||afiliacion.contains("LUXEMBOURG")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LUXEMBOURG";
		
			if(afiliacion.contains("CHULALONGKORN") && afiliacion.contains("UNIV"))
					return "CHULALONGKORN UNIVERSITY";
		
			if( afiliacion.compareTo("UAE")==0 )
					return "UNITED ARAB EMIRATES UNIVERSITY";
			if( afiliacion.endsWith(" UAE")  )
					return "UNITED ARAB EMIRATES UNIVERSITY";
			if( afiliacion.startsWith("UAE ")  )
					return "UNITED ARAB EMIRATES UNIVERSITY";
		
			if( afiliacion.compareTo("CNRS")==0 )
					return "CENTRE NATIONAL DE LA RECHERCHE SCIENTIFIQUE";
		
			if(afiliacion.contains("GRAZ") && afiliacion.contains("UNIV") && afiliacion.contains("TECH"))
						return "GRAZ UNIVERSITY OF TECHNOLOGY";
			if(afiliacion.contains("TUGRAZ"))
						return "GRAZ UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.contains("RUSSIA") && afiliacion.contains("ACAD") && afiliacion.contains("SCI") )
					return "RUSSIAN ACADEMY OF SCIENCES";
			if( afiliacion.compareTo("ACAD SCI USSR")==0 )
					return "RUSSIAN ACADEMY OF SCIENCES";
		
		
			if( afiliacion.startsWith("CONCORDIA UNIV") )
					return "CONCORDIA UNIVERSITY";
			if( afiliacion.startsWith("CRANFIELD UNIV") )
					return "CRANFIELD UNIVERSITY";

			
			if( afiliacion.compareTo("CIMV")==0 )
					return "CIMV";
			if( afiliacion.compareTo("CITI")==0 )
					return "CITI";
			
			if( afiliacion.contains("CLEMSON") && afiliacion.contains("UNIV"))
					return "CLEMSON UNIVERSITY";
					
			if( afiliacion.contains("AALTO") && afiliacion.contains("UNIV"))
					return "AALTO UNIVERSITY";
			
			if( afiliacion.contains("ABERYSTWYTH") && afiliacion.contains("UNIV"))
					return "ABERYSTWYTH UNIVERSITY";
			
			if( afiliacion.contains("ABO") && afiliacion.contains("AKAD") && afiliacion.contains("UNIV"))
					return "ABO AKAD UNIVERSITY";
			
			if( afiliacion.contains("SINICA") && afiliacion.contains("ACAD"))
					return "ACADEMY OF SINICA";
			
			if( afiliacion.contains("ADAS") && afiliacion.contains("UK") && (afiliacion.contains("LTD")||afiliacion.contains("LIMITED")) )
					return "ADAS UK LIMITED";
			
			if( afiliacion.contains("ADITYA") && afiliacion.contains("BIRLA") && afiliacion.contains("DOMSJO"))
					return "ADITYA BIRLA DOMSJO FABRIKER AB";
			
			if( afiliacion.contains("AGR") && afiliacion.contains("FOOD") && afiliacion.contains("CANADA"))
					return "AGRICULTURE AND AGRI-FOOD CANADA";
			
			if( afiliacion.contains("ATHENS") && afiliacion.contains("AGR") && afiliacion.contains("UNIV"))
					return "AGRICULTURE UNIVERSITY OF ATHENS";
			
			if( afiliacion.contains("WAGENINGEN") && afiliacion.contains("AGR") && afiliacion.contains("UNIV"))
					return "WAGENINGEN AGRICULTURAL UNIVERSITY";
			
			if( afiliacion.contains("MARSEILLE") && afiliacion.contains("AIX") && afiliacion.contains("UNIV"))
					return "AIX MARSEILLE UNIVERSITY";
					
			if(afiliacion.contains("ALIGARH") && afiliacion.contains("MUSLIM") && afiliacion.contains("UNIV"))
					return "ALIGARH MUSLIM UNIVERSITY";
					
			if(afiliacion.contains("AMIR") && afiliacion.contains("KABIR") && afiliacion.contains("UNIV") && afiliacion.contains("TECH"))
					return "AMIR KABIR UNIVERSITY OF TECHNOLOGY";
			
			if(afiliacion.contains("ANNA") && afiliacion.contains("UNIV"))
					return "ANNA UNIVERSITY";
					
			if(afiliacion.contains("ARGONNE") && afiliacion.contains("NAT") && afiliacion.contains("LAB"))
					return "ARGONNE NATIONAL LABORATORY";
					
			if(afiliacion.contains("ARISTOTLE") && afiliacion.contains("UNIV") && afiliacion.contains("THESSALONIKI"))
					return "ARISTOTLE UNIVERSITY OF THESSALONIKI";
			
			if(afiliacion.contains("ASIAN") && afiliacion.contains("INST") && afiliacion.contains("TECH"))
					return "ASIAN INSTITUTE OF TECHNOLOGY";
					
			if(afiliacion.contains("ASTON") && afiliacion.contains("UNIV"))
					return "ASTON UNIVERSITY";
					
			if(afiliacion.contains("AT") && afiliacion.contains("BELL") && afiliacion.contains("LABS"))
					return "ATT BELL LABORATORIES";
			
			
			if(afiliacion.contains("BASF") && afiliacion.contains("AG"))
					return "BASF AG";
			
			
			if(afiliacion.contains("BCSIR") && afiliacion.contains("LABS"))
					return "BANGLADESH COUNCIL OF SCIENTIFIC AND INDUSTRIAL RESEARCH LABORATORIES";
			
			if(afiliacion.contains("BEN") && afiliacion.contains("GURION") && afiliacion.contains("UNIV") && afiliacion.contains("NEGEV"))
					return "BEN GURION UNIVERSITY OF THE NEGEV";
			
			if(afiliacion.contains("BIOREF") && afiliacion.contains("DE") && afiliacion.contains("GMBH"))
					return "BIOREFINERY GMBH";
					
			if(afiliacion.contains("BOGAZICI") && afiliacion.contains("UNIV"))
					return "BOGAZICI UNIVERSITY";
			
			if(afiliacion.contains("BRANDENBURG") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") && afiliacion.contains("COTTBUS"))
					return "BRANDENBURG TECHNICAL UNIVERSITY OF COTTBUS";
			
			if(afiliacion.contains("BRUNEL") && afiliacion.contains("UNIV"))
					return "BRUNEL UNIVERSITY";
					
			if(afiliacion.contains("CARDIFF") && afiliacion.contains("UNIV"))
					return "CARDIFF UNIVERSITY";
			
			
			if( afiliacion.compareTo("CEMAGREF")==0 )
					return "NATIONAL CENTER OF AGRICULTURAL MACHINERY AGRICULTURAL ENGINEERING AND WATER AND FORESTS";
			if( afiliacion.compareTo("CENT LEATHER RES INST")==0 )
					return "CENTRAL LEATHER RESEARCH INSTITUTE";
			if( afiliacion.compareTo("CLRI")==0 )
					return "CENTRAL LEATHER RESEARCH INSTITUTE";
					
			
			if( afiliacion.contains("CH2M") && afiliacion.contains("HILL") )
					return "CH2M HILL INC";
					
			if( afiliacion.startsWith("CHALMERS") )
					return "CHALMERS UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.compareTo("CHEM TECHNOL WOOD")==0 )
					return "INSTITUTE OF WOOD CHEMISTRY AND CHEMICAL TECHNOLOGY OF WOOD";
			if( afiliacion.startsWith("CHILDRENS HOSP") )
					return "CHILDRENS HOSPITAL";
			
			if( afiliacion.compareTo("CSIR")==0 )
					return "COUNCIL OF SCIENTIFIC AND INDUSTRIAL RESEARCH";
			if( afiliacion.compareTo("CSIRO")==0 )
					return "COMMONWEALTH SCIENTIFIC AND INDUSTRIAL RESEARCH ORGANIZATION";
			if( afiliacion.compareTo("CSIRO MAT SCI ENGN")==0 )
					return "CSIRO MATERIALS SCIENCE AND ENGINEERING";
			
			
			if( afiliacion.compareTo("CURTIN UNIV TECHNOL")==0 )
					return "CURTIN UNIVERSITY OF TECHNOLOGY";
			
			
			if( afiliacion.startsWith("DE LA SALLE UNIV") )
					return "DE LA SALLE UNIVERSITY";
			if( afiliacion.compareTo("DECHEMA EV")==0 )
					return "DECHEMA EV";
			if( afiliacion.compareTo("DEMOCRITUS UNIV THRACE")==0 )
					return "DEMOCRITUS UNIVERSITY OF THRACE";
			if( afiliacion.compareTo("DOE BIOENERGY SCI CTR BESC")==0 )
					return "DOE BIOENERGY SCIENCE CENTER";
			if( afiliacion.compareTo("DOKUZ EYLUL UNIV")==0 )
					return "DOKUZ EYLUL UNIVERSITY";
			if( afiliacion.compareTo("DONG ENERGY AS")==0 )
					return "DONG ENERGY AS";
			
			
			if( afiliacion.startsWith("DUPONT") )
					return "DUPONT CO INC";
			
			if( afiliacion.compareTo("EAWAG")==0 )
					return "EAWAG";
			if( afiliacion.compareTo("ECOLE POLYTECH")==0 )
					return "ECOLE POLYTECHNIC";
			if( afiliacion.compareTo("ECOLE POLYTECH FED LAUSANNE")==0 )
					return "ECOLE POLYTECHNIQUE FEDERALE DE LAUSANNE";
			
			
			if( afiliacion.startsWith("ECOLE POLYTECHNIQUE FEDERALE DE LAUSANNE") )
					return "ECOLE POLYTECHNIQUE FEDERALE DE LAUSANNE";
			
			if( afiliacion.compareTo("EGE UNIV")==0 )
					return "EGE UNIVERSITY";
			if( afiliacion.compareTo("EINDHOVEN UNIV TECHNOL")==0 )
					return "EINDHOVEN UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.compareTo("ENERGY RES CTR NETHERLANDS ECN")==0 )
					return "ENERGY RESEARCH CENTER OF THE NETHERLANDS";
			if( afiliacion.compareTo("ENVIRONM CANADA")==0 )
					return "ENVIRONM CANADA";
			if( afiliacion.compareTo("ETH")==0 )
					return "EIDGENOSSISCHE TECHNISCHE HOCHSCHULE";
			
			
			if( afiliacion.compareTo("FPINNOVATIONS")==0 )
					return "FPINNOVATIONS";
			if( afiliacion.compareTo("FREE UNIV BERLIN")==0 )
					return "FREE UNIVERSITY OF BERLIN";
			
			if( afiliacion.compareTo("GATE FUELS INC")==0 )
					return "GATE FUELS INC";
			if( afiliacion.compareTo("GE")==0 )
					return "GENERAL ELECTRIC";
			if( afiliacion.compareTo("GENENTECH INC")==0 )
					return "GENENTECH INC";
			
			if( afiliacion.compareTo("GRAZ UNIV TECHNOL")==0 )
					return "GRAZ UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.compareTo("GRENOBLE INP PAGORA")==0 )
					return "GRENOBLE INP PAGORA";
			if( afiliacion.startsWith("GRIFFITH UNIV") )
					return "GRIFFITH UNIVERSITY";
			
			if( afiliacion.startsWith("HACETTEPE UNIV") )
					return "HACETTEPE UNIVERSITY";
			if( afiliacion.compareTo("HAMBURG UNIV TECHNOL")==0 )
					return "HAMBURG UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.startsWith("HANNOVER MED") )
					return "HANNOVER MEDICAL SCHOOL";
			if( afiliacion.compareTo("HANOI UNIV TECHNOL")==0 )
					return "HANOI UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.compareTo("HEBREW UNIV JERUSALEM")==0 )
					return "HEBREW UNIVERSITY OF JERUSALEM";
			if( afiliacion.compareTo("HELSINKI UNIV TECHNOL")==0 )
					return "HELSINKI UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.startsWith("HERIOT WATT UNIV") )
					return "HERIOT WATT UNIVERSITY";
			if( afiliacion.startsWith("HIROSHIMA UNIV") )
					return "HIROSHIMA UNIVERSITY";
			if( afiliacion.startsWith("HOKKAIDO UNIV") )
					return "HOKKAIDO UNIVERSITY";
			if( afiliacion.startsWith("HUMBOLDT UNIV") )
					return "HUMBOLDT UNIVERSITY";
			if( afiliacion.startsWith("HUNGARIAN ACAD") )
					return "HUNGARIAN ACADEMY OF SCIENCES";
			if( afiliacion.startsWith("IBM") )
					return "IBM CORP";
			
			if( afiliacion.startsWith("HILTON MINE") )
					return "HILTON MINE";
					
			if( afiliacion.compareTo("INETI")==0 )
					return "INSTITUTO NACIONAL DE ENGENHARIA TECNOLOGIA E INOVACAO";
			if( afiliacion.startsWith("INHA UNIV") )
					return "INHA UNIVERSITY";
			if( afiliacion.compareTo("INNVENTIA AB")==0 )
					return "INNVENTIA AB";
			if( afiliacion.compareTo("INRA")==0 )
					return "INSTITUT NATIONAL DE LA RECHERCHE AGRONOMIQUE";
			if( afiliacion.compareTo("INSERM")==0 )
					return "NATIONAL INSTITUTE OF HEALTH AND MEDICAL RESEARCH";
			if( afiliacion.compareTo("INST NATL SCI APPL")==0 )
					return "INSTITUT NATIONAL DES SCIENCES APPLIQUEES";
			if( afiliacion.compareTo("INST PASTEUR")==0 )
					return "INSTITUT PASTEUR";
			if( afiliacion.compareTo("JAIST")==0 )
					return "JAPAN ADVANCED INSTITUTE OF SCIENCE AND TECHNOLOGY";
			if( afiliacion.compareTo("JAPAN ADV INST SCI TECHNOL")==0 )
					return "JAPAN ADVANCED INSTITUTE OF SCIENCE AND TECHNOLOGY";
			if( afiliacion.compareTo("JAPAN SCI TECHNOL AGCY")==0 )
					return "JAPAN SCIENCE AND TECHNOLOGY AGENCY";
			if( afiliacion.compareTo("JAWAHARLAL NEHRU TECHNOL UNIV")==0 )
					return "JAWAHARLAL NEHRU TECHNOLOGY UNIVERSITY";
			if( afiliacion.startsWith("JILIN UNIV") )
					return "JILIN UNIVERSITY";
			if( afiliacion.startsWith("JOANNEUM RES") )
					return "JOANNEUM RESEARCH";
			if( afiliacion.startsWith("KARLSTAD UNIV") )
					return "KARLSTAD UNIVERSITY";
			
			if( afiliacion.compareTo("KAUNAS UNIV TECHNOL")==0 )
					return "KAUNAS UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.compareTo("KING FAHD UNIV PETR MINERALS")==0 )
					return "KING FAHD UNIVERSITY OF PETROLEUM AND MINERALS";
			if( afiliacion.startsWith("KING SAUD UNIV") )
					return "KING SAUD UNIVERSITY";
			if( afiliacion.startsWith("KOBE UNIV") )
					return "KOBE UNIVERSITY";
			if( afiliacion.compareTo("KOMPETENZZENTRUM HOLZ GMBH")==0 )
					return "KOMPETENZZENTRUM HOLZ GMBH";
			if( afiliacion.compareTo("KTH ROYAL INST TECHNOL")==0 )
					return "ROYAL INSTITUTE OF TECHNOLOGY";
			if( afiliacion.startsWith("ROYAL INSTITUTE OF TECH") )
					return "ROYAL INSTITUTE OF TECHNOLOGY";
			if( afiliacion.startsWith("ROYAL INST TECHNOL") )
					return "ROYAL INSTITUTE OF TECHNOLOGY";
			if( afiliacion.startsWith("KUMAMOTO UNIV") )
					return "KUMAMOTO UNIVERSITY";
			if( afiliacion.startsWith("KYOTO UNIV") )
					return "KYOTO UNIVERSITY";
			if( afiliacion.startsWith("KYUSHU UNIV") )
					return "KYUSHU UNIVERSITY";
			if( afiliacion.compareTo("LAB NACL CIENCIA TECNOL BIOETANOL CTBE")==0 )
					return "BRAZILIAN BIOETHANOL SCIENCE AND TECHNOLOGY LABORATORY";
			if( afiliacion.startsWith("LAKEHEAD UNIV") )
					return "LAKEHEAD UNIVERSITY";
			if( afiliacion.startsWith("LAPPEENRANTA UNIV TECHNOL") )
					return "LAPPEENRANTA UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.compareTo("LATVIAN STATE INST WOOD CHEM")==0 )
					return "LATVIAN STATE INSTITUTE OF WOOD CHEMISTRY";
			
			if( afiliacion.compareTo("LEIBNIZ INST AGR ENGN BORNIM")==0 )
					return "LEIBNIZ INSTITUTE OF AGRICULTURAL ENGINEERING";
			if( afiliacion.compareTo("LEIBNIZ UNIV HANNOVER")==0 )
					return "LEIBNIZ UNIVERSITY OF HANNOVER";
			if( afiliacion.startsWith("LEIDEN UNIV") )
					return "LEIDEN UNIVERSITY";
			if( afiliacion.compareTo("LENZING AG")==0 )
					return "LENZING AG";
			if( afiliacion.startsWith("LIGNOL INNOVAT CORP") )
					return "LIGNOL INNOVAT CORP";
			if( afiliacion.startsWith("LINKOPING UNIV") )
					return "LINKOPING UNIVERSITY";
			
			if( afiliacion.compareTo("LOUGHBOROUGH UNIV TECHNOL")==0 )
					return "LOUGHBOROUGH UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.startsWith("LULEA UNIV TECHNOL") )
					return "LULEA UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.startsWith("MACQUARIE UNIV") )
					return "MACQUARIE UNIVERSITY";
			if( afiliacion.startsWith("MALARDALEN UNIV") )
					return "MALARDALEN UNIVERSITY";
			
			if( afiliacion.startsWith("MASSEY UNIV") )
					return "MASSEY UNIVERSITY";
			if( afiliacion.compareTo("MAX PLANCK INST KOHLENFORSCH")==0 )
					return "MAX PLANCK INSTITUTE KOHLENFORSCH";
			
			if( afiliacion.compareTo("MICROBIOGEN LIMITED")==0 )
					return "MICROBIOGEN LIMITED";
			if( afiliacion.startsWith("MID SWEDEN UNIV") )
					return "MID SWEDEN UNIVERSITY";
			if( afiliacion.compareTo("MONASH UNIV")==0 )
					return "MONASH UNIVERSITY";
			if( afiliacion.startsWith("MOSCOW MV LOMONOSOV STATE UNIV") )
					return "LOMONOSOV STATE UNIVERSITY OF MOSCOW";
			if( afiliacion.startsWith("NAGOYA UNIV") )
					return "NAGOYA UNIVERSITY";
			if( afiliacion.compareTo("NANYANG TECHNOL UNIV")==0 )
					return "NANYANG TECHNOLOGY UNIVERSITY";
			
			if( afiliacion.compareTo("NAT RESOURCES CANADA")==0 )
					return "NATURAL RESOURCES CANADA";
			if( afiliacion.compareTo("NATL CENT UNIV")==0 )
					return "NATIONAL CENTRAL UNIVERSITY";
			if( afiliacion.compareTo("NATL CHEM LAB")==0 )
					return "NATIONAL CHEMICAL LABORATORY";
			if( afiliacion.compareTo("NATL CHENG KUNG UNIV")==0 )
					return "NATIONAL CHENG KUNG UNIVERSITY";
			if( afiliacion.startsWith("NATL CHIAO TUNG UNIV") || afiliacion.startsWith("NATL CHIAOTUNG UNIV") || afiliacion.startsWith("NATIONAL CHIAO TUNG UNIV") || afiliacion.startsWith("NATIONAL CHIAOTUNG UNIV") )
					return "NATIONAL CHIAO TUNG UNIVERSITY";
			if( afiliacion.compareTo("NATL CHUNG HSING UNIV")==0 )
					return "NATIONAL CHUNG HSING UNIVERSITY";
			if( afiliacion.compareTo("NATL CTR GENET ENGN BIOTECHNOL")==0 )
					return "NATIONAL CENTER FOR GENETIC ENGINEERING AND BIOTECHNOLOGY";
			if( afiliacion.compareTo("NATL INST ADV IND SCI TECHNOL")==0 )
					return "NATIONAL INSTITUTE OF ADVANCED INDUSTRIAL SCIENCE AND TECHNOLOGY";
			if( afiliacion.compareTo("NATL INST ENVIRONM STUDIES")==0 )
					return "NATIONAL INSTITUTE FOR ENVIRONMENTAL STUDIES";
			if( afiliacion.compareTo("NIES")==0 )
					return "NATIONAL INSTITUTE FOR ENVIRONMENTAL STUDIES";
			if( afiliacion.compareTo("NATL INST MAT SCI")==0 )
					return "NATIONAL INSTITUTE FOR MATERIALS SCIENCE";
			if( afiliacion.compareTo("NIMS")==0 )
					return "NATIONAL INSTITUTE FOR MATERIALS SCIENCE";
			if( afiliacion.compareTo("NATL RES COUNCIL CANADA")==0 )
					return "NATIONAL RESEARCH COUNCIL CANADA";
			if( afiliacion.compareTo("NATL RES CTR")==0 )
					return "NATIONAL RESEARCH CENTER";
			
			if( afiliacion.compareTo("NATL TECH UNIV ATHENS")==0 )
					return "NATIONAL TECHNICAL UNIVERSITY OF ATHENS";
			if( afiliacion.compareTo("NATL TSING HUA UNIV")==0 )
					return "NATIONAL TSING HUA UNIVERSITY";
			if( afiliacion.compareTo("NATL UNIV IRELAND")==0 )
					return "NATIONAL UNIVERSITY OF IRELAND";
			if( afiliacion.compareTo("NATL UNIV SINGAPORE")==0 )
					return "NATIONAL UNIVERSITY OF SINGAPORE";
			if( afiliacion.compareTo("NCI")==0 )
					return "NATIONAL CANCER INSTITUTE";
			if( afiliacion.compareTo("NORAMPAC CABANO")==0 )
					return "NORAMPAC CABANO";
			
			if( afiliacion.compareTo("NOVOZYMES AS")==0 )
					return "NOVOZYMES AS";
			if( afiliacion.startsWith("OKAYAMA UNIV") )
					return "OKAYAMA UNIVERSITY";
			if( afiliacion.startsWith("OPEN UNIV") )
					return "OPEN UNIVERSITY";
			if( afiliacion.startsWith("OSAKA UNIV") )
					return "OSAKA UNIVERSITY";
			if( afiliacion.compareTo("PARTHENOPE UNIV NAPLES")==0 )
					return "PARTHENOPE UNIVERSITY OF NAPLES";
			if( afiliacion.compareTo("PETROBRAS SA")==0 )
					return "PETROBRAS SA";
			if( afiliacion.compareTo("PETROBRAS")==0 )
					return "PETROBRAS SA";
			if( afiliacion.compareTo("POLISH ACAD SCI")==0 )
					return "POLISH ACADEMY OF SCIENCES";
			if( afiliacion.compareTo("PROCESSUM BIOREFINERY INITIAT AB")==0 )
					return "PROCESSUM BIOREFINERY INITIATIVE AB";
			
			if( afiliacion.compareTo("AGR RES ORG")==0 )
					return "AGRICULTURAL RESEARCH ORGANISATION";
			
			if( afiliacion.contains("PROCTER") && afiliacion.contains("GAMBLE") )
					return "PROCTER AND GAMBLE CO";
			if( afiliacion.contains("RADBOUD") && afiliacion.contains("UNIV") && afiliacion.contains("NIJMEGEN") )
					return "RADBOUD UNIVERSITY OF NIJMEGEN";
			
			if( afiliacion.contains("FOREST ") && afiliacion.contains(" PAPER") && afiliacion.contains(" RES") && afiliacion.contains(" INST") )
					return "FOREST AND PAPER RESEARCH INSTITUTE";
			if( afiliacion.compareTo("RAIZ")==0 )
					return "FOREST AND PAPER RESEARCH INSTITUTE";
			if( afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("BIOACT") && afiliacion.contains("POLYMER") && afiliacion.contains("SYS") )
					return "RESEARCH INSTITUTE OF BIOACTIVE POLYMER SYSTEMS E.V.";
			if( afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("INNOVA") && afiliacion.contains("TECH") && afiliacion.contains("EARTH") )
					return "RESEARCH INSTITUTE OF INNOVATIVE TECHNOLOGY FOR THE EARTH";
			if( afiliacion.contains("RHEIN") && afiliacion.contains("WESTFA") && afiliacion.contains("AACHEN") )
					return "RWTH AACHEN UNIVERSITY";
			if( afiliacion.compareTo("RWTH")==0 )
					return "RWTH AACHEN UNIVERSITY";
			if( afiliacion.startsWith("ROTHAMSTED RES") )
					return "ROTHAMSTED RESEARCH";
			if( afiliacion.contains("ROYAL") && afiliacion.contains("INST") && afiliacion.contains("TECH") )
					return "ROYAL INSTITUTE OF TECHNOLOGY";
			if( afiliacion.compareTo("SCION")==0 )
					return "SCION";
			if( afiliacion.startsWith("SELCUK UNIV") )
					return "SELCUK UNIVERSITY";
			if( afiliacion.startsWith("SHANDONG UNIV") )
					return "SHANDONG UNIVERSITY";
			if( afiliacion.startsWith("SHIZUOKA UNIV") )
					return "SHIZUOKA UNIVERSITY";
			if( afiliacion.startsWith("SIEMENS") )
					return "SIEMENS";
			if( afiliacion.startsWith("SMARTEC") )
					return "SMARTEC SA";
			if( afiliacion.contains("SILESIAN") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "SILESIAN UNIVERSITY OF TECHNOLOGY";
			if( afiliacion.contains("SILSOE") && afiliacion.contains("RES") && afiliacion.contains("INST") )
					return "SILSOE RESEARCH INSTITUTE";
			if( afiliacion.contains("STATE") && afiliacion.contains("UNIV") && afiliacion.contains("GHENT") )
					return "STATE UNIVERSITY OF GHENT";
			if( afiliacion.contains("VULKANLAND") && afiliacion.contains("REGIONALENTWICKLUNG") )
					return "STEIR VULKANLAND REGIONALENTWICKLUNG GMBH";
			if( afiliacion.contains("SWEDISH") && afiliacion.contains("UNIV") && afiliacion.contains("AGR") && afiliacion.contains(" SCI") )
					return "SWEDISH UNIVERSITY OF AGRICULTURE SCIENCES";
			if( afiliacion.contains("SWISS")&&afiliacion.contains("FED") && afiliacion.contains("INST") && afiliacion.contains(" TECH") )
					return "SWISS FEDERAL INSTITUTE OF TECHNOLOGY";
			if( afiliacion.contains("TAMPERE") && afiliacion.contains("UNIV") && afiliacion.contains("TECH") )
					return "TAMPERE UNIVERSITY OF TECHNOLOGY";
			
			if( afiliacion.compareTo("TEAGASC")==0 )
					return "IRISH AGRICULTURE AND FOOD DEVELOPMENT AUTHORITY";
			if( afiliacion.contains("IRISH") && afiliacion.contains("AGR") && afiliacion.contains("FOOD") && afiliacion.contains("DEV") && afiliacion.contains("AUTH") )
					return "IRISH AGRICULTURE AND FOOD DEVELOPMENT AUTHORITY";
			
			if( afiliacion.contains("BERLIN") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF BERLIN";
					
			if( afiliacion.contains("BRAUNSCHWEIG") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "BRAUNSCHWEIG UNIVERSITY OF TECHNOLOGY";
					
			if( afiliacion.contains(" CRETE") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF CRETE";
					
			if( afiliacion.contains("DARMSTADT") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF DARMSTADT";
					
			if( afiliacion.contains("DENMARK") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF DENMARK";
					
			if( afiliacion.contains("DRESDEN") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "DRESDEN UNIVERSITY OF TECHNOLOGY";
					
			if( afiliacion.contains("LODZ") && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF LODZ";
					
			if( (afiliacion.contains("MUNICH")||afiliacion.contains("MUNCHEN")) && afiliacion.contains("TECH") && afiliacion.contains("UNIV") )
					return "TECHNICAL UNIVERSITY OF MUNICH";
					
			if( (afiliacion.contains("MUNICH")||afiliacion.contains("MUNCHEN")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MUNICH"; // ALE & ENG
			if( afiliacion.compareTo("LMU")==0)
					return "UNIVERSITY OF MUNICH";
					
			if( afiliacion.contains("ISRAEL") && afiliacion.contains("INST") && afiliacion.contains("TECH") )
					return "ISRAEL INSTITUTE OF TECHNOLOGY";
					
			if( afiliacion.compareTo("TECHNION")==0 )
					return "ISRAEL INSTITUTE OF TECHNOLOGY";
					
			if( afiliacion.startsWith("TEL AVIV UNIV") )
					return "TEL AVIV UNIVERSITY";
					
			if( afiliacion.startsWith("TOHOKU UNIV") )
					return "TOHOKU UNIVERSITY";

			

			if( afiliacion.startsWith("TOYOTA") )
					return "TOYOTA INC";
			
			if( afiliacion.compareTo("UCL")==0 )
					return "UNIVERSITY COLLEGE LONDON";

			if( afiliacion.contains("HELMHOLTZ") && (afiliacion.contains("CEN") || afiliacion.contains("ZEN")) &&
				(afiliacion.contains("ENVIRONM") || afiliacion.contains("UMW")) )
					return "HELMHOLTZ CENTER FOR ENVIRONMENTAL RESEARCH";
			if( afiliacion.compareTo("UFZ")==0 )
					return "HELMHOLTZ CENTER FOR ENVIRONMENTAL RESEARCH";

			if( afiliacion.startsWith("UMEA UNIV") )
					return "UMEA UNIVERSITY";

			if( afiliacion.contains("AALBORG") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF AALBORG";
			
			if( afiliacion.contains("AMSTERDAM") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF AMSTERDAM";

			if( afiliacion.contains("AVEIRO") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF AVEIRO";

			if( afiliacion.contains(" BATH") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BATH";

			if( afiliacion.contains("BELGRADE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BELGRADE";

			if( afiliacion.contains("BERGEN") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BERGEN";

			if( afiliacion.contains(" BERN") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BERN";

			if( afiliacion.contains("BIELEFELD") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BIELEFELD";

			if( afiliacion.contains("BIRMINGHAM") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BIRMINGHAM";

			if( afiliacion.contains(" BORAS") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BORAS";

			if( afiliacion.contains("BRADFORD") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BRADFORD";

			if( afiliacion.contains("BRISTOL") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF BRISTOL";

			if( afiliacion.contains("CAMBRIDGE") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CAMBRIDGE";
					
			if( afiliacion.contains("CANTABRIA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CANTABRIA";
					
			if( afiliacion.contains("CANTERBURY") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CANTERBURY";
					
			if( afiliacion.contains("CAPE TOWN") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF CAPE TOWN";
					
			if( afiliacion.contains("COIMBRA") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF COIMBRA";
		
			if( afiliacion.contains("DUBLIN") && afiliacion.contains("UNIV") && afiliacion.contains("COLL") )
					return "UNIVERSITY COLLEGE DUBLIN";
		
			if( afiliacion.contains("COPENHAGEN") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF COPENHAGEN";
		
			if( afiliacion.contains("DURHAM") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF DURHAM";
		
			if( afiliacion.contains("EDINBURGH") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF EDINBURGH";
		
			if( afiliacion.contains("ERLANGEN NURNBERG") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF ERLANGEN NURNBERG";
		
			if( afiliacion.contains("EXETER") && afiliacion.contains("UNIV") )
					return "UNIVERSITY OF EXETER";
			
			if( afiliacion.contains("FREIBURG") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF FREIBURG";

			if( (afiliacion.contains("GENOA")||afiliacion.contains("GENOVA")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GENOA";

			if( (afiliacion.contains("GHENT")||afiliacion.contains("GENT")) && afiliacion.contains("UNIV"))
					return "GHENT UNIVERSITY";
			if( afiliacion.compareTo("UGENT")==0)
					return "GHENT UNIVERSITY";

			if(afiliacion.contains("GLASGOW") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GLASGOW";

			if(afiliacion.contains("GRONINGEN") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF GRONINGEN";

			if(afiliacion.contains("HALLE") && afiliacion.contains("WITTENBERG") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF HALLE WITTENBERG";
			if(afiliacion.contains("MARTIN") && afiliacion.contains("LUTHER") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF HALLE WITTENBERG";

			if(afiliacion.contains("HAMBURG") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF HAMBURG"; //Alemán, Inglés

			if(afiliacion.contains("HANNOVER") && afiliacion.contains("UNIV"))
					return "LEIBNIZ UNIVERSITY OF HANNOVER";

			if(afiliacion.contains("HEIDELBERG") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF HEIDELBERG";

			if( (afiliacion.contains("HELSINKI") || afiliacion.contains("HELSINGIN") || afiliacion.contains("HELSINGFORS")) && (afiliacion.contains("UNIV")||afiliacion.contains("YLIOP")) ) // Finés, Sueco, Inglés
					return "UNIVERSITY OF HELSINKI";

			if(afiliacion.contains("IOANNINA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF IOANNINA";

			if(afiliacion.contains("JYVASKYLA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF JYVASKYLA";

			if(afiliacion.contains("KAISERSLAUTERN") && (afiliacion.contains("UNIV") || afiliacion.contains("TU")))
					return "KAISERSLAUTERN UNIVERSITY OF TECHNOLOGY";

			if(afiliacion.contains("KARLSRUHE") && afiliacion.contains("UNIV"))
					return "KARLSRUHE UNIVERSITY";

			if( afiliacion.contains("PUTRA") && afiliacion.contains("MALAYSIA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PUTRA MALAYSIA";
			if( (afiliacion.contains("KEBANGSAAN") || afiliacion.contains("NAT"))  && afiliacion.contains("MALAYSIA") && afiliacion.contains("UNIV"))
					return "NATIONAL UNIVERSITY OF MALAYSIA";
			if( afiliacion.compareTo("UKM")==0)
					return "NATIONAL UNIVERSITY OF MALAYSIA";
			if( afiliacion.contains("UNIV") && afiliacion.contains("SAINS") && afiliacion.contains("MALAYSIA"))
					return "UNIVERSITY OF SAINS MALAYSIA";
			if( afiliacion.contains("MALAYSIA") &&(afiliacion.contains("TEKNOL")||afiliacion.contains("TECH")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF TECHNOLOGY MALAYSIA";
			
			if( (afiliacion.contains("TEKNOL")||afiliacion.contains("TECH")) && afiliacion.contains("PETRONAS") && afiliacion.contains("UNIV"))
					return "PETRONAS UNIVERSITY OF TECHNOLOGY";

			if(afiliacion.contains("LANCASTER") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LANCASTER";

			if(afiliacion.contains("LEEDS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LEEDS";

			if( (afiliacion.contains("LEIPZIG")||afiliacion.contains("LEIPZIGER")) && afiliacion.contains("UNIV"))
					return "LEIPZIG UNIVERSITY";

			if(afiliacion.contains("LIMERICK") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LIMERICK";

			if(afiliacion.contains("LIVERPOOL") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LIVERPOOL";

			if( (afiliacion.contains("LJUBLJANA")||afiliacion.contains("LJUBLJANI")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LJUBLJANA"; // Solov & ENG

			
			if(afiliacion.contains("LONDON") && afiliacion.contains("CITY") && afiliacion.contains("UNIV"))
					return "CITY UNIVERSITY OF LONDON";
			if(afiliacion.contains("LONDON") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LONDON";

			if(afiliacion.contains("IMPERIAL") && afiliacion.contains("COLL"))
					return "IMPERIAL COLLEGE OF SCIENCE TECHNOLOGY AND MEDICINE";

			if(afiliacion.contains("LOUGHBOROUGH") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF LOUGHBOROUGH";

			if(afiliacion.contains("MALAGA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MALAGA";

			if(afiliacion.contains("MALAYA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MALAYA";

			if(afiliacion.contains("MANCHESTER") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MANCHESTER";

			if( (afiliacion.contains("MARIBOR")||afiliacion.contains("MARIBORU")) && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MARIBOR"; //Eslov && ENG

			if(afiliacion.contains("MESSINA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MESSINA"; //Ita && ENG

			if(afiliacion.contains("MICHIGAN") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MICHIGAN";

			if(afiliacion.contains("MINHO") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MINHO"; // Port && ENG

			if(afiliacion.contains("MONTPELLIER") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MONTPELLIER";

			if(afiliacion.contains("MUNSTER") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF MUNSTER";
							
			if( afiliacion.contains("NAT") && afiliacion.contains("RES") && afiliacion.contains("APPL") && afiliacion.contains("LIFE") && afiliacion.contains("SCI") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NATURAL RESOURCES AND APPLIED LIFE SCIENCES";
					
			if( afiliacion.contains("NOTTINGHAM") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF NOTTINGHAM";
					
			if( (afiliacion.contains("NOVA")||afiliacion.contains("new")) && (afiliacion.contains("LISBOA")||afiliacion.contains("LISBON")) && afiliacion.contains("UNIV"))
					return "NEW UNIVERSITY OF LISBON";
			
			if( afiliacion.contains("OXFORD") && afiliacion.contains("PRESS") && afiliacion.contains("UNIV"))
					return "OXFORD UNIVERSITY PRESS";		
			if( afiliacion.contains("OXFORD") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF OXFORD";
					
			if( (afiliacion.contains("PANNONIA")||afiliacion.contains("VESZPREM")||afiliacion.contains("PANNON")) && (afiliacion.contains("UNIV")||afiliacion.contains("EGYETEM")))
					return "UNIVERSITY OF PANNONIA";
			
			if( afiliacion.contains("PATRAS") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PATRAS";

			if( (afiliacion.contains("POLYTEC")||afiliacion.contains("POLITE")) && (afiliacion.contains("BUCURESTI")||afiliacion.contains("BUCHAREST")) && afiliacion.contains("UNIV"))
					return "POLYTECHNIC UNIVERSITY OF BUCHAREST"; //Rum & eng
					
			if( afiliacion.contains("PRETORIA") && afiliacion.contains("UNIV"))
					return "UNIVERSITY OF PRETORIA"; //AFR & ENG
						
			if( afiliacion.contains("TOOSI") && afiliacion.contains("UNIV") && afiliacion.contains("TECH") && afiliacion.contains("K") )
				return "KHAJE NASIR TOOSI UNIVERSITY OF TECHNOLOGY";
			
			
			
		
		//VARIAS
		if( afiliacion.contains("DENMARK") && (afiliacion.contains("SO ")||afiliacion.contains("S ")||afiliacion.contains("SOUTH")) && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF SOUTHERN DENMARK";
				
		if( afiliacion.contains("STELLENBOSCH") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF STELLENBOSCH";
				
		if( (afiliacion.contains("LISBOA")||afiliacion.contains("LISBON")) && afiliacion.contains("TEC") && afiliacion.contains("UNIV"))
				return "TECHNICAL UNIVERSITY OF LISBON";

		if( afiliacion.contains("TEHRAN") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF TEHRAN";
		
		if( afiliacion.contains("TEHRAN") && afiliacion.contains("POLYTECH"))
				return "TEHRAN POLYTECHNIC";
		if( afiliacion.contains("AMIRKABIR") && afiliacion.contains("TECH"))
				return "TEHRAN POLYTECHNIC";
				
		if( afiliacion.contains("TWENTE") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF TWENTE";
				
		if( afiliacion.contains("UTRECHT") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF UTRECHT";
				
		if( afiliacion.contains("VICTORIA") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF VICTORIA";//Hay muchas de varios países
				
		if( afiliacion.contains("VIENNA") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF VIENNA";
				
		if( afiliacion.contains("WAGENINGEN") && afiliacion.contains("RES") && (afiliacion.contains("CTR")||afiliacion.contains("CEN")) && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF WAGENINGEN RESEARCH CENTER";
				
		if( afiliacion.contains("WITWATERSRAND") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF WITWATERSRAND";
				
		if( afiliacion.contains("ZAGREB") && afiliacion.contains("UNIV"))
				return "UNIVERSITY OF ZAGREB";
				
		if(afiliacion.contains("UPPSALA") && afiliacion.contains("UNIV"))
				return "UPPSALA UNIVERSITY";
				
		if(afiliacion.contains("VIENNA") && afiliacion.contains("UNIV") && afiliacion.contains("TECH"))
				return "VIENNA UNIVERSITY OF TECHNOLOGY";
				
		if( afiliacion.contains("INST") && afiliacion.contains("WOOD") && afiliacion.contains("TECH") && afiliacion.contains("BIOL"))
				return "INSTITUTE OF WOOD TECHNOLOGY AND WOOD BIOLOGY";

		if( afiliacion.contains("FINLAND") && afiliacion.contains("TECH") && afiliacion.contains("RES") && (afiliacion.contains("CTR")||afiliacion.contains("CEN")) )
				return "VTT TECHNICAL RESEARCH CENTER OF FINLAND";
		if( afiliacion.contains("VTT") )
				return "VTT TECHNICAL RESEARCH CENTER OF FINLAND";
				
		if(afiliacion.contains("WAGENINGEN") && afiliacion.contains("UR"))
				return "WAGENINGEN UNIVERSITY AND RESEARCH CENTER";
		if(afiliacion.contains("WAGENINGEN")  && afiliacion.contains("UNIV") && afiliacion.contains("RES") && (afiliacion.contains("CTR")||afiliacion.contains("CEN")))
				return "WAGENINGEN UNIVERSITY AND RESEARCH CENTER";

		if(afiliacion.contains("WAGENINGEN") && afiliacion.contains("UNIV"))
				return "WAGENINGEN UNIVERSITY";
				
		if(afiliacion.contains("WARSAW") && afiliacion.contains("UNI") && afiliacion.contains("TECH"))
				return "WARSAW UNIVERSITY OF TECHNOLOGY";
				
		if(afiliacion.contains("WEIZMANN") && afiliacion.contains("INST") && afiliacion.contains("SCI"))
				return "WEIZMANN INSTITUTE OF SCIENCE";
				
		if( (afiliacion.contains("NAC")||afiliacion.contains("NAT")) && afiliacion.contains("SUR") && afiliacion.contains("UNIV"))
				return "UNIVERSIDAD NACIONAL DEL SUR"; //PONER AL FINAL
		
		if( afiliacion.compareTo("FNAL")==0 )
				return "FERMI NATIONAL ACCELERATOR LABORATORY";
				
		if( afiliacion.contains("GEODATA") )
				return "GEODATA";
				
		if( afiliacion.contains("MOTT") && afiliacion.contains("MACDONALD") )
				return "HATCH MOTT MACDONALD";
		
		if( afiliacion.contains("URS") && afiliacion.contains("CORP") )
				return "URS CORPORATION";
				
		if( afiliacion.contains("IEEE") )
				return "IEEE";
				
		if( afiliacion.contains("MWH") )
				return "MWH GLOBAL";
				
		if( afiliacion.contains("BALFOUR") && afiliacion.contains("BEATTY") && afiliacion.contains("RAIL") )
				return "BALFOUR BEATTY RAIL GMBH";

		
		if( afiliacion.startsWith("STATE KEY LAB GEOMECH") )
				return "STATE KEY LABORATORY FOR GEOMECHANICS AND DEEP UNDERGROUND ENGINEERING";
		if( afiliacion.startsWith("STATE KEY LAB SIMULAT") )
				return "STATE KEY LABORATORY OF SIMULATION AND REGULATION OF WATER CYCLE IN RIVER BASIN";
		
		if(afiliacion.contains("UNIV") && afiliacion.contains("CALIF"))
				return "UNIVERSITY OF CALIFORNIA";
		
		if(afiliacion.contains("ROBBINS") && afiliacion.contains("CO"))
				return "ROBBINS COMPANY";
		
		if( afiliacion.startsWith("SIKA ") || afiliacion.endsWith(" SIKA") || afiliacion.contains(" SIKA ") || afiliacion.compareTo("SIKA")==0)
				return "SIKA GROUP";
		
		if( afiliacion.contains("ECOLE") && afiliacion.contains("POLYTECH"))
				return "ECOLE POLYTECHNIQUE";
		
		if( afiliacion.contains("VA TECH") && afiliacion.contains("HYDRO") )
				return "VA TECH HYDRO COMPANY";
		if( afiliacion.contains("ANDRITZ") && afiliacion.contains("HYDRO") )
				return "VA TECH HYDRO COMPANY";
		
		if( afiliacion.contains("VATTENFALL") )
				return "VATTENFALL COMPANY";
		
		if( afiliacion.contains("VERBUND") && afiliacion.contains("HYDRO") )
				return "VERBUND AGENCY";
		if( afiliacion.contains("VERBUNDPLAN") )
				return "VERBUND AGENCY";
		
		if( afiliacion.contains("WEST") && afiliacion.contains("CONSULT") && afiliacion.contains("RIVER") )
				return "RIVER WEST CONSULTANTS";
				
		if( afiliacion.contains("WEST") && afiliacion.contains("CONSULT") && afiliacion.contains("RW") )
				return "RW WEST CONSULTANTS";
				
		if( afiliacion.contains("WEST") && afiliacion.contains("CONSULT") && afiliacion.contains("SIERRA") )
				return "SIERRA WEST CONSULTANTS";
		
		if( afiliacion.contains("WEST") && afiliacion.contains("CONSULT") && afiliacion.contains("RANGE") )
				return "RANGE WEST CONSULTANTS";
		
		if( afiliacion.contains("SOIL") && afiliacion.contains("MECH") && (afiliacion.contains("CENT")||afiliacion.contains("CTR")) )
				return "SOIL MECHANICS CENTER";
		
		if( afiliacion.contains("BLACK") && afiliacion.contains("VEATCH") )
				return "BLACK AND VEATCH LIMITED";
		
		if( afiliacion.contains("CHUNG") && afiliacion.contains("HUA") && afiliacion.contains("UNIV") )
				return "CHUNG HUA UNIVERSITY";
		
		if( afiliacion.contains("CHANG") && afiliacion.contains("HUA") && afiliacion.contains("UNIV") )
				return "NATIONAL CHANGHUA UNIVERSITY OF EDUCATION";
		
		if( (afiliacion.contains("CON TECH")||afiliacion.contains("CONTECH")) && afiliacion.contains("SYS") )
				return "CON TECH SYSTEMS LIMITED";
		
		if( afiliacion.contains("KLEINFELDER")  )
				return "KLEINFELDER INCORPORATED";
		
		if( afiliacion.contains("NORTHWEST") && afiliacion.contains("RES") && afiliacion.contains("INST") && afiliacion.contains("CO") )
				return "NORTHWEST RESEARCH INSTITUTE COMPANY";
				
				
		
		
		/* SUSTITUCIONES POSTERIORES */
		
		afiliacion = afiliacion.replace("UNIV OF ","UNIVERSITY OF ");
		afiliacion = afiliacion.replace("DIV OF ","DIVISION OF ");
		afiliacion = afiliacion.replace("DEPT OF ","DEPARTMENT OF ");
		afiliacion = afiliacion.replace("INST OF ","INSTITUTE OF ");
		afiliacion = afiliacion.replace("GRP OF","GROUP OF ");
		
		afiliacion = afiliacion.replace(" E CHINA "," EAST CHINA ");
		if( afiliacion.endsWith(" E CHINA") )
			afiliacion = afiliacion.replace(" E CHINA"," EAST CHINA");
		if( afiliacion.startsWith("E CHINA ") )
			afiliacion = afiliacion.replace("E CHINA ","EAST CHINA ");
		
		afiliacion = afiliacion.replace(" N CHINA "," NORTH CHINA ");
		if( afiliacion.endsWith(" N CHINA") )
			afiliacion = afiliacion.replace(" N CHINA"," NORTH CHINA");
		if( afiliacion.startsWith("N CHINA ") )
			afiliacion = afiliacion.replace("N CHINA ","NORTH CHINA ");
		
		afiliacion = afiliacion.replace(" W CHINA "," WEST CHINA ");
		if( afiliacion.endsWith(" W CHINA") )
			afiliacion = afiliacion.replace(" W CHINA"," WEST CHINA");
		if( afiliacion.startsWith("W CHINA ") )
			afiliacion = afiliacion.replace("W CHINA ","WEST CHINA ");
		
		afiliacion = afiliacion.replace(" S CHINA "," SOUTH CHINA ");
		if( afiliacion.endsWith(" S CHINA") )
			afiliacion = afiliacion.replace(" S CHINA"," SOUTH CHINA");
		if( afiliacion.startsWith("S CHINA ") )
			afiliacion = afiliacion.replace("S CHINA ","SOUTH CHINA ");
		
		if( afiliacion.contains("DIV ") )
			afiliacion = afiliacion.replace("DIV ","DIVISION OF ");
		if( afiliacion.contains("DEPT ") )
			afiliacion = afiliacion.replace("DEPT ","DEPARTMENT OF ");
		if( afiliacion.contains("GRP ") )
			afiliacion = afiliacion.replace("GRP ","GROUP OF ");
		
		afiliacion = afiliacion.replace(" TECH UNIV "," TECHNICAL UNIVERSITY ");
		if( afiliacion.startsWith("TECH UNIV ") )
			afiliacion = afiliacion.replace("TECH UNIV ","TECHNICAL UNIVERSITY ");
		if( afiliacion.endsWith(" TECH UNIV") )
			afiliacion = afiliacion.replace(" TECH UNIV"," TECHNICAL UNIVERSITY");
		
		afiliacion = afiliacion.replace(" UNIV TECH "," UNIVERSITY OF TECHNOLOGY ");
		if( afiliacion.startsWith("UNIV TECH ") )
			afiliacion = afiliacion.replace("UNIV TECH ","UNIVERSITY OF TECHNOLOGY ");
		if( afiliacion.endsWith(" UNIV TECH") )
			afiliacion = afiliacion.replace(" UNIV TECH"," UNIVERSITY OF TECHNOLOGY");		
		
		
		if( !afiliacion.contains(" AUTON") && !afiliacion.contains("FED") && !afiliacion.contains("NACIONAL") && !afiliacion.contains("NACL") && !afiliacion.contains("POLYTEC") && !afiliacion.contains("POLITEC") )
		{
			afiliacion = afiliacion.replace("UNIV ","UNIVERSITY OF ");
		}
		
		afiliacion = afiliacion.replace("UNIV AUTONOMA","UNIVERSIDAD AUTONOMA");
		afiliacion = afiliacion.replace("UNIV POLITECNICA","UNIVERSIDAD POLITECNICA");
		afiliacion = afiliacion.replace("UNIV FEDERAL","UNIVERSIDAD FEDERAL");

		afiliacion = afiliacion.replace(" REG "," REGIONS ");
		if( afiliacion.endsWith(" REG") )
			afiliacion = replaceLast(afiliacion, " REG"," REGIONS");
		if( afiliacion.startsWith("REG ") )
			afiliacion = afiliacion.replaceFirst("REG ","REGIONS ");
		
		afiliacion = afiliacion.replace(" APPL "," APPLIED ");
		if( afiliacion.endsWith(" APPL") )
			afiliacion = replaceLast(afiliacion, " APPL"," APPLIED");
		if( afiliacion.startsWith("APPL ") )
			afiliacion = afiliacion.replaceFirst("APPL ","APPLIED ");
		
		afiliacion = afiliacion.replace(" STRUCT "," STRUCTURAL ");
		if( afiliacion.endsWith(" STRUCT") )
			afiliacion = replaceLast(afiliacion, " STRUCT"," STRUCTURAL");
		if( afiliacion.startsWith("STRUCT ") )
			afiliacion = afiliacion.replaceFirst("STRUCT ","STRUCTURAL ");
		
		afiliacion = afiliacion.replace(" PUBL "," PUBLIC ");
		if( afiliacion.endsWith(" PUBL") )
			afiliacion = replaceLast(afiliacion," PUBL"," PUBLIC");
		if( afiliacion.startsWith("PUBL ") )
			afiliacion = afiliacion.replaceFirst("PUBL ","PUBLIC ");
		
		afiliacion = afiliacion.replace(" GRP "," GROUP ");
		if( afiliacion.endsWith(" GRP") )
			afiliacion = replaceLast(afiliacion," GRP"," GROUP");
		if( afiliacion.startsWith("GRP ") )
			afiliacion = afiliacion.replaceFirst("GRP ","GROUP ");
		
		afiliacion = afiliacion.replace(" ENGN "," ENGINEERING ");
		if( afiliacion.endsWith(" ENGN") )
			afiliacion = replaceLast(afiliacion," ENGN"," ENGINEERING");
		if( afiliacion.startsWith("ENGN ") )
			afiliacion = afiliacion.replaceFirst("ENGN ","ENGINEERING ");
			
		afiliacion = afiliacion.replace(" ENG "," ENGINEERING ");
		if( afiliacion.endsWith(" ENG") )
			afiliacion = replaceLast(afiliacion," ENG"," ENGINEERING");
		if( afiliacion.startsWith("ENG ") )
			afiliacion = afiliacion.replaceFirst("ENG ","ENGINEERING ");
		
		
		afiliacion = afiliacion.replace(" ENVIRONM "," ENVIRONMENTAL ");
		if( afiliacion.endsWith(" ENVIRONM") )
			afiliacion = replaceLast(afiliacion," ENVIRONM"," ENVIRONMENTAL");
		if( afiliacion.startsWith("ENVIRONM ") )
			afiliacion = afiliacion.replaceFirst("ENVIRONM ","ENVIRONMENTAL ");
		
		afiliacion = afiliacion.replace(" ENVIRON "," ENVIRONMENT ");
		if( afiliacion.endsWith(" ENVIRON") )
			afiliacion = replaceLast(afiliacion," ENVIRON"," ENVIRONMENT");
		if( afiliacion.startsWith("ENVIRON ") )
			afiliacion = afiliacion.replaceFirst("ENVIRON ","ENVIRONMENT ");

			
		afiliacion = afiliacion.replace(" UNIV "," UNIVERSITY ");
		if( afiliacion.endsWith(" UNIV") )
			afiliacion = replaceLast(afiliacion," UNIV"," UNIVERSITY");
		if( afiliacion.startsWith("UNIV ") )
			afiliacion = afiliacion.replaceFirst("UNIV ","UNIVERSITY ");
		
		afiliacion = afiliacion.replace(" ACAD "," ACADEMY ");
		if( afiliacion.endsWith(" ACAD") )
			afiliacion = replaceLast(afiliacion," ACAD"," ACADEMY");
		if( afiliacion.startsWith("ACAD ") )
			afiliacion = afiliacion.replaceFirst("ACAD ","ACADEMY ");
		
		afiliacion = afiliacion.replace(" COLL "," COLLEGE ");
		if( afiliacion.endsWith(" COLL") )
			afiliacion = replaceLast(afiliacion," COLL"," COLLEGE");
		if( afiliacion.startsWith("COLL ") )
			afiliacion = afiliacion.replaceFirst("COLL ","COLLEGE ");
		
		afiliacion = afiliacion.replace(" CENTRE "," CENTER ");
		if( afiliacion.endsWith(" CENTRE") )
			afiliacion = replaceLast(afiliacion," CENTRE"," CENTER");
		if( afiliacion.startsWith("CENTRE ") )
			afiliacion = afiliacion.replaceFirst("CENTRE ","CENTER ");
		
		afiliacion = afiliacion.replace(" CTR "," CTR ");
		if( afiliacion.endsWith(" CTR") )
			afiliacion = replaceLast(afiliacion," CTR"," CENTER");
		if( afiliacion.startsWith("CTR ") )
			afiliacion = afiliacion.replaceFirst("CTR ","CENTER ");
		
		afiliacion = afiliacion.replace(" POLYTECH "," POLYTECHNIC ");
		if( afiliacion.endsWith(" POLYTECH") )
			afiliacion = replaceLast(afiliacion," POLYTECH"," POLYTECHNIC");
		if( afiliacion.startsWith("POLYTECH ") )
			afiliacion = afiliacion.replaceFirst("POLYTECH ","POLYTECHNIC ");
		
		
		afiliacion = afiliacion.replace(" CENT "," CENTRAL ");
		if( afiliacion.endsWith(" CENT") )
			afiliacion = replaceLast(afiliacion," CENT"," CENTRAL");
		if( afiliacion.startsWith("CENT ") )
			afiliacion = afiliacion.replaceFirst("CENT ","CENTRAL ");
		
		afiliacion = afiliacion.replace(" DIV "," DIVISION ");
		if( afiliacion.endsWith(" DIV") )
			afiliacion = replaceLast(afiliacion," DIV"," DIVISION");
		if( afiliacion.startsWith("DIV ") )
			afiliacion = afiliacion.replaceFirst("DIV ","DIVISION ");
		
		
		afiliacion = afiliacion.replace(" DEPT "," DEPARTMENT ");
		if( afiliacion.endsWith(" DEPT") )
			afiliacion = replaceLast(afiliacion," DEPT"," DEPARTMENT");
		if( afiliacion.startsWith("DEPT ") )
			afiliacion = afiliacion.replaceFirst("DEPT ","DEPARTMENT ");
		
		
		afiliacion = afiliacion.replace(" INST "," INSTITUTE ");
		if( afiliacion.endsWith(" INST") )
			afiliacion = replaceLast(afiliacion," INST"," INSTITUTE");
		if( afiliacion.startsWith("INST ") )
			afiliacion = afiliacion.replaceFirst("INST ","INSTITUTE ");
		

		afiliacion = afiliacion.replace(" INC "," INCORPORATED ");
		if( afiliacion.endsWith(" INC") )
			afiliacion = replaceLast(afiliacion," INC"," INCORPORATED");
		if( afiliacion.startsWith("INC ") )
			afiliacion = afiliacion.replaceFirst("INC ","INCORPORATED ");
			
		
		afiliacion = afiliacion.replace(" CO "," COMPANY ");
		if( afiliacion.endsWith(" CO") )
			afiliacion = replaceLast(afiliacion," CO"," COMPANY");
		if( afiliacion.startsWith("CO ") )
			afiliacion = afiliacion.replaceFirst("CO ","COMPANY ");
		
		
		afiliacion = afiliacion.replace(" PTY "," LIMITED ");
		if( afiliacion.endsWith(" PTY") )
			afiliacion = replaceLast(afiliacion," PTY"," LIMITED");
		if( afiliacion.startsWith("PTY ") )
			afiliacion = afiliacion.replaceFirst("PTY ","LIMITED ");
		
		afiliacion = afiliacion.replace(" LTD "," LIMITED ");
		if( afiliacion.endsWith(" LTD") )
			afiliacion = replaceLast(afiliacion," LTD"," LIMITED");
		if( afiliacion.startsWith("LTD ") )
			afiliacion = afiliacion.replaceFirst("LTD ","LIMITED ");
		
		afiliacion = afiliacion.replace(" LLC "," LIMITED ");
		if( afiliacion.endsWith(" LLC") )
			afiliacion = replaceLast(afiliacion," LLC"," LIMITED");
		if( afiliacion.startsWith("LLC ") )
			afiliacion = afiliacion.replaceFirst("LLC ","LIMITED ");
			
		
		afiliacion = afiliacion.replace(" AGCY "," AGENCY ");
		if( afiliacion.endsWith(" AGCY") )
			afiliacion = replaceLast(afiliacion," AGCY"," AGENCY");
		if( afiliacion.startsWith("AGCY ") )
			afiliacion = afiliacion.replaceFirst("AGCY ","AGENCY ");
		
		afiliacion = afiliacion.replace(" AG "," AGENCY ");
		if( afiliacion.endsWith(" AG") )
			afiliacion = replaceLast(afiliacion," AG"," AGENCY");
		if( afiliacion.startsWith("AG ") )
			afiliacion = afiliacion.replaceFirst("AG ","AGENCY ");
			
		
		afiliacion = afiliacion.replace(" CORP "," CORPORATION ");
		if( afiliacion.endsWith(" CORP") )
			afiliacion = replaceLast(afiliacion," CORP"," CORPORATION");
		if( afiliacion.startsWith("CORP ") )
			afiliacion = afiliacion.replaceFirst("CORP ","CORPORATION ");
			
		
		afiliacion = afiliacion.replace(" IND "," INDUSTRY ");
		if( afiliacion.endsWith(" IND") )
			afiliacion = replaceLast(afiliacion," IND"," INDUSTRY");
		if( afiliacion.startsWith("IND ") )
			afiliacion = afiliacion.replaceFirst("IND ","INDUSTRY ");
			
		
		afiliacion = afiliacion.replace(" LAB "," LABORATORY ");
		if( afiliacion.endsWith(" LAB") )
			afiliacion = replaceLast(afiliacion," LAB"," LABORATORY");
		if( afiliacion.startsWith("LAB ") )
			afiliacion = afiliacion.replaceFirst("LAB ","LABORATORY ");
			
		afiliacion = afiliacion.replace(" LABS "," LABORATORIES ");
		if( afiliacion.endsWith(" LABS") )
			afiliacion = replaceLast(afiliacion," LABS"," LABORATORIES");
		if( afiliacion.startsWith("LABS ") )
			afiliacion = afiliacion.replaceFirst("LABS ","LABORATORIES ");
		
		
		afiliacion = afiliacion.replace(" TECHNOL "," TECHNOLOGY ");
		if( afiliacion.endsWith(" TECHNOL") )
			afiliacion = replaceLast(afiliacion," TECHNOL"," TECHNOLOGY");
		if( afiliacion.startsWith("TECHNOL ") )
			afiliacion = afiliacion.replaceFirst("TECHNOL ","TECHNOLOGY ");
		
		afiliacion = afiliacion.replace(" TECH "," TECHNICAL ");
		if( afiliacion.endsWith(" TECH") )
			afiliacion = replaceLast(afiliacion," TECH"," TECHNICAL");
		if( afiliacion.startsWith("TECH ") )
			afiliacion = afiliacion.replaceFirst("TECH ","TECHNICAL ");
		
		
		afiliacion = afiliacion.replace(" SCI "," SCIENCE ");
		if( afiliacion.endsWith(" SCI") )
			afiliacion = replaceLast(afiliacion," SCI"," SCIENCE");
		if( afiliacion.startsWith("SCI ") )
			afiliacion = afiliacion.replaceFirst("SCI ","SCIENCE ");
		
		
		afiliacion = afiliacion.replace(" ADV "," ADVANCED ");
		if( afiliacion.endsWith(" ADV") )
			afiliacion = replaceLast(afiliacion," ADV"," ADVANCED");
		if( afiliacion.startsWith("ADV ") )
			afiliacion = afiliacion.replaceFirst("ADV ","ADVANCED ");
		
		
		afiliacion = afiliacion.replace(" FED "," FEDERAL ");
		if( afiliacion.endsWith(" FED") )
			afiliacion = replaceLast(afiliacion," FED"," FEDERAL");
		if( afiliacion.startsWith("FED ") )
			afiliacion = afiliacion.replaceFirst("FED ","FEDERAL ");
		
		
		afiliacion = afiliacion.replace(" NATL "," NATIONAL ");
		if( afiliacion.endsWith(" NATL") )
			afiliacion = replaceLast(afiliacion," NATL"," NATIONAL");
		if( afiliacion.startsWith("NATL ") )
			afiliacion = afiliacion.replaceFirst("NATL ","NATIONAL ");
		
		afiliacion = afiliacion.replace(" INT "," INTERNATIONAL ");
		if( afiliacion.endsWith(" INT") )
			afiliacion = replaceLast(afiliacion," INT"," INTERNATIONAL");
		if( afiliacion.startsWith("INT ") )
			afiliacion = afiliacion.replaceFirst("INT ","INTERNATIONAL ");
		
		afiliacion = afiliacion.replace(" NAT "," NATIONAL ");
		if( afiliacion.endsWith(" NAT") )
			afiliacion = replaceLast(afiliacion," NAT"," NATIONAL");
		if( afiliacion.startsWith("NAT ") )
			afiliacion = afiliacion.replaceFirst("NAT ","NATIONAL ");
		
		afiliacion = afiliacion.replace(" INTL "," INTERNATIONAL ");
		if( afiliacion.endsWith(" INTL") )
			afiliacion = replaceLast(afiliacion," INTL"," INTERNATIONAL");
		if( afiliacion.startsWith("INTL ") )
			afiliacion = afiliacion.replaceFirst("INTL ","INTERNATIONAL ");
		
		afiliacion = afiliacion.replace(" SCI/TECH "," SCIENCE AND TECHNOLOGY ");
		if( afiliacion.endsWith(" SCI/TECH") )
			afiliacion = replaceLast(afiliacion," SCI/TECH"," SCIENCE AND TECHNOLOGY");
		if( afiliacion.startsWith("SCI/TECH ") )
			afiliacion = afiliacion.replaceFirst("SCI/TECH ","SCIENCE AND TECHNOLOGY ");
		
		afiliacion = afiliacion.replace(" RSRC "," RESOURCES ");
		if( afiliacion.endsWith(" RSRC") )
			afiliacion = replaceLast(afiliacion," RSRC"," RESOURCES");
		if( afiliacion.startsWith("RSRC ") )
			afiliacion = afiliacion.replaceFirst("RSRC ","RESOURCES ");
			
		
		afiliacion = afiliacion.replace(" PWR "," POWER ");
		if( afiliacion.endsWith(" PWR") )
			afiliacion = replaceLast(afiliacion," PWR"," POWER");
		if( afiliacion.startsWith("PWR ") )
			afiliacion = afiliacion.replaceFirst("PWR ","POWER ");
		
		
		afiliacion = afiliacion.replace(" GEOL "," GEOLOGY ");
		if( afiliacion.endsWith(" GEOL") )
			afiliacion = replaceLast(afiliacion," GEOL"," GEOLOGY");
		if( afiliacion.startsWith("GEOL ") )
			afiliacion = afiliacion.replaceFirst("GEOL ","GEOLOGY ");
		
		afiliacion = afiliacion.replace(" GEOG "," GEOGRAPHY ");
		if( afiliacion.endsWith(" GEOG") )
			afiliacion = replaceLast(afiliacion," GEOG"," GEOGRAPHY");
		if( afiliacion.startsWith("GEOG ") )
			afiliacion = afiliacion.replaceFirst("GEOG ","GEOGRAPHY ");
		
		
		afiliacion = afiliacion.replace(" GEOPHYS "," GEOPHYSICS ");
		if( afiliacion.endsWith(" GEOPHYS") )
			afiliacion = replaceLast(afiliacion," GEOPHYS"," GEOPHYSICS");
		if( afiliacion.startsWith("GEOPHYS ") )
			afiliacion = afiliacion.replaceFirst("GEOPHYS ","GEOPHYSICS ");
		
		
		afiliacion = afiliacion.replace(" MECH "," MECHANICS ");
		if( afiliacion.endsWith(" MECH") )
			afiliacion = replaceLast(afiliacion," MECH"," MECHANICS");
		if( afiliacion.startsWith("MECH ") )
			afiliacion = afiliacion.replaceFirst("MECH ","MECHANICS ");
		
		
		afiliacion = afiliacion.replace(" GEOTECH "," GEOTECHNICAL ");
		if( afiliacion.endsWith(" GEOTECH") )
			afiliacion = replaceLast(afiliacion," GEOTECH"," GEOTECHNICAL");
		if( afiliacion.startsWith("GEOTECH ") )
			afiliacion = afiliacion.replaceFirst("GEOTECH ","GEOTECHNICAL ");
		
		
		afiliacion = afiliacion.replace(" AGR "," AGRICULTURAL ");
		if( afiliacion.endsWith(" AGR") )
			afiliacion = replaceLast(afiliacion," AGR"," AGRICULTURAL");
		if( afiliacion.startsWith("AGR ") )
			afiliacion = afiliacion.replaceFirst("AGR ","AGRICULTURAL ");
		
		
		afiliacion = afiliacion.replace(" MIN "," MINING ");
		if( afiliacion.endsWith(" MIN") )
			afiliacion = replaceLast(afiliacion," MIN"," MINING");
		if( afiliacion.startsWith("MIN ") )
			afiliacion = afiliacion.replaceFirst("MIN ","MINING ");
		
		afiliacion = afiliacion.replace(" HYDRAUL "," HYDRAULIC ");
		if( afiliacion.endsWith(" HYDRAUL") )
			afiliacion = replaceLast(afiliacion," HYDRAUL"," HYDRAULIC");
		if( afiliacion.startsWith("HYDRAUL ") )
			afiliacion = afiliacion.replaceFirst("HYDRAUL ","HYDRAULIC ");
		
		
		afiliacion = afiliacion.replace(" MAT "," MATERIALS ");
		if( afiliacion.endsWith(" MAT") )
			afiliacion = replaceLast(afiliacion," MAT"," MATERIALS");
		if( afiliacion.startsWith("MAT ") )
			afiliacion = afiliacion.replaceFirst("MAT ","MATERIALS ");
		
		afiliacion = afiliacion.replace(" ECOL "," ECOLOGY ");
		if( afiliacion.endsWith(" ECOL") )
			afiliacion = replaceLast(afiliacion," ECOL"," ECOLOGY");
		if( afiliacion.startsWith("ECOL ") )
			afiliacion = afiliacion.replaceFirst("ECOL ","ECOLOGY ");
			
		
		afiliacion = afiliacion.replace(" AGRIC "," AGRICULTURAL ");
		if( afiliacion.endsWith(" AGRIC") )
			afiliacion = replaceLast(afiliacion," AGRIC"," AGRICULTURAL");
		if( afiliacion.startsWith("AGRIC ") )
			afiliacion = afiliacion.replaceFirst("AGRIC ","AGRICULTURAL ");
		
		
		afiliacion = afiliacion.replace(" GEOMECH "," GEOMECHANICS ");
		if( afiliacion.endsWith(" GEOMECH") )
			afiliacion = replaceLast(afiliacion," GEOMECH"," GEOMECHANICS");
		if( afiliacion.startsWith("GEOMECH ") )
			afiliacion = afiliacion.replaceFirst("GEOMECH ","GEOMECHANICS ");
			
		afiliacion = afiliacion.replace(" BIOTECH "," BIOTECHNOLOGY ");
		if( afiliacion.endsWith(" BIOTECH") )
			afiliacion = replaceLast(afiliacion," BIOTECH"," BIOTECHNOLOGY");
		if( afiliacion.startsWith("BIOTECH ") )
			afiliacion = afiliacion.replaceFirst("BIOTECH ","BIOTECHNOLOGY ");
			
		
		afiliacion = afiliacion.replace(" BIOTECHNOL "," BIOTECHNOLOGY ");
		if( afiliacion.endsWith(" BIOTECHNOL") )
			afiliacion = replaceLast(afiliacion," BIOTECHNOL"," BIOTECHNOLOGY");
		if( afiliacion.startsWith("BIOTECHNOL ") )
			afiliacion = afiliacion.replaceFirst("BIOTECHNOL ","BIOTECHNOLOGY ");
		
		afiliacion = afiliacion.replace(" ZOOL "," ZOOLOGY ");
		if( afiliacion.endsWith(" ZOOL") )
			afiliacion = replaceLast(afiliacion," ZOOL"," ZOOLOGY");
		if( afiliacion.startsWith("ZOOL ") )
			afiliacion = afiliacion.replaceFirst("ZOOL ","ZOOLOGY ");
		
		afiliacion = afiliacion.replace(" ASTRON "," ASTRONOMY ");
		if( afiliacion.endsWith(" ASTRON") )
			afiliacion = replaceLast(afiliacion," ASTRON"," ASTRONOMY");
		if( afiliacion.startsWith("ASTRON ") )
			afiliacion = afiliacion.replaceFirst("ASTRON ","ASTRONOMY ");
		
		
		afiliacion = afiliacion.replace(" HYDROELECT "," HYDROELECTRIC ");
		if( afiliacion.endsWith(" HYDROELECT") )
			afiliacion = replaceLast(afiliacion," HYDROELECT"," HYDROELECTRIC");
		if( afiliacion.startsWith("HYDROELECT ") )
			afiliacion = afiliacion.replaceFirst("HYDROELECT ","HYDROELECTRIC ");
		
		
		afiliacion = afiliacion.replace(" ELECT "," ELECTRIC ");
		if( afiliacion.endsWith(" ELECT") )
			afiliacion = replaceLast(afiliacion," ELECT"," ELECTRIC");
		if( afiliacion.startsWith("ELECT ") )
			afiliacion = afiliacion.replaceFirst("ELECT ","ELECTRIC ");
		
		
		afiliacion = afiliacion.replace(" POW "," POWER ");
		if( afiliacion.endsWith(" POW") )
			afiliacion = replaceLast(afiliacion," POW"," POWER");
		if( afiliacion.startsWith("POW ") )
			afiliacion = afiliacion.replaceFirst("POW ","POWER ");
		
		afiliacion = afiliacion.replace(" PWR "," POWER ");
		if( afiliacion.endsWith(" PWR") )
			afiliacion = replaceLast(afiliacion," PWR"," POWER");
		if( afiliacion.startsWith("PWR ") )
			afiliacion = afiliacion.replaceFirst("PWR ","POWER ");
		
		
		afiliacion = afiliacion.replace(" BLDG "," BUILDING ");
		if( afiliacion.endsWith(" BLDG") )
			afiliacion = replaceLast(afiliacion," BLDG"," BUILDING");
		if( afiliacion.startsWith("BLDG ") )
			afiliacion = afiliacion.replaceFirst("BLDG ","BUILDING ");
		
		
		afiliacion = afiliacion.replace(" STN "," STATION ");
		if( afiliacion.endsWith(" STN") )
			afiliacion = replaceLast(afiliacion," STN"," STATION");
		if( afiliacion.startsWith("STN ") )
			afiliacion = afiliacion.replaceFirst("STN ","STATION ");
		
		
		afiliacion = afiliacion.replace(" SCH "," SCHOOL ");
		if( afiliacion.endsWith(" SCH") )
			afiliacion = replaceLast(afiliacion," SCH"," SCHOOL");
		if( afiliacion.startsWith("SCH ") )
			afiliacion = afiliacion.replaceFirst("SCH ","SCHOOL ");
			
		
		
		afiliacion = afiliacion.replace(" RES "," RESEARCH ");
		if( afiliacion.endsWith(" RES") )
			afiliacion = replaceLast(afiliacion," RES"," RESEARCH");
		if( afiliacion.startsWith("RES ") )
			afiliacion = afiliacion.replaceFirst("RES ","RESEARCH ");
		
		afiliacion = afiliacion.replace(" DEVEL "," DEVELOPMENT ");
		if( afiliacion.endsWith(" DEVEL") )
			afiliacion = replaceLast(afiliacion," DEVEL"," DEVELOPMENT");
		if( afiliacion.startsWith("DEVEL ") )
			afiliacion = afiliacion.replaceFirst("DEVEL ","DEVELOPMENT ");
		
		afiliacion = afiliacion.replace(" DEV "," DEVELOPMENT ");
		if( afiliacion.endsWith(" DEV") )
			afiliacion = replaceLast(afiliacion," DEV"," DEVELOPMENT");
		if( afiliacion.startsWith("DEV ") )
			afiliacion = afiliacion.replaceFirst("DEV ","DEVELOPMENT ");
		
		afiliacion = afiliacion.replace(" MGMT "," MANAGEMENT ");
		if( afiliacion.endsWith(" MGMT") )
			afiliacion = replaceLast(afiliacion," MGMT"," MANAGEMENT");
		if( afiliacion.startsWith("MGMT ") )
			afiliacion = afiliacion.replaceFirst("MGMT ","MANAGEMENT ");
		
		afiliacion = afiliacion.replace(" SERV "," SERVICES ");
		if( afiliacion.endsWith(" SERV") )
			afiliacion = replaceLast(afiliacion," SERV"," SERVICES");
		if( afiliacion.startsWith("SERV ") )
			afiliacion = afiliacion.replaceFirst("SERV ","SERVICES ");
		
		afiliacion = afiliacion.replace(" APPLIED SCIENCE "," APPLIED SCIENCES ");
		if( afiliacion.endsWith(" APPLIED SCIENCE") )
			afiliacion = replaceLast(afiliacion," APPLIED SCIENCE"," APPLIED SCIENCES");
		if( afiliacion.startsWith("APPLIED SCIENCE ") )
			afiliacion = afiliacion.replaceFirst("APPLIED SCIENCE ","APPLIED SCIENCES ");
		
		afiliacion = afiliacion.replace("LIMITED LIMITED","LIMITED");
		afiliacion = afiliacion.replace("ACADEMY SCIENCE","ACADEMY OF SCIENCE");
		afiliacion = afiliacion.replace("UNIVERSITY APPLIED","UNIVERSITY OF APPLIED");
		afiliacion = afiliacion.replace("UNIVERSITY CIVIL","UNIVERSITY OF CIVIL");
		afiliacion = afiliacion.replace("UNIVERSITY SCIENCE","UNIVERSITY OF SCIENCE");
		afiliacion = afiliacion.replace("UNIVERSITY TECHNOLOGY","UNIVERSITY OF TECHNOLOGY");
		afiliacion = afiliacion.replace("UNIVERSITY ADVANCED","UNIVERSITY OF ADVANCED");
		
		afiliacion = afiliacion.replace("INSTITUTE SCIENCE","INSTITUTE OF SCIENCE");
		afiliacion = afiliacion.replace("INSTITUTE ENGINEERING","INSTITUTE OF ENGINEERING");
		afiliacion = afiliacion.replace("INSTITUTE TECHNOLOGY","INSTITUTE OF TECHNOLOGY");
		afiliacion = afiliacion.replace("INSTITUTE RESEARCH","INSTITUTE OF RESEARCH");
		afiliacion = afiliacion.replace("INSTITUTE ADVANCED","INSTITUTE OF ADVANCED");
		afiliacion = afiliacion.replace("INSTITUTE DEVELOPMENT","INSTITUTE FOR THE DEVELOPMENT");
		
		afiliacion = afiliacion.replace("INSTITUTE ENVIRONMENTAL","INSTITUTE OF ENVIRONMENTAL");
		afiliacion = afiliacion.replace("INSTITUTE FOOD","INSTITUTE OF FOOD");
		afiliacion = afiliacion.replace("INSTITUTE ECOLOGY","INSTITUTE OF ECOLOGY");
		afiliacion = afiliacion.replace("INSTITUTE GEO","INSTITUTE OF GEO");
		afiliacion = afiliacion.replace("INSTITUTE FRESHWATER","INSTITUTE OF FRESHWATER");
		afiliacion = afiliacion.replace("INSTITUTE WATER","INSTITUTE OF WATER");
		afiliacion = afiliacion.replace("INSTITUTE HYDRAULIC","INSTITUTE OF HYDRAULIC");
		
		afiliacion = afiliacion.replace("LABORATORY SCIENCE","LABORATORY OF SCIENCE");
		afiliacion = afiliacion.replace("LABORATORY ENGINEERING","LABORATORY OF ENGINEERING");
		afiliacion = afiliacion.replace("LABORATORY TECHNOLOGY","LABORATORY OF TECHNOLOGY");
		afiliacion = afiliacion.replace("LABORATORY RESEARCH","LABORATORY OF RESEARCH");
		afiliacion = afiliacion.replace("LABORATORY ADVANCED","LABORATORY OF ADVANCED");
		afiliacion = afiliacion.replace("LABORATORY DEVELOPMENT","LABORATORY FOR THE DEVELOPMENT");
		
		afiliacion = afiliacion.replace("LABORATORY PHYS","LABORATORY OF PHYS");
		afiliacion = afiliacion.replace("LABORATORY ENVIRONMENTAL","LABORATORY OF ENVIRONMENTAL");
		afiliacion = afiliacion.replace("LABORATORY FOOD","LABORATORY OF FOOD");
		afiliacion = afiliacion.replace("LABORATORY ECOLOGY","LABORATORY OF ECOLOGY");
		afiliacion = afiliacion.replace("LABORATORY GEO","LABORATORY OF GEO");
		afiliacion = afiliacion.replace("LABORATORY FRESHWATER","LABORATORY OF FRESHWATER");
		afiliacion = afiliacion.replace("LABORATORY WATER","LABORATORY OF WATER");
		afiliacion = afiliacion.replace("LABORATORY HYDRAULIC","LABORATORY OF HYDRAULIC");
		
		afiliacion = afiliacion.replace("CENTER SCIENCE","CENTER OF SCIENCE");
		afiliacion = afiliacion.replace("CENTER ENGINEERING","CENTER OF ENGINEERING");
		afiliacion = afiliacion.replace("CENTER TECHNOLOGY","CENTER OF TECHNOLOGY");
		afiliacion = afiliacion.replace("CENTER RESEARCH","CENTER OF RESEARCH");
		afiliacion = afiliacion.replace("CENTER ADVANCED","CENTER OF ADVANCED");
		afiliacion = afiliacion.replace("CENTER DEVELOPMENT","CENTER FOR THE DEVELOPMENT");
		
		afiliacion = afiliacion.replace("CENTER PHYS","CENTER OF PHYS");
		afiliacion = afiliacion.replace("CENTER ENVIRONMENTAL","CENTER OF ENVIRONMENTAL");
		afiliacion = afiliacion.replace("CENTER FOOD","CENTER OF FOOD");
		afiliacion = afiliacion.replace("CENTER ECOLOGY","CENTER OF ECOLOGY");
		afiliacion = afiliacion.replace("CENTER GEO","CENTER OF GEO");
		afiliacion = afiliacion.replace("CENTER FRESHWATER","CENTER OF FRESHWATER");
		afiliacion = afiliacion.replace("CENTER WATER","CENTER OF WATER");
		afiliacion = afiliacion.replace("CENTER HYDRAULIC","CENTER OF HYDRAULIC");
		
		afiliacion = afiliacion.replace("SCHOOL SCIENCE","SCHOOL OF SCIENCE");
		afiliacion = afiliacion.replace("SCHOOL ENGINEERING","SCHOOL OF ENGINEERING");
		afiliacion = afiliacion.replace("SCHOOL TECHNOLOGY","SCHOOL OF TECHNOLOGY");
		afiliacion = afiliacion.replace("SCHOOL RESEARCH","SCHOOL OF RESEARCH");
		afiliacion = afiliacion.replace("SCHOOL ADVANCED","SCHOOL OF ADVANCED");
		afiliacion = afiliacion.replace("SCHOOL DEVELOPMENT","SCHOOL FOR THE DEVELOPMENT");
		
		afiliacion = afiliacion.replace("SCHOOL PHYS","SCHOOL OF PHYS");
		afiliacion = afiliacion.replace("SCHOOL ENVIRONMENTAL","SCHOOL OF ENVIRONMENTAL");
		afiliacion = afiliacion.replace("SCHOOL FOOD","SCHOOL OF FOOD");
		afiliacion = afiliacion.replace("SCHOOL ECOLOGY","SCHOOL OF ECOLOGY");
		afiliacion = afiliacion.replace("SCHOOL GEO","SCHOOL OF GEO");
		afiliacion = afiliacion.replace("SCHOOL FRESHWATER","SCHOOL OF FRESHWATER");
		afiliacion = afiliacion.replace("SCHOOL WATER","SCHOOL OF WATER");
		afiliacion = afiliacion.replace("SCHOOL HYDRAULIC","SCHOOL OF HYDRAULIC");
		
		afiliacion = afiliacion.replace("SCIENCE TECHNOLOGY","SCIENCE AND TECHNOLOGY");
		
		afiliacion = afiliacion.replace("ACADEMY TECHNOLOGY","ACADEMY OF TECHNOLOGY");
		
		
		//System.out.println("SE HIZO UNA SUSTITUCIÓN");
		
		if( bandera!= 1) // No sé qué es (puede ser una compañía)
				afiliacion = "*" + afiliacion;
		
		return afiliacion;
	}// getNombreCompletoInstitucion
	
	public static String replaceLast(String string, String toReplace, String replacement) 
	{
		int pos = string.lastIndexOf(toReplace);
		if (pos > -1) 
		{
			return string.substring(0, pos) + replacement + string.substring(pos + toReplace.length(), string.length());
		} 
		else 
			return string;
	}
}
 
 
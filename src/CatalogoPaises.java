/**	
 * @(#)CatalogoPaises.java
 *
 * Contiene los pa�ses "reconocidos" con sus nombres oficiales en el SCIT
 * IMPORTANTE: Al agregar o quitar un pa�s del listado, hay que modificar el valor de NUMERO_PAISES
 *
 * @author Hern�ndez Dom�nguez Laura Elena
 * @version 1.0 (25/Febrero/2012)
 */

//Devuelve el contenido de un archivo de texto en una cadena
public class CatalogoPaises
{
	private String [] paises;
	private final int NUMERO_PAISES=230; 
	
	public CatalogoPaises( )
	{
		obtenerPaises();
	}
	
	String validaPais( String pais )
	{
		// Reemplazar algunos pa�ses:
			if( pais.contains("ENGLAND") == true )
				pais = "UNITED KINGDOM";
			
			if( pais.contains("WALES") == true )
				pais = "UNITED KINGDOM";
			
			if( pais.contains("SCOTLAND") == true )
				pais = "UNITED KINGDOM";
			
			if( pais.contains("IRELAND") == true )
				pais = "UNITED KINGDOM";
				
			if( pais.endsWith("UK") == true )
				pais = "UNITED KINGDOM";
				
			if( pais.endsWith("USA") == true )
				pais = "UNITED STATES OF AMERICA";
			
			if( pais.contains("RUSSIA") == true )
				pais = "RUSSIA";
				
			if( pais.endsWith("UNITED STATES") == true )
				pais = "UNITED STATES OF AMERICA";
				
			if( pais.contains("CHINA") == true )
				pais = "CHINA";
			
			if( pais.contains("SOUTH KOREA") == true )
				pais = "REPUBLIC OF KOREA (SOUTH KOREA)";
				
			if( pais.contains("PHILIPPINES") == true )
				pais = "REPUBLIC OF THE PHILIPPINES";
				
			if( pais.contains("NETHERLANDS") == true )
				pais = "NETHERLANDS";
			
			if( pais.contains("LUXEMBOURG") == true )
				pais = "LUXEMBURG";
			
			if( pais.contains("PRAGUE") == true )
				pais = "CZECH REPUBLIC";
	
		//int idPais=0;
		for ( int i=0; i<paises.length; i++ )
		{
			if( pais.contains( paises[i] ) )
				return paises[i];
		}
		
		//return "*" + pais;
		return "NO DISPONIBLE";
	}
	
	void obtenerPaises( )
	{
		paises = new String [NUMERO_PAISES];

		int contadorPaises=0;

		paises[contadorPaises] = "AFGHANISTAN";				contadorPaises++;
		paises[contadorPaises] = "ALBANIA";					contadorPaises++;
		paises[contadorPaises] = "GERMANY";					contadorPaises++;
		paises[contadorPaises] = "ANDORRA";					contadorPaises++;
		paises[contadorPaises] = "ANGOLA";					contadorPaises++;
		paises[contadorPaises] = "ANTIGUA AND BARBUDA";		contadorPaises++;
		paises[contadorPaises] = "ANTILLES";				contadorPaises++;
		paises[contadorPaises] = "NETHERLANDS ANTILLES";	contadorPaises++;
		paises[contadorPaises] = "SAUDI ARABIA";			contadorPaises++;
		paises[contadorPaises] = "SVALBARD";				contadorPaises++;
		paises[contadorPaises] = "ALGERIA";					contadorPaises++;
		paises[contadorPaises] = "ARGENTINA";				contadorPaises++;
		paises[contadorPaises] = "ARMENIA";					contadorPaises++;
		paises[contadorPaises] = "ARUBA";					contadorPaises++;
		paises[contadorPaises] = "AUSTRALIA";				contadorPaises++;
		paises[contadorPaises] = "AUSTRIA";					contadorPaises++;
		paises[contadorPaises] = "AZERBAIJAN";				contadorPaises++;
		paises[contadorPaises] = "BAHAMAS";					contadorPaises++;
		paises[contadorPaises] = "BAHRAIN";					contadorPaises++;
		paises[contadorPaises] = "BANGLADESH";				contadorPaises++;
		paises[contadorPaises] = "BARBADOS";				contadorPaises++;
		paises[contadorPaises] = "BELGIUM";					contadorPaises++;
		paises[contadorPaises] = "BELIZE";					contadorPaises++;
		paises[contadorPaises] = "BERMUDA";					contadorPaises++;
		paises[contadorPaises] = "BHUTAN";					contadorPaises++;
		paises[contadorPaises] = "BELARUS";					contadorPaises++;
		paises[contadorPaises] = "BOLIVIA";					contadorPaises++;
		paises[contadorPaises] = "BOSNIA AND HERZEGOVINA";	contadorPaises++;
		paises[contadorPaises] = "BOTSWANA";				contadorPaises++;
		paises[contadorPaises] = "BRAZIL";					contadorPaises++;
		paises[contadorPaises] = "BRUNEI";					contadorPaises++;
		paises[contadorPaises] = "BULGARIA";				contadorPaises++;
		paises[contadorPaises] = "BURKINA FASO";			contadorPaises++;
		paises[contadorPaises] = "BURUNDI";					contadorPaises++;
		paises[contadorPaises] = "CAPE VERDE";				contadorPaises++;
		paises[contadorPaises] = "CAMBODIA";				contadorPaises++;
		paises[contadorPaises] = "CAMEROON";				contadorPaises++;
		paises[contadorPaises] = "CANADA";					contadorPaises++;
		paises[contadorPaises] = "CHAD";					contadorPaises++;
		paises[contadorPaises] = "CHILE";					contadorPaises++;
		paises[contadorPaises] = "CHINA";					contadorPaises++;
		paises[contadorPaises] = "CYPRUS";					contadorPaises++;
		paises[contadorPaises] = "VATICAN CITY";			contadorPaises++;
		paises[contadorPaises] = "COLOMBIA";				contadorPaises++;
		paises[contadorPaises] = "COMOROS";					contadorPaises++;
		paises[contadorPaises] = "CONGO";					contadorPaises++;
		paises[contadorPaises] = "NORTH KOREA";				contadorPaises++;
		paises[contadorPaises] = "COTE DIVOIRE";			contadorPaises++;
		paises[contadorPaises] = "COSTA RICA";				contadorPaises++;
		paises[contadorPaises] = "CROATIA";					contadorPaises++;
		paises[contadorPaises] = "CUBA";					contadorPaises++;
		paises[contadorPaises] = "BENIN";					contadorPaises++;
		paises[contadorPaises] = "DENMARK";					contadorPaises++;
		paises[contadorPaises] = "DJIBOUTI";				contadorPaises++;
		paises[contadorPaises] = "DOMINICA";				contadorPaises++;
		paises[contadorPaises] = "ECUADOR";					contadorPaises++;
		paises[contadorPaises] = "EGYPT";					contadorPaises++;
		paises[contadorPaises] = "SALVADOR";				contadorPaises++;
		paises[contadorPaises] = "UNITED ARAB EMIRATES";	contadorPaises++;
		paises[contadorPaises] = "ERITREA";					contadorPaises++;
		paises[contadorPaises] = "SLOVAKIA";				contadorPaises++;
		paises[contadorPaises] = "SLOVENIA";				contadorPaises++;
		paises[contadorPaises] = "SPAIN";					contadorPaises++;
		paises[contadorPaises] = "UNITED STATES OF AMERICA";	contadorPaises++;
		paises[contadorPaises] = "ESTONIA";					contadorPaises++;
		paises[contadorPaises] = "ETHIOPIA";				contadorPaises++;
		paises[contadorPaises] = "RUSSIA";					contadorPaises++;
		paises[contadorPaises] = "MALAY STATES";			contadorPaises++;
		paises[contadorPaises] = "FIJI";					contadorPaises++;
		paises[contadorPaises] = "REPUBLIC OF THE PHILIPPINES";		contadorPaises++;
		paises[contadorPaises] = "FINLAND";					contadorPaises++;
		paises[contadorPaises] = "FRANCE";					contadorPaises++;
		paises[contadorPaises] = "GABON";					contadorPaises++;
		paises[contadorPaises] = "GAMBIA";					contadorPaises++;
		paises[contadorPaises] = "GEORGIA";					contadorPaises++;
		paises[contadorPaises] = "GHANA";					contadorPaises++;
		paises[contadorPaises] = "GIBRALTAR";				contadorPaises++;
		paises[contadorPaises] = "GRENADA";					contadorPaises++;
		paises[contadorPaises] = "GREECE";					contadorPaises++;
		paises[contadorPaises] = "GREENLAND";				contadorPaises++;
		paises[contadorPaises] = "GUADELOUPE";				contadorPaises++;
		paises[contadorPaises] = "GUATEMALA";				contadorPaises++;
		paises[contadorPaises] = "GUINEA";					contadorPaises++;
		paises[contadorPaises] = "GUINEA BISSAU";			contadorPaises++;
		paises[contadorPaises] = "EQUATORIAL GUINEA";		contadorPaises++;
		paises[contadorPaises] = "GUIANA";					contadorPaises++;
		paises[contadorPaises] = "FRENCH GUIANA";			contadorPaises++;
		paises[contadorPaises] = "HAITI";					contadorPaises++;
		paises[contadorPaises] = "HONDURAS";				contadorPaises++;
		paises[contadorPaises] = "HONG KONG";				contadorPaises++;
		paises[contadorPaises] = "HUNGARY";					contadorPaises++;
		paises[contadorPaises] = "INDIA";					contadorPaises++;
		paises[contadorPaises] = "INDONESIA";				contadorPaises++;
		paises[contadorPaises] = "IRAQ";					contadorPaises++;
		paises[contadorPaises] = "IRAN";					contadorPaises++;
		paises[contadorPaises] = "IRELAND";					contadorPaises++;
		paises[contadorPaises] = "ISLE OF MAN";				contadorPaises++;
		paises[contadorPaises] = "ICELAND";					contadorPaises++;
		paises[contadorPaises] = "CHANNEL ISLANDS";			contadorPaises++;
		paises[contadorPaises] = "CAYMAN ISLANDS";			contadorPaises++;
		paises[contadorPaises] = "COOK ISLANDS";			contadorPaises++;
		paises[contadorPaises] = "FAEROES";					contadorPaises++;
		paises[contadorPaises] = "FALKLAND ISLANDS";		contadorPaises++;
		paises[contadorPaises] = "NORTHERN MARIANA ISLANDS";	contadorPaises++;
		paises[contadorPaises] = "MARSHALL ISLANDS";		contadorPaises++;
		paises[contadorPaises] = "MOLDOVA";					contadorPaises++;
		paises[contadorPaises] = "SOLOMON ISLANDS";			contadorPaises++;
		paises[contadorPaises] = "TURKS AND CAICOS ISLANDS";	contadorPaises++;
		paises[contadorPaises] = "BRITISH VIRGIN ISLANDS";		contadorPaises++;
		paises[contadorPaises] = "WALLIS AND FUTUNA ISLANDS";	contadorPaises++;
		paises[contadorPaises] = "ISRAEL";					contadorPaises++;
		paises[contadorPaises] = "ITALY";					contadorPaises++;
		paises[contadorPaises] = "JAMAICA";					contadorPaises++;
		paises[contadorPaises] = "JAPAN";					contadorPaises++;
		paises[contadorPaises] = "JORDAN";					contadorPaises++;
		paises[contadorPaises] = "KAZAKHSTAN";				contadorPaises++;
		paises[contadorPaises] = "KENYA";					contadorPaises++;
		paises[contadorPaises] = "KYRGYZSTAN";				contadorPaises++;
		paises[contadorPaises] = "KIRIBATI";				contadorPaises++;
		paises[contadorPaises] = "KUWAIT";					contadorPaises++;
		paises[contadorPaises] = "LAOS";					contadorPaises++;
		paises[contadorPaises] = "LESOTHO";					contadorPaises++;
		paises[contadorPaises] = "LATVIA";					contadorPaises++;
		paises[contadorPaises] = "LEBANON";					contadorPaises++;
		paises[contadorPaises] = "LIBERIA";					contadorPaises++;
		paises[contadorPaises] = "LIBYA";					contadorPaises++;
		paises[contadorPaises] = "LIECHTENSTEIN";			contadorPaises++;
		paises[contadorPaises] = "LITHUANIA";				contadorPaises++;
		paises[contadorPaises] = "LUXEMBURG";				contadorPaises++;
		paises[contadorPaises] = "MACAO";					contadorPaises++;
		paises[contadorPaises] = "MACEDONIA";				contadorPaises++;
		paises[contadorPaises] = "MADAGASCAR";				contadorPaises++;
		paises[contadorPaises] = "MALAYSIA";				contadorPaises++;
		paises[contadorPaises] = "MALAWI";					contadorPaises++;
		paises[contadorPaises] = "MALDIVES";				contadorPaises++;
		paises[contadorPaises] = "MALI";					contadorPaises++;
		paises[contadorPaises] = "MALTA";					contadorPaises++;
		paises[contadorPaises] = "MOROCCO";					contadorPaises++;
		paises[contadorPaises] = "MARTINIQUE";				contadorPaises++;
		paises[contadorPaises] = "MAURITIUS";				contadorPaises++;
		paises[contadorPaises] = "MAURITANIA";				contadorPaises++;
		paises[contadorPaises] = "MAYOTTE";					contadorPaises++;
		paises[contadorPaises] = "MEXICO";					contadorPaises++;
		paises[contadorPaises] = "MICRONESIA";				contadorPaises++;
		paises[contadorPaises] = "MONACO";					contadorPaises++;
		paises[contadorPaises] = "MONGOLIA";				contadorPaises++;
		paises[contadorPaises] = "MONTSERRAT";				contadorPaises++;
		paises[contadorPaises] = "MOZAMBIQUE";				contadorPaises++;
		paises[contadorPaises] = "MYANMAR";					contadorPaises++;
		paises[contadorPaises] = "NAMIBIA";					contadorPaises++;
		paises[contadorPaises] = "NAURU";					contadorPaises++;
		paises[contadorPaises] = "NEPAL";					contadorPaises++;
		paises[contadorPaises] = "NICARAGUA";				contadorPaises++;
		paises[contadorPaises] = "NIGER";					contadorPaises++;
		paises[contadorPaises] = "NIGERIA";					contadorPaises++;
		paises[contadorPaises] = "NORWAY";					contadorPaises++;
		paises[contadorPaises] = "NEW CALEDONIA";			contadorPaises++;
		paises[contadorPaises] = "NEW ZEALAND";				contadorPaises++;
		paises[contadorPaises] = "POLYNESIA";				contadorPaises++;
		paises[contadorPaises] = "MICRONESIA";				contadorPaises++;
		paises[contadorPaises] = "MELANESIA";				contadorPaises++;
		paises[contadorPaises] = "OMAN";					contadorPaises++;
		paises[contadorPaises] = "NETHERLANDS";				contadorPaises++;
		paises[contadorPaises] = "PAKISTAN";				contadorPaises++;
		paises[contadorPaises] = "PALAU ISLANDS";			contadorPaises++;
		paises[contadorPaises] = "PALESTINE";				contadorPaises++;
		paises[contadorPaises] = "PANAMA";					contadorPaises++;
		paises[contadorPaises] = "PAPUA NEW GUINEA";		contadorPaises++;
		paises[contadorPaises] = "PARAGUAY";				contadorPaises++;
		paises[contadorPaises] = "PERU";					contadorPaises++;
		paises[contadorPaises] = "PITCAIRN ISLAND";			contadorPaises++;
		paises[contadorPaises] = "FRENCH POLYNESIA";		contadorPaises++;
		paises[contadorPaises] = "POLAND";					contadorPaises++;
		paises[contadorPaises] = "PORTUGAL";				contadorPaises++;
		paises[contadorPaises] = "PUERTO RICO";				contadorPaises++;
		paises[contadorPaises] = "QATAR";					contadorPaises++;
		paises[contadorPaises] = "UNITED KINGDOM";			contadorPaises++;
		paises[contadorPaises] = "CZECH REPUBLIC";			contadorPaises++;
		paises[contadorPaises] = "DOMINICAN REPUBLIC";		contadorPaises++;
		paises[contadorPaises] = "CENTRAL AFRICAN REPUBLIC";	contadorPaises++;
		paises[contadorPaises] = "REUNION";					contadorPaises++;
		paises[contadorPaises] = "RWANDA";					contadorPaises++;
		paises[contadorPaises] = "ROMANIA";					contadorPaises++;
		paises[contadorPaises] = "SAMOA";					contadorPaises++;
		paises[contadorPaises] = "SAINT CHRISTOPHER NEVIS";		contadorPaises++;
		paises[contadorPaises] = "SAINT PIERRE AND MIQUELON";	contadorPaises++;
		paises[contadorPaises] = "SAINT VINCENT AND THE GRENADINES";	contadorPaises++;
		paises[contadorPaises] = "SAINT HELENA";			contadorPaises++;
		paises[contadorPaises] = "SAINT LUCIA";				contadorPaises++;
		paises[contadorPaises] = "SAO TOME E PRINCIPE";		contadorPaises++;
		paises[contadorPaises] = "SENEGAL";					contadorPaises++;
		paises[contadorPaises] = "SEYCHELLES";				contadorPaises++;
		paises[contadorPaises] = "SIERRA LEONE";			contadorPaises++;
		paises[contadorPaises] = "SINGAPORE";				contadorPaises++;
		paises[contadorPaises] = "SYRIA";					contadorPaises++;
		paises[contadorPaises] = "SOMALIA";					contadorPaises++;
		paises[contadorPaises] = "SOUTH AFRICA";			contadorPaises++;
		paises[contadorPaises] = "SRI LANKA";				contadorPaises++;
		paises[contadorPaises] = "SUDAN";					contadorPaises++;
		paises[contadorPaises] = "SWEDEN";					contadorPaises++;
		paises[contadorPaises] = "SWITZERLAND";				contadorPaises++;
		paises[contadorPaises] = "SURINAM";					contadorPaises++;
		paises[contadorPaises] = "SWAZILAND";				contadorPaises++;
		paises[contadorPaises] = "THAILAND";				contadorPaises++;
		paises[contadorPaises] = "TAIWAN";					contadorPaises++;
		paises[contadorPaises] = "TAJIKISTAN";				contadorPaises++;
		paises[contadorPaises] = "TANZANIA";				contadorPaises++;
		paises[contadorPaises] = "EAST TIMOR";				contadorPaises++;
		paises[contadorPaises] = "TOGO";					contadorPaises++;
		paises[contadorPaises] = "TONGA";					contadorPaises++;
		paises[contadorPaises] = "TRINIDAD AND TOBAGO";		contadorPaises++;
		paises[contadorPaises] = "TUNISIA";					contadorPaises++;
		paises[contadorPaises] = "TURKMENISTAN";			contadorPaises++;
		paises[contadorPaises] = "TURKEY";					contadorPaises++;
		paises[contadorPaises] = "TUVALU";					contadorPaises++;
		paises[contadorPaises] = "UGANDA";					contadorPaises++;
		paises[contadorPaises] = "UKRAINE";					contadorPaises++;
		paises[contadorPaises] = "URUGUAY";					contadorPaises++;
		paises[contadorPaises] = "UZBEKISTAN";				contadorPaises++;
		paises[contadorPaises] = "VANUATU";					contadorPaises++;
		paises[contadorPaises] = "VENEZUELA";				contadorPaises++;
		paises[contadorPaises] = "VIETNAM";					contadorPaises++;
		paises[contadorPaises] = "YEMEN REPUBLIC";			contadorPaises++;
		paises[contadorPaises] = "YUGOSLAVIA";				contadorPaises++;
		paises[contadorPaises] = "ZAMBIA";					contadorPaises++;
		paises[contadorPaises] = "ZIMBABWE";				contadorPaises++;
		paises[contadorPaises] = "REPUBLIC OF KOREA (SOUTH KOREA)";		contadorPaises++;
		paises[contadorPaises] = "BANGKOK";					contadorPaises++;
		paises[contadorPaises] = "EUROPEAN UNION";			contadorPaises++;
		paises[contadorPaises] = "SERBIA";					contadorPaises++;
	}// void obtenerPaises( )
	
}
 
 
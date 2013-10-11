import java.util.Map;
import java.util.Comparator;

public class MiComparador implements Comparator
{
	public int compare(Object objeto1, Object objeto2)
	{
		int resultado=0; 
		Map.Entry entry1 = (Map.Entry)objeto1 ;
		Map.Entry entry2 = (Map.Entry)objeto2 ; //Sort based on keys.
		
		String word1=(String)entry1.getKey();
		String word2=(String)entry2.getKey();
		
		//Sort String in an alphabetical order
		resultado=word1.compareToIgnoreCase(word2);
		/*
		Integer value1 = (Integer)entry1.getValue();
		Integer value2 = (Integer)entry2.getValue();

		if( value1.compareTo(value2)==0 ) //Son iguales
		{
			String word1=(String)entry1.getKey();
			String word2=(String)entry2.getKey();

			//Sort String in an alphabetical order
			resultado=word1.compareToIgnoreCase(word2);
		} 
		else
		{
			//Sort values in a descending order
			resultado=value1.compareTo( value2 );
			return resultado;
		}*/
		
		return resultado;
	}// public int compare(Object objeto1, Object objeto2)
}
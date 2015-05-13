package unicam.reduceParallelGateway;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import unicam.utils.ExtendedActivity;



public class AdjacentTable {
	private Hashtable<String, ArrayList<ExtendedActivity>> adjt; 

	
	public AdjacentTable()
		{ adjt = new  Hashtable<String, ArrayList<ExtendedActivity>> ();  }
	
	public ArrayList<ExtendedActivity> get (String string)
		{
		 return adjt.get(string);
		}
	
	/**@param key sender
	 * @param value ct
	 * */
	public synchronized void put (String key, ExtendedActivity value)
		{
		 ArrayList<ExtendedActivity> values = adjt.get(key);
		 if (values == null)
		 	{
			 values = new ArrayList<ExtendedActivity>();
			 values.add(value);
			 adjt.put(key, values); 
		 	}
		 else
		 	{
			 values.add(value);
		 	}
		}
	
	public  Enumeration<ArrayList<ExtendedActivity>> getValues()
	{
	 return adjt.elements();
	}
}

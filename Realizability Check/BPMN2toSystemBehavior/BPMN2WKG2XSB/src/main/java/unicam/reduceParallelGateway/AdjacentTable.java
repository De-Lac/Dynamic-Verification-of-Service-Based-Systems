package unicam.reduceParallelGateway;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import unicam.workflowgraph.MessageExchange;




public class AdjacentTable {
	private Hashtable<String, ArrayList<MessageExchange>> adjt; 

	
	public AdjacentTable()
		{ adjt = new  Hashtable<String, ArrayList<MessageExchange>> ();  }
	
	public ArrayList<MessageExchange> get (String string)
		{
		 return adjt.get(string);
		}
	
	/**@param key sender
	 * @param value ct
	 * */
	public synchronized void put (String key, MessageExchange value)
		{
		 ArrayList<MessageExchange> values = adjt.get(key);
		 if (values == null)
		 	{
			 values = new ArrayList<MessageExchange>();
			 values.add(value);
			 adjt.put(key, values); 
		 	}
		 else
		 	{
			 values.add(value);
		 	}
		}
	
	public  Enumeration<ArrayList<MessageExchange>> getValues()
	{
	 return adjt.elements();
	}
}

package unicam.reduceParallelGateway;
import java.util.ArrayList;

import unicam.workflowgraph.MessageExchange;



public class Combinatorics 
{

	   
	   public static ArrayList<ArrayList<MessageExchange>> getAll(ArrayList <MessageExchange> stringa){  
		   ArrayList<ArrayList<MessageExchange>> result = new ArrayList<ArrayList<MessageExchange>>();
	      for( int i=1; i<=stringa.size(); i++){ 
	         result.addAll(get(stringa,i));
	      }
	      result.add(null); // empty permutation
	      return result;
	   }
	   
	   private static ArrayList<ArrayList<MessageExchange>> get(ArrayList <MessageExchange> stringa, int len){ 
		   ArrayList<MessageExchange> base = new ArrayList<MessageExchange>();
		for(MessageExchange n:stringa){
	         base.add(n); 
	      }
		ArrayList<ArrayList<MessageExchange>> result = new ArrayList<ArrayList<MessageExchange>>();
	      fill(base,new ArrayList<MessageExchange>(),len, result); 
	      return result;
	   }
	   
	   private static void fill(ArrayList<MessageExchange> base, ArrayList<MessageExchange> current, int len, ArrayList<ArrayList<MessageExchange>> perms){
	     if( current.size()>= len ){
	         perms.add(current);
	         return;
	      }
	      for( MessageExchange n: base){
	    	  ArrayList<MessageExchange> newCurrent = new ArrayList<MessageExchange>(current);
	         newCurrent.add(n);
	         ArrayList<MessageExchange> newBase = new ArrayList<MessageExchange>(base);
	         newBase.remove(n);
	         fill(newBase, newCurrent, len, perms);
	      }
	   }

}

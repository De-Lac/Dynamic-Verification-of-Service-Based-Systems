package unicam.reduceParallelGateway;
import java.util.ArrayList;

import unicam.utils.ExtendedActivity;



public class Combinatorics 
{

	   
	   public static ArrayList<ArrayList<ExtendedActivity>> getAll(ArrayList <ExtendedActivity> stringa){  
		   ArrayList<ArrayList<ExtendedActivity>> result = new ArrayList<ArrayList<ExtendedActivity>>();
	      for( int i=1; i<=stringa.size(); i++){ 
	         result.addAll(get(stringa,i));
	      }
	      result.add(null); // empty permutation
	      return result;
	   }
	   
	   private static ArrayList<ArrayList<ExtendedActivity>> get(ArrayList <ExtendedActivity> stringa, int len){ 
		   ArrayList<ExtendedActivity> base = new ArrayList<ExtendedActivity>();
		for(ExtendedActivity n:stringa){
	         base.add(n); 
	      }
		ArrayList<ArrayList<ExtendedActivity>> result = new ArrayList<ArrayList<ExtendedActivity>>();
	      fill(base,new ArrayList<ExtendedActivity>(),len, result); 
	      return result;
	   }
	   
	   private static void fill(ArrayList<ExtendedActivity> base, ArrayList<ExtendedActivity> current, int len, ArrayList<ArrayList<ExtendedActivity>> perms){
	     if( current.size()>= len ){
	         perms.add(current);
	         return;
	      }
	      for( ExtendedActivity n: base){
	    	  ArrayList<ExtendedActivity> newCurrent = new ArrayList<ExtendedActivity>(current);
	         newCurrent.add(n);
	         ArrayList<ExtendedActivity> newBase = new ArrayList<ExtendedActivity>(base);
	         newBase.remove(n);
	         fill(newBase, newCurrent, len, perms);
	      }
	   }

}

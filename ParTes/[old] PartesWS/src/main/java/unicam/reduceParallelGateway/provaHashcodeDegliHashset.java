package unicam.reduceParallelGateway;

import java.util.ArrayList;
import java.util.HashSet;


public class provaHashcodeDegliHashset 
{
 protected HashSet<HashSet<String>> insieme;
 
 
 public provaHashcodeDegliHashset(ArrayList<HashSet<String>> t)
 {
	 insieme = new HashSet<HashSet<String>>(t.size()); 
	 for (HashSet<String> n:t)
	 	{insieme.add(n);}
	 
 }


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((insieme == null) ? 0 : insieme.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	provaHashcodeDegliHashset other = (provaHashcodeDegliHashset) obj;
	if (insieme == null) {
		if (other.insieme != null)
			return false;
	} else if (!insieme.equals(other.insieme))
		return false;
	return true;
}
 
 
public static void main (String[] args)
{
 HashSet<String> uno = new HashSet<String>(); 
 uno.add("ab"); uno.add("a"); uno.add("ac"); uno.add("d");
 
 HashSet<String> due = new HashSet<String>(); 
 due.add("a"); due.add("ab"); due.add("d"); due.add("ac");
 
 
ArrayList<HashSet<String>> t = new ArrayList<HashSet<String>>();
t.add(uno); 
provaHashcodeDegliHashset prova = new provaHashcodeDegliHashset(t);
 
 if (prova.insieme.contains(due))
 	{System.out.println("true");}
 else
 	{System.out.println("false");}
 
 System.out.println("hashcode uno "+uno.hashCode());
 System.out.println("hashcode due "+due.hashCode());
}


 
}

package unicam.reduceParallelGateway;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import partes.service.PartesMain;
import partes.utils.PartesConf;
import unicam.utils.ExtendedActivity;
import unicam.utils.IOUtils4Mac;




public class AffectionsGraph 
{
 private Hashtable<ExtendedActivity, GraphNode> CTs;
 private AdjacentTable adjTable;
 private ArrayList<GraphNode> startingGNs;
 private ArrayList<GraphNode> endingGNs;
 
 //how many times the rpst has been rebuild
 private static int iteration_affGraph = 0;
 private Log log = LogFactory.getLog(AffectionsGraph.class);

 
 
 public AffectionsGraph ()
 	{
	 adjTable = new AdjacentTable();
	 CTs = new  Hashtable<ExtendedActivity, GraphNode>();
	 startingGNs = new ArrayList<GraphNode>();
	 endingGNs = new ArrayList<GraphNode>();
 	}
 
 
public Enumeration<GraphNode> getCTs() 
  {return CTs.elements();}


/**
 * @param affecting ct
 * @param affected ct
 * affecting ~~> affected
 * */
public void createAffectTransition(ExtendedActivity affecting, ExtendedActivity affected)
	{
	 printDebug(affecting.getName()+ " ~~~> "+affected.getName());
	 CTs.get(affected).addAtIn(CTs.get(affecting));
	}

/**add the node to the graph, and fill the adjacency table*/
public synchronized void addCT(GraphNode gn) 
 {
  gn.setGraph(this);
  CTs.put(gn.getCt(), gn); 
  adjTable.put(gn.getCt().getSender().getName(), gn.getCt()); // used for affection transition
 }

public void addStartingGN(GraphNode gn)
 {
	startingGNs.add(gn);
 }

public  ArrayList<GraphNode> getStartingGNs()
{
 return startingGNs;	
}

public void addEndingGN(GraphNode gn)
{
	endingGNs.add(gn);
}

public  ArrayList<GraphNode> getEndingGNs()
{
 return endingGNs;	
}

public AdjacentTable getAdjTable ()
	{
	 return adjTable;
	}

public GraphNode getGraphNode(ExtendedActivity ct)
	{
	 return CTs.get(ct);
	}

public AffectionsGraph clone()
{
 AffectionsGraph cloned = new AffectionsGraph();
 Enumeration<GraphNode> gnIterator = this.getCTs();
 // create all the graph nodes
 while(gnIterator.hasMoreElements())
 	{
	 GraphNode gn = gnIterator.nextElement();
	 GraphNode cgn = new GraphNode(gn.getCt());
	 if (gn.isMarked()) {cgn.mark();}
	 cloned.addCT(cgn);
 	}
 // create all affect transitions
 gnIterator = this.getCTs();
 while(gnIterator.hasMoreElements())
	{
	 GraphNode gn = gnIterator.nextElement();
	 for(GraphNode atIn : gn.getAtIn())
	 	{
		 cloned.getGraphNode(gn.getCt()).addAtIn(cloned.getGraphNode(atIn.getCt()));
	 	}
	}
 // create all structural transitions
 gnIterator = this.getCTs();
 while(gnIterator.hasMoreElements())
	{
	 GraphNode gn = gnIterator.nextElement();
	 GraphNode stIn =  gn.getStIn();
	 if (stIn != null)
		 {cloned.getGraphNode(gn.getCt()).setStIn(cloned.getGraphNode(stIn.getCt()));}
	}
 //starting cts
 for(GraphNode start : this.getStartingGNs())
 	{
	 cloned.addStartingGN(cloned.getGraphNode(start.getCt()));
 	}
//ending cts
for(GraphNode end : this.getEndingGNs())
	{
	 cloned.addEndingGN(cloned.getGraphNode(end.getCt()));
	}
 return cloned;
}

/**
 * @param GraphNode gn is removed from the graph and from all the transitions. it becomes null*/
public void removeGraphNode(ExtendedActivity ct) 
{
 GraphNode gn = CTs.get(ct);
 CTs.remove(gn.getCt());
 endingGNs.remove(gn);
 startingGNs.remove(gn);
 gn.destroy();
 gn=null;
}




//===== print AffectionsGraph ========
public void printAffG()
	{
	 if (! PartesMain.instance.doDebug())
 		{return;}
	 try {
		  IOUtils4Mac.invokeDOT(PartesConf.getString("outputPath"), "affGraph_"+iteration_affGraph+".png", toDOT());
		  iteration_affGraph++;
	 	 } 
	catch (IOException e) {e.printStackTrace();}
	}





private String toDOT() 
{
	String result = "";
	if (this == null) {
		return result;
	}
	
	result += "digraph G {\n";
	result += "rankdir=LR \n"; //rankdir=LR for left to right graph; rankdir=TD for top to down graph
	for (GraphNode gn:CTs.values())
		{
		 for(GraphNode affected:gn.getAtOut())
		 	{// affection transitions
			 result += "\""+gn.getCt().getName()+"\"->"+"\""+affected.getCt().getName()+"\";\n";
		 	}
		 //structure transition
		 try{result += "\""+gn.getCt().getName()+"\" -> \""+gn.getStOut().getCt().getName()+"\" [style=\"dashed\"];\n";}
		 catch(java.lang.NullPointerException e){}
		}
	result += " }";

return result;
}

private void printDebug(String message)
{
 if (PartesMain.instance.doDebug())
 	{
	  log.info(message);
 	}
}

}



// ==========================================================================================================================
 class GraphNode
{
 private ExtendedActivity ct;
 private GraphNode stOut; //structural transition
 private GraphNode stIn;
 private ArrayList<GraphNode> atOut; //affecting transition
 private ArrayList<GraphNode> atIn;  //affected transition
 private AffectionsGraph graph;
 private boolean marked = false;
 
 public GraphNode(ExtendedActivity ct)
 {
	 this.setCt(ct);
	 atOut = new ArrayList<GraphNode>();
	 atIn = new ArrayList<GraphNode>();
 }

public void destroy() 
{
 for (GraphNode atin:getAtIn())
 	{atin.getAtOut().remove(this);}
 for (GraphNode atout:getAtOut())
	{atout.getAtIn().remove(this);}
 if (getStOut() != null)
	 {getStOut().setStIn(null);}
 if (getStIn() != null)
 	{getStIn().setStOut(null);}	
}

public GraphNode getStOut() {
	return stOut;
}

/**private because is automatically created by setStIn*/
private void setStOut(GraphNode stOut) {
	this.stOut = stOut;
}

public GraphNode getStIn() {
	return stIn;
}


/**automatically create the opposite relation*/
public void setStIn(GraphNode incoming) {
	this.stIn = incoming;
	if (incoming != null)
		{incoming.setStOut(this);}	//structural transition
}

public ArrayList<GraphNode> getAtOut() {
	return atOut;
}

private void addAtOut(GraphNode gn) {
	this.atOut.add(gn);
}

public ArrayList<GraphNode> getAtIn() {
	return atIn;
}

public void addAtIn(GraphNode gn) {
	this.atIn.add(gn);
	gn.addAtOut(this);
}

public ExtendedActivity getCt() {
	return ct;
}

public void setCt(ExtendedActivity ct) {
	this.ct = ct;
}

public AffectionsGraph getGraph() {
	return graph;
}

protected void setGraph(AffectionsGraph graph) {
	this.graph = graph;
}

@Override
public String toString()
{
 return getCt().getName();	
}

public void mark() 
{ marked = true;}

public boolean isMarked() 
{return marked;}




}

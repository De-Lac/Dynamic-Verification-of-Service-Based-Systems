package unicam.refactorWorkflowgraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import org.jbpt.pm.Activity;
import org.jbpt.pm.AlternativGateway;
import org.jbpt.pm.AndGateway;
import org.jbpt.pm.ControlFlow;
import org.jbpt.pm.DataNode;
import org.jbpt.pm.Event;
import org.jbpt.pm.FlowNode;
import org.jbpt.pm.Gateway;
import org.jbpt.pm.IDataNode;
import org.jbpt.pm.OrGateway;
import org.jbpt.pm.ProcessModel;
import org.jbpt.pm.XorGateway;
import org.omg.spec.bpmn._20100524.model.TParticipant;

import partes.service.PartesMain;
import unicam.utils.ExtendedActivity;
import unicam.utils.IOUtils4Mac;

public class WorkflowGraph extends ProcessModel
{
 
private static int iteration = 0;
//table that associate a CT with the condition that selects that branch (in case of OR or XOR gateways) during the rafactoring
private static Hashtable<String, String> singleConditions;
//table <condition, startingCTs> that associate an AND of conditions to one branch of the final refactored XOR gateway
private static Hashtable<String, ArrayList<PartesTrace>> finalConditions;

private static Hashtable<String, Hashtable<TParticipant, ArrayList<String>>> projections = new Hashtable<String, Hashtable<TParticipant, ArrayList<String>>>();


 public WorkflowGraph()
 	{
	 super();
	 finalConditions = new Hashtable<String, ArrayList<PartesTrace>>();
	 singleConditions = new Hashtable<String, String>();
 	}
 
 
 // ===== print workFlowGraph ========
 public void printWfG(String filePath, int iteration_rpst)
 	{
	 if (iteration>1 && !(PartesMain.instance.doDebug()) )
	 	{return;}
	 filePath = filePath +"/debug/";
	 System.out.println();
	 System.out.println("=====================================================");
	 System.out.println("============= Workflow Graph transitions=============");
	 System.out.println("=====================================================");
	 Collection<ControlFlow<FlowNode>> cf = getControlFlow();
	 Iterator<ControlFlow<FlowNode>> cfIterator = cf.iterator();
	 while (cfIterator.hasNext())
	 	{
		 ControlFlow<FlowNode> f = cfIterator.next();
		 System.out.println(f.getSource().getName()+" ---> "+f.getTarget().getName());
	 	}
	 System.out.println();System.out.println();
	 
	 try {  
		  IOUtils4Mac.invokeDOT(filePath, "graph_"+(iteration_rpst)+"."+iteration+".png", toDOT());
		  iteration++;
	 	 } 
	catch (IOException e) {e.printStackTrace();}
 	}

 //===========================================
 
 /** get the previous predecessors list until the next gateway. predecessors[0] = the most left element, probably a gateway*/
 public  ArrayList<FlowNode> getPredecessors(FlowNode node)
	{
		ArrayList<FlowNode> predecessors = new ArrayList<FlowNode> (); 
		return addPredecessors(node, predecessors);
	}
	
	
	/**predecessors[0] = the most left element, probably a gateway*/
	private  ArrayList<FlowNode> addPredecessors(FlowNode node, ArrayList<FlowNode> predecessors)
	{
		Collection<FlowNode> directPredecessors = getDirectPredecessors(node);
		 Iterator<FlowNode> it = directPredecessors.iterator();
		 FlowNode directPredecessor = null;
		 while(it.hasNext())
		 	{
			 directPredecessor = it.next();
			 predecessors.add(0, directPredecessor);
			 if (directPredecessor instanceof Gateway)
			 	{return predecessors;}
		 	}
		 if (directPredecessor==null)
		 	{return predecessors;}
		 return addPredecessors(directPredecessor, predecessors);
	}
	
	/** get the next successors list until the next gateway. successor[size-1] could be a gateway*/
	public ArrayList<FlowNode> getSuccessors(FlowNode node)
	{
		ArrayList<FlowNode> successors = new ArrayList<FlowNode> (); 
		successors = addSuccessors(node, null, successors);
		if (node instanceof Gateway && node.getName().contains("start_"))
			{successors.subList(0, successors.size()-1).clear();}
		return successors;
	}
	
	
	/** get the next successors list until the choosen gateway.
	 * <pre>
	 * 
	 *  / 1s \-->a-->f--> / 2s \-->b-->/ 2e \-->g--> / 1e \
	 *  \    /            \    /-->c-->\    /        \    /
	 *    |                                            ^
	 *    --->d-->e------------------------------------|
	 *    
	 *  getSuccessors(a, 1e) = [f, 2s, 2e, g]  
	 *    
	 * </pre>
	 * */
	public ArrayList<FlowNode> getSuccessors(FlowNode startFrom, FlowNode until)
	{
		ArrayList<FlowNode> successors = new ArrayList<FlowNode> (); 
		if (startFrom instanceof Gateway && startFrom.getName().contains("start_"))
			{successors = getSuccessors(startFrom);  //add the internal end gateway
			 return addSuccessors(successors.get(0), until, successors);
			}
		return addSuccessors(startFrom, until, successors);
	}
	
	
	
	/**
	 * iterate adding successors until reach a gateway if finall==null, or until the "finall" node otherwise
	 * @param finall 
	 * 			add successors until finall is reached (if != null)
	 * @param node 
	 * 			the node we are looking for its successor
	 * @param successors 
	 * 			the array where add successors nodes
	 * @return
	 * 		    list of successors until the final provided node (or the first reached gateway)
	 *  @see WorkflowGraph#getSuccessors(FlowNode, FlowNode) getSuccessors()
	 */
	private  ArrayList<FlowNode> addSuccessors(FlowNode node, FlowNode finall, ArrayList<FlowNode> successors)
	{
		Collection<FlowNode> directSuccessors = getDirectSuccessors(node);
		 Iterator<FlowNode> it = directSuccessors.iterator();
		 FlowNode directSuccessor = null;
		 while(it.hasNext())
		 	{
			 directSuccessor = it.next();
			 successors.add(directSuccessor);
			 if ( (finall==null && directSuccessor instanceof Gateway) ||
				  (finall == directSuccessor) 	 
			    )
			 	{return successors;}
			 else if (directSuccessor instanceof Gateway && directSuccessor.getName().startsWith("start_"))
			 	{// directSuccessor == internal start_gateway. I add as successor its end_gateway
				 FlowNode endGateway = getSuccessors(directSuccessor).get(getSuccessors(directSuccessor).size()-1);
				 successors.add(endGateway); 
				 directSuccessor = endGateway;
			 	}
		 	}
		 if (directSuccessor==null)
		 	{return successors;}
		 return addSuccessors(directSuccessor, finall, successors);
	}
	
	
	/**
	 * <pre>
	 *          x > 100                   __________
	 * /   \  ---------> a-->b-->c        |a|x>100 |
	 *  OR                                |d|x<=100|
	 * \   / ----------> d-->e-->f        ----------
	 *       x <= 100                    
	 *      
	 * </pre>
	 * associate a condition to a FlowNode. It means that the node is executed only if that condition is true. 
	 * This because the node is on a branch of a choice-gateway, and the condition is the one that enable that branch
	 * */
	public void addCondition(FlowNode n, String condition)
		{singleConditions.put(n.getName(), condition);}//associate the condition of that branch
	
	
	/**return the condition associated to a FlowNode. It means that the node is accessible only if the condition is respected, since
	 * it is the condition of a OR or XOR gateway. returns null if the node is not on a choice-gateway branch
	 * */
	public String getConditionAssociated(FlowNode n)
		{
		 try{
			 return singleConditions.get(n.getName());
		    }
		 catch(NullPointerException ex) {return null;}
		}
 
	
	
	
	
	
	/**
	 * each branch is associated to an AND of conditions. Many traces could have the same conditions 
	 * (because cts were of the same OR branch), but CTs are in different order (because were in a parallel gateway).
	 * This methods groups different traces that share the same conditions.
	 * <b>It should be called at the end of the refactoring.</b>
	 * */
	public void organizeTracesAccordingToConditions(String filePath, int iteration_rpst)
	{
	 if (getGateways().size()>2)
	 	{
		 System.err.print("the WorkflowGraph should be refactored before organizing its traces");
	 	 System.exit(1);
	 	}
	 FlowNode xor = getEntries().iterator().next();
	 if(getEntries().size()==1 && xor instanceof XorGateway)
	 	{
		 Collection<FlowNode> startingNodes = getDirectSuccessors(xor);
		 for (FlowNode startingNode : startingNodes)
		 	{
			 //scan one branch and check all the conditions associated to it
			 String andCondition="true\n";
			 if (getConditionAssociated(startingNode)!=null)
			 	{andCondition += " AND " + getConditionAssociated(startingNode)+"\n\r";}
			 for(FlowNode successor : getSuccessors(startingNode))
			 	{
				 if (getConditionAssociated(successor) != null)
				 	{
					 andCondition += " AND "+getConditionAssociated(successor)+"\n\r";
				 	}
			 	}
			 
			 //associate the condition to the branch 
			 getEdge(xor, startingNode).setDescription(andCondition);
			 if (finalConditions.get(andCondition) == null)
				 {// first trace of that condition
				  ArrayList<PartesTrace> tracesWithSameCondition = new ArrayList<PartesTrace>();
				  ArrayList<FlowNode> trace = getSuccessors(startingNode);
				  trace.add(0, startingNode); // add the first element at the beginning of the list
				  trace.remove(trace.size()-1); //last element should be a XOR gateway
				  tracesWithSameCondition.add(new PartesTrace(trace));
				  finalConditions.put(andCondition, tracesWithSameCondition);
				  makeProjections(andCondition, trace);
				 }
			 else
			 	{//one trace already exists associated to this condition
				  ArrayList<FlowNode> trace = getSuccessors(startingNode);
				  trace.remove(trace.size()-1); //last element should be a XOR gateway
				  trace.add(0, startingNode); // add the first element at the beginning of the list
				  finalConditions.get(andCondition).add(new PartesTrace(trace));
				}
		 	}
	 	}
	 else
	 	{
		 System.err.print("the WorkflowGraph has more then one entry, or it doesn't start with a XOR gateway.... Is it really right?? not handled now");
	 	 System.exit(1);
	 	}
	 printWfG(filePath, iteration_rpst);
	}
	
	
	/**
	 * returns an HashTable. The key is the AND of all the conditions true in the branch,
	 * the object is an ArrayList contains the firsts CTs of the branches that satisfy the AND condition 
	 * @return
	 */
 public Hashtable<String, ArrayList<PartesTrace>> getTracesOfRefactoredGraph()
 	{
	 if (!finalConditions.keys().hasMoreElements())
	 	{
		 System.err.print("the WorkflowGraph is not refactored");
	 	 System.exit(1);
	 	}	
	 return finalConditions;
 	}
 
 
 /**
  * returns the projections relative to a condition, of all the participants.
  * 
  * @param condition
  * @return projections
  * To get a projection of a participant: @projections.get(TParticipant)
  */
 public Hashtable<TParticipant, ArrayList<String>> getProjectionOfOneCondition(String condition)
 	{
	 return projections.get(condition);
 	}
 
 

 
 /**
  * Get one of the traces given by 
  * {@link unicam.refactorWorkflowgraph.WorkflowGraph#getTracesOfRefactoredGraph() WorkflowGraph.getTracesOfRefactoredGraph()}
  * contained in {@link unicam.refactorWorkflowgraph.WorkflowGraph#finalConditions finalConditions}
  * and divides the behaviors of each participant
  * @param condition the condition associated to this projection
  * @param trace the sequence of CTs of the trace where to make the projection
  * @return {@literal Hashtable <participant, listOfBehaviors>}
  */
 private void makeProjections(String condition, ArrayList<FlowNode> trace)
 	{
	 Hashtable<TParticipant, ArrayList<String>> projection = new Hashtable<TParticipant, ArrayList<String>>();
	 for (FlowNode ct : trace)
	 	{
		 TParticipant sender = ((ExtendedActivity)ct).getSender();
		 TParticipant receiver = ((ExtendedActivity)ct).getReceiver();
		 if (projection.get(sender) == null)
		 	{projection.put(sender, new ArrayList<String>());}
		 projection.get(sender).add("send to "+receiver.getName());
		 if (projection.get(receiver) == null)
		 	{projection.put(receiver, new ArrayList<String>());}
		 projection.get(receiver).add("receive from "+sender.getName());
	 	}
	 projections.put(condition, projection);
	}
 	
 
 
 
 
 
 
 
 
 /**
  * print the refactored graph with the enabling conditions on edges of the XorGateway 
  * @param filePath path where of the png file of the graph
  * @param iteration_rpst the number of the relative rpst
  */
 public void finalPrint(String filePath, int iteration_rpst)
 	{
	 	if (! PartesMain.instance.doDebug())
	 		{return;}
		String result = "";
		if (finalConditions.isEmpty()) 
			{ return; }
		
		result += "digraph G {\n";
		result += "rankdir=LR \n"; //rankdir=LR for left to right graph; rankdir=TD for top to down graph
		FlowNode xor = getEntries().iterator().next();
		for (FlowNode startingNode: getDirectSuccessors(xor))
			{
			 String condition = getEdge(xor, startingNode).getDescription();
		     result += xor.hashCode()+" -> "+startingNode.hashCode()+" [ label=\""+condition+"\" ];\n";
		     FlowNode from = startingNode;
		     for (FlowNode node : getSuccessors(startingNode))
		     	{ 
		    	 result += from.hashCode() +" -> "+node.hashCode() +";\n";
		    	 from = node;
		     	}
			}
		for (FlowNode node:getFlowNodes())
			{
			 if (node instanceof Gateway)
			 	{result += node.hashCode() + "[shape=diamond, label=\""+node.getName()+"\"];\n";}
			 else
				 {result += node.hashCode() + "[label=\""+node.getName()+"\"];\n";}
			}
		result += " }";
	try {
		  IOUtils4Mac.invokeDOT(filePath, "FINALWGraph_"+iteration_rpst+".png", result);
	 	 } 
	catch (IOException e) {e.printStackTrace();}

 	}
 
 
 
 
 
 @Override
	public String toDOT() {
		String result = "";
		if (this == null) {
			return result;
		}
		
		result += "digraph G {\n";
		result += "rankdir=LR \n"; //rankdir=LR for left to right graph; rankdir=TD for top to down graph
		
		for (Event e : this.getEvents()) {
			result += String.format("  n%s[shape=ellipse,label=\"%s\"];\n", e.getId().replace("-", ""), e.getName());
		}
		result+="\n";
		
		for (Activity a : this.getActivities()) {
			result += String.format("  n%s[shape=box,label=\"%s\"];\n", a.getId().replace("-", ""), a.getName());
		}
		result+="\n";
		
		for (Gateway g : this.getGateways(AndGateway.class)) {
			result += String.format("  n%s[shape=diamond,label=\"%s\"];\n", g.getId().replace("-", ""), "AND_"+g.getName());
		}
		for (Gateway g : this.getGateways(XorGateway.class)) {
			result += String.format("  n%s[shape=diamond,label=\"%s\"];\n", g.getId().replace("-", ""), "XOR_"+g.getName());
		}
		for (Gateway g : this.getGateways(OrGateway.class)) {
			result += String.format("  n%s[shape=diamond,label=\"%s\"];\n", g.getId().replace("-", ""), "OR_"+g.getName());
		}
		for (Gateway g : this.getGateways(AlternativGateway.class))
			result += String.format("  n%s[shape=diamond,label=\"%s\"];\n", g.getId().replace("-", ""), "?");
		result+="\n";
		
		for (DataNode d : this.getDataNodes()) {
			result += String.format("  n%s[shape=note,label=\"%s\"];\n", d.getId().replace("-", ""), d.getName().concat(" [" + d.getState() + "]"));
		}
		result+="\n";
		
		for (ControlFlow<FlowNode> cf: this.getControlFlow()) {
			if (cf.getLabel()!=null && cf.getLabel()!="")
				result += String.format("  n%s->n%s[label=\"%s\"];\n", cf.getSource().getId().replace("-", ""), cf.getTarget().getId().replace("-", ""), cf.getLabel());
			else
				result += String.format("  n%s->n%s;\n", cf.getSource().getId().replace("-", ""), cf.getTarget().getId().replace("-", ""));
		}
		result+="\n";
		
		for (Activity a : this.getActivities()) {
			for (IDataNode d : a.getReadDocuments()) {
				result += String.format("  n%s->n%s;\n", d.getId().replace("-", ""), a.getId().replace("-", ""));
			}
			for (IDataNode d : a.getWriteDocuments()) {
				result += String.format("  n%s->n%s;\n", a.getId().replace("-", ""), d.getId().replace("-", ""));
			}
		}
		result += "}";
		
		return result;
	}
	
 
}


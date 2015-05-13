package unicam.reduceParallelGateway;


import java.util.ArrayList;

import org.jbpt.pm.AndGateway;
import org.jbpt.pm.FlowNode;
import org.jbpt.pm.OrGateway;
import org.jbpt.pm.XorGateway;

import partes.service.PartesMain;
import unicam.refactorWorkflowgraph.RefactorWorkflowGraph;
import unicam.refactorWorkflowgraph.WorkflowGraph;

public class ReduceInclusiveGateway 
{
	
	
	
	
/**
 * 
 * @param startIncGw
 * @param endIncGw
 * @param g
 * <pre>
 *                      ------>a-->b
 *                      |
 *  /  \-->a-->b      /   \ 
 *   OR          ===>  XOR  -->c-->d
 *  \  /-->c-->d      \   /
 *                      |      /   \-->a-->b
 *                      ------> AND
 *                             \   /-->c-->d
 * </pre>
 */
 public static void reduceInclusiveGateway(OrGateway startIncGw, OrGateway endIncGw, WorkflowGraph g)
 {
  printDebug("reduce inclusive gateway");
  ArrayList<ArrayList<FlowNode>> branches = RefactorWorkflowGraph.getBranches(g, startIncGw, endIncGw, true);
  // fill the main XorGateway
  XorGateway newStartingXorGateway = new XorGateway();
  XorGateway newEndingXorGateway = new XorGateway();
  RefactorWorkflowGraph.fillBranches(newStartingXorGateway, newEndingXorGateway, g, branches);
  // fill the subParallelGateway
  AndGateway newStartingAndGateway = new AndGateway();
  AndGateway newEndingAndGateway = new AndGateway();
  RefactorWorkflowGraph.fillBranches(newStartingAndGateway, newEndingAndGateway, g, branches);
  g.addControlFlow(newStartingXorGateway, newStartingAndGateway);
  g.addControlFlow(newEndingAndGateway, newEndingXorGateway); 
  // delete old edge and link the new
  try{g.addControlFlow(g.getDirectPredecessors(startIncGw).iterator().next(), newStartingXorGateway);}
  catch(java.util.NoSuchElementException e){}
  try{g.addControlFlow(newEndingXorGateway, g.getDirectSuccessors(endIncGw).iterator().next());}
  catch(java.util.NoSuchElementException e){}
  g.removeFlowNode(startIncGw);
  g.removeFlowNode(endIncGw);
  
 }
 
 
 
 private static void printDebug(String message)
 {
  if (PartesMain.instance.doDebug())
  	{
	  System.out.println(message);
  	}
 }
 
}

package unicam.refactorWorkflowgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpt.pm.AndGateway;
import org.jbpt.pm.FlowNode;
import org.jbpt.pm.Gateway;
import org.jbpt.pm.OrGateway;
import org.jbpt.pm.XorGateway;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.omg.spec.bpmn._20100524.model.TChoreography;
import org.omg.spec.bpmn._20100524.model.TChoreographyTask;
import org.omg.spec.bpmn._20100524.model.TEndEvent;
import org.omg.spec.bpmn._20100524.model.TExclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TFlowNode;
import org.omg.spec.bpmn._20100524.model.TGateway;
import org.omg.spec.bpmn._20100524.model.TInclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TItemDefinition;
import org.omg.spec.bpmn._20100524.model.TMessage;
import org.omg.spec.bpmn._20100524.model.TMessageFlow;
import org.omg.spec.bpmn._20100524.model.TParallelGateway;
import org.omg.spec.bpmn._20100524.model.TParticipant;
import org.omg.spec.bpmn._20100524.model.TSequenceFlow;
import org.omg.spec.bpmn._20100524.model.TStartEvent;
import org.omg.spec.bpmn._20100524.model.TSubChoreography;

import partes.exception.BPMNmalformedException;
import partes.exception.PartesErrors;
import partes.refactorRunner.InteractionTreeBuilder;
import partes.refactorRunner.PartesInfo;
import partes.service.PartesMain;
import partes.utils.PartesConf;
import unicam.reduceParallelGateway.InterleavingTree;
import unicam.reduceParallelGateway.ReduceInclusiveGateway;
import unicam.reduceParallelGateway.ReduceParallelGateway;
import unicam.reduceParallelGateway.TreeNode;
import unicam.utils.ExtendedActivity;




public class RefactorWorkflowGraph { 
	
	//how many times the rpst has been rebuild
	private static int iteration_rpst = 0;
	private static Log log = LogFactory.getLog(RefactorWorkflowGraph.class);
	private static HashMap<Gateway, Gateway> gateways = new HashMap<Gateway, Gateway> ();
	

	
	/**gets a BPMN choreography and returns a WorkflowGraph.
	 * accepts just  ChoreographyTasks, OR (inclusive), XOR (exclusive) and AND (parallel) gateways
	 * @param iMAGEfilesPATH 
	 * @throws BPMNmalformedException 
	 * */
	public static WorkflowGraph from_BPMN_to_WorkflowGraph(TChoreography chor) throws BPMNmalformedException
		{
		 WorkflowGraph G = new WorkflowGraph();
		 Vector<TFlowElement> actionableElements =  chor.getActionableFlowElements();
		 Iterator<TFlowElement> actionableElementsIterator = actionableElements.iterator();
		 while(actionableElementsIterator.hasNext())
		    {
			 TFlowElement start = actionableElementsIterator.next();
				 if (start instanceof TFlowNode)
					 {buildWfG(G, (TFlowNode)start, null, chor, "");}	
				 else 
				 	{
					 String error = PartesErrors.WRONG_STARTING_NODE+". check "+start;
					 printDebug(error);
				 	 throw new BPMNmalformedException(error);
				 	}
			}


		 return G;
		}
	
	
	
	
	/**
	 * create a  WorkflowGraph of just  ChoreographyTasks, XOR and AND gateways;
	 * The condition is associated to the outgoing arrow from a OR or XOR gateway. is empty otherwise.
	 * @param g
	 * @param flowElem
	 * @param previous
	 * @param chor
	 * @param condition
	 * @return the last element of the graph (the one before the EndEvent)
	 * @throws BPMNmalformedException 
	 */
	private static FlowNode buildWfG(WorkflowGraph g, TFlowNode flowElem, FlowNode previous, TChoreography chor, String condition) throws BPMNmalformedException 
	{
	 FlowNode n = null;
	 FlowNode lastNode = null;
	 // CHOREOGRAPHY TASK
	 if (flowElem instanceof TChoreographyTask)  
	 	{
		 TChoreographyTask ct = (TChoreographyTask)flowElem;
         n = transformTChoreographyTaskToExtendedActivity(ct, chor); 
         n.setId(flowElem.getId());
	 	}
	 else if (flowElem instanceof TParallelGateway)
	 	{// PARALLEL
		 n = new AndGateway(flowElem.getName());
		 n.setId(flowElem.getId());
	 	}
	 else if (flowElem instanceof TExclusiveGateway)
	 	{// EXCLUSIVE
		 n = new XorGateway(flowElem.getName());
		 n.setId(flowElem.getId());
	 	}
	 else if (flowElem instanceof TInclusiveGateway)
	 	{// INCLUSIVE
		 n = new OrGateway(flowElem.getName());
		 n.setId(flowElem.getId());
	 	}
	 else if ( flowElem instanceof TSubChoreography )
	 	{// SUB_CHOREOGRAPHY
		  n = from_SubChoreography_to_SubWorkflowGraph(g, ((TSubChoreography)flowElem), chor, previous, condition);
		  previous = null; // I have not to link previous to n. n is the last element of the subChor
	 	}
	 if (n != null)
		 {
		  if (!(condition.equals("")))
		  	{g.addCondition(n, condition);}//associate the condition of that branch
		  if (previous!=null)
		  	{
			 boolean gatewayAlreadyExplored = false;
		     if (n instanceof Gateway)
		       	{
		       	 for (Gateway gat : g.getGateways())
		       	 	{
		       		 if (gat.getId().equals(n.getId()))
		       		 	{//gateway already added and explored
		       			 gatewayAlreadyExplored = true;
		       			 n = gat;
		       			 break;
		       		 	}
		       	 	}
		       	}
		     g.addControlFlow(previous, n);
		     if (gatewayAlreadyExplored)
		     	{return null;}
		  	}
		 } 
	 Iterator<QName> nextArrows = flowElem.getOutgoing().iterator();	
	 while(nextArrows.hasNext())
	 	{
			QName sfname = nextArrows.next();
	
			Iterator<JAXBElement<? extends TFlowElement>> flowElements = chor.getFlowElement().iterator();
			while(flowElements.hasNext())
			    {
				 TFlowElement fte = flowElements.next().getValue();
				 if (fte.getId().equals(sfname.getLocalPart()))
				   {
					// a sequenceFlow is an arrow
					TSequenceFlow arrow = (TSequenceFlow) fte;
					TFlowNode nextElement =((TFlowNode)arrow.getTargetRef());
					if (nextElement  instanceof TEndEvent)
						{lastNode = n;}
					if (arrow.getConditionExpression() != null)
						{
						 FlowNode fn = buildWfG(g, nextElement, n, chor, arrow.getConditionExpression().getContent().toString());
						 if ( fn != null )
						 	{lastNode = fn;}
						}
					else
						{
						 FlowNode fn = buildWfG(g, nextElement, n, chor, "");
						 if ( fn != null )
					 		{lastNode = fn;}
						 }
					break;
				   }
			     } 
		}
	 return lastNode;
	}
	
	
	
	/**
	 * return the ending element of the subChoreography. Previous nodes will be already linked in the WfG
	 * @param g
	 * @param tSubChoreography
	 * @param previous
	 * @param chor
	 * @param condition
	 * @return
	 * @throws BPMNmalformedException 
	 */
	private static FlowNode from_SubChoreography_to_SubWorkflowGraph(WorkflowGraph g, TSubChoreography subChor, TChoreography chor, FlowNode previous, String condition) throws BPMNmalformedException 
	{
		for (JAXBElement<? extends TFlowElement> telem : subChor.getFlowElement())
			{ // add elements of the subChor into the general Chor
			 TFlowElement elem = telem.getValue();
			 if (elem instanceof TGateway || elem instanceof TSequenceFlow || elem instanceof TChoreographyTask)
			 	{ chor.getFlowElement().add(telem); }
			 else if ( !(elem instanceof TStartEvent) && !(elem instanceof TEndEvent))
			 	{
				 String error = PartesErrors.BPMN_ELEMENT_NOT_MATCHED +elem.getName();
				 log.error(error);
			 	 throw new BPMNmalformedException(error);
			 	}
			} 
		Iterator<JAXBElement<? extends TFlowElement>> flowElemIter = subChor.getFlowElement().iterator();
		while ( flowElemIter.hasNext() )
				{
			      TFlowElement flowElem = flowElemIter.next().getValue();

			      if (flowElem instanceof TStartEvent)
			      {
			    	  QName arrowName = ((TStartEvent) flowElem).getOutgoing().get(0); 
			    	  Iterator<JAXBElement<? extends TFlowElement>> flowElements = subChor.getFlowElement().iterator();
			    	  TFlowNode nextElement = null;
			    				while(flowElements.hasNext())
			    				    {
			    					 TFlowElement fte = flowElements.next().getValue();
			    					 if (fte.getId().equals(arrowName.getLocalPart()))
			    					   {
			    						// a sequenceFlow is an arrow
			    						TSequenceFlow arrow = (TSequenceFlow) fte;
			    						nextElement =((TFlowNode)arrow.getTargetRef());
			    						return buildWfG(g, nextElement, previous, chor, condition);
			    					   }
			    				     } 
			    	  if ( nextElement == null)
			    	  	{
			    		 String error = PartesErrors.SUB_CHOREOGRAPHY_WITHOUT_START+ "check "+ subChor.getName();
			    		 printDebug(error);
						 throw new BPMNmalformedException(error);
			    	  	}
			      }
				}
		 return null;
	}

	
	
	
	
	/**returns a refactored WorkflowGraph, with just one big ExclusiveGateway
	 * @throws BPMNmalformedException */
	public static WorkflowGraph refactorWorflowGraph (WorkflowGraph g) throws BPMNmalformedException
		{
		 g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
		 // fill the hashmap of gateways <starting, ending>
	      for ( Gateway gat : g.getGateways() )
	      	{
	    	  if(gat.getName().contains("start_"))
	    	  	{
	    		  boolean closed = false;
	    		  for ( Gateway gat2 : g.getGateways() )
	    		  {
	    			if(gat2.getName().equals("end_"+gat.getName().substring(6)))
	    			{
	    			 gateways.put(gat, gat2);
	    			 closed = true;
	    			 break;
	    			}
	    		  }
	    		  if (!closed)
	    		  	{
	    			  String error =PartesErrors.WRONG_SESE + gat.getName();
	    			  log.error(error);
	    			  throw new BPMNmalformedException(error);
	    			}
	    	  	}
	      	}
		 
		 
		 
		 while ( g.getGateways().size()>2
				 ||
				 (g.getGateways().size()==2 &&  (
						 					      (/* it doesn't start with a xor */    !(g.getEntries().iterator().next() instanceof XorGateway)) ||  
						 					      (/* it doesn't finish with a xor */ 
						 					    		( g.getPredecessors(((XorGateway)(((g.getGateways()).toArray())[1]))).contains(((XorGateway)(((g.getGateways()).toArray())[0]))) &&
						 					              g.getDirectSuccessors(((XorGateway)(((g.getGateways()).toArray())[1]))).size() > 0
						 					            )   ||
						 					           ( g.getPredecessors(((XorGateway)(((g.getGateways()).toArray())[0]))).contains(((XorGateway)(((g.getGateways()).toArray())[1]))) &&
								 					              g.getDirectSuccessors(((XorGateway)(((g.getGateways()).toArray())[0]))).size() > 0
								 					   )
						 					       )
						 					     )
				 )
			   ) //i should have just one starting and one ending XORgateway
		 {
		  System.out.println("refactoring...   number of total gateways: "+g.getGateways().size()+"    number of nodes: "+g.getFlowNodes().size());
		  // ===== FINDING INNER GATEWAY ======
		  Gateway stg = null ;
		  Gateway etg = null;
		  
	      // gateways filled. now i'm looking for the inner gateway to reduce
		  Iterator<Gateway> gatIterator = gateways.keySet().iterator();
	      while (gatIterator.hasNext())
	      	{
	    	  Gateway  startGat = gatIterator.next();
	    	  Gateway  endGat = gateways.get(startGat);
	    	  boolean containsOtherGateways = false;
	    	  for( FlowNode ds : g.getDirectSuccessors(startGat))
	    	  	{
	    		  if (!(g.getSuccessors(ds).get(g.getSuccessors(ds).size()-1).getName().equals(endGat.getName())))
	    		  	{
	    			  containsOtherGateways = true;
	    			  break;
	    		  	}
	    	  	}
	    	  if (!containsOtherGateways)
	    	  	{
	    		  stg = startGat;
	    		  etg = endGat;
	    	  	}
	    	  
	    	  
	    	  
	      	}
	      if (stg == null)
	      	{
	    	  log.error("mmm something strange.. the inner gateway to reduce wasn't found.");
	      	}
		  //  =========================================
							 
							//====== OR GATEWAY ========
 						  if (stg instanceof OrGateway)
						   {
							  OrGateway innerGateway = (OrGateway) stg;
							  OrGateway endingGateway = (OrGateway) etg;
							  printDebug("deepest enter OrGateway "+stg.getName()); 
							  ReduceInclusiveGateway.reduceInclusiveGateway(innerGateway, endingGateway, g);
							  g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
						   }
 						  
 						  
 						
						  if ( stg instanceof XorGateway )
					 		{
							 XorGateway innerGateway = (XorGateway)stg;
							 XorGateway endingGateway = (XorGateway) etg;
									 if (endingGateway != null && g.getEdge(endingGateway, innerGateway) != null)
									 	{ // ======= XOR CYCLE GATEWAY (repeat - until) ========
										  //	ENTERING REPEAT-UNTIL
										  printDebug("deepest enter repeat-until cycle XorGateway "+innerGateway.getName());
								 
										  ArrayList<ArrayList<FlowNode>> branches = getBranches(g, innerGateway, endingGateway, false);
										  if (branches.size()>1)
										  	{
											  printDebug(PartesErrors.WRONG_REPEAT_UNTIL);
											  System.exit(1);
										  	}
										  FlowNode from = innerGateway;
										  FlowNode to;
										  for (int cycles = 0; cycles < 2; cycles++)
										  	{ //ExtendedActivity =  number of times to iteratate the cycle repeat-until
											  for (FlowNode node : branches.get(0))
											  	{
												  to = (ExtendedActivity) node.clone();
												  g.addControlFlow(from, to);
												  from=to;
											  	}
										  	}
										  g.addControlFlow(from, endingGateway);
										  g.removeEdges(g.getEdges(endingGateway, innerGateway));
										  g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
									 	} 
									 else if (endingGateway != null)
									 	{// ======= XOR GATEWAY ========
										 // ENTERING XOR_GATEWAY
										 printDebug("deepest enter XorGateway "+innerGateway.getName());
										 //	move previous tasks into the XorGateway #RULE 1
										 rule1 (innerGateway,g);
										 //move next tasks into the XorGateway #RULE 2
										 rule2 (endingGateway,g);
										 g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
										 //if there is an AND before, put out the XOR
										 FlowNode leftMostPredecessor=null;
										 FlowNode rightMostSuccessor = null;
										 if(g.getPredecessors(innerGateway).size()>0)
										 	{leftMostPredecessor= g.getPredecessors(innerGateway).get(0);}
										 if(g.getSuccessors(endingGateway).size()>0)
										 	{rightMostSuccessor = g.getSuccessors(endingGateway).get(g.getSuccessors(endingGateway).size()-1);}
										 if (leftMostPredecessor instanceof AndGateway && rightMostSuccessor instanceof AndGateway)
										 	{
											 merge_starting_AND_XOR_gateways(g, (AndGateway)leftMostPredecessor, innerGateway, endingGateway, (AndGateway)rightMostSuccessor);
											 g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
										 	}
										 else if(leftMostPredecessor instanceof XorGateway && g.getDirectSuccessors(leftMostPredecessor).size()<2)
										 	{
											 merge_ending_starting_XOR_gateway(g, innerGateway, (XorGateway)leftMostPredecessor, innerGateway, endingGateway);
											 g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
										 	}
										 else
										 	{g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);}

								
									 	}
					 		}
 						  
 						  
 						  
						  // ==== AND_GATEWAY =====
						  if (stg instanceof AndGateway )
						 	{ // ENTERING AND_GATEWAY
							 AndGateway innerGateway = (AndGateway) stg;
							 AndGateway endingGateway = (AndGateway) etg;
							 printDebug("deepest enter AndGateway "+innerGateway.getName());
							 
							 InterleavingTree interleavingTree = new ReduceParallelGateway().reduceParallelGateway(innerGateway, g);
							 FlowNode successor = null;
							 try 
							 	{successor = g.getDirectSuccessors(endingGateway).iterator().next();}
							 catch(java.util.NoSuchElementException e){/*no successor*/}
							 FlowNode predecessor = null;
							 try
							 	{predecessor = g.getDirectPredecessors(innerGateway).iterator().next();}
							 catch(java.util.NoSuchElementException e){/*no predecessor*/}
							 if (interleavingTree.getRoot().getLeaves().size() > 1)
							 	{// there are more traces. I need to put them into a XorGateway
								 String gatewayName = generateName();
								 XorGateway endingXor = new XorGateway("end_"+gatewayName);
								 XorGateway startingXor = new XorGateway("start_"+gatewayName);
								 gateways.put(startingXor, endingXor);
								 if (successor != null)
								 	{g.addControlFlow(endingXor, successor);}
								 if (predecessor != null)
								 	{g.addControlFlow(predecessor, startingXor);}
								 transformTreeToXorGateways(startingXor, interleavingTree.getRoot(), endingXor, g);
							 	}
							 else
							 	{// I have just one trace, I don't need the xor Gateway
								 transformTreeToXorGateways(predecessor, interleavingTree.getRoot(), successor, g);
							 	}
							 
							 g.removeFlowNode(innerGateway); 
							 gateways.remove(innerGateway);
							 g.removeFlowNode(endingGateway);
							 g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
							} 
		 }
		g.organizeTracesAccordingToConditions(PartesConf.getString("outputPath"), iteration_rpst);
		g.finalPrint(PartesConf.getString("outputPath"), iteration_rpst);
		return g;
	   }
	
	
	
	
	
	
	
	
	
	/**
	 * If there are 2 separated sequential XOR, this methods merge them
	 * <pre>
	 *                                                                |--->e-->f---|
	 *                                                  --->a-->b-->xor           xor------
	 *  |---->a-->b----|      |-->e-->f---|             |             |--->g-->h---^      |
	 *  xor           xor-->xor           xor   ==>    xor                               xor
	 *  |---->c-->d----^      |-->g-->h---^             |             |--->e-->f---|      ^                  
	 *                                                  ---->c-->d-->xor          xor-----|
	 *                                                                |--->g-->h---^  
	 * </pre>
	 */
	private static void merge_ending_starting_XOR_gateway(WorkflowGraph g, XorGateway leftStartXor, XorGateway leftEndingXor, XorGateway rightStartXor, XorGateway rightEndXor) 
	{
		 
		  Collection<FlowNode> predecessors = g.getDirectPredecessors(leftEndingXor); // b, d
		  ArrayList<ArrayList<FlowNode>> branches = getBranches(g, rightStartXor, rightEndXor,true); // {[e,f] , [g,h]}
		  rightEndXor.setName(leftEndingXor.getName());
		  g.removeFlowNode(leftEndingXor);
		  g.removeFlowNode(rightStartXor);
		  gateways.remove(rightStartXor);
		  gateways.remove(leftStartXor);
		  gateways.put(leftStartXor, rightEndXor);
		  for (FlowNode predecessor : predecessors)
		  	{
			  String gatewayName = generateName();
			  XorGateway newStartXor = new XorGateway("start_"+gatewayName);
			  XorGateway newEndXor = new XorGateway("end_"+gatewayName);
			  gateways.put(newStartXor, newEndXor);
			  fillBranches(newStartXor, newEndXor, g, branches);
			  g.addControlFlow(predecessor, newStartXor);
			  g.addControlFlow(newEndXor, rightEndXor);
		  	}
	 	
		
	}

	private static void transformTreeToXorGateways(FlowNode startingNode, TreeNode treeNode, FlowNode endingNode, WorkflowGraph g) 
	{
	 String gatewayName = generateName();
	 // starting node
	 if ( !(startingNode instanceof XorGateway) && treeNode.getSons().size() > 1)
	  {
		XorGateway sxor = new XorGateway("start_"+gatewayName);
		g.addControlFlow(startingNode, sxor);
		startingNode = sxor;
		
		 // ending node
		XorGateway exor = new XorGateway("end_"+gatewayName);
		g.addControlFlow(exor, endingNode);
	 	endingNode = exor;
	 	gateways.put(sxor, exor);
	  }
	 
	 
	 if (treeNode.getSons().size()==0)
	 	{g.addControlFlow(startingNode, endingNode);}
	 else
	 	{
		 for (TreeNode son:treeNode.getSons())
		 	{
			 FlowNode from = startingNode;
			 for (ExtendedActivity to:son.getCts())
		  		{
				 to = (ExtendedActivity) to.clone();
				 if (from != null)
					 {g.addControlFlow(from, to);}
				 from=to;
		  		}
			 transformTreeToXorGateways(from, son, endingNode, g);
		 	}
	  }
	 }		






	/**<pre>
	 *  put cts before the inner gateway, inside it
	 *  
	 *                             
	 *   ----->e                                --->e
	 *   |                                      |
	 * outerGW           ---->d       ==>    outerGW
	 *   |               |                      |      |----->a-->b-->d
	 *   ----->a-->b-->innerXOR                 --->innerXor
	 *                   |                             |
	 *                   --->c                          ----->a-->b-->c
	 * </pre>
	 * */
	private static void rule1 (XorGateway innerGateway, WorkflowGraph g)
	{ printDebug("rule 1");
	  // OuterGateway-->a-->b-->InnerGateway-->c   becomes   OuterGateway-->InnerGateway-->a-->b-->c
	  // =====  remove old edges ======
	  //i starts from 1. [0] could be a gateway to not remove. i check this later
	  ArrayList<FlowNode> predecessors = g.getPredecessors(innerGateway);
	  for(int i=1; i<predecessors.size(); i++)
	  	{
		 g.removeFlowNode(predecessors.get(i));
	  	}
	  if(predecessors.size()==0)
	  	{return;}
	  if (!( predecessors.get(0) instanceof Gateway))
	    {
		  g.removeFlowNode(predecessors.get(0));
		}
		
	// =====  create new edges ======
	  Gateway outerGateway = null;
	  if(predecessors.get(0) instanceof Gateway)
  		{
		  g.addControlFlow(predecessors.get(0), innerGateway);
		  outerGateway = (Gateway) predecessors.get(0);
		  predecessors.remove(0);
  		}
	  if (predecessors.size() > 0)
	  {
	   for(FlowNode successor: g.getDirectSuccessors(innerGateway))
	   	{ 
		 g.removeEdges(g.getEdges(innerGateway, successor));
		 ArrayList<ArrayList<FlowNode>> branch = new ArrayList<ArrayList<FlowNode>>();
		 branch.add(predecessors);
		 fillBranches(innerGateway, successor, g, branch);
//	     FlowNode to = predecessors.get(index).clone();
//	     FlowNode from = null;
//	     g.addControlFlow(innerGateway, to);
//	     for(int i=index+1; i<predecessors.size();i++)
//	    	{
//	    	 from = to;
//	    	 to = predecessors.get(i).clone();
//	    	 g.addControlFlow(from, to);
//	    	}
//	     g .addControlFlow(to, successor);	    
	    }
	   }
		 
	  if (outerGateway != null)
	 	{
		 if (outerGateway instanceof XorGateway && g.getDirectSuccessors(outerGateway).size()>1)
			 { // XorGateway-->XorGateway-->b
			  printDebug("merge between "+innerGateway.getName()+" and "+outerGateway.getName());
			  merge_starting_Xorgateways(g, (XorGateway)innerGateway, (XorGateway)outerGateway);
			 }
	 	}
	}
	
	
	/**<pre>
	 *  put cts after the ending inner gateway, inside it
	 *  
     * -  --  --   ---   ---   ------          -  --  --   ---   ---   ------
	 *   -->a----                   |            -->a-->c-->d---            |
	 *          |                   |                          |            |
	 *        innerXOR-->c-->d-->outerGW   ==>               innerXOR-->outerGW
	 *          |                   |                          |            |
	 *   -->b----                   |            -->b-->c-->d---            |
	 *                              |                                       |
	 * -  --  --   ---   ---   ------          -  --  --   ---   ---   ------
	 * </pre>
	 * */
	private static void rule2 (XorGateway endingGateway, WorkflowGraph g)
	{ printDebug("rule 2");
	  // EndingGateway-->a-->b-->c-->OuterGateway   becomes  a-->b-->c-->EndingGateway-->OuterGateway
	  // =====  remove old edges ======
	  // successors[size] could be a gateway to not remove. i check this later
	  ArrayList<FlowNode> successors = g.getSuccessors(endingGateway);
	  if (successors.size()>0)
	  {
	   for(int i=0; i<successors.size()-1; i++)
	  	{
		 g.removeFlowNode(successors.get(i));
	  	}
	   if (!( successors.get(successors.size()-1) instanceof Gateway))
	    {
		  g.removeFlowNode(successors.get(successors.size()-1));
		}
		
	// =====  create new edges ======
	   Gateway outerGateway = null;
	   if(successors.get(successors.size()-1) instanceof Gateway)
  		{
		  g.addControlFlow(endingGateway, successors.get(successors.size()-1));
		  outerGateway = (Gateway) successors.get((successors.size()-1));
		  successors.remove(successors.size()-1);
  		}
	  
	   if (successors.size() >0)
	   {
	    for(FlowNode predecessor: g.getDirectPredecessors(endingGateway))
	    { 
	 	 g.removeEdges(g.getEdges(predecessor, endingGateway));
	 	 ArrayList<ArrayList<FlowNode>> branch = new ArrayList<ArrayList<FlowNode>>();
	 	 branch.add(successors);
	 	 fillBranches(predecessor, endingGateway, g, branch);
//	     FlowNode to = successors.get(0).clone();
//	     FlowNode from = null;
//	     g.addControlFlow(predecessor, to);
//	     for(int i=1; i<successors.size(); i++)
//	    	{
//	    	 from = to;
//	    	 to = successors.get(i).clone();
//	    	 g.addControlFlow(from, to);
//	    	}
//		 g.addControlFlow(to, endingGateway);
	    }
	   }
	  
	   if ( outerGateway != null)
	 	{ // b-->XorGateway-->XorGateway
		   printDebug("merge between "+endingGateway.getName()+" and "+outerGateway.getName());
		 if (outerGateway instanceof XorGateway && g.getDirectSuccessors(outerGateway).size()<2)
			 {merge_ending_Xorgateways(g, (XorGateway)endingGateway, (XorGateway)outerGateway);}
	 	}
	  }
	}
	
	
	/**<pre>
	 *  put a XOR gateway out from an AND gateway
	 *  
	 *                                    |----->a-->b
	 *   ----->a-->b               ----->AND
	 *   |                         |      |----->c
	 * AND      ----->c     ==>   XOR
	 *   |      |                  |      |----->a-->b
	 *   ----->XOR                 ----->AND
	 *          |                         |----->d
	 *          ----->d
	 * </pre>
	 * */
	private static WorkflowGraph merge_starting_AND_XOR_gateways(WorkflowGraph g, AndGateway startAndGateway, XorGateway startXorGateway, XorGateway endXorGateway, AndGateway endAndGateway)
	{
	 String gatewayName = generateName();
	 XorGateway newStartXor = new XorGateway("start_"+gatewayName);
	 XorGateway newEndXor = new XorGateway("end_"+gatewayName);
	 gateways.put(newStartXor, newEndXor);
	 if (g.getDirectPredecessors(startAndGateway).size()>0)
		 {g.addControlFlow(g.getDirectPredecessors(startAndGateway).iterator().next(), newStartXor);}
	 if (g.getDirectSuccessors(endAndGateway).size()>0)
		 {g.addControlFlow(newEndXor, g.getDirectSuccessors(endAndGateway).iterator().next());}
	//prepare the others branch of the ANDgateway, to clone in the new XorGateways
	 ArrayList<ArrayList<FlowNode>> andBranches = getBranches(g, startAndGateway, endAndGateway, true);
	 // remove the branch with the xor
	 for (ArrayList<FlowNode> branch : andBranches)
	 	{
		 if (branch.get(0) == startXorGateway)
		 	{andBranches.remove(branch);
		 	 break;
		 	}
	 	}
//	 for(FlowNode andBranch : g.getDirectSuccessors(startAndGateway))
//	 	{
//		 if (andBranch != startXorGateway)
//		 {
//		  ArrayList<FlowNode> branch = new ArrayList<FlowNode>(); 
//		  branch.add(andBranch);
//		  ArrayList<FlowNode> successors = g.getSuccessors(andBranch);
//		  g.removeFlowNode(andBranch);
//		  successors.remove(successors.size()-1);//remove the endAndGateway
//		  for(FlowNode node : successors)
//		 	{
//			 branch.add(node);
//			 g.removeFlowNode(node);
//		 	}
//		  andBranches.add(branch);
//		 }
//	 	}
	 for( FlowNode xorBranch : g.getDirectSuccessors(startXorGateway))
	 	{
		 gatewayName = generateName();
		 AndGateway newStartAnd = new AndGateway("start_"+gatewayName);
		 AndGateway newEndAnd = new AndGateway("end_"+gatewayName);
		 gateways.put(newStartAnd, newEndAnd);
		 //add the new AND to the new XOR
		 g.addControlFlow(newStartXor, newStartAnd);
		 g.addControlFlow(newEndAnd, newEndXor);
		 //add one of the choice's branch
		 g.addControlFlow(newStartAnd, xorBranch);
		 if (g.getSuccessors(xorBranch).size()>1)
		 	{//if successors.size==1, it's just the endXorGateway
			  ArrayList<FlowNode> sccs = g.getSuccessors(xorBranch);
			  FlowNode lastOfTheBranch = sccs.get(g.getSuccessors(xorBranch).size()-2);
			 g.addControlFlow(lastOfTheBranch, newEndAnd);
			 }
		 else
		 	{
			 g.addControlFlow(xorBranch, newEndAnd);
		 	}
		 
		 //add the branches of the outerAndGateway
		 g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
		 fillBranches(newStartAnd, newEndAnd, g, andBranches);
		 g.printWfG(PartesConf.getString("outputPath"), iteration_rpst);
//		 for(ArrayList<FlowNode> andBranch : andBranches)
//		 	{
//			 FlowNode from = andBranch.get(0).clone();
//			 g.addControlFlow(newStartAnd, from); 
//			 for(int i=1; i<andBranch.size(); i++)
//			 	{
//				 FlowNode to = andBranch.get(i).clone();
//				 g.addControlFlow(from, to);
//				 from = to;
//			 	}
//			 g.addControlFlow(from, newEndAnd);
//		 	}
	 	}
	 
	 // ======= PORCHETTA===============
	 for(ArrayList<FlowNode> branch : andBranches)
	 	{
		 Gateway stg = null;
		 Gateway eng = null;
		 for(FlowNode node : branch)
			 {
			  if (node instanceof Gateway && stg == null)
			  	{ stg = (Gateway)node; }
			  else if (node instanceof Gateway && stg != null)
			  	{ 
				  eng = (Gateway)node;
				  getBranches(g, stg, eng, true); // remove internal branches
				  g.removeFlowNode(stg); // remove no-more-used gateways
				  g.removeFlowNode(eng);
				  gateways.remove(stg);
				  gateways.remove(eng);
				}
			  else {g.removeFlowNode(node);}
			 }
	 	}
	 
	// ================================
	 
	 
	 g.removeFlowNode(endAndGateway);
	 g.removeFlowNode(startAndGateway);
	     gateways.remove(startAndGateway);
	 g.removeFlowNode(endXorGateway);
	 g.removeFlowNode(startXorGateway);
	     gateways.remove(startXorGateway);
	 return g;
	}
	
	
	/**<pre>
	 *  merge two starting gateways
	 *  
     * 
	 *          -->a                            -->a
	 *          |                               |
	 *        outerXOR                   ==>   XOR-->b
	 *          |                               |
	 *          |      |---->b                  -->c
	 *          -->innerXOR  
	 *                 |     
	 *                 ----->c
	 * </pre>
	 * */
	private static WorkflowGraph merge_starting_Xorgateways(WorkflowGraph g, XorGateway innerG, XorGateway OuterG)
	{
	 Collection<FlowNode> successors = g.getDirectSuccessors(innerG);
	 for (FlowNode successor : successors)
	 	{
		 g.addControlFlow(OuterG, successor);
	 	}
	 g.removeFlowNode(innerG);
	 gateways.remove(innerG);
	 return g;
	}
	

	/**<pre>
	 *  merge two ending gateways
	 *  
     * -------------->c-----
	 *   -->a----           |             -->a---    
	 *          |           |                   |
	 *       innerXOR-->outerXOR   ==>   -->b-->XOR          
	 *          |                               |     
	 *   -->b----                         -->c---
	 *   
	 * </pre>
	 * */
	private static WorkflowGraph merge_ending_Xorgateways(WorkflowGraph g, XorGateway innerG, XorGateway OuterG)
	{
	 Collection<FlowNode> predecessors = g.getDirectPredecessors(innerG);
	 for (FlowNode predecessor : predecessors)
	 	{
		 g.addControlFlow(predecessor, OuterG);
	 	}
	 g.removeFlowNode(innerG);
	 return g;
	}

	
	
	private static TParticipant resolveQNameTParticipant(QName name, TChoreography chor)
	{
	 Iterator<TParticipant> tmf = chor.getParticipant().iterator();
	 while(tmf.hasNext())
	 	{
		 TParticipant p = tmf.next();
		 if (p.getId().equals(name.getLocalPart()))
		  {return p;}
		}
	 return null;
	}
	
	private static TMessageFlow resolveQNameTMessage(QName name, TChoreography chor)
	{
	 Iterator<TMessageFlow> tmf = chor.getMessageFlow().iterator();
	 while(tmf.hasNext())
	 	{
		 TMessageFlow p = tmf.next();
		 if (p.getId().equals(name.getLocalPart()))
		  {return p;}
		}
	 return null;
	}
	
	
	
	
	
	
	/**
	  * <pre>
	  * returns all the branches, and if "remove"==true, removes all the CTs from the relative WorkflowGraph.
	  * It doesn't remove internal gateways because their connection should be used later on
	  * 
	  *   
	  *   / 1s \-->a-->f--> / 2s \-->b-->/ 2e \-->g--> / 1e \
	  *   \    /            \    /-->c-->\    /        \    /
	  *     |                                             ^
	  *     --->d-->e-------------------------------------|
	  * 
	  * returns ArrayList<ArrayList<FlowNode>>
	  *       --------
	  *       |0|0|a |
	  *       |0|1|f |
	  *       |0|2|2s|
	  *       |0|3|2e|
	  *       |0|4|g |
	  *       |1|0|d |
	  *       |1|1|e |
	  *       --------
	  * to see how is a branch, see:{@link WorkflowGraph#getSuccessors(FlowNode, FlowNode) getSuccessors()}
	  * 
	  * </pre>
	  * */
	 public static ArrayList<ArrayList<FlowNode>> getBranches(WorkflowGraph g, Gateway startGw, Gateway endGw, boolean remove)
	 	{
		 ArrayList<ArrayList<FlowNode>> branches = new ArrayList<ArrayList<FlowNode>>();
		 for(FlowNode startingCt : g.getDirectSuccessors(startGw))
		 	{// get starting CTs for each branch
			 if (startingCt != endGw)
			 {
			  ArrayList<FlowNode> branch = new ArrayList<FlowNode>(); 
			  branch.add(startingCt);
			  ArrayList<FlowNode> successors = g.getSuccessors(startingCt, endGw);
			  if(remove && !(startingCt instanceof Gateway) ) //i can't remove an internal gateway. I need its flow later
				  {g.removeFlowNode(startingCt);}
			  if(successors.get(successors.size()-1) == endGw)
				  {successors.remove(successors.size()-1);}//remove the endGateway
			  for(FlowNode node : successors)
			 	{
				 branch.add(node);
				 if(remove &&  !(node instanceof Gateway) ) //i can't remove an internal gateway. I need its flow later
					 {g.removeFlowNode(node);}
			 	}
			  branches.add(branch);
			 }
		 	}
		 return branches;
	 	}
	
	
	/**
	 * <pre>
	 * Transform a matrix in branches. 
	 * ATTENTION!! Two nodes of a branch could be a starting and ending gateway. in this case, the nodes between
	 * should be consider
	 * 
	 *    branches
	 *     ------
	 *    |0|0|a|
	 *    |0|1|b|        /   \---->a-->b-->c--> /   \
	 *    |0|2|c|  ====> start                   end    
	 *    |1|0|d|        \   /---->d-->e-->f--> \   /
	 *    |1|1|e|
	 *    |1|2|f|
	 *    -------
	 *    
	 *    if, for instance, "b" and "c" are respectively a starting and ending gateway,
	 *    the nodes between them should be reconstructed
	 * </pre> 
	 * */
	 public static void fillBranches (FlowNode start, FlowNode end, WorkflowGraph g, ArrayList<ArrayList<FlowNode>> branches)
	 {
	  for(ArrayList<FlowNode> branch : branches)
	    {
		  FlowNode originalNode = branch.get(0);
		  FlowNode to = null;
		  String newName="";
		  if (originalNode instanceof Gateway && originalNode!=start && originalNode!=end)
		  	{
			  if (originalNode instanceof XorGateway)
			  	{
				  if (originalNode.getName().contains("start_"))
					  { newName = generateName(); } 
				  to = new XorGateway(originalNode.getName() + newName);
				  if (start.getName().contains("start_") &&  to.getName().contains("end_"))
				  	  {gateways.put((XorGateway)start, (XorGateway)to);}
				}
			  else if (originalNode instanceof AndGateway)
			  	{
				  if (originalNode.getName().contains("start_"))
				  	{ newName = generateName(); }
				  to = new AndGateway(originalNode.getName() + newName);
				  if (start.getName().contains("start_") &&  to.getName().contains("end_"))
			  	  	{gateways.put((AndGateway)start, (AndGateway)to);}
			  	}
		  	}
		  else
		  	{to = originalNode.clone();}
		  FlowNode from=null;
		  g.addControlFlow(start, to);
		  for (int i=1; i<branch.size();i++)
		  	{
			  from = to;
			  if (branch.get(i) instanceof Gateway && branch.get(i)!=start && branch.get(i)!=end)
			  	{
				  if (branch.get(i) instanceof XorGateway)
					  {
						  if (branch.get(i).getName().contains("start_"))
							  { newName = generateName(); }
						  to = new XorGateway(branch.get(i).getName() + newName);
						  if (from.getName().contains("start_") &&  to.getName().contains("end_"))
					  	  	{gateways.put((XorGateway)from, (XorGateway)to);}
					  }
				  else if (branch.get(i) instanceof AndGateway)
			  	  	{
					  if (branch.get(i).getName().contains("start_"))
					  	{ newName = generateName();}
				  	  to = new AndGateway(branch.get(i).getName() + newName);
				  	  if (from.getName().contains("start_") &&  to.getName().contains("end_"))
			  	  		{gateways.put((AndGateway)from, (AndGateway)to);}
			  	  	}
			  	}
			  else
			  	{to = branch.get(i).clone();}
			  if (from instanceof Gateway && from.getName().contains("start_") &&
			      to instanceof Gateway && to.getName().contains("end_"))
			  	{  
				  fillBranches(from, to, g, getBranches(g, ((Gateway)originalNode), ((Gateway)branch.get(i)), false));
			  	}
			  else
			  	{ g.addControlFlow(from, to); }
			  originalNode = branch.get(i);
		  	}
		  g.addControlFlow(to, end);
	    }
	 }
	 
	 
	 
	 
	 private static FlowNode transformTChoreographyTaskToExtendedActivity(TChoreographyTask ct, TChoreography chor) throws BPMNmalformedException
	 	{
		 FlowNode node;
		 TParticipant sender = resolveQNameTParticipant(ct.getInitiatingParticipantRef(), chor);
         TParticipant receiver;
         List<QName> qnameParticipants = ct.getParticipantRef();
         if ( ! (qnameParticipants.get(0).toString().equals(ct.getInitiatingParticipantRef().toString())))
        	 {receiver = resolveQNameTParticipant(qnameParticipants.get(0), chor);}
         else
         	 {receiver = resolveQNameTParticipant(qnameParticipants.get(1), chor);}
		 node = new ExtendedActivity(ct, sender, receiver);
		 TMessageFlow messageRequest = null;
		 try
		 	{ messageRequest = resolveQNameTMessage(ct.getMessageFlowRef().get(0), chor); }
		 catch(java.lang.IndexOutOfBoundsException ex) 
		 	{String error = ("["+RefactorWorkflowGraph.class.getName() +"] ERROR. attached message not found for ChoreographyTask "+ct.getName());
		  	   error += ("\n tasks must have messages equals to operations of relative WSDLs");
		  	   throw new BPMNmalformedException(error);
		  	}
		 if ( ! (messageRequest.getSourceRef().toString().equals(ct.getInitiatingParticipantRef().toString())))
		 	{// this is the response message. the request is the other one
			 messageRequest = resolveQNameTMessage(ct.getMessageFlowRef().get(1), chor);
		 	}
		  TMessage messageRequestRef = null;
		  try { messageRequestRef = InteractionTreeBuilder.getMessage(messageRequest.getMessageRef().getLocalPart()); }
		  catch(java.lang.NullPointerException ex)
		  	  {String error = ("["+RefactorWorkflowGraph.class.getName() +"] ERROR. attached message not found for ChoreographyTask "+ct.getName());
  		  	   error += ("\n tasks must have messages equals to operations of relative WSDLs");
  		  	   throw new BPMNmalformedException(error);
		  	  }
		  @SuppressWarnings("unused")
		QName b = ((TMessage)messageRequestRef).getItemRef();
		  @SuppressWarnings("unused")
		String c = messageRequestRef.getItemRef().getLocalPart();
		  TItemDefinition item = null; 
		  String method = null;
		  try{
		   item = InteractionTreeBuilder.getItem(messageRequestRef.getItemRef().getLocalPart()); 
		   method = item.getStructureRef().getLocalPart();
		  } 
		  catch(java.lang.NullPointerException ex) {ex.printStackTrace();}
		  /*
		   * method can be in 3 forms:
		   *  1) structureRef="namespace:method_name"
		   *  2) structureRef="../WSDLFile/AirTrafficControl.wsdl#//@eMessages.9"
		   *  3) structureRef="method_name"
		   * I have to reach just the method_name
		   */
		  Pattern pattern1 = Pattern.compile("(.)+\\.wsdl#(.)+\\.[0-9]+");
		  Matcher matcher1 = pattern1.matcher(method);
		  Pattern pattern2 = Pattern.compile("(.)+:(.)+");
		  Matcher matcher2 = pattern2.matcher(method);
		  if (matcher1.matches())
		  	{// 2) structureRef="wsdl_path/wsdl_name.wsdl#//@eMessages.number"
			  String wsdl_path = method.split("#//")[0];
			  int message_number = Integer.parseInt((((method.split("#//"))[1]).split("\\."))[1]) ;
			  try { 
			      SAXBuilder builder = new SAXBuilder(); 
			      String[] path = wsdl_path.split("/");
			      PartesInfo pi = null;
			      for (PartesInfo p : PartesMain.instance.servicesWsdlUrl)
			      	{
			    	  if (p.getModelImplClass().equals(receiver.getName()))
			    		{
			    		  pi = p;
			    		  break;
			    		}
			      	}
			      if (pi == null)
			      	{
			    	  throw new NullPointerException("wsdl for the role '"+receiver.getName()+"' not found");
			      	}   
			      Document document = builder.build(pi.getWsdlLocation()); 
			      Element root = document.getRootElement(); 
			      List<Element> elements = root.getChildren();
			      int counter=-1;
			      for (Element elem : elements)
			      	{
			    	  if (elem.getName().equals("message"))
			    	  	{
			    		  counter++;
			    		  if (counter == message_number)
			    		  {
			    			  String message_name = elem.getAttributeValue("name");
			    			  ((ExtendedActivity)node).fillMessage(message_name);
			    			  break;
			    		  }
			    	  	}
			      	}    
			      } 
			    catch (Exception e) 
			    	{ e.printStackTrace(); } 
		  	}
		  else
		  	{
			  if (matcher2.matches())
			  	{  //1) structureRef="namespace:method_name"
				  ((ExtendedActivity)node).fillMessage((method.split(":"))[1]);
			  	}
			  else 
			  	{  //3) structureRef="method_name"
				  ((ExtendedActivity)node).fillMessage(method);
			  	}
		  	}
		 ((ExtendedActivity)node).setMethodClass(receiver.getName()); //the method is invoked by the sender to the receiverRecepitRegistry_PortTypeRecepitRegistry_PortType
		 //System.out.println(ct.getName()+"     "+sender.getName()+" ---  " +((ExtendedActivity)n).getMethod()+ "  ----> "+receiver.getName());
		 printDebug(ct.getName()+"     "+sender.getName()+" --> "+receiver.getName());
		 return node;
	 	}
	 
	 
	 
	 
	 
	 private static void printDebug(String message)
	 {
	  if (PartesMain.instance.doDebug())
	  	{
		  log.info(message);
	  	}
	 }
	 
	 
	 private static String generateName()
		{
		 return Math.random()+"";
		} 
	 
	 
	 
}

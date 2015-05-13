package unicam.refactorWorkflowgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpt.graph.abs.IFragment;
import org.jbpt.pm.AndGateway;
import org.jbpt.pm.ControlFlow;
import org.jbpt.pm.FlowNode;
import org.jbpt.pm.Gateway;
import org.jbpt.pm.OrGateway;
import org.jbpt.pm.XorGateway;
import org.omg.spec.bpmn._20100524.model.TChoreography;
import org.omg.spec.bpmn._20100524.model.TChoreographyTask;
import org.omg.spec.bpmn._20100524.model.TExclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TFlowNode;
import org.omg.spec.bpmn._20100524.model.TInclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TItemDefinition;
import org.omg.spec.bpmn._20100524.model.TMessage;
import org.omg.spec.bpmn._20100524.model.TMessageFlow;
import org.omg.spec.bpmn._20100524.model.TParallelGateway;
import org.omg.spec.bpmn._20100524.model.TParticipant;
import org.omg.spec.bpmn._20100524.model.TSequenceFlow;

import partes.exception.BPMNmalformedException;
import partes.exception.PartesErrors;
import partes.refactorRunner.InteractionTreeBuilder;
import partes.service.PartesMain;
import unicam.reduceParallelGateway.InterleavingTree;
import unicam.reduceParallelGateway.ReduceInclusiveGateway;
import unicam.reduceParallelGateway.ReduceParallelGateway;
import unicam.reduceParallelGateway.TreeNode;
import unicam.utils.ExtendedActivity;
import unicam.utils.ExtendedRPST;
import unicam.utils.IOUtils4Mac;

import java.io.*; 

import org.jdom.*; 
import org.jdom.input.*; 



public class RefactorWorkflowGraphWithRPST { 
	
	//how many times the rpst has been rebuild
	private static int iteration_rpst = 0;
	public static String IMAGEfilesPATH="";
	public static String modeDirPath="";
	private static Log log = LogFactory.getLog(RefactorWorkflowGraph.class);
	

	
	/**gets a BPMN choreography and returns a WorkflowGraph.
	 * accepts just  ChoreographyTasks, OR (inclusive), XOR (exclusive) and AND (parallel) gateways
	 * @param iMAGEfilesPATH 
	 * @throws BPMNmalformedException 
	 * @throws IOException 
	 * @throws JDOMException 
	 * */
	public static WorkflowGraph from_BPMN_to_WorkflowGraph(TChoreography chor, String modeDir) throws BPMNmalformedException, JDOMException, IOException
		{
		 modeDirPath = modeDir;
		 IMAGEfilesPATH=modeDirPath + File.separator + "refactoring/";
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
					 String error = PartesErrors.WRONG_STARTING_NODE+" "+start;
					 printDebug(error);
				 	 throw new BPMNmalformedException(error);
				 	}
			}


		 return G;
		}
	
	/**
	 * create a  WorkflowGraph of just  ChoreographyTasks, XOR and AND gateways;
	 * The condition is associated to the outgoing arrow from a OR or XOR gateway. is empty otherwise
	 * @param g
	 * @param flowElem
	 * @param previous
	 * @param chor
	 * @param condition
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	private static void buildWfG(WorkflowGraph g, TFlowNode flowElem, FlowNode previous, TChoreography chor, String condition) throws JDOMException, IOException 
	{
	 FlowNode n = null;
	 if (flowElem instanceof TChoreographyTask)  
	 	{
		 TChoreographyTask ct = (TChoreographyTask)flowElem;
         TParticipant sender = resolveQNameTParticipant(ct.getInitiatingParticipantRef(), chor);
         TParticipant receiver;
         List<QName> qnameParticipants = ct.getParticipantRef();
         if ( ! (qnameParticipants.get(0).toString().equals(ct.getInitiatingParticipantRef().toString())))
        	 {receiver = resolveQNameTParticipant(qnameParticipants.get(0), chor);}
         else
         	 {receiver = resolveQNameTParticipant(qnameParticipants.get(1), chor);}
		 n = new ExtendedActivity(ct, sender, receiver);
		 TMessageFlow messageRequest = resolveQNameTMessage(ct.getMessageFlowRef().get(0), chor);
		 if ( ! (messageRequest.getSourceRef().toString().equals(ct.getInitiatingParticipantRef().toString())))
		 	{// this is the response message. the request is the other one
			 messageRequest = resolveQNameTMessage(ct.getMessageFlowRef().get(1), chor);
		 	}
		  TMessage messageRequestRef = InteractionTreeBuilder.getMessage(messageRequest.getMessageRef().getLocalPart());
		  TItemDefinition item = InteractionTreeBuilder.getItem(messageRequestRef.getItemRef().getLocalPart()); 
		  String method = item.getStructureRef().getLocalPart();
		  /*
		   * method can be in 2 forms:
		   *  1) structureRef="namespace:method_name"
		   *  2) structureRef="../WSDLFile/AirTrafficControl.wsdl#//@eMessages.9"
		   * I have to reach just the method_name
		   */
		  Pattern pattern = Pattern.compile("(.)+\\.wsdl#(.)+\\.[0-9]+");
		  Matcher matcher = pattern.matcher(method);
		  if (matcher.matches())
		  	{// 2) structureRef="wsdl_path/wsdl_name.wsdl#//@eMessages.number"
			  String wsdl_path = method.split("#//")[0];
			  int message_number = Integer.parseInt((((method.split("#//"))[1]).split("\\."))[1]) ;
			      SAXBuilder builder = new SAXBuilder(); 
			      String[] path = wsdl_path.split("/");
			      Document document = builder.build(new File(modeDirPath + File.separator + path[path.length-1])); 
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
			    			  ((ExtendedActivity)n).fillMessage(message_name);
			    			  break;
			    		  }
			    	  	}
			      	}    
		  	}
		  else
		  	{//1) structureRef="namespace:method_name"
			  ((ExtendedActivity)n).fillMessage((method.split(":"))[1]); 
		  	}
		 ((ExtendedActivity)n).setMethodClass(receiver.getName()); //the method is invoked by the sender to the receiverRecepitRegistry_PortTypeRecepitRegistry_PortType
		 //System.out.println(ct.getName()+"     "+sender.getName()+" ---  " +((ExtendedActivity)n).getMethod()+ "  ----> "+receiver.getName());
		 printDebug(ct.getName()+"     "+sender.getName()+" --> "+receiver.getName()); 
	 	}
	 else if (flowElem instanceof TParallelGateway)
	 	{
		 n = new AndGateway(flowElem.getName());
	 	}
	 else if (flowElem instanceof TExclusiveGateway)
	 	{
		 n = new XorGateway(flowElem.getName());
	 	}
	 else if (flowElem instanceof TInclusiveGateway)
	 	{
		 n = new OrGateway(flowElem.getName());
	 	}
	 if (n != null)
		 {
		  n.setId(flowElem.getId());
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
		       		 	}
		       	 	}
		       	}
		     g.addControlFlow(previous, n);
		     if (gatewayAlreadyExplored)
		     	{return;}
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
					if (arrow.getConditionExpression() != null)
						{buildWfG(g, nextElement, n, chor, arrow.getConditionExpression().getContent().toString());}
					else
						{buildWfG(g, nextElement, n, chor, "");}
					break;
				   }
			     } 
		}
	}
	
	
	
	
	public static ExtendedRPST from_WorkflowGraph_to_RPST(WorkflowGraph g)
       {
		ExtendedRPST rpst = new ExtendedRPST(g);
		if (PartesMain.instance.doDebug())
			{
			 try 
			 {
			  IOUtils4Mac.invokeDOT(IMAGEfilesPATH, "rpst_"+iteration_rpst+".png", rpst.toDOT());
			  iteration_rpst++;
		 	 } 
			 catch (IOException e) {e.printStackTrace();}
			}
		return rpst;
	   }
	
	
	/**returns a refactored WorkflowGraph, with just one big ExclusiveGateway
	 * @throws BPMNmalformedException */
	public static WorkflowGraph refactorWorflowGraph (WorkflowGraph g) throws BPMNmalformedException
		{
		 g.printWfG(IMAGEfilesPATH, iteration_rpst);
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
		  ExtendedRPST rpst = from_WorkflowGraph_to_RPST(g);
		  ArrayList<Gateway> reducedGateways = new ArrayList<Gateway>();
		  //looking for the start-gateway
		  boolean recalculateRpst = false;
				for(IFragment<ControlFlow<FlowNode>, FlowNode> leaf : rpst.getDeepestFragment())
					{ 
					 Iterator<ControlFlow<FlowNode>> cfIterator = leaf.iterator();
					 while(cfIterator.hasNext())
						{
						 ControlFlow<FlowNode> cf = cfIterator.next(); //control flow
						 
						 
						 
						 if(! reducedGateways.contains(cf.getSource()) && !reducedGateways.contains(cf.getTarget()))
						 {
							 
							//====== OR GATEWAY ========
 						  if (cf.getSource() instanceof OrGateway && g.contains(cf.getSource()))// g can not contain a FlowNode because it could be already deleted by a rule
						   {
							  OrGateway innerGateway = (OrGateway) cf.getSource();
							  printDebug("deepest enter OrGateway "+cf.getSource().getName()); 
							  // looking for the ending gateway
							  ArrayList<FlowNode> successors = g.getSuccessors(innerGateway );
							  Iterator<FlowNode> successorIter = successors.iterator();
							  OrGateway endingGateway = null;
							  while (successorIter.hasNext())
								  	{
									  FlowNode s = successorIter.next();
									  if (s instanceof OrGateway)
									  	{
										  endingGateway = (OrGateway) s;
										 break;
										}
								  	}
							  ReduceInclusiveGateway.reduceInclusiveGateway(innerGateway, endingGateway, g);
							  g.printWfG(IMAGEfilesPATH, iteration_rpst);
							  recalculateRpst=true;
						   }
 						  
 						  
 						
						  if (cf.getSource() instanceof XorGateway && g.contains(cf.getSource()))//g can not contain a FlowNode because it could be already deleted by a rule
					 		{
							 XorGateway innerGateway = (XorGateway) cf.getSource();
							 // looking for the ending gateway
							 XorGateway endingGateway = null;
							 ArrayList<FlowNode> successors = g.getSuccessors(innerGateway );
								 if (successors.size() > 0 &&
									 successors.get(successors.size()-1) instanceof XorGateway && 
									 g.getPredecessors(successors.get(successors.size()-1)).contains(innerGateway)
									)
							  		{
									 endingGateway = (XorGateway) successors.get(successors.size()-1);
									 if (endingGateway != null && g.getEdge(endingGateway, innerGateway) != null)
									 	{ // ======= XOR CYCLE GATEWAY (repeat - until) ========
										  //	ENTERING REPEAT-UNTIL
										  printDebug("deepest enter repeat-until cycle XorGateway "+cf.getSource().getName());
								 
										  ArrayList<ArrayList<FlowNode>> branches = getBranches(g, innerGateway, endingGateway, false);
										  if (branches.size()>1)
										  	{
											  String error = "ERROR  found wired ending gateway repeat_until. It should have just 1 repeated flow !!";
											  printDebug(error);
											  throw new BPMNmalformedException(error);
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
										  recalculateRpst=true;
										  g.printWfG(IMAGEfilesPATH, iteration_rpst);
									 	} 
									 else if (endingGateway != null)
									 	{// ======= XOR GATEWAY ========
										 // ENTERING XOR_GATEWAY
										 printDebug("deepest enter XorGateway "+cf.getSource().getName());
										 //	move previous tasks into the XorGateway #RULE 1
										 rule1 (innerGateway,g);
										 g.printWfG(IMAGEfilesPATH, iteration_rpst);
										 //move next tasks into the XorGateway #RULE 2
										 rule2 (endingGateway,g);
										 g.printWfG(IMAGEfilesPATH, iteration_rpst);
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
											 g.printWfG(IMAGEfilesPATH, iteration_rpst);
										 	}
										 else if(leftMostPredecessor instanceof XorGateway && g.getDirectSuccessors(leftMostPredecessor).size()<2)
										 	{
											 merge_ending_starting_XOR_gateway(g, (XorGateway)leftMostPredecessor, innerGateway, endingGateway);
											 g.printWfG(IMAGEfilesPATH, iteration_rpst);
										 	}
										 reducedGateways.add(innerGateway);
										 recalculateRpst=true;
								
									 	}
							  		}
					 		}
 						  
 						  
 						  
						  // ==== AND_GATEWAY =====
						  if (cf.getSource() instanceof AndGateway && g.contains(cf.getSource()))//g can not contain a FlowNode because it could be already deleted by a rule
						 	{ // ENTERING AND_GATEWAY
							 AndGateway innerGateway = (AndGateway) cf.getSource();
							 printDebug("deepest enter AndGateway "+cf.getSource().getName());
							 // looking for the ending AndGateway
							  Iterator<FlowNode> successorIter = g.getSuccessors(innerGateway).iterator();
							  FlowNode endingGateway = null;
							  while (successorIter.hasNext())
							  	{
								  FlowNode s = successorIter.next();
								  if (s instanceof AndGateway)
								  	{
									  endingGateway = s;
									 break;
									}
							  	}
							 
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
								 XorGateway endingXor = new XorGateway("Xor");
								 XorGateway startingXor = new XorGateway("Xor");
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
							 g.removeFlowNode(endingGateway);
							 reducedGateways.add(innerGateway);
							 g.printWfG(IMAGEfilesPATH, iteration_rpst);
							 recalculateRpst=true;
							} 
						 }
						}
					 if (recalculateRpst)
					 	{break;}
					}
		 }
		g.organizeTracesAccordingToConditions(IMAGEfilesPATH, iteration_rpst);
		g.finalPrint(IMAGEfilesPATH, iteration_rpst);
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
	private static void merge_ending_starting_XOR_gateway(WorkflowGraph g, XorGateway leftEndingXor, XorGateway rightStartXor, XorGateway rightEndXor) 
	{
		 
		  Collection<FlowNode> predecessors = g.getDirectPredecessors(leftEndingXor); // b, d
		  ArrayList<ArrayList<FlowNode>> branches = getBranches(g, rightStartXor, rightEndXor,true); // {[e,f] , [g,h]}
		  g.removeFlowNode(leftEndingXor);
		  g.removeFlowNode(rightStartXor);
		  for (FlowNode predecessor : predecessors)
		  	{
			  XorGateway newStartXor = new XorGateway("xor");
			  XorGateway newEndXor = new XorGateway("xor");
			  fillBranches(newStartXor, newEndXor, g, branches);
			  g.addControlFlow(predecessor, newStartXor);
			  g.addControlFlow(newEndXor, rightEndXor);
		  	}
	 	
		
	}

	private static void transformTreeToXorGateways(FlowNode wfgraphNode, TreeNode treeNode, FlowNode endingNode, WorkflowGraph g) 
	{
	 FlowNode start = wfgraphNode;
	 boolean create_ending_xor=false;
	 // starting node
	 if ( !(wfgraphNode instanceof XorGateway) && treeNode.getSons().size() > 1)
	  {
		XorGateway xor = new XorGateway("Xor");
		g.addControlFlow(wfgraphNode, xor);
		start = xor;
		create_ending_xor = true;
	  }
	 else if (wfgraphNode == null)
	 	{
		 wfgraphNode = new XorGateway("Xor");
		 start = wfgraphNode;
		 create_ending_xor = true;
	 	}
	 
	 // ending node
	 if ( endingNode != null && create_ending_xor)
	 	{
		 XorGateway xor = new XorGateway("xor");
		 g.addControlFlow(xor, endingNode);
	 	 endingNode = xor;
	 	}
	 else if (create_ending_xor)
	 	{
		 endingNode = new XorGateway("xor");
	 	}
	 
	 
	 if (treeNode.getSons().size()==0)
	 	{g.addControlFlow(start, endingNode);}
	 else
	 	{
		 for (TreeNode son:treeNode.getSons())
		 	{
			 FlowNode from = start;
			 for (ExtendedActivity to:son.getCts())
		  		{
				 to = (ExtendedActivity) to.clone();
				 g.addControlFlow(from, to);
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
	 XorGateway newStartXor = new XorGateway("Or");
	 XorGateway newEndXor = new XorGateway("Or");
	 if (g.getDirectPredecessors(startAndGateway).size()>0)
		 {g.addControlFlow(g.getDirectPredecessors(startAndGateway).iterator().next(), newStartXor);}
	 if (g.getDirectSuccessors(endAndGateway).size()>0)
		 {g.addControlFlow(newEndXor, g.getDirectSuccessors(endAndGateway).iterator().next());}
	//prepare the others branch of the ANDgateway, to clone in the new XorGateways
	 ArrayList<ArrayList<FlowNode>> andBranches = getBranches(g, startAndGateway, startXorGateway, true); 
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
		 AndGateway newStartAnd = new AndGateway("Parallel");
		 AndGateway newEndAnd = new AndGateway("Parallel");
		 //add the new AND to the new XOR
		 g.addControlFlow(newStartXor, newStartAnd);
		 g.addControlFlow(newEndAnd, newEndXor);
		 //add one of the choice's branch
		 g.addControlFlow(newStartAnd, xorBranch);
		 if (g.getSuccessors(xorBranch).size()>1)
		 	{//if successors.size==1, it's just the endXorGateway
			 g.addControlFlow(g.getSuccessors(xorBranch).get(g.getSuccessors(xorBranch).size()-2), newEndAnd);
			 }
		 else
		 	{
			 g.addControlFlow(xorBranch, newEndAnd);
		 	}
		 
		 //add the branches of the outerAndGateway
		 fillBranches(newStartAnd, newEndAnd, g, andBranches);
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
	 g.removeFlowNode(endAndGateway);
	 g.removeFlowNode(startAndGateway);
	 g.removeFlowNode(endXorGateway);
	 g.removeFlowNode(startXorGateway);
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
	  * returns all the branches, and if @remove==true, removes all the CTs from the relative WorkflowGraph
	  *   / \--->a-->b-->c-->/ \
	  *   \ /--->d-->e-->f-->\ /
	  * 
	  * returns ArrayList<ArrayList<FlowNode>>
	  *       -------
	  *       |0|0|a|
	  *       |0|1|b|
	  *       |0|2|c|
	  *       |1|0|d|
	  *       |1|1|e|
	  *       |1|2|f|
	  *       -------
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
			  ArrayList<FlowNode> successors = g.getSuccessors(startingCt);
			  if(remove)
				  {g.removeFlowNode(startingCt);}
			  if(successors.get(successors.size()-1) instanceof Gateway)
				  {successors.remove(successors.size()-1);}//remove the endGateway
			  for(FlowNode node : successors)
			 	{
				 branch.add(node);
				 if(remove)
					 {g.removeFlowNode(node);}
			 	}
			  branches.add(branch);
			 }
		 	}
		 return branches;
	 	}
	
	
	/**
	 * <pre>
	 * transform a matrix in branches
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
	 * </pre> 
	 * */
	 public static void fillBranches (FlowNode start, FlowNode end, WorkflowGraph g, ArrayList<ArrayList<FlowNode>> branches)
	 {
	  for(ArrayList<FlowNode> branch : branches)
	    {
		  FlowNode to = branch.get(0).clone();
		  FlowNode from=null;
		  g.addControlFlow(start, to);
		  for (int i=1; i<branch.size();i++)
		  	{
			  from = to;
			  to = branch.get(i).clone();
			  g.addControlFlow(from, to);
		  	}
		  g.addControlFlow(to, end);
	    }
	 }
	 
	 
	 
	 private static void printDebug(String message)
	 {
	  if (true||PartesMain.instance.doDebug())
	  	{
		  log.info(message);
	  	}
	 }
	 
	 
	 
	 
}

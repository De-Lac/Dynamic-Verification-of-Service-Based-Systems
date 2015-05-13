package unicam.refactorWorkflowgraph;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;

import ucsb.BPMNtoXSB.exception.BPMNmalformedException;
import ucsb.BPMNtoXSB.service.PartesMain;
import ucsb.BPMNtoXSB.utils.PartesConf;
import unicam.atl.BPMN2toWFG.files.FromBPMN2toWFT;
import unicam.reduceParallelGateway.InterleavingTree;
import unicam.reduceParallelGateway.ReduceParallelGateway;
import unicam.reduceParallelGateway.TreeNode;
import unicam.utils.IOUtils4Mac;
import unicam.workflowgraph.Action;
import unicam.workflowgraph.Branch;
import unicam.workflowgraph.ExclusiveChoice;
import unicam.workflowgraph.Gateway;
import unicam.workflowgraph.ParallelExecution;
import unicam.workflowgraph.WfgNode;
import unicam.workflowgraph.WorkFlowGraph;





public class RefactorWorkflowGraph { 
	
	//how many times the rpst has been rebuild
	private static Log log = LogFactory.getLog(RefactorWorkflowGraph.class);
	private WorkFlowGraph wfg;
	private String bpmn2file;
	

	
	
	/**
	 * passing the bpmn2file file and the path where to save the wfg model, this class
	 * create a {@link WorkFlowGraph}, retrievable invoking  getWfg() 
	 * 
	 * @param bpmn2file
	 * 			 file path + file name + extension (should be bpmn2) of the bpmn2 choreography
	 * @param workflowGraph
	 * 			the name of the model to save (just the name, without extension and path)
	 * @param workflowGraphPath
	 * 		   the path where to save the wfg model 
	 * @throws BPMNmalformedException 
	 * @throws FileNotFoundException 
	 */
	public RefactorWorkflowGraph (String bpmn2file, String wfgFileName, String wfgFilePath) throws FileNotFoundException, BPMNmalformedException
	{
	 this.bpmn2file=bpmn2file;
	 from_BPMN_to_WorkflowGraph(wfgFileName,  wfgFilePath);
	}
	
	
	public WorkFlowGraph getWfg()
	{return wfg;}
	
	
	/**gets a BPMN choreography and returns a WorkflowGraph.
	 * accepts just  ChoreographyTasks, OR (inclusive), XOR (exclusive) and AND (parallel) gateways
	 * @param iMAGEfilesPATH 
	 * @throws BPMNmalformedException 
	 * @throws ATLCoreException 
	 * @throws FileNotFoundException 
	 * */
	private WorkFlowGraph from_BPMN_to_WorkflowGraph(String wfgFileName, String wfgFilePath) throws BPMNmalformedException, FileNotFoundException
		{
//		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bpmn2", new Bpmn2ResourceFactoryImpl());
		try 
			{ wfg = FromBPMN2toWFT.doFromBPMN2toWFT(bpmn2file, wfgFileName, wfgFilePath); 
			 return wfg; 
			}
		catch (ATLCoreException e) 
			{e.printStackTrace();
			 throw new BPMNmalformedException(e.getMessage());} 
		catch (IOException e) 
			{
			 e.printStackTrace();
			 throw new FileNotFoundException(e.getMessage());
		     }
		}
	
	
	
//	/**
//	 * return the ending element of the subChoreography. Previous nodes will be already linked in the WfG
//	 * @param g
//	 * @param tSubChoreography
//	 * @param previous
//	 * @param chor
//	 * @param condition
//	 * @return
//	 * @throws BPMNmalformedException 
//	 */
//	private static Node from_SubChoreography_to_SubWorkflowGraph(WorkflowGraph g, TSubChoreography subChor, TChoreography chor, Node previous, String condition) throws BPMNmalformedException 
//	{
//		for (JAXBElement<? extends TFlowElement> telem : subChor.getFlowElement())
//			{ // add elements of the subChor into the general Chor
//			 TFlowElement elem = telem.getValue();
//			 if (elem instanceof TGateway || elem instanceof TSequenceFlow || elem instanceof TChoreographyTask)
//			 	{ chor.getFlowElement().add(telem); }
//			 else if ( !(elem instanceof TStartEvent) && !(elem instanceof TEndEvent))
//			 	{
//				 String error = PartesErrors.BPMN_ELEMENT_NOT_MATCHED +elem.getName();
//				 log.error(error);
//			 	 throw new BPMNmalformedException(error);
//			 	}
//			} 
//		Iterator<JAXBElement<? extends TFlowElement>> flowElemIter = subChor.getFlowElement().iterator();
//		while ( flowElemIter.hasNext() )
//				{
//			      TFlowElement flowElem = flowElemIter.next().getValue();
//
//			      if (flowElem instanceof TStartEvent)
//			      {
//			    	  QName arrowName = ((TStartEvent) flowElem).getOutgoing().get(0); 
//			    	  Iterator<JAXBElement<? extends TFlowElement>> flowElements = subChor.getFlowElement().iterator();
//			    	  TNode nextElement = null;
//			    				while(flowElements.hasNext())
//			    				    {
//			    					 TFlowElement fte = flowElements.next().getValue();
//			    					 if (fte.getId().equals(arrowName.getLocalPart()))
//			    					   {
//			    						// a sequenceFlow is an arrow
//			    						TSequenceFlow arrow = (TSequenceFlow) fte;
//			    						nextElement =((TNode)arrow.getTargetRef());
//			    						return buildWfG(g, nextElement, previous, chor, condition);
//			    					   }
//			    				     } 
//			    	  if ( nextElement == null)
//			    	  	{
//			    		 String error = PartesErrors.SUB_CHOREOGRAPHY_WITHOUT_START+ "check "+ subChor.getName();
//			    		 printDebug(error);
//						 throw new BPMNmalformedException(error);
//			    	  	}
//			      }
//				}
//		 return null;
//	}

	
	
	
	
	/**returns a refactored WorkflowGraph, with just one big ExclusiveGateway
	 * @throws BPMNmalformedException 
	 * @throws IOException */
	public WorkFlowGraph refactorWorflowGraph () throws BPMNmalformedException, IOException
		{ 
		 int c=0;
		 while ( wfg.getGateways().size()>2
				 ||
				 (wfg.getGateways().size()==2 &&  !(wfg.getGateways().get(0) instanceof ExclusiveChoice) && !(wfg.getGateways().get(1) instanceof ExclusiveChoice))
			   ) //i should have just one starting and one ending ExclusiveChoice
		 {
		  System.out.println("refactoring...   number of total gateways: "+wfg.getGateways().size()+"    number of nodes: "+wfg.getActions().size());
		  c++;
		  IOUtils4Mac.invokeDOT(PartesMain.instance.conf.OUTPUT_PATH, "wfg"+c+".png", wfg.toDOTforGraphViz());
		  // ===== FINDING INNER GATEWAY ======
		  Gateway stg = null ;
		  Gateway etg = null;
		  
	      // gateways filled. now i'm looking for the inner gateway to reduce
		  Iterator<Gateway> gatIterator = wfg.getGateways().iterator();
	      while (gatIterator.hasNext())
	      	{
	    	  Gateway  startGat = gatIterator.next();
	    	  while (startGat.isMerge() && gatIterator.hasNext())
	    	  	{startGat = gatIterator.next();}
	    	  if (startGat.isMerge())
	    	  	{stg=null;break;}
	    	  Gateway  endGat = startGat.getRefMerge();
	    	  boolean containsOtherGateways = false;
	    	  for( Branch branch : startGat.getBranches())
	    	  	{
	    		  for (WfgNode n : branch.getNodes())
	    		  	{
	    			  if (n instanceof Gateway)
	    			  	{ containsOtherGateways=true; break; }
	    		  	}
	    		  if (containsOtherGateways) {break;}
	    	  	}
	    	  if (!containsOtherGateways)
	    	  	{
	    		  stg = startGat;
	    		  etg = endGat;
	    		  break;
	    	  	}
	    	  
	      	}
	      if (stg == null)
	      	{
	    	  log.error("mmm something strange.. the inner gateway to reduce wasn't found.");
	      	}
		  //  =========================================
							 
							//====== OR GATEWAY ========
// 						  if (stg instanceof OrGateway)
//						   {
//							  OrGateway innerGateway = (OrGateway) stg;
//							  OrGateway endingGateway = (OrGateway) etg;
//							  printDebug("deepest enter OrGateway "+stg.getName()); 
//							  ReduceInclusiveGateway.reduceInclusiveGateway(innerGateway, endingGateway, g);
//							  
//						   }
 						  
 						  
 						
						  if ( stg instanceof ExclusiveChoice )
					 		{
							 ExclusiveChoice innerGateway = (ExclusiveChoice)stg;
							 ExclusiveChoice endingGateway = (ExclusiveChoice) etg;
									 if (endingGateway != null && endingGateway.getSuccessors().contains(innerGateway))
									 	{
										 throw new BPMNmalformedException("repeat-until cycle found. It is not handled yet");
									 	} 
									 else if (endingGateway != null)
									 	{// ======= XOR GATEWAY ========
										 // ENTERING XOR_GATEWAY
										 printDebug("deepest enter ExclusiveChoice "+innerGateway.getName());
										 //	move previous tasks into the ExclusiveChoice #RULE 1
										 rule1 (innerGateway);
										 //move next tasks into the ExclusiveChoice #RULE 2
										 rule2 (endingGateway);
										 
										 //if there is an AND before, put out the XOR
										 WfgNode leftMostPredecessor=null;
										 WfgNode rightMostSuccessor = null;
										 if(getPredecessorsUntilGateway(innerGateway).size()>0)
										 	{leftMostPredecessor= getPredecessorsUntilGateway(innerGateway).get(0);}
										 if(getSuccessorsUntilGateway(endingGateway).size()>0)
										 	{rightMostSuccessor = getSuccessorsUntilGateway(endingGateway).get(getSuccessorsUntilGateway(endingGateway).size()-1);}
										 if (leftMostPredecessor instanceof ParallelExecution && rightMostSuccessor instanceof ParallelExecution)
										 	{
											 merge_starting_AND_XOR_gateways((ParallelExecution)leftMostPredecessor, innerGateway, endingGateway, (ParallelExecution)rightMostSuccessor);
											 
										 	}
										 else if(leftMostPredecessor instanceof ExclusiveChoice && ((ExclusiveChoice)leftMostPredecessor).getSuccessors().size()<2)
										 	{
											 merge_ending_starting_XOR_gateway(innerGateway, (ExclusiveChoice)leftMostPredecessor, innerGateway, endingGateway);
											 
										 	}
										 else
										 	{printDebug(this.getClass().getCanonicalName()+ " WTF?  XORGateway empty else");}

								
									 	}
					 		}
 						  
 						  
 						  
						  // ==== AND_GATEWAY =====
						  if (stg instanceof ParallelExecution )
						 	{ // ENTERING AND_GATEWAY
							 ParallelExecution innerGateway = (ParallelExecution) stg;
							 ParallelExecution endingGateway = (ParallelExecution) etg;
							 printDebug("deepest enter ParallelExecution "+innerGateway.getName());
							 InterleavingTree interleavingTree = new ReduceParallelGateway().reduceParallelGateway(innerGateway, wfg);
							 WfgNode successor = null;
							 try 
							 	{successor = endingGateway.getSuccessors().iterator().next();}
							 catch(java.util.NoSuchElementException e){/*no successor*/}
							 WfgNode predecessor = null;
							 try
							 	{predecessor = innerGateway.getPredecessors().iterator().next();}
							 catch(java.util.NoSuchElementException e){/*no predecessor*/}
							 if (interleavingTree.getRoot().getLeaves().size() > 1)
							 	{// there are more traces. I need to put them into a ExclusiveChoice
								 String gatewayName = generateName();
								 ExclusiveChoice endingXor = wfg.createNewExclusiveChoice("end_"+gatewayName, true, false);
								 ExclusiveChoice startingXor = wfg.createNewExclusiveChoice("start_"+gatewayName, false, true);
								 startingXor.setRefMerge(endingXor);
								 if (successor != null)
								 	{endingXor.add_set_successor(successor);}
								 if (predecessor != null)
								 	{predecessor.add_set_successor(startingXor);}
								 transformTreeToExclusiveChoices(startingXor, interleavingTree.getRoot(), endingXor);
							 	}
							 else
							 	{// I have just one trace, I don't need the xor Gateway
								 transformTreeToExclusiveChoices(predecessor, interleavingTree.getRoot(), successor);
							 	}
							 wfg.removeNode(innerGateway); 
							 wfg.removeNode(endingGateway);
							} 
		 }
		return wfg;
	   }
	
	
	
	
	
	
	
	
	
	private void printDebug(String string) 
	{
		System.out.println(string);
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
	private void merge_ending_starting_XOR_gateway(ExclusiveChoice leftStartXor, ExclusiveChoice leftEndingXor, ExclusiveChoice rightStartXor, ExclusiveChoice rightEndXor) 
	{

		Collection<WfgNode> predecessors = leftEndingXor.getPredecessors(); // b, d
		ArrayList<ArrayList<WfgNode>> branches = new ArrayList<ArrayList<WfgNode>>();  // {[e,f] , [g,h]}
		for(Branch branch : rightStartXor.getBranches()) 
		   { branches.add(new ArrayList<WfgNode>(Arrays.asList(branch.getNodes().toArray(new WfgNode[branch.getNodes().size()])))); }
		for(Branch branch : rightStartXor.getBranches())
			{ wfg.removeNodes(branch.getNodes()); }
		rightEndXor.setName(leftEndingXor.getName());
		wfg.removeNode(leftEndingXor);
		wfg.removeNode(rightStartXor);
		wfg.removeNode(rightStartXor);
		wfg.removeNode(leftStartXor);
		leftStartXor.setRefMerge(rightEndXor);
		for (WfgNode predecessor : predecessors)
		{
			String gatewayName = generateName();
			ExclusiveChoice newStartXor = wfg.createNewExclusiveChoice("start_"+gatewayName, false, true);
			ExclusiveChoice newEndXor = wfg.createNewExclusiveChoice("end_"+gatewayName, true, false);
			newStartXor.setRefMerge(newEndXor);
			fillBranches(newStartXor, newEndXor, branches);
			predecessor.add_set_successor(newStartXor);
			newEndXor.add_set_successor(rightEndXor);
		}


	}

	private  void transformTreeToExclusiveChoices(WfgNode startingNode, TreeNode treeNode, WfgNode endingNode) 
	{
	 String gatewayName = generateName();
	 // starting node
	 if ( !(startingNode instanceof ExclusiveChoice) && treeNode.getSons().size() > 1)
	  {
		ExclusiveChoice sxor = wfg.createNewExclusiveChoice("start_"+gatewayName, false, true);
		startingNode.add_set_successor(sxor);
		startingNode = sxor;
		
		 // ending node
		ExclusiveChoice exor = wfg.createNewExclusiveChoice("end_"+gatewayName, true, false);
		exor.add_set_successor(endingNode);
	 	endingNode = exor;
	 	sxor.setRefMerge(exor);
	  }
	 
	 
	 if (treeNode.getSons().size()==0)
	 	{startingNode.add_set_successor(endingNode);}
	 else
	 	{
		 for (TreeNode son:treeNode.getSons())
		 	{
			 WfgNode from = startingNode;
			 for (WfgNode to:son.getCts())
		  		{
				 to = (WfgNode) to.clone();
				 wfg.addNode(to);
				 if (from != null)
					 {from.add_set_successor(to);}
				 from=to;
		  		}
			 transformTreeToExclusiveChoices(from, son, endingNode);
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
	 * @throws BPMNmalformedException 
	 * @throws IOException 
	 * */
	private  void rule1 (ExclusiveChoice innerGateway) throws BPMNmalformedException, IOException
	{ printDebug("rule 1");
	  // OuterGateway-->a-->b-->InnerGateway-->c   becomes   OuterGateway-->InnerGateway-->a-->b-->c
	  // =====  remove old edges ======
	  //i starts from 1. [0] could be a gateway to not remove. i check this later
	  ArrayList<WfgNode> predecessors = getPredecessorsUntilGateway(innerGateway);
	  for(int i=1; i<predecessors.size(); i++)
	  	{
		 wfg.removeNode(predecessors.get(i));
	  	}
	  if(predecessors.size()==0)
	  	{return;}
	  if (!( predecessors.get(0) instanceof Gateway))
	    {
		  wfg.removeNode(predecessors.get(0));
		}
		
	// =====  create new edges ======
	  Gateway outerGateway = null;
	  if(predecessors.get(0) instanceof Gateway)
  		{
		  predecessors.get(0).add_set_successor(innerGateway);
		  outerGateway = (Gateway) predecessors.get(0);
		  predecessors.remove(0);
  		}
	  if (predecessors.size() > 0)
	  {
		//WORKAROUND, If I delete in the for directly from getSuccessors(), I have java.util.ConcurrentModificationException
		// so I use successorToUnset
	   ArrayList<WfgNode> successorToUnset = new ArrayList<WfgNode>();   
	   for(WfgNode successor : innerGateway.getSuccessors())
	   	{
		   successorToUnset.add(successor); 
	   	}
	   for(WfgNode successor : successorToUnset)
	   {
		 innerGateway.remove_unset_successor(successor);
		 ArrayList<ArrayList<WfgNode>> branch = new ArrayList<ArrayList<WfgNode>>();
	     branch.add(predecessors);
		 fillBranches(innerGateway, successor, branch);
	   }
	  }
		 
	  if (outerGateway != null)
	 	{
		 if (outerGateway instanceof ExclusiveChoice && outerGateway.getSuccessors().size()>1)
			 { // ExclusiveChoice-->ExclusiveChoice-->b
			  printDebug("merge between "+innerGateway.getName()+" and "+outerGateway.getName());
			  merge_starting_ExclusiveChoices((ExclusiveChoice)innerGateway, (ExclusiveChoice)outerGateway);
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
	 * @throws BPMNmalformedException 
	 * @throws IOException 
	 * */
	private  void rule2 (ExclusiveChoice endingGateway) throws BPMNmalformedException, IOException
	{ printDebug("rule 2");
	  // EndingGateway-->a-->b-->c-->OuterGateway   becomes  a-->b-->c-->EndingGateway-->OuterGateway
	  // =====  remove old edges ======
	  // successors[size] could be a gateway to not remove. i check this later
	  ArrayList<WfgNode> successors = getSuccessorsUntilGateway(endingGateway);
	  if (successors.size()>0)
	  {
	   for(int i=0; i<successors.size()-1; i++)
	  	{
		 wfg.removeNode(successors.get(i));
	  	}
	   if (!( successors.get(successors.size()-1) instanceof Gateway))
	    {
		  wfg.removeNode(successors.get(successors.size()-1));
		}
		
	// =====  create new edges ======
	   Gateway outerGateway = null;
	   if(successors.get(successors.size()-1) instanceof Gateway)
  		{
		  endingGateway.add_set_successor(successors.get(successors.size()-1));
		  outerGateway = (Gateway) successors.get((successors.size()-1));
		  successors.remove(successors.size()-1);
  		}
	  
	   if (successors.size() >0)
	   {
	    for(WfgNode predecessor: endingGateway.getPredecessors())
	    { 
	 	 predecessor.remove_unset_successor(endingGateway);
	 	 ArrayList<ArrayList<WfgNode>> branch = new ArrayList<ArrayList<WfgNode>>();
	 	 branch.add(successors);
	 	 fillBranches(predecessor, endingGateway, branch);
	    }
	   }
	  
	   if ( outerGateway != null)
	 	{ // b-->ExclusiveChoice-->ExclusiveChoice
		   printDebug("merge between "+endingGateway.getName()+" and "+outerGateway.getName());
		 if (outerGateway instanceof ExclusiveChoice && outerGateway.getSuccessors().size()<2)
			 {merge_ending_ExclusiveChoices((ExclusiveChoice)endingGateway, (ExclusiveChoice)outerGateway);}
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
	 * @throws BPMNmalformedException 
	 * */
	private  void merge_starting_AND_XOR_gateways(ParallelExecution startParallelExecution, ExclusiveChoice startExclusiveChoice, ExclusiveChoice endExclusiveChoice, ParallelExecution endParallelExecution) throws BPMNmalformedException
	{
	 String gatewayName = generateName();
	 ExclusiveChoice newStartXor = wfg.createNewExclusiveChoice("start_"+gatewayName, false, true);
	 ExclusiveChoice newEndXor = wfg.createNewExclusiveChoice("end_"+gatewayName, true, false);
	 newStartXor.setRefMerge(newEndXor);
	 if (startParallelExecution.getPredecessors().size()>0)
		 {startParallelExecution.getPredecessors().get(0).add_set_successor(newStartXor);}
	 if (endParallelExecution.getSuccessors().size()>0)
		 {newEndXor.add_set_successor(endParallelExecution.getSuccessors().get(0));}
	//prepare the others branch of the ParallelExecution, to clone in the new ExclusiveChoices
	 ArrayList<ArrayList<WfgNode>> andBranches = new ArrayList<ArrayList<WfgNode>>() ;  // {[e,f] , [g,h]}
		for(Branch branch : startParallelExecution.getBranches()) 
		   { andBranches.add(new ArrayList<WfgNode>(Arrays.asList(branch.getNodes().toArray(new WfgNode[branch.getNodes().size()])))); }
		for(Branch branch : startParallelExecution.getBranches())
			{ wfg.removeNodes(branch.getNodes()); }
	 // remove the branch with the xor
	 for (ArrayList<WfgNode> branch : andBranches)
	 	{
		 if (branch.get(0) == startExclusiveChoice)
		 	{andBranches.remove(branch);
		 	 break;
		 	}
	 	}
	 for( WfgNode xorBranch : startExclusiveChoice.getSuccessors())
	 	{
		 gatewayName = generateName();
		 ParallelExecution newStartAnd = wfg.createNewParallelExecution("start_"+gatewayName, false, true);
		 ParallelExecution newEndAnd = wfg.createNewParallelExecution("end_"+gatewayName, true, false);
		 newStartAnd.setRefMerge(newEndAnd);
		 //add the new AND to the new XOR
		 newStartXor.add_set_successor(newStartAnd);
		 newEndAnd.add_set_successor(newEndXor);
		 //add one of the choice's branch
		 newStartAnd.add_set_successor(xorBranch);
		 if (getSuccessorsUntilGateway(xorBranch).size()>1)
		 	{//if successors.size==1, it's just the endExclusiveChoice
			  ArrayList<WfgNode> sccs = getSuccessorsUntilGateway(xorBranch);
			  WfgNode lastOfTheBranch = sccs.get(getSuccessorsUntilGateway(xorBranch).size()-2);
			 lastOfTheBranch.add_set_successor(newEndAnd);
			 }
		 else
		 	{
			 xorBranch.add_set_successor(newEndAnd);
		 	}
		 
		 //add the branches of the outerParallelExecution
		 
		 fillBranches(newStartAnd, newEndAnd, andBranches);
		 
	 	}
	 
	 // ======= PORCHETTA===============
	 for(ArrayList<WfgNode> branch : andBranches)
	 	{
		 Gateway stg = null;
		 Gateway eng = null;
		 for(WfgNode node : branch)
			 {
			  if (node instanceof Gateway && stg == null)
			  	{ stg = (Gateway)node; }
			  else if (node instanceof Gateway && stg != null)
			  	{ 
				  eng = (Gateway)node;
				  
				  for(Branch br : stg.getBranches())
					{ wfg.removeNodes(br.getNodes()); } // remove internal branches
				  wfg.removeNode(stg); // remove no-more-used gateways
				  wfg.removeNode(eng);
				}
			  else {wfg.removeNode(node);}
			 }
	 	}
	 
	// ================================
	 
	 
	 wfg.removeNode(endParallelExecution);
	 wfg.removeNode(startParallelExecution);
	 wfg.removeNode(endExclusiveChoice);
	 wfg.removeNode(startExclusiveChoice);
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
	private void merge_starting_ExclusiveChoices(ExclusiveChoice innerG, ExclusiveChoice OuterG)
	{
	 Collection<WfgNode> successors = innerG.getSuccessors();
	 for (WfgNode successor : successors)
	 	{
		 OuterG.add_set_successor(successor);
	 	}
	 wfg.removeNode(innerG);
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
	private void merge_ending_ExclusiveChoices(ExclusiveChoice innerG, ExclusiveChoice OuterG)
	{
	 Collection<WfgNode> predecessors = innerG.getPredecessors();
	 for (WfgNode predecessor : predecessors)
	 	{
		 predecessor.add_set_successor(OuterG);
	 	}
	 wfg.removeNode(innerG);
	}

	
	
	
	/**
	 * <pre>
	 * Transform a matrix in branches. 
	 * ATTENTION!! Two nodes of a branch could be a starting and ending gateway. in this case, the nodes between
	 * should be considered
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
	 public  void fillBranches (WfgNode start, WfgNode end, ArrayList<ArrayList<WfgNode>> branches)
	 {
	  for(ArrayList<WfgNode> branch : branches)
	    {
		  WfgNode originalNode = branch.get(0);
		  WfgNode to = null;
		  String newName="";
		  if (originalNode instanceof Gateway && originalNode!=start && originalNode!=end)
		  	{
			  if (originalNode instanceof ExclusiveChoice)
			  	{
				  if (originalNode.getName().contains("start_"))
					  { newName = generateName(); }
				  to = wfg.createNewExclusiveChoice(originalNode.getName() + newName, true, false);
				  if (start.getName().contains("start_") &&  to.getName().contains("end_"))
				  	  {((ExclusiveChoice)start).setRefMerge((ExclusiveChoice)to);}
				}
			  else if (originalNode instanceof ParallelExecution)
			  	{
				  if (originalNode.getName().contains("start_"))
				  	{ newName = generateName(); }
				  to = wfg.createNewParallelExecution(originalNode.getName() + newName, true, false);
				  if (start.getName().contains("start_") &&  to.getName().contains("end_"))
			  	  	{((ParallelExecution)start).setRefMerge((ParallelExecution)to);}
			  	}
		  	}
		  else
		  	{to = originalNode.clone(); wfg.addNode(to);}
		  WfgNode from=null;
		  start.add_set_successor(to);
		  for (int i=1; i<branch.size();i++)
		  	{
			  from = to;
			  if (branch.get(i) instanceof Gateway && branch.get(i)!=start && branch.get(i)!=end)
			  	{
				  if (branch.get(i) instanceof ExclusiveChoice)
					  {
						  if (branch.get(i).getName().contains("start_"))
							  { newName = generateName(); }
						  to = wfg.createNewExclusiveChoice(branch.get(i).getName() + newName, true, false);
						  if (from.getName().contains("start_") &&  to.getName().contains("end_"))
					  	  	{((ExclusiveChoice)from).setRefMerge((ExclusiveChoice)to);}
					  }
				  else if (branch.get(i) instanceof ParallelExecution)
			  	  	{
					  if (branch.get(i).getName().contains("start_"))
					  	{ newName = generateName();}
					  to = wfg.createNewParallelExecution(branch.get(i).getName() + newName, true, false);
				  	  if (from.getName().contains("start_") &&  to.getName().contains("end_"))
			  	  		{((ParallelExecution)from).setRefMerge((ParallelExecution)to);}
			  	  	}
			  	}
			  else
			  	{to = branch.get(i).clone();wfg.addNode(to);}
			  if (from instanceof Gateway && from.getName().contains("start_") &&
			      to instanceof Gateway && to.getName().contains("end_"))
			  	{  
				  ArrayList<ArrayList<WfgNode>> tempBranches = new ArrayList<ArrayList<WfgNode>>();
					for(Branch tempBranch : ((Gateway)originalNode).getBranches()) 
					   { tempBranches.add(new ArrayList<WfgNode>(Arrays.asList(tempBranch.getNodes().toArray(new WfgNode[tempBranch.getNodes().size()])))); }
				  fillBranches(from, to, tempBranches);
			  	}
			  else
			  	{ from.add_set_successor(to); }
			  originalNode = branch.get(i);
		  	}
		  to.add_set_successor(end);
	    }
	 }
	 
	
	 
	 private static String generateName()
		{
		 return Math.random()+"";
		} 
	 
	
	 
	 
//	 /*==========================================/*==========================================*//*==========================================*/
	 
	 
	 
	 /** get the previous predecessors list until the next gateway. predecessors[0] = the most left element, probably a gateway
	 * @throws BPMNmalformedException */
	 public  ArrayList<WfgNode> getPredecessorsUntilGateway(WfgNode node) throws BPMNmalformedException
		{
		 	if (node instanceof Gateway && 
		 			(
		 			 ((Gateway)node).isMerge() ||
		 			 ((Gateway)node).getPredecessors().size()>1)
		 			 )
		 		{throw new BPMNmalformedException("gateway "+node.getName()+" has many predecessor.it should be a Fork gateway, Something wrong");}
			ArrayList<WfgNode> predecessors = new ArrayList<WfgNode> (); 
			return addPredecessors(node, predecessors);
		}
		
		
		/**predecessors[0] = the most left element, probably a gateway*/
		private  ArrayList<WfgNode> addPredecessors(WfgNode node, ArrayList<WfgNode> predecessors)
		{
			WfgNode directPredecessor = null;
			if (node instanceof Action) {directPredecessor = (((Action)node).getPredecessor());}
			else if (node instanceof Gateway) {directPredecessor = (((Gateway)node).getPredecessors().get(0));}
			
			predecessors.add(0, directPredecessor);
			if (directPredecessor==null || directPredecessor instanceof Gateway)
				 	{return predecessors;}
			else 	
				{return addPredecessors(directPredecessor, predecessors);}
		}
		
		/** get the next successors list until the next gateway. successor[size-1] could be a gateway
		 * @throws BPMNmalformedException */
		public ArrayList<WfgNode> getSuccessorsUntilGateway(WfgNode node) throws BPMNmalformedException
		{
			if (node instanceof Gateway && 
					(
					  ((Gateway)node).isFork() ||
					  ((Gateway)node).getSuccessors().size()>1) 
					)
	 			{throw new BPMNmalformedException("gateway "+node.getName()+" has many successors.It should be Merge gateway. Something wrong");}
			ArrayList<WfgNode> successors = new ArrayList<WfgNode> (); 
			return addSuccessors(node, successors);
		}
		
		
		
		private  ArrayList<WfgNode> addSuccessors(WfgNode node, ArrayList<WfgNode> successors)
		{
			WfgNode directSuccessor = null;
			if (node instanceof Action) {directSuccessor = (((Action)node).getSuccessor());}
			else if (node instanceof Gateway) {directSuccessor = (((Gateway)node).getSuccessors().get(0));}

			successors.add(directSuccessor);
			if (directSuccessor==null || directSuccessor instanceof Gateway)
		 		{return successors;}
			else
				{return addSuccessors(directSuccessor, successors);}
		}
	 
		/*==========================================*//*==========================================*//*==========================================*//*==========================================*/
	 	
		
		
}

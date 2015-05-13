package unicam.reduceParallelGateway;


import ucsb.BPMNtoXSB.service.PartesMain;
import unicam.workflowgraph.Gateway;
import unicam.workflowgraph.Participant;
import unicam.workflowgraph.WfgNode;
import unicam.workflowgraph.WorkFlowGraph;
import unicam.workflowgraph.WorkflowgraphFactory;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import unicam.workflowgraph.MessageExchange;
import unicam.workflowgraph.ParallelExecution;


public class ReduceParallelGateway {
	
	private AffectionsGraph originalAg;
	private HashSet <AffectionSet> tracesAffectionSets;
	private InterleavingTree it;
	private Log log = LogFactory.getLog(ReduceParallelGateway.class);

	
	public ReduceParallelGateway()
	{
	 originalAg = new AffectionsGraph();  // it's build by @create_graph
	 tracesAffectionSets = new HashSet <AffectionSet>();// filled up by @isTraceEquivalentToAnyother
	 it = new InterleavingTree(); //filled up by @explore_graph
	}
	

	public InterleavingTree reduceParallelGateway(ParallelExecution pg, WorkFlowGraph g) 
	{
		ArrayList<MessageExchange> cts = new ArrayList<MessageExchange>();
		for(WfgNode ct : pg.getSuccessors())
			{
			 cts.add((MessageExchange) ct);
			}
		create_graph(cts, g);
		explore_graph();
		printDebug("\n\n\n============== results ============");
		it.getRoot().printTree("");
		return it;
		
	}

	private void explore_graph() 
	{
     printDebug("starts the graph exploration");
	 Enumeration<GraphNode> gnIterator = originalAg.getCTs();
	 boolean oneExplorationMade=false;//I should make at least one exploration, even if no node affects another
	 while (gnIterator.hasMoreElements())
	 	{
		 AffectionsGraph clonedGraph = originalAg.clone();
		 GraphNode gn = clonedGraph.getGraphNode(gnIterator.nextElement().getCt());
		 if ( (gn.getAtOut().size()!=0 || gn.getAtIn().size()!=0 ||  !oneExplorationMade)
				&& avoidDuplicates(gn)
			)
		 	{//this affects or is affected, so it needs to be explored
			 printDebug("===== exploration starts from "+gn.getCt().getName()+" ====");
			 ;
//			 if (gn.getAtOut().size()>0 || !oneExplorationMade)
//				 {
				  TreeNode tn = new TreeNode();
				  tn.setGraph(clonedGraph);
				  it.getRoot().addSon(tn); tn.setFather(it.getRoot());
				  resolveStructuralTransitions(gn, tn);
				  tn.appendCt(gn.getCt());
				  for(MessageExchange ct : tn.getCts()) {printDebug(ct.getName()+" ");} 
				  printDebug("\n");
				  ArrayList<GraphNode> nextGns = gn.getAtOut();//i save them here, because if i remove before gn from the graph, i cannot access more to its atOut
				  tn.getGraph().removeGraphNode(gn.getCt());
				  if (nextGns.size() > 0)
				  	{
					  exploreAffected(tn, nextGns,"   ");
				  	}
				  else
				  	{//exploration finished
					  TreeNode child = new TreeNode();
					  tn.addSon(child); child.setFather(tn);child.setGraph(tn.getGraph());
					  appendRemainingCts(child, "   ");
				  	}
//				 }
		 	}
		 oneExplorationMade=true;
	 	}
	 printDebug("===== exploration ended =====");
	}

	
	/**
	 * Given a graphNode <b>gn</b>, this methods explores all the <b>AtOut[gn]</b> (i.e. @affectedList),
	 * appending the traces to the TreeNode @tn 
	 * <pre>
	 * control to avoid duplicated:
	 *     A ~~~> B
	 *     |         
	 *     ~~~> C ~~~> D
	 *     
	 * if I start from A, I should have  AB_CD and ACD_B. 
	 * Since <b>AtOut[B]=0</b> and <b>AtIn[B]=1</b>, it is not useful explore AB_CD, since I have
	 * A~>B relation already covered in ACD_B. 
	 * 
	 * Same thing for:
	 *  A ~~~> B
	 *  |         
	 *  ~~~> C
	 *  
	 *   ABC and ACB are equivalent. One shot is enough.
	 *</pre>
	 */
	private void exploreAffected(TreeNode tn, ArrayList<GraphNode> affectedList, String level) 
	{
		boolean oneAffectedExplored=false; //I should make at least one affected exploration
		for (int i=0; i<affectedList.size();i++)
		{
			GraphNode node = affectedList.get(i);
			
			printDebug(level+"~~~> "+node.getCt());
			//control to avoid duplicated traces (see method documentation)
			//if a don't append remaining cts in each trace, i need the 'true' here
			if (/*true ||*/ (node.getAtOut().size()>0 || node.getAtIn().size()>0) || 
			     (i==affectedList.size()-1 && !oneAffectedExplored) 
			   )
			{
				oneAffectedExplored=true;
				AffectionsGraph cloned = tn.getGraph().clone();
				GraphNode affected = cloned.getGraphNode(node.getCt());
				ArrayList<TreeNode> children = exploreAffecters(null, affected, new ArrayList<TreeNode>(), level+"   ");
				if (children.size() > 0 )
				{
					for (TreeNode child : children)
					{
						tn.addSon(child);
						child.setFather(tn); //????????????? l'ho messo dopo. faccio danni ??????
						for (TreeNode leaf : child.getLeaves())
						{
							TreeNode son = new TreeNode();son.setFather(leaf); leaf.addSon(son);son.setGraph(leaf.getGraph());
							resolveStructuralTransitions(son.getGraph().getGraphNode(affected.getCt()), son);
							son.appendCt(affected.getCt());
							String str =level; printDebug(str+"\n"); for(MessageExchange ct : son.getCts()) {str +=(ct.getName()+" ");} 
							ArrayList<GraphNode> nextGns = son.getGraph().getGraphNode(affected.getCt()).getAtOut();//i save them here, because if i remove before gn from the graph, i cannot access more to its atOut
							son.getGraph().removeGraphNode(affected.getCt());
							if (nextGns.size() > 0)
							{
								exploreAffected(son, nextGns,str+"   ");
							}
							else
							{//exploration finished
								appendRemainingCts(son, str+"   ");
							}
						}
					}
				}
				else
				{
					TreeNode child = new TreeNode();
					child.setGraph(tn.getGraph().clone());
					tn.addSon(child); child.setFather(tn);
					resolveStructuralTransitions(affected, child);
					child.appendCt(affected.getCt());
					String str = level;for(MessageExchange ct : child.getCts()) {str += (ct.getName()+" ");} printDebug(str+"\n");
					ArrayList<GraphNode> nextGns = affected.getAtOut();//i save them here, because if i remove before gn from the graph, i cannot access more to its atOut
					child.getGraph().removeGraphNode(affected.getCt());
					if (nextGns.size() > 0)
					{
						exploreAffected(child, nextGns,level+"   ");
					}
					else
					{//exploration finished
						appendRemainingCts(child, level+"   ");
					}
				}
			}
			else
			{printDebug("not useful. exploration made by someone other");}
		}
	}

	/**
	 * Given a graphNode <b>gn'</b> in <b>AtOut[gn]</b>, this method explores all the possible internal 
	 * states that <b>gn'</b> can have. It explores recursively in turn <b>AtIn[gn']</b>,
	 * appending the traces to the TreeNode @tn 
	 */
	private ArrayList<TreeNode> exploreAffecters(TreeNode tn, GraphNode gn, ArrayList<TreeNode> heads, String level) 
	{
	 gn.mark(); // marked for be visited soon
	 
	 
	 
	 /** ===========================================================
	 *  remove StIn[]* from AtIn[] to avoid duplicated of traces.
	 *  let's take
	 *     _ _ _ _ _ 
	 *     |         |
	 *     -->A ~~~> B <~~~ C
	 *     
	 *     if I start from C, I have  C->B and C->A->B, but both actually are C->A->B and C->A->B
	 *     so I don't consider A ~> B, I remove A from AtIn[B]
	  */
	 ArrayList<GraphNode> list = gn.getAtIn();
	 GraphNode temp = gn.getStIn();
	 while (temp != null)
	 	{
		 list.remove(temp);
	 	 temp = temp.getStIn();
	 	}
	 /*======================================================================*/
	 
	 
	 ArrayList<ArrayList<MessageExchange>> interleavings = generateAllInterleaving(list);
	 for (ArrayList<MessageExchange> interleaving : interleavings)
	 	{
		 TreeNode dad = new TreeNode();
		 if (interleaving == null)  
		 	{//the empty combination
			 printDebug(level+" ?? _~~~> "+gn.getCt().getName());
			 if (tn != null) {tn.addstepFather(dad); dad.addSon(tn); dad.setGraph(tn.getGraph().clone());}
			 else {dad.setGraph(gn.getGraph().clone());}
			 heads.add(dad);
			 } 
		 else
		 	{
			 String str=(level+" ??");for (MessageExchange ct : interleaving) {str+=(ct.getName());str+=("~~~> "+gn.getCt().getName()+"\n");}
			 printDebug(str);
			 if (tn != null) 
			 	{ tn.addstepFather(dad); dad.addSon(tn); dad.setGraph(tn.getGraph().clone()); }
			 else
			 	{ dad.setGraph(gn.getGraph().clone()); }  
			 for (MessageExchange ct : interleaving)
		 		{
				 GraphNode node = dad.getGraph().getGraphNode(ct);
				 if (! isValid(node))
			 		{printDebug(level+" NOT VALID!!"); 
			 		 // This is a trace not valid. Later on i must check if i must delete this tree-branch
			 		MessageExchange fakeNode = WorkflowgraphFactory.eINSTANCE.createMessageExchange();
			 		fakeNode.setSuccessor(null);fakeNode.setPredecessor(null);fakeNode.setRequest(null);fakeNode.setReceiver(null);fakeNode.setSender(null);
			 		dad.appendCt(fakeNode);
			 		break;
			 		}
				 else
			 		{
					 if (dad.getBrothers().size() == 0)
				 		{
						 exploreAffecters(dad, node, heads, level+"   ");
						 brothersCreation(node ,dad, level+"  ");
				 		}
					 else
				 		{
						 for(TreeNode bro : dad.getBrothers())
					 		{
							 ArrayList<TreeNode> subHeads = new ArrayList<TreeNode>();
							 TreeNode nt = new TreeNode();
							 nt.setGraph(bro.getGraph());
							 exploreAffecters(nt, bro.getGraph().getGraphNode(ct), subHeads, level+"   ");
							 brothersCreation(bro.getGraph().getGraphNode(ct) ,nt, level+"  ");
							 for (TreeNode ancestor : subHeads)
						 		{ bro.addSon(ancestor); }
					 		}
				 		}
			 		}
		 		}
			 // ----
			 for (TreeNode bro : dad.getBrothers())
			 	{
				 for (TreeNode leaf : bro.getLeaves())
				 	{	
					 for (TreeNode child : dad.getSons())
			 			{
						 child.addstepFather(leaf);
						 leaf.addSon(child);
			 			}
				 	}
			 	}
			 for (TreeNode child : dad.getSons())
	 			{
				 child.getstepFathers().remove(dad);
	 			}
	 	}
		 }
	 return heads;
	}

	private ArrayList<ArrayList<MessageExchange>> generateAllInterleaving(ArrayList<GraphNode> gns) 
	{
	 ArrayList<MessageExchange> cts = new ArrayList<MessageExchange>();	
	 for(GraphNode gn : gns)
	 	{cts.add(gn.getCt());}
	 return Combinatorics.getAll(cts);
	}

	private void appendRemainingCts(TreeNode tn, String level) 
	{
	 String str=(level+"##");
	 ArrayList<GraphNode> endingList = new ArrayList<GraphNode>();
     for(GraphNode end : tn.getGraph().getEndingGNs())
     	{
    	 // affecting node has the priority to be added first, because in this way
    	 // i can cover other affections in the same trace!  the equivalent
    	 // trace explored later will be discarded
    	 if(end.getAtOut().size()>0)
    	 	{endingList.add(0,end);}
    	 else
    	 	{endingList.add(end);}
     	}
     TreeNode child = new TreeNode();
     child.setGraph(tn.getGraph());
     child.setFather(tn); tn.addSon(child);
     for(GraphNode end : endingList)
        {
    	 resolveStructuralTransitions(end, child);
    	 child.appendCt(end.getCt());
    	 end.getGraph().removeGraphNode(end.getCt());
     	}
     addTraceIfNotEquivalentToAnyother(child);
	 for(MessageExchange ct : child.getCts()) {str+=(ct.getName()+" ");} 
	 printDebug(str+"##\n");
	}

	/**
	 * from the passed TreeNode, a path back to the root make a trace. If that
	 * trace is equivalent to another one already generated, it's discarded. Otherwise
	 * it's added in the {@link #traces} hashmap.
	 * How it works?
	 * From the trace built from the treeBode, I fill up an HashMap
	 * to see which and in which order affecting nodes occur. Starting from the first,
	 * for each task of the trace I add it in the corresponding rows of the affected.
	 * i.e. I have this AffectionGraph
	 * <pre>
	 *    A ~~~> B <~~~ D
	 *    └ ~~~> C <~~~ ┘
	 * </pre>    
	 * and the trace is CDAB.
	 * <pre>
	 *   'C' I add it just in C, and close the row (i can't add no more)
	 *   'D' AtOut[D]={B,C} so I should add D to B and C, beside in D closing that row. 
	 *       but row C is already closed, so I add D just to B and D
	 *   ...
	 * </pre> 
	 * For instance that AffGraph generates traces like: ADCB and ADBC. To investigate 
	 * different influences, the 2 traces can be like 2 hash maps:
	 * <pre>
	 * -------      -------
	 * |A|A  |      |A|A  |
	 * |D|D  |      |D|D  |
	 * |C|ADC|      |B|ADB|
	 * |B|ADB|      |C|ADC|
	 * ------       ------
	 * </pre> 
	 * The two traces are different but equivalent, because their influcences hashMap are egual
	 * @param child
	 *         a leaf of the tree, the back-path until the root represent a trace
	 * @return 
	 */
	private boolean addTraceIfNotEquivalentToAnyother(TreeNode child) 
	{
	 ArrayList<MessageExchange> currentTrace = new ArrayList<MessageExchange>();
	 HashMap<String, ArrayList<String>> currentTraceInfluences = new  HashMap<String, ArrayList<String>>();
     TreeNode treeNode = child;
     // fill the current trace from the last to the first CT
	 while (treeNode != null)
	 	{
		 for (int i=treeNode.getCts().size()-1; i>=0; i--)
		 	{
			 currentTrace.add(0, treeNode.getCts().get(i));
			 currentTraceInfluences.put(treeNode.getCts().get(i).getName(), new ArrayList<String>());
		 	}
		 treeNode = treeNode.getFather();	 
	 	}
	 // fill the affections (which one and in which order)
	 for (MessageExchange ct : currentTrace)
	 	{
		 currentTraceInfluences.get(ct.getName()).add(ct.getName()); //close the row
		 for (GraphNode affected:originalAg.getGraphNode(ct).getAtOut())
		 	{
			 int last = currentTraceInfluences.get(affected.getCt().getName()).size()-1; 
			 if (last<0 || ! currentTraceInfluences.get(affected.getCt().getName()).get(last).equals(affected.getCt().getName()))
				 {//row not closed. add the affecting
				  currentTraceInfluences.get(affected.getCt().getName()).add(ct.getName());
				 }
		 	}
	 	}
	 // check if there are other equivalent traces
	 AffectionSet currentAffectionSet = new AffectionSet();
	 Iterator<ArrayList<String>> inflIter = currentTraceInfluences.values().iterator();
	 while(inflIter.hasNext())
	 	{
		 currentAffectionSet.add(inflIter.next());
	 	 
	 	}
	 if(! tracesAffectionSets.contains(currentAffectionSet))
	   {
		 //current trace is not equivalent to any other one. I add it among other traces
		 tracesAffectionSets.add(currentAffectionSet);
		 return false;
		} 
	 else
	 	{//current trace is equivalent to another.
		 printDebug(currentTrace+ " is equivalent to another one. I discard it");
		
		 // remove the path from the tree
		 treeNode = child;
	     // fill the current trace from the last to the first CT
		 // if treeNode.getFather()==null then treeNode==root
//		 while (treeNode.getFather().getFather() != null)
//		 	{
//			 TreeNode father=treeNode.getFather();
//			 father.getSons().remove(treeNode);
//			 treeNode=father;
//		 	}
		 return true;
	 	}
	}


	/**
	 * @param GraphNode: all the incoming structural transitions are explored in cascade, adding the relative cts to the TreeNode tn
	 * @param TreeNode: the tn where to add the cts */
	private void resolveStructuralTransitions(GraphNode gn, TreeNode tn) 
		{
		 GraphNode back = gn.getStIn();
	     if(back != null)
	     	{
	    	 back = tn.getGraph().getGraphNode(back.getCt());
	    	 if (back != null)
	    		 {
	    		  tn.prefixCt(back.getCt());
	    		  resolveStructuralTransitions( back, tn);
	    		  tn.getGraph().removeGraphNode(back.getCt());
	    		 }
	     	}
		}

	/**
	 * @param branches: an array of the firsts CT of a parallel gateway
	 */
	private  void create_graph(ArrayList<MessageExchange> cts, final WorkFlowGraph g) 
	{
		printDebug("======= GRAPH CREATION ========");
		ArrayList<Thread> threads = new ArrayList<Thread>();
		printDebug( "creating structural transitions.");
		for (final MessageExchange ct	 : cts)
			{			
			Thread t = new Thread ()
			 {	 
			  public void run()
			    {
				  printDebug("thread "+this.getId()+" started");
				  create_structuralTransitions(new GraphNode(ct), originalAg, this.getId(), g); 
				  printDebug("		thread "+this.getId()+" ended");
			    }
			 };
			 threads.add(t);
			 t.start();
			}
		for (Thread t : threads)
			{
			 try {t.join();} 
			 catch (InterruptedException e) {e.printStackTrace();}
			}
		printDebug("threads terminated");
		create_affectTransitions();
//		originalAg.printAffG();
	}

	
	
	
	
	
	
	
	
	
	
private void create_affectTransitions()
	{
	  printDebug("creating affect transitions");
	  AdjacentTable adj = originalAg.getAdjTable();
	  Enumeration<ArrayList<MessageExchange>> ctIterator = adj.getValues();
	  while(ctIterator.hasMoreElements())
	  	{
		 ArrayList<MessageExchange> affectingList = ctIterator.nextElement();
		 for(MessageExchange affecting: affectingList)
		 	{
			 Participant receiver = affecting.getReceiver();
			 ArrayList<MessageExchange> affectedList = adj.get(receiver.getName());
			 if (affectedList!=null)
			 {
			  for(MessageExchange affected : affectedList)
			 	{
				// devo togliere pero' l'affect transition verso StIn(), non ha senso
				// se sono dello stesso branch, li controllo o no? 
				// if (affecting.getBranchNumber() != affected.getBranchNumber())
					 {originalAg.createAffectTransition(affecting, affected);}
			 	}
			 }
		 	}
	  	}	
	  // elimino le affect transition verso StIn()*
	  
	  
	}

/**scan sequentially next cts and add them to the affections-graph
 * @param GraphNode gn:  gn - - -> gn.next - - -> gn.next.next
 * @param AffectionGraph ag: the graph where fill the structural transitions
 * @param branchNumber 
 */
private void create_structuralTransitions(GraphNode gn, AffectionsGraph ag, long branchNumber, WorkFlowGraph g)
{
// gn.getCt().setBranchNumber(branchNumber);
 if (gn.getCt().getPredecessor() instanceof ParallelExecution)
 	{// it's the first ct of one branch
	 ag.addCT(gn);
	 ag.addStartingGN(gn);
 	}
 if ( ! (gn.getCt().getSuccessor() instanceof Gateway))
 	{
	 GraphNode nextGn = new GraphNode((MessageExchange) (gn.getCt().getSuccessor()));
	 ag.addCT(nextGn);
	 printDebug(gn.getCt().getName()+" - - -> "+nextGn.getCt().getName()+ "   [thread "+Thread.currentThread().getId()+"] "+Thread.currentThread().getId());
	 nextGn.setStIn(gn); 	//structural transition
	 create_structuralTransitions(nextGn, ag, branchNumber,g);
 	}
 else
 	{ag.addEndingGN(gn);}
 
 // WORKAROUND!!!!!! really bad, quick and dirty...====================
 boolean b=true;
 while(b){
 try {g.removeNode(gn.getCt());b=false;} 
 catch(Exception e)
 	{System.out.println("problem in deleting "+gn.getCt().getName());b=true;}
  //probably because the attribute NAME is set as unique in the metamodel, instead is not unique
 }
 // ================================================================================
}



private void brothersCreation(GraphNode gn, TreeNode tn, String level)
	{
	 if (tn.getstepFathers().size() != 0)
	 	{
		 for (TreeNode stepf : tn.getstepFathers())
		 	{
			 if (! stepf.getCts().toString().toLowerCase().contains("nooo"))
			 	{
				 TreeNode bro = new TreeNode();
				 bro.setFather(stepf); stepf.addSon(bro);
				 stepf.getSons().remove(tn);
				 tn.addBrothers(bro);
				 bro.setGraph(stepf.getGraph());
			 
				 GraphNode ggn = bro.getGraph().getGraphNode(gn.getCt());
				 resolveStructuralTransitions(ggn, bro);
				 bro.appendCt(ggn.getCt());
				 bro.getGraph().removeGraphNode(ggn.getCt());
				 String str=level; for(MessageExchange ct : bro.getCts()) {str += (ct.getName()+" ");} printDebug(str);
			 	}
			 else
			 	{stepf = null;}
		 	}
		 tn.getstepFathers().clear();
	 	}
	 else
	 	{
		 resolveStructuralTransitions(gn, tn);
		 tn.appendCt(gn.getCt());
		 String str = level; for(MessageExchange ct : tn.getCts()) {str += (ct.getName()+" ");} printDebug(str);
		 tn.getGraph().removeGraphNode(gn.getCt());
	 	}
	}


  private void printDebug(String message)
  {
   log.info(message);
  }
  
  /**
   * Before trying to write a node 'gn' in a trace, should be checked is it has already 
   * been marked before. This method
   * checks if 'gn', or one among all its StIn[gn]*, is marked.
   * If a marked node is found, the current trace is not valid.
   */
    private boolean isValid(GraphNode gn)
    	{
  	  if (gn.isMarked())
  	  	{return false;}
  	  else
  	  	{if (gn.getStIn()!=null)
  	  		{return isValid(gn.getStIn());}
  	  	else
  	  		{return true;}
  	  	}
    	}
    
    
    /**
     * return true if the exploration should continue, false otherwise, if this GraphNode should be jumped
     * CASO 1 <br>
	 * If a node 'B' affects a node 'C' that is affected also by a node 'A' such that 'A' is in StIn[B]*,
	 * when the exploration starts from B, is not necessary explore B->C because it is explored by the
	 * exploration that starts from 'A'
	 * <pre>
	 *   _ _ _ _ _ _ _ _ 
	 *  |                |
	 *  -> A ~~~> C <~~~ B
	 *            ^
	 *            |- -E
	 *            
	 * A:  (AEBC), AEC, AC, [ABC], ABEC
	 * B:  (ABEC), [ABC]   <--- I can avoid these
	 * 
	 * </pre>
	 * CASO 2<br>
	 * If a node 'C' affects a node 'B' that is affected also by a node 'A' such that 'A' is in StIn[B]*,
	 * ,if B doesn't affect anything, is not necessary starts the exploration from B, because all the traces are already generated from A.
	 * Anyway I need the A ~> B to generate trace ACB
	 * <pre>
	 *   _ _ _ _ _ 
	 *  |         |
	 *  -->A ~~~> B <~~~ C
	 *            
	 *            
	 * A:  (ABC), ACB
	 * B:  (ABC)  <--- I can avoid this
	 * C:  CAB
	 * 
	 * </pre>
	 * @param gn
	 */
	private boolean avoidDuplicates(GraphNode gn) 
	{
		// ==== CASO 1 ======
		
	 for(int i=0; i<gn.getAtOut().size();i++)
	 	{
		 GraphNode affected = gn.getAtOut().get(i);
		 GraphNode stin=null;
		 try{stin = gn.getStIn();}catch(NullPointerException ex){}
		 while (stin!=null)
			 {
			  if (affected.getAtIn().contains(stin))
			  	{ // AtIn[C]* contains A
				 printDebug(gn.getCt().getName()+" ~~> "+affected.getCt().getName()+" is explored by "+stin);
				 gn.getAtOut().remove(affected); // [A]B ~~> C is not necessary to be explored
				 i--;
				 affected.getAtIn().remove(gn);
				 break;
				}
			  try{stin = stin.getStIn();}catch(NullPointerException ex){stin=null;}
			 }
	 	}
	 
	 // ==== CASO 2 da testare ====
	 Vector<GraphNode> stins = new Vector<GraphNode>();
	 GraphNode temp = gn.getStIn();
	 while (temp != null)
	 	{
		 stins.add(temp);
		 temp = temp.getStIn();
	 	}
	 for(int i=0; i<gn.getAtIn().size();i++)
	 	{
		 GraphNode affected = gn.getAtIn().get(i);
		 if (stins.contains(affected))
		 	{
			 gn.getAtOut().clear();
			 System.out.println("exploration from "+gn+" shouldn't start at all. It's useless");
			 return false;
		 	}
	 	}
	 return true;
	 
		
	}
	
	
	
	
	
	/**
	 * 
	 * <pre>
	 *    A ~~~> B <~~~ D
	 *    └ ~~~> C <~~~ ┘
	 * </pre>    
	 * A trace can be ADCB
	 * -------      
	 * |A|A  |      
	 * |D|D  |      
	 * |C|ADC|      
	 * |B|ADB|      
	 * ------       
	 * the relative AffectionSet is=[{A}, {D}, {A D C}, {A D B}]
	 *
	 */
	protected class AffectionSet
	{
		
	  private HashSet<ArrayList<String>> affections;
		
	  
	  public AffectionSet()
	  {
		  affections = new HashSet<ArrayList<String>>();  
	  }
	  
	  
	 @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((affections == null) ? 0 : affections.hashCode());
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
			AffectionSet other = (AffectionSet) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (affections == null) {
				if (other.affections != null)
					return false;
			} else if (!affections.equals(other.affections))
				return false;
			return true;
		}

	
	 
	 public boolean add(ArrayList<String> aff)
	 {
		 return affections.add(aff);
	 }

	private ReduceParallelGateway getOuterType() {
		return ReduceParallelGateway.this;
	}
	}

}


package unicam.reduceParallelGateway;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpt.pm.AndGateway;
import org.jbpt.pm.FlowNode;
import org.jbpt.pm.Gateway;
import org.omg.spec.bpmn._20100524.model.TChoreographyTask;
import org.omg.spec.bpmn._20100524.model.TParticipant;
import org.ow2.choreos.partes.ChoreographyInteractionTreeGenerator;

import partes.service.PartesMain;
import unicam.refactorWorkflowgraph.WorkflowGraph;
import unicam.utils.ExtendedActivity;


public class ReduceParallelGateway {
	
	private AffectionsGraph originalAg;
	private InterleavingTree it;
	private Log log = LogFactory.getLog(ReduceParallelGateway.class);

	
	public ReduceParallelGateway()
	{
	 originalAg = new AffectionsGraph();  // it's build by @create_graph
	 it = new InterleavingTree(); //filled up by @explore_graph
	}
	

	public InterleavingTree reduceParallelGateway(AndGateway pg, WorkflowGraph g) 
	{
		ArrayList<ExtendedActivity> cts = new ArrayList<ExtendedActivity>();
		for(FlowNode ct : g.getDirectSuccessors(pg))
			{
			 cts.add((ExtendedActivity) ct);
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
		 if (gn.getAtOut().size()!=0 || gn.getAtIn().size()!=0 ||  !oneExplorationMade)
		 	{//this affects or is affected, so it needs to be explored
			 printDebug("===== exploration starts from "+gn.getCt().getName()+" ====");
			 avoidDuplicates(gn);
//			 if (gn.getAtOut().size()>0 || !oneExplorationMade)
//				 {
				  TreeNode tn = new TreeNode();
				  tn.setGraph(clonedGraph);
				  it.getRoot().addSon(tn); tn.setFather(it.getRoot());
				  resolveStructuralTransitions(gn, tn);
				  tn.appendCt(gn.getCt());
				  for(ExtendedActivity ct : tn.getCts()) {printDebug(ct.getName()+" ");} 
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
	 */
	private void exploreAffected(TreeNode tn, ArrayList<GraphNode> affectedList, String level) 
	{
	 for (GraphNode node : affectedList)
	 	{printDebug(level+"~~~> "+node.getCt());
	 	 AffectionsGraph cloned = tn.getGraph().clone();
	 	 GraphNode affected = cloned.getGraphNode(node.getCt());
		 ArrayList<TreeNode> children = exploreAffecters(null, affected, new ArrayList<TreeNode>(), level+"   ");
		 if (children.size() > 0 )
		 {
		  for (TreeNode child : children)
		 	{
			 tn.addSon(child);
			 for (TreeNode leaf : child.getLeaves())
			 	{
				 TreeNode son = new TreeNode();son.setFather(leaf); leaf.addSon(son);son.setGraph(leaf.getGraph());
				 resolveStructuralTransitions(son.getGraph().getGraphNode(affected.getCt()), son);
				 son.appendCt(affected.getCt());
				 	String str =level;for(ExtendedActivity ct : son.getCts()) {level +=(ct.getName()+" ");} printDebug(str+"\n");
				 ArrayList<GraphNode> nextGns = son.getGraph().getGraphNode(affected.getCt()).getAtOut();//i save them here, because if i remove before gn from the graph, i cannot access more to its atOut
				 son.getGraph().removeGraphNode(affected.getCt());
				 if (nextGns.size() > 0)
				 	{
					 exploreAffected(son, nextGns,level+"   ");
				 	}
				 else
				 	{//exploration finished
					 appendRemainingCts(son, level+"   ");
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
			 	String str = level;for(ExtendedActivity ct : child.getCts()) {str += (ct.getName()+" ");} printDebug(str+"\n");
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
	}

	/**
	 * Given a graphNode <b>gn'</b> in <b>AtOut[gn]</b>, this method explores all the possible internal 
	 * states that <b>gn'</b> can have. It explores recursively in turn <b>AtIn[gn']</b>,
	 * appending the traces to the TreeNode @tn 
	 */
	private ArrayList<TreeNode> exploreAffecters(TreeNode tn, GraphNode gn, ArrayList<TreeNode> heads, String level) 
	{
	 gn.mark(); // marked for be visited soon
	 ArrayList<ArrayList<ExtendedActivity>> interleavings = generateAllInterleaving(gn.getAtIn());
	 for (ArrayList<ExtendedActivity> interleaving : interleavings)
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
			 String str=(level+" ??");for (ExtendedActivity ct : interleaving) {str+=(ct.getName());str+=("~~~> "+gn.getCt().getName()+"\n");}
			 printDebug(str);
			 if (tn != null) 
			 	{ tn.addstepFather(dad); dad.addSon(tn); dad.setGraph(tn.getGraph().clone()); }
			 else
			 	{ dad.setGraph(gn.getGraph().clone()); }  
			 for (ExtendedActivity ct : interleaving)
		 		{
				 GraphNode node = dad.getGraph().getGraphNode(ct);
				 if (isValid(node))
			 		{printDebug(level+" NOT VALID!!"); 
			 		 // This is a trace not valid. Later on i must check if i must delete this tree-branch
			 		 dad.appendCt(new ExtendedActivity(null, null, null));
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

	private ArrayList<ArrayList<ExtendedActivity>> generateAllInterleaving(ArrayList<GraphNode> gns) 
	{
	 ArrayList<ExtendedActivity> cts = new ArrayList<ExtendedActivity>();	
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
    	 endingList.add(end);
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
	 for(ExtendedActivity ct : child.getCts()) {str+=(ct.getName()+" ");} printDebug(str+"##\n");
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
	private  void create_graph(ArrayList<ExtendedActivity> cts, final WorkflowGraph g) 
	{
		printDebug("======= GRAPH CREATION ========");
		ArrayList<Thread> threads = new ArrayList<Thread>();
		printDebug( "creating structural transitions.");
		for (final ExtendedActivity ct	 : cts)
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
		originalAg.printAffG();
	}

	
	
	
	
	
	
	
	
	
	
private void create_affectTransitions()
	{
	  printDebug("creating affect transitions");
	  AdjacentTable adj = originalAg.getAdjTable();
	  Enumeration<ArrayList<ExtendedActivity>> ctIterator = adj.getValues();
	  while(ctIterator.hasMoreElements())
	  	{
		 ArrayList<ExtendedActivity> affectingList = ctIterator.nextElement();
		 for(ExtendedActivity affecting: affectingList)
		 	{
			 TParticipant receiver = affecting.getReceiver();
			 ArrayList<ExtendedActivity> affectedList = adj.get(receiver.getName());
			 if (affectedList!=null)
			 {
			  for(ExtendedActivity affected : affectedList)
			 	{
				 if (affecting.getBranchNumber() != affected.getBranchNumber())
					 {originalAg.createAffectTransition(affecting, affected);}
			 	}
			 }
		 	}
	  	}		
	}

/**scan sequentially next cts and add them to the affections-graph
 * @param GraphNode gn:  gn - - -> gn.next - - -> gn.next.next
 * @param AffectionGraph ag: the graph where fill the structural transitions
 * @param branchNumber 
 */
private void create_structuralTransitions(GraphNode gn, AffectionsGraph ag, long branchNumber, WorkflowGraph g)
{
 gn.getCt().setBranchNumber(branchNumber);
 ExtendedActivity ciao = gn.getCt();
  Collection<FlowNode> bau = g.getDirectPredecessors(ciao);
  FlowNode b = bau.iterator().next();
  Collection<FlowNode> pp = g.getDirectPredecessors(b);
 if (g.getDirectPredecessors(gn.getCt()).iterator().next() instanceof AndGateway)
 	{// it's the first ct of one branch
	 ag.addCT(gn);
	 ag.addStartingGN(gn);
 	}
 if ( ! (g.getDirectSuccessors(gn.getCt()).iterator().next() instanceof Gateway))
 	{
	 GraphNode nextGn = new GraphNode((ExtendedActivity) g.getDirectSuccessors(gn.getCt()).iterator().next());
	 ag.addCT(nextGn);
	 printDebug(gn.getCt().getName()+" - - -> "+nextGn.getCt().getName()+ "   [thread "+Thread.currentThread().getId()+"] "+Thread.currentThread().getId());
	 nextGn.setStIn(gn); 	//structural transition
	 create_structuralTransitions(nextGn, ag, branchNumber,g);
 	}
 else
 	{ag.addEndingGN(gn);}
 g.removeFlowNode(gn.getCt());
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
				 String str=level; for(ExtendedActivity ct : bro.getCts()) {str += (ct.getName()+" ");} printDebug(str);
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
		 String str = level; for(ExtendedActivity ct : tn.getCts()) {str += (ct.getName()+" ");} printDebug(str);
		 tn.getGraph().removeGraphNode(gn.getCt());
	 	}
	}


  private void printDebug(String message)
  {
   if (PartesMain.instance.doDebug())
 	{
	 log.info(message);
 	}
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
	 * @param gn
	 */
	private void avoidDuplicates(GraphNode gn) 
	{
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
		
	}
	
	
	public static void main(String[] args)
	{
		PartesMain pm = new PartesMain();
		pm.debug=true;
		ExtendedActivity a;
		ExtendedActivity b;
		ExtendedActivity c;
		ExtendedActivity d;
		ExtendedActivity e;
		ExtendedActivity f;
		ExtendedActivity g;
		ExtendedActivity h;
		ExtendedActivity i;
		{
		 TParticipant sender = new TParticipant(); sender.setName("1");
		 TParticipant receiver = new TParticipant(); receiver.setName("11");
		 TChoreographyTask t = new TChoreographyTask(); t.setName("a"); t.setId("a");
		  a = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("3");
			 TParticipant receiver = new TParticipant(); receiver.setName("4");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("b");t.setId("b");
			  b = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("14");
			 TParticipant receiver = new TParticipant(); receiver.setName("11");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("c");t.setId("c");
			  c = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("7");
			 TParticipant receiver = new TParticipant(); receiver.setName("8");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("d");t.setId("d");
			  d = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("9");
			 TParticipant receiver = new TParticipant(); receiver.setName("3");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("e");t.setId("e");
			  e = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("11");
			 TParticipant receiver = new TParticipant(); receiver.setName("12");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("f");t.setId("f");
			  f = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("13");
			 TParticipant receiver = new TParticipant(); receiver.setName("14");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("g");t.setId("g");
			  g = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("15");
			 TParticipant receiver = new TParticipant(); receiver.setName("16");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("h");t.setId("h");
			  h = new ExtendedActivity(t, sender, receiver);
		}
		{
			 TParticipant sender = new TParticipant(); sender.setName("17");
			 TParticipant receiver = new TParticipant(); receiver.setName("18");
			 TChoreographyTask t = new TChoreographyTask(); t.setName("i");t.setId("i");
			  i = new ExtendedActivity(t, sender, receiver);
		}		
		
		
		ArrayList<ExtendedActivity> cts = new ArrayList<ExtendedActivity>();
		cts.add(a);
		cts.add(d);
		cts.add(g);
		
		WorkflowGraph wg = new WorkflowGraph();
		AndGateway sag = new AndGateway();
		AndGateway eag = new AndGateway();
		wg.addControlFlow(sag, a);wg.addControlFlow(a, b); wg.addControlFlow(b, c);wg.addControlFlow(c, eag);  
		wg.addControlFlow(sag, d);wg.addControlFlow(d, e); wg.addControlFlow(e, f);wg.addControlFlow(f, eag);
		wg.addControlFlow(sag, g);wg.addControlFlow(g, h); wg.addControlFlow(h, i);wg.addControlFlow(i, eag);
		ReduceParallelGateway tis = new ReduceParallelGateway();
		tis.create_graph(cts, wg);
		tis.explore_graph();
		tis.printDebug("\n\n\n============== results ============");
		tis.it.getRoot().printTree("");
		
		
	}

}


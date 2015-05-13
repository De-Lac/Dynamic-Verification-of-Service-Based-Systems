package unicam.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.jbpt.algo.tree.rpst.IRPSTNode;
import org.jbpt.algo.tree.rpst.RPST;
import org.jbpt.graph.abs.IFragment;
import org.jbpt.pm.ControlFlow;
import org.jbpt.pm.FlowNode;

import partes.service.PartesMain;
import unicam.refactorWorkflowgraph.WorkflowGraph;

public class ExtendedRPST extends RPST<ControlFlow<FlowNode>, FlowNode>
{
	private int maxHeight = 0;
	
	public ExtendedRPST(WorkflowGraph g)
	{
	 super(g);
	 setNodesHeight(getChildren(getRoot()), 0);
	}
	
	
	private void setNodesHeight(Set<IRPSTNode<ControlFlow<FlowNode>, FlowNode>> children, int h)
	{
	 for (IRPSTNode<ControlFlow<FlowNode>, FlowNode> child : children)
		{
		 child.setHeight(h);
		 setNodesHeight(getChildren(child), h+1);
		}
	 if (h > maxHeight) {maxHeight = h;}
	}
	
	
	public int getMaxHeight()
	{
	 return maxHeight;
	}
	
	
	public  ArrayList<IFragment<ControlFlow<FlowNode>, FlowNode>> getDeepestFragment()
	{
	int deepestLevel = 0;
	ArrayList <IFragment<ControlFlow<FlowNode>, FlowNode>> fragmentsToReduce = new ArrayList <IFragment<ControlFlow<FlowNode>, FlowNode>>();
	
	Iterator<IRPSTNode<ControlFlow<FlowNode>, FlowNode>> nodeIterator = getRPSTNodes().iterator();
	printDebug("==== RPST =====");
	while(nodeIterator.hasNext())
		{
		 IRPSTNode<ControlFlow<FlowNode>, FlowNode> node = nodeIterator.next();
		 if (node.getHeight() > deepestLevel)
		 	{deepestLevel = node.getHeight();
		 	 fragmentsToReduce.clear();
		 	}
		 if (node.getHeight() == deepestLevel)
		 	{
			 fragmentsToReduce.add(node.getFragment());
		 	}
		 if (PartesMain.instance.doDebug())
			 { printDebug(node.getHeight()+"   "+node.getType()+"   "+node.getFragment());}
		}
	printDebug("deepest fragment to reduce: "+fragmentsToReduce);
	printDebug("====  =====");
	return fragmentsToReduce;
	}


	private void printDebug(String string) 
	{
	 if (PartesMain.instance.doDebug())
	 	{System.out.println(string);	}
		
	}

}

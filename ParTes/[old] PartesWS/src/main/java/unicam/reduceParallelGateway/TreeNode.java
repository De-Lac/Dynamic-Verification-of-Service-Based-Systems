package unicam.reduceParallelGateway;

import java.util.ArrayList;

import partes.service.PartesMain;
import unicam.utils.ExtendedActivity;

public class TreeNode	
{
 private TreeNode father;
 private ArrayList<TreeNode> stepFathers;
 private ArrayList<TreeNode> brothers;
 private ArrayList<TreeNode> sons;
 private ArrayList<ExtendedActivity> cts;
 private AffectionsGraph graph;
 
 
public TreeNode()
{
 stepFathers = new ArrayList<TreeNode>();
 brothers = new ArrayList<TreeNode>();
 sons = new ArrayList<TreeNode> ();	
 cts = new ArrayList<ExtendedActivity>();
 
}


 
public TreeNode getFather() {
	return father;
}
public void setFather(TreeNode father) {
	this.father = father;
}
public ArrayList<TreeNode> getstepFathers() {
	return stepFathers;
}
public void addstepFather(TreeNode foster) {
	this.stepFathers.add(foster);
}
public ArrayList<TreeNode> getBrothers() {
	return brothers;
}
public void addBrothers(TreeNode brother) {
	this.brothers.add(brother);
}
public ArrayList<TreeNode> getSons() {
	return sons;
}
public void addSon(TreeNode son) {
	this.sons.add(son);
}



public ArrayList<ExtendedActivity> getCts() {
	return cts;
}



public void appendCt(ExtendedActivity ct) {
	this.cts.add(ct);
}

/** @param ChoreographyTask: put the ct at the beginning of the list*/
public void prefixCt(ExtendedActivity ct) {
	this.cts.add(0, ct);
}



public AffectionsGraph getGraph() {
	return graph;
}



public void setGraph(AffectionsGraph graph) {
	this.graph = graph;
}



public ArrayList<TreeNode> getLeaves() 
{
 ArrayList<TreeNode> leaves = new ArrayList<TreeNode>();
 searchLeaves(leaves);
 return leaves;
}

private void searchLeaves(ArrayList<TreeNode> leaves)
{
 if (getSons().size() == 0)
 	{
	 leaves.add(this);
	 return;
 	}
 for(TreeNode son : this.getSons())
 	{
	 son.searchLeaves(leaves);
 	}
}


@Override
public String toString()
{
 return cts.toString();	
}


public void printTree(String p)
{
 if (! PartesMain.instance.doDebug())
 	{return;}
 String result = p;
 for (ExtendedActivity ct : getCts())
 	{
	 result += ct.getName() + " ";
 	}
 for(int i=0; i<sons.size();i++)
 	{
	 sons.get(i).printTree(result);
 	}
 if(sons.size()==0)
 	{
	 System.out.println(result);
 	}
}

}




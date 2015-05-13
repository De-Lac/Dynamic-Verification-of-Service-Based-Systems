/**
 * <copyright>
 * This file is part of Partes project.
 *
 * This program and the accompanying materials are made available under 
 * the terms of the  GPL license (the "GNU PUBLIC LICENSE") which 
 * accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * </copyright>
 *
 * $Id: TestFragment.java 28/ott/2011 11:59:33 francesco $
 */

package partes.testbuilder;

import java.util.Vector;

import jdsl.core.api.Tree;

/**
 * The Class TestFragment.
 */
public class TestFragment {

	/** The tree. */
	private Tree tree;
	
	/** The initial fragment. */
	private boolean initialFragment;
	//private boolean finalFragment;
	/** The branch fragment. */
	private boolean branchFragment;
	
	/** The predecessor. */
	private TestFragment predecessor;
	
	/** The successors. */
	private Vector<TestFragment> successors;
	
	/**
	 * Gets the fragment id.
	 * 
	 * @return the fragment id
	 */
	public int getFragmentID(){
		return this.tree.hashCode();
	}
		
	/**
	 * Gets the predecessor.
	 * 
	 * @return the predecessor
	 */
	public TestFragment getPredecessor() {
		return predecessor;
	}

	/**
	 * Sets the predecessor.
	 * 
	 * @param predecessor
	 *            the new predecessor
	 */
	public void setPredecessor(TestFragment predecessor) {
		this.predecessor = predecessor;
	}

	/**
	 * Gets the successors.
	 * 
	 * @return the successors
	 */
	public Vector<TestFragment> getSuccessors() {
		return successors;
	}

	/**
	 * Adds the successor.
	 * 
	 * @param successor
	 *            the successor
	 */
	public void addSuccessor(TestFragment successor) {
		this.successors.add(successor);
	}
	
	/**
	 * Sets the successors.
	 * 
	 * @param successors
	 *            the new successors
	 */
	public void setSuccessors(Vector<TestFragment> successors) {
		this.successors = successors;
	}

	/**
	 * Instantiates a new test fragment.
	 * 
	 * @param tree
	 *            the tree
	 */
	public TestFragment(Tree tree) {
		super();
		this.tree = tree;
		branchFragment = false;
		initialFragment = false;	
		this.successors = new Vector<TestFragment>();
	}
	
	/**
	 * Gets the tree.
	 * 
	 * @return the tree
	 */
	public Tree getTree() {
		return tree;
	}
	
	/**
	 * Sets the tree.
	 * 
	 * @param tree
	 *            the new tree
	 */
	public void setTree(Tree tree) {
		this.tree = tree;
	}
	
	/**
	 * Checks if is initial fragment.
	 * 
	 * @return true, if is initial fragment
	 */
	public boolean isInitialFragment() {
		return initialFragment;
	}
	
	/**
	 * Sets the initial fragment.
	 * 
	 * @param initialFragment
	 *            the new initial fragment
	 */
	public void setInitialFragment(boolean initialFragment) {
		this.initialFragment = initialFragment;
	}

	/**
	 * Checks if is branch fragment.
	 * 
	 * @return true, if is branch fragment
	 */
	public boolean isBranchFragment() {
		return branchFragment;
	}
	
	/**
	 * Sets the branch fragment.
	 * 
	 * @param branchFragment
	 *            the new branch fragment
	 */
	public void setBranchFragment(boolean branchFragment) {
		this.branchFragment = branchFragment;
	}
	
}

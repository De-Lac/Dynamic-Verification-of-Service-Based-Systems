/**
 * <copyright>
 * This file is part of BPTesting project.
 *
 * This program and the accompanying materials are made available under 
 * the terms of the  GPL license (the "GNU PUBLIC LICENSE") which 
 * accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * </copyright>
 *
 * $Id: TreeWithEndpoint.java 02/feb/2012 10:22:58 francesco $
 */
package partes.testbuilder;

import java.util.Iterator;
import java.util.Vector;

import jdsl.core.api.Tree;

/**
 * The Class TreeWithEndpoint.
 */
public class TreeWithEndpoint {

	/** The tree. */
	Tree tree;

	/** The wsdl file name. */
	String wsdlFileName;

	/** The tree file name. */
	String treeFileName;

	/** The port type. */
	String portType;

	/**
	 * Instantiates a new tree with endpoint.
	 */
	public TreeWithEndpoint() {
	}

	/**
	 * Instantiates a new tree with endpoint.
	 * 
	 * @param tree
	 *            the tree
	 * @param wsdlFileName
	 *            the wsdl file name
	 * @param portType
	 *            the port type
	 */
	public TreeWithEndpoint(Tree tree, String wsdlFileName, String portType) {
		super();
		this.tree = tree;
		this.wsdlFileName = wsdlFileName;
		this.portType = portType;
	}

	/**
	 * Gets the tree file name.
	 * 
	 * @return the tree file name
	 */
	public String getTreeFileName() {
		return treeFileName;
	}

	/**
	 * Sets the tree file name.
	 * 
	 * @param treeFileName
	 *            the new tree file name
	 */
	public void setTreeFileName(String treeFileName) {
		this.treeFileName = treeFileName;
	}

	/**
	 * Gets the port type.
	 * 
	 * @return the port type
	 */
	public String getPortType() {
		return portType;
	}

	/**
	 * Sets the port type.
	 * 
	 * @param portType
	 *            the new port type
	 */
	public void setPortType(String portType) {
		this.portType = portType;
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
	 * Gets the wsdl file name.
	 * 
	 * @return the wsdl file name
	 */
	public String getWsdlFileName() {
		return wsdlFileName;
	}

	/**
	 * Sets the wsdl file name.
	 * 
	 * @param wsdlFileName
	 *            the new wsdl file name
	 */
	public void setWsdlFileName(String wsdlFileName) {
		this.wsdlFileName = wsdlFileName;
	}

	/**
	 * Gets the test fragments.
	 * 
	 * @return the test fragments
	 */
	public Vector<TestFragment> getTestFragments() {

		Vector<TestFragment> result = new Vector<TestFragment>();

		InteractionTreeTour euler = new InteractionTreeTour();

		TestFragmentPool pool = new TestFragmentPool();
		euler.setTestPool(pool);

		euler.execute(this.tree);

		Iterator<TestFragment> testIterator = pool.getTestFragmentIterator();

		while (testIterator.hasNext()) {
			TestFragment t = testIterator.next();
			result.add(t);
		}

		return result;
	}

}

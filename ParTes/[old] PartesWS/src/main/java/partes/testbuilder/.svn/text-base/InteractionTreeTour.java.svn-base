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
 * $Id: BPTEulerTour.java 28/ott/2011 11:59:33 francesco $
 */

package partes.testbuilder;

import jdsl.core.algo.traversals.EulerTour;
import jdsl.core.api.Position;
import jdsl.core.api.PositionIterator;
import jdsl.core.api.Tree;
import jdsl.core.ref.NodeTree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import partes.commons.Interaction;
import partes.service.PartesMain;

/**
 * The Class InteractionTreeTour.
 */
public class InteractionTreeTour extends EulerTour {

	/** The log. */
	private Log log = LogFactory.getLog(InteractionTreeTour.class);

	/** The pool. */
	TestFragmentPool pool;

	/**
	 * Sets the test pool.
	 * 
	 * @param p
	 *            the new test pool
	 */
	void setTestPool(TestFragmentPool p) {
		this.pool = p;
	}

	/**
	 * Gets the test pool.
	 * 
	 * @return the test pool
	 */
	TestFragmentPool getTestPool() {
		return pool;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jdsl.core.algo.traversals.EulerTour#visitBetweenChildren(jdsl.core.api
	 * .Position)
	 */
	@Override
	protected void visitBetweenChildren(Position arg0) {
		super.visitBetweenChildren(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jdsl.core.algo.traversals.EulerTour#visitExternal(jdsl.core.api.Position)
	 */
	@Override
	protected void visitExternal(Position arg0) {
		super.visitExternal(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jdsl.core.algo.traversals.EulerTour#visitFirstTime(jdsl.core.api.Position
	 * )
	 */
	@Override
	protected void visitFirstTime(Position arg0) {
		if (arg0.element() != null) {

			Interaction i = ((Interaction) arg0.element());

			String str;
			if (i != null) {
				str = "" + i.getMethod();
			} else {
				str = "" + arg0.toString();
			}

			int numChildren = this.tree_.numChildren(arg0);

			switch (numChildren) {
			case 0:
				// nodo foglia
				printDebug("visitFirstTime leaf " + str);

				break;
			case 1:
				printDebug("visitFirstTime leaf on sequence" + str);
				break;
			default:
				// altri casi, ossia >1 figlio
				printDebug("visitFirstTime testfragment generation" + str);
				
				TestFragment tf = pool.findTestFragment(arg0);
				if (tf != null) {
					tf.setBranchFragment(true);
				}

				PositionIterator children = this.tree_.children(arg0);
				while (children.hasNext()) {
					Position p = children.nextPosition();
					/*
					 * Tree t = new NodeTree(); Position root = t.root();
					 * t.replaceElement(root, p);
					 */

					boolean start = false;
					if (this.tree_.isRoot(arg0) && str.equals("root")) {
						start = true;
					}

					Tree t = ((NodeTree) this.tree_).cut(p);
					
					TestFragment tFragment = new TestFragment(t);

					// aggiungo al tf padre un suo figlio successore
					if (tf != null) {
						tf.addSuccessor(tFragment);
					}
					// aggiungo al figlio l'indicazione del fragment padre
					tFragment.setPredecessor(tf);

					tFragment.setInitialFragment(start);

					pool.addToPool(p.hashCode(), tFragment);
					recursiveExecute(t, pool);
				}
				break;
			}

		}// fine controllo elementi null
		else {
			Object t = ((NodeTree) this.tree_).removeExternal(arg0);
		}
		
	}

	/**
	 * Recursive execute.
	 * 
	 * @param t
	 *            the t
	 * @param pool
	 *            the pool
	 */
	protected void recursiveExecute(Tree t, TestFragmentPool pool) {
		InteractionTreeTour euler = new InteractionTreeTour();
		euler.setTestPool(pool);
		euler.execute(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jdsl.core.algo.traversals.EulerTour#visitLastTime(jdsl.core.api.Position)
	 */
	@Override
	protected void visitLastTime(Position arg0) {
		super.visitLastTime(arg0);
	}
	
	
	private void printDebug(String message)
	 {
	  if (PartesMain.instance.doDebug())
	  	{
		  log.debug(message);
	  	}
	 }

}

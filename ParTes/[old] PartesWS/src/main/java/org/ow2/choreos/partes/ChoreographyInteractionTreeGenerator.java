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
 * $Id: ChoreographyInteractionTreeGenerator.java 21-giu-2012 18.53.35 francesco $
 */

package org.ow2.choreos.partes;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

import partes.exception.BPMNmalformedException;

import jdsl.core.api.Tree;

/**
 * The Interface ChoreographyInteractionTreeGenerator.
 */
public interface ChoreographyInteractionTreeGenerator {

	/**
	 * Builds the interaction tree.
	 * 
	 * @param modelDir
	 *            the model dir
	 * @return the tree
	 */
	public Tree buildInteractionTree(String modelDir);
	
	
	/**
	 * Builds the interaction trees. Each tree is associated to one condition
	 * 
	 * @param modelDir
	 *            the model dir
	 * @return the tree
	 * @throws BPMNmalformedException 
	 * @throws FileNotFoundException 
	 * @throws JAXBException 
	 */
	public HashMap<String, Tree> buildInteractionTrees(String modelDir) throws BPMNmalformedException, FileNotFoundException, JAXBException;


}
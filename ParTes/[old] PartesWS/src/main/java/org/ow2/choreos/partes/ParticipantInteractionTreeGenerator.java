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
 * $Id: ParticipantInteractionTreeGenerator.java 21-giu-2012 18.56.11 francesco $
 */
package org.ow2.choreos.partes;

import java.util.Vector;

import jdsl.core.api.Tree;
import partes.projection.ProjectionInfo;

/**
 * The Interface ParticipantInteractionTreeGenerator.
 */
public interface ParticipantInteractionTreeGenerator {

	/**
	 * Make projection.
	 * @param tree
	 *            the tree
	 * @param services
	 *            the services
	 * @return the vector
	 */
	public Vector<ProjectionInfo> makeProjection(
			Tree tree, String[] services);

}
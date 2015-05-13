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
 * $Id: Esempio.java 26/gen/2012 18:12:24 francesco $
 */
package partes.projection;

import jdsl.core.api.Tree;
import jdsl.core.ref.NodeTree;

/**
 * The Class ProjectionInfo.
 * 
 * @author francesco
 */
public class ProjectionInfo {

	//public String projectionTree;
	
	/** The projection tree. */
	private Tree projectionTree;
	
	/** The service. */
	private String service;
	
	/**
	 * Instantiates a new projection info.
	 * 
	 * @param service
	 *            the service
	 * @param projectionTree
	 *            the projection tree
	 */
	public ProjectionInfo(String service, Tree projectionTree){
		this.projectionTree = projectionTree;
		this.service = service;
		
	}
	
	/**
	 * Instantiates a new projection info.
	 */
	public ProjectionInfo(){
		this.projectionTree = new NodeTree();
		this.service = "";
		
	}

	/**
	 * Gets the projection tree.
	 * 
	 * @return the projection tree
	 */
	public Tree getProjectionTree() {
		return projectionTree;
	}

	/**
	 * Sets the projection tree.
	 * 
	 * @param projectionTree
	 *            the new projection tree
	 */
	public void setProjectionTree(Tree projectionTree) {
		this.projectionTree = projectionTree;
	}

	/**
	 * Gets the service.
	 * 
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * Sets the service.
	 * 
	 * @param service
	 *            the new service
	 */
	public void setService(String service) {
		this.service = service;
	}
	
	
}

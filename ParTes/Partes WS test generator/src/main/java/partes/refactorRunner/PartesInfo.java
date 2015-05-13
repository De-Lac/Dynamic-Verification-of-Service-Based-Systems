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
 * $Id: PartesInfo.java 19/giu/2012 11:59:33 francesco $
 */

package partes.refactorRunner; 

/**
 * The Class PartesInfo.
 */
public class PartesInfo {
	
	/** The port type to search. */
	private String portTypeToSearch;
	
	/** The wsdl location. */
	private String wsdlLocation;
	
	/** The model impl class. */
	private String modelImplClass;
	
	/**
	 * Instantiates a new partes info.
	 * 
	 * @param portTypeToSearch
	 *            the port type to search
	 * @param wsdlLocation
	 *            the wsdl location
	 * @param modelImplClass
	 *            the model impl class
	 */
	public PartesInfo(String portTypeToSearch, String wsdlLocation,
			String modelImplClass) {
		super();
		this.portTypeToSearch = portTypeToSearch;
		this.wsdlLocation = wsdlLocation;
		this.modelImplClass = modelImplClass;
	}
	
	/**
	 * Gets the port type to search.
	 * 
	 * @return the port type to search
	 */
	public String getPortTypeToSearch() {
		return portTypeToSearch;
	}
	
	/**
	 * Sets the port type to search.
	 * 
	 * @param portTypeToSearch
	 *            the new port type to search
	 */
	public void setPortTypeToSearch(String portTypeToSearch) {
		this.portTypeToSearch = portTypeToSearch;
	}
	
	/**
	 * Gets the wsdl location.
	 * 
	 * @return the wsdl location
	 */
	public String getWsdlLocation() {
		return wsdlLocation;
	}
	
	/**
	 * Sets the wsdl location.
	 * 
	 * @param wsdlLocation
	 *            the new wsdl location
	 */
	public void setWsdlLocation(String wsdlLocation) {
		this.wsdlLocation = wsdlLocation;
	}
	
	/**
	 * Gets the model impl class.
	 * 
	 * @return the model impl class
	 */
	public String getModelImplClass() {
		return modelImplClass;
	}
	
	/**
	 * Sets the model impl class.
	 * 
	 * @param modelImplClass
	 *            the new model impl class
	 */
	public void setModelImplClass(String modelImplClass) {
		this.modelImplClass = modelImplClass;
	}
	
	@Override
	public String toString()
	{return this.getModelImplClass();}



}

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
 * $Id: ParticipantTestBuilder.java 21-giu-2012 18.56.31 francesco $
 */
package org.ow2.choreos.partes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import jdsl.core.api.Tree;

import org.apache.xmlbeans.XmlException;

import partes.exception.TestGenerationException;
import partes.refactorRunner.PartesInfo;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.SoapUIException;

/**
 * The Interface ParticipantTestBuilder.
 */
public interface ParticipantTestBuilder {

	/**
	 * Make soap ui project.
	 * 
	 * @param tree
	 *            the tree
	 * @param portTypeToSearch
	 *            the port type to search
	 * @param wsdlLocation
	 *            the wsdl location
	 * @return the wsdl project
	 * @throws XmlException
	 *             the xml exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SoapUIException
	 *             the soap ui exception
	 */
	public WsdlProject makeSOAPuiProject(Tree tree, String portTypeToSearch,
			String wsdlLocation) throws XmlException, IOException,
			SoapUIException;
	
	
	
	/**
	 * 
	 * @param trees HashMap (condition, tree)
	 * @param participants HashMap (service name, service endpoint)
	 * @return SOAPui project with a test suite each condition, and a TestCase each trace of one condition
	 * @throws TestGenerationException 
	 */
	 public WsdlProject makeSOAPuiProjectTracesTest(HashMap<String, Tree> trees,  Vector<PartesInfo> participants) throws TestGenerationException;

}
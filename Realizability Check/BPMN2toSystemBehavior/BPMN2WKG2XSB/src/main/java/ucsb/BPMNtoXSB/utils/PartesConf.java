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
 * $Id: PartesConf.java 21-giu-2012 19.02.50 francesco $
 */
package ucsb.BPMNtoXSB.utils;



/**
 * The Class PartesConf.
 */
public class PartesConf {
	
	public String SYS_FILENAME = "sys.systembehavior";
	public String WFG_FILENAME = "wfg.workflowgraph";
	public String PEERS_FILENAME = "peers.peerbehavior";
	public String BPMN2_FILEPATH = "";
	public String OUTPUT_PATH = "";
	public boolean GENERATE_IMGS;
	


	/**
	 * Instantiates a new partes conf
	 * @param input 
	 * 				path + bpmn2 filename
	 * @param output
	 *               path where store generated models
	 */
	public PartesConf(String input, String output, boolean img) 
	{
		 BPMN2_FILEPATH = input;
		 OUTPUT_PATH = output;
		 GENERATE_IMGS = img;
	}

	
	
}

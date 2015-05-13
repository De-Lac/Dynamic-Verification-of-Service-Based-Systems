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
 * $Id: Partes.java 21-giu-2012 19.03.45 francesco $
 */
package partes.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.xml.bind.JAXBException;

import jdsl.core.api.Tree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlException;
import org.ow2.choreos.partes.ChoreographyInteractionTreeGenerator;
import org.ow2.choreos.partes.PartesTestGenerator;
import org.ow2.choreos.partes.ParticipantInteractionTreeGenerator;
import org.ow2.choreos.partes.ParticipantTestBuilder;

import partes.exception.BPMNmalformedException;
import partes.exception.TestGenerationException;
import partes.projection.ProjectionInfo;
import partes.refactorRunner.PartesInfo;
import partes.utils.PartesConf;
import partes.utils.WriteToFile;
import partes.utils.YamlReader;

import com.eviware.soapui.support.SoapUIException;
import com.thoughtworks.xstream.XStream;

/**
 * The Class Partes.
 */
public class Partes extends PartesTestGenerator {

	/** The log. */
	private static Log log = LogFactory.getLog(Partes.class);
			
	

/*
	private ChoreographyInteractionTreeGenerator jpfRunner;
	private ParticipantInteractionTreeGenerator treeProjection;
	private ParticipantTestBuilder testBuilder;

	public Partes(boolean debug, String modelDir, ChoreographyInteractionTreeGenerator jpfRunner,
			ParticipantInteractionTreeGenerator treeProjection, ParticipantTestBuilder testBuilder) {
		super();
		this.debug = debug;
		this.modelDir = modelDir;
		this.jpfRunner = jpfRunner;
		this.treeProjection = treeProjection;
		this.testBuilder = testBuilder;
	}

	public Partes(boolean debug, String modelDir) {
		super();
		this.debug = debug;
		this.modelDir = modelDir;
		this.jpfRunner = new JPFRunner();
		this.treeProjection = new TreeProjection();
		this.testBuilder = new TestBuilder();
	}
*/
	
	/**
	 * Instantiates a new partes.
	 * 
	 * @param debug
	 *            the debug
	 * @param modelDir
	 *            the model dir
	 */
	public Partes() {
		super();
	}
	
	/**
	 * Instantiates a new partes.
	 * 
	 * @param debug
	 *            the debug
	 * @param modelDir
	 *            the model dir
	 * @param cTreeGenerator
	 *            the c tree generator
	 * @param pProjectionGenerator
	 *            the projection generator
	 * @param pTestBuilder
	 *            the test builder
	 */
	public Partes(ChoreographyInteractionTreeGenerator cTreeGenerator,
			ParticipantInteractionTreeGenerator pProjectionGenerator, ParticipantTestBuilder pTestBuilder) {
		super(cTreeGenerator, pProjectionGenerator, pTestBuilder);
	}

	
	/**
	 *
	 *
	 * it returns an HashMap with a condition as key, and as value
	 * an list of HashMap with {@link partes.refactorRunner.PartesInfo PartesInfo} as key  
	 * and the String  (test) as value. 
	 * @throws BPMNmalformedException 
	 * @throws TestGenerationException 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public HashMap<String, HashMap<PartesInfo, String>> generateTestSuite() throws BPMNmalformedException, TestGenerationException, FileNotFoundException, JAXBException {
		log.info("started test suite generation for " + PartesMain.instance.bpmnPath);
		
		HashMap<String, HashMap<PartesInfo, String>> xmlTests = new HashMap<String, HashMap<PartesInfo, String>>();

		
		
		// #### STEP 1 ##### create the InteractionTrees
		HashMap<String, Tree> step1 = this.getcTreeGenerator().buildInteractionTrees(PartesMain.instance.bpmnPath);

		log.info("built interaction trees of "+step1.keySet().size()+" conditions");
		
		if (PartesMain.instance.debug) {
			XStream xstream = new XStream();
			String xml = xstream.toXML(step1);
			WriteToFile.writeToANewFileInOutputDir("TestSuite"+File.separator,
					PartesConf.getString("cmdline.tree_of_interaction_file"),
					xml.trim());
		}

		/**
		 * now, for each condition, we create projections and test pool. In the output folder
		 * there will be one sub-folder for each condition. In each of theme there will be the
		 * participants projections and the test sequence generated. 
		 * The conditions are the children of the root.
		 * @see partes.refactorRunner.InteractionTreeBuilder.getTreeOfInteraction()
		 */
		Set<String> conditions = step1.keySet();
		Iterator<String> condIter = conditions.iterator();
		
		//look for participants
		Vector<PartesInfo> participants = PartesMain.instance.servicesWsdlUrl;
				//+ PartesConf.getString("treeBuilder.participant_conf_file"));

		log.info("participants are: " + participants.toString());
		Vector<String> services = new Vector<String>();
		for (PartesInfo p : participants) 
			{ services.add(p.getModelImplClass()); }

		String[] servicesToSearch = new String[0];
		servicesToSearch = services.toArray(servicesToSearch);
		
		
		while (condIter.hasNext())
			{
			 String condition = condIter.next();
			 XStream xstream = new XStream();
			 String xml = xstream.toXML(step1.get(condition));
			 Tree treeOfOneCondition = (Tree) xstream.fromXML(xml); //cloned tree
			 
			 // #### STEP 2 #### makes the projections
			 Vector<ProjectionInfo> step2 = this.getpProjectionGenerator().makeProjection(
					treeOfOneCondition, servicesToSearch);

			log.info("built " + step2.size() + "["+condition+"] projection trees for participants");
			
			// #### STEP 3 #### makes SOAPui project
			for (ProjectionInfo pi : step2) 
				{
				 if (PartesMain.instance.debug) 
				 	{
					 XStream xstream2 = new XStream();
					 String xml2 = xstream2.toXML(pi.getProjectionTree());
					 WriteToFile.writeToANewFileInOutputDir("TestSuite"+File.separator+condition,
							"projection-" + pi.getService() + ".xml", xml2);
				 	}
				 for (PartesInfo p : participants) 
				 	{
					 if (pi.getService().equals(p.getModelImplClass())) 
					 	{
						 String wsdlLocation = p.getWsdlLocation();
						 String portTypeToSearch = p.getPortTypeToSearch();
						 String xmlTest = "";
						 try 
						 	{
							 xmlTest = this.getpTestBuilder()
									.makeSOAPuiProject(pi.getProjectionTree(),
											portTypeToSearch, wsdlLocation)
									.getProjectDocument().toString();
						 	} 
						 catch (XmlException e) 
						 	{
							 //e.printStackTrace();
							 System.out.println("Partes causes an XmlException!");
						 	} 
						 catch (IOException e) 
						 	{
							 //e.printStackTrace();
							 System.out.println("Partes causes an IOException!");
						 	} 
						 catch (SoapUIException e) 
						 	{
							 //e.printStackTrace();
							 System.out.println("Partes causes an SoapUIException!");
						 	}
						 if (xmlTests.get(condition) == null)
						 	{xmlTests.put(condition, new HashMap<PartesInfo, String>());}
						xmlTests.get(condition).put(p, xmlTest);
						log.info("built SOAPui project for " + p.getPortTypeToSearch());
					   }
				 	}
				}
			}
		// #### STEP 4 #### make integration test with all the traces of that condition
		String xmlTest = "";
		xmlTest = this.getpTestBuilder().makeSOAPuiProjectTracesTest(step1, participants).getProjectDocument().toString();
		HashMap<PartesInfo, String> hm = new HashMap<PartesInfo, String>();
		hm.put(null, xmlTest);
		xmlTests.put("whole choreography traces", hm);
		return xmlTests;
	}


}

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
 * $Id: TrapProperty.java 28/ott/2009 11:59:33 francesco $
 */

package partes.refactorRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jdsl.core.api.Position;
import jdsl.core.api.PositionIterator;
import jdsl.core.api.Tree;
import jdsl.core.ref.NodeTree;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.spec.bpmn._20100524.model.TChoreography;
import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.omg.spec.bpmn._20100524.model.TItemDefinition;
import org.omg.spec.bpmn._20100524.model.TMessage;
import org.omg.spec.bpmn._20100524.model.TParticipant;
import org.omg.spec.bpmn._20100524.model.TRootElement;
import org.ow2.choreos.partes.ChoreographyInteractionTreeGenerator;

import com.thoughtworks.xstream.XStream;

import partes.commons.Interaction;
import partes.exception.BPMNmalformedException;
import partes.utils.PartesConf;
import partes.utils.WriteToFile;
import unicam.refactorWorkflowgraph.PartesTrace;
import unicam.refactorWorkflowgraph.RefactorWorkflowGraph;
import unicam.refactorWorkflowgraph.WorkflowGraph;
import unicam.utils.ExtendedActivity;
//import java.util.List;
//import model.stub.amazonecs.Items;
//import gov.nasa.jpf.jvm.ElementInfo;

public class InteractionTreeBuilder implements ChoreographyInteractionTreeGenerator {

	/** The log. */
	private Log log = LogFactory.getLog(InteractionTreeBuilder.class);

	
	private static List<JAXBElement<? extends TRootElement>>  content;
	private static HashMap <String, TMessage> messages;    
	private static HashMap <String, TItemDefinition> items;
	private static TChoreography choreography;
	private static WorkflowGraph wg;
	private static String bpmnFile;
	

	
	/**
	 * not implemented here
	 */
	@Override
	public Tree buildInteractionTree(String modelDir) 
	{ return null;}
	
	
	
	/**
	 * @throws BPMNmalformedException 
	 * @throws FileNotFoundException 
	 * @throws JAXBException 
	 * @see partes.refactorRunner.InteractionTreeBuilder#getTreesOfInteraction() getTreesOfInteraction()
	 */
	@Override
	public HashMap<String, Tree> buildInteractionTrees(String bpmnFilePath) throws BPMNmalformedException, FileNotFoundException, JAXBException
	{
		bpmnFile = bpmnFilePath;
		List<JAXBElement<? extends TRootElement>> content = null;
		try {content = getContent();} 
		/*!!!!!! TODO: IMPROVE ERROR HANDLING !!!!!*/
		catch (FileNotFoundException e) { throw new FileNotFoundException("["+this.getClass().getName()+"] "+e);} 
		catch (JAXBException e) { throw new JAXBException("["+this.getClass().getName()+"] "+e);}

		choreography = new TChoreography();
		int contentNumber = 0;
		while( !(content.get(contentNumber).getValue() instanceof TChoreography))
		{contentNumber++;}
		if (contentNumber < content.size())
		{ // Tchoreography found!

			choreography = (TChoreography) content.get(contentNumber).getValue();	
			for (JAXBElement element : content)
			{
				if (element.getValue() instanceof TMessage)
				{
					TMessage message = (TMessage)element.getValue();
					messages.put(message.getId(), message);
				}
				else if (element.getValue() instanceof TItemDefinition)
				{
					TItemDefinition item = (TItemDefinition) element.getValue();
					items.put(item.getId(), item);
				}
			}

			System.out.println("================ " + choreography.getName() + " ================ ");
			new File(PartesConf.getString("outputPath")).mkdirs();
			long startTime = System.currentTimeMillis();
			log.info("start");
			log.info("running... ");
			log.info("outputPath is " + PartesConf.getString("outputPath"));
			HashMap<String, Tree> treesOfAllConditions = getTreesOfInteraction();
			long endTime = System.currentTimeMillis();
			Log log = LogFactory.getLog(InteractionTreeBuilder.class);
			log.info("total time: " + (endTime - startTime) + " ms");
			log.info("end");
			return treesOfAllConditions;
		}
		else 
		{
		 throw new BPMNmalformedException("Tchoreography not found in: "+bpmnFilePath);
		}
	}
	
	
	
	
	
	/**
	 * Instantiates a new trap property.
	 * @param targetProject 
	 */
	public InteractionTreeBuilder() 
	{
		super();
		messages = new HashMap <String, TMessage> (); 
	    items = new HashMap <String, TItemDefinition> (); 
	}
	
	
	
	/**
	 * returns projections of all participants according to selected condition
	 * {@link WorkflowGraph#getProjectionOfOneCondition(String)}
	 * @param condition
	 * @return
	 */
	public Hashtable<TParticipant, ArrayList<String>> getProjections(String condition)
		{
		 return wg.getProjectionOfOneCondition(condition);
		}
	
	
	
	
	/**
	 * this methods call {@link InteractionTreeBuilder#getTracesToTest() getTracesToTest()} to build and refactor a Workflow Graph.
	 * From the refactoring of the WorkflowGraph, many {@link unicam.refactorWorkflowgraph.PartesTrace PartesTraces} are provided,
	 * grouped by the shared condition.
	 * For each condition, this method builds an InteractionTree of all the PartesTraces associated to that condition.
	 * @return InteractionTree
	 * <pre>
	 *    _____________________
	 *    |cond|     tree      |    tree1         tree2
	 *    |----|---------------|    root(x<0)   root(x>0)
	 *    |x<0 |  tree1        |     / \          / \
	 *    |x>0 |   tree2       |    a  b         c  b
	 *    |--- |---------------|    |  |         |  |
	 *                              bc ca        ab ac	
	 * </pre>
	 * @throws BPMNmalformedException 
	 */
	private HashMap<String, Tree> getTreesOfInteraction() throws BPMNmalformedException
		{
		 HashMap<String, Tree> treesOfAllConditions = new HashMap<String, Tree>();
		 Hashtable<String, ArrayList<PartesTrace>> allTraces = getTracesToTest(); //all the traces grouped by condition
		 Enumeration<String> conditions = allTraces.keys();
		 while(conditions.hasMoreElements())
			{
			 String condition = conditions.nextElement();
			 Tree tree4oneCondition = new NodeTree();
			 Interaction init = new Interaction("root", "root");
			 tree4oneCondition.replaceElement(tree4oneCondition.root(), init);
			 ArrayList<PartesTrace> tracesOfOneCondition = allTraces.get(condition); //all the traces associated to one condition
			 // from all the linear traces I have, I rebuild a tree collapsing the shared node of the traces.
			 // this is done to reuse the "make projections" 
			 /** @TODO i have the traces, then I rebuild the tree from them to resue the already-done
			  * makeProjections()...  then I explore the tree to retrive the traces to make STEP4,
			  * i.e. the integration testing.  Many steps could be avoided...*/
			 for(PartesTrace trace: tracesOfOneCondition)
			 	{ // start building one of the trees associated to one of the conditions
				 Position lastPosition = tree4oneCondition.root();
				 for (ExtendedActivity ct : trace)
				 	{ // i must check if this node already exists among children on current node
					 PositionIterator childrenIter = tree4oneCondition.children(lastPosition);
					 boolean nodeAlreadyExists = false;
					 while (childrenIter.hasNext())
					 	{
						 Position child = childrenIter.nextPosition();
						 if (((Interaction)child.element()).getMethod().equals(ct.getMethod()) &&
							 ((Interaction)child.element()).getMethodClass().equals(ct.getMethodClass())
							)
						 	{
							 lastPosition = child;
							 nodeAlreadyExists=true;
							 break;
						 	}
					 	}
					 if (! nodeAlreadyExists)
					 	{
						 Interaction interaction = new Interaction(ct.getMethodClass(),
	                                ct.getMethod(),
	                                ct.getParams());
						 lastPosition = tree4oneCondition.insertFirstChild(lastPosition, interaction);
					 	}
				 	}
			 	}
			 treesOfAllConditions.put(condition, tree4oneCondition);
			}
		return treesOfAllConditions;
    }
	
	
	
	/**
	 * returns traces to test associated to condition.
	 * 
	 *  <pre> 
	 *  / \-->a' -->b' -->c'---> / \
	 *  \ /-->b''-->a''-->c''--> \ /
	 *   |                        ^
	 *   ---->b'''-->c'''-->d'''--|
	 *  
	 *                     ___________________________________________
	 *  the method returns |x>0  | [a',b',c']						  |
	 *                     |x<=0 | [{b'',a'',c''}; {b''',c''',d'''}]  |
	 *                     |_____|____________________________________|
	 * </pre>                    
	 * @return
	 * @throws BPMNmalformedException 
	 */
	private static Hashtable<String, ArrayList<PartesTrace>> getTracesToTest () throws BPMNmalformedException
		{
		// choose where to save png files of graphs, trees...
//				JFileChooser chooser = new JFileChooser();
//			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//			    chooser.setAcceptAllFileFilterUsed(false);
//			    int option = chooser.showDialog(null, "choose dir");
//			    if (option == JFileChooser.APPROVE_OPTION)
//			    	{ 
//			    	 chooser.getSelectedFile().mkdirs();
//			    	 IMAGEfilesPATH = chooser.getSelectedFile().getPath();
//			    	 for(File file:chooser.getSelectedFile().listFiles())
//			    	 	{
//			    		 file.delete();
//			    	 	}
//			    	}
//			    else 
//			    	{ System.exit(0); }
//			    
			    wg = RefactorWorkflowGraph.from_BPMN_to_WorkflowGraph(choreography);
				wg = RefactorWorkflowGraph.refactorWorflowGraph(wg);
				// now g has been refactored, with just one XOR choice and many traces to choice
				return wg.getTracesOfRefactoredGraph();
		}
	
	
	
	
	public static TChoreography getChoreography()
		{return choreography;}
	
	public static List<JAXBElement<? extends TRootElement>> getContent() throws JAXBException, FileNotFoundException {
		if(content==null)
		{
		 JAXBContext jc = JAXBContext.newInstance( "org.omg.spec.bpmn._20100524.model" );
		 Unmarshaller u = jc.createUnmarshaller();
		 JAXBElement<TDefinitions> td = null;
		 System.out.println(bpmnFile);
		try 
			{ 
			System.out.println("url");
			td = (JAXBElement<TDefinitions>) u.unmarshal(new URL(bpmnFile)); } 
		catch (MalformedURLException e) 
			{
			System.out.println("file");
			 td = (JAXBElement<TDefinitions>) u.unmarshal(new File(bpmnFile));
		    } 
		 content = td.getValue().getRootElement();
		}
		return content;
	}
	
	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws BPMNmalformedException 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws BPMNmalformedException, FileNotFoundException, JAXBException {

		String modelDir = "";
		Options options = new Options();
		HelpFormatter formatter = new HelpFormatter();
		options.addOption("m", "modeldir", true, "specify model dir");
		CommandLineParser parser = new PosixParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
			if (cmd.getOptions().length == 0) 
				{
				 formatter.printHelp("refactorRunner", options, true);
				 System.exit(0);
				}

			// get model option value
			modelDir = cmd.getOptionValue("m");

			if (modelDir == null) 
				{
				 formatter.printHelp("refactorRunner", options, true);
				 System.exit(0);
				}

			} 
		catch (ParseException e) 
			{
			 formatter.printHelp("refactorRunner", options, true);
			 System.exit(0);
			}

		ChoreographyInteractionTreeGenerator j = new InteractionTreeBuilder();
		HashMap<String, Tree> r = j.buildInteractionTrees(modelDir);
		XStream xstream = new XStream();
		String xml = xstream.toXML(r);
		WriteToFile.writeToANewFileInOutputDir("TestSuite"+File.separator, 
											   "treeofinteraction.xml", 
											    xml.trim());

	}
	
	
    public static TMessage getMessage(String key)
    	{return messages.get(key);}
    
    public static TItemDefinition getItem(String key)
    	{return items.get(key);}
	
	
}

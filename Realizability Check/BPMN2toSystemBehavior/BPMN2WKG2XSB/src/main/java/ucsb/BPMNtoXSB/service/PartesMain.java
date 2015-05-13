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
 * $Id: PartesMain.java 21-giu-2012 19.05.32 francesco $
 */
package ucsb.BPMNtoXSB.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;

import javax.xml.bind.JAXBException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;

import ucsb.BPMNtoXSB.exception.BPMNmalformedException;
import ucsb.BPMNtoXSB.exception.TestGenerationException;
import ucsb.BPMNtoXSB.utils.PartesConf;
import ucsb.acceleo.SYS2XSB.main.SYS2XSB;
import ucsb.atl.WFGtoSYS.files.FromWfg2Sys;
import ucsb.peerbehavior.Peer;
import ucsb.systembehavior.SystemBehavior;
import unicam.atl.BPMN2toWFG.files.FromBPMN2toWFT;
import unicam.refactorWorkflowgraph.RefactorWorkflowGraph;
import unicam.utils.IOUtils4Mac;
import unicam.workflowgraph.WorkFlowGraph;

/**
 * The Class PartesMain.
 */
public class PartesMain {

	public static PartesMain instance = null;
	public String choreographyTModelKey;
	public PartesConf conf;
	String timeStart;
	String timeWfg;
	String timePeersAndSys;
	String timeXsb;


	public PartesMain()
		{
		 instance = this;
		}



	
	
	/**
	 * the main to call by command line
	 * @param args
	 * <pre>
	 * -p /../../xyz.bpmn  for the bpmn2 choreography
	 * </pre>
	 */
	public static void main(String[] args) 
	{ 
		instance = new PartesMain();
		//try {instance.thanks();} catch (InterruptedException e1) {}
		if (args == null || args.length == 0)
		   {
			System.out.println("no parameters passed, default parameters will be taken. Anyway the usage is:\nargs[0]: bpmn2 file path \nargs[1]: output path \nargs[2]: generate or not svg images");
			String bpmnFile = "/Users/deLac/Documents/eclipse_workspace/BPMN2WKG2XSB/examples/ANDtoXOR/realizExceptionCase.bpmn2";
			String outputpath = "/Users/deLac/Desktop/blabla/";
			instance.conf = new PartesConf(bpmnFile, outputpath, true);
//			String bpmnFile = "./airport_short.bpmn2";
		   }
		else if (args.length==3)
			{ instance.conf = new PartesConf(args[0], args[1], Boolean.parseBoolean(args[2]));  }
		else
			{System.out.println("args[0]: bpmn2 file path \nargs[1]: output path \nargs[2]: generate or not svg images");}
		
		instance.choreographyTModelKey="TestChor";
		try 
			{ instance.run(); } 
		catch (BPMNmalformedException e) 
			{
			 String error = "BPMN choreography should respect some rules to be applied to Partes \n ";
			 instance.handleError(error, e);
			} 
		catch (JAXBException e) 
			{
			 String error = "ERROR converting BPMN elements in java JAXB elements\n";
			 instance.handleError(error, e);
			} 
		catch (FileNotFoundException e) 
			{
			 String error = "ERROR file not found";
			 instance.handleError(error, e);
			}
		catch(Exception ex)
		{
		  ex.printStackTrace();
		  instance.handleError(ex.getMessage(), ex);
		}
		
	}







	/**
	 * 
	 * @param bpmn  it could be a local path (/Users/Daniele/.../xyz.bpmn) or an URL (http://mysite/xyz?wsdl)
	 * @return Map<TestSuiteName, TestSuiteFileContent>  or  Map<"error", errorType>
	 * @throws TestGenerationException 
	 * @throws BPMNmalformedException 
	 * @throws JAXBException 
	 * @throws ATLCoreException 
	 * @throws IOException 
	 * @see PartesMain#run(String, boolean, String)
	 */
	private void run() throws BPMNmalformedException, TestGenerationException, JAXBException, IOException, ATLCoreException
	{
   	    timeStart = new Timestamp(new java.util.Date().getTime())+"";
		// ====  FROM BPMN   TO   WORK FLOW GRAPH ======
		System.out.println("start of ParTes execution");
		WorkFlowGraph wg  = FromBPMN2toWFT.doFromBPMN2toWFT(conf.BPMN2_FILEPATH, "wfg", conf.OUTPUT_PATH);
		System.out.println("BPMN2 -> WorkFlowGraph ok");
		timeWfg = new Timestamp(new java.util.Date().getTime())+"";
		if (conf.GENERATE_IMGS)
			{ IOUtils4Mac.invokeDOT(conf.OUTPUT_PATH, "wfg.pdf", wg.toDOTforGraphViz()); }
		System.out.println("WorkFlowGraph printed");
	
		
//		wg = rwfg.refactorWorflowGraph();
//		wg.saveModel(PartesConf.getString("outputPath")+"refactored_wfg.workflowgraph");
//		System.out.println(wg.toDOTforGraphViz());
//		IOUtils4Mac.invokeDOT(PartesConf.getString("outputPath"), "refactored_wfg.png", wg.toDOTforGraphViz());
		
		
		
		// ====  FROM WORK FLOW GRAPH TO  SYSTEM & PEERS  ======
		FromWfg2Sys transf = new FromWfg2Sys(conf.OUTPUT_PATH+conf.WFG_FILENAME, conf.OUTPUT_PATH);		
		
		ResourceSet resSet = new ResourceSetImpl(); // Obtain a new resource set
	    Resource resource = resSet.getResource(URI.createFileURI(new File(conf.OUTPUT_PATH+conf.SYS_FILENAME).getAbsolutePath()), true); // Get the resource
	    SystemBehavior systemBehavior = ((SystemBehavior) resource.getContents().get(0));// Get the first model element and cast it to the right type
	    System.out.println("WorkFlowGraph --> SYS ok");
	    timePeersAndSys = new Timestamp(new java.util.Date().getTime())+"";
   	    if (conf.GENERATE_IMGS)
   	    		{ IOUtils4Mac.invokeDOT(conf.OUTPUT_PATH, "sys.pdf", systemBehavior.toDOTforGraphViz()); }
	    System.out.println("sys printed");
	    
	    
	    resource = resSet.getResource(URI.createFileURI(new File(conf.OUTPUT_PATH+conf.PEERS_FILENAME).getAbsolutePath()), true); // Get the resource
	    EList<EObject> peers = resource.getContents();
	    for (EObject p : peers)
		    {
		     Peer peer = (Peer)p;
		     if (conf.GENERATE_IMGS)
		    	 { IOUtils4Mac.invokeDOT(conf.OUTPUT_PATH, peer.getName()+".pdf", peer.toDOTforGraphViz()); }
		    }
	    System.out.println("WorkFlowGraph --> PEERS ok");

	    // === FROM SYSTEM TO XSB ===
		new SYS2XSB().doSYStoXSB(conf.OUTPUT_PATH+conf.SYS_FILENAME, conf.OUTPUT_PATH);
		
		
		timeXsb = new Timestamp(new java.util.Date().getTime())+"";
        System.out.println("end of ParTes execution");
        System.out.println("Starting time: "+timeStart);
        System.out.println("Wfg created at: "+timeWfg);
        System.out.println("Sys and Peers created at: "+timePeersAndSys);
	    System.out.println("Sys XSB created at: "+timeXsb);

	}

	
	protected void handleError(String error, Exception e)
	{
	 System.out.println(error);
	 e.printStackTrace();
	}	
	
	
	/**
	 * 
	 * @param bpmn
	 *  filepath of the bpmn2 choreography
	 *  @param outputWfgPath
	 *  path of the output wfg file, without filename
	 *  @param wfgName
	 *  wfg filename
	 * @throws BPMNmalformedException 
	 * @throws IOException 
	 */
	public WorkFlowGraph BPMN2toWFG (String bpmn, String outputWfgPath, String wfgName) throws BPMNmalformedException, IOException
	{
		System.out.println("start of ParTes execution");
		RefactorWorkflowGraph rwfg = new RefactorWorkflowGraph(bpmn, wfgName, outputWfgPath);
		WorkFlowGraph wfg = rwfg.getWfg();
		System.out.println("BPMN2 -> WorkFlowGraph ok");
		IOUtils4Mac.invokeDOT(outputWfgPath, wfgName+".png", wfg.toDOTforGraphViz());
		return wfg;
	}
	
	
	
//	public void addRequiredMetamodels()
//	{
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bpmn2", new Bpmn2ResourceFactoryImpl());
//		
//		EPackage.Registry.INSTANCE.put(SystembehaviorPackage.eNS_URI, SystembehaviorPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("systembehavior", new XMIResourceFactoryImpl());
//		
//		EPackage.Registry.INSTANCE.put(PeerbehaviorPackage.eNS_URI, PeerbehaviorPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("peerbehavior", new XMIResourceFactoryImpl());
//	}
	
	
	private String escapeString(String str) 
	{
	 str=str.replaceAll("\\;", "&#59;");
	 str=str.replaceAll("\\?", "&#63;");
	 str=str.replaceAll("\\!", "&#33;");
	 str=str.replaceAll("\\-", "&#45;");
	 str=str.replaceAll("\\(", "&#40;");
	 str=str.replaceAll("\\)", "&#41;");
	 str=str.replaceAll("\\>", "&#62;");
	 str=str.replaceAll("\\<", "&#60;");
	 str=str.replaceAll("\\_", "&#95;");
	 str=str.replaceAll("\\ ", "&#95;");
	 str = "<"+str+">";
	 return str;
	}
	
	
	
	
	private void thanks() throws InterruptedException
	{
System.out.println("grazie per il tuo tempo. per ringraziarti, eccoti qualche scena di nudo");
Thread.sleep(4000);
System.out.println("                      _..--''`-..._");
System.out.println("                   -'             `-.");
System.out.println("                .-'                  `-.");
System.out.println("               /   .-'''''''''--.       \\ ");
System.out.println("               |  /__........_   `-.    |");
System.out.println("               \\ / -. .--._  ``-._ |   /");
System.out.println("                / /\\ V //  `--._ -`-  /");
System.out.println("               / / || | |       \\\\ \\`/");
System.out.println("                |  || |\\|        \\\\ \\");
System.out.println("               /| // /-._   _... ||  \\");
System.out.println("              //\\ \\ / <o>   <o>  ||\\\\|   TO PROTECT");
System.out.println("              /  \\//     /      // |\\\\    AND SERVE");
System.out.println("              \\| \\\\_\\    ._/   // /|//");
System.out.println("               |\\ //|\\  .__.   / / |//");
System.out.println("                \\|/// \\ `=='  / / ///");
System.out.println("                 \\//  |\\    .' / // -.");
System.out.println("                     /-.`--' -'.' |   `------.");
System.out.println("              _..---' \\ `-..-'   /            \\            .");
System.out.println("           .-'         \\  /@ \\  /              \\         . \\\\");
System.out.println("           |     .$.     \\/.--.\\/_               \\       /|#||");
System.out.println("          /     $$$  _-'         `-.       /     .    .'  #||");
System.out.println("         .   \\  `$' /               \\      |     |   :   _#/");
System.out.println("         |    |    /           /    /      \\     |   |  / #");
System.out.println("         |    /    `.     \\   /    /        \\    |   /  : 6");
System.out.println("         |   /       `-.      .   /          |   |  /   ' 9");
System.out.println("         |  |           `-/.___.-'           |.==\\.'   /.-6-.");
System.out.println("         |  |            /      \\            |   /    /((   ))");
System.out.println("         |`= \\        ..-    @   \\          /   /    :  `-.-'");
System.out.println("        |     `..___--            `--..__.-'  .'     :");
System.out.println("        '      |\\            @            /| /      /");
System.out.println("        /       :|___________...._________/ \\       /");
System.out.println("       .        /|                       /   \\     /");
System.out.println("       :       / /                      /     `._.'");
System.out.println("       |     .'./ \\                    /");
System.out.println("       |     :/    `.                 |");
System.out.println("       |    /'       `-.              |");
System.out.println("       :   /            `-.  c     _.'\\");
System.out.println("       /   /                `-..--''    \\");
System.out.println("      /   /       .                     |");
System.out.println("     /   /`-.       .       @           |");
System.out.println("    .-- \\    `-._    .             .    |");
System.out.println("  _/    \\\\_______\\______________________/____");
System.out.println("((_\\\\\\\\\\|u((_________________________________)");
System.out.println("    `---|             \\       __..---''");
System.out.println("        \\              \\ _.--'        |");
System.out.println("                        /             /");
System.out.println("         \\             /");
System.out.println("                      |              /");
System.out.println("           \\          |");
System.out.println("            \\         |             /");
System.out.println("             \\        |            /");
System.out.println("              \\       |           /");
Thread.sleep(4000);
System.out.println("\n\ntroppo vestita..vero?\n\n");
Thread.sleep(4000);




System.out.println("                     |            \\   ");
System.out.println("                    |       \\      |  ");
System.out.println("                    | @      \\      \\  ");
System.out.println("              _.. _  \\        |     |  ");
System.out.println("             / /'''\\\\ |         \\     \\  ");
System.out.println("            / / _  _|) \\         \\    |  ");
System.out.println("           /  )  _' |\\ |          \\    |  ");
System.out.println("        __/-')\\ `-'/') |          |    |  ");
System.out.println("    _.-'       ` -'( )) \\         |    )  ");
System.out.println(" .-'     _,        )( ) |          \\   |  ");
System.out.println("(     .-\"_'    \\    \\   ##         \\   |  ");
System.out.println(" ``-.__   `-._//`\\'__\\___#/        |   /  ");
System.out.println("       `--._   \\ 0)_____ (        /    |  ");
System.out.println("         '  `\\\\\\\\,'__.' )|       | ,   /  ");
System.out.println("        /       ~~.'    ( |       </ ||||  ");
System.out.println("      .'        /       `-|        ,////  ");
System.out.println("   .'       . )'          |       /  ");
System.out.println("   |         \\            |      |  ");
System.out.println("    \\         \\           |      |  ");
System.out.println("     `\\        \\          (     /  ");
System.out.println("       `\\       \\         |     |  ");
Thread.sleep(3000);
System.out.println("\n\nok, adesso lasciami acceso.. ciao ciao");
Thread.sleep(3000);
	 	
}

	
	
	
	
	
	
	

}

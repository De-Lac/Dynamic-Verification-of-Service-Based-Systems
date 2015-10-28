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
package partes.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Vector;

import javax.xml.bind.JAXBException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ow2.choreos.partes.PartesTestGenerator;

import partes.exception.BPMNmalformedException;
import partes.exception.TestGenerationException;
import partes.refactorRunner.PartesInfo;
import partes.utils.Jsonize;
import partes.utils.PartesConf;
import partes.utils.WriteToFile;
import partes.utils.YamlReader;

/**
 * The Class PartesMain.
 */
public class PartesMain {

	public static PartesMain instance = null;

	/** The debug. */
	public boolean debug;

	private static Log log = LogFactory.getLog(Partes.class);

	/** The model files */
	public String bpmnPath;
	public String choreographyTModelKey;
	public Vector<PartesInfo> servicesWsdlUrl; // mapping between role and wsdl


	public PartesMain()
		{
		 while (instance != null)
		 	{try {
			 		long range = (long)3000 - (long)500 + 1;
			 	    long fraction = (long)(range * new Random().nextDouble());
			 	    int randomNumber =  (int)(fraction + 500);
			 	    System.out.println("wait "+randomNumber+" for the termination of another instance");
		 		    Thread.sleep(randomNumber); 
		 		  } 
		 	 catch (NumberFormatException | InterruptedException e) 
		 	 	{handleError(e.getMessage(), e);}
		    }
		 instance = this;
		}

	
//	====== TESTING PURPOSE  main TO getTestSuite ======
	public static void main2 (String[] a) throws IOException
	{
		instance = new PartesMain();
		System.out.println(instance.getTestSuites("uddi:choreos.eu:choreographies:passenger-friendly airport"));
	}
	
	
	/**
	 * @return TestSuites of a Choreography providing its ID
	 * @throws IOException 
	 */
	public String getTestSuites(String choreographyTModelKey) throws IOException 
	{
			this.choreographyTModelKey = choreographyTModelKey;

			ArrayList<String[]> tests = new ArrayList<String[]>();
			// ===== ERRORS ========
			{
				String path = PartesConf.getString("outputPath")+File.separator+"error"+File.separator+"error.txt";
				if (new File(path).exists())
				{
					String error = readFile(path);
					return Jsonize.getError(error);
				}
			}
			// ===== TEST SUITE =========
			{
				String path = PartesConf.getString("outputPath")+File.separator+"TestSuite";
				// catch the exception that no files exists
				try{ File temp = new File(path). listFiles()[0];}
				catch(NullPointerException ex) {throw new IOException();}
				
				for (File dir : new File(path). listFiles())
				{
					for (File file : new File(path+"/"+dir.getName()). listFiles())
					{
						String[] row = new String[2];
						row[0]=file.getName() ; 
						System.out.println(row[0]);
						row[1] = readFile(path+"/"+dir.getName()+"/"+file.getName());
						tests.add(row);
					}
				}
			}
			String result = Jsonize.getTestSuites(tests);
			PartesMain.instance=null;
			return (result);
	}
	
	
	/**
	 * the main to call by command line
	 * @param args
	 * <pre>
	 * -d                for the debug
	 * -p /../../xyz.bpmn  for the bpmn2 choreography
	 * -y /../../xyz.yml   for the .yml file with references role-wsdl
	 * 
	 * For the structure of the .yml file, see {@link #run(String, boolean, LinkedHashMap)}
	 * </pre>
	 */
	public static void main(String[] args) 
	{
		instance = new PartesMain();
		
		// create Options object
		Options options = new Options();

		// create an HelFormatter
		HelpFormatter formatter = new HelpFormatter();

		// add options
		options.addOption("d", "debug", false, "build xml files for debug [optional]");
		options.addOption("p", "partes", true, "specify bpmn path [required]");
		options.addOption("y", "yaml", true, "specify yaml path with list of wsdl [required]");

		CommandLineParser parser = new PosixParser();
		CommandLine cmd;
		// ================= manual default specification ====================
		
		if (args.length==0)
			{// if no argument is passed, default is taken (for testing purpose)
			 formatter.printHelp("PartesMain", options, true);
			 System.out.println("\n\nno argument is passed, default is taken (for testing purpose)");
			 args = new String[2];
//			 args[0]="-p "+args[0];
			 args[0]="-p /Users/danielefani/Documents/workspace/eclipse/Mars/VVframework/Dynamic-Verification-of-Service-Based-Systems/ParTes/Partes WS test generator/TestSuiteExamples/Friendly_Passenger Airport/choreography_1.bpmn";
//			 args[0]="-p wp7.bpmn";
			 args[1]="-y /Users/danielefani/Documents/workspace/eclipse/Mars/VVframework/Dynamic-Verification-of-Service-Based-Systems/ParTes/Partes WS test generator/TestSuiteExamples/Friendly_Passenger Airport/role_matching.yml";
//			 args[2]="-d";
			}
		// ===========================================================

		boolean dbg = false;
		String bpmnFile="";
		String yamlFile="";

		try 
		{
			cmd = parser.parse(options, args);
			if (cmd.getOptions().length == 0) 
			{
				// automatically generate the help statement and exit
				formatter.printHelp("PartesMain", options, true);
				System.exit(0);
			}

			// debug
			dbg = false;
			if (cmd.hasOption("d")) 
				{ dbg = true; }

			// bpmn
			if (cmd.getOptionValue("partes") == null) 
				{
				 formatter.printHelp("PartesMain", options, true);
				 System.exit(0);
				}
			else
				{bpmnFile = cmd.getOptionValue("partes").trim();}

			//yml
			if (cmd.getOptionValue("y") == null)
				{
				 formatter.printHelp("PartesMain", options, true);
				 System.exit(0);	
				}
			else
				{
				 yamlFile = cmd.getOptionValue("y").trim();
				}

		} 
		catch (ParseException e) 
			{
			 formatter.printHelp("PartesMain", options, true);
			 System.exit(0);
			}	
		try 
			{ instance.run_withYmlPath(bpmnFile, dbg, yamlFile, "DefaultChoreography"); } 
		catch (BPMNmalformedException e) 
			{
			 String error = "BPMN choreography should respect some rules to be applied to Partes \n ";
			 instance.handleError(error, e);
			} 
		catch (TestGenerationException e) 
			{
			 String error = "ERROR maybe there is an arror in the matching between role and service\n ";
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
	 * @param bpmn  the path to the bpmn file
	 * @param debug
	 * @param yml  the path of the .yml file with the mapping between role and wsdl
	 * <pre>
	 *  =====================================================
	 *  The yaml file should respect this structure:
	 * 
	 * participants:
	 * -   modelImplClass: Airport
	 *     portTypeToSearch: IAirport
	 *     wsdlLocation: /Users/DeLac/Desktop/rpst/Airport.wsdl
	 * -   modelImplClass: ATC
	 *     portTypeToSearch: IAirTrafficControl
	 *     wsdlLocation: /Users/DeLac/Desktop/rpst/AirTrafficControl.wsdl
	 * =====================================================
	 * 
	 * The reading of the yaml file could be done as follow:
	 * 		org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml();
	 *		LinkedHashMap readedInfo = (LinkedHashMap) yaml.load(new FileReader(ymlFileName));
	 * </pre>
	 * @return the error or the state of the execution
	 * @throws TestGenerationException 
	 * @throws BPMNmalformedException 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public String run_withYmlPath(String bpmn, boolean debug, String ymlPath, String choreographyTModelKey) throws BPMNmalformedException, TestGenerationException, JAXBException, FileNotFoundException
	{
	 return run(bpmn, debug, YamlReader.getPartesParticipantInformation(ymlPath), choreographyTModelKey); 
	}



	public String run_withYmlContent(String bpmn, boolean debug, String ymlContent, String choreographyTModelKey) throws BPMNmalformedException, TestGenerationException, JAXBException
	{
	 try
	 	{
		 File temp = File.createTempFile("participants", ".yml"); 	 
		 BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		 bw.write(ymlContent);
		 bw.close();
		 return run(bpmn, debug, YamlReader.getPartesParticipantInformation(temp), choreographyTModelKey);
	 	}
	 catch(IOException ex)
	 	{
		 ex.printStackTrace();
		 String error = "ERROR ["+PartesMain.class.getName()+"] ERROR during the reading of the content of the temporary yaml file \n"+ex.getMessage();
		 return instance.handleError(error, ex);
	 	}
		
	}




	/**
	 * 
	 * @param bpmn  it could be a local path (/Users/Daniele/.../xyz.bpmn) or an URL (http://mysite/xyz?wsdl)
	 * @param debug
	 * @param choreographyTModelKey 
	 * @param servicesInfo
	 * @return Map<TestSuiteName, TestSuiteFileContent>  or  Map<"error", errorType>
	 * @throws TestGenerationException 
	 * @throws BPMNmalformedException 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 * @see PartesMain#run(String, boolean, String)
	 */
	private String run(String bpmn, boolean debug, Vector<PartesInfo> servicesWsdlUrl, String choreographyTModelKey) throws BPMNmalformedException, TestGenerationException, FileNotFoundException, JAXBException
	{
		instance.bpmnPath = bpmn;
		instance.servicesWsdlUrl = servicesWsdlUrl;
		instance.debug = debug;
		instance.choreographyTModelKey= choreographyTModelKey; 
		System.out.println("start of ParTes execution");

		PartesTestGenerator p = new Partes();
		// delete the old directory if exists
		deleteOutputDirectory(new File(PartesConf.getString("outputPath")));
		
		HashMap<String, HashMap<PartesInfo, String>> xmlTests;
		xmlTests = p.generateTestSuite(); 
		System.out.println("generated test suite for:");

		ArrayList<String[]> tests = new ArrayList<String[]>();
		
		for (String condition : xmlTests.keySet())
		{
			for (PartesInfo participant : xmlTests.get(condition).keySet()) 
			{
				String xmlTest = xmlTests.get(condition).get(participant);
				String testSuiteFileName = "test-";
				if (participant == null)
					{// test of traces
					 testSuiteFileName += "traces.xml";
					}
				else
					{// test of one participant
					 testSuiteFileName += participant.getPortTypeToSearch() + ".xml";
					}
				String[] test = new String[2]; 
				test[0] = condition+"/"+testSuiteFileName ; 
				test[1] = xmlTest;
				tests.add(test);
				WriteToFile.writeToANewFileInOutputDir("TestSuite"+File.separator+condition, testSuiteFileName, xmlTest);
			}
		}

		System.out.println("end of ParTes execution");
		PartesMain.instance = null;
		return Jsonize.getTestSuites(tests);
	}

	public  boolean doDebug()
		{return debug;}
	
	
	private String readFile(String filePath) throws IOException 
	{
		BufferedReader br = null;
			BufferedReader input = new BufferedReader(new FileReader(filePath));
			StringBuffer buffer = new StringBuffer();
			String text;
			while ((text = input.readLine()) != null)
			{ buffer.append(text + "\n"); }
			input.close();
			return (buffer.toString());
		
	}
	
	
	
	private void deleteOutputDirectory(File dir)
	{
		if(dir.isDirectory())
		{
			//directory is empty, then delete it
			if(dir.list().length==0)
			{ dir.delete(); }
			else
			{
				String files[] = dir.list();
				for (String temp : files) 
				{ File fileDelete = new File(dir, temp);
				deleteOutputDirectory(fileDelete);
				}
				//check the directory again, if empty then delete it
				if(dir.list().length==0)
				{ dir.delete(); }
			}

		}
		else { dir.delete(); }
	}
	
	protected String handleError(String error, Exception e)
	{
	 System.out.println(error);
	 log.error(error+"\n"+e);
	 e.printStackTrace();
	 WriteToFile.writeToANewFileInOutputDir("error", "error.txt", Calendar.getInstance().getTime()+"\n"+error+"\n"+e);
	 PartesMain.instance = null;
	 return Jsonize.getError(error);	
	}	

}

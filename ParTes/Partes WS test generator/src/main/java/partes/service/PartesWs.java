package partes.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import partes.exception.BPMNmalformedException;
import partes.exception.TestGenerationException;
import partes.utils.Jsonize;
import partes.utils.PartesConf;
import partes.utils.WriteToFile;


public class PartesWs 
{


	public PartesWs()
	{
		
	}

	public String  helloService(String msg){
		return "Hello "+ msg;
	}
	
	
	public String getTestSuite(String choreographyTModelKey) throws IOException 
		{
		 try {
			  return new PartesMain().getTestSuites(choreographyTModelKey);
		 	 } 
		 catch(IOException e)
			{
			 PartesMain.instance=null;
			 throw new IOException("##!! TestSuite not found for: "+choreographyTModelKey+" !!]]");
			 }
		}
	
	
	/**
	 * 
	 * @param bpmn path or url
	 * @param yml path
	 * @param debug
	 * @param choreographyTModelKey -> the ID used to identify the chor.
	 * @return Map<TestSuite_name, TestSuite_file_content> or Map<"error", errorType>
	 * 
	 * the structure of the .yml file must follow this structure:
	 * {@link partes.service.PartesMain#run(String, boolean, LinkedHashMap)}
	 */
	public String generateSOAPuiTestSuiteFromYmlPath (String bpmnPath, String ymlPath, boolean debug, String choreographyTModelKey) 
	{
		System.out.println("Partes service invoked");
		try 
			{ 
			 String ymlContent = new Scanner(new File(ymlPath)).useDelimiter("\\Z").next(); 
			 return generateSOAPuiTestSuiteFromYmlContent(bpmnPath, ymlContent, debug, choreographyTModelKey); 
			} 
		catch (FileNotFoundException e) 
			{ 
			 String error = "ERROR  FileNotFoundException "+ymlPath;
			 System.out.println(error);
			 e.printStackTrace();
			 WriteToFile.writeToANewFileInOutputDir("error", "error.txt", Calendar.getInstance().getTime()+"\n"+error+"\n"+e);
			 return Jsonize.getError(error);
			}
		
	}
	
	/**
	 * 
	 * @param bpmn
	 * @param ymlContent
	 * @param debug
	 * @param choreographyTModelKey -> the ID used to identify the chor.
	 * @return Map<TestSuite_name, TestSuite_file_content> or Map<"error", errorType>
	 */
public String generateSOAPuiTestSuiteFromYmlContent(String bpmn, String ymlContent, boolean debug, String choreographyTModelKey)
  {
	String error;
	PartesMain pm = new PartesMain();
    try 
		{ return pm.run_withYmlContent(bpmn, debug, ymlContent, choreographyTModelKey); } 
	catch (BPMNmalformedException e) 
		{
		 error = "ERROR BPMN choreography should respect some rules to be applied to Partes \n "+e;
		 return pm.handleError(error, e);
		} 
	catch (TestGenerationException e) 
		{
		 error = "ERROR maybe there is an arror in the matching between role and service\n "+e;
		 return pm.handleError(error, e);
		} 
	catch (JAXBException e) 
		{
		 error = "ERROR converting BPMN elements in java JAXB elements\n"+e;
		 return pm.handleError(error, e);
		}
    catch (Exception e)
    	{
    	 error = "ERROR "+e.toString();
    	 return pm.handleError(error, e);
    	}
	}

	
	

}

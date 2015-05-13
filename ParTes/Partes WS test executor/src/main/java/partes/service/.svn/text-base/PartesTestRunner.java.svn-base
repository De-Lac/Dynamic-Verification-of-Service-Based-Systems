package partes.service;

import java.util.List;

import com.eviware.soapui.model.testsuite.TestAssertion;
import com.eviware.soapui.tools.SoapUIMockServiceRunner;
import com.eviware.soapui.tools.SoapUITestCaseRunner;

public class PartesTestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
			{
			 String testPath="/Users/DeLac/Desktop/rpst/refactoring/whole choreography traces/test-traces.xml";
//			 String testPath="https://dl.dropboxusercontent.com/u/13520648/test-traces.xml";
			 String choreography = "airport";
			 testRunner(testPath, choreography);
			} 
		catch (Exception e) 
			{e.printStackTrace();}
	}

	public static String testRunner(String testPath, String choreography) throws Exception 
	{
		SoapUITestCaseRunner testCaseRunner = new SoapUITestCaseRunner();
		SoapUIMockServiceRunner mockServiceRunner = new SoapUIMockServiceRunner();
		testCaseRunner.setProjectFile (testPath);
		testCaseRunner.setOutputFolder(PartesTRconf.getString("outputPath")+choreography+"/");
		mockServiceRunner.setProjectFile(testPath);
		List<TestAssertion> assertions = testCaseRunner.getAssertions();
		for (TestAssertion t : assertions)
			{
			  System.out.println(t.getDescription());
			  System.out.println(t.getLabel());
			  System.out.println(t.getName());
			  System.out.println(t.getSettings().toString());
			  System.out.println("================");
			}
		mockServiceRunner.run();
		System.out.println("TestSuite:  "+testCaseRunner.getTestSuite());
		System.out.println("TestCase:  "+testCaseRunner.getTestCase());
		System.out.println("TestStep number:  "+testCaseRunner.getTestStepCount());
		System.out.println("host: "+testCaseRunner.getHost());
		testCaseRunner.setEnableUI(true);
		try
			{ testCaseRunner.run(); }
		catch(Exception ex)
			{return "Error "+ex.getMessage();}
		mockServiceRunner.stopAll();
		return ("OK");
	}

}

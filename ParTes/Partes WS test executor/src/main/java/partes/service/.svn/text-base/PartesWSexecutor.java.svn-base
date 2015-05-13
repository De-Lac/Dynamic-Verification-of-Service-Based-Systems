package partes.service;


public class PartesWSexecutor 
{


	public PartesWSexecutor()
	{
		
	}

	public String  helloService(String msg)
		{return "[PartesWSexecutor] Hello "+ msg;}
	
	
	
	public String executeTestSuite(String testPath, String choreographyName)
	{
	 try 
	 	{return  PartesTestRunner.testRunner(testPath, choreographyName);} 
	 catch (Exception e) 
		{
		 e.printStackTrace();
		 return "ERROR  "+e.getMessage();
		}
	}
	
	

}

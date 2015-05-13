package partes.utils;

import java.util.ArrayList;

public class Jsonize {

	public static String getError(String error)
	{
	 return "{ \"items\" : [ { \"type\" : \"error\", \"content\": \""+error+"\" } ] }";
	}
	
	/**
	 * <pre>
	 * @param tests =  ArrayList<TestSuiteName, TestSuiteContent>
	 * </pre>
	 * @return
	 */
	public static String getTestSuites(ArrayList<String[]> tests)
	{
	 String result = "{ \"items\" : [";
	 for (String[] test : tests)
	 	{
		 String testSuiteName = org.codehaus.jettison.json.JSONObject.quote(test[0]);
		 String testSuiteContent = org.codehaus.jettison.json.JSONObject.quote(test[1]);
		 result += "{ \"type\" : \"testsuite\", \"name\":\""+testSuiteName+"\", \"content\" : \""+testSuiteContent+"\"},";
	 	}
	 result += "] }";
	 return result;
	}

}

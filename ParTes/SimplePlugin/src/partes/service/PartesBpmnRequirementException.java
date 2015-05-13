package partes.service;

public class PartesBpmnRequirementException extends Exception {

	static String  WRONG_LINKED_WSDL_LOCATION = "[#className#] Error. TestSuite not generated cause #componentName# has not the wsdlLocation!!!" +
			"\n##### SUGGESTION ON HOW TO SOLVE THIS PROBLEM #####"+
	        "\n It could be impossible to retrieve or it's just blank." +
			"\nThe choreography.bpmn structure should have this strucutre:" +
			"\n=================================================" +
			"\n<bpmn2:interface id='Interface_1' implementationRef='ns1:Role_Name' name='Role_Name'>" +
			"\n   <bpmn2:operation>.... " +
			"\n   ....." +
			"\n</bpmn2:interface>" +
			"\n...." +
			"\n...." +
			"\n<bpmn2:participant id='Participant_1' name='P1'>" +
			"\n   <bpmn2:interfaceRef>Interface_1</bpmn2:interfaceRef>" +
			"\n</bpmn2:participant>" +
			"\n=================================================" +
			"\nIf you don't know how to solve this problem, we suggest you "+
			"\n to write the matching between roles and services in a .yml file according to the documentation."+
			"\n\n the .yml file should be as follow:\n"+
			"\nparticipants"+
			"\n-   modelImplClass: roleName"+
			"\n    portTypeToSearch: portTypeName"+
			"\n    wsdlLocation: http://../../serviceName.wsdl"+
			"\n-   modelImplClass: roleName2"+
			"\n..."+
			"\n\n the .yml file should be passed to ServicePot in this way:\n"+
			"\n <arg0>"+
			"\n   <authInfo>authtoken:#######</authInfo>"+
			"\n   <choreographyURI>-p https://bpmnURI/chorName.bpmn;;-y http://ymlURI/participantsFileName.yml</choreographyURI>"+
			"\n <arg0/>";	
	
	
	public PartesBpmnRequirementException (String message)
	{ super (message); }
	
	
	public static void rise (String errorType, String componentName, String className) throws PartesBpmnRequirementException
	{
	 String error = errorType.replaceAll("#componentName#", componentName);
	 error = errorType.replaceAll("#className#", className);
	 System.out.println(error);
	 throw new PartesBpmnRequirementException(error);
	}
	
	

}

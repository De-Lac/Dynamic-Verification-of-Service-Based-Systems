package service;

import javax.jws.WebService;
import it.unicam.cassandra.example.sso.contract.idp.IdpPortType;


@WebService(targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Idp", 
            portName="IdpPort",
            serviceName="IdpService", 
            endpointInterface="it.unicam.cassandra.example.sso.contract.idp.IdpPortType")
public class IdpPortTypeImpl implements IdpPortType {
	
	protected int INTERNAL_STATE=1;
//	private String SERVER_USER = "http://localhost:8080/user/services/user"; // user agent
	private String SERVER_USER  = "http://localhost:6969/user_role"; // servicemix	
	private SOAPmessages soapMessages;
	
	
	public IdpPortTypeImpl()
	{
	 super();
	 soapMessages = new SOAPmessages(this); 
	}
	
    public String authentication(String key, String username, String password)
    {
     INTERNAL_STATE=2;
     String token = "Bkdk4k33";
     System.out.println("[Idp["+INTERNAL_STATE+"]#authentication] "+username+" authenticated with token "+token);
     System.out.println("[Idp]  3 identities found: 1) iamDeLac, 2)elSonador,  3)danielefani");
     String response="{\"token\":\""+token+"\", \"ids\":[{\"id\":\"iamDeLac\"},{\"id\":\"elSonador\"},{\"id\":\"danielefani\"}]}";
     try
	 	{
    	 response = soapMessages.callIdentityPrincipal(response, SERVER_USER);
    	 token = "Bkdk4k33-id001";
    	 return soapMessages.callResponse(token, SERVER_USER);
	 	}
	 catch(javax.xml.soap.SOAPException ex){ex.printStackTrace(); return ex.getMessage(); }
     catch(java.net.MalformedURLException ex){ex.printStackTrace(); return ex.getMessage();}
     catch(java.io.IOException ex){ex.printStackTrace(); return ex.getMessage();}
    }


    
}


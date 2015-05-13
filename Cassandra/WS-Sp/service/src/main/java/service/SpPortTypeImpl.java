package service;

import javax.jws.WebService;
import it.unicam.cassandra.example.sso.contract.sp.SpPortType;


@WebService(targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", 
            portName="SpPort",
            serviceName="SpService", 
            endpointInterface="it.unicam.cassandra.example.sso.contract.sp.SpPortType")


public class SpPortTypeImpl implements SpPortType {
	
	private SOAPmessages soapMessages; 
//	private String server_idp  = "http://localhost:8080/idp/services/idp"; // identity provider
	private String server_idp  = "http://localhost:6969/idp_role"; // servicemix
//	private String server_user  = "http://localhost:8080/user/services/user";   // user agent
	private String server_user  = "http://localhost:6969/user_role"; // servicemix
    protected int INTERNAL_STATE=1;
	
    
    public SpPortTypeImpl()
	{
	 super();
	 soapMessages = new SOAPmessages(this); 
	}
    
    
    public String requestResource(int resourceId)
        {
    	String key="XF343DFGDER";
    	INTERNAL_STATE=2;
    	 System.out.println("[Sp["+INTERNAL_STATE+"]#requestResource] generated key: "+key+" for resource "+resourceId);
    	 if (resourceId>0)
    		 {
    		  try
    		    { 
    			  return soapMessages.callAuthenticationRequest(key, server_user);}
    		  catch(javax.xml.soap.SOAPException ex){ex.printStackTrace(); return ex.getMessage(); }
    	      catch(java.net.MalformedURLException ex){ex.printStackTrace(); return ex.getMessage();}
    	      catch(java.io.IOException ex){ex.printStackTrace(); return ex.getMessage();}
    		 }
    	 else
    	 	{return "resource not available";}
        }
    
        
 
    
    public String notIdentified(String in)
    {
    	INTERNAL_STATE=1;
    	System.out.println("[Sp["+INTERNAL_STATE+"]#notIdentified] ");	
    	return "ok";
    }

    
    public String identified(int resourceId, String token)
    {
    	INTERNAL_STATE=4;
    	System.out.println("[Sp["+INTERNAL_STATE+"]#identified] ");	
    	/*generate link to access the resource*/
    	String link = "http://myserver/"+resourceId+"/"+token;
    	 try
		    { 
			  return soapMessages.callReleaseResource(link, server_user);}
		  catch(javax.xml.soap.SOAPException ex){ex.printStackTrace(); return ex.getMessage(); }
	      catch(java.net.MalformedURLException ex){ex.printStackTrace(); return ex.getMessage();}
	      catch(java.io.IOException ex){ex.printStackTrace(); return ex.getMessage();}
    }

    
    
}


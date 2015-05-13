package service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jws.WebService;
import javax.swing.JOptionPane;

import it.unicam.cassandra.example.sso.contract.user.UserPortType;


@WebService(targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/User", 
            portName="UserPort",
            serviceName="UserService", 
            endpointInterface="it.unicam.cassandra.example.sso.contract.user.UserPortType")
public class UserPortTypeImpl implements UserPortType {
	
//	private final String SERVER_IDP  = "http://localhost:8080/idp/services/idp"; // identity provider
	private String SERVER_IDP  = "http://localhost:6969/idp_role"; // servicemix
	protected int INTERNAL_STATE=1;
	private SOAPmessages soapMessages;
	private String token="";
	
	
	
	public UserPortTypeImpl()
	{
	 super();
	 soapMessages = new SOAPmessages(this); 
	}
	
    public String response(String token)
    {
     INTERNAL_STATE=6;
     System.out.println("[User["+INTERNAL_STATE+"]#response] "+token);
     this.token=token;
     /*do something*/
     return "confirmed";	
    }

    
   
    public String startRequestResource(int resourceId, String serviceProviderServer) 
    {
    	INTERNAL_STATE=1;
    	System.out.println("[User["+INTERNAL_STATE+"]#startRequestResource] "+resourceId);
    	try
    	 { 
    	  String response = soapMessages.callRequestResource(resourceId, serviceProviderServer);
    	  if (response.equals("confirmed"))
    		  {
    		   String tk = token;
    		   token=""; //reset
    		   return soapMessages.callIdentified(resourceId, tk, serviceProviderServer);
    		  }
    	  else
    	      {return "error during the request of the resource: "+response;}
    	 }
    	catch(javax.xml.soap.SOAPException ex){ex.printStackTrace(); return ex.getMessage(); }
    	catch(java.net.MalformedURLException ex){ex.printStackTrace(); return ex.getMessage();}
    	catch(java.io.IOException ex){ex.printStackTrace(); return ex.getMessage();}
    }

   
    public java.lang.String authReq(java.lang.String sp_key)
     {
    	INTERNAL_STATE=3;
    	System.out.println("[User["+INTERNAL_STATE+"]#authReq] "+sp_key);
    	/*do something*/
    	try
    	 {return soapMessages.callAuthentication(sp_key, SERVER_IDP);}
    	catch(javax.xml.soap.SOAPException ex){ex.printStackTrace(); return ex.getMessage(); }
	    catch(java.net.MalformedURLException ex){ex.printStackTrace(); return ex.getMessage();}
	    catch(java.io.IOException ex){ex.printStackTrace(); return ex.getMessage();}
     }

    
    /**
     * token = {"token":"DSF4e", "IDs":[{"id":"iamDeLac"},{"id":"elSonador"}]}
     */
     public java.lang.String identityPrincipal(java.lang.String token)
     {
    	 INTERNAL_STATE=5;
    	 System.out.println("[User#identityPrincipal["+INTERNAL_STATE+"]] "+token);
    	    String tk="";
    	    String id="";  
    	    // get token
    	    Pattern pattern = Pattern.compile("\"token\"\\:\"(.*?)\"");
    	    Matcher matcher = pattern.matcher(token);
    	    while (matcher.find()) 
    	      { tk =(matcher.group(1)); }
    	    
      	    // get ids
      	    pattern = Pattern.compile("\"id\"\\:\"(.*?)\"");
      	    matcher = pattern.matcher(token);
      	    while (matcher.find()) 
      	      { id +=(matcher.group(1))+";";} //; used for splitting
      	    String[] ids = id.split(";");
      	    
      	    String chosedId = (String) JOptionPane.showInputDialog(null, 
      	    													   "Choose desired id",
      	    													   "With which user you want to request the resource?", 
      	    													    JOptionPane.QUESTION_MESSAGE, 
      	    													    null,
      	    													    ids, // Array of choices
      	    													    ids[0]); // Initial choice
      	    return (chosedId);
     }
     
     
     

    public java.lang.String releaseResource(java.lang.String link)
     {
    	INTERNAL_STATE=8;
    	System.out.println("[User["+INTERNAL_STATE+"]#releaseResource] "+link);
    	JOptionPane.showMessageDialog(null, "you can access the resource at "+link);
    	return "ok, resource released";
     }

    
}


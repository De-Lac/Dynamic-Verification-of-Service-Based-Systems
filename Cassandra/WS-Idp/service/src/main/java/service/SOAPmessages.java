package service;


/**
 * guide from  http://learnfrommike.blogspot.it/2012/06/sending-soap-message-as-plain-xml-with.html
 */


import java.io.FileOutputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.namespace.QName;
import javax.swing.JOptionPane;

import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;


public class SOAPmessages {
	
	private MessageFactory factory;
    private IdpPortTypeImpl idp_service;
	
	
	public SOAPmessages(IdpPortTypeImpl idp_service)
	{
	 this.idp_service = idp_service;
	 try
	  { factory = MessageFactory.newInstance();}
	 catch(SOAPException ex){ex.printStackTrace();}
	}
	
	/**
	 *
	 * <pre>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://www.unicam.it/cassandra/example/sso/contract/User">
   <soapenv:Header/>
   <soapenv:Body>
      <user:identityPrincipal>
         <token>{"token":"DSF4e", "IDs":[{"id":"iamDeLac"},{"id":"elSonador"}]};</token>
      </user:identityPrincipal>
   </soapenv:Body>
</soapenv:Envelope>
     *</pre>
	 */
	public String callIdentityPrincipal(String token, String user_server) throws SOAPException, MalformedURLException, IOException
	{
		SOAPMessage soapMsg = factory.createMessage();
		SOAPPart part = soapMsg.getSOAPPart();

		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader header = envelope.getHeader();
		SOAPBody body = envelope.getBody();

		header.addTextNode("IdentityPrincipal");
		SOAPBodyElement element = body.addBodyElement(envelope.createName("identityPrincipal", "user", "http://www.unicam.it/cassandra/example/sso/contract/User"));
		element.addChildElement("token").addTextNode(token);
		
		idp_service.INTERNAL_STATE=3;
		System.out.println("[Idp["+idp_service.INTERNAL_STATE+"]] callIdentityPrincipal:");
//		soapMsg.writeTo(System.out);System.out.println();
		
		// IdentityPrincipal response
		SOAPMessage response = sendMessage(user_server, soapMsg);
		
		return parseIdentityPrincipalResponse(response);

	}
	
	
	
	/**
	 * <pre>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://www.unicam.it/cassandra/example/sso/contract/User">
   <soapenv:Header/>
   <soapenv:Body>
      <user:response>
         <in>?</in>
      </user:response>
   </soapenv:Body>
</soapenv:Envelope>
     *</pre>
	 */
	public String callResponse(String token, String user_server) throws SOAPException, MalformedURLException, IOException
	{
		SOAPMessage soapMsg = factory.createMessage();
		SOAPPart part = soapMsg.getSOAPPart();

		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader header = envelope.getHeader();
		SOAPBody body = envelope.getBody();

		header.addTextNode("Response");
		SOAPBodyElement element = body.addBodyElement(envelope.createName("response", "user", "http://www.unicam.it/cassandra/example/sso/contract/User"));
		element.addChildElement("in").addTextNode(token);

		idp_service.INTERNAL_STATE=4;
		System.out.println("[Idp["+idp_service.INTERNAL_STATE+"]] callResponse:");
//		soapMsg.writeTo(System.out);System.out.println();
		
		// Response response
		SOAPMessage response = sendMessage(user_server, soapMsg);
		
		return parseResponseResponse(response);

	}	
	


	
/**
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:identityPrincipalResponse xmlns:ns2="http://www.unicam.it/cassandra/example/sso/contract/User">
         <out>{"token":"DSF4e", "id":"iamDeLac"}</out>
      </ns2:identityPrincipalResponse>
   </soap:Body>
</soap:Envelope>	 
*/
	private String parseIdentityPrincipalResponse(SOAPMessage response) throws SOAPException, IOException
	{
        SOAPBody sb = response.getSOAPBody();
        QName bodyName = new QName("http://www.unicam.it/cassandra/example/sso/contract/User", "identityPrincipalResponse", "ns2");
        java.util.Iterator iterator = sb.getChildElements(bodyName);
        String value="";
        while (iterator.hasNext()) 
         {
          SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
          value += bodyElement.getTextContent();
         }
        System.out.println("[Idp["+idp_service.INTERNAL_STATE+"] callIdentityPrincipalResponse] the user chose "+value);
		/*response.writeTo(System.out);System.out.println();*/
		return value;	
	}
	
	
	
	/**
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:responseResponse xmlns:ns2="http://www.unicam.it/cassandra/example/sso/contract/User">
         <out>confirmed</out>
      </ns2:responseResponse>
   </soap:Body>
</soap:Envelope>	 
	*/
		private String parseResponseResponse(SOAPMessage response) throws SOAPException, IOException
		{
	        SOAPBody sb = response.getSOAPBody();
	        QName bodyName = new QName("http://www.unicam.it/cassandra/example/sso/contract/User", "responseResponse", "ns2");
	        java.util.Iterator iterator = sb.getChildElements(bodyName);
	        String value="";
	        while (iterator.hasNext()) 
	         {
	          SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
	          value += bodyElement.getTextContent();
	         }
	        System.out.println("[Idp["+idp_service.INTERNAL_STATE+"]] ResponseResponse: "+value); 
			/*response.writeTo(System.out);System.out.println();*/
			return value;	
		}
	
	
	
	
	
	/**
	 * @param server
	 *  server where to send the message
	 * @param reqStr
	 *  the SOAP message to send
	 */
	private SOAPMessage sendMessage(String server, SOAPMessage reqStr) throws MalformedURLException, java.io.IOException, SOAPException
	{
		URL endpoint = new URL( server );
		SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
	    SOAPConnection connection = sfc.createConnection();
	    SOAPMessage response = connection.call(reqStr, endpoint);
		return(response);
	}

}
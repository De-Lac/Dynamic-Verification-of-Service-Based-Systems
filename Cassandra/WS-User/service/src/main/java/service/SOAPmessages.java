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
    private UserPortTypeImpl user_service;
	
	
	public SOAPmessages(UserPortTypeImpl user_service)
	{
	 this.user_service = user_service;
	 try
	  { factory = MessageFactory.newInstance();}
	 catch(SOAPException ex){ex.printStackTrace();}
	}
	
	/**
	 * @param resourceId
	 * id of the resource to request
	 * @param sp_server
	 * url of the Service Provider server
	 * <pre>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header>RequestResource</SOAP-ENV:Header>
    <SOAP-ENV:Body>
        <sp:requestResource xmlns:sp="http://www.unicam.it/cassandra/example/sso/contract/Sp">
            <resourceId>5</resourceId>
        </sp:requestResource>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
     *</pre>
	 */
	public String callRequestResource(int resourceId, String sp_server) throws SOAPException, MalformedURLException, IOException
	{
		SOAPMessage soapMsg = factory.createMessage();
		SOAPPart part = soapMsg.getSOAPPart();

		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader header = envelope.getHeader();
		SOAPBody body = envelope.getBody();

		header.addTextNode("RequestResource");

		SOAPBodyElement element = body.addBodyElement(envelope.createName("requestResource", "sp", "http://www.unicam.it/cassandra/example/sso/contract/Sp"));
		element.addChildElement("resourceId").addTextNode(resourceId+"");

		user_service.INTERNAL_STATE=2;
    	System.out.println("[User["+user_service.INTERNAL_STATE+"]#callRequestResource] "+resourceId);
//		soapMsg.writeTo(System.out);System.out.println();

		// response
		SOAPMessage response = sendMessage(sp_server, soapMsg);
		return parseRequestResourceResponse(response);

	}
	

	
	/**
	 * @param sp_key
	 * key indicating the resource of the serviceProvider
	 * @param idp_server
	 * url of the Identity Provider server
	 * <pre>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:idp="http://www.unicam.it/cassandra/example/sso/contract/Idp">
   <soapenv:Header/>
   <soapenv:Body>
      <idp:authentication>
         <sp_key>?</sp_key>
         <username>?</username>
         <password>?</password>
      </idp:authentication>
   </soapenv:Body>
</soapenv:Envelope>
     *</pre>
	 */
	public String callAuthentication(String sp_key, String idp_server) throws SOAPException, MalformedURLException, IOException
	{
		String username = JOptionPane.showInputDialog(null, "What's your username?");
		String password = JOptionPane.showInputDialog(null, "What's your password?");
		SOAPMessage soapMsg = factory.createMessage();
		SOAPPart part = soapMsg.getSOAPPart();

		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader header = envelope.getHeader();
		SOAPBody body = envelope.getBody();

		header.addTextNode("Authentication");

		SOAPBodyElement element = body.addBodyElement(envelope.createName("authentication", "idp", "http://www.unicam.it/cassandra/example/sso/contract/Idp"));
		element.addChildElement("sp_key").addTextNode(sp_key);
		element.addChildElement("username").addTextNode(username);
		element.addChildElement("password").addTextNode(password);

		user_service.INTERNAL_STATE=4;
    	System.out.println("[User["+user_service.INTERNAL_STATE+"]#callAuth] "+sp_key);
//		soapMsg.writeTo(System.out);System.out.println();

		// response
		SOAPMessage response = sendMessage(idp_server, soapMsg);
		return parseAuthenticationResponse(response);

	}	
	
	
	
	
	/**
	 * @param sp_key
	 * key indicating the resource of the serviceProvider
	 * @param idp_server
	 * url of the Identity Provider server
	 * <pre>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sp="http://www.unicam.it/cassandra/example/sso/contract/Sp">
   <soapenv:Header/>
   <soapenv:Body>
      <sp:identified>
         <resourceId>5</resourceId>
         <token>Bhd5d-001</token>
      </sp:identified>
   </soapenv:Body>
</soapenv:Envelope>
     *</pre>
	 */
	public String callIdentified(int resourceId, String token, String idp_server) throws SOAPException, MalformedURLException, IOException
	{
		SOAPMessage soapMsg = factory.createMessage();
		SOAPPart part = soapMsg.getSOAPPart();

		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader header = envelope.getHeader();
		SOAPBody body = envelope.getBody();

		header.addTextNode("Authentication");

		SOAPBodyElement element = body.addBodyElement(envelope.createName("identified", "sp", "http://www.unicam.it/cassandra/example/sso/contract/Sp"));
		element.addChildElement("resourceId").addTextNode(resourceId+"");
		element.addChildElement("token").addTextNode(token);

		user_service.INTERNAL_STATE=7;
  	    System.out.println("[User["+user_service.INTERNAL_STATE+"]#callIdentified]");
//  	 soapMsg.writeTo(System.out);System.out.println();

		// response
		SOAPMessage response = sendMessage(idp_server, soapMsg);
		return parseIdentifiedResponse(response);

	}		
	
	
	
	/**
	 * 
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:identifiedResponse xmlns:ns2="http://www.unicam.it/cassandra/example/sso/contract/Sp">
         <out>ok</out>
      </ns2:identifiedResponse>
   </soap:Body>
</soap:Envelope>
	 * 
	 */
		private String parseIdentifiedResponse(SOAPMessage response) throws SOAPException, IOException
		{
			SOAPBody sb = response.getSOAPBody();
			QName bodyName = new QName("http://www.unicam.it/cassandra/example/sso/contract/Sp", "identifiedResponse", "ns2");
			java.util.Iterator iterator = sb.getChildElements(bodyName);
			String value="";
			while (iterator.hasNext()) 
			{
				SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
				value += bodyElement.getTextContent();
			}
			System.out.println("[User["+user_service.INTERNAL_STATE+"]] IdentifiedResponse: "+value); 
//			response.writeTo(System.out);System.out.println();
			return value;	
		}
	
	
	
	
	
	
	
/**
 * 
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:authenticationResponse xmlns:ns2="http://www.unicam.it/cassandra/example/sso/contract/Idp">
         <authToken>Bkdk4k33</authToken>
      </ns2:authenticationResponse>
   </soap:Body>
</soap:Envelope>
 * 
 */
	private String parseAuthenticationResponse(SOAPMessage response) throws SOAPException, IOException
	{
		SOAPBody sb = response.getSOAPBody();
		QName bodyName = new QName("http://www.unicam.it/cassandra/example/sso/contract/Idp", "authenticationResponse", "ns2");
		java.util.Iterator iterator = sb.getChildElements(bodyName);
		String value="";
		while (iterator.hasNext()) 
		{
			SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
			value += bodyElement.getTextContent();
		}
		System.out.println("[User["+user_service.INTERNAL_STATE+"]] AuthenticationResponse: "+value); 
//		response.writeTo(System.out);System.out.println();
		return value;	
	}

	
/**
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:requestResourceResponse xmlns:ns2="http://www.unicam.it/cassandra/example/sso/contract/Sp">
         <resourceAvailable>ok</resourceAvailable>
      </ns2:requestResourceResponse>
   </soap:Body>
</soap:Envelope>	 
*/
	private String parseRequestResourceResponse(SOAPMessage response) throws SOAPException, IOException
	{
        SOAPBody sb = response.getSOAPBody();
        QName bodyName = new QName("http://www.unicam.it/cassandra/example/sso/contract/Sp", "requestResourceResponse", "ns2");
        java.util.Iterator iterator = sb.getChildElements(bodyName);
        String value="";
        while (iterator.hasNext()) 
         {
          SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
          value += bodyElement.getTextContent();
         }
        System.out.println("[User["+user_service.INTERNAL_STATE+"]] RequestResourceResponse: "+value); 
//      response.writeTo(System.out);System.out.println();
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
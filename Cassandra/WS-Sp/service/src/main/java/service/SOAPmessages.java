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

import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class SOAPmessages {
	
	private MessageFactory factory;
	private SpPortTypeImpl sp_service;
	
	
	public SOAPmessages(SpPortTypeImpl sp_service)
	{
	 this.sp_service = sp_service;
	 try
	  { factory = MessageFactory.newInstance();}
	 catch(SOAPException ex){ex.printStackTrace();}
	}
	
	
	
	/**
	 * 
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://www.unicam.it/cassandra/example/sso/contract/User">
   <soapenv:Header/>
   <soapenv:Body>
      <user:authReq>
         <key>DFJd7XXdf</key>
      </user:authReq>
   </soapenv:Body>
</soapenv:Envelope>
	 */
	public String callAuthenticationRequest(String key, String server_user) throws SOAPException, MalformedURLException, IOException
	{
		SOAPMessage soapMsg = factory.createMessage();
		SOAPPart part = soapMsg.getSOAPPart();

		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader header = envelope.getHeader();
		SOAPBody body = envelope.getBody();

		header.addTextNode("AuthReq");

		SOAPBodyElement element = body.addBodyElement(envelope.createName("authReq", "user", "http://www.unicam.it/cassandra/example/sso/contract/User"));
		element.addChildElement("key").addTextNode(key);

		sp_service.INTERNAL_STATE=3;
		System.out.println("[Sp["+sp_service.INTERNAL_STATE+"]]#callAuthReq");
//		soapMsg.writeTo(System.out);System.out.println();

		// response
		SOAPMessage response = sendMessage(server_user, soapMsg);
//      System.out.println("[Sp["+sp_service.INTERNAL_STATE+"]] AuthReqResponse:"); response.writeTo(System.out);System.out.println();
		return parseAuthenticationRequestResponse(response);

	}
	
	/**
	 * 
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://www.unicam.it/cassandra/example/sso/contract/User">
   <soapenv:Header/>
   <soapenv:Body>
      <user:releaseResource>
         <link>http://myserver/resource/token</link>
      </user:releaseResource>
   </soapenv:Body>
</soapenv:Envelope>
	 */
	public String callReleaseResource(String link, String server_user) throws SOAPException, MalformedURLException, IOException
	{
		SOAPMessage soapMsg = factory.createMessage();
		SOAPPart part = soapMsg.getSOAPPart();

		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader header = envelope.getHeader();
		SOAPBody body = envelope.getBody();

		header.addTextNode("ReleaseResource");

		SOAPBodyElement element = body.addBodyElement(envelope.createName("releaseResource", "user", "http://www.unicam.it/cassandra/example/sso/contract/User"));
		element.addChildElement("link").addTextNode(link);

		sp_service.INTERNAL_STATE=5;
		System.out.println("[Sp["+sp_service.INTERNAL_STATE+"]#callReleaseResource] ");
//		soapMsg.writeTo(System.out);System.out.println();

		// response
		SOAPMessage response = sendMessage(server_user, soapMsg);
		return parseReleaseResourceResponse(response);
	}	
	

	
	/**
	 * 
	 * 
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:releaseResourceResponse xmlns:ns2="http://www.unicam.it/cassandra/example/sso/contract/User">
         <out>blabla</out>
      </ns2:releaseResourceResponse>
   </soap:Body>
</soap:Envelope>
	 * 
	 */
	private String parseReleaseResourceResponse(SOAPMessage response) throws SOAPException, IOException
	{
        SOAPBody sb = response.getSOAPBody();
        QName bodyName = new QName("http://www.unicam.it/cassandra/example/sso/contract/User", "releaseResourceResponse", "ns2");
        java.util.Iterator iterator = sb.getChildElements(bodyName);
        String value="";
        while (iterator.hasNext()) 
         {
          SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
          value += bodyElement.getTextContent();
         }
        System.out.println("[Sp["+sp_service.INTERNAL_STATE+"]] ReleaseResourceResponse: "+value); 
//      response.writeTo(System.out);System.out.println();
		return value;	
	}	
	
	
	
	
	/**
	 * 
	 * 
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:authReqResponse xmlns:ns2="http://www.unicam.it/cassandra/example/sso/contract/User">
         <out>miao</out>
      </ns2:authReqResponse>
   </soap:Body>
</soap:Envelope>
	 * 
	 */
	private String parseAuthenticationRequestResponse(SOAPMessage response) throws SOAPException, IOException
	{
        SOAPBody sb = response.getSOAPBody();
        QName bodyName = new QName("http://www.unicam.it/cassandra/example/sso/contract/User", "authReqResponse", "ns2");
        java.util.Iterator iterator = sb.getChildElements(bodyName);
        String value="";
        while (iterator.hasNext()) 
         {
          SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
          value += bodyElement.getTextContent();
         }
        System.out.println("[Sp["+sp_service.INTERNAL_STATE+"]] AuthenticationRequestResponse: "+value); 
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
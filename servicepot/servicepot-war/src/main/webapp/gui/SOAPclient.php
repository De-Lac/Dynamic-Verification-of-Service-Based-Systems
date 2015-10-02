<?php 
        //Data, connection, auth
        $choreographyURI = $_POST['choreographyURI']; // request data from the form
        $soapUrl = "http://localhost:8080/ServicePot/servicepot/services/choreos-publish"; // asmx URL of WSDL


        // xml post structure
        
        $xml_post_string ='<?xml version="1.0" encoding="utf-8"?>
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:chor="http://www.choreos.eu">
        	<soapenv:Header/>
        	<soapenv:Body>
        		<chor:SaveChoreography>
        		<arg0>
        			<authInfo>authtoken:a2a73ecf-52b8-4a7b-8236-82b91daa8e92</authInfo>
        			<choreographyURI>'.$choreographyURI.'</choreographyURI>
        		</arg0>
        		</chor:SaveChoreography>
        	</soapenv:Body>
        </soapenv:Envelope>';
        

        $headers = array(
                        "Content-type: text/xml;charset=\"utf-8\"",
                        "Accept: text/xml",
                        "Cache-Control: no-cache",
                        "Pragma: no-cache",
                        "SOAPAction: http://www.choreos.eu/SaveChoreography", 
                        "Content-length: ".strlen($xml_post_string),
                    ); //SOAPAction: your op URL


$soap_do = curl_init();
  curl_setopt($soap_do, CURLOPT_URL, $soapUrl );
  curl_setopt($soap_do, CURLOPT_CONNECTTIMEOUT, 10);
  curl_setopt($soap_do, CURLOPT_TIMEOUT,        10);
  curl_setopt($soap_do, CURLOPT_RETURNTRANSFER, true );
  curl_setopt($soap_do, CURLOPT_SSL_VERIFYPEER, false);
  curl_setopt($soap_do, CURLOPT_SSL_VERIFYHOST, false);
  curl_setopt($soap_do, CURLOPT_POST,           true );
  curl_setopt($soap_do, CURLOPT_POSTFIELDS,     $xml_post_string);
  curl_setopt($soap_do, CURLOPT_HTTPHEADER,     $headers);
 
  if(curl_exec($soap_do) === false) {
    $err = 'Curl error: ' . curl_error($soap_do);
    curl_close($soap_do);
    print $err;
  } else {
    curl_close($soap_do);
    print 'Operation completed without any errors';
  }









?>
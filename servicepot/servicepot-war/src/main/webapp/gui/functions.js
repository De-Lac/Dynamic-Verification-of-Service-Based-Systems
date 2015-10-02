var tmodelkeys;
var partes_message_popup=false;

function write_response(resp)
{
	document.getElementById('console').innerHTML = resp;
	enable_buttons();
}

function enable_buttons()
{
	document.body.style.cursor = 'default';
	document.getElementById('save_choreography').disabled = false;
	document.getElementById('save_service').disabled = false;
	document.getElementById('find_choreography').disabled = false;
	document.getElementById('find_service').disabled = false;	
}

function disable_buttons()
{
	document.body.style.cursor = 'wait';
	document.getElementById('save_choreography').disabled = true;
	document.getElementById('save_service').disabled = true;
	document.getElementById('find_choreography').disabled = true;
	document.getElementById('find_service').disabled = true;	
}


function save_choreography(url)
{ // https://dl.dropboxusercontent.com/u/13520648/passenger_friendly_airport.bpmn
	hidePopup('popup_save_chor');
	disable_buttons();
	document.getElementById('console').innerHTML="...waiting for the response...";
	var xmlhttp = new XMLHttpRequest();            
    xmlhttp.open("POST", "http://sputnik.cs.unicam.it:8080/ServicePot/servicepot/services/choreos-publish", true);
    xmlhttp.setRequestHeader("SOAPAction", "http://tempuri.org/ICourses/GetCountries");
    
    if (document.getElementById("partes").checked==true)
    	{// add the -p option to start partes
    	 url = "-p "+url;
    	// partes_message_popup = true;
    	} 
    
    // build SOAP request
    var sr ='<?xml version="1.0" encoding="utf-8"?> \n' +
        '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:chor="http://www.choreos.eu">\n'+
        '	<soapenv:Header/>\n'+
        '	<soapenv:Body>\n'+
        '		<chor:SaveChoreography>\n'+
        '		<arg0>\n'+
        '			<authInfo>authtoken:a2a73ecf-52b8-4a7b-8236-82b91daa8e92</authInfo>\n'+
        '			<choreographyURI>'+url+'</choreographyURI>\n'+
        '		</arg0>\n'+
        '		</chor:SaveChoreography>\n'+
        '	</soapenv:Body>\n'+
        '</soapenv:Envelope>\n';

    xmlhttp.onerror = function(e) 
    	{ write_response("<span style='color:red'>Error ocurred. Error = " + e.message+"</span>");}

    xmlhttp.ontimeout = function(e) 
    	{ write_response("Timeout error!"); }

    xmlhttp.onreadystatechange = function () 
       {  
        if (xmlhttp.readyState  == 4) 
        	{
             if (xmlhttp.status == 200 || xmlhttp.status == 0) 
             	{
            	 tModelKey = (xmlhttp.response.match(/tModelKey\=\"(.*?)\"/))[1];
            	 resp = stylizeXML(xmlhttp.response);
            	 write_response('<span style="color:green;">OK! choreography saved</span><br><div class="code">'+resp+'</div>');
            	 if (partes_message_popup)
            		 {
            		  disable_buttons(); // I have to wait partes termination,
            		  partes_message_popup = setInterval(function(){show_partes_message(tModelKey)},5000);
            		  alert("you should wait ParTes termination. It could take a while..");
            		 }
                }
             else
             	{
            	 write_response('<span style="color:red;">status:'+xmlhttp.response+'</span><br><span style="text-align:left;"><div class="code">'+xmlhttp.response+'</div></span>');
             	}
            }   
      } 

    xmlhttp.setRequestHeader("Content-Length", sr.length);
    xmlhttp.setRequestHeader("Content-Type", "text/xml; charset=utf-8");

    xmlhttp.send(sr);  	
}




function find_choreography(chorName)
{
	document.getElementById("choose_chor").disabled=true;
	document.getElementById("roles_choreography").disabled=true;
	document.getElementById("details_choreography").disabled=true;
	document.getElementById("testsuite_choreography").disabled=true;
	tmodelkeys=null;
	disable_buttons();
	document.getElementById("choose_chor").innerHTML="<option>waiting...</option>";
	var xmlhttp = new XMLHttpRequest();            
    xmlhttp.open("POST", "http://sputnik.cs.unicam.it:8080/ServicePot/servicepot/services/choreos-inquiry", true);
    xmlhttp.setRequestHeader("SOAPAction", "http://tempuri.org/ICourses/GetCountries");
    // build SOAP request
    var sr ='<?xml version="1.0" encoding="utf-8"?> \n' +
    '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:chor="http://www.choreos.eu" xmlns:urn="urn:uddi-org:api_v3">'+
    '<soapenv:Header/>'+
    '<soapenv:Body>'+
    '   <chor:FindChoreographies>'+
    '      <arg0>'+
    '         <urn:authInfo>?</urn:authInfo>';
             if (chorName != "")
            	 {
            	  sr +='<urn:findQualifiers>'+
                       '<urn:findQualifier>?</urn:findQualifier>'+
                       '</urn:findQualifiers>'+
                       '<urn:name>chorName</urn:name>';
                 }
    sr += ' </arg0>'+
    '   </chor:FindChoreographies>'+
    '</soapenv:Body>'+
    '</soapenv:Envelope>';
    xmlhttp.onerror = function(e) 
    	{ 
    	  hidePopup('popup_find_chor');
    	  write_response("<span style='color:red'>Error ocurred. Error = " + e.message+"</span>");
    	}

    xmlhttp.ontimeout = function(e) 
    	{ 
    	  hidePopup('popup_find_chor');
    	  write_response("Timeout error!"); 
    	}

    xmlhttp.onreadystatechange = function () 
       {  
        if (xmlhttp.readyState  == 4) 
        	{
             if (xmlhttp.status == 200 || xmlhttp.status == 0) 
             {
            	 resp = xmlhttp.response;
            	 names = resp.match(/<(ns\d:)?name>(.*?)<\/(ns\d:)?name>/gi);
            	 tmodelkeys = resp.match(/tModelKey=\"(.*?)\">/gi);
            	 document.getElementById("choose_chor").innerHTML="" //remove 'waiting...'
            	 for (var i=0; i<names.length; i++)
            	   {
            		 // load choreographies names
            		 names[i]=names[i].replace("<ns2:name>","");
            		 names[i]=names[i].replace("</ns2:name>","");
            		 document.getElementById("choose_chor").innerHTML += "<option>"+names[i]+"</option>"
            		 // and relative tModelKey
            		 tmodelkeys[i]=tmodelkeys[i].replace("tModelKey=\"","");
            		 tmodelkeys[i]=tmodelkeys[i].replace("\">","");
            	   }
            	 document.getElementById("choose_chor").disabled=false;
            	 document.getElementById("roles_choreography").disabled=false;
            	 document.getElementById("details_choreography").disabled=false;
            	 document.getElementById("testsuite_choreography").disabled=false;
            	 
            	 write_response('<span style="color:green;">OK! choreographies found</span><br>');
             }
             else
             	{
            	 hidePopup('popup_find_chor');
            	 write_response('<span style="color:red;">status:'+xmlhttp.response+'</span><br><div class="code">'+xmlhttp.response+'</div>');
             	}
            }   
      } 

    xmlhttp.setRequestHeader("Content-Length", sr.length);
    xmlhttp.setRequestHeader("Content-Type", "text/xml; charset=utf-8");

    xmlhttp.send(sr);  	
}



function details_choreography(tModelKeyIndex)
{
	disable_buttons();
	hidePopup('popup_find_chor');
	tmodelKey = tmodelkeys[tModelKeyIndex];
	document.getElementById('console').innerHTML += "<br>...waiting for the choreography "+tmodelKey+" details...<br>";
	var xmlhttp = new XMLHttpRequest();            
    xmlhttp.open("POST", "http://sputnik.cs.unicam.it:8080/ServicePot/servicepot/services/choreos-inquiry", true);
    xmlhttp.setRequestHeader("SOAPAction", "http://tempuri.org/ICourses/GetCountries");
    // build SOAP request
    var sr ='<?xml version="1.0" encoding="utf-8"?> \n' +
    		'<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:chor="http://www.choreos.eu" xmlns:urn="urn:uddi-org:api_v3">'+
			' <soapenv:Header/>'+
    		' <soapenv:Body>'+
			'	<chor:GetChoreographyDetails>'+
          	'		<arg0>'+
          	'			<authInfo>authtoken:a2a73ecf-52b8-4a7b-8236-82b91daa8e92</authInfo>\n'+
            '			<urn:tModelKey>'+tmodelKey+'</urn:tModelKey>'+
          	'		</arg0>'+
       		'	</chor:GetChoreographyDetails>'+
    		' </soapenv:Body>'+
    		'</soapenv:Envelope>';
    xmlhttp.onerror = function(e) 
    	{ 
    	  hidePopup('popup_find_chor');
    	  write_response("<span style='color:red'>Error ocurred. Error = " + e.message+"</span>");
    	}

    xmlhttp.ontimeout = function(e) 
    	{ 
    	  hidePopup('popup_find_chor');
    	  write_response("Timeout error!"); 
    	}

    xmlhttp.onreadystatechange = function () 
       {  
        if (xmlhttp.readyState  == 4) 
        	{
             if (xmlhttp.status == 200 || xmlhttp.status == 0) 
             {
            	 resp = stylizeXML(xmlhttp.response);
            	 write_response('<span style="color:green;">OK! details found of '+tmodelKey+'</span><br><div class="code">'+resp+'</div>');
             }
             else
             	{
            	 hidePopup('popup_find_chor');
            	 write_response('<span style="color:red;">status:'+xmlhttp.response+'</span><br><div class="code">'+xmlhttp.response+'</div>');
             	}
            }   
      } 

    xmlhttp.setRequestHeader("Content-Length", sr.length);
    xmlhttp.setRequestHeader("Content-Type", "text/xml; charset=utf-8");

    xmlhttp.send(sr);  	
}


function testSuite_choreography(tModelKeyIndex)
{  
	disable_buttons();
	hidePopup('popup_find_chor');
	tmodelKey = tmodelkeys[tModelKeyIndex];
	document.getElementById('console').innerHTML += "<br>...waiting for the choreography "+tmodelKey+" Test Suite...<br>";
	var xmlhttp_testSuiteReq = new XMLHttpRequest();       
	xmlhttp_testSuiteReq.open("POST", "http://sputnik.cs.unicam.it:8080/PartesWsTestGenerator/services/PartesWsTestGenerator.PartesWsTestGeneratorHttpSoap11Endpoint/", true);
	xmlhttp_testSuiteReq.setRequestHeader("SOAPAction", "http://sputnik.cs.unicam.it:8080/PartesWsTestGenerator/services/PartesWsTestGenerator.PartesWsTestGeneratorHttpSoap11Endpoint/");
    // build SOAP request
    var sr ='<?xml version="1.0" encoding="utf-8"?> \n' + 
    		'<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.partes">'+
    		'	<soapenv:Header/>'+
    		'	<soapenv:Body>'+
    		'       <ser:getTestSuite>'+
            '           <ser:choreographyTModelKey>'+tmodelKey+'</ser:choreographyTModelKey>'+
            '       </ser:getTestSuite>'+
    		'	</soapenv:Body>'+
    		'</soapenv:Envelope>';
    xmlhttp_testSuiteReq.onerror = function(e) 
    	{ 
    	  write_response("<span style='color:red'>Error ocurred. Error = " + e.message+"</span>");
    	}

    xmlhttp_testSuiteReq.ontimeout = function(e) 
    	{ 
    	  write_response("Timeout error!"); 
    	}

    xmlhttp_testSuiteReq.onreadystatechange = function () 
       {  
        if (xmlhttp_testSuiteReq.readyState  == 4) 
        	{
             if (xmlhttp_testSuiteReq.status == 200 || xmlhttp_testSuiteReq.status == 0) 
             {
            	 resp = /*stylizeXML*/(xmlhttp_testSuiteReq.response);
            	 write_response('<span style="color:green;">OK! TestSuite found for '+tmodelKey+'</span><br><div class="code">'+resp+'</div>');
             }
             else
             	{
            	 write_response('<span style="color:red;">status:'+xmlhttp_testSuiteReq.response+'</span><br><div class="code">'+xmlhttp_testSuiteReq.response+'</div>');
             	}
            }   
      } 

    xmlhttp_testSuiteReq.setRequestHeader("Content-Length", sr.length);
    xmlhttp_testSuiteReq.setRequestHeader("Content-Type", "text/xml; charset=utf-8");

    xmlhttp_testSuiteReq.send(sr); 
}

function roles_choreography(tModelKeyIndex)
{
	disable_buttons();
	hidePopup('popup_find_chor');
	tmodelKey = tmodelkeys[tModelKeyIndex];
	document.getElementById('console').innerHTML += "<br>...waiting for the choreography "+tmodelKey+" details...<br>";
	var xmlhttp = new XMLHttpRequest();            
    xmlhttp.open("POST", "http://sputnik.cs.unicam.it:8080/ServicePot/servicepot/services/choreos-inquiry", true);
    xmlhttp.setRequestHeader("SOAPAction", "http://tempuri.org/ICourses/GetCountries");
    // build SOAP request
    var sr ='<?xml version="1.0" encoding="utf-8"?> \n' +
    		'<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:chor="http://www.choreos.eu" xmlns:urn="urn:uddi-org:api_v3">'+
    		'	<soapenv:Header/>'+
    		'	<soapenv:Body>'+
    		'		<chor:GetRolesInChoreography>'+
            '			<arg0>'+
            '			<authInfo>authtoken:a2a73ecf-52b8-4a7b-8236-82b91daa8e92</authInfo>\n'+
            ' 				<urn:tModelKey>'+tmodelKey+'</urn:tModelKey>'+
    		'			</arg0>'+
    		'		</chor:GetRolesInChoreography>'+
    		'	</soapenv:Body>'+
    		'</soapenv:Envelope>';
    xmlhttp.onerror = function(e) 
    	{ 
    	  hidePopup('popup_find_chor');
    	  write_response("<span style='color:red'>Error ocurred. Error = " + e.message+"</span>");
    	}

    xmlhttp.ontimeout = function(e) 
    	{ 
    	  hidePopup('popup_find_chor');
    	  write_response("Timeout error!"); 
    	}

    xmlhttp.onreadystatechange = function () 
       {  
        if (xmlhttp.readyState  == 4) 
        	{
             if (xmlhttp.status == 200 || xmlhttp.status == 0) 
             {
            	 resp = stylizeXML(xmlhttp.response);
            	 write_response('<span style="color:green;">OK! roles found of '+tmodelKey+'</span><br><div class="code">'+resp+'</div>');
             }
             else
             	{
            	 hidePopup('popup_find_chor');
            	 write_response('<span style="color:red;">status:'+xmlhttp.response+'</span><br><div class="code">'+xmlhttp.response+'</div>');
             	}
            }   
      } 

    xmlhttp.setRequestHeader("Content-Length", sr.length);
    xmlhttp.setRequestHeader("Content-Type", "text/xml; charset=utf-8");

    xmlhttp.send(sr);  	
}







function show_popup(popupName)
{
 document.getElementById(popupName).className='popup notHidden';
 document.getElementById('fade').className='notHidden';
 window.scroll(0,0); 
}

function hidePopup(popupName)
{
 document.getElementById(popupName).className="popup hidden";
 document.getElementById('fade').className="hidden";
}


function show_partes_message(tmodelKey)
{
	// request test suite. If it's generated, shows the message. repeat the request otherwise
	clearInterval(partes_message_popup); 
	partes_message_popup=false;
	// ==== send the request====
	var xmlhttp_testSuiteReq2 = new XMLHttpRequest();       
	xmlhttp_testSuiteReq2.open("POST", "http://sputnik.cs.unicam.it:8080/PartesWsTestGenerator/services/PartesWsTestGenerator.PartesWsTestGeneratorHttpSoap11Endpoint/", true);
	xmlhttp_testSuiteReq2.setRequestHeader("SOAPAction", "http://sputnik.cs.unicam.it:8080/PartesWsTestGenerator/services/PartesWsTestGenerator.PartesWsTestGeneratorHttpSoap11Endpoint/");
    // build SOAP request
    var sr ='<?xml version="1.0" encoding="utf-8"?> \n' + 
    		'<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.partes">'+
    		'	<soapenv:Header/>'+
    		'	<soapenv:Body>'+
    		'       <ser:getTestSuite>'+
            '           <ser:choreographyTModelKey>'+tmodelKey+'</ser:choreographyTModelKey>'+
            '       </ser:getTestSuite>'+
    		'	</soapenv:Body>'+
    		'</soapenv:Envelope>';
    xmlhttp_testSuiteReq2.onerror = function(e) 
    	{ 
    	 //not yet generated. try again after 5 seconds
    	 partes_message_popup = setInterval(function(){show_partes_message(tModelKey)},5000);
    	}

    xmlhttp_testSuiteReq2.ontimeout = function(e) 
	    { 
	    	popup=document.getElementById("partes_popup");
	    	popup.className='popup notHidden';
	    	popup.innerHTML += "<b>ParTes</b>TestSuite generation for "+tmodelKey+" timed out error";
	    	enable_buttons();
	    }

    xmlhttp_testSuiteReq2.onreadystatechange = function () 
       {  
        if (xmlhttp_testSuiteReq2.readyState  == 4) 
        	{
             if (xmlhttp_testSuiteReq2.status == 200 || xmlhttp_testSuiteReq2.status == 0) 
             { // TestSuite ready! shows the popup
            	 popup=document.getElementById("partes_popup");
            	 popup.className='popup notHidden';
            	 popup.innerHTML += "<b>ParTes</b> has terminated TestSuite generation for "+tmodelKey;
            	 enable_buttons();
             }
             else
             	{
            	 popup=document.getElementById("partes_popup");
            	 popup.className='popup notHidden';
            	 popup.innerHTML += "<b>ParTes</b>TestSuite generation for "+tmodelKey+" has encountered problems.";
            	 popup.innerHTML += "<br> status: "+xmlhttp_testSuiteReq2.status;
            	 popup.innerHTML += "res: "+xmlhttp_testSuiteReq2.response;
            	 enable_buttons();
             	}
            }   
      } 

    xmlhttp_testSuiteReq2.setRequestHeader("Content-Length", sr.length);
    xmlhttp_testSuiteReq2.setRequestHeader("Content-Type", "text/xml; charset=utf-8");

    xmlhttp_testSuiteReq2.send(sr); 
}

function hide_partes_message()
{
	popup=document.getElementById("partes_popup");
	popup.className='popup hidden';
	popup.innerHTML = "";
	clearInterval(partes_message_popup);
}

/**
 * <pre>
 * tag = orange
 * tag name = blue
 * tag content = black
 * attribute value = red
 * attribute name = green
 * </pre>
 * @param xml
 *            xml file to stylize
 * @returns
 *         the html code of the stylized xml
 */
function stylizeXML(xml)
{
	xml = xml.replace(/>/g,"&gt");
	xml = xml.replace(/</g,"&lt");
	
	//========== indentation ==========
	
//	blocks = xml.match(/\&lt[\/]?[^(\&gt)]+\&gt/g);
//	space= "&nbsp;&nbsp;";
//	while (blocks.length > 0)
//		{ // </..>  or  <..>
//		 alert(blocks[0]);
//		 if (blocks[0].match(/\&lt[^\/(\&gt)]+\&gt\//))
//		   { // <..>
//			 alert("</   >");
//			 xml.replace(blocks[0], "</br>"+space+blocks[0]);
//			 space += "&nbsp;&nbsp;";
//		   }
//		 if (blocks[0].match(/\&lt\/[^(\&gt)]+\&gt\//))
//		   { // <..>
//			 alert("<   >");
//			 space.replace("&nbsp;&nbsp;","");
//			 xml.replace(blocks[0], "</br>"+space+blocks[0]);
//		   }
//		 alert(blocks[0]);
//		 blocks = xml.match(/[^\&nbsp\;]\&lt[\/]?[^(\&gt)]+\&gt/g);
//		}
	
	xml = xml.replace(/\&gt\&lt/g, "&gt <br> &lt");  //  ><   becomes   > <br> <
	
	
	//========== green tag (attributes name) ==========
	var greens=xml.match(/<(\S+\s+)+[\S]+\=\"[^>]+>/g); //  ...=
	if (greens != null)
	   {
		for (i=0; i<greens.length; i++)
		{
			greens=xml.match(/\s+\S+\=\"/g);
			for (i=0; i<greens.length; i++)
			{
				green = greens[i];
				green = green.replace(/\=\"/g, '=</span>"');
				attributes = green.match(/\s+\S+\=<\/span>\"/g);
				for(j=0; j<attributes.length; j++)
				{
					attribute2 = "<span class='color_green'>"+attributes[j];
					green = green.replace(attributes[j], attribute2);
				}
				xml = xml.replace(greens[i],  green);
			}

		}
	   }
	
	//========== blue tag (tag names) ==========
	var blues=xml.match(/\&lt(.*?)\&gt/g); // < ... >
	for (i=0; i<blues.length; i++)
		{
		 blue = blues[i];
		 blue = blue.replace("&lt/","");
		 blue = blue.replace("&lt","");
		 blue = blue.replace("&gt","");
		 if (blues[i].match(/^\&lt\//))
			 //   </ ... >
			 {xml = xml.replace(blues[i],      "<span class='color_orange'>&lt/</span><span class='color_blue'>"+blue+"</span><span class='color_orange'>&gt</span>");} // </
		 else
			 //   < ... >
		 	 {xml = xml.replace(blues[i],      "<span class='color_orange'>&lt</span><span class='color_blue'>"+blue+"</span><span class='color_orange'>&gt</span>");}  
		 
		}
	
	
	//========== red tag (attributes value) ==========
	var reds=xml.match(/\=<\/span>(\s*)\"(.*?)\"/g); //  ="..."
	for (i=0; i<reds.length; i++)
		{
		 red = reds[i];
		 red = red.replace("=</span>","");
		 xml = xml.replace(reds[i], "=</span><span class='color_red'>"+red+"</span>");
		}
	
	
	return xml;
	
}









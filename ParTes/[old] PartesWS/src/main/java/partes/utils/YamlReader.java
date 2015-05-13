package partes.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.Yaml;

import partes.refactorRunner.PartesInfo;
import partes.service.Partes;

public class YamlReader 

{

	private static Log log = LogFactory.getLog(Partes.class);
	
	public static Vector<PartesInfo> getPartesParticipantInformation(File yamlFile) throws FileNotFoundException
	{
		LinkedHashMap readedInfo = (LinkedHashMap) new Yaml().load(new FileReader(yamlFile));
		return getPartesParticipantInformation(readedInfo);
	}


	
	/**
	 * Gets the partes participant information.
	 * 
	 * @param filename
	 *            the filename
	 * @return the partes participant information
	 * @throws FileNotFoundException 
	 */
	public static Vector<PartesInfo> getPartesParticipantInformation(String yamlFile) throws FileNotFoundException 
	{
		LinkedHashMap readedInfo = (LinkedHashMap) new Yaml().load(new FileReader(yamlFile));
		return getPartesParticipantInformation(readedInfo);
	}
	
	
	
	
	
	
	private static Vector<PartesInfo> getPartesParticipantInformation(LinkedHashMap readedInfo)
	{
		Vector<PartesInfo> pi = new Vector<PartesInfo>();

		log.info("looking for participant information");

		ArrayList<LinkedHashMap> listInfo = (ArrayList) readedInfo.values().toArray()[0];

		for (LinkedHashMap p : listInfo) 
		{
			String portype = p.get("portTypeToSearch").toString();
			String wsdl = p.get("wsdlLocation").toString();
			String service = p.get("modelImplClass").toString();
			pi.add(new PartesInfo(portype, wsdl, service));
		}
		return pi;
	}



	
}

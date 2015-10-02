/**
 *
 * Copyright (C) 2012 Midhat Ali, Andrea Polini, Guglielmo De Angelis
 *
 * This file is part of ServicePot ver 0.1 .
 *
 * ServicePot is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with ServicePot. If not, see <http:www.gnu.org/licenses/>.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unicam.choreos.registry.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.wsdl.PortType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import org.ow2.choreos.bpmn2.*;
import org.ow2.choreos.registry.messages.SaveChoreographyIn;
import org.uddi.api_v3.*;
import org.xmlsoap.schemas.wsdl.TDocumented;
import org.xmlsoap.schemas.wsdl.TPortType;

/**
 *
 * @author midhat
 */
public class ChoreographyRegistryWorker {

    public static Map<TModel, List<TModel>> getUDDIChoreographiesFromBPMN(SaveChoreographyIn input) throws MalformedURLException, IOException, JAXBException {

        Map<TModel, List<TModel>> outputMap = new HashMap<TModel, List<TModel>>();
        Map<String, String> interfaces = new HashMap<String, String>();
        Map<String, String> portTypes = new HashMap<String, String>();
        Map<String, String> wsdlImports = new HashMap<String, String>();
        try {
            URL choreographyURL = new URL(input.getChoreographyURI());

            JAXBContext jc = JAXBContext.newInstance(TDefinitions.class);
            JAXBElement<TDefinitions> bpmnRoot = (JAXBElement<TDefinitions>) jc.createUnmarshaller().unmarshal(
                    choreographyURL);
            for (TImport importt : bpmnRoot.getValue().getImport()) {
                if (CHOReOSMetadataConstants.WSDL_BPMN2_IMPORT_TYPE.equals(importt.getImportType())) {
                    String wsdlLocation = importt.getLocation();
                    JAXBContext wsdljc = JAXBContext.newInstance(
                            org.xmlsoap.schemas.wsdl.TDefinitions.class
                            );
                    JAXBElement<org.xmlsoap.schemas.wsdl.TDefinitions> wsdlRoot =
                            (JAXBElement<org.xmlsoap.schemas.wsdl.TDefinitions>) 
                            wsdljc.createUnmarshaller().unmarshal(new URL(wsdlLocation));

                    List<TDocumented> wsdlElements = wsdlRoot.getValue().getAnyTopLevelOptionalElement();
                    for (TDocumented wsdlElement : wsdlElements) {
                        if (wsdlElement instanceof TPortType) {
                            TPortType portType = (TPortType) wsdlElement;
                            wsdlImports.put(wsdlRoot.getValue().getTargetNamespace()+":"+portType.getName(), wsdlLocation);
                        }


                    }


                    //wsdlImports.put(importt.getNamespace(), importt.getLocation());

                }
            }


            List<JAXBElement<? extends TRootElement>> elements = bpmnRoot.getValue().getRootElement();




            for (JAXBElement<? extends TRootElement> element : elements) {
                if (element.getDeclaredType().equals(TInterface.class)) {
                    TInterface interrface = (TInterface) element.getValue();
                    portTypes.put(interrface.getId(), interrface.getName());
                    if (interrface.getImplementationRef() != null)
                    	{
                    	 interfaces.put(interrface.getId(), wsdlImports.get(interrface.getImplementationRef().getNamespaceURI()+":"+interrface.getImplementationRef().getLocalPart()));
                    	}
                    else
                    	{
                    	 System.out.println("Warning: impossible to retrieve wsdl getImplementationRef for "+interrface.getName()+",looking for role name match, without considering namespace");
                    	 boolean wsdlLocationFound = false;
                    	 for(String wKey : wsdlImports.keySet())
        					 	{ // example of key =  http://scn2.wp6.thalesgroup.choreos.ow2.org/:ISecurityCompany
        						 if (wKey.endsWith(":"+interrface.getName()))
        						 	{
        							 interfaces.put(interrface.getId(), wsdlImports.get(wKey));
        							 System.out.println("found "+wsdlImports.get(wKey)+"\n");
        							 wsdlLocationFound=true;
        							 break;
        						 	}
        					 	}
                    	 if (!wsdlLocationFound)
                    	 	{
                    		 System.out.println("name match not found\n");
                    		 interfaces.put(interrface.getId(), "");
                    	 	}
                    	}
                }

            }

            for (JAXBElement<? extends TRootElement> element : elements) {
                if (element.getDeclaredType().equals(TChoreography.class)) {
                    TChoreography choreography = (TChoreography) element.getValue();
                    if (input.getChoreographyName() != null
                            && !input.getChoreographyName().isEmpty()
                            && choreography.getName() != null
                            && !choreography.getName().equals(input.getChoreographyName())) {
                        continue;
                    }
                    TModel choreographyTModel = createChoreographyTModel(input, choreography);
                    List<TModel> rolesList = createRoleTModels(choreography, interfaces, portTypes);
                    outputMap.put(choreographyTModel, rolesList);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputMap;

    }

    private static TModel createChoreographyTModel(SaveChoreographyIn userInput, TChoreography choreographyObj) {
        TModel choreographyTModel = new TModel();

        choreographyTModel.setTModelKey(
                String.format(
                CHOReOSMetadataConstants.CHOREOS_CHOREOGRAPHIES_TMODEL_KEY_PATTERN,
                choreographyObj.getName()));

        Name choreographyName = new Name();
        choreographyName.setValue(choreographyObj.getName());
        if (choreographyName.getValue() == null || choreographyName.getValue().trim().equals("")) {
            choreographyName.setValue(choreographyObj.getId());
        }
        choreographyTModel.setName(choreographyName);

        OverviewURL overviewURL = new OverviewURL();
        overviewURL.setUseType(CHOReOSMetadataConstants.CHOREOGRAPHY_OVERVIEWURL_USETYPE);
        overviewURL.setValue(userInput.getChoreographyURI());

        OverviewDoc overviewDoc = new OverviewDoc();
        overviewDoc.setOverviewURL(overviewURL);

        choreographyTModel.getOverviewDoc().add(overviewDoc);

        CategoryBag categoryBag = new CategoryBag();
        KeyedReference kr = new KeyedReference();
        kr.setKeyValue("choreography");
        kr.setTModelKey(CHOReOSMetadataConstants.CHOREOS_TYPES_TMODEL_KEY);
        categoryBag.getKeyedReference().add(kr);
        choreographyTModel.setCategoryBag(categoryBag);

        return choreographyTModel;

    }

    private static List<TModel> createRoleTModels(TChoreography choreographyObj, Map<String, String> interfaces, Map<String, String> portTypes) {
        List<TParticipant> allRoles = choreographyObj.getParticipant();
        List<TModel> roleTModels = new ArrayList<TModel>();
        for (TParticipant role : allRoles) {
            TModel roleTModel = new TModel();

            roleTModel.setTModelKey(
                    String.format(
                    CHOReOSMetadataConstants.CHOREOS_ROLES_TMODEL_KEY_PATTERN,
                    role.getName()));


            Name roleName = new Name();
            roleName.setValue(role.getName());
            roleTModel.setName(roleName);

            KeyedReference rolesCategory = new KeyedReference();
            rolesCategory.setKeyValue("role");
            rolesCategory.setTModelKey(CHOReOSMetadataConstants.CHOREOS_TYPES_TMODEL_KEY);

            KeyedReference roleChoreography = new KeyedReference();
            roleChoreography.setKeyValue(
                    String.format(
                    CHOReOSMetadataConstants.CHOREOS_CHOREOGRAPHIES_TMODEL_KEY_PATTERN,
                    choreographyObj.getName()));
            roleChoreography.setTModelKey(CHOReOSMetadataConstants.CHOREOS_ROLE_CHOREOGRAPHY_TMODEL_KEY);


            CategoryBag categoryBag = new CategoryBag();
            categoryBag.getKeyedReference().add(rolesCategory);
            categoryBag.getKeyedReference().add(roleChoreography);
            roleTModel.setCategoryBag(categoryBag);
            
            /**       NEW PIECE OF CODE TO LOAD WSDL LOCATIONS         */
//            if (interfaces.get(role.getName()) != null) 
//            	{
//                    String interfaceImplRef = interfaces.get(role.getId());
//                    System.out.println("interfaceImplRef "+interfaceImplRef+ "  roleid: "+role.getId());
//                    OverviewURL overviewURL = new OverviewURL();
//                    overviewURL.setUseType(CHOReOSMetadataConstants.WSDL_INTERFACE_OVERVIEWURL_USETYPE);
//                    overviewURL.setValue(interfaceImplRef);
//                    OverviewDoc overviewDoc = new OverviewDoc();
//                    overviewDoc.setOverviewURL(overviewURL);
//                    roleTModel.getOverviewDoc().add(overviewDoc);
//            	}
            
            
            /** THIS PART DOESN'T WORK BECAUSE JAXB DOESN'T FIND THE "interfaceImplRef" TAG   
            IF THIS PROBLEM IS FIXED, WE CAN USE THIS PIECE OF CODE INSTEAD */
            if (role.getInterfaceRef() != null && role.getInterfaceRef().size() > 0) 
               {
                for (QName name : role.getInterfaceRef()) 
                {
                    String interfaceImplRef = interfaces.get(name.getLocalPart());
                    if (interfaceImplRef == null || "".equals(interfaceImplRef)) 
                    {
                        continue;
                    }
                    // add the wsdl location as overviewDoc
                    OverviewURL overviewURL = new OverviewURL();
                    overviewURL.setUseType(CHOReOSMetadataConstants.WSDL_INTERFACE_OVERVIEWURL_USETYPE);
                    overviewURL.setValue(interfaceImplRef);
                    System.out.println("interfaceImplRef "+interfaceImplRef);
                    OverviewDoc overviewDoc = new OverviewDoc();
                    overviewDoc.setOverviewURL(overviewURL);
                    roleTModel.getOverviewDoc().add(overviewDoc);
                    
                    // add the portType as description
                    Description desc = new Description();
                    desc.setValue(portTypes.get(name.getLocalPart()));
                    roleTModel.getDescription().add(desc);

                }
              }

            roleTModels.add(roleTModel);
        }

        return roleTModels;
    }

    public static FindTModel prepareFindRolesRequest(List<String> choreographyTModelKeys) {

        FindTModel findRoles = new FindTModel();

        CategoryBag rolesCategoryBag = new CategoryBag();

        KeyedReference rolesCategoryKeyRef = new KeyedReference();
        rolesCategoryKeyRef.setTModelKey(CHOReOSMetadataConstants.CHOREOS_TYPES_TMODEL_KEY);
        rolesCategoryKeyRef.setKeyValue("role");
        rolesCategoryBag.getKeyedReference().add(rolesCategoryKeyRef);

        findRoles.setCategoryBag(rolesCategoryBag);
        for (String choreographyTModelKey : choreographyTModelKeys) {
            KeyedReference rolesChoreographyKeyRef = new KeyedReference();
            rolesChoreographyKeyRef.setTModelKey(CHOReOSMetadataConstants.CHOREOS_ROLE_CHOREOGRAPHY_TMODEL_KEY);
            rolesChoreographyKeyRef.setKeyValue(choreographyTModelKey);

            rolesCategoryBag.getKeyedReference().add(rolesChoreographyKeyRef);
        }

        return findRoles;
    }
}

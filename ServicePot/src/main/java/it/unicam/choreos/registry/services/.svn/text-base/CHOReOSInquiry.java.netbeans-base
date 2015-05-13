/**
 *
 * Copyright (C) 2012  Midhat Ali, Andrea Polini, Guglielmo De Angelis
 *
 * This file is part of ServicePot ver 0.1 .
 *
 * ServicePot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with ServicePot.  If not, see <http:www.gnu.org/licenses/>.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unicam.choreos.registry.services;

import it.unicam.choreos.registry.proxy.ServicePotUDDIService;
import it.unicam.choreos.registry.proxy.UDDIInquiryPortTypeImpl;
import it.unicam.choreos.registry.util.CHOReOSMetadataConstants;
import it.unicam.choreos.registry.util.ChoreographyRegistryWorker;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import org.osgi.framework.BundleContext;
import org.ow2.choreos.registry.ICHOReOSInquiry;
import org.ow2.choreos.registry.messages.FindParticipantsIn;
import org.ow2.choreos.registry.plugin.CHOReOSInquiryMonitor;
import org.ow2.choreos.registry.plugin.v2.Wrapper;
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIInquiryPortType;

/**
 *
 * @author midhat
 */
@WebService(serviceName = "CHOReOSInquiry", targetNamespace="http://www.choreos.eu")
public class CHOReOSInquiry extends ServicePotUDDIService implements ICHOReOSInquiry {
    

    public CHOReOSInquiry() {
    }

    public CHOReOSInquiry(BundleContext bc) {
        this.bc = bc;
    }
      
        
    @Override
    public TModelList FindChoreographies(FindTModel findChreographiesIn) {
         
                 
        Wrapper<FindTModel> inputWrapper=new Wrapper<FindTModel>(findChreographiesIn);
        String opid = UUID.randomUUID().toString();
        callPlugins(CHOReOSInquiryMonitor.class, "beforeFindChoreographies", findChreographiesIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "beforeFindChoreographies", inputWrapper, opid);
        findChreographiesIn=inputWrapper.getContents();
   
        
        UDDIInquiryPortType inquiryService = null;
        try {
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSInquiry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (findChreographiesIn.getCategoryBag() == null) {
            findChreographiesIn.setCategoryBag(new CategoryBag());
        }
        
        
        KeyedReference choreographyCategory = new KeyedReference();
        choreographyCategory.setKeyValue("choreography");
        choreographyCategory.setTModelKey(CHOReOSMetadataConstants.CHOREOS_TYPES_TMODEL_KEY);
        findChreographiesIn.getCategoryBag().getKeyedReference().add(choreographyCategory);
        TModelList choreographies= inquiryService.findTModel(findChreographiesIn);
                   
        Wrapper<TModelList> outputWrapper=new Wrapper<TModelList>(choreographies);
        callPlugins(CHOReOSInquiryMonitor.class, "beforeFindChoreographies", choreographies);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "beforeFindChoreographies", outputWrapper, opid);
        choreographies=outputWrapper.getContents();
        return choreographies;
        
    }
    
    @Override
    public TModelDetail GetChoreographyDetails(GetTModelDetail getChereogaphyDetailsIn) {
          
        
                     String opid = UUID.randomUUID().toString();
        Wrapper<GetTModelDetail> inputWrapper=new Wrapper<GetTModelDetail>(getChereogaphyDetailsIn);
        callPlugins(CHOReOSInquiryMonitor.class, "beforeGetChoreographyDetails", getChereogaphyDetailsIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "beforeGetChoreographyDetails", inputWrapper, opid);
getChereogaphyDetailsIn=inputWrapper.getContents();
           UDDIInquiryPortType inquiryService = null;
        try {
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSInquiry.class.getName()).log(Level.SEVERE, null, ex);
        }
        TModelDetail output= inquiryService.getTModelDetail(getChereogaphyDetailsIn);
        
        Wrapper<TModelDetail> outputWrapper=new Wrapper<TModelDetail>(output);
        callPlugins(CHOReOSInquiryMonitor.class, "afterGetChoreographyDetails", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "afterGetChoreographyDetails", outputWrapper, opid);
        return output;
    }
    

    
   

    @Override
    public ServiceList FindParticipants(FindParticipantsIn findParticipantsIn) {

                String opid = UUID.randomUUID().toString();

                Wrapper<FindParticipantsIn> inputWrapper=new Wrapper<FindParticipantsIn>(findParticipantsIn);
        callPlugins(CHOReOSInquiryMonitor.class, "beforeFindParticipants", findParticipantsIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "beforeFindParticipants", inputWrapper, opid);

         UDDIInquiryPortType inquiryService = null;
        try {
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSInquiry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (findParticipantsIn.getParticipantCriteria().getCategoryBag() == null) {
            findParticipantsIn.getParticipantCriteria().setCategoryBag(new CategoryBag());
        }
        
        
        KeyedReference participantCategory = new KeyedReference();
        
        
            participantCategory.setKeyValue("participant");
            participantCategory.setTModelKey(CHOReOSMetadataConstants.CHOREOS_TYPES_TMODEL_KEY);
            findParticipantsIn.getParticipantCriteria().getCategoryBag().getKeyedReference().add(participantCategory);

            if (findParticipantsIn.getRoleKeys() != null && !findParticipantsIn.getRoleKeys().isEmpty()) {
            for (String roleKey : findParticipantsIn.getRoleKeys()) {
                participantCategory.setKeyValue(roleKey);
                participantCategory.setTModelKey(CHOReOSMetadataConstants.CHOREOS_PARTICIPANT_ROLE_TMODEL_KEY);
                findParticipantsIn.getParticipantCriteria().getCategoryBag().getKeyedReference().add(participantCategory);
            }}
        ServiceList output = inquiryService.findService(findParticipantsIn.getParticipantCriteria());
        
        Wrapper<ServiceList> outputWrapper=new Wrapper<ServiceList>(output);
        callPlugins(CHOReOSInquiryMonitor.class, "afterFindParticipants", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "afterFindParticipants", outputWrapper, opid);
        return output;
    }
    
    @Override
    public TModelList GetRolesInChoreography(GetTModelDetail getRolesInChoreography) {
        

                Wrapper<GetTModelDetail> inputWrapper=new Wrapper<GetTModelDetail>(getRolesInChoreography);
                        String opid = UUID.randomUUID().toString();
                callPlugins(CHOReOSInquiryMonitor.class, "beforeGetRolesInChoreography", getRolesInChoreography);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "beforeGetRolesInChoreography", inputWrapper, opid);
getRolesInChoreography=inputWrapper.getContents();
         UDDIInquiryPortType inquiryService = null;
        try {
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSInquiry.class.getName()).log(Level.SEVERE, null, ex);
        }
        FindTModel findRoles= ChoreographyRegistryWorker.prepareFindRolesRequest(getRolesInChoreography.getTModelKey());
        TModelList output= inquiryService.findTModel(findRoles);
        
        Wrapper<TModelList> outputWrapper=new Wrapper<TModelList>(output);
        callPlugins(CHOReOSInquiryMonitor.class, "afterGetRolesInChoreography", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSInquiryMonitor.class, "afterGetRolesInChoreography", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
        
    }
}

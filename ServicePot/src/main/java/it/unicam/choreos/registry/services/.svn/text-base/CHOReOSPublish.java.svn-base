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
package it.unicam.choreos.registry.services;

import it.unicam.choreos.registry.proxy.ServicePotUDDIService;
import it.unicam.choreos.registry.proxy.UDDIInquiryPortTypeImpl;
import it.unicam.choreos.registry.proxy.UDDIPublicationPortTypeImpl;
import it.unicam.choreos.registry.util.CHOReOSMetadataConstants;
import it.unicam.choreos.registry.util.ChoreographyRegistryWorker;
import it.unicam.choreos.registry.util.OSGIWorker;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.ow2.choreos.registry.ICHOReOSPublish;
import org.ow2.choreos.registry.messages.AddChoreographyParticipantIn;
import org.ow2.choreos.registry.messages.RolesAndParticipantIn;
import org.ow2.choreos.registry.messages.SaveChoreographyIn;
import org.ow2.choreos.registry.plugin.CHOReOSPublishMonitor;
import org.ow2.choreos.registry.plugin.v2.Wrapper;
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDIPublicationPortType;

/**
 *
 * @author midhat
 */
@WebService(serviceName = "CHOReOSPublish", targetNamespace = "http://www.choreos.eu")
public class CHOReOSPublish extends ServicePotUDDIService implements ICHOReOSPublish {

    public CHOReOSPublish() {
    }

    public CHOReOSPublish(BundleContext bc) {
        this.bc = bc;
    }

    @Override
    public TModelDetail SaveChoreography(SaveChoreographyIn saveChoreographyIn) {

        String opid = UUID.randomUUID().toString();
        Wrapper<SaveChoreographyIn> inputWrapper = new Wrapper<SaveChoreographyIn>(saveChoreographyIn);
        callPlugins(CHOReOSPublishMonitor.class, "beforeSaveChoreography", saveChoreographyIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "beforeSaveChoreography", inputWrapper, opid);
        saveChoreographyIn = inputWrapper.getContents();

        TModelDetail saveOutput = null;
        try {

            Map<TModel, List<TModel>> uddiChoreographiesFromBPMN = ChoreographyRegistryWorker.getUDDIChoreographiesFromBPMN(saveChoreographyIn);


            Wrapper<Map<TModel, List<TModel>>> intermediateWrapper = new Wrapper<Map<TModel, List<TModel>>>(uddiChoreographiesFromBPMN);
            callPlugins(CHOReOSPublishMonitor.class, "afterProcessChoreography", saveChoreographyIn);
            callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "afterProcessChoreography", intermediateWrapper, opid);
            uddiChoreographiesFromBPMN = intermediateWrapper.getContents();
            UDDIPublicationPortType UDDIPublishService = new UDDIPublicationPortTypeImpl();

            SaveTModel currentSaveTModelRequest = new SaveTModel();
            currentSaveTModelRequest.setAuthInfo(saveChoreographyIn.getAuthInfo());
            for (Entry<TModel, List<TModel>> entry : uddiChoreographiesFromBPMN.entrySet()) 
            {
                currentSaveTModelRequest.getTModel().add(entry.getKey());
                currentSaveTModelRequest.getTModel().addAll(entry.getValue());
            }
            saveOutput = UDDIPublishService.saveTModel(currentSaveTModelRequest);


        } catch (MalformedURLException ex) {
            Logger.getLogger(CHOReOSPublish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(CHOReOSPublish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSPublish.class.getName()).log(Level.SEVERE, null, ex);

        }

        Wrapper<TModelDetail> outputWrapper = new Wrapper<TModelDetail>(saveOutput);
        callPlugins(CHOReOSPublishMonitor.class, "afterSaveChoreography", saveOutput);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "afterSaveChoreography", outputWrapper, opid);
        saveOutput = outputWrapper.getContents();
        return saveOutput;


    }

    @Override
    public ServiceDetail AddChoreographyParticipant(AddChoreographyParticipantIn addChoreographyParticipantIn) {
        Collection<ServiceReference<CHOReOSPublishMonitor>> serviceReferences = OSGIWorker.getPlugins(CHOReOSPublishMonitor.class, bc);
        if (serviceReferences != null) {
            for (ServiceReference<CHOReOSPublishMonitor> sr : serviceReferences) {

                CHOReOSPublishMonitor plugin = bc.getService(sr);


                plugin.beforeAddChoreographyParticipant(addChoreographyParticipantIn);
            }
        }

        String opid = UUID.randomUUID().toString();
        Wrapper<AddChoreographyParticipantIn> inputWrapper = new Wrapper<AddChoreographyParticipantIn>(addChoreographyParticipantIn);
        callPlugins(CHOReOSPublishMonitor.class, "beforeAddChoreographyParticipant", addChoreographyParticipantIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "beforeAddChoreographyParticipant", inputWrapper, opid);
        addChoreographyParticipantIn = inputWrapper.getContents();


        ServiceDetail sd = null;
        UDDIPublicationPortType publishService = null;
        UDDIInquiryPortType inquiryService = null;

        try {
            publishService = new UDDIPublicationPortTypeImpl();
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSPublish.class.getName()).log(Level.SEVERE, null, ex);

        }


        if (addChoreographyParticipantIn.getBusinessServiceKey() != null
                && !addChoreographyParticipantIn.getBusinessServiceKey().isEmpty()) {

            //Existing Service
            GetServiceDetail gsd = new GetServiceDetail();
            gsd.getServiceKey().add(addChoreographyParticipantIn.getBusinessServiceKey());
            sd = inquiryService.getServiceDetail(gsd);
            SaveService ss = new SaveService();
            ss.getBusinessService().addAll(sd.getBusinessService());
            addChoreographyParticipantIn.setNewService(ss);

        }

        List<BusinessService> services = addChoreographyParticipantIn.getNewService().getBusinessService();
        for (BusinessService service : services) {
            if (service.getCategoryBag() == null) {
                service.setCategoryBag(new CategoryBag());
            }
            KeyedReference participantCategory = new KeyedReference();
            participantCategory.setTModelKey(CHOReOSMetadataConstants.CHOREOS_TYPES_TMODEL_KEY);
            participantCategory.setKeyValue("participant");
            service.getCategoryBag().getKeyedReference().add(participantCategory);

            for (String roleKey : addChoreographyParticipantIn.getRoleKeys()) {
                KeyedReference participantRole = new KeyedReference();
                participantRole.setTModelKey(CHOReOSMetadataConstants.CHOREOS_PARTICIPANT_ROLE_TMODEL_KEY);
                participantRole.setKeyValue(roleKey);
                service.getCategoryBag().getKeyedReference().add(participantRole);

            }

        }
        if (addChoreographyParticipantIn.getNewService().getAuthInfo() == null
                || addChoreographyParticipantIn.getNewService().getAuthInfo().isEmpty()) {
            addChoreographyParticipantIn.getNewService().setAuthInfo(
                    addChoreographyParticipantIn.getAuthInfo());
        }

        sd = publishService.saveService(addChoreographyParticipantIn.getNewService());


        Wrapper<ServiceDetail> outputWrapper = new Wrapper<ServiceDetail>(sd);
        callPlugins(CHOReOSPublishMonitor.class, "afterAddChoreographyParticipant", sd);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "afterAddChoreographyParticipant", outputWrapper, opid);
        sd = outputWrapper.getContents();
        return sd;
    }

    @Override
    public ServiceDetail AddRolesToParticipant(RolesAndParticipantIn addRoleToParticipantIn) {
        Wrapper<RolesAndParticipantIn> inputWrapper = new Wrapper<RolesAndParticipantIn>(addRoleToParticipantIn);

        String opid = UUID.randomUUID().toString();
        callPlugins(CHOReOSPublishMonitor.class, "beforeAddRolesToParticipant", addRoleToParticipantIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "beforeAddRolesToParticipant", inputWrapper, opid);
        addRoleToParticipantIn = inputWrapper.getContents();

        ServiceDetail sd;
        UDDIPublicationPortType publishService = null;
        UDDIInquiryPortType inquiryService = null;

        try {
            publishService = new UDDIPublicationPortTypeImpl();
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSPublish.class.getName()).log(Level.SEVERE, null, ex);
        }

        GetServiceDetail gsd = new GetServiceDetail();
        gsd.getServiceKey().add(addRoleToParticipantIn.getServiceKey());
        sd = inquiryService.getServiceDetail(gsd);
        SaveService ss = new SaveService();
        ss.getBusinessService().addAll(sd.getBusinessService());

        for (BusinessService service : ss.getBusinessService()) {
            if (service.getCategoryBag() == null) {
                service.setCategoryBag(new CategoryBag());
            }
            for (String roleKey : addRoleToParticipantIn.getRoles()) {
                KeyedReference participantRole = new KeyedReference();
                participantRole.setTModelKey(CHOReOSMetadataConstants.CHOREOS_PARTICIPANT_ROLE_TMODEL_KEY);
                participantRole.setKeyValue(roleKey);
                service.getCategoryBag().getKeyedReference().add(participantRole);

            }



        }
        if (ss.getAuthInfo() == null
                || ss.getAuthInfo().isEmpty()) {
            ss.setAuthInfo(
                    addRoleToParticipantIn.getAuthInfo());
        }
        ServiceDetail output = publishService.saveService(ss);

        Wrapper<ServiceDetail> outputWrapper = new Wrapper<ServiceDetail>(output);
        callPlugins(CHOReOSPublishMonitor.class, "beforeAddRolesToParticipant", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "beforeAddRolesToParticipant", outputWrapper, opid);
        output = outputWrapper.getContents();
        return output;
    }

    @Override
    public ServiceDetail RemoveRolesFromParticipant(RolesAndParticipantIn removeRoleFromParticipantIn) {
        Wrapper<RolesAndParticipantIn> inputWrapper = new Wrapper<RolesAndParticipantIn>(removeRoleFromParticipantIn);
        String opid = UUID.randomUUID().toString();
        callPlugins(CHOReOSPublishMonitor.class, "beforeRemoveRolesFromParticipant", removeRoleFromParticipantIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "beforeRemoveRolesFromParticipant", inputWrapper, opid);
        removeRoleFromParticipantIn = inputWrapper.getContents();

        ServiceDetail sd;
        UDDIPublicationPortType publishService = null;
        UDDIInquiryPortType inquiryService = null;

        try {
            publishService = new UDDIPublicationPortTypeImpl();
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSPublish.class.getName()).log(Level.SEVERE, null, ex);
        }

        GetServiceDetail gsd = new GetServiceDetail();
        gsd.getServiceKey().add(removeRoleFromParticipantIn.getServiceKey());
        sd = inquiryService.getServiceDetail(gsd);
        SaveService ss = new SaveService();
        ss.getBusinessService().addAll(sd.getBusinessService());

        for (BusinessService service : ss.getBusinessService()) {
            if (service.getCategoryBag() != null && service.getCategoryBag().getKeyedReference() != null) {
                Iterator<KeyedReference> keyedRefIterator = service.getCategoryBag().getKeyedReference().iterator();
                while (keyedRefIterator.hasNext()) {
                    KeyedReference serviceKr = keyedRefIterator.next();
                    for (String roleKey : removeRoleFromParticipantIn.getRoles()) {
                        if (serviceKr.getTModelKey().equals(CHOReOSMetadataConstants.CHOREOS_PARTICIPANT_ROLE_TMODEL_KEY)
                                && serviceKr.getKeyValue().equals(roleKey)) {
                            keyedRefIterator.remove();
                        }
                    }
                }
            }

        }
        if (ss.getAuthInfo() == null
                || ss.getAuthInfo().isEmpty()) {
            ss.setAuthInfo(
                    removeRoleFromParticipantIn.getAuthInfo());
        }
        ServiceDetail output = publishService.saveService(ss);
        Wrapper<ServiceDetail> outputWrapper = new Wrapper<ServiceDetail>(output);
        callPlugins(CHOReOSPublishMonitor.class, "afterRemoveRolesFromParticipant", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "afterRemoveRolesFromParticipant", outputWrapper, opid);
        output = outputWrapper.getContents();
        return output;
    }

    @Override
    public void RemoveChoreography(DeleteTModel removeChoreographyIn) {
        Wrapper<DeleteTModel> inputWrapper = new Wrapper<DeleteTModel>(removeChoreographyIn);
        String opid = UUID.randomUUID().toString();
        callPlugins(CHOReOSPublishMonitor.class, "beforeRemoveChoreography", removeChoreographyIn);
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "beforeRemoveChoreography", inputWrapper, opid);
        removeChoreographyIn = inputWrapper.getContents();

        UDDIPublicationPortType publishService = null;
        UDDIInquiryPortType inquiryService = null;

        try {
            publishService = new UDDIPublicationPortTypeImpl();
            inquiryService = new UDDIInquiryPortTypeImpl();
        } catch (IOException ex) {
            Logger.getLogger(CHOReOSPublish.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Find Roles
        FindTModel findRoles = ChoreographyRegistryWorker.prepareFindRolesRequest(removeChoreographyIn.getTModelKey());
        TModelList foundRoles = inquiryService.findTModel(findRoles);

        //Find Participants
        FindService findParticipants = new FindService();
        CategoryBag participantsCategorybag = new CategoryBag();
        for (TModelInfo roleTModel : foundRoles.getTModelInfos().getTModelInfo()) {
            KeyedReference participantCategoryKeyRef = new KeyedReference();
            participantCategoryKeyRef.setKeyValue("participant");
            participantCategoryKeyRef.setTModelKey(CHOReOSMetadataConstants.CHOREOS_TYPES_TMODEL_KEY);
            participantCategoryKeyRef.setKeyName(roleTModel.getTModelKey());
            participantsCategorybag.getKeyedReference().add(participantCategoryKeyRef);
        }
        findParticipants.setCategoryBag(participantsCategorybag);
        ServiceList foundParticipants = inquiryService.findService(findParticipants);

        //Remove Choreography
        publishService.deleteTModel(removeChoreographyIn);

        //Remove Roles
        DeleteTModel deleteRoles = new DeleteTModel();
        deleteRoles.setAuthInfo(removeChoreographyIn.getAuthInfo());
        if (foundRoles.getTModelInfos() != null) {
            for (TModelInfo role : foundRoles.getTModelInfos().getTModelInfo()) {
                deleteRoles.getTModelKey().add(role.getTModelKey());
            }
        }
        publishService.deleteTModel(deleteRoles);

        //Remove roles from participants
        if (foundParticipants.getServiceInfos() != null) {
            for (ServiceInfo participantInfo : foundParticipants.getServiceInfos().getServiceInfo()) {
                BusinessService participant = new BusinessService();
                participant.setServiceKey(participantInfo.getServiceKey());

                RolesAndParticipantIn deleteRolesAndParticipants = new RolesAndParticipantIn();
                deleteRolesAndParticipants.setAuthInfo(removeChoreographyIn.getAuthInfo());
                deleteRolesAndParticipants.setServiceKey(participant.getServiceKey());
                deleteRolesAndParticipants.setRoles(deleteRoles.getTModelKey());

                RemoveRolesFromParticipant(deleteRolesAndParticipants);


            }
        }
        callPlugins(CHOReOSPublishMonitor.class, "afterRemoveChoreography");
        callPlugins(org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor.class, "afterRemoveChoreography", opid);

    }
}

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
package org.ow2.choreos.registry.plugin.v2;

import org.ow2.choreos.registry.plugin.*;
import java.util.List;
import javax.xml.ws.Holder;
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIPublicationPortType;

/**
 *
 * @author midhat
 */
@ServicePotPluginInterface
public interface UDDIPublicationMonitor{

    
    public void beforeDeleteBinding(Wrapper<DeleteBinding> body,String opid);
    public void afterDeleteBinding(String opid);

    
    public void beforeSaveTModel(Wrapper<SaveTModel> body,String opid);
    public void afterSaveTModel(Wrapper<TModelDetail> body,String opid);

    
    public void beforeAddPublisherAssertions(Wrapper<AddPublisherAssertions> body,String opid);
    public void afterAddPublisherAssertions(String opid);

    
    public void beforeDeleteBusiness(Wrapper<DeleteBusiness> body,String opid);
    public void afterDeleteBusiness(String opid);

    
    public void beforeSaveService(Wrapper<SaveService> body,String opid);
    public void afterSaveService(Wrapper<ServiceDetail> body,String opid);

    
    public void beforeDeletePublisherAssertions(Wrapper<DeletePublisherAssertions> body,String opid);
    public void afterDeletePublisherAssertions(String opid);

    
    public void beforeSetPublisherAssertions(Wrapper<String> authInfo, Wrapper<Holder<List<PublisherAssertion>>> publisherAssertion,String opid);
    public void afterSetPublisherAssertions(String opid);

    
    public void beforeGetPublisherAssertions(Wrapper<String> authInfo,String opid);
    public void afterGetPublisherAssertions(Wrapper<List<PublisherAssertion>> body,String opid);

    
    public void beforeDeleteService(Wrapper<DeleteService> body,String opid);
    public void afterDeleteService(String opid);

    
    public void beforeSaveBinding(SaveBinding body,String opid);
    public void afterSaveBinding(BindingDetail body,String opid);

    
    public void beforeSaveBusiness(SaveBusiness body,String opid);
    public void afterSaveBusiness(BusinessDetail body,String opid);

    
    public void beforeGetRegisteredInfo(GetRegisteredInfo body,String opid);
    public void afterGetRegisteredInfo(RegisteredInfo body,String opid);

    
    public void beforeGetAssertionStatusReport(String authInfo, CompletionStatus completionStatus,String opid);
    public void afterGetAssertionStatusReport(List<AssertionStatusItem> body,String opid);

    
    public void beforeDeleteTModel(DeleteTModel body,String opid);
    public void afterDeleteTModel(String opid);
    
}

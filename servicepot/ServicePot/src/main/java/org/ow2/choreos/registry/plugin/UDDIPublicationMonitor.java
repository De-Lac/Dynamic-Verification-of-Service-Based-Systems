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
package org.ow2.choreos.registry.plugin;

import java.util.List;
import javax.xml.ws.Holder;
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIPublicationPortType;

/**
 *
 * @author midhat
 * @deprecated Use the interface in org.ow2.choreos.registry.plugin.v2 package
 */
@ServicePotPluginInterface
@Deprecated
public interface UDDIPublicationMonitor{

    
    public void beforeDeleteBinding(DeleteBinding body) ;
    public void afterDeleteBinding() ;

    
    public void beforeSaveTModel(SaveTModel body) ;
    public void afterSaveTModel(TModelDetail body) ;

    
    public void beforeAddPublisherAssertions(AddPublisherAssertions body) ;
    public void afterAddPublisherAssertions() ;

    
    public void beforeDeleteBusiness(DeleteBusiness body) ;
    public void afterDeleteBusiness() ;

    
    public void beforeSaveService(SaveService body) ;
    public void afterSaveService(ServiceDetail body) ;

    
    public void beforeDeletePublisherAssertions(DeletePublisherAssertions body) ;
    public void afterDeletePublisherAssertions() ;

    
    public void beforeSetPublisherAssertions(String authInfo, Holder<List<PublisherAssertion>> publisherAssertion) ;
    public void afterSetPublisherAssertions() ;

    
    public void beforeGetPublisherAssertions(String authInfo) ;
    public void afterGetPublisherAssertions(List<PublisherAssertion> body) ;

    
    public void beforeDeleteService(DeleteService body) ;
    public void afterDeleteService() ;

    
    public void beforeSaveBinding(SaveBinding body) ;
    public void afterSaveBinding(BindingDetail body) ;

    
    public void beforeSaveBusiness(SaveBusiness body) ;
    public void afterSaveBusiness(BusinessDetail body) ;

    
    public void beforeGetRegisteredInfo(GetRegisteredInfo body) ;
    public void afterGetRegisteredInfo(RegisteredInfo body) ;

    
    public void beforeGetAssertionStatusReport(String authInfo, CompletionStatus completionStatus) ;;
    public void afterGetAssertionStatusReport(List<AssertionStatusItem> body) ;

    
    public void beforeDeleteTModel(DeleteTModel body) ;
    public void afterDeleteTModel() ;
    
}

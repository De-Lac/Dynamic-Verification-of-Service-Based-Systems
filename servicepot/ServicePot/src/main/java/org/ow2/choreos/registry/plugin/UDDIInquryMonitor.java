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

import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIInquiryPortType;

/**
 *
 * @author midhat
 *@deprecated Use the interface in org.ow2.choreos.registry.plugin.v2 package
 */
@ServicePotPluginInterface
@Deprecated
public  interface UDDIInquryMonitor {

    
    public void beforeGetBindingDetail(GetBindingDetail body);
    public void afterGetBindingDetail(BindingDetail output);

    
    
    public void beforeGetServiceDetail(GetServiceDetail body);
    public void afterGetServiceDetail(ServiceDetail body);
   

    
    public void beforeGetTModelDetail(GetTModelDetail body) ;
    public void afterGetTModelDetail(TModelDetail body) ;

    
    public void beforeFindBinding(FindBinding body) ;
    public void afterFindBinding(BindingDetail body) ;

    
    public void beforeFindBusiness(FindBusiness body) ;
    public void afterFindBusiness(BusinessList body) ;

    
    public void beforeFindRelatedBusinesses(FindRelatedBusinesses body) ;
    public void afterFindRelatedBusinesses(RelatedBusinessesList body) ;

    
    public void beforeGetBusinessDetail(GetBusinessDetail body) ;
    public void afterGetBusinessDetail(BusinessDetail body) ;

    
    public void beforeFindTModel(FindTModel body) ;
    public void afterFindTModel(TModelList body) ;

    
    public void beforeGetOperationalInfo(GetOperationalInfo body) ;
    public void afterGetOperationalInfo(OperationalInfos body) ;
    
   public void beforeFindService(FindService input);
   public void afterFindService (ServiceList output);
}
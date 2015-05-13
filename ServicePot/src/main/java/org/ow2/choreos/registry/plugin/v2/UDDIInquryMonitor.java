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
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIInquiryPortType;

/**
 *
 * @author midhat
 */
@ServicePotPluginInterface
public  interface UDDIInquryMonitor {

    
    public void beforeGetBindingDetail(Wrapper<GetBindingDetail> body,String opid);
    public void afterGetBindingDetail(Wrapper<BindingDetail> output,String opid);

    
    
    public void beforeGetServiceDetail(Wrapper<GetServiceDetail> body,String opid);
    public void afterGetServiceDetail(Wrapper<ServiceDetail> body,String opid);
   

    
    public void beforeGetTModelDetail(Wrapper<GetTModelDetail> body,String opid);
    public void afterGetTModelDetail(Wrapper<TModelDetail> body,String opid);

    
    public void beforeFindBinding(Wrapper<FindBinding> body,String opid);
    public void afterFindBinding(Wrapper<BindingDetail> body,String opid);

    
    public void beforeFindBusiness(Wrapper<FindBusiness> body,String opid);
    public void afterFindBusiness(Wrapper<BusinessList> body,String opid);

    
    public void beforeFindRelatedBusinesses(Wrapper<FindRelatedBusinesses> body,String opid);
    public void afterFindRelatedBusinesses(Wrapper<RelatedBusinessesList> body,String opid);

    
    public void beforeGetBusinessDetail(Wrapper<GetBusinessDetail> body,String opid);
    public void afterGetBusinessDetail(Wrapper<BusinessDetail> body,String opid);

    
    public void beforeFindTModel(Wrapper<FindTModel> body, String opid);
    public void afterFindTModel(Wrapper<TModelList> body, String opid) ;

    
    public void beforeGetOperationalInfo(Wrapper<GetOperationalInfo> body,String opid);
    public void afterGetOperationalInfo(Wrapper<OperationalInfos> body,String opid);
    
   public void beforeFindService(Wrapper<FindService> input,String opid) ;
   public void afterFindService (Wrapper<ServiceList> output,String opid);
}
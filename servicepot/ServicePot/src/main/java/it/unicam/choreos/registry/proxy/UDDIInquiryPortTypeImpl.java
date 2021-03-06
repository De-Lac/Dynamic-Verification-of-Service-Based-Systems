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
/**
 * Please modify this class to meet your needs This class is not complete
 */
package it.unicam.choreos.registry.proxy;

import it.unicam.choreos.registry.util.UDDIDispatcher;
import it.unicam.choreos.registry.util.UDDIDispatcherFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleContext;
import org.ow2.choreos.registry.plugin.UDDIInquryMonitor;
import org.ow2.choreos.registry.plugin.v2.Wrapper;
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIInquiryPortType;

/**
 * This class was generated by Apache CXF 2.5.2 2012-02-02T15:14:55.173+01:00
 * Generated source version: 2.5.2
 *
 */
@javax.jws.WebService(serviceName = "UDDIInquiryService",
portName = "UDDIInquiryImplPort",
targetNamespace = "urn:uddi-org:v3_service",
//wsdlLocation = "resources/inquiry.wsdl",
endpointInterface = "org.uddi.v3_service.UDDIInquiryPortType")
public class UDDIInquiryPortTypeImpl extends ServicePotUDDIService implements UDDIInquiryPortType {

    private static final Logger LOG = Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName());
    

    public UDDIInquiryPortTypeImpl(BundleContext bc) throws IOException {

        this();
        this.bc = bc;
    }

    public UDDIInquiryPortTypeImpl() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("UDDIProxy.properties"));
        uddiURL = properties.getProperty("UDDI.Endpoint.Inquiry");

    }

    public UDDIInquiryPortTypeImpl(String uddiURL) {
        super(uddiURL);
    }


    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#getBindingDetail(org.uddi.api_v3.GetBindingDetail
     * body )*
     */
    public org.uddi.api_v3.BindingDetail getBindingDetail(org.uddi.api_v3.GetBindingDetail body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<GetBindingDetail> inputWrapper=new Wrapper<GetBindingDetail>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeGetBindingDetail", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeGetBindingDetail", inputWrapper, opid);
        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        BindingDetail output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "getBindingDetail", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Wrapper<BindingDetail> outputWrapper=new Wrapper<BindingDetail>(output);
        callPlugins(UDDIInquryMonitor.class, "afterGetBindingDetail", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterGetBindingDetail", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }

    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#findService(org.uddi.api_v3.FindService
     * body )*
     */
    public org.uddi.api_v3.ServiceList findService(org.uddi.api_v3.FindService body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<FindService> inputWrapper=new Wrapper<FindService>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeFindService", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeFindService", inputWrapper, opid);
        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        ServiceList output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "findService", body);

        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }


        Wrapper<ServiceList> outputWrapper=new Wrapper<ServiceList>(output);
        callPlugins(UDDIInquryMonitor.class, "afterFindService", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterFindService", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }


    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#getServiceDetail(org.uddi.api_v3.GetServiceDetail
     * body )*
     */
    public org.uddi.api_v3.ServiceDetail getServiceDetail(org.uddi.api_v3.GetServiceDetail body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<GetServiceDetail> inputWrapper=new Wrapper<GetServiceDetail>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeGetServiceDetail", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeGetServiceDetail", inputWrapper, opid);
        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        ServiceDetail output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "getServiceDetail", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Wrapper<ServiceDetail> outputWrapper=new Wrapper<ServiceDetail>(output);
        callPlugins(UDDIInquryMonitor.class, "afterGetServiceDetail", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterGetServiceDetail", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }

    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#getTModelDetail(org.uddi.api_v3.GetTModelDetail
     * body )*
     */
    public org.uddi.api_v3.TModelDetail getTModelDetail(org.uddi.api_v3.GetTModelDetail body) {
        String opid = UUID.randomUUID().toString();
        
        Wrapper<GetTModelDetail> inputWrapper=new Wrapper<GetTModelDetail>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeGetTModelDetail", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeGetTModelDetail", inputWrapper, opid);
        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        TModelDetail output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "getTModelDetail", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Wrapper<TModelDetail> outputWrapper=new Wrapper<TModelDetail>(output);
        callPlugins(UDDIInquryMonitor.class, "afterGetTModelDetail", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterGetTModelDetail", outputWrapper, opid);
output=outputWrapper.getContents();
        return output;
    }

    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#findBinding(org.uddi.api_v3.FindBinding
     * body )*
     */
    public org.uddi.api_v3.BindingDetail findBinding(org.uddi.api_v3.FindBinding body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<FindBinding> inputWrapper=new Wrapper<FindBinding>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeFindBinding", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeFindBinding", inputWrapper, opid);
        body = inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        BindingDetail output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "findBinding", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Wrapper<BindingDetail> outputWrapper=new Wrapper<BindingDetail>(output);
        callPlugins(UDDIInquryMonitor.class, "afterFindBinding", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterFindBinding", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }

    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#findBusiness(org.uddi.api_v3.FindBusiness
     * body )*
     */
    public org.uddi.api_v3.BusinessList findBusiness(org.uddi.api_v3.FindBusiness body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<FindBusiness> inputWrapper=new Wrapper<FindBusiness>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeFindBusiness", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeFindBusiness", inputWrapper, opid);
        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        BusinessList output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "findBusiness", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Wrapper<BusinessList> outputWrapper=new Wrapper<BusinessList>(output);
        callPlugins(UDDIInquryMonitor.class, "afterFindBusiness", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterFindBusiness", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }

    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#findRelatedBusinesses(org.uddi.api_v3.FindRelatedBusinesses
     * body )*
     */
    public org.uddi.api_v3.RelatedBusinessesList findRelatedBusinesses(org.uddi.api_v3.FindRelatedBusinesses body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<FindRelatedBusinesses> inputWrapper=new Wrapper<FindRelatedBusinesses>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeFindRelatedBusinesses", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeFindRelatedBusinesses", inputWrapper, opid);
        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        RelatedBusinessesList output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "findRelatedBusinesses", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Wrapper<RelatedBusinessesList> outputWrapper=new Wrapper<RelatedBusinessesList>(output);
        callPlugins(UDDIInquryMonitor.class, "afterFindRelatedBusinesses", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterFindRelatedBusinesses", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }

    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#getBusinessDetail(org.uddi.api_v3.GetBusinessDetail
     * body )*
     */
    public org.uddi.api_v3.BusinessDetail getBusinessDetail(org.uddi.api_v3.GetBusinessDetail body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<GetBusinessDetail> inputWrapper
                =new Wrapper<GetBusinessDetail>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeGetBusinessDetail", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeGetBusinessDetail", inputWrapper, opid);

        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        BusinessDetail output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "getBusinessDetail", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Wrapper<BusinessDetail> outputWrapper=new Wrapper<BusinessDetail>(output);
        callPlugins(UDDIInquryMonitor.class, "afterGetBusinessDetail", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterGetBusinessDetail", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }

    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDIInquiryPortType#findTModel(org.uddi.api_v3.FindTModel
     * body )*
     */
    public org.uddi.api_v3.TModelList findTModel(org.uddi.api_v3.FindTModel body) {

        String opid = UUID.randomUUID().toString();
        
        Wrapper<FindTModel> inputWrapper=new Wrapper<FindTModel>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeFindTModel", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeFindTModel", inputWrapper, opid);

        body=inputWrapper.getContents();
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        TModelList output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "findTModel", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Wrapper<TModelList> outputWrapper=new Wrapper<TModelList>(output);
        callPlugins(UDDIInquryMonitor.class, "afterFindTModel", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterFindTModel", outputWrapper, opid);
output=outputWrapper.getContents();
        return output;
    }

    public org.uddi.api_v3.OperationalInfos getOperationalInfo(org.uddi.api_v3.GetOperationalInfo body) {
        String opid = UUID.randomUUID().toString();
        Wrapper<GetOperationalInfo> inputWrapper=new Wrapper<GetOperationalInfo>(body);
        callPlugins(UDDIInquryMonitor.class, "beforeGetOperationalInfo", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "beforeGetOperationalInfo", inputWrapper, opid);
        body=inputWrapper.getContents();
        
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        OperationalInfos output = null;
        try {
            output = dispatcher.dispatchFirstMethod(UDDIInquiryPortType.class, "getOperationalInfo", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Wrapper<OperationalInfos> outputWrapper=new Wrapper<OperationalInfos>(output);
        callPlugins(UDDIInquryMonitor.class, "afterGetOperationalInfo", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor.class, "afterGetOperationalInfo", outputWrapper, opid);
        output=outputWrapper.getContents();
        return output;
    }

  
}

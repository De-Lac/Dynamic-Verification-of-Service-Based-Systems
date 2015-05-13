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
package it.unicam.choreos.registry.osgi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.binding.soap.SoapBindingFactory;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.http.ClientOnlyHTTPTransportFactory;
import org.apache.cxf.transport.servlet.AbstractCXFServlet;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author midhat
 */
public class Activator implements BundleActivator {

    private ServiceTracker httpServiceTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        httpServiceTracker = new HttpServiceTracker(context);
        httpServiceTracker.open();
        
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        
        
        httpServiceTracker.close();
        httpServiceTracker = null;
    }

    private class HttpServiceTracker extends ServiceTracker {

        public HttpServiceTracker(BundleContext context) {
            super(context, HttpService.class.getName(), null);
        }

        @Override
        public Object addingService(ServiceReference reference) {
            HttpService httpService = (HttpService) context.getService(reference);
            try {

                AbstractCXFServlet servlet = new CXFServlet();
                BusFactory.setDefaultBus(servlet.getBus());
                httpService.registerServlet("/services", servlet, null, null); //$NON-NLS-1$
                Bus bus = servlet.getBus();
                
                BindingFactoryManager bfm = bus.getExtension(BindingFactoryManager.class);
                SoapBindingFactory sbf=new SoapBindingFactory();
                sbf.setBus(bus);
                bfm.registerBindingFactory(org.apache.cxf.binding.soap.SoapBindingFactory.SOAP_11_BINDING, sbf);
                bfm.registerBindingFactory(org.apache.cxf.binding.soap.SoapBindingFactory.SOAP_12_BINDING, sbf);
                
                ConduitInitiatorManager conduitInitiatorMgr =bus.getExtension(ConduitInitiatorManager.class);
                /*
                 SoapTransportFactory stf=new SoapTransportFactory();
                stf.setBus(bus);
                */
                ClientOnlyHTTPTransportFactory httf=new org.apache.cxf.transport.http.ClientOnlyHTTPTransportFactory();
                httf.setBus(bus);
                conduitInitiatorMgr.registerConduitInitiator("http://schemas.xmlsoap.org/wsdl/soap/http", httf);


                Endpoint.publish("/choreos-inquiry",new it.unicam.choreos.registry.services.CHOReOSInquiry(context));
                Endpoint.publish("/choreos-publish",new it.unicam.choreos.registry.services.CHOReOSPublish(context));
                Endpoint.publish("/custody-transfer", new it.unicam.choreos.registry.proxy.UDDICustodyTransferPortTypeImpl(context));
                Endpoint.publish("/inquiry", new it.unicam.choreos.registry.proxy.UDDIInquiryPortTypeImpl(context));
                Endpoint.publish("/publish", new it.unicam.choreos.registry.proxy.UDDIPublicationPortTypeImpl(context));
                Endpoint.publish("/security", new it.unicam.choreos.registry.proxy.UDDISecurityPortTypeImpl(context));
                Endpoint.publish("/subscription-listener", new it.unicam.choreos.registry.proxy.UDDISubscriptionListenerPortTypeImpl(context));
                Endpoint.publish("/subscription", new it.unicam.choreos.registry.proxy.UDDISubscriptionPortTypeImpl(context));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return httpService;
        }

        @Override
        public void removedService(ServiceReference reference, Object service) {
            HttpService httpService = (HttpService) service;

            httpService.unregister("/services"); //$NON-NLS-1$
            super.removedService(reference, service);
        }
    }

    class ServicePotServlet extends CXFNonSpringServlet {

        @Override
        public void loadBus(ServletConfig servletConfig) throws ServletException {
            try {
                super.loadBus(servletConfig);

                // You could add the endpoint publish codes here
                Bus bb = this.getBus();
                BusFactory.setDefaultBus(bb);
                Endpoint.publish("/custody-transfer", new it.unicam.choreos.registry.proxy.UDDICustodyTransferPortTypeImpl());
                Endpoint.publish("/inquiry", new it.unicam.choreos.registry.proxy.UDDIInquiryPortTypeImpl());
                Endpoint.publish("/publish", new it.unicam.choreos.registry.proxy.UDDIPublicationPortTypeImpl());
                Endpoint.publish("/security", new it.unicam.choreos.registry.proxy.UDDISecurityPortTypeImpl());
                Endpoint.publish("/subscription-listener", new it.unicam.choreos.registry.proxy.UDDISubscriptionListenerPortTypeImpl());
                Endpoint.publish("/subscription", new it.unicam.choreos.registry.proxy.UDDISubscriptionPortTypeImpl());
            } catch (IOException ex) {
                Logger.getLogger(Activator.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }
}

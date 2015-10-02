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
import org.ow2.choreos.registry.plugin.UDDISubscriptionListenerMonitor;
import org.ow2.choreos.registry.plugin.v2.Wrapper;
import org.uddi.api_v3.DispositionReport;
import org.uddi.subr_v3.NotifySubscriptionListener;
import org.uddi.v3_service.UDDISubscriptionListenerPortType;

/**
 * This class was generated by Apache CXF 2.5.2 2012-02-02T15:16:27.303+01:00
 * Generated source version: 2.5.2
 *
 */
@javax.jws.WebService(serviceName = "UDDISubscriptionListenerService",
portName = "UDDISubscriptionListenerImplPort",
targetNamespace = "urn:uddi-org:v3_service",
//wsdlLocation = "resources/subscription-listener.wsdl",
endpointInterface = "org.uddi.v3_service.UDDISubscriptionListenerPortType")
public class UDDISubscriptionListenerPortTypeImpl extends ServicePotUDDIService implements UDDISubscriptionListenerPortType {

    private static final Logger LOG = Logger.getLogger(UDDISubscriptionListenerPortTypeImpl.class.getName());
    
    private static final Class uddiClass = UDDISubscriptionListenerPortType.class;
    /*
     * (non-Javadoc) @see
     * org.uddi.v3_service.UDDISubscriptionListenerPortType#notifySubscriptionListener(org.uddi.subr_v3.NotifySubscriptionListener
     * body )*
     */

    public UDDISubscriptionListenerPortTypeImpl(String uddiURL) {
        super(uddiURL);
    }
    

    public UDDISubscriptionListenerPortTypeImpl() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("UDDIProxy.properties"));
        uddiURL = properties.getProperty("UDDI.Endpoint.SubscriptionListener");
    }

    public UDDISubscriptionListenerPortTypeImpl(BundleContext bc) throws IOException {
        this();
        this.bc = bc;
    }

    public org.uddi.api_v3.DispositionReport notifySubscriptionListener(org.uddi.subr_v3.NotifySubscriptionListener body) {
  
        

         String opid = UUID.randomUUID().toString();
        Wrapper<NotifySubscriptionListener> inputWrapper=new Wrapper<NotifySubscriptionListener>(body);
        callPlugins(UDDISubscriptionListenerMonitor.class, "beforeNotifySubscriptionListener", body);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDISubscriptionListenerMonitor.class, "beforeNotifySubscriptionListener", inputWrapper, opid);
   
        body=inputWrapper.getContents();
 
        UDDIDispatcher dispatcher = UDDIDispatcherFactory.createDispatcher(uddiURL);
        DispositionReport output = null;
        try {
            output = dispatcher.dispatchFirstMethod(uddiClass, "notifySubscriptionListener", body);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
         
        Wrapper<DispositionReport> outputWrapper=new Wrapper<DispositionReport>(output);
        callPlugins(UDDISubscriptionListenerMonitor.class, "afterNotifySubscriptionListener", output);
        callPlugins(org.ow2.choreos.registry.plugin.v2.UDDISubscriptionListenerMonitor.class, "afterNotifySubscriptionListener", outputWrapper, opid);
   
        output=outputWrapper.getContents();
        
        return output;
    }
}
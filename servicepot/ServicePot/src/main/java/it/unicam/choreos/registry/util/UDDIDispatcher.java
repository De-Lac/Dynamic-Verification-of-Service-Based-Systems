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
package it.unicam.choreos.registry.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.cxf.jaxws.*;

/**
 *
 * @author midhat
 */
public class UDDIDispatcher {
    
    private String dispatchURL;
    
    protected UDDIDispatcher() {
        //Must use Factory
    }
    
    protected UDDIDispatcher(String dispatchURL) {
        this.dispatchURL = dispatchURL;
    }
    
    public <O> O dispatchFirstMethod(Class serviceClass, String methodName, Object... input) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //callPlugins(UDDIInquryMonitor.class, "afterGetOperationalInfo", output);
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress(dispatchURL);
        factory.setServiceClass(serviceClass);
        factory.setBindingId(org.apache.cxf.binding.soap.SoapBindingFactory.SOAP_11_BINDING);
        Object service = factory.create();
        
        Class[] classes = new Class[input.length];
        for (int i = 0; i < input.length; i++) {
            classes[i] = input[i].getClass();
        }      
 
        Method method = service.getClass().getMethod(methodName, classes);
        
        Object output = method.invoke(service, input);
        return (O) output;
        
    }
    
    
}

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

import java.util.Collection;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 *
 * @author midhat
 */
public class OSGIWorker {
    
    public static <T> Collection<ServiceReference<T>> getPlugins(Class<T> clazz, BundleContext bc){ 
        Collection<ServiceReference<T>> serviceReferences = null;
        if (bc != null) {
            try {
                serviceReferences = bc.getServiceReferences(clazz, null);
                
            } catch (InvalidSyntaxException ex) {
                ex.printStackTrace();
            }
        }
        return serviceReferences;
    }
}

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

import org.uddi.api_v3.AuthToken;
import org.uddi.api_v3.DiscardAuthToken;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.v3_service.UDDISecurityPortType;

/**
 * @deprecated Use the interface in org.ow2.choreos.registry.plugin.v2 package
 * @author midhat
 */
@ServicePotPluginInterface
@Deprecated
public interface UDDISecurityMonitor {

    
    public void beforeDiscardAuthToken(DiscardAuthToken body) ;
    public void afterDiscardAuthToken() ;
    
    public void beforeGetAuthToken(GetAuthToken body) ;
    public void afterGetAuthToken(AuthToken body) ;
    
}

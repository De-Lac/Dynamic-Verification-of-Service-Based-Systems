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
import org.uddi.sub_v3.*;
import org.uddi.v3_service.UDDISubscriptionPortType;

/**
 *
 * @author midhat
 */
@ServicePotPluginInterface
public interface UDDISubscriptionMonitor {
    
    public void beforeGetSubscriptionResults(Wrapper<GetSubscriptionResults> body,String opid);
    public void afterGetSubscriptionResults(Wrapper<SubscriptionResultsList> body,String opid);
    
    public void beforeGetSubscriptions(Wrapper<GetSubscriptions> parameters,String opid);
    public void afterGetSubscriptions(Wrapper<Subscriptions> parameters,String opid);
    
    public void beforeDeleteSubscription(Wrapper<DeleteSubscription> body,String opid);
    public void afterDeleteSubscription(String opid);
    
    public void beforeSaveSubscription(Wrapper<SaveSubscription> parameters,String opid);
    public void afterSaveSubscription(Wrapper<Subscriptions> parameters,String opid);
    
}

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
import org.ow2.choreos.registry.messages.FindParticipantsIn;
import org.uddi.api_v3.*;

/**
 *
 * @author midhat
 */
@ServicePotPluginInterface
public interface CHOReOSInquiryMonitor {

    public void beforeFindChoreographies(Wrapper<FindTModel> findChreographiesIn,String opid);
    public void afterFindChoreographies(Wrapper<TModelList> findChreographiesOut,String opid);

    public void beforeGetChoreographyDetails(Wrapper<GetTModelDetail> getChereogaphyDetailsIn,String opid);
    public void afterGetChoreographyDetails(Wrapper<TModelDetail> getChereogaphyDetailsOut,String opid);

    public void beforeGetRolesInChoreography(Wrapper<GetTModelDetail> getRolesInChoreography,String opid);
    public void afterGetRolesInChoreography(Wrapper<TModelList> getRolesInChoreography,String opid);

    public void beforeFindParticipants(Wrapper<FindParticipantsIn> findParticipantsIn,String opid);
    public void afterFindParticipants(Wrapper<ServiceList> findParticipantsIn,String opid);
}

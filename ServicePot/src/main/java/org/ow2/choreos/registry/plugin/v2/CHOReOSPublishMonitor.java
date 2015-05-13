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
import org.ow2.choreos.registry.messages.AddChoreographyParticipantIn;
import org.ow2.choreos.registry.messages.RolesAndParticipantIn;
import org.ow2.choreos.registry.messages.SaveChoreographyIn;
import java.util.List;
import java.util.Map;
import org.uddi.api_v3.DeleteTModel;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.api_v3.TModel;
import org.uddi.api_v3.TModelDetail;

/**
 *
 * @author midhat
 */
@ServicePotPluginInterface
public interface CHOReOSPublishMonitor{

    
    public void beforeSaveChoreography(Wrapper<SaveChoreographyIn> saveChoreographyIn,String opid);
    public void afterProcessChoreography (Wrapper<Map<TModel, List<TModel>>> choreographiesAndRoles,String opid);
    public void afterSaveChoreography(Wrapper<TModelDetail> saveChoreographyOut,String opid);

    
    public void beforeAddChoreographyParticipant(Wrapper<AddChoreographyParticipantIn> addChoreographyParticipantIn,String opid);
    public void afterAddChoreographyParticipant(Wrapper<ServiceDetail> addChoreographyParticipantOut,String opid);

    
    public void beforeAddRolesToParticipant(Wrapper<RolesAndParticipantIn> addRoleToParticipantIn,String opid);
    public void  afterAddRolesToParticipant(Wrapper<ServiceDetail> addRoleToParticipantOut,String opid);
    
    public void beforeRemoveRolesFromParticipant(Wrapper<RolesAndParticipantIn> removeRoleFromParticipantIn,String opid);
    public  void afterRemoveRolesFromParticipant(Wrapper<ServiceDetail> removeRoleFromParticipantOut,String opid);

    
    public void beforeRemoveChoreography(Wrapper<DeleteTModel> removeChoreographyIn,String opid);
    public void afterRemoveChoreography(String opid);
    
}

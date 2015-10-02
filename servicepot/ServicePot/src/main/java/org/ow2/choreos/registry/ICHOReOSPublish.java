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
 * @(#) ICHOReOSPublish.java
 */

package org.ow2.choreos.registry;

import org.ow2.choreos.registry.messages.AddChoreographyParticipantIn;
import org.ow2.choreos.registry.messages.RolesAndParticipantIn;
import org.ow2.choreos.registry.messages.SaveChoreographyIn;
import org.uddi.api_v3.DeleteTModel;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.api_v3.TModelDetail;


public interface ICHOReOSPublish
{
	TModelDetail SaveChoreography( SaveChoreographyIn saveChoreographyIn );
	
	ServiceDetail AddChoreographyParticipant( AddChoreographyParticipantIn addChoreographyParticipantIn );
	
	ServiceDetail AddRolesToParticipant( RolesAndParticipantIn addRoleToParticipantIn );
	
	ServiceDetail RemoveRolesFromParticipant( RolesAndParticipantIn removeRoleFromParticipantIn );
	
	void RemoveChoreography( DeleteTModel removeChoreographyIn );
	
	
}

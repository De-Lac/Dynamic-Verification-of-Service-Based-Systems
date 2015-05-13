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
 * @(#) RolesAndParticipantIn.java
 */

package org.ow2.choreos.registry.messages;

import java.util.List;
import org.uddi.api_v3.AuthToken;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.TModel;

public class RolesAndParticipantIn
{
    /**
     * Required. List of roles to add to this service. Only TModelkey needs to be populated
     */
	private List<String> roles;
	
        /**
         * Required. Business Service to be changed
         */
	private String serviceKey;
	
	/**
         * Required. UDDI Authentication token.
         */
        private String authInfo;

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getServiceKey() {
        return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
        this.serviceKey = serviceKey;
    }
	
	
}

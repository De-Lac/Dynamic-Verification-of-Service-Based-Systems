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
 * @(#) AddChoreographyParticipantIn.java
 */
package org.ow2.choreos.registry.messages;

import java.util.List;
import org.uddi.api_v3.AuthToken;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.SaveService;
import org.uddi.api_v3.TModel;

public class AddChoreographyParticipantIn {

    /**
     * Required. Specifies TModel for an existing choreography. Only the
     * TModelKey needs to be populated
     */
    private String choreographyKey;
    /**
     * Required if newService is not specified. Specifies an existing service.
     * Only the ServiceKey needs to be populated
     */
    private String businessServiceKey;
    /**TModel
     * Required. Specifies TModels for existing roles. Only the TModelKey needs
     * to be populated.
     */
    private List<String> roleKeys;
    /**
     * Required if businessService is not specified. This object needs to be
     * populated as per the UDDI specification
     */
    private SaveService newService;
    /**
     * Required. The UDDI authentication token.
     */
    private String authInfo;

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getBusinessServiceKey() {
        return businessServiceKey;
    }

    public void setBusinessServiceKey(String businessServiceKey) {
        this.businessServiceKey = businessServiceKey;
    }

    public String getChoreographyKey() {
        return choreographyKey;
    }

    public void setChoreographyKey(String choreographyKey) {
        this.choreographyKey = choreographyKey;
    }

    public SaveService getNewService() {
        return newService;
    }

    public void setNewService(SaveService newService) {
        this.newService = newService;
    }

    public List<String> getRoleKeys() {
        return roleKeys;
    }

    public void setRoleKeys(List<String> roleKeys) {
        this.roleKeys = roleKeys;
    }

    
}

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
 * @(#) SaveChoreographyIn.java
 */

package org.ow2.choreos.registry.messages;

import org.uddi.api_v3.AuthToken;

public class SaveChoreographyIn
{
    /**
     * Optional. If a choreography name is specified, 
     * adds only the specified choreography to the registry.
     */
	private String ChoreographyName;
	
        /**
         * Required. URI to the BPMN2 description of the choreography. 
         * Choreography definition Must be in XML format as specified by the 
         * BPMN2 specification  (http://www.omg.org/spec/BPMN/2.0/)
        */
	private String ChoreographyURI;
	
        /**
         * Required. UDDI Authentication token.
         */
	private String authInfo;

    public String getChoreographyName() {
        return ChoreographyName;
    }

    public void setChoreographyName(String ChoreographyName) {
        this.ChoreographyName = ChoreographyName;
    }

    public String getChoreographyURI() {
        return ChoreographyURI;
    }

    public void setChoreographyURI(String ChoreographyURI) {
        this.ChoreographyURI = ChoreographyURI;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }
	
	
}

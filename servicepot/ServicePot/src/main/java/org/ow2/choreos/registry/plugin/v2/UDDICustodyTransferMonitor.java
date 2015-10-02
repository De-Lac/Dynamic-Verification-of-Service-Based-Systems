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
import org.uddi.custody_v3.DiscardTransferToken;
import org.uddi.custody_v3.GetTransferToken;
import org.uddi.custody_v3.TransferEntities;
import org.uddi.custody_v3.TransferToken;
import org.uddi.v3_service.UDDICustodyTransferPortType;

/**
 *
 * @author midhat
 */
@ServicePotPluginInterface
public interface UDDICustodyTransferMonitor{

    
    public void beforeTransferEntities(Wrapper<TransferEntities> body,String opid);
    public void afterTransferEntities(String opid);

    
    public void beforeDiscardTransferToken(Wrapper<DiscardTransferToken> body,String opid);
    public void afterDiscardTransferToken(String opid);
    
    public void beforeGetTransferToken(Wrapper<GetTransferToken> parameters,String opid);
    public void afterGetTransferToken(Wrapper<TransferToken> parameters,String opid);
    
}
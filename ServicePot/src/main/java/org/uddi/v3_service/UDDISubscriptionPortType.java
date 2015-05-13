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
package org.uddi.v3_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-02-02T15:16:44.079+01:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "urn:uddi-org:v3_service", name = "UDDI_Subscription_PortType")
@XmlSeeAlso({org.uddi.custody_v3.ObjectFactory.class, org.uddi.api_v3.ObjectFactory.class, org.uddi.repl_v3.ObjectFactory.class, org.uddi.sub_v3.ObjectFactory.class, org.uddi.vs_v3.ObjectFactory.class, org.uddi.policy_v3.ObjectFactory.class, org.uddi.vscache_v3.ObjectFactory.class, org.uddi.policy_v3_instanceparms.ObjectFactory.class, org.w3._2000._09.xmldsig.ObjectFactory.class, org.uddi.subr_v3.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UDDISubscriptionPortType {

    @WebResult(name = "subscriptionResultsList", targetNamespace = "urn:uddi-org:sub_v3", partName = "body")
    @WebMethod(operationName = "get_subscriptionResults", action = "get_subscriptionResults")
    public org.uddi.sub_v3.SubscriptionResultsList getSubscriptionResults(
        @WebParam(partName = "body", name = "get_subscriptionResults", targetNamespace = "urn:uddi-org:sub_v3")
        org.uddi.sub_v3.GetSubscriptionResults body
    );

    @WebResult(name = "subscriptions", targetNamespace = "urn:uddi-org:sub_v3", partName = "parameters")
    @WebMethod(operationName = "get_subscriptions", action = "get_subscriptions")
    public org.uddi.sub_v3.Subscriptions getSubscriptions(
        @WebParam(partName = "parameters", name = "get_subscriptions", targetNamespace = "urn:uddi-org:sub_v3")
        org.uddi.sub_v3.GetSubscriptions parameters
    );

    @WebMethod(operationName = "delete_subscription", action = "delete_subscription")
    public void deleteSubscription(
        @WebParam(partName = "body", name = "delete_subscription", targetNamespace = "urn:uddi-org:sub_v3")
        org.uddi.sub_v3.DeleteSubscription body
    );

    @WebResult(name = "subscriptions", targetNamespace = "urn:uddi-org:sub_v3", partName = "parameters")
    @WebMethod(operationName = "save_subscription", action = "save_subscription")
    public org.uddi.sub_v3.Subscriptions saveSubscription(
        @WebParam(partName = "parameters", name = "save_subscription", targetNamespace = "urn:uddi-org:sub_v3")
        org.uddi.sub_v3.SaveSubscription parameters
    );
}

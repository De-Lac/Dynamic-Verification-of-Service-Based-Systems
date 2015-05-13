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
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-02-02T15:15:57.398+01:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "urn:uddi-org:v3_service", name = "UDDI_Publication_PortType")
@XmlSeeAlso({org.uddi.custody_v3.ObjectFactory.class, org.uddi.api_v3.ObjectFactory.class, org.uddi.repl_v3.ObjectFactory.class, org.uddi.sub_v3.ObjectFactory.class, org.uddi.vs_v3.ObjectFactory.class, org.uddi.policy_v3.ObjectFactory.class, org.uddi.vscache_v3.ObjectFactory.class, org.uddi.policy_v3_instanceparms.ObjectFactory.class, org.w3._2000._09.xmldsig.ObjectFactory.class, org.uddi.subr_v3.ObjectFactory.class})
public interface UDDIPublicationPortType {

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod(operationName = "delete_binding", action = "delete_binding")
    public void deleteBinding(
        @WebParam(partName = "body", name = "delete_binding", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.DeleteBinding body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "tModelDetail", targetNamespace = "urn:uddi-org:api_v3", partName = "body")
    @WebMethod(operationName = "save_tModel", action = "save_tModel")
    public org.uddi.api_v3.TModelDetail saveTModel(
        @WebParam(partName = "body", name = "save_tModel", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.SaveTModel body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod(operationName = "add_publisherAssertions", action = "add_publisherAssertions")
    public void addPublisherAssertions(
        @WebParam(partName = "body", name = "add_publisherAssertions", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.AddPublisherAssertions body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod(operationName = "delete_business", action = "delete_business")
    public void deleteBusiness(
        @WebParam(partName = "body", name = "delete_business", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.DeleteBusiness body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "serviceDetail", targetNamespace = "urn:uddi-org:api_v3", partName = "body")
    @WebMethod(operationName = "save_service", action = "save_service")
    public org.uddi.api_v3.ServiceDetail saveService(
        @WebParam(partName = "body", name = "save_service", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.SaveService body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod(operationName = "delete_publisherAssertions", action = "delete_publisherAssertions")
    public void deletePublisherAssertions(
        @WebParam(partName = "body", name = "delete_publisherAssertions", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.DeletePublisherAssertions body
    );

    @RequestWrapper(localName = "set_publisherAssertions", targetNamespace = "urn:uddi-org:api_v3", className = "org.uddi.api_v3.SetPublisherAssertions")
    @WebMethod(operationName = "set_publisherAssertions", action = "set_publisherAssertions")
    @ResponseWrapper(localName = "publisherAssertions", targetNamespace = "urn:uddi-org:api_v3", className = "org.uddi.api_v3.PublisherAssertions")
    public void setPublisherAssertions(
        @WebParam(name = "authInfo", targetNamespace = "urn:uddi-org:api_v3")
        java.lang.String authInfo,
        @WebParam(mode = WebParam.Mode.INOUT, name = "publisherAssertion", targetNamespace = "urn:uddi-org:api_v3")
        javax.xml.ws.Holder<java.util.List<org.uddi.api_v3.PublisherAssertion>> publisherAssertion
    );

    @WebResult(name = "publisherAssertion", targetNamespace = "urn:uddi-org:api_v3")
    @RequestWrapper(localName = "get_publisherAssertions", targetNamespace = "urn:uddi-org:api_v3", className = "org.uddi.api_v3.GetPublisherAssertions")
    @WebMethod(operationName = "get_publisherAssertions", action = "get_publisherAssertions")
    @ResponseWrapper(localName = "publisherAssertionsResponse", targetNamespace = "urn:uddi-org:api_v3", className = "org.uddi.api_v3.PublisherAssertionsResponse")
    public java.util.List<org.uddi.api_v3.PublisherAssertion> getPublisherAssertions(
        @WebParam(name = "authInfo", targetNamespace = "urn:uddi-org:api_v3")
        java.lang.String authInfo
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod(operationName = "delete_service", action = "delete_service")
    public void deleteService(
        @WebParam(partName = "body", name = "delete_service", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.DeleteService body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "bindingDetail", targetNamespace = "urn:uddi-org:api_v3", partName = "body")
    @WebMethod(operationName = "save_binding", action = "save_binding")
    public org.uddi.api_v3.BindingDetail saveBinding(
        @WebParam(partName = "body", name = "save_binding", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.SaveBinding body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "businessDetail", targetNamespace = "urn:uddi-org:api_v3", partName = "body")
    @WebMethod(operationName = "save_business", action = "save_business")
    public org.uddi.api_v3.BusinessDetail saveBusiness(
        @WebParam(partName = "body", name = "save_business", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.SaveBusiness body
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "registeredInfo", targetNamespace = "urn:uddi-org:api_v3", partName = "body")
    @WebMethod(operationName = "get_registeredInfo", action = "get_registeredInfo")
    public org.uddi.api_v3.RegisteredInfo getRegisteredInfo(
        @WebParam(partName = "body", name = "get_registeredInfo", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.GetRegisteredInfo body
    );

    @WebResult(name = "assertionStatusItem", targetNamespace = "urn:uddi-org:api_v3")
    @RequestWrapper(localName = "get_assertionStatusReport", targetNamespace = "urn:uddi-org:api_v3", className = "org.uddi.api_v3.GetAssertionStatusReport")
    @WebMethod(operationName = "get_assertionStatusReport", action = "get_assertionStatusReport")
    @ResponseWrapper(localName = "assertionStatusReport", targetNamespace = "urn:uddi-org:api_v3", className = "org.uddi.api_v3.AssertionStatusReport")
    public java.util.List<org.uddi.api_v3.AssertionStatusItem> getAssertionStatusReport(
        @WebParam(name = "authInfo", targetNamespace = "urn:uddi-org:api_v3")
        java.lang.String authInfo,
        @WebParam(name = "completionStatus", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.CompletionStatus completionStatus
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod(operationName = "delete_tModel", action = "delete_tModel")
    public void deleteTModel(
        @WebParam(partName = "body", name = "delete_tModel", targetNamespace = "urn:uddi-org:api_v3")
        org.uddi.api_v3.DeleteTModel body
    );
}
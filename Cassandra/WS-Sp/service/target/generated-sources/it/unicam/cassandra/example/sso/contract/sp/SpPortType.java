package it.unicam.cassandra.example.sso.contract.sp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2015-01-22T15:59:20.236+01:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", name = "SpPortType")
@XmlSeeAlso({ObjectFactory.class})
public interface SpPortType {

    @WebMethod(action = "http://www.unicam.it/cassandra/example/sso/contract/Sp/identified")
    @RequestWrapper(localName = "identified", targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", className = "it.unicam.cassandra.example.sso.contract.sp.Identified")
    @ResponseWrapper(localName = "identifiedResponse", targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", className = "it.unicam.cassandra.example.sso.contract.sp.IdentifiedResponse")
    @WebResult(name = "out", targetNamespace = "")
    public java.lang.String identified(
        @WebParam(name = "resourceId", targetNamespace = "")
        int resourceId,
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token
    );

    @WebMethod(action = "http://www.unicam.it/cassandra/example/sso/contract/Sp/requestResource")
    @RequestWrapper(localName = "requestResource", targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", className = "it.unicam.cassandra.example.sso.contract.sp.RequestResource")
    @ResponseWrapper(localName = "requestResourceResponse", targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", className = "it.unicam.cassandra.example.sso.contract.sp.RequestResourceResponse")
    @WebResult(name = "resourceAvailable", targetNamespace = "")
    public java.lang.String requestResource(
        @WebParam(name = "resourceId", targetNamespace = "")
        int resourceId
    );

    @WebMethod(action = "http://www.unicam.it/cassandra/example/sso/contract/Sp/notIdentified")
    @RequestWrapper(localName = "notIdentified", targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", className = "it.unicam.cassandra.example.sso.contract.sp.NotIdentified")
    @ResponseWrapper(localName = "notIdentifiedResponse", targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/Sp", className = "it.unicam.cassandra.example.sso.contract.sp.NotIdentifiedResponse")
    @WebResult(name = "out", targetNamespace = "")
    public java.lang.String notIdentified(
        @WebParam(name = "in", targetNamespace = "")
        java.lang.String in
    );
}
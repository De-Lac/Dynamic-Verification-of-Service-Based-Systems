
package it.unicam.cassandra.example.sso.contract.sp;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.unicam.cassandra.example.sso.contract.sp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unicam.cassandra.example.sso.contract.sp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestResource }
     * 
     */
    public RequestResource createRequestResource() {
        return new RequestResource();
    }

    /**
     * Create an instance of {@link IdentifiedResponse }
     * 
     */
    public IdentifiedResponse createIdentifiedResponse() {
        return new IdentifiedResponse();
    }

    /**
     * Create an instance of {@link NotIdentified }
     * 
     */
    public NotIdentified createNotIdentified() {
        return new NotIdentified();
    }

    /**
     * Create an instance of {@link Identified }
     * 
     */
    public Identified createIdentified() {
        return new Identified();
    }

    /**
     * Create an instance of {@link NotIdentifiedResponse }
     * 
     */
    public NotIdentifiedResponse createNotIdentifiedResponse() {
        return new NotIdentifiedResponse();
    }

    /**
     * Create an instance of {@link RequestResourceResponse }
     * 
     */
    public RequestResourceResponse createRequestResourceResponse() {
        return new RequestResourceResponse();
    }

}

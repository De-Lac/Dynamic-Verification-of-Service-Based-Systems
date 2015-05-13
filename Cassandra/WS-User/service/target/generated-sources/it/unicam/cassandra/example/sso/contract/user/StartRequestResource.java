
package it.unicam.cassandra.example.sso.contract.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resourceId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serviceProviderServer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resourceId",
    "serviceProviderServer"
})
@XmlRootElement(name = "startRequestResource")
public class StartRequestResource {

    protected int resourceId;
    @XmlElement(required = true)
    protected String serviceProviderServer;

    /**
     * Recupera il valore della proprietà resourceId.
     * 
     */
    public int getResourceId() {
        return resourceId;
    }

    /**
     * Imposta il valore della proprietà resourceId.
     * 
     */
    public void setResourceId(int value) {
        this.resourceId = value;
    }

    /**
     * Recupera il valore della proprietà serviceProviderServer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProviderServer() {
        return serviceProviderServer;
    }

    /**
     * Imposta il valore della proprietà serviceProviderServer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProviderServer(String value) {
        this.serviceProviderServer = value;
    }

}

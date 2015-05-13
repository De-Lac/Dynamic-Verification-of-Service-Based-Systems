
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
 *         &lt;element name="resourceAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "resourceAvailable"
})
@XmlRootElement(name = "startRequestResourceResponse")
public class StartRequestResourceResponse {

    @XmlElement(required = true)
    protected String resourceAvailable;

    /**
     * Recupera il valore della proprietà resourceAvailable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceAvailable() {
        return resourceAvailable;
    }

    /**
     * Imposta il valore della proprietà resourceAvailable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceAvailable(String value) {
        this.resourceAvailable = value;
    }

}

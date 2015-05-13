
package it.unicam.cassandra.example.sso.schema.idp;

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
 *         &lt;element name="doubledNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "doubledNumber"
})
@XmlRootElement(name = "authenticationResponse")
public class AuthenticationResponse {

    @XmlElement(required = true)
    protected String doubledNumber;

    /**
     * Recupera il valore della proprietà doubledNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoubledNumber() {
        return doubledNumber;
    }

    /**
     * Imposta il valore della proprietà doubledNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoubledNumber(String value) {
        this.doubledNumber = value;
    }

}

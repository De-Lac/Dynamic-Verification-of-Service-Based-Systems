
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
 *         &lt;element name="numberToDouble" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "numberToDouble"
})
@XmlRootElement(name = "authentication")
public class Authentication {

    @XmlElement(required = true)
    protected String numberToDouble;

    /**
     * Recupera il valore della proprietà numberToDouble.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberToDouble() {
        return numberToDouble;
    }

    /**
     * Imposta il valore della proprietà numberToDouble.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberToDouble(String value) {
        this.numberToDouble = value;
    }

}

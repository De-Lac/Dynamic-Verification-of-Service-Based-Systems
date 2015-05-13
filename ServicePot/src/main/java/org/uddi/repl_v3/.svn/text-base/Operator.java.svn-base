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
package org.uddi.repl_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.uddi.api_v3.Contact;
import org.w3._2000._09.xmldsig.KeyInfoType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operatorNodeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operatorStatus" type="{urn:uddi-org:repl_v3}operatorStatus_type"/>
 *         &lt;element name="contact" type="{urn:uddi-org:api_v3}contact" maxOccurs="unbounded"/>
 *         &lt;element name="soapReplicationURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="KeyInfo" type="{http://www.w3.org/2000/09/xmldsig#}KeyInfoType" maxOccurs="unbounded" minOccurs="0"/>
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
    "operatorNodeID",
    "operatorStatus",
    "contact",
    "soapReplicationURL",
    "keyInfo"
})
@XmlRootElement(name = "operator")
public class Operator {

    @XmlElement(required = true)
    protected String operatorNodeID;
    @XmlElement(required = true)
    protected OperatorStatusType operatorStatus;
    @XmlElement(required = true)
    protected List<Contact> contact;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String soapReplicationURL;
    @XmlElement(name = "KeyInfo")
    protected List<KeyInfoType> keyInfo;

    /**
     * Gets the value of the operatorNodeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorNodeID() {
        return operatorNodeID;
    }

    /**
     * Sets the value of the operatorNodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorNodeID(String value) {
        this.operatorNodeID = value;
    }

    /**
     * Gets the value of the operatorStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorStatusType }
     *     
     */
    public OperatorStatusType getOperatorStatus() {
        return operatorStatus;
    }

    /**
     * Sets the value of the operatorStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorStatusType }
     *     
     */
    public void setOperatorStatus(OperatorStatusType value) {
        this.operatorStatus = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contact }
     * 
     * 
     */
    public List<Contact> getContact() {
        if (contact == null) {
            contact = new ArrayList<Contact>();
        }
        return this.contact;
    }

    /**
     * Gets the value of the soapReplicationURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoapReplicationURL() {
        return soapReplicationURL;
    }

    /**
     * Sets the value of the soapReplicationURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoapReplicationURL(String value) {
        this.soapReplicationURL = value;
    }

    /**
     * Gets the value of the keyInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyInfoType }
     * 
     * 
     */
    public List<KeyInfoType> getKeyInfo() {
        if (keyInfo == null) {
            keyInfo = new ArrayList<KeyInfoType>();
        }
        return this.keyInfo;
    }

}

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

import java.math.BigInteger;
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
import org.w3._2000._09.xmldsig.SignatureType;


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
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="timeOfConfigurationUpdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="registryContact">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="contact" type="{urn:uddi-org:api_v3}contact"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="operator" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="operatorNodeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="operatorStatus" type="{urn:uddi-org:repl_v3}operatorStatus_type"/>
 *                   &lt;element name="contact" type="{urn:uddi-org:api_v3}contact" maxOccurs="unbounded"/>
 *                   &lt;element name="soapReplicationURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *                   &lt;element name="KeyInfo" type="{http://www.w3.org/2000/09/xmldsig#}KeyInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:uddi-org:repl_v3}communicationGraph" minOccurs="0"/>
 *         &lt;element name="maximumTimeToSyncRegistry" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="maximumTimeToGetChanges" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Signature" type="{http://www.w3.org/2000/09/xmldsig#}SignatureType" maxOccurs="unbounded" minOccurs="0"/>
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
    "serialNumber",
    "timeOfConfigurationUpdate",
    "registryContact",
    "operator",
    "communicationGraph",
    "maximumTimeToSyncRegistry",
    "maximumTimeToGetChanges",
    "signature"
})
@XmlRootElement(name = "replicationConfiguration")
public class ReplicationConfiguration {

    protected long serialNumber;
    @XmlElement(required = true)
    protected String timeOfConfigurationUpdate;
    @XmlElement(required = true)
    protected ReplicationConfiguration.RegistryContact registryContact;
    @XmlElement(nillable = true)
    protected List<ReplicationConfiguration.Operator> operator;
    protected CommunicationGraph communicationGraph;
    protected BigInteger maximumTimeToSyncRegistry;
    @XmlElement(required = true)
    protected BigInteger maximumTimeToGetChanges;
    @XmlElement(name = "Signature")
    protected List<SignatureType> signature;

    /**
     * Gets the value of the serialNumber property.
     * 
     */
    public long getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     */
    public void setSerialNumber(long value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the timeOfConfigurationUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOfConfigurationUpdate() {
        return timeOfConfigurationUpdate;
    }

    /**
     * Sets the value of the timeOfConfigurationUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOfConfigurationUpdate(String value) {
        this.timeOfConfigurationUpdate = value;
    }

    /**
     * Gets the value of the registryContact property.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationConfiguration.RegistryContact }
     *     
     */
    public ReplicationConfiguration.RegistryContact getRegistryContact() {
        return registryContact;
    }

    /**
     * Sets the value of the registryContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationConfiguration.RegistryContact }
     *     
     */
    public void setRegistryContact(ReplicationConfiguration.RegistryContact value) {
        this.registryContact = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReplicationConfiguration.Operator }
     * 
     * 
     */
    public List<ReplicationConfiguration.Operator> getOperator() {
        if (operator == null) {
            operator = new ArrayList<ReplicationConfiguration.Operator>();
        }
        return this.operator;
    }

    /**
     * Gets the value of the communicationGraph property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationGraph }
     *     
     */
    public CommunicationGraph getCommunicationGraph() {
        return communicationGraph;
    }

    /**
     * Sets the value of the communicationGraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationGraph }
     *     
     */
    public void setCommunicationGraph(CommunicationGraph value) {
        this.communicationGraph = value;
    }

    /**
     * Gets the value of the maximumTimeToSyncRegistry property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumTimeToSyncRegistry() {
        return maximumTimeToSyncRegistry;
    }

    /**
     * Sets the value of the maximumTimeToSyncRegistry property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumTimeToSyncRegistry(BigInteger value) {
        this.maximumTimeToSyncRegistry = value;
    }

    /**
     * Gets the value of the maximumTimeToGetChanges property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumTimeToGetChanges() {
        return maximumTimeToGetChanges;
    }

    /**
     * Sets the value of the maximumTimeToGetChanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumTimeToGetChanges(BigInteger value) {
        this.maximumTimeToGetChanges = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureType }
     * 
     * 
     */
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
    }


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
    public static class Operator {

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
     *         &lt;element name="contact" type="{urn:uddi-org:api_v3}contact"/>
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
        "contact"
    })
    public static class RegistryContact {

        @XmlElement(required = true)
        protected Contact contact;

        /**
         * Gets the value of the contact property.
         * 
         * @return
         *     possible object is
         *     {@link Contact }
         *     
         */
        public Contact getContact() {
            return contact;
        }

        /**
         * Sets the value of the contact property.
         * 
         * @param value
         *     allowed object is
         *     {@link Contact }
         *     
         */
        public void setContact(Contact value) {
            this.contact = value;
        }

    }

}

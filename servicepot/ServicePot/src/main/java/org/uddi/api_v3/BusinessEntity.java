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
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig.SignatureType;


/**
 * <p>Java class for businessEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="businessEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="discoveryURLs" type="{urn:uddi-org:api_v3}discoveryURLs" minOccurs="0"/>
 *         &lt;element name="name" type="{urn:uddi-org:api_v3}name" maxOccurs="unbounded"/>
 *         &lt;element name="description" type="{urn:uddi-org:api_v3}description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contacts" type="{urn:uddi-org:api_v3}contacts" minOccurs="0"/>
 *         &lt;element name="businessServices" type="{urn:uddi-org:api_v3}businessServices" minOccurs="0"/>
 *         &lt;element name="identifierBag" type="{urn:uddi-org:api_v3}identifierBag" minOccurs="0"/>
 *         &lt;element name="categoryBag" type="{urn:uddi-org:api_v3}categoryBag" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="businessKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "businessEntity", propOrder = {
    "discoveryURLs",
    "name",
    "description",
    "contacts",
    "businessServices",
    "identifierBag",
    "categoryBag",
    "signature"
})
public class BusinessEntity {

    protected DiscoveryURLs discoveryURLs;
    @XmlElement(required = true)
    protected List<Name> name;
    @XmlElement(nillable = true)
    protected List<Description> description;
    protected Contacts contacts;
    protected BusinessServices businessServices;
    protected IdentifierBag identifierBag;
    protected CategoryBag categoryBag;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected List<SignatureType> signature;
    @XmlAttribute(name = "businessKey")
    protected String businessKey;

    /**
     * Gets the value of the discoveryURLs property.
     * 
     * @return
     *     possible object is
     *     {@link DiscoveryURLs }
     *     
     */
    public DiscoveryURLs getDiscoveryURLs() {
        return discoveryURLs;
    }

    /**
     * Sets the value of the discoveryURLs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscoveryURLs }
     *     
     */
    public void setDiscoveryURLs(DiscoveryURLs value) {
        this.discoveryURLs = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * 
     * 
     */
    public List<Name> getName() {
        if (name == null) {
            name = new ArrayList<Name>();
        }
        return this.name;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description }
     * 
     * 
     */
    public List<Description> getDescription() {
        if (description == null) {
            description = new ArrayList<Description>();
        }
        return this.description;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * @return
     *     possible object is
     *     {@link Contacts }
     *     
     */
    public Contacts getContacts() {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contacts }
     *     
     */
    public void setContacts(Contacts value) {
        this.contacts = value;
    }

    /**
     * Gets the value of the businessServices property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessServices }
     *     
     */
    public BusinessServices getBusinessServices() {
        return businessServices;
    }

    /**
     * Sets the value of the businessServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessServices }
     *     
     */
    public void setBusinessServices(BusinessServices value) {
        this.businessServices = value;
    }

    /**
     * Gets the value of the identifierBag property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierBag }
     *     
     */
    public IdentifierBag getIdentifierBag() {
        return identifierBag;
    }

    /**
     * Sets the value of the identifierBag property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierBag }
     *     
     */
    public void setIdentifierBag(IdentifierBag value) {
        this.identifierBag = value;
    }

    /**
     * Gets the value of the categoryBag property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryBag }
     *     
     */
    public CategoryBag getCategoryBag() {
        return categoryBag;
    }

    /**
     * Sets the value of the categoryBag property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryBag }
     *     
     */
    public void setCategoryBag(CategoryBag value) {
        this.categoryBag = value;
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
     * Gets the value of the businessKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessKey() {
        return businessKey;
    }

    /**
     * Sets the value of the businessKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessKey(String value) {
        this.businessKey = value;
    }

}

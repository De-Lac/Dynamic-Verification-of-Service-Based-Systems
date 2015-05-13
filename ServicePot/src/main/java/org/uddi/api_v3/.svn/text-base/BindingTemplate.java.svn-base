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
 * <p>Java class for bindingTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bindingTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{urn:uddi-org:api_v3}description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accessPoint" type="{urn:uddi-org:api_v3}accessPoint" minOccurs="0"/>
 *         &lt;element name="hostingRedirector" type="{urn:uddi-org:api_v3}hostingRedirector" minOccurs="0"/>
 *         &lt;element name="tModelInstanceDetails" type="{urn:uddi-org:api_v3}tModelInstanceDetails" minOccurs="0"/>
 *         &lt;element name="categoryBag" type="{urn:uddi-org:api_v3}categoryBag" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="bindingKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serviceKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bindingTemplate", propOrder = {
    "description",
    "accessPoint",
    "hostingRedirector",
    "tModelInstanceDetails",
    "categoryBag",
    "signature"
})
public class BindingTemplate {

    @XmlElement(nillable = true)
    protected List<Description> description;
    protected AccessPoint accessPoint;
    protected HostingRedirector hostingRedirector;
    protected TModelInstanceDetails tModelInstanceDetails;
    protected CategoryBag categoryBag;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected List<SignatureType> signature;
    @XmlAttribute(name = "bindingKey")
    protected String bindingKey;
    @XmlAttribute(name = "serviceKey")
    protected String serviceKey;

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
     * Gets the value of the accessPoint property.
     * 
     * @return
     *     possible object is
     *     {@link AccessPoint }
     *     
     */
    public AccessPoint getAccessPoint() {
        return accessPoint;
    }

    /**
     * Sets the value of the accessPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessPoint }
     *     
     */
    public void setAccessPoint(AccessPoint value) {
        this.accessPoint = value;
    }

    /**
     * Gets the value of the hostingRedirector property.
     * 
     * @return
     *     possible object is
     *     {@link HostingRedirector }
     *     
     */
    public HostingRedirector getHostingRedirector() {
        return hostingRedirector;
    }

    /**
     * Sets the value of the hostingRedirector property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostingRedirector }
     *     
     */
    public void setHostingRedirector(HostingRedirector value) {
        this.hostingRedirector = value;
    }

    /**
     * Gets the value of the tModelInstanceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TModelInstanceDetails }
     *     
     */
    public TModelInstanceDetails getTModelInstanceDetails() {
        return tModelInstanceDetails;
    }

    /**
     * Sets the value of the tModelInstanceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TModelInstanceDetails }
     *     
     */
    public void setTModelInstanceDetails(TModelInstanceDetails value) {
        this.tModelInstanceDetails = value;
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
     * Gets the value of the bindingKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBindingKey() {
        return bindingKey;
    }

    /**
     * Sets the value of the bindingKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBindingKey(String value) {
        this.bindingKey = value;
    }

    /**
     * Gets the value of the serviceKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceKey() {
        return serviceKey;
    }

    /**
     * Sets the value of the serviceKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceKey(String value) {
        this.serviceKey = value;
    }

}

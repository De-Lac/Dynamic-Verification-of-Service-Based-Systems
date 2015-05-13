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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for find_binding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="find_binding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="findQualifiers" type="{urn:uddi-org:api_v3}findQualifiers" minOccurs="0"/>
 *         &lt;element name="tModelBag" type="{urn:uddi-org:api_v3}tModelBag" minOccurs="0"/>
 *         &lt;element name="find_tModel" type="{urn:uddi-org:api_v3}find_tModel" minOccurs="0"/>
 *         &lt;element name="categoryBag" type="{urn:uddi-org:api_v3}categoryBag" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="maxRows" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="serviceKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="listHead" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "find_binding", propOrder = {
    "authInfo",
    "findQualifiers",
    "tModelBag",
    "findTModel",
    "categoryBag"
})
public class FindBinding {

    protected String authInfo;
    protected FindQualifiers findQualifiers;
    protected TModelBag tModelBag;
    @XmlElement(name = "find_tModel")
    protected FindTModel findTModel;
    protected CategoryBag categoryBag;
    @XmlAttribute(name = "maxRows")
    protected Integer maxRows;
    @XmlAttribute(name = "serviceKey")
    protected String serviceKey;
    @XmlAttribute(name = "listHead")
    protected Integer listHead;

    /**
     * Gets the value of the authInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthInfo() {
        return authInfo;
    }

    /**
     * Sets the value of the authInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthInfo(String value) {
        this.authInfo = value;
    }

    /**
     * Gets the value of the findQualifiers property.
     * 
     * @return
     *     possible object is
     *     {@link FindQualifiers }
     *     
     */
    public FindQualifiers getFindQualifiers() {
        return findQualifiers;
    }

    /**
     * Sets the value of the findQualifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindQualifiers }
     *     
     */
    public void setFindQualifiers(FindQualifiers value) {
        this.findQualifiers = value;
    }

    /**
     * Gets the value of the tModelBag property.
     * 
     * @return
     *     possible object is
     *     {@link TModelBag }
     *     
     */
    public TModelBag getTModelBag() {
        return tModelBag;
    }

    /**
     * Sets the value of the tModelBag property.
     * 
     * @param value
     *     allowed object is
     *     {@link TModelBag }
     *     
     */
    public void setTModelBag(TModelBag value) {
        this.tModelBag = value;
    }

    /**
     * Gets the value of the findTModel property.
     * 
     * @return
     *     possible object is
     *     {@link FindTModel }
     *     
     */
    public FindTModel getFindTModel() {
        return findTModel;
    }

    /**
     * Sets the value of the findTModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindTModel }
     *     
     */
    public void setFindTModel(FindTModel value) {
        this.findTModel = value;
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
     * Gets the value of the maxRows property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRows() {
        return maxRows;
    }

    /**
     * Sets the value of the maxRows property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRows(Integer value) {
        this.maxRows = value;
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

    /**
     * Gets the value of the listHead property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getListHead() {
        return listHead;
    }

    /**
     * Sets the value of the listHead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setListHead(Integer value) {
        this.listHead = value;
    }

}

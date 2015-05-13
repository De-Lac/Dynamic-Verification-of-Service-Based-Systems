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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operationalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operationalInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="modifiedIncludingChildren" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="nodeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="entityKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operationalInfo", propOrder = {
    "created",
    "modified",
    "modifiedIncludingChildren",
    "nodeID",
    "authorizedName"
})
public class OperationalInfo {

    @XmlSchemaType(name = "anySimpleType")
    protected Object created;
    @XmlSchemaType(name = "anySimpleType")
    protected Object modified;
    @XmlSchemaType(name = "anySimpleType")
    protected Object modifiedIncludingChildren;
    protected String nodeID;
    protected String authorizedName;
    @XmlAttribute(name = "entityKey", required = true)
    protected String entityKey;

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCreated(Object value) {
        this.created = value;
    }

    /**
     * Gets the value of the modified property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getModified() {
        return modified;
    }

    /**
     * Sets the value of the modified property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setModified(Object value) {
        this.modified = value;
    }

    /**
     * Gets the value of the modifiedIncludingChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getModifiedIncludingChildren() {
        return modifiedIncludingChildren;
    }

    /**
     * Sets the value of the modifiedIncludingChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setModifiedIncludingChildren(Object value) {
        this.modifiedIncludingChildren = value;
    }

    /**
     * Gets the value of the nodeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeID() {
        return nodeID;
    }

    /**
     * Sets the value of the nodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeID(String value) {
        this.nodeID = value;
    }

    /**
     * Gets the value of the authorizedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedName() {
        return authorizedName;
    }

    /**
     * Sets the value of the authorizedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedName(String value) {
        this.authorizedName = value;
    }

    /**
     * Gets the value of the entityKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityKey() {
        return entityKey;
    }

    /**
     * Sets the value of the entityKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityKey(String value) {
        this.entityKey = value;
    }

}

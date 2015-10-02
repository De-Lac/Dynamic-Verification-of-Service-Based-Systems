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
 * <p>Java class for assertionStatusItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assertionStatusItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keyedReference" type="{urn:uddi-org:api_v3}keyedReference"/>
 *         &lt;element name="keysOwned" type="{urn:uddi-org:api_v3}keysOwned"/>
 *       &lt;/sequence>
 *       &lt;attribute name="completionStatus" use="required" type="{urn:uddi-org:api_v3}completionStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assertionStatusItem", propOrder = {
    "fromKey",
    "toKey",
    "keyedReference",
    "keysOwned"
})
public class AssertionStatusItem {

    @XmlElement(required = true)
    protected String fromKey;
    @XmlElement(required = true)
    protected String toKey;
    @XmlElement(required = true)
    protected KeyedReference keyedReference;
    @XmlElement(required = true)
    protected KeysOwned keysOwned;
    @XmlAttribute(name = "completionStatus", required = true)
    protected CompletionStatus completionStatus;

    /**
     * Gets the value of the fromKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromKey() {
        return fromKey;
    }

    /**
     * Sets the value of the fromKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromKey(String value) {
        this.fromKey = value;
    }

    /**
     * Gets the value of the toKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToKey() {
        return toKey;
    }

    /**
     * Sets the value of the toKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToKey(String value) {
        this.toKey = value;
    }

    /**
     * Gets the value of the keyedReference property.
     * 
     * @return
     *     possible object is
     *     {@link KeyedReference }
     *     
     */
    public KeyedReference getKeyedReference() {
        return keyedReference;
    }

    /**
     * Sets the value of the keyedReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyedReference }
     *     
     */
    public void setKeyedReference(KeyedReference value) {
        this.keyedReference = value;
    }

    /**
     * Gets the value of the keysOwned property.
     * 
     * @return
     *     possible object is
     *     {@link KeysOwned }
     *     
     */
    public KeysOwned getKeysOwned() {
        return keysOwned;
    }

    /**
     * Sets the value of the keysOwned property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeysOwned }
     *     
     */
    public void setKeysOwned(KeysOwned value) {
        this.keysOwned = value;
    }

    /**
     * Gets the value of the completionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CompletionStatus }
     *     
     */
    public CompletionStatus getCompletionStatus() {
        return completionStatus;
    }

    /**
     * Sets the value of the completionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletionStatus }
     *     
     */
    public void setCompletionStatus(CompletionStatus value) {
        this.completionStatus = value;
    }

}

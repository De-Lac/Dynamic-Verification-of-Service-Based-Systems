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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.uddi.api_v3.PublisherAssertion;


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
 *         &lt;element ref="{urn:uddi-org:api_v3}publisherAssertion"/>
 *         &lt;element name="fromBusinessCheck" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toBusinessCheck" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element ref="{urn:uddi-org:repl_v3}fromSignatures" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:repl_v3}toSignatures" minOccurs="0"/>
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
    "publisherAssertion",
    "fromBusinessCheck",
    "toBusinessCheck",
    "modified",
    "fromSignatures",
    "toSignatures"
})
@XmlRootElement(name = "changeRecordPublisherAssertion")
public class ChangeRecordPublisherAssertion {

    @XmlElement(namespace = "urn:uddi-org:api_v3", required = true)
    protected PublisherAssertion publisherAssertion;
    protected boolean fromBusinessCheck;
    protected boolean toBusinessCheck;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object modified;
    protected FromSignatures fromSignatures;
    protected ToSignatures toSignatures;

    /**
     * Gets the value of the publisherAssertion property.
     * 
     * @return
     *     possible object is
     *     {@link PublisherAssertion }
     *     
     */
    public PublisherAssertion getPublisherAssertion() {
        return publisherAssertion;
    }

    /**
     * Sets the value of the publisherAssertion property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublisherAssertion }
     *     
     */
    public void setPublisherAssertion(PublisherAssertion value) {
        this.publisherAssertion = value;
    }

    /**
     * Gets the value of the fromBusinessCheck property.
     * 
     */
    public boolean isFromBusinessCheck() {
        return fromBusinessCheck;
    }

    /**
     * Sets the value of the fromBusinessCheck property.
     * 
     */
    public void setFromBusinessCheck(boolean value) {
        this.fromBusinessCheck = value;
    }

    /**
     * Gets the value of the toBusinessCheck property.
     * 
     */
    public boolean isToBusinessCheck() {
        return toBusinessCheck;
    }

    /**
     * Sets the value of the toBusinessCheck property.
     * 
     */
    public void setToBusinessCheck(boolean value) {
        this.toBusinessCheck = value;
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
     * Gets the value of the fromSignatures property.
     * 
     * @return
     *     possible object is
     *     {@link FromSignatures }
     *     
     */
    public FromSignatures getFromSignatures() {
        return fromSignatures;
    }

    /**
     * Sets the value of the fromSignatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link FromSignatures }
     *     
     */
    public void setFromSignatures(FromSignatures value) {
        this.fromSignatures = value;
    }

    /**
     * Gets the value of the toSignatures property.
     * 
     * @return
     *     possible object is
     *     {@link ToSignatures }
     *     
     */
    public ToSignatures getToSignatures() {
        return toSignatures;
    }

    /**
     * Sets the value of the toSignatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToSignatures }
     *     
     */
    public void setToSignatures(ToSignatures value) {
        this.toSignatures = value;
    }

}

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
package org.uddi.sub_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for subscription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriptionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriptionFilter" type="{urn:uddi-org:sub_v3}subscriptionFilter" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}bindingKey" minOccurs="0"/>
 *         &lt;element name="notificationInterval" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="maxEntities" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="expiresAfter" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="brief" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscription", propOrder = {
    "subscriptionKey",
    "subscriptionFilter",
    "bindingKey",
    "notificationInterval",
    "maxEntities",
    "expiresAfter"
})
public class Subscription {

    protected String subscriptionKey;
    protected SubscriptionFilter subscriptionFilter;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected String bindingKey;
    protected Duration notificationInterval;
    protected Integer maxEntities;
    @XmlSchemaType(name = "anySimpleType")
    protected Object expiresAfter;
    @XmlAttribute(name = "brief")
    protected Boolean brief;

    /**
     * Gets the value of the subscriptionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionKey() {
        return subscriptionKey;
    }

    /**
     * Sets the value of the subscriptionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionKey(String value) {
        this.subscriptionKey = value;
    }

    /**
     * Gets the value of the subscriptionFilter property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionFilter }
     *     
     */
    public SubscriptionFilter getSubscriptionFilter() {
        return subscriptionFilter;
    }

    /**
     * Sets the value of the subscriptionFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionFilter }
     *     
     */
    public void setSubscriptionFilter(SubscriptionFilter value) {
        this.subscriptionFilter = value;
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
     * Gets the value of the notificationInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getNotificationInterval() {
        return notificationInterval;
    }

    /**
     * Sets the value of the notificationInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setNotificationInterval(Duration value) {
        this.notificationInterval = value;
    }

    /**
     * Gets the value of the maxEntities property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxEntities() {
        return maxEntities;
    }

    /**
     * Sets the value of the maxEntities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxEntities(Integer value) {
        this.maxEntities = value;
    }

    /**
     * Gets the value of the expiresAfter property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getExpiresAfter() {
        return expiresAfter;
    }

    /**
     * Sets the value of the expiresAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setExpiresAfter(Object value) {
        this.expiresAfter = value;
    }

    /**
     * Gets the value of the brief property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBrief() {
        return brief;
    }

    /**
     * Sets the value of the brief property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBrief(Boolean value) {
        this.brief = value;
    }

}

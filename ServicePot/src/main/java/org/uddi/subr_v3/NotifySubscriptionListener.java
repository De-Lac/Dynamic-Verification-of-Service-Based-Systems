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
package org.uddi.subr_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.sub_v3.SubscriptionResultsList;


/**
 * <p>Java class for notify_subscriptionListener complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notify_subscriptionListener">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}authInfo" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:sub_v3}subscriptionResultsList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notify_subscriptionListener", propOrder = {
    "authInfo",
    "subscriptionResultsList"
})
public class NotifySubscriptionListener {

    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected String authInfo;
    @XmlElement(namespace = "urn:uddi-org:sub_v3", required = true)
    protected SubscriptionResultsList subscriptionResultsList;

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
     * Gets the value of the subscriptionResultsList property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionResultsList }
     *     
     */
    public SubscriptionResultsList getSubscriptionResultsList() {
        return subscriptionResultsList;
    }

    /**
     * Sets the value of the subscriptionResultsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionResultsList }
     *     
     */
    public void setSubscriptionResultsList(SubscriptionResultsList value) {
        this.subscriptionResultsList = value;
    }

}

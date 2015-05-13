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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_subscriptionResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_subscriptionResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}authInfo" minOccurs="0"/>
 *         &lt;element name="subscriptionKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coveragePeriod" type="{urn:uddi-org:sub_v3}coveragePeriod"/>
 *         &lt;element name="chunkToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_subscriptionResults", propOrder = {
    "authInfo",
    "subscriptionKey",
    "coveragePeriod",
    "chunkToken"
})
public class GetSubscriptionResults {

    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected String authInfo;
    @XmlElement(required = true)
    protected String subscriptionKey;
    @XmlElement(required = true)
    protected CoveragePeriod coveragePeriod;
    protected String chunkToken;

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
     * Gets the value of the coveragePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link CoveragePeriod }
     *     
     */
    public CoveragePeriod getCoveragePeriod() {
        return coveragePeriod;
    }

    /**
     * Sets the value of the coveragePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoveragePeriod }
     *     
     */
    public void setCoveragePeriod(CoveragePeriod value) {
        this.coveragePeriod = value;
    }

    /**
     * Gets the value of the chunkToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChunkToken() {
        return chunkToken;
    }

    /**
     * Sets the value of the chunkToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChunkToken(String value) {
        this.chunkToken = value;
    }

}

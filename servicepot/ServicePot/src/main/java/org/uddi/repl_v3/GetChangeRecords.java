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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="requestingNode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changesAlreadySeen" type="{urn:uddi-org:repl_v3}highWaterMarkVector_type" minOccurs="0"/>
 *         &lt;element name="responseLimitCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="responseLimitVector" type="{urn:uddi-org:repl_v3}highWaterMarkVector_type" minOccurs="0"/>
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
    "requestingNode",
    "changesAlreadySeen",
    "responseLimitCount",
    "responseLimitVector"
})
@XmlRootElement(name = "get_changeRecords")
public class GetChangeRecords {

    @XmlElement(required = true)
    protected String requestingNode;
    protected HighWaterMarkVectorType changesAlreadySeen;
    protected BigInteger responseLimitCount;
    protected HighWaterMarkVectorType responseLimitVector;

    /**
     * Gets the value of the requestingNode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestingNode() {
        return requestingNode;
    }

    /**
     * Sets the value of the requestingNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestingNode(String value) {
        this.requestingNode = value;
    }

    /**
     * Gets the value of the changesAlreadySeen property.
     * 
     * @return
     *     possible object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public HighWaterMarkVectorType getChangesAlreadySeen() {
        return changesAlreadySeen;
    }

    /**
     * Sets the value of the changesAlreadySeen property.
     * 
     * @param value
     *     allowed object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public void setChangesAlreadySeen(HighWaterMarkVectorType value) {
        this.changesAlreadySeen = value;
    }

    /**
     * Gets the value of the responseLimitCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getResponseLimitCount() {
        return responseLimitCount;
    }

    /**
     * Sets the value of the responseLimitCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setResponseLimitCount(BigInteger value) {
        this.responseLimitCount = value;
    }

    /**
     * Gets the value of the responseLimitVector property.
     * 
     * @return
     *     possible object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public HighWaterMarkVectorType getResponseLimitVector() {
        return responseLimitVector;
    }

    /**
     * Sets the value of the responseLimitVector property.
     * 
     * @param value
     *     allowed object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public void setResponseLimitVector(HighWaterMarkVectorType value) {
        this.responseLimitVector = value;
    }

}

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
 *         &lt;element name="notifyingNode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changesAvailable" type="{urn:uddi-org:repl_v3}highWaterMarkVector_type"/>
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
    "notifyingNode",
    "changesAvailable"
})
@XmlRootElement(name = "notify_changeRecordsAvailable")
public class NotifyChangeRecordsAvailable {

    @XmlElement(required = true)
    protected String notifyingNode;
    @XmlElement(required = true)
    protected HighWaterMarkVectorType changesAvailable;

    /**
     * Gets the value of the notifyingNode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotifyingNode() {
        return notifyingNode;
    }

    /**
     * Sets the value of the notifyingNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotifyingNode(String value) {
        this.notifyingNode = value;
    }

    /**
     * Gets the value of the changesAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public HighWaterMarkVectorType getChangesAvailable() {
        return changesAvailable;
    }

    /**
     * Sets the value of the changesAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public void setChangesAvailable(HighWaterMarkVectorType value) {
        this.changesAvailable = value;
    }

}

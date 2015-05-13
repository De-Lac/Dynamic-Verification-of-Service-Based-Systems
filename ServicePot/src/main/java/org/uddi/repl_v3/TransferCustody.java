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
import javax.xml.bind.annotation.XmlType;
import org.uddi.custody_v3.KeyBag;
import org.uddi.custody_v3.TransferOperationalInfo;
import org.uddi.custody_v3.TransferToken;


/**
 * <p>Java class for transfer_custody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transfer_custody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:custody_v3}transferToken"/>
 *         &lt;element ref="{urn:uddi-org:custody_v3}keyBag"/>
 *         &lt;element ref="{urn:uddi-org:custody_v3}transferOperationalInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transfer_custody", propOrder = {
    "transferToken",
    "keyBag",
    "transferOperationalInfo"
})
public class TransferCustody {

    @XmlElement(namespace = "urn:uddi-org:custody_v3", required = true)
    protected TransferToken transferToken;
    @XmlElement(namespace = "urn:uddi-org:custody_v3", required = true)
    protected KeyBag keyBag;
    @XmlElement(namespace = "urn:uddi-org:custody_v3", required = true)
    protected TransferOperationalInfo transferOperationalInfo;

    /**
     * Gets the value of the transferToken property.
     * 
     * @return
     *     possible object is
     *     {@link TransferToken }
     *     
     */
    public TransferToken getTransferToken() {
        return transferToken;
    }

    /**
     * Sets the value of the transferToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferToken }
     *     
     */
    public void setTransferToken(TransferToken value) {
        this.transferToken = value;
    }

    /**
     * Gets the value of the keyBag property.
     * 
     * @return
     *     possible object is
     *     {@link KeyBag }
     *     
     */
    public KeyBag getKeyBag() {
        return keyBag;
    }

    /**
     * Sets the value of the keyBag property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyBag }
     *     
     */
    public void setKeyBag(KeyBag value) {
        this.keyBag = value;
    }

    /**
     * Gets the value of the transferOperationalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TransferOperationalInfo }
     *     
     */
    public TransferOperationalInfo getTransferOperationalInfo() {
        return transferOperationalInfo;
    }

    /**
     * Sets the value of the transferOperationalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferOperationalInfo }
     *     
     */
    public void setTransferOperationalInfo(TransferOperationalInfo value) {
        this.transferOperationalInfo = value;
    }

}

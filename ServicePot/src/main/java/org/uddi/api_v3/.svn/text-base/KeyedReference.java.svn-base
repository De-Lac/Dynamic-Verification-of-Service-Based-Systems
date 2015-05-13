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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for keyedReference complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType name="keyedReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="tModelKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="keyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="keyValue" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "keyedReference")
public class KeyedReference {

    @XmlAttribute(name = "tModelKey", required = true)
    protected String tModelKey;
    @XmlAttribute(name = "keyName")
    protected String keyName;
    @XmlAttribute(name = "keyValue", required = true)
    protected String keyValue;

    /**
     * Gets the value of the tModelKey property.
     *
     * @return possible object is
     *     {@link String }
     *
     */
    public String getTModelKey() {
        return tModelKey;
    }

    /**
     * Sets the value of the tModelKey property.
     *
     * @param value allowed object is
     *     {@link String }
     *
     */
    public void setTModelKey(String value) {
        this.tModelKey = value;
    }

    /**
     * Gets the value of the keyName property.
     *
     * @return possible object is
     *     {@link String }
     *
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * Sets the value of the keyName property.
     *
     * @param value allowed object is
     *     {@link String }
     *
     */
    public void setKeyName(String value) {
        this.keyName = value;
    }

    /**
     * Gets the value of the keyValue property.
     *
     * @return possible object is
     *     {@link String }
     *
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * Sets the value of the keyValue property.
     *
     * @param value allowed object is
     *     {@link String }
     *
     */
    public void setKeyValue(String value) {
        this.keyValue = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof KeyedReference)) {
            return false;
        }
        KeyedReference kr = (KeyedReference) obj;
        boolean keyNamesEqual = ((keyName == null) && (kr.keyName == null))
                || (keyName != null && keyName.equals(kr.keyName));

        boolean keyValuesEqual = ((keyValue == null) && (kr.keyValue == null))
                || (keyValue != null && keyValue.equals(kr.keyValue));

        boolean tModelKeysEqual = ((tModelKey == null) && (kr.tModelKey == null))
                || (tModelKey != null && tModelKey.equals(kr.tModelKey));
        
        return keyNamesEqual && keyValuesEqual && tModelKeysEqual;

    }
}

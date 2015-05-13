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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for keyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="keyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="businessKey"/>
 *     &lt;enumeration value="tModelKey"/>
 *     &lt;enumeration value="serviceKey"/>
 *     &lt;enumeration value="bindingKey"/>
 *     &lt;enumeration value="subscriptionKey"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "keyType")
@XmlEnum
public enum KeyType {

    @XmlEnumValue("businessKey")
    BUSINESS_KEY("businessKey"),
    @XmlEnumValue("tModelKey")
    T_MODEL_KEY("tModelKey"),
    @XmlEnumValue("serviceKey")
    SERVICE_KEY("serviceKey"),
    @XmlEnumValue("bindingKey")
    BINDING_KEY("bindingKey"),
    @XmlEnumValue("subscriptionKey")
    SUBSCRIPTION_KEY("subscriptionKey");
    private final String value;

    KeyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KeyType fromValue(String v) {
        for (KeyType c: KeyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

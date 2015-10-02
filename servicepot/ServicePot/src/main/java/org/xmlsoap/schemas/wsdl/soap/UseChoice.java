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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.13 at 11:12:21 AM CEST 
//


package org.xmlsoap.schemas.wsdl.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for useChoice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="useChoice">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="literal"/>
 *     &lt;enumeration value="encoded"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "useChoice")
@XmlEnum
public enum UseChoice {

    @XmlEnumValue("literal")
    LITERAL("literal"),
    @XmlEnumValue("encoded")
    ENCODED("encoded");
    private final String value;

    UseChoice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UseChoice fromValue(String v) {
        for (UseChoice c: UseChoice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.14 at 06:48:11 PM CEST 
//


package org.ow2.choreos.bpmn2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipantBandKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipantBandKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="top_initiating"/>
 *     &lt;enumeration value="middle_initiating"/>
 *     &lt;enumeration value="bottom_initiating"/>
 *     &lt;enumeration value="top_non_initiating"/>
 *     &lt;enumeration value="middle_non_initiating"/>
 *     &lt;enumeration value="bottom_non_initiating"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipantBandKind", namespace = "http://www.omg.org/spec/BPMN/20100524/DI")
@XmlEnum
public enum ParticipantBandKind {

    @XmlEnumValue("top_initiating")
    TOP_INITIATING("top_initiating"),
    @XmlEnumValue("middle_initiating")
    MIDDLE_INITIATING("middle_initiating"),
    @XmlEnumValue("bottom_initiating")
    BOTTOM_INITIATING("bottom_initiating"),
    @XmlEnumValue("top_non_initiating")
    TOP_NON_INITIATING("top_non_initiating"),
    @XmlEnumValue("middle_non_initiating")
    MIDDLE_NON_INITIATING("middle_non_initiating"),
    @XmlEnumValue("bottom_non_initiating")
    BOTTOM_NON_INITIATING("bottom_non_initiating");
    private final String value;

    ParticipantBandKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParticipantBandKind fromValue(String v) {
        for (ParticipantBandKind c: ParticipantBandKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

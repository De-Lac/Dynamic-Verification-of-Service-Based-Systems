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
 * <p>Java class for completionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="completionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="status:complete"/>
 *     &lt;enumeration value="status:fromKey_incomplete"/>
 *     &lt;enumeration value="status:toKey_incomplete"/>
 *     &lt;enumeration value="status:both_incomplete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "completionStatus")
@XmlEnum
public enum CompletionStatus {

    @XmlEnumValue("status:complete")
    STATUS_COMPLETE("status:complete"),
    @XmlEnumValue("status:fromKey_incomplete")
    STATUS_FROM_KEY_INCOMPLETE("status:fromKey_incomplete"),
    @XmlEnumValue("status:toKey_incomplete")
    STATUS_TO_KEY_INCOMPLETE("status:toKey_incomplete"),
    @XmlEnumValue("status:both_incomplete")
    STATUS_BOTH_INCOMPLETE("status:both_incomplete");
    private final String value;

    CompletionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CompletionStatus fromValue(String v) {
        for (CompletionStatus c: CompletionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
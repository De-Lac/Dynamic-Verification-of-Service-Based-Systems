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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tArtifact">
 *       &lt;attribute name="categoryValueRef" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGroup")
public class TGroup
    extends TArtifact
{

    @XmlAttribute
    protected QName categoryValueRef;

    /**
     * Gets the value of the categoryValueRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getCategoryValueRef() {
        return categoryValueRef;
    }

    /**
     * Sets the value of the categoryValueRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setCategoryValueRef(QName value) {
        this.categoryValueRef = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.02 at 10:00:00 PM CEST 
//


package org.omg.spec.bpmn._20100524.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tGateway complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tGateway">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tFlowNode">
 *       &lt;attribute name="gatewayDirection" type="{http://www.omg.org/spec/BPMN/20100524/MODEL}tGatewayDirection" default="Unspecified" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGateway")
@XmlSeeAlso({
    TComplexGateway.class,
    TInclusiveGateway.class,
    TEventBasedGateway.class,
    TParallelGateway.class,
    TExclusiveGateway.class
})
public class TGateway
    extends TFlowNode
{

    @XmlAttribute
    protected TGatewayDirection gatewayDirection;

    /**
     * Gets the value of the gatewayDirection property.
     * 
     * @return
     *     possible object is
     *     {@link TGatewayDirection }
     *     
     */
    public TGatewayDirection getGatewayDirection() {
        if (gatewayDirection == null) {
            return TGatewayDirection.UNSPECIFIED;
        } else {
            return gatewayDirection;
        }
    }

    /**
     * Sets the value of the gatewayDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGatewayDirection }
     *     
     */
    public void setGatewayDirection(TGatewayDirection value) {
        this.gatewayDirection = value;
    }

}

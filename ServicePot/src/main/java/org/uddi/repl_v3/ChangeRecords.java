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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="changeRecord" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="changeID" type="{urn:uddi-org:repl_v3}changeRecordID_type"/>
 *                   &lt;element name="changeRecordNull" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewData" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDelete" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordPublisherAssertion" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordHide" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDeleteAssertion" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordAcknowledgement" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordCorrection" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewDataConditional" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordConditionFailed" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="acknowledgementRequested" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "changeRecord"
})
@XmlRootElement(name = "changeRecords")
public class ChangeRecords {

    @XmlElement(nillable = true)
    protected List<ChangeRecords.ChangeRecord> changeRecord;

    /**
     * Gets the value of the changeRecord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeRecord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeRecords.ChangeRecord }
     * 
     * 
     */
    public List<ChangeRecords.ChangeRecord> getChangeRecord() {
        if (changeRecord == null) {
            changeRecord = new ArrayList<ChangeRecords.ChangeRecord>();
        }
        return this.changeRecord;
    }


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
     *         &lt;element name="changeID" type="{urn:uddi-org:repl_v3}changeRecordID_type"/>
     *         &lt;element name="changeRecordNull" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewData" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDelete" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordPublisherAssertion" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordHide" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDeleteAssertion" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordAcknowledgement" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordCorrection" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewDataConditional" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordConditionFailed" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="acknowledgementRequested" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "changeID",
        "changeRecordNull",
        "changeRecordNewData",
        "changeRecordDelete",
        "changeRecordPublisherAssertion",
        "changeRecordHide",
        "changeRecordDeleteAssertion",
        "changeRecordAcknowledgement",
        "changeRecordCorrection",
        "changeRecordNewDataConditional",
        "changeRecordConditionFailed"
    })
    public static class ChangeRecord {

        @XmlElement(required = true)
        protected ChangeRecordIDType changeID;
        protected Object changeRecordNull;
        protected ChangeRecordNewData changeRecordNewData;
        protected ChangeRecordDelete changeRecordDelete;
        protected ChangeRecordPublisherAssertion changeRecordPublisherAssertion;
        protected ChangeRecordHide changeRecordHide;
        protected ChangeRecordDeleteAssertion changeRecordDeleteAssertion;
        protected ChangeRecordAcknowledgement changeRecordAcknowledgement;
        protected ChangeRecordCorrection changeRecordCorrection;
        protected ChangeRecordNewDataConditional changeRecordNewDataConditional;
        protected ChangeRecordConditionFailed changeRecordConditionFailed;
        @XmlAttribute(name = "acknowledgementRequested", required = true)
        protected boolean acknowledgementRequested;

        /**
         * Gets the value of the changeID property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordIDType }
         *     
         */
        public ChangeRecordIDType getChangeID() {
            return changeID;
        }

        /**
         * Sets the value of the changeID property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordIDType }
         *     
         */
        public void setChangeID(ChangeRecordIDType value) {
            this.changeID = value;
        }

        /**
         * Gets the value of the changeRecordNull property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getChangeRecordNull() {
            return changeRecordNull;
        }

        /**
         * Sets the value of the changeRecordNull property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setChangeRecordNull(Object value) {
            this.changeRecordNull = value;
        }

        /**
         * Gets the value of the changeRecordNewData property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordNewData }
         *     
         */
        public ChangeRecordNewData getChangeRecordNewData() {
            return changeRecordNewData;
        }

        /**
         * Sets the value of the changeRecordNewData property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordNewData }
         *     
         */
        public void setChangeRecordNewData(ChangeRecordNewData value) {
            this.changeRecordNewData = value;
        }

        /**
         * Gets the value of the changeRecordDelete property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordDelete }
         *     
         */
        public ChangeRecordDelete getChangeRecordDelete() {
            return changeRecordDelete;
        }

        /**
         * Sets the value of the changeRecordDelete property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordDelete }
         *     
         */
        public void setChangeRecordDelete(ChangeRecordDelete value) {
            this.changeRecordDelete = value;
        }

        /**
         * Gets the value of the changeRecordPublisherAssertion property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordPublisherAssertion }
         *     
         */
        public ChangeRecordPublisherAssertion getChangeRecordPublisherAssertion() {
            return changeRecordPublisherAssertion;
        }

        /**
         * Sets the value of the changeRecordPublisherAssertion property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordPublisherAssertion }
         *     
         */
        public void setChangeRecordPublisherAssertion(ChangeRecordPublisherAssertion value) {
            this.changeRecordPublisherAssertion = value;
        }

        /**
         * Gets the value of the changeRecordHide property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordHide }
         *     
         */
        public ChangeRecordHide getChangeRecordHide() {
            return changeRecordHide;
        }

        /**
         * Sets the value of the changeRecordHide property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordHide }
         *     
         */
        public void setChangeRecordHide(ChangeRecordHide value) {
            this.changeRecordHide = value;
        }

        /**
         * Gets the value of the changeRecordDeleteAssertion property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordDeleteAssertion }
         *     
         */
        public ChangeRecordDeleteAssertion getChangeRecordDeleteAssertion() {
            return changeRecordDeleteAssertion;
        }

        /**
         * Sets the value of the changeRecordDeleteAssertion property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordDeleteAssertion }
         *     
         */
        public void setChangeRecordDeleteAssertion(ChangeRecordDeleteAssertion value) {
            this.changeRecordDeleteAssertion = value;
        }

        /**
         * Gets the value of the changeRecordAcknowledgement property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordAcknowledgement }
         *     
         */
        public ChangeRecordAcknowledgement getChangeRecordAcknowledgement() {
            return changeRecordAcknowledgement;
        }

        /**
         * Sets the value of the changeRecordAcknowledgement property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordAcknowledgement }
         *     
         */
        public void setChangeRecordAcknowledgement(ChangeRecordAcknowledgement value) {
            this.changeRecordAcknowledgement = value;
        }

        /**
         * Gets the value of the changeRecordCorrection property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordCorrection }
         *     
         */
        public ChangeRecordCorrection getChangeRecordCorrection() {
            return changeRecordCorrection;
        }

        /**
         * Sets the value of the changeRecordCorrection property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordCorrection }
         *     
         */
        public void setChangeRecordCorrection(ChangeRecordCorrection value) {
            this.changeRecordCorrection = value;
        }

        /**
         * Gets the value of the changeRecordNewDataConditional property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordNewDataConditional }
         *     
         */
        public ChangeRecordNewDataConditional getChangeRecordNewDataConditional() {
            return changeRecordNewDataConditional;
        }

        /**
         * Sets the value of the changeRecordNewDataConditional property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordNewDataConditional }
         *     
         */
        public void setChangeRecordNewDataConditional(ChangeRecordNewDataConditional value) {
            this.changeRecordNewDataConditional = value;
        }

        /**
         * Gets the value of the changeRecordConditionFailed property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordConditionFailed }
         *     
         */
        public ChangeRecordConditionFailed getChangeRecordConditionFailed() {
            return changeRecordConditionFailed;
        }

        /**
         * Sets the value of the changeRecordConditionFailed property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordConditionFailed }
         *     
         */
        public void setChangeRecordConditionFailed(ChangeRecordConditionFailed value) {
            this.changeRecordConditionFailed = value;
        }

        /**
         * Gets the value of the acknowledgementRequested property.
         * 
         */
        public boolean isAcknowledgementRequested() {
            return acknowledgementRequested;
        }

        /**
         * Sets the value of the acknowledgementRequested property.
         * 
         */
        public void setAcknowledgementRequested(boolean value) {
            this.acknowledgementRequested = value;
        }

    }

}

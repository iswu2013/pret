
package com.pret.open.u9.warehouse;

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
 *         &lt;element name="GetWareMcustDeliverFlagResult" type="{http://tempuri.org/}ArrayOfWARE" minOccurs="0"/>
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
    "getWareMcustDeliverFlagResult"
})
@XmlRootElement(name = "GetWareMcustDeliverFlagResponse")
public class GetWareMcustDeliverFlagResponse {

    @XmlElement(name = "GetWareMcustDeliverFlagResult")
    protected ArrayOfWARE getWareMcustDeliverFlagResult;

    /**
     * Gets the value of the getWareMcustDeliverFlagResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWARE }
     *     
     */
    public ArrayOfWARE getGetWareMcustDeliverFlagResult() {
        return getWareMcustDeliverFlagResult;
    }

    /**
     * Sets the value of the getWareMcustDeliverFlagResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWARE }
     *     
     */
    public void setGetWareMcustDeliverFlagResult(ArrayOfWARE value) {
        this.getWareMcustDeliverFlagResult = value;
    }

}

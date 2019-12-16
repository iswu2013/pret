
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
 *         &lt;element name="GetWareDeliverDistinctResult" type="{http://tempuri.org/}ArrayOfWARE" minOccurs="0"/>
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
    "getWareDeliverDistinctResult"
})
@XmlRootElement(name = "GetWareDeliverDistinctResponse")
public class GetWareDeliverDistinctResponse {

    @XmlElement(name = "GetWareDeliverDistinctResult")
    protected ArrayOfWARE getWareDeliverDistinctResult;

    /**
     * Gets the value of the getWareDeliverDistinctResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWARE }
     *     
     */
    public ArrayOfWARE getGetWareDeliverDistinctResult() {
        return getWareDeliverDistinctResult;
    }

    /**
     * Sets the value of the getWareDeliverDistinctResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWARE }
     *     
     */
    public void setGetWareDeliverDistinctResult(ArrayOfWARE value) {
        this.getWareDeliverDistinctResult = value;
    }

}

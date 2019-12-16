
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
 *         &lt;element name="GetWareDeliverStoreVRResult" type="{http://tempuri.org/}ArrayOfWAREVR" minOccurs="0"/>
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
    "getWareDeliverStoreVRResult"
})
@XmlRootElement(name = "GetWareDeliverStoreVRResponse")
public class GetWareDeliverStoreVRResponse {

    @XmlElement(name = "GetWareDeliverStoreVRResult")
    protected ArrayOfWAREVR getWareDeliverStoreVRResult;

    /**
     * Gets the value of the getWareDeliverStoreVRResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWAREVR }
     *     
     */
    public ArrayOfWAREVR getGetWareDeliverStoreVRResult() {
        return getWareDeliverStoreVRResult;
    }

    /**
     * Sets the value of the getWareDeliverStoreVRResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWAREVR }
     *     
     */
    public void setGetWareDeliverStoreVRResult(ArrayOfWAREVR value) {
        this.getWareDeliverStoreVRResult = value;
    }

}

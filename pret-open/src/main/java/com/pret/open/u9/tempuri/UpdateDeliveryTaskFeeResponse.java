
package com.pret.open.u9.tempuri;

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
 *         &lt;element name="UpdateDeliveryTaskFeeResult" type="{http://tempuri.org/}RetMsg" minOccurs="0"/>
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
    "updateDeliveryTaskFeeResult"
})
@XmlRootElement(name = "UpdateDeliveryTaskFeeResponse")
public class UpdateDeliveryTaskFeeResponse {

    @XmlElement(name = "UpdateDeliveryTaskFeeResult")
    protected RetMsg updateDeliveryTaskFeeResult;

    /**
     * Gets the value of the updateDeliveryTaskFeeResult property.
     * 
     * @return
     *     possible object is
     *     {@link RetMsg }
     *     
     */
    public RetMsg getUpdateDeliveryTaskFeeResult() {
        return updateDeliveryTaskFeeResult;
    }

    /**
     * Sets the value of the updateDeliveryTaskFeeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetMsg }
     *     
     */
    public void setUpdateDeliveryTaskFeeResult(RetMsg value) {
        this.updateDeliveryTaskFeeResult = value;
    }

}

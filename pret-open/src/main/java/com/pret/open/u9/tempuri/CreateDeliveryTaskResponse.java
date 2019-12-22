
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
 *         &lt;element name="CreateDeliveryTaskResult" type="{http://tempuri.org/}RetMsg" minOccurs="0"/>
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
    "createDeliveryTaskResult"
})
@XmlRootElement(name = "CreateDeliveryTaskResponse")
public class CreateDeliveryTaskResponse {

    @XmlElement(name = "CreateDeliveryTaskResult")
    protected RetMsg createDeliveryTaskResult;

    /**
     * Gets the value of the createDeliveryTaskResult property.
     * 
     * @return
     *     possible object is
     *     {@link RetMsg }
     *     
     */
    public RetMsg getCreateDeliveryTaskResult() {
        return createDeliveryTaskResult;
    }

    /**
     * Sets the value of the createDeliveryTaskResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetMsg }
     *     
     */
    public void setCreateDeliveryTaskResult(RetMsg value) {
        this.createDeliveryTaskResult = value;
    }

}


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
 *         &lt;element name="DeliverCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "deliverCode"
})
@XmlRootElement(name = "GetWareDeliver")
public class GetWareDeliver {

    @XmlElement(name = "DeliverCode")
    protected int deliverCode;

    /**
     * Gets the value of the deliverCode property.
     * 
     */
    public int getDeliverCode() {
        return deliverCode;
    }

    /**
     * Sets the value of the deliverCode property.
     * 
     */
    public void setDeliverCode(int value) {
        this.deliverCode = value;
    }

}

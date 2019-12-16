
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
 *         &lt;element name="GetWareResult" type="{http://tempuri.org/}ArrayOfWARE" minOccurs="0"/>
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
    "getWareResult"
})
@XmlRootElement(name = "GetWareResponse")
public class GetWareResponse {

    @XmlElement(name = "GetWareResult")
    protected ArrayOfWARE getWareResult;

    /**
     * Gets the value of the getWareResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWARE }
     *     
     */
    public ArrayOfWARE getGetWareResult() {
        return getWareResult;
    }

    /**
     * Sets the value of the getWareResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWARE }
     *     
     */
    public void setGetWareResult(ArrayOfWARE value) {
        this.getWareResult = value;
    }

}

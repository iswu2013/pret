
package com.pret.open.u9.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeeDoc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeeDoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MBDocNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeLines" type="{http://tempuri.org/}ArrayOfFeeLines" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeeDoc", propOrder = {
    "mbDocNo",
    "feeLines"
})
public class FeeDoc {

    @XmlElement(name = "MBDocNo")
    protected String mbDocNo;
    @XmlElement(name = "FeeLines")
    protected ArrayOfFeeLines feeLines;

    /**
     * Gets the value of the mbDocNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMBDocNo() {
        return mbDocNo;
    }

    /**
     * Sets the value of the mbDocNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMBDocNo(String value) {
        this.mbDocNo = value;
    }

    /**
     * Gets the value of the feeLines property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFeeLines }
     *     
     */
    public ArrayOfFeeLines getFeeLines() {
        return feeLines;
    }

    /**
     * Sets the value of the feeLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFeeLines }
     *     
     */
    public void setFeeLines(ArrayOfFeeLines value) {
        this.feeLines = value;
    }

}

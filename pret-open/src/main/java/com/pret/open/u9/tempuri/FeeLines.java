
package com.pret.open.u9.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeeLines complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeeLines">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StartArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfirmedQty" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Fee" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EndArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeeLines", propOrder = {
    "startArea",
    "confirmedQty",
    "fee",
    "endArea"
})
public class FeeLines {

    @XmlElement(name = "StartArea")
    protected String startArea;
    @XmlElement(name = "ConfirmedQty", required = true)
    protected BigDecimal confirmedQty;
    @XmlElement(name = "Fee", required = true)
    protected BigDecimal fee;
    @XmlElement(name = "EndArea")
    protected String endArea;

    /**
     * Gets the value of the startArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartArea() {
        return startArea;
    }

    /**
     * Sets the value of the startArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartArea(String value) {
        this.startArea = value;
    }

    /**
     * Gets the value of the confirmedQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getConfirmedQty() {
        return confirmedQty;
    }

    /**
     * Sets the value of the confirmedQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setConfirmedQty(BigDecimal value) {
        this.confirmedQty = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFee(BigDecimal value) {
        this.fee = value;
    }

    /**
     * Gets the value of the endArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndArea() {
        return endArea;
    }

    /**
     * Sets the value of the endArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndArea(String value) {
        this.endArea = value;
    }

}

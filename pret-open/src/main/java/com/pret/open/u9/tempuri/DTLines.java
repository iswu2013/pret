
package com.pret.open.u9.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DTLines complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DTLines">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="U9DocLineNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="U9DocNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipQty" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ConfirmedQty" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTLines", propOrder = {
    "u9DocLineNo",
    "u9DocNo",
    "shipQty",
    "confirmedQty",
    "remark"
})
public class DTLines {

    @XmlElement(name = "U9DocLineNo")
    protected int u9DocLineNo;
    @XmlElement(name = "U9DocNo")
    protected String u9DocNo;
    @XmlElement(name = "ShipQty", required = true)
    protected BigDecimal shipQty;
    @XmlElement(name = "ConfirmedQty", required = true)
    protected BigDecimal confirmedQty;
    @XmlElement(name = "Remark")
    protected String remark;

    /**
     * Gets the value of the u9DocLineNo property.
     * 
     */
    public int getU9DocLineNo() {
        return u9DocLineNo;
    }

    /**
     * Sets the value of the u9DocLineNo property.
     * 
     */
    public void setU9DocLineNo(int value) {
        this.u9DocLineNo = value;
    }

    /**
     * Gets the value of the u9DocNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getU9DocNo() {
        return u9DocNo;
    }

    /**
     * Sets the value of the u9DocNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setU9DocNo(String value) {
        this.u9DocNo = value;
    }

    /**
     * Gets the value of the shipQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShipQty() {
        return shipQty;
    }

    /**
     * Sets the value of the shipQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShipQty(BigDecimal value) {
        this.shipQty = value;
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
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

}

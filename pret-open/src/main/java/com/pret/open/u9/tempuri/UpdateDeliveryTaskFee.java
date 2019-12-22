
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
 *         &lt;element name="DTDoc_LIST" type="{http://tempuri.org/}ArrayOfFeeDoc" minOccurs="0"/>
 *         &lt;element name="orgcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usercode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "dtDocLIST",
    "orgcode",
    "usercode"
})
@XmlRootElement(name = "UpdateDeliveryTaskFee")
public class UpdateDeliveryTaskFee {

    @XmlElement(name = "DTDoc_LIST")
    protected ArrayOfFeeDoc dtDocLIST;
    protected String orgcode;
    protected String usercode;

    /**
     * Gets the value of the dtDocLIST property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFeeDoc }
     *     
     */
    public ArrayOfFeeDoc getDTDocLIST() {
        return dtDocLIST;
    }

    /**
     * Sets the value of the dtDocLIST property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFeeDoc }
     *     
     */
    public void setDTDocLIST(ArrayOfFeeDoc value) {
        this.dtDocLIST = value;
    }

    /**
     * Gets the value of the orgcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * Sets the value of the orgcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgcode(String value) {
        this.orgcode = value;
    }

    /**
     * Gets the value of the usercode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * Sets the value of the usercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsercode(String value) {
        this.usercode = value;
    }

}

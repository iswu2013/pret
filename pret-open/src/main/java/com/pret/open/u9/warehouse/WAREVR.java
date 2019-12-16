
package com.pret.open.u9.warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WAREVR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WAREVR">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}WARE">
 *       &lt;sequence>
 *         &lt;element name="VRCONTACT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VRMOBILE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VRTEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WAREVR", propOrder = {
    "vrcontact",
    "vrmobile",
    "vrtel"
})
public class WAREVR
    extends WARE
{

    @XmlElement(name = "VRCONTACT")
    protected String vrcontact;
    @XmlElement(name = "VRMOBILE")
    protected String vrmobile;
    @XmlElement(name = "VRTEL")
    protected String vrtel;

    /**
     * Gets the value of the vrcontact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRCONTACT() {
        return vrcontact;
    }

    /**
     * Sets the value of the vrcontact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRCONTACT(String value) {
        this.vrcontact = value;
    }

    /**
     * Gets the value of the vrmobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRMOBILE() {
        return vrmobile;
    }

    /**
     * Sets the value of the vrmobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRMOBILE(String value) {
        this.vrmobile = value;
    }

    /**
     * Gets the value of the vrtel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRTEL() {
        return vrtel;
    }

    /**
     * Sets the value of the vrtel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRTEL(String value) {
        this.vrtel = value;
    }

}

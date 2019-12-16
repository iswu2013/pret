
package com.pret.open.u9.warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WARE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WARE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MCUSTNO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MCUSTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIVERCENTERCODE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DELIVERCENTERNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STOREID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STORENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STORETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELFALG" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="WARENO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WARENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRTDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CRTWK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHGDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CHGWK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHGIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MOBILE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WMSVERSION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WARE", propOrder = {
    "mcustno",
    "mcustname",
    "delivercentercode",
    "delivercentername",
    "storeid",
    "storename",
    "area",
    "storetype",
    "delfalg",
    "wareno",
    "warename",
    "locno",
    "crtdate",
    "crtwk",
    "chgdate",
    "chgwk",
    "chgip",
    "addr",
    "contact",
    "mobile",
    "tel",
    "wmsversion"
})
@XmlSeeAlso({
    WAREVR.class
})
public class WARE {

    @XmlElement(name = "MCUSTNO")
    protected int mcustno;
    @XmlElement(name = "MCUSTNAME")
    protected String mcustname;
    @XmlElement(name = "DELIVERCENTERCODE")
    protected int delivercentercode;
    @XmlElement(name = "DELIVERCENTERNAME")
    protected String delivercentername;
    @XmlElement(name = "STOREID")
    protected int storeid;
    @XmlElement(name = "STORENAME")
    protected String storename;
    @XmlElement(name = "AREA")
    protected String area;
    @XmlElement(name = "STORETYPE")
    protected String storetype;
    @XmlElement(name = "DELFALG")
    protected int delfalg;
    @XmlElement(name = "WARENO")
    protected String wareno;
    @XmlElement(name = "WARENAME")
    protected String warename;
    @XmlElement(name = "LOCNO")
    protected String locno;
    @XmlElement(name = "CRTDATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar crtdate;
    @XmlElement(name = "CRTWK")
    protected String crtwk;
    @XmlElement(name = "CHGDATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar chgdate;
    @XmlElement(name = "CHGWK")
    protected String chgwk;
    @XmlElement(name = "CHGIP")
    protected String chgip;
    @XmlElement(name = "ADDR")
    protected String addr;
    @XmlElement(name = "CONTACT")
    protected String contact;
    @XmlElement(name = "MOBILE")
    protected String mobile;
    @XmlElement(name = "TEL")
    protected String tel;
    @XmlElement(name = "WMSVERSION")
    protected String wmsversion;

    /**
     * Gets the value of the mcustno property.
     * 
     */
    public int getMCUSTNO() {
        return mcustno;
    }

    /**
     * Sets the value of the mcustno property.
     * 
     */
    public void setMCUSTNO(int value) {
        this.mcustno = value;
    }

    /**
     * Gets the value of the mcustname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMCUSTNAME() {
        return mcustname;
    }

    /**
     * Sets the value of the mcustname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMCUSTNAME(String value) {
        this.mcustname = value;
    }

    /**
     * Gets the value of the delivercentercode property.
     * 
     */
    public int getDELIVERCENTERCODE() {
        return delivercentercode;
    }

    /**
     * Sets the value of the delivercentercode property.
     * 
     */
    public void setDELIVERCENTERCODE(int value) {
        this.delivercentercode = value;
    }

    /**
     * Gets the value of the delivercentername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERCENTERNAME() {
        return delivercentername;
    }

    /**
     * Sets the value of the delivercentername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERCENTERNAME(String value) {
        this.delivercentername = value;
    }

    /**
     * Gets the value of the storeid property.
     * 
     */
    public int getSTOREID() {
        return storeid;
    }

    /**
     * Sets the value of the storeid property.
     * 
     */
    public void setSTOREID(int value) {
        this.storeid = value;
    }

    /**
     * Gets the value of the storename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTORENAME() {
        return storename;
    }

    /**
     * Sets the value of the storename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTORENAME(String value) {
        this.storename = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAREA() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAREA(String value) {
        this.area = value;
    }

    /**
     * Gets the value of the storetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTORETYPE() {
        return storetype;
    }

    /**
     * Sets the value of the storetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTORETYPE(String value) {
        this.storetype = value;
    }

    /**
     * Gets the value of the delfalg property.
     * 
     */
    public int getDELFALG() {
        return delfalg;
    }

    /**
     * Sets the value of the delfalg property.
     * 
     */
    public void setDELFALG(int value) {
        this.delfalg = value;
    }

    /**
     * Gets the value of the wareno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARENO() {
        return wareno;
    }

    /**
     * Sets the value of the wareno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARENO(String value) {
        this.wareno = value;
    }

    /**
     * Gets the value of the warename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARENAME() {
        return warename;
    }

    /**
     * Sets the value of the warename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARENAME(String value) {
        this.warename = value;
    }

    /**
     * Gets the value of the locno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCNO() {
        return locno;
    }

    /**
     * Sets the value of the locno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCNO(String value) {
        this.locno = value;
    }

    /**
     * Gets the value of the crtdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCRTDATE() {
        return crtdate;
    }

    /**
     * Sets the value of the crtdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCRTDATE(XMLGregorianCalendar value) {
        this.crtdate = value;
    }

    /**
     * Gets the value of the crtwk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRTWK() {
        return crtwk;
    }

    /**
     * Sets the value of the crtwk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRTWK(String value) {
        this.crtwk = value;
    }

    /**
     * Gets the value of the chgdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCHGDATE() {
        return chgdate;
    }

    /**
     * Sets the value of the chgdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCHGDATE(XMLGregorianCalendar value) {
        this.chgdate = value;
    }

    /**
     * Gets the value of the chgwk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGWK() {
        return chgwk;
    }

    /**
     * Sets the value of the chgwk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGWK(String value) {
        this.chgwk = value;
    }

    /**
     * Gets the value of the chgip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGIP() {
        return chgip;
    }

    /**
     * Sets the value of the chgip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGIP(String value) {
        this.chgip = value;
    }

    /**
     * Gets the value of the addr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDR() {
        return addr;
    }

    /**
     * Sets the value of the addr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDR(String value) {
        this.addr = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTACT() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTACT(String value) {
        this.contact = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMOBILE() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMOBILE(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the tel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEL() {
        return tel;
    }

    /**
     * Sets the value of the tel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEL(String value) {
        this.tel = value;
    }

    /**
     * Gets the value of the wmsversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWMSVERSION() {
        return wmsversion;
    }

    /**
     * Sets the value of the wmsversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWMSVERSION(String value) {
        this.wmsversion = value;
    }

}

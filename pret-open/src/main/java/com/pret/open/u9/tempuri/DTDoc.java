
package com.pret.open.u9.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DTDoc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DTDoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Supplier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MBDocNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DTLines" type="{http://tempuri.org/}ArrayOfDTLines" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTDoc", propOrder = {
    "transType",
    "supplier",
    "mbDocNo",
    "docType",
    "dtLines"
})
public class DTDoc {

    @XmlElement(name = "TransType")
    protected String transType;
    @XmlElement(name = "Supplier")
    protected String supplier;
    @XmlElement(name = "MBDocNo")
    protected String mbDocNo;
    @XmlElement(name = "DocType")
    protected String docType;
    @XmlElement(name = "DTLines")
    protected ArrayOfDTLines dtLines;

    /**
     * Gets the value of the transType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransType() {
        return transType;
    }

    /**
     * Sets the value of the transType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransType(String value) {
        this.transType = value;
    }

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplier(String value) {
        this.supplier = value;
    }

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
     * Gets the value of the docType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocType() {
        return docType;
    }

    /**
     * Sets the value of the docType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocType(String value) {
        this.docType = value;
    }

    /**
     * Gets the value of the dtLines property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDTLines }
     *     
     */
    public ArrayOfDTLines getDTLines() {
        return dtLines;
    }

    /**
     * Sets the value of the dtLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDTLines }
     *     
     */
    public void setDTLines(ArrayOfDTLines value) {
        this.dtLines = value;
    }

}

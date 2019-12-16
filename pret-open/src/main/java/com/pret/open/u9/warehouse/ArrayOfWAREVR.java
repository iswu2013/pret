
package com.pret.open.u9.warehouse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWAREVR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWAREVR">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WAREVR" type="{http://tempuri.org/}WAREVR" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWAREVR", propOrder = {
    "warevr"
})
public class ArrayOfWAREVR {

    @XmlElement(name = "WAREVR", nillable = true)
    protected List<WAREVR> warevr;

    /**
     * Gets the value of the warevr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warevr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWAREVR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WAREVR }
     * 
     * 
     */
    public List<WAREVR> getWAREVR() {
        if (warevr == null) {
            warevr = new ArrayList<WAREVR>();
        }
        return this.warevr;
    }

}

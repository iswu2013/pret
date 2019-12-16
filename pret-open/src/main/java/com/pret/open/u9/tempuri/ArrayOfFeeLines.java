
package com.pret.open.u9.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFeeLines complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFeeLines">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FeeLines" type="{http://tempuri.org/}FeeLines" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFeeLines", propOrder = {
    "feeLines"
})
public class ArrayOfFeeLines {

    @XmlElement(name = "FeeLines", nillable = true)
    protected List<FeeLines> feeLines;

    /**
     * Gets the value of the feeLines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeLines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeLines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeLines }
     * 
     * 
     */
    public List<FeeLines> getFeeLines() {
        if (feeLines == null) {
            feeLines = new ArrayList<FeeLines>();
        }
        return this.feeLines;
    }

}


package com.pret.open.u9.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDTLines complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDTLines">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DTLines" type="{http://tempuri.org/}DTLines" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDTLines", propOrder = {
    "dtLines"
})
public class ArrayOfDTLines {

    @XmlElement(name = "DTLines", nillable = true)
    protected List<DTLines> dtLines;

    /**
     * Gets the value of the dtLines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dtLines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDTLines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DTLines }
     * 
     * 
     */
    public List<DTLines> getDTLines() {
        if (dtLines == null) {
            dtLines = new ArrayList<DTLines>();
        }
        return this.dtLines;
    }

}

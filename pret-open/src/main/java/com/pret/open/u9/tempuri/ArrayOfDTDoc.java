
package com.pret.open.u9.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDTDoc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDTDoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DTDoc" type="{http://tempuri.org/}DTDoc" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDTDoc", propOrder = {
    "dtDoc"
})
public class ArrayOfDTDoc {

    @XmlElement(name = "DTDoc", nillable = true)
    protected List<DTDoc> dtDoc;

    /**
     * Gets the value of the dtDoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dtDoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDTDoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DTDoc }
     * 
     * 
     */
    public List<DTDoc> getDTDoc() {
        if (dtDoc == null) {
            dtDoc = new ArrayList<DTDoc>();
        }
        return this.dtDoc;
    }

}

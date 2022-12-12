
package com.ebssystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfDetalleAmparadoBenef complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfDetalleAmparadoBenef"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="DetalleAmparadoBenef" type="{http://www.ebssystem.com/}DetalleAmparadoBenef" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDetalleAmparadoBenef", propOrder = {
    "detalleAmparadoBenef"
})
public class ArrayOfDetalleAmparadoBenef {

    @XmlElement(name = "DetalleAmparadoBenef", nillable = true)
    protected List<DetalleAmparadoBenef> detalleAmparadoBenef;

    /**
     * Gets the value of the detalleAmparadoBenef property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the detalleAmparadoBenef property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDetalleAmparadoBenef().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleAmparadoBenef }
     * 
     * 
     */
    public List<DetalleAmparadoBenef> getDetalleAmparadoBenef() {
        if (detalleAmparadoBenef == null) {
            detalleAmparadoBenef = new ArrayList<DetalleAmparadoBenef>();
        }
        return this.detalleAmparadoBenef;
    }

}

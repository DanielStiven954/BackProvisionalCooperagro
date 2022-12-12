
package com.ebssas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfIndicadorCarteraDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfIndicadorCarteraDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="IndicadorCarteraDTO" type="{http://www.ebssas.com/}IndicadorCarteraDTO" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIndicadorCarteraDTO", propOrder = {
    "indicadorCarteraDTO"
})
public class ArrayOfIndicadorCarteraDTO {

    @XmlElement(name = "IndicadorCarteraDTO", nillable = true)
    protected List<IndicadorCarteraDTO> indicadorCarteraDTO;

    /**
     * Gets the value of the indicadorCarteraDTO property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the indicadorCarteraDTO property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getIndicadorCarteraDTO().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link IndicadorCarteraDTO }
     * 
     * 
     */
    public List<IndicadorCarteraDTO> getIndicadorCarteraDTO() {
        if (indicadorCarteraDTO == null) {
            indicadorCarteraDTO = new ArrayList<IndicadorCarteraDTO>();
        }
        return this.indicadorCarteraDTO;
    }

}

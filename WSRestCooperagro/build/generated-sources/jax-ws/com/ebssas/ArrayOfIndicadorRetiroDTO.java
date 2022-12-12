
package com.ebssas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfIndicadorRetiroDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfIndicadorRetiroDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="IndicadorRetiroDTO" type="{http://www.ebssas.com/}IndicadorRetiroDTO" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIndicadorRetiroDTO", propOrder = {
    "indicadorRetiroDTO"
})
public class ArrayOfIndicadorRetiroDTO {

    @XmlElement(name = "IndicadorRetiroDTO", nillable = true)
    protected List<IndicadorRetiroDTO> indicadorRetiroDTO;

    /**
     * Gets the value of the indicadorRetiroDTO property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the indicadorRetiroDTO property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getIndicadorRetiroDTO().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link IndicadorRetiroDTO }
     * 
     * 
     */
    public List<IndicadorRetiroDTO> getIndicadorRetiroDTO() {
        if (indicadorRetiroDTO == null) {
            indicadorRetiroDTO = new ArrayList<IndicadorRetiroDTO>();
        }
        return this.indicadorRetiroDTO;
    }

}

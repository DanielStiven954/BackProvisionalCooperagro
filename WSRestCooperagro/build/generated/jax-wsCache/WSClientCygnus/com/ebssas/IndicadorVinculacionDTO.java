
package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for IndicadorVinculacionDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="IndicadorVinculacionDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ICountVinculacion" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="SAsesor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndicadorVinculacionDTO", propOrder = {
    "iCountVinculacion",
    "sAsesor"
})
public class IndicadorVinculacionDTO {

    @XmlElement(name = "ICountVinculacion")
    protected long iCountVinculacion;
    @XmlElement(name = "SAsesor")
    protected String sAsesor;

    /**
     * Gets the value of the iCountVinculacion property.
     * 
     */
    public long getICountVinculacion() {
        return iCountVinculacion;
    }

    /**
     * Sets the value of the iCountVinculacion property.
     * 
     */
    public void setICountVinculacion(long value) {
        this.iCountVinculacion = value;
    }

    /**
     * Gets the value of the sAsesor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSAsesor() {
        return sAsesor;
    }

    /**
     * Sets the value of the sAsesor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSAsesor(String value) {
        this.sAsesor = value;
    }

}

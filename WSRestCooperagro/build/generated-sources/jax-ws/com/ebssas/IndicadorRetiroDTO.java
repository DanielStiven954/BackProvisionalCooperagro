
package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for IndicadorRetiroDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="IndicadorRetiroDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ICountRetiro" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="SMotivoRetiro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndicadorRetiroDTO", propOrder = {
    "iCountRetiro",
    "sMotivoRetiro"
})
public class IndicadorRetiroDTO {

    @XmlElement(name = "ICountRetiro")
    protected long iCountRetiro;
    @XmlElement(name = "SMotivoRetiro")
    protected String sMotivoRetiro;

    /**
     * Gets the value of the iCountRetiro property.
     * 
     */
    public long getICountRetiro() {
        return iCountRetiro;
    }

    /**
     * Sets the value of the iCountRetiro property.
     * 
     */
    public void setICountRetiro(long value) {
        this.iCountRetiro = value;
    }

    /**
     * Gets the value of the sMotivoRetiro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMotivoRetiro() {
        return sMotivoRetiro;
    }

    /**
     * Sets the value of the sMotivoRetiro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMotivoRetiro(String value) {
        this.sMotivoRetiro = value;
    }

}

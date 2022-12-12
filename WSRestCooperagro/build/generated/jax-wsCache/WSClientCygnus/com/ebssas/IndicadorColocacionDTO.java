
package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for IndicadorColocacionDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="IndicadorColocacionDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="DSuma" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="ICountColocacion" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="SCodCredi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndicadorColocacionDTO", propOrder = {
    "dSuma",
    "iCountColocacion",
    "sCodCredi"
})
public class IndicadorColocacionDTO {

    @XmlElement(name = "DSuma")
    protected double dSuma;
    @XmlElement(name = "ICountColocacion")
    protected long iCountColocacion;
    @XmlElement(name = "SCodCredi")
    protected String sCodCredi;

    /**
     * Gets the value of the dSuma property.
     * 
     */
    public double getDSuma() {
        return dSuma;
    }

    /**
     * Sets the value of the dSuma property.
     * 
     */
    public void setDSuma(double value) {
        this.dSuma = value;
    }

    /**
     * Gets the value of the iCountColocacion property.
     * 
     */
    public long getICountColocacion() {
        return iCountColocacion;
    }

    /**
     * Sets the value of the iCountColocacion property.
     * 
     */
    public void setICountColocacion(long value) {
        this.iCountColocacion = value;
    }

    /**
     * Gets the value of the sCodCredi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCodCredi() {
        return sCodCredi;
    }

    /**
     * Sets the value of the sCodCredi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCodCredi(String value) {
        this.sCodCredi = value;
    }

}


package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for IndicadorCarteraDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="IndicadorCarteraDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="DSuma" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="ICountCartera" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="SDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndicadorCarteraDTO", propOrder = {
    "dSuma",
    "iCountCartera",
    "sDescripcion"
})
public class IndicadorCarteraDTO {

    @XmlElement(name = "DSuma")
    protected double dSuma;
    @XmlElement(name = "ICountCartera")
    protected long iCountCartera;
    @XmlElement(name = "SDescripcion")
    protected String sDescripcion;

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
     * Gets the value of the iCountCartera property.
     * 
     */
    public long getICountCartera() {
        return iCountCartera;
    }

    /**
     * Sets the value of the iCountCartera property.
     * 
     */
    public void setICountCartera(long value) {
        this.iCountCartera = value;
    }

    /**
     * Gets the value of the sDescripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescripcion() {
        return sDescripcion;
    }

    /**
     * Sets the value of the sDescripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescripcion(String value) {
        this.sDescripcion = value;
    }

}


package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for Movimiento complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="Movimiento"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="BRtaConsulta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMsjConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LstMovimientos" type="{http://www.ebssystem.com/}ArrayOfDatoDTO" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Movimiento", propOrder = {
    "bRtaConsulta",
    "sMsjConsulta",
    "lstMovimientos"
})
public class Movimiento {

    @XmlElement(name = "BRtaConsulta")
    protected boolean bRtaConsulta;
    @XmlElement(name = "SMsjConsulta")
    protected String sMsjConsulta;
    @XmlElement(name = "LstMovimientos")
    protected ArrayOfDatoDTO lstMovimientos;

    /**
     * Gets the value of the bRtaConsulta property.
     * 
     */
    public boolean isBRtaConsulta() {
        return bRtaConsulta;
    }

    /**
     * Sets the value of the bRtaConsulta property.
     * 
     */
    public void setBRtaConsulta(boolean value) {
        this.bRtaConsulta = value;
    }

    /**
     * Gets the value of the sMsjConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMsjConsulta() {
        return sMsjConsulta;
    }

    /**
     * Sets the value of the sMsjConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMsjConsulta(String value) {
        this.sMsjConsulta = value;
    }

    /**
     * Gets the value of the lstMovimientos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDatoDTO }
     *     
     */
    public ArrayOfDatoDTO getLstMovimientos() {
        return lstMovimientos;
    }

    /**
     * Sets the value of the lstMovimientos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDatoDTO }
     *     
     */
    public void setLstMovimientos(ArrayOfDatoDTO value) {
        this.lstMovimientos = value;
    }

}


package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DetalleAmparadoBenef complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DetalleAmparadoBenef"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CNumRadic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CNombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CApellidos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DPorc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DValor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="BRtaConsulta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMjs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetalleAmparadoBenef", propOrder = {
    "cNumRadic",
    "cIdentificacion",
    "cNombres",
    "cApellidos",
    "dPorc",
    "dValor",
    "bRtaConsulta",
    "sMjs"
})
public class DetalleAmparadoBenef {

    @XmlElement(name = "CNumRadic")
    protected String cNumRadic;
    @XmlElement(name = "CIdentificacion")
    protected String cIdentificacion;
    @XmlElement(name = "CNombres")
    protected String cNombres;
    @XmlElement(name = "CApellidos")
    protected String cApellidos;
    @XmlElement(name = "DPorc")
    protected String dPorc;
    @XmlElement(name = "DValor")
    protected String dValor;
    @XmlElement(name = "BRtaConsulta")
    protected boolean bRtaConsulta;
    @XmlElement(name = "SMjs")
    protected String sMjs;

    /**
     * Gets the value of the cNumRadic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNumRadic() {
        return cNumRadic;
    }

    /**
     * Sets the value of the cNumRadic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNumRadic(String value) {
        this.cNumRadic = value;
    }

    /**
     * Gets the value of the cIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIdentificacion() {
        return cIdentificacion;
    }

    /**
     * Sets the value of the cIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIdentificacion(String value) {
        this.cIdentificacion = value;
    }

    /**
     * Gets the value of the cNombres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNombres() {
        return cNombres;
    }

    /**
     * Sets the value of the cNombres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNombres(String value) {
        this.cNombres = value;
    }

    /**
     * Gets the value of the cApellidos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCApellidos() {
        return cApellidos;
    }

    /**
     * Sets the value of the cApellidos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCApellidos(String value) {
        this.cApellidos = value;
    }

    /**
     * Gets the value of the dPorc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPorc() {
        return dPorc;
    }

    /**
     * Sets the value of the dPorc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPorc(String value) {
        this.dPorc = value;
    }

    /**
     * Gets the value of the dValor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDValor() {
        return dValor;
    }

    /**
     * Sets the value of the dValor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDValor(String value) {
        this.dValor = value;
    }

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
     * Gets the value of the sMjs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMjs() {
        return sMjs;
    }

    /**
     * Sets the value of the sMjs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMjs(String value) {
        this.sMjs = value;
    }

}

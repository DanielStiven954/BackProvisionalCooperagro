
package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for pregseguridadperDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="pregseguridadperDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="I_Tipo_Iden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Campo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pregseguridadperDTO", propOrder = {
    "iTipoIden",
    "cIdentificacion",
    "cCampo"
})
public class PregseguridadperDTO {

    @XmlElement(name = "I_Tipo_Iden")
    protected String iTipoIden;
    @XmlElement(name = "C_Identificacion")
    protected String cIdentificacion;
    @XmlElement(name = "C_Campo")
    protected String cCampo;

    /**
     * Gets the value of the iTipoIden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITipoIden() {
        return iTipoIden;
    }

    /**
     * Sets the value of the iTipoIden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITipoIden(String value) {
        this.iTipoIden = value;
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
     * Gets the value of the cCampo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCampo() {
        return cCampo;
    }

    /**
     * Sets the value of the cCampo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCampo(String value) {
        this.cCampo = value;
    }

}

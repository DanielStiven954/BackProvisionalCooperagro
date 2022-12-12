
package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="WS_CONSULTAR_DATOS_AMPARADOS_BENEFICIARIOResult" type="{http://www.ebssystem.com/}ArrayOfDetalleAmparadoBenef" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsconsultardatosamparadosbeneficiarioResult"
})
@XmlRootElement(name = "WS_CONSULTAR_DATOS_AMPARADOS_BENEFICIARIOResponse")
public class WSCONSULTARDATOSAMPARADOSBENEFICIARIOResponse {

    @XmlElement(name = "WS_CONSULTAR_DATOS_AMPARADOS_BENEFICIARIOResult")
    protected ArrayOfDetalleAmparadoBenef wsconsultardatosamparadosbeneficiarioResult;

    /**
     * Gets the value of the wsconsultardatosamparadosbeneficiarioResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleAmparadoBenef }
     *     
     */
    public ArrayOfDetalleAmparadoBenef getWSCONSULTARDATOSAMPARADOSBENEFICIARIOResult() {
        return wsconsultardatosamparadosbeneficiarioResult;
    }

    /**
     * Sets the value of the wsconsultardatosamparadosbeneficiarioResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleAmparadoBenef }
     *     
     */
    public void setWSCONSULTARDATOSAMPARADOSBENEFICIARIOResult(ArrayOfDetalleAmparadoBenef value) {
        this.wsconsultardatosamparadosbeneficiarioResult = value;
    }

}

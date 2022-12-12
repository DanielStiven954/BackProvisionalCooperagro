
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
 *         &amp;lt;element name="WS_CONSULTAR_MOVIMIENTOS_FECHAResult" type="{http://www.ebssystem.com/}Movimiento" minOccurs="0"/&amp;gt;
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
    "wsconsultarmovimientosfechaResult"
})
@XmlRootElement(name = "WS_CONSULTAR_MOVIMIENTOS_FECHAResponse")
public class WSCONSULTARMOVIMIENTOSFECHAResponse {

    @XmlElement(name = "WS_CONSULTAR_MOVIMIENTOS_FECHAResult")
    protected Movimiento wsconsultarmovimientosfechaResult;

    /**
     * Gets the value of the wsconsultarmovimientosfechaResult property.
     * 
     * @return
     *     possible object is
     *     {@link Movimiento }
     *     
     */
    public Movimiento getWSCONSULTARMOVIMIENTOSFECHAResult() {
        return wsconsultarmovimientosfechaResult;
    }

    /**
     * Sets the value of the wsconsultarmovimientosfechaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Movimiento }
     *     
     */
    public void setWSCONSULTARMOVIMIENTOSFECHAResult(Movimiento value) {
        this.wsconsultarmovimientosfechaResult = value;
    }

}

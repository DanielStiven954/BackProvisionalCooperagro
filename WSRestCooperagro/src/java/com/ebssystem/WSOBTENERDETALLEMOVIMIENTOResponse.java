
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
 *         &amp;lt;element name="WS_OBTENER_DETALLE_MOVIMIENTOResult" type="{http://www.ebssystem.com/}Movimiento" minOccurs="0"/&amp;gt;
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
    "wsobtenerdetallemovimientoResult"
})
@XmlRootElement(name = "WS_OBTENER_DETALLE_MOVIMIENTOResponse")
public class WSOBTENERDETALLEMOVIMIENTOResponse {

    @XmlElement(name = "WS_OBTENER_DETALLE_MOVIMIENTOResult")
    protected Movimiento wsobtenerdetallemovimientoResult;

    /**
     * Gets the value of the wsobtenerdetallemovimientoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Movimiento }
     *     
     */
    public Movimiento getWSOBTENERDETALLEMOVIMIENTOResult() {
        return wsobtenerdetallemovimientoResult;
    }

    /**
     * Sets the value of the wsobtenerdetallemovimientoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Movimiento }
     *     
     */
    public void setWSOBTENERDETALLEMOVIMIENTOResult(Movimiento value) {
        this.wsobtenerdetallemovimientoResult = value;
    }

}

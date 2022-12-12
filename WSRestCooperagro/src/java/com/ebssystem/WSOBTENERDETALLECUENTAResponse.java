
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
 *         &amp;lt;element name="WS_OBTENER_DETALLE_CUENTAResult" type="{http://www.ebssystem.com/}DetalleCta" minOccurs="0"/&amp;gt;
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
    "wsobtenerdetallecuentaResult"
})
@XmlRootElement(name = "WS_OBTENER_DETALLE_CUENTAResponse")
public class WSOBTENERDETALLECUENTAResponse {

    @XmlElement(name = "WS_OBTENER_DETALLE_CUENTAResult")
    protected DetalleCta wsobtenerdetallecuentaResult;

    /**
     * Gets the value of the wsobtenerdetallecuentaResult property.
     * 
     * @return
     *     possible object is
     *     {@link DetalleCta }
     *     
     */
    public DetalleCta getWSOBTENERDETALLECUENTAResult() {
        return wsobtenerdetallecuentaResult;
    }

    /**
     * Sets the value of the wsobtenerdetallecuentaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetalleCta }
     *     
     */
    public void setWSOBTENERDETALLECUENTAResult(DetalleCta value) {
        this.wsobtenerdetallecuentaResult = value;
    }

}


package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &amp;lt;element name="xsFechaCorte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "xsFechaCorte"
})
@XmlRootElement(name = "WS_GET_INDICADOR_CARTERA")
public class WSGETINDICADORCARTERA {

    protected String xsFechaCorte;

    /**
     * Gets the value of the xsFechaCorte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXsFechaCorte() {
        return xsFechaCorte;
    }

    /**
     * Sets the value of the xsFechaCorte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXsFechaCorte(String value) {
        this.xsFechaCorte = value;
    }

}

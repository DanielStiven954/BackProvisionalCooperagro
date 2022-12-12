
package com.ebssas;

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
 *         &amp;lt;element name="WS_GET_INDICADOR_CARTERAResult" type="{http://www.ebssas.com/}ResponseIndicadores" minOccurs="0"/&amp;gt;
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
    "wsgetindicadorcarteraResult"
})
@XmlRootElement(name = "WS_GET_INDICADOR_CARTERAResponse")
public class WSGETINDICADORCARTERAResponse {

    @XmlElement(name = "WS_GET_INDICADOR_CARTERAResult")
    protected ResponseIndicadores wsgetindicadorcarteraResult;

    /**
     * Gets the value of the wsgetindicadorcarteraResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseIndicadores }
     *     
     */
    public ResponseIndicadores getWSGETINDICADORCARTERAResult() {
        return wsgetindicadorcarteraResult;
    }

    /**
     * Sets the value of the wsgetindicadorcarteraResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseIndicadores }
     *     
     */
    public void setWSGETINDICADORCARTERAResult(ResponseIndicadores value) {
        this.wsgetindicadorcarteraResult = value;
    }

}

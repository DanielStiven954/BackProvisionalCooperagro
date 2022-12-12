
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
 *         &amp;lt;element name="WS_GET_INDICADOR_COLOCACIONResult" type="{http://www.ebssas.com/}ResponseIndicadores" minOccurs="0"/&amp;gt;
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
    "wsgetindicadorcolocacionResult"
})
@XmlRootElement(name = "WS_GET_INDICADOR_COLOCACIONResponse")
public class WSGETINDICADORCOLOCACIONResponse {

    @XmlElement(name = "WS_GET_INDICADOR_COLOCACIONResult")
    protected ResponseIndicadores wsgetindicadorcolocacionResult;

    /**
     * Gets the value of the wsgetindicadorcolocacionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseIndicadores }
     *     
     */
    public ResponseIndicadores getWSGETINDICADORCOLOCACIONResult() {
        return wsgetindicadorcolocacionResult;
    }

    /**
     * Sets the value of the wsgetindicadorcolocacionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseIndicadores }
     *     
     */
    public void setWSGETINDICADORCOLOCACIONResult(ResponseIndicadores value) {
        this.wsgetindicadorcolocacionResult = value;
    }

}

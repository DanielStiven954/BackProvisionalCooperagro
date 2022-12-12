
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
 *         &amp;lt;element name="WS_GET_INDICADOR_VINCULACIONResult" type="{http://www.ebssas.com/}ResponseIndicadores" minOccurs="0"/&amp;gt;
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
    "wsgetindicadorvinculacionResult"
})
@XmlRootElement(name = "WS_GET_INDICADOR_VINCULACIONResponse")
public class WSGETINDICADORVINCULACIONResponse {

    @XmlElement(name = "WS_GET_INDICADOR_VINCULACIONResult")
    protected ResponseIndicadores wsgetindicadorvinculacionResult;

    /**
     * Gets the value of the wsgetindicadorvinculacionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseIndicadores }
     *     
     */
    public ResponseIndicadores getWSGETINDICADORVINCULACIONResult() {
        return wsgetindicadorvinculacionResult;
    }

    /**
     * Sets the value of the wsgetindicadorvinculacionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseIndicadores }
     *     
     */
    public void setWSGETINDICADORVINCULACIONResult(ResponseIndicadores value) {
        this.wsgetindicadorvinculacionResult = value;
    }

}

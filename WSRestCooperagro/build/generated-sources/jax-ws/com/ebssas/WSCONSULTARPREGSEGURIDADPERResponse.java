
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
 *         &amp;lt;element name="WS_CONSULTAR_PREGSEGURIDADPERResult" type="{http://www.ebssas.com/}ArrayOfPregseguridadperDTO" minOccurs="0"/&amp;gt;
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
    "wsconsultarpregseguridadperResult"
})
@XmlRootElement(name = "WS_CONSULTAR_PREGSEGURIDADPERResponse")
public class WSCONSULTARPREGSEGURIDADPERResponse {

    @XmlElement(name = "WS_CONSULTAR_PREGSEGURIDADPERResult")
    protected ArrayOfPregseguridadperDTO wsconsultarpregseguridadperResult;

    /**
     * Gets the value of the wsconsultarpregseguridadperResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPregseguridadperDTO }
     *     
     */
    public ArrayOfPregseguridadperDTO getWSCONSULTARPREGSEGURIDADPERResult() {
        return wsconsultarpregseguridadperResult;
    }

    /**
     * Sets the value of the wsconsultarpregseguridadperResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPregseguridadperDTO }
     *     
     */
    public void setWSCONSULTARPREGSEGURIDADPERResult(ArrayOfPregseguridadperDTO value) {
        this.wsconsultarpregseguridadperResult = value;
    }

}

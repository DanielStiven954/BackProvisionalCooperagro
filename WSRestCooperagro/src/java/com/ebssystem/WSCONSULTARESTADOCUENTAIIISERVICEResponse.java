
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
 *         &amp;lt;element name="WS_CONSULTAR_ESTADOCUENTAIIISERVICEResult" type="{http://www.ebssystem.com/}ArrayOfDato2DTO" minOccurs="0"/&amp;gt;
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
    "wsconsultarestadocuentaiiiserviceResult"
})
@XmlRootElement(name = "WS_CONSULTAR_ESTADOCUENTAIIISERVICEResponse")
public class WSCONSULTARESTADOCUENTAIIISERVICEResponse {

    @XmlElement(name = "WS_CONSULTAR_ESTADOCUENTAIIISERVICEResult")
    protected ArrayOfDato2DTO wsconsultarestadocuentaiiiserviceResult;

    /**
     * Gets the value of the wsconsultarestadocuentaiiiserviceResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDato2DTO }
     *     
     */
    public ArrayOfDato2DTO getWSCONSULTARESTADOCUENTAIIISERVICEResult() {
        return wsconsultarestadocuentaiiiserviceResult;
    }

    /**
     * Sets the value of the wsconsultarestadocuentaiiiserviceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDato2DTO }
     *     
     */
    public void setWSCONSULTARESTADOCUENTAIIISERVICEResult(ArrayOfDato2DTO value) {
        this.wsconsultarestadocuentaiiiserviceResult = value;
    }

}

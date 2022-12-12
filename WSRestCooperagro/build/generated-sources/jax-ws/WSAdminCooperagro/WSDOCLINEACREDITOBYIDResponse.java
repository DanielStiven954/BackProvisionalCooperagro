
package WSAdminCooperagro;

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
 *         &amp;lt;element name="WS_DOC_LINEA_CREDITO_BY_IDResult" type="{https://ebssas.com/}ResponseDocCredito" minOccurs="0"/&amp;gt;
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
    "wsdoclineacreditobyidResult"
})
@XmlRootElement(name = "WS_DOC_LINEA_CREDITO_BY_IDResponse")
public class WSDOCLINEACREDITOBYIDResponse {

    @XmlElement(name = "WS_DOC_LINEA_CREDITO_BY_IDResult")
    protected ResponseDocCredito wsdoclineacreditobyidResult;

    /**
     * Gets the value of the wsdoclineacreditobyidResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseDocCredito }
     *     
     */
    public ResponseDocCredito getWSDOCLINEACREDITOBYIDResult() {
        return wsdoclineacreditobyidResult;
    }

    /**
     * Sets the value of the wsdoclineacreditobyidResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseDocCredito }
     *     
     */
    public void setWSDOCLINEACREDITOBYIDResult(ResponseDocCredito value) {
        this.wsdoclineacreditobyidResult = value;
    }

}

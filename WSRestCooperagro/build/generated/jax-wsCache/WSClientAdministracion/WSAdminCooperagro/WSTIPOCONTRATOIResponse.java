
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
 *         &amp;lt;element name="WS_TIPO_CONTRATO_IResult" type="{https://ebssas.com/}ResponseTipoContrato" minOccurs="0"/&amp;gt;
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
    "wstipocontratoiResult"
})
@XmlRootElement(name = "WS_TIPO_CONTRATO_IResponse")
public class WSTIPOCONTRATOIResponse {

    @XmlElement(name = "WS_TIPO_CONTRATO_IResult")
    protected ResponseTipoContrato wstipocontratoiResult;

    /**
     * Gets the value of the wstipocontratoiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseTipoContrato }
     *     
     */
    public ResponseTipoContrato getWSTIPOCONTRATOIResult() {
        return wstipocontratoiResult;
    }

    /**
     * Sets the value of the wstipocontratoiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseTipoContrato }
     *     
     */
    public void setWSTIPOCONTRATOIResult(ResponseTipoContrato value) {
        this.wstipocontratoiResult = value;
    }

}

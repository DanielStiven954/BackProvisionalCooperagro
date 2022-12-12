
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
 *         &amp;lt;element name="WS_TIPO_FORMA_PAGO_IIResult" type="{https://ebssas.com/}ResponseTipoPago" minOccurs="0"/&amp;gt;
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
    "wstipoformapagoiiResult"
})
@XmlRootElement(name = "WS_TIPO_FORMA_PAGO_IIResponse")
public class WSTIPOFORMAPAGOIIResponse {

    @XmlElement(name = "WS_TIPO_FORMA_PAGO_IIResult")
    protected ResponseTipoPago wstipoformapagoiiResult;

    /**
     * Gets the value of the wstipoformapagoiiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseTipoPago }
     *     
     */
    public ResponseTipoPago getWSTIPOFORMAPAGOIIResult() {
        return wstipoformapagoiiResult;
    }

    /**
     * Sets the value of the wstipoformapagoiiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseTipoPago }
     *     
     */
    public void setWSTIPOFORMAPAGOIIResult(ResponseTipoPago value) {
        this.wstipoformapagoiiResult = value;
    }

}

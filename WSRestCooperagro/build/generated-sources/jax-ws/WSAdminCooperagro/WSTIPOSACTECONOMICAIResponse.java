
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
 *         &amp;lt;element name="WS_TIPOS_ACT_ECONOMICA_IResult" type="{https://ebssas.com/}ResponseActividadEconomica" minOccurs="0"/&amp;gt;
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
    "wstiposacteconomicaiResult"
})
@XmlRootElement(name = "WS_TIPOS_ACT_ECONOMICA_IResponse")
public class WSTIPOSACTECONOMICAIResponse {

    @XmlElement(name = "WS_TIPOS_ACT_ECONOMICA_IResult")
    protected ResponseActividadEconomica wstiposacteconomicaiResult;

    /**
     * Gets the value of the wstiposacteconomicaiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseActividadEconomica }
     *     
     */
    public ResponseActividadEconomica getWSTIPOSACTECONOMICAIResult() {
        return wstiposacteconomicaiResult;
    }

    /**
     * Sets the value of the wstiposacteconomicaiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseActividadEconomica }
     *     
     */
    public void setWSTIPOSACTECONOMICAIResult(ResponseActividadEconomica value) {
        this.wstiposacteconomicaiResult = value;
    }

}

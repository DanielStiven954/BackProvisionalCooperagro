
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
 *         &amp;lt;element name="WS_TIPOS_IDENTIFICACION_IIResult" type="{https://ebssas.com/}ResponseTiposIdent" minOccurs="0"/&amp;gt;
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
    "wstiposidentificacioniiResult"
})
@XmlRootElement(name = "WS_TIPOS_IDENTIFICACION_IIResponse")
public class WSTIPOSIDENTIFICACIONIIResponse {

    @XmlElement(name = "WS_TIPOS_IDENTIFICACION_IIResult")
    protected ResponseTiposIdent wstiposidentificacioniiResult;

    /**
     * Gets the value of the wstiposidentificacioniiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseTiposIdent }
     *     
     */
    public ResponseTiposIdent getWSTIPOSIDENTIFICACIONIIResult() {
        return wstiposidentificacioniiResult;
    }

    /**
     * Sets the value of the wstiposidentificacioniiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseTiposIdent }
     *     
     */
    public void setWSTIPOSIDENTIFICACIONIIResult(ResponseTiposIdent value) {
        this.wstiposidentificacioniiResult = value;
    }

}

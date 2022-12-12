
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
 *         &amp;lt;element name="WS_TIPOS_NIV_ESTUDIO_IIResult" type="{https://ebssas.com/}ResponseNivelesEstudio" minOccurs="0"/&amp;gt;
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
    "wstiposnivestudioiiResult"
})
@XmlRootElement(name = "WS_TIPOS_NIV_ESTUDIO_IIResponse")
public class WSTIPOSNIVESTUDIOIIResponse {

    @XmlElement(name = "WS_TIPOS_NIV_ESTUDIO_IIResult")
    protected ResponseNivelesEstudio wstiposnivestudioiiResult;

    /**
     * Gets the value of the wstiposnivestudioiiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseNivelesEstudio }
     *     
     */
    public ResponseNivelesEstudio getWSTIPOSNIVESTUDIOIIResult() {
        return wstiposnivestudioiiResult;
    }

    /**
     * Sets the value of the wstiposnivestudioiiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseNivelesEstudio }
     *     
     */
    public void setWSTIPOSNIVESTUDIOIIResult(ResponseNivelesEstudio value) {
        this.wstiposnivestudioiiResult = value;
    }

}

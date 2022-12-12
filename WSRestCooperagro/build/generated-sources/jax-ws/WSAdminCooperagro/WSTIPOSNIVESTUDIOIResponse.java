
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
 *         &amp;lt;element name="WS_TIPOS_NIV_ESTUDIO_IResult" type="{https://ebssas.com/}ResponseNivelesEstudio" minOccurs="0"/&amp;gt;
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
    "wstiposnivestudioiResult"
})
@XmlRootElement(name = "WS_TIPOS_NIV_ESTUDIO_IResponse")
public class WSTIPOSNIVESTUDIOIResponse {

    @XmlElement(name = "WS_TIPOS_NIV_ESTUDIO_IResult")
    protected ResponseNivelesEstudio wstiposnivestudioiResult;

    /**
     * Gets the value of the wstiposnivestudioiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseNivelesEstudio }
     *     
     */
    public ResponseNivelesEstudio getWSTIPOSNIVESTUDIOIResult() {
        return wstiposnivestudioiResult;
    }

    /**
     * Sets the value of the wstiposnivestudioiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseNivelesEstudio }
     *     
     */
    public void setWSTIPOSNIVESTUDIOIResult(ResponseNivelesEstudio value) {
        this.wstiposnivestudioiResult = value;
    }

}


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
 *         &amp;lt;element name="WS_CIUDAD_IIResult" type="{https://ebssas.com/}ResponseCiudad" minOccurs="0"/&amp;gt;
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
    "wsciudadiiResult"
})
@XmlRootElement(name = "WS_CIUDAD_IIResponse")
public class WSCIUDADIIResponse {

    @XmlElement(name = "WS_CIUDAD_IIResult")
    protected ResponseCiudad wsciudadiiResult;

    /**
     * Gets the value of the wsciudadiiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCiudad }
     *     
     */
    public ResponseCiudad getWSCIUDADIIResult() {
        return wsciudadiiResult;
    }

    /**
     * Sets the value of the wsciudadiiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCiudad }
     *     
     */
    public void setWSCIUDADIIResult(ResponseCiudad value) {
        this.wsciudadiiResult = value;
    }

}

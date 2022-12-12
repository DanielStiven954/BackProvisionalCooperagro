
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
 *         &amp;lt;element name="WS_CIUDAD_IResult" type="{https://ebssas.com/}ResponseCiudad" minOccurs="0"/&amp;gt;
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
    "wsciudadiResult"
})
@XmlRootElement(name = "WS_CIUDAD_IResponse")
public class WSCIUDADIResponse {

    @XmlElement(name = "WS_CIUDAD_IResult")
    protected ResponseCiudad wsciudadiResult;

    /**
     * Gets the value of the wsciudadiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCiudad }
     *     
     */
    public ResponseCiudad getWSCIUDADIResult() {
        return wsciudadiResult;
    }

    /**
     * Sets the value of the wsciudadiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCiudad }
     *     
     */
    public void setWSCIUDADIResult(ResponseCiudad value) {
        this.wsciudadiResult = value;
    }

}

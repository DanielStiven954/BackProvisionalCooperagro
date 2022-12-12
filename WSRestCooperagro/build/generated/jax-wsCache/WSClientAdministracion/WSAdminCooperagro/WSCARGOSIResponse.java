
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
 *         &amp;lt;element name="WS_CARGOS_IResult" type="{https://ebssas.com/}ResponseCargo" minOccurs="0"/&amp;gt;
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
    "wscargosiResult"
})
@XmlRootElement(name = "WS_CARGOS_IResponse")
public class WSCARGOSIResponse {

    @XmlElement(name = "WS_CARGOS_IResult")
    protected ResponseCargo wscargosiResult;

    /**
     * Gets the value of the wscargosiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCargo }
     *     
     */
    public ResponseCargo getWSCARGOSIResult() {
        return wscargosiResult;
    }

    /**
     * Sets the value of the wscargosiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCargo }
     *     
     */
    public void setWSCARGOSIResult(ResponseCargo value) {
        this.wscargosiResult = value;
    }

}

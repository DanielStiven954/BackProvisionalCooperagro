
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
 *         &amp;lt;element name="WS_ENTIDADES_IResult" type="{https://ebssas.com/}ResponseEntidad" minOccurs="0"/&amp;gt;
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
    "wsentidadesiResult"
})
@XmlRootElement(name = "WS_ENTIDADES_IResponse")
public class WSENTIDADESIResponse {

    @XmlElement(name = "WS_ENTIDADES_IResult")
    protected ResponseEntidad wsentidadesiResult;

    /**
     * Gets the value of the wsentidadesiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseEntidad }
     *     
     */
    public ResponseEntidad getWSENTIDADESIResult() {
        return wsentidadesiResult;
    }

    /**
     * Sets the value of the wsentidadesiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseEntidad }
     *     
     */
    public void setWSENTIDADESIResult(ResponseEntidad value) {
        this.wsentidadesiResult = value;
    }

}

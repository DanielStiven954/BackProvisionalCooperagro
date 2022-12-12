
package wsmovimientoscygnus_retefuente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &amp;lt;element name="retefuenteResult" type="{WSMovimientosCygnus_retefuente}RespuestaCert" minOccurs="0"/&amp;gt;
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
    "retefuenteResult"
})
@XmlRootElement(name = "retefuenteResponse")
public class RetefuenteResponse {

    protected RespuestaCert retefuenteResult;

    /**
     * Gets the value of the retefuenteResult property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCert }
     *     
     */
    public RespuestaCert getRetefuenteResult() {
        return retefuenteResult;
    }

    /**
     * Sets the value of the retefuenteResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCert }
     *     
     */
    public void setRetefuenteResult(RespuestaCert value) {
        this.retefuenteResult = value;
    }

}


package wsmovimientoscygnus_retefuente;

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
 *         &amp;lt;element name="retefuente_coopedacResult" type="{WSMovimientosCygnus_retefuente}RespuestaCert" minOccurs="0"/&amp;gt;
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
    "retefuenteCoopedacResult"
})
@XmlRootElement(name = "retefuente_coopedacResponse")
public class RetefuenteCoopedacResponse {

    @XmlElement(name = "retefuente_coopedacResult")
    protected RespuestaCert retefuenteCoopedacResult;

    /**
     * Gets the value of the retefuenteCoopedacResult property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCert }
     *     
     */
    public RespuestaCert getRetefuenteCoopedacResult() {
        return retefuenteCoopedacResult;
    }

    /**
     * Sets the value of the retefuenteCoopedacResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCert }
     *     
     */
    public void setRetefuenteCoopedacResult(RespuestaCert value) {
        this.retefuenteCoopedacResult = value;
    }

}


package wssimuladorcredito;

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
 *         &amp;lt;element name="WS_CONSULTA_VALPRIMERACUOTAResult" type="{WSSimuladorCredito}Respuesta_cuotas" minOccurs="0"/&amp;gt;
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
    "wsconsultavalprimeracuotaResult"
})
@XmlRootElement(name = "WS_CONSULTA_VALPRIMERACUOTAResponse")
public class WSCONSULTAVALPRIMERACUOTAResponse {

    @XmlElement(name = "WS_CONSULTA_VALPRIMERACUOTAResult")
    protected RespuestaCuotas wsconsultavalprimeracuotaResult;

    /**
     * Gets the value of the wsconsultavalprimeracuotaResult property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCuotas }
     *     
     */
    public RespuestaCuotas getWSCONSULTAVALPRIMERACUOTAResult() {
        return wsconsultavalprimeracuotaResult;
    }

    /**
     * Sets the value of the wsconsultavalprimeracuotaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCuotas }
     *     
     */
    public void setWSCONSULTAVALPRIMERACUOTAResult(RespuestaCuotas value) {
        this.wsconsultavalprimeracuotaResult = value;
    }

}

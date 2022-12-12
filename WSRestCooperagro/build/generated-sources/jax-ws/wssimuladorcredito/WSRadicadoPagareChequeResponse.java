
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
 *         &amp;lt;element name="WS_RadicadoPagareChequeResult" type="{WSSimuladorCredito}RespuestaRegistro" minOccurs="0"/&amp;gt;
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
    "wsRadicadoPagareChequeResult"
})
@XmlRootElement(name = "WS_RadicadoPagareChequeResponse")
public class WSRadicadoPagareChequeResponse {

    @XmlElement(name = "WS_RadicadoPagareChequeResult")
    protected RespuestaRegistro wsRadicadoPagareChequeResult;

    /**
     * Gets the value of the wsRadicadoPagareChequeResult property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaRegistro }
     *     
     */
    public RespuestaRegistro getWSRadicadoPagareChequeResult() {
        return wsRadicadoPagareChequeResult;
    }

    /**
     * Sets the value of the wsRadicadoPagareChequeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaRegistro }
     *     
     */
    public void setWSRadicadoPagareChequeResult(RespuestaRegistro value) {
        this.wsRadicadoPagareChequeResult = value;
    }

}

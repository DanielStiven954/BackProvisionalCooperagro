
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
 *         &amp;lt;element name="WS_LINEAS_SERVICIOResult" type="{https://ebssas.com/}ResponseLineaCredito" minOccurs="0"/&amp;gt;
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
    "wslineasservicioResult"
})
@XmlRootElement(name = "WS_LINEAS_SERVICIOResponse")
public class WSLINEASSERVICIOResponse {

    @XmlElement(name = "WS_LINEAS_SERVICIOResult")
    protected ResponseLineaCredito wslineasservicioResult;

    /**
     * Gets the value of the wslineasservicioResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseLineaCredito }
     *     
     */
    public ResponseLineaCredito getWSLINEASSERVICIOResult() {
        return wslineasservicioResult;
    }

    /**
     * Sets the value of the wslineasservicioResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseLineaCredito }
     *     
     */
    public void setWSLINEASSERVICIOResult(ResponseLineaCredito value) {
        this.wslineasservicioResult = value;
    }

}

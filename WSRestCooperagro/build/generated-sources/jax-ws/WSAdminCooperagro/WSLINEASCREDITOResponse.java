
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
 *         &amp;lt;element name="WS_LINEAS_CREDITOResult" type="{https://ebssas.com/}ResponseLineaCredito" minOccurs="0"/&amp;gt;
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
    "wslineascreditoResult"
})
@XmlRootElement(name = "WS_LINEAS_CREDITOResponse")
public class WSLINEASCREDITOResponse {

    @XmlElement(name = "WS_LINEAS_CREDITOResult")
    protected ResponseLineaCredito wslineascreditoResult;

    /**
     * Gets the value of the wslineascreditoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseLineaCredito }
     *     
     */
    public ResponseLineaCredito getWSLINEASCREDITOResult() {
        return wslineascreditoResult;
    }

    /**
     * Sets the value of the wslineascreditoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseLineaCredito }
     *     
     */
    public void setWSLINEASCREDITOResult(ResponseLineaCredito value) {
        this.wslineascreditoResult = value;
    }

}

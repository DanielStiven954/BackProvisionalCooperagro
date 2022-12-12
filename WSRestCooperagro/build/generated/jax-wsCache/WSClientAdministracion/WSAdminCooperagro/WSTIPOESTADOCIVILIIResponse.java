
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
 *         &amp;lt;element name="WS_TIPO_ESTADO_CIVIL_IIResult" type="{https://ebssas.com/}ResponseTipoEstadoCivil" minOccurs="0"/&amp;gt;
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
    "wstipoestadociviliiResult"
})
@XmlRootElement(name = "WS_TIPO_ESTADO_CIVIL_IIResponse")
public class WSTIPOESTADOCIVILIIResponse {

    @XmlElement(name = "WS_TIPO_ESTADO_CIVIL_IIResult")
    protected ResponseTipoEstadoCivil wstipoestadociviliiResult;

    /**
     * Gets the value of the wstipoestadociviliiResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseTipoEstadoCivil }
     *     
     */
    public ResponseTipoEstadoCivil getWSTIPOESTADOCIVILIIResult() {
        return wstipoestadociviliiResult;
    }

    /**
     * Sets the value of the wstipoestadociviliiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseTipoEstadoCivil }
     *     
     */
    public void setWSTIPOESTADOCIVILIIResult(ResponseTipoEstadoCivil value) {
        this.wstipoestadociviliiResult = value;
    }

}

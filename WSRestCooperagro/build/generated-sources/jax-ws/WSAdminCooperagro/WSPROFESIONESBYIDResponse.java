
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
 *         &amp;lt;element name="WS_PROFESIONES_BY_IDResult" type="{https://ebssas.com/}ResponseProfesion" minOccurs="0"/&amp;gt;
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
    "wsprofesionesbyidResult"
})
@XmlRootElement(name = "WS_PROFESIONES_BY_IDResponse")
public class WSPROFESIONESBYIDResponse {

    @XmlElement(name = "WS_PROFESIONES_BY_IDResult")
    protected ResponseProfesion wsprofesionesbyidResult;

    /**
     * Gets the value of the wsprofesionesbyidResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseProfesion }
     *     
     */
    public ResponseProfesion getWSPROFESIONESBYIDResult() {
        return wsprofesionesbyidResult;
    }

    /**
     * Sets the value of the wsprofesionesbyidResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseProfesion }
     *     
     */
    public void setWSPROFESIONESBYIDResult(ResponseProfesion value) {
        this.wsprofesionesbyidResult = value;
    }

}

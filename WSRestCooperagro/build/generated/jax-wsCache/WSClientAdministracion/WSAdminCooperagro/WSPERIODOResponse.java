
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
 *         &amp;lt;element name="WS_PERIODOResult" type="{https://ebssas.com/}ResponsePeriodo" minOccurs="0"/&amp;gt;
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
    "wsperiodoResult"
})
@XmlRootElement(name = "WS_PERIODOResponse")
public class WSPERIODOResponse {

    @XmlElement(name = "WS_PERIODOResult")
    protected ResponsePeriodo wsperiodoResult;

    /**
     * Gets the value of the wsperiodoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponsePeriodo }
     *     
     */
    public ResponsePeriodo getWSPERIODOResult() {
        return wsperiodoResult;
    }

    /**
     * Sets the value of the wsperiodoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsePeriodo }
     *     
     */
    public void setWSPERIODOResult(ResponsePeriodo value) {
        this.wsperiodoResult = value;
    }

}

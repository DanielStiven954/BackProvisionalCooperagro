
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
 *         &amp;lt;element name="WS_PERIODOBYIDResult" type="{https://ebssas.com/}ResponsePeriodo" minOccurs="0"/&amp;gt;
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
    "wsperiodobyidResult"
})
@XmlRootElement(name = "WS_PERIODOBYIDResponse")
public class WSPERIODOBYIDResponse {

    @XmlElement(name = "WS_PERIODOBYIDResult")
    protected ResponsePeriodo wsperiodobyidResult;

    /**
     * Gets the value of the wsperiodobyidResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResponsePeriodo }
     *     
     */
    public ResponsePeriodo getWSPERIODOBYIDResult() {
        return wsperiodobyidResult;
    }

    /**
     * Sets the value of the wsperiodobyidResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsePeriodo }
     *     
     */
    public void setWSPERIODOBYIDResult(ResponsePeriodo value) {
        this.wsperiodobyidResult = value;
    }

}

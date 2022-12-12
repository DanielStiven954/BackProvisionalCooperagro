
package wspersonascygnus;

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
 *         &amp;lt;element name="WC_CREAR_PERSONABASICOResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "wccrearpersonabasicoResult"
})
@XmlRootElement(name = "WC_CREAR_PERSONABASICOResponse")
public class WCCREARPERSONABASICOResponse {

    @XmlElement(name = "WC_CREAR_PERSONABASICOResult")
    protected String wccrearpersonabasicoResult;

    /**
     * Gets the value of the wccrearpersonabasicoResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWCCREARPERSONABASICOResult() {
        return wccrearpersonabasicoResult;
    }

    /**
     * Sets the value of the wccrearpersonabasicoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWCCREARPERSONABASICOResult(String value) {
        this.wccrearpersonabasicoResult = value;
    }

}

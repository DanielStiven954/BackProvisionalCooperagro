
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
 *         &amp;lt;element name="WC_CREAR_PERSONASResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "wccrearpersonasResult"
})
@XmlRootElement(name = "WC_CREAR_PERSONASResponse")
public class WCCREARPERSONASResponse {

    @XmlElement(name = "WC_CREAR_PERSONASResult")
    protected String wccrearpersonasResult;

    /**
     * Gets the value of the wccrearpersonasResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWCCREARPERSONASResult() {
        return wccrearpersonasResult;
    }

    /**
     * Sets the value of the wccrearpersonasResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWCCREARPERSONASResult(String value) {
        this.wccrearpersonasResult = value;
    }

}

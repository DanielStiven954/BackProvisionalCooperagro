
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
 *         &amp;lt;element name="WC_CREAR_ROLPERSONASResult" type="{WSPersonasCygnus}RespuestaCrea" minOccurs="0"/&amp;gt;
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
    "wccrearrolpersonasResult"
})
@XmlRootElement(name = "WC_CREAR_ROLPERSONASResponse")
public class WCCREARROLPERSONASResponse {

    @XmlElement(name = "WC_CREAR_ROLPERSONASResult")
    protected RespuestaCrea wccrearrolpersonasResult;

    /**
     * Gets the value of the wccrearrolpersonasResult property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCrea }
     *     
     */
    public RespuestaCrea getWCCREARROLPERSONASResult() {
        return wccrearrolpersonasResult;
    }

    /**
     * Sets the value of the wccrearrolpersonasResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCrea }
     *     
     */
    public void setWCCREARROLPERSONASResult(RespuestaCrea value) {
        this.wccrearrolpersonasResult = value;
    }

}


package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &amp;lt;element name="calculoCuposResult" type="{WSSimuladorCredito}RespuestaCupo" minOccurs="0"/&amp;gt;
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
    "calculoCuposResult"
})
@XmlRootElement(name = "calculoCuposResponse")
public class CalculoCuposResponse {

    protected RespuestaCupo calculoCuposResult;

    /**
     * Gets the value of the calculoCuposResult property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaCupo }
     *     
     */
    public RespuestaCupo getCalculoCuposResult() {
        return calculoCuposResult;
    }

    /**
     * Sets the value of the calculoCuposResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaCupo }
     *     
     */
    public void setCalculoCuposResult(RespuestaCupo value) {
        this.calculoCuposResult = value;
    }

}

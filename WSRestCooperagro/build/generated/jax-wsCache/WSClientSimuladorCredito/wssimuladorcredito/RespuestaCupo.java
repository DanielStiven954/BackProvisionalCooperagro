
package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RespuestaCupo complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RespuestaCupo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}SalFunctionalClass"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="R_s_max_monto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_s_max_plazo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_s_cupo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_s_tfijos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaCupo", propOrder = {
    "rsMaxMonto",
    "rsMaxPlazo",
    "rsCupo",
    "rsTfijos"
})
public class RespuestaCupo
    extends SalFunctionalClass
{

    @XmlElement(name = "R_s_max_monto")
    protected String rsMaxMonto;
    @XmlElement(name = "R_s_max_plazo")
    protected String rsMaxPlazo;
    @XmlElement(name = "R_s_cupo")
    protected String rsCupo;
    @XmlElement(name = "R_s_tfijos")
    protected String rsTfijos;

    /**
     * Gets the value of the rsMaxMonto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRSMaxMonto() {
        return rsMaxMonto;
    }

    /**
     * Sets the value of the rsMaxMonto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRSMaxMonto(String value) {
        this.rsMaxMonto = value;
    }

    /**
     * Gets the value of the rsMaxPlazo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRSMaxPlazo() {
        return rsMaxPlazo;
    }

    /**
     * Sets the value of the rsMaxPlazo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRSMaxPlazo(String value) {
        this.rsMaxPlazo = value;
    }

    /**
     * Gets the value of the rsCupo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRSCupo() {
        return rsCupo;
    }

    /**
     * Sets the value of the rsCupo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRSCupo(String value) {
        this.rsCupo = value;
    }

    /**
     * Gets the value of the rsTfijos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRSTfijos() {
        return rsTfijos;
    }

    /**
     * Sets the value of the rsTfijos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRSTfijos(String value) {
        this.rsTfijos = value;
    }

}

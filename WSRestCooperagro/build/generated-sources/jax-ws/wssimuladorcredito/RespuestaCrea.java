
package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RespuestaCrea complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RespuestaCrea"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="R_s_mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_numRadic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_numDesti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_Val_cuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaCrea", propOrder = {
    "rsMensaje",
    "rNumRadic",
    "rNumDesti",
    "rValCuota"
})
public class RespuestaCrea
    extends General
{

    @XmlElement(name = "R_s_mensaje")
    protected String rsMensaje;
    @XmlElement(name = "R_numRadic")
    protected String rNumRadic;
    @XmlElement(name = "R_numDesti")
    protected String rNumDesti;
    @XmlElement(name = "R_Val_cuota")
    protected String rValCuota;

    /**
     * Gets the value of the rsMensaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRSMensaje() {
        return rsMensaje;
    }

    /**
     * Sets the value of the rsMensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRSMensaje(String value) {
        this.rsMensaje = value;
    }

    /**
     * Gets the value of the rNumRadic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRNumRadic() {
        return rNumRadic;
    }

    /**
     * Sets the value of the rNumRadic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRNumRadic(String value) {
        this.rNumRadic = value;
    }

    /**
     * Gets the value of the rNumDesti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRNumDesti() {
        return rNumDesti;
    }

    /**
     * Sets the value of the rNumDesti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRNumDesti(String value) {
        this.rNumDesti = value;
    }

    /**
     * Gets the value of the rValCuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRValCuota() {
        return rValCuota;
    }

    /**
     * Sets the value of the rValCuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRValCuota(String value) {
        this.rValCuota = value;
    }

}

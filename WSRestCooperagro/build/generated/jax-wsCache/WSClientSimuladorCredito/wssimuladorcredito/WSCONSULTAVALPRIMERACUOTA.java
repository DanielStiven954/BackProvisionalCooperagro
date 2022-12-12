
package wssimuladorcredito;

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
 *         &amp;lt;element name="pws_num_radic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_cod_desti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_cod_desem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_fecha_pag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_bd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_usu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_psw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "pwsNumRadic",
    "pwsCodDesti",
    "pwsCodDesem",
    "pwsFechaPag",
    "pwsBd",
    "pwsUsu",
    "pwsPsw"
})
@XmlRootElement(name = "WS_CONSULTA_VALPRIMERACUOTA")
public class WSCONSULTAVALPRIMERACUOTA {

    @XmlElement(name = "pws_num_radic")
    protected String pwsNumRadic;
    @XmlElement(name = "pws_cod_desti")
    protected String pwsCodDesti;
    @XmlElement(name = "pws_cod_desem")
    protected String pwsCodDesem;
    @XmlElement(name = "pws_fecha_pag")
    protected String pwsFechaPag;
    @XmlElement(name = "pws_bd")
    protected String pwsBd;
    @XmlElement(name = "pws_usu")
    protected String pwsUsu;
    @XmlElement(name = "pws_psw")
    protected String pwsPsw;

    /**
     * Gets the value of the pwsNumRadic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsNumRadic() {
        return pwsNumRadic;
    }

    /**
     * Sets the value of the pwsNumRadic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsNumRadic(String value) {
        this.pwsNumRadic = value;
    }

    /**
     * Gets the value of the pwsCodDesti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsCodDesti() {
        return pwsCodDesti;
    }

    /**
     * Sets the value of the pwsCodDesti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsCodDesti(String value) {
        this.pwsCodDesti = value;
    }

    /**
     * Gets the value of the pwsCodDesem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsCodDesem() {
        return pwsCodDesem;
    }

    /**
     * Sets the value of the pwsCodDesem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsCodDesem(String value) {
        this.pwsCodDesem = value;
    }

    /**
     * Gets the value of the pwsFechaPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFechaPag() {
        return pwsFechaPag;
    }

    /**
     * Sets the value of the pwsFechaPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFechaPag(String value) {
        this.pwsFechaPag = value;
    }

    /**
     * Gets the value of the pwsBd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsBd() {
        return pwsBd;
    }

    /**
     * Sets the value of the pwsBd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsBd(String value) {
        this.pwsBd = value;
    }

    /**
     * Gets the value of the pwsUsu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsUsu() {
        return pwsUsu;
    }

    /**
     * Sets the value of the pwsUsu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsUsu(String value) {
        this.pwsUsu = value;
    }

    /**
     * Gets the value of the pwsPsw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsPsw() {
        return pwsPsw;
    }

    /**
     * Sets the value of the pwsPsw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsPsw(String value) {
        this.pwsPsw = value;
    }

}


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
 *         &amp;lt;element name="pws_codigoPer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_numRol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_fechaInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "pwsCodigoPer",
    "pwsNumRol",
    "pwsFechaInicio",
    "pwsBd",
    "pwsUsu",
    "pwsPsw"
})
@XmlRootElement(name = "WC_CREAR_ROLPERSONAS")
public class WCCREARROLPERSONAS {

    @XmlElement(name = "pws_codigoPer")
    protected String pwsCodigoPer;
    @XmlElement(name = "pws_numRol")
    protected String pwsNumRol;
    @XmlElement(name = "pws_fechaInicio")
    protected String pwsFechaInicio;
    @XmlElement(name = "pws_bd")
    protected String pwsBd;
    @XmlElement(name = "pws_usu")
    protected String pwsUsu;
    @XmlElement(name = "pws_psw")
    protected String pwsPsw;

    /**
     * Gets the value of the pwsCodigoPer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsCodigoPer() {
        return pwsCodigoPer;
    }

    /**
     * Sets the value of the pwsCodigoPer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsCodigoPer(String value) {
        this.pwsCodigoPer = value;
    }

    /**
     * Gets the value of the pwsNumRol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsNumRol() {
        return pwsNumRol;
    }

    /**
     * Sets the value of the pwsNumRol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsNumRol(String value) {
        this.pwsNumRol = value;
    }

    /**
     * Gets the value of the pwsFechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFechaInicio() {
        return pwsFechaInicio;
    }

    /**
     * Sets the value of the pwsFechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFechaInicio(String value) {
        this.pwsFechaInicio = value;
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

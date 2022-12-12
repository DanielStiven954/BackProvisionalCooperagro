
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
 *         &amp;lt;element name="pws_identific" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_form_periodic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_cod_credi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_form_plazo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_form_pag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "pwsIdentific",
    "pwsFormPeriodic",
    "pwsCodCredi",
    "pwsFormPlazo",
    "pwsFormPag",
    "pwsBd",
    "pwsUsu",
    "pwsPsw"
})
@XmlRootElement(name = "calculoCupos")
public class CalculoCupos {

    @XmlElement(name = "pws_identific")
    protected String pwsIdentific;
    @XmlElement(name = "pws_form_periodic")
    protected String pwsFormPeriodic;
    @XmlElement(name = "pws_cod_credi")
    protected String pwsCodCredi;
    @XmlElement(name = "pws_form_plazo")
    protected String pwsFormPlazo;
    @XmlElement(name = "pws_form_pag")
    protected String pwsFormPag;
    @XmlElement(name = "pws_bd")
    protected String pwsBd;
    @XmlElement(name = "pws_usu")
    protected String pwsUsu;
    @XmlElement(name = "pws_psw")
    protected String pwsPsw;

    /**
     * Gets the value of the pwsIdentific property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsIdentific() {
        return pwsIdentific;
    }

    /**
     * Sets the value of the pwsIdentific property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsIdentific(String value) {
        this.pwsIdentific = value;
    }

    /**
     * Gets the value of the pwsFormPeriodic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFormPeriodic() {
        return pwsFormPeriodic;
    }

    /**
     * Sets the value of the pwsFormPeriodic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFormPeriodic(String value) {
        this.pwsFormPeriodic = value;
    }

    /**
     * Gets the value of the pwsCodCredi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsCodCredi() {
        return pwsCodCredi;
    }

    /**
     * Sets the value of the pwsCodCredi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsCodCredi(String value) {
        this.pwsCodCredi = value;
    }

    /**
     * Gets the value of the pwsFormPlazo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFormPlazo() {
        return pwsFormPlazo;
    }

    /**
     * Sets the value of the pwsFormPlazo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFormPlazo(String value) {
        this.pwsFormPlazo = value;
    }

    /**
     * Gets the value of the pwsFormPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFormPag() {
        return pwsFormPag;
    }

    /**
     * Sets the value of the pwsFormPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFormPag(String value) {
        this.pwsFormPag = value;
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

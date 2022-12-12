
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
 *         &amp;lt;element name="pws_monto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_nro_cuotas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_fecha_sol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_val_recog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_cod_credi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_form_plazo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_identific" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_form_periodic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_forma_pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_val_tf1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_fec_tf1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_val_tf2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_fec_tf2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_val_tf3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_fec_tf3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "pwsMonto",
    "pwsNroCuotas",
    "pwsFechaSol",
    "pwsValRecog",
    "pwsCodCredi",
    "pwsFormPlazo",
    "pwsIdentific",
    "pwsFormPeriodic",
    "pwsFormaPago",
    "pwsValTf1",
    "pwsFecTf1",
    "pwsValTf2",
    "pwsFecTf2",
    "pwsValTf3",
    "pwsFecTf3",
    "pwsBd",
    "pwsUsu",
    "pwsPsw"
})
@XmlRootElement(name = "WS_CONSULTA_LIQUIDACIONATR")
public class WSCONSULTALIQUIDACIONATR {

    @XmlElement(name = "pws_monto")
    protected String pwsMonto;
    @XmlElement(name = "pws_nro_cuotas")
    protected String pwsNroCuotas;
    @XmlElement(name = "pws_fecha_sol")
    protected String pwsFechaSol;
    @XmlElement(name = "pws_val_recog")
    protected String pwsValRecog;
    @XmlElement(name = "pws_cod_credi")
    protected String pwsCodCredi;
    @XmlElement(name = "pws_form_plazo")
    protected String pwsFormPlazo;
    @XmlElement(name = "pws_identific")
    protected String pwsIdentific;
    @XmlElement(name = "pws_form_periodic")
    protected String pwsFormPeriodic;
    @XmlElement(name = "pws_forma_pago")
    protected String pwsFormaPago;
    @XmlElement(name = "pws_val_tf1")
    protected String pwsValTf1;
    @XmlElement(name = "pws_fec_tf1")
    protected String pwsFecTf1;
    @XmlElement(name = "pws_val_tf2")
    protected String pwsValTf2;
    @XmlElement(name = "pws_fec_tf2")
    protected String pwsFecTf2;
    @XmlElement(name = "pws_val_tf3")
    protected String pwsValTf3;
    @XmlElement(name = "pws_fec_tf3")
    protected String pwsFecTf3;
    @XmlElement(name = "pws_bd")
    protected String pwsBd;
    @XmlElement(name = "pws_usu")
    protected String pwsUsu;
    @XmlElement(name = "pws_psw")
    protected String pwsPsw;

    /**
     * Gets the value of the pwsMonto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsMonto() {
        return pwsMonto;
    }

    /**
     * Sets the value of the pwsMonto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsMonto(String value) {
        this.pwsMonto = value;
    }

    /**
     * Gets the value of the pwsNroCuotas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsNroCuotas() {
        return pwsNroCuotas;
    }

    /**
     * Sets the value of the pwsNroCuotas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsNroCuotas(String value) {
        this.pwsNroCuotas = value;
    }

    /**
     * Gets the value of the pwsFechaSol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFechaSol() {
        return pwsFechaSol;
    }

    /**
     * Sets the value of the pwsFechaSol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFechaSol(String value) {
        this.pwsFechaSol = value;
    }

    /**
     * Gets the value of the pwsValRecog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsValRecog() {
        return pwsValRecog;
    }

    /**
     * Sets the value of the pwsValRecog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsValRecog(String value) {
        this.pwsValRecog = value;
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
     * Gets the value of the pwsFormaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFormaPago() {
        return pwsFormaPago;
    }

    /**
     * Sets the value of the pwsFormaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFormaPago(String value) {
        this.pwsFormaPago = value;
    }

    /**
     * Gets the value of the pwsValTf1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsValTf1() {
        return pwsValTf1;
    }

    /**
     * Sets the value of the pwsValTf1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsValTf1(String value) {
        this.pwsValTf1 = value;
    }

    /**
     * Gets the value of the pwsFecTf1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFecTf1() {
        return pwsFecTf1;
    }

    /**
     * Sets the value of the pwsFecTf1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFecTf1(String value) {
        this.pwsFecTf1 = value;
    }

    /**
     * Gets the value of the pwsValTf2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsValTf2() {
        return pwsValTf2;
    }

    /**
     * Sets the value of the pwsValTf2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsValTf2(String value) {
        this.pwsValTf2 = value;
    }

    /**
     * Gets the value of the pwsFecTf2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFecTf2() {
        return pwsFecTf2;
    }

    /**
     * Sets the value of the pwsFecTf2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFecTf2(String value) {
        this.pwsFecTf2 = value;
    }

    /**
     * Gets the value of the pwsValTf3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsValTf3() {
        return pwsValTf3;
    }

    /**
     * Sets the value of the pwsValTf3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsValTf3(String value) {
        this.pwsValTf3 = value;
    }

    /**
     * Gets the value of the pwsFecTf3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFecTf3() {
        return pwsFecTf3;
    }

    /**
     * Sets the value of the pwsFecTf3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFecTf3(String value) {
        this.pwsFecTf3 = value;
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

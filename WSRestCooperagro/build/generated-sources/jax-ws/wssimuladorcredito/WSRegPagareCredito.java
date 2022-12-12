
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
 *         &amp;lt;element name="pws_numRadic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_numCuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_numPagare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_valorPagare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_fechaCuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_autorizacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_aprobacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_porcComision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_valorComision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_matricula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_semestre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "pwsNumCuota",
    "pwsNumPagare",
    "pwsValorPagare",
    "pwsFechaCuota",
    "pwsAutorizacion",
    "pwsAprobacion",
    "pwsPorcComision",
    "pwsValorComision",
    "pwsMatricula",
    "pwsSemestre",
    "pwsBd",
    "pwsUsu",
    "pwsPsw"
})
@XmlRootElement(name = "WS_regPagareCredito")
public class WSRegPagareCredito {

    @XmlElement(name = "pws_numRadic")
    protected String pwsNumRadic;
    @XmlElement(name = "pws_numCuota")
    protected String pwsNumCuota;
    @XmlElement(name = "pws_numPagare")
    protected String pwsNumPagare;
    @XmlElement(name = "pws_valorPagare")
    protected String pwsValorPagare;
    @XmlElement(name = "pws_fechaCuota")
    protected String pwsFechaCuota;
    @XmlElement(name = "pws_autorizacion")
    protected String pwsAutorizacion;
    @XmlElement(name = "pws_aprobacion")
    protected String pwsAprobacion;
    @XmlElement(name = "pws_porcComision")
    protected String pwsPorcComision;
    @XmlElement(name = "pws_valorComision")
    protected String pwsValorComision;
    @XmlElement(name = "pws_matricula")
    protected String pwsMatricula;
    @XmlElement(name = "pws_semestre")
    protected String pwsSemestre;
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
     * Gets the value of the pwsNumCuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsNumCuota() {
        return pwsNumCuota;
    }

    /**
     * Sets the value of the pwsNumCuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsNumCuota(String value) {
        this.pwsNumCuota = value;
    }

    /**
     * Gets the value of the pwsNumPagare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsNumPagare() {
        return pwsNumPagare;
    }

    /**
     * Sets the value of the pwsNumPagare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsNumPagare(String value) {
        this.pwsNumPagare = value;
    }

    /**
     * Gets the value of the pwsValorPagare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsValorPagare() {
        return pwsValorPagare;
    }

    /**
     * Sets the value of the pwsValorPagare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsValorPagare(String value) {
        this.pwsValorPagare = value;
    }

    /**
     * Gets the value of the pwsFechaCuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsFechaCuota() {
        return pwsFechaCuota;
    }

    /**
     * Sets the value of the pwsFechaCuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsFechaCuota(String value) {
        this.pwsFechaCuota = value;
    }

    /**
     * Gets the value of the pwsAutorizacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsAutorizacion() {
        return pwsAutorizacion;
    }

    /**
     * Sets the value of the pwsAutorizacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsAutorizacion(String value) {
        this.pwsAutorizacion = value;
    }

    /**
     * Gets the value of the pwsAprobacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsAprobacion() {
        return pwsAprobacion;
    }

    /**
     * Sets the value of the pwsAprobacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsAprobacion(String value) {
        this.pwsAprobacion = value;
    }

    /**
     * Gets the value of the pwsPorcComision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsPorcComision() {
        return pwsPorcComision;
    }

    /**
     * Sets the value of the pwsPorcComision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsPorcComision(String value) {
        this.pwsPorcComision = value;
    }

    /**
     * Gets the value of the pwsValorComision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsValorComision() {
        return pwsValorComision;
    }

    /**
     * Sets the value of the pwsValorComision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsValorComision(String value) {
        this.pwsValorComision = value;
    }

    /**
     * Gets the value of the pwsMatricula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsMatricula() {
        return pwsMatricula;
    }

    /**
     * Sets the value of the pwsMatricula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsMatricula(String value) {
        this.pwsMatricula = value;
    }

    /**
     * Gets the value of the pwsSemestre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwsSemestre() {
        return pwsSemestre;
    }

    /**
     * Sets the value of the pwsSemestre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwsSemestre(String value) {
        this.pwsSemestre = value;
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

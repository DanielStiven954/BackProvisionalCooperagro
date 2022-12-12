
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
 *         &amp;lt;element name="p_dfn_nat_codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_w_s_tipodepersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="pws_identific" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_w_n_tipoiden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_w_d_fecexp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_dfs_nat_nombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_dfs_nat_apellidos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_w_s_direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_w_n_ciudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_w_s_telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="p_w_s_direcelec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "pDfnNatCodigo",
    "pwsTipodepersona",
    "pwsIdentific",
    "pwnTipoiden",
    "pwdFecexp",
    "pDfsNatNombres",
    "pDfsNatApellidos",
    "pwsDireccion",
    "pwnCiudad",
    "pwsTelefono",
    "pwsDirecelec",
    "pwsBd",
    "pwsUsu",
    "pwsPsw"
})
@XmlRootElement(name = "WC_CREAR_PERSONABASICO")
public class WCCREARPERSONABASICO {

    @XmlElement(name = "p_dfn_nat_codigo")
    protected String pDfnNatCodigo;
    @XmlElement(name = "p_w_s_tipodepersona")
    protected String pwsTipodepersona;
    @XmlElement(name = "pws_identific")
    protected String pwsIdentific;
    @XmlElement(name = "p_w_n_tipoiden")
    protected String pwnTipoiden;
    @XmlElement(name = "p_w_d_fecexp")
    protected String pwdFecexp;
    @XmlElement(name = "p_dfs_nat_nombres")
    protected String pDfsNatNombres;
    @XmlElement(name = "p_dfs_nat_apellidos")
    protected String pDfsNatApellidos;
    @XmlElement(name = "p_w_s_direccion")
    protected String pwsDireccion;
    @XmlElement(name = "p_w_n_ciudad")
    protected String pwnCiudad;
    @XmlElement(name = "p_w_s_telefono")
    protected String pwsTelefono;
    @XmlElement(name = "p_w_s_direcelec")
    protected String pwsDirecelec;
    @XmlElement(name = "pws_bd")
    protected String pwsBd;
    @XmlElement(name = "pws_usu")
    protected String pwsUsu;
    @XmlElement(name = "pws_psw")
    protected String pwsPsw;

    /**
     * Gets the value of the pDfnNatCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDfnNatCodigo() {
        return pDfnNatCodigo;
    }

    /**
     * Sets the value of the pDfnNatCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDfnNatCodigo(String value) {
        this.pDfnNatCodigo = value;
    }

    /**
     * Gets the value of the pwsTipodepersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWSTipodepersona() {
        return pwsTipodepersona;
    }

    /**
     * Sets the value of the pwsTipodepersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWSTipodepersona(String value) {
        this.pwsTipodepersona = value;
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
     * Gets the value of the pwnTipoiden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWNTipoiden() {
        return pwnTipoiden;
    }

    /**
     * Sets the value of the pwnTipoiden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWNTipoiden(String value) {
        this.pwnTipoiden = value;
    }

    /**
     * Gets the value of the pwdFecexp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWDFecexp() {
        return pwdFecexp;
    }

    /**
     * Sets the value of the pwdFecexp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWDFecexp(String value) {
        this.pwdFecexp = value;
    }

    /**
     * Gets the value of the pDfsNatNombres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDfsNatNombres() {
        return pDfsNatNombres;
    }

    /**
     * Sets the value of the pDfsNatNombres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDfsNatNombres(String value) {
        this.pDfsNatNombres = value;
    }

    /**
     * Gets the value of the pDfsNatApellidos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDfsNatApellidos() {
        return pDfsNatApellidos;
    }

    /**
     * Sets the value of the pDfsNatApellidos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDfsNatApellidos(String value) {
        this.pDfsNatApellidos = value;
    }

    /**
     * Gets the value of the pwsDireccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWSDireccion() {
        return pwsDireccion;
    }

    /**
     * Sets the value of the pwsDireccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWSDireccion(String value) {
        this.pwsDireccion = value;
    }

    /**
     * Gets the value of the pwnCiudad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWNCiudad() {
        return pwnCiudad;
    }

    /**
     * Sets the value of the pwnCiudad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWNCiudad(String value) {
        this.pwnCiudad = value;
    }

    /**
     * Gets the value of the pwsTelefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWSTelefono() {
        return pwsTelefono;
    }

    /**
     * Sets the value of the pwsTelefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWSTelefono(String value) {
        this.pwsTelefono = value;
    }

    /**
     * Gets the value of the pwsDirecelec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWSDirecelec() {
        return pwsDirecelec;
    }

    /**
     * Sets the value of the pwsDirecelec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWSDirecelec(String value) {
        this.pwsDirecelec = value;
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


package wsmovimientoscygnus_retefuente;

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
 *         &amp;lt;element name="ps_identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ps_fecha_ini" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ps_fecha_fin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ps_base" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ps_usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ps_clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "psIdentificacion",
    "psFechaIni",
    "psFechaFin",
    "psBase",
    "psUsuario",
    "psClave"
})
@XmlRootElement(name = "retefuente_coopedac")
public class RetefuenteCoopedac {

    @XmlElement(name = "ps_identificacion")
    protected String psIdentificacion;
    @XmlElement(name = "ps_fecha_ini")
    protected String psFechaIni;
    @XmlElement(name = "ps_fecha_fin")
    protected String psFechaFin;
    @XmlElement(name = "ps_base")
    protected String psBase;
    @XmlElement(name = "ps_usuario")
    protected String psUsuario;
    @XmlElement(name = "ps_clave")
    protected String psClave;

    /**
     * Gets the value of the psIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsIdentificacion() {
        return psIdentificacion;
    }

    /**
     * Sets the value of the psIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsIdentificacion(String value) {
        this.psIdentificacion = value;
    }

    /**
     * Gets the value of the psFechaIni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsFechaIni() {
        return psFechaIni;
    }

    /**
     * Sets the value of the psFechaIni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsFechaIni(String value) {
        this.psFechaIni = value;
    }

    /**
     * Gets the value of the psFechaFin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsFechaFin() {
        return psFechaFin;
    }

    /**
     * Sets the value of the psFechaFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsFechaFin(String value) {
        this.psFechaFin = value;
    }

    /**
     * Gets the value of the psBase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsBase() {
        return psBase;
    }

    /**
     * Sets the value of the psBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsBase(String value) {
        this.psBase = value;
    }

    /**
     * Gets the value of the psUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsUsuario() {
        return psUsuario;
    }

    /**
     * Sets the value of the psUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsUsuario(String value) {
        this.psUsuario = value;
    }

    /**
     * Gets the value of the psClave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsClave() {
        return psClave;
    }

    /**
     * Sets the value of the psClave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsClave(String value) {
        this.psClave = value;
    }

}

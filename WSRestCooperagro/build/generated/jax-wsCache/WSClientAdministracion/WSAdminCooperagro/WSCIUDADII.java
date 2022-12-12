
package WSAdminCooperagro;

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
 *         &amp;lt;element name="xi_codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xc_nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xi_nivel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xi_ind_nal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xi_ind_internal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xi_ubicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "xiCodigo",
    "xcNombre",
    "xiNivel",
    "xiIndNal",
    "xiIndInternal",
    "xiUbicacion"
})
@XmlRootElement(name = "WS_CIUDAD_II")
public class WSCIUDADII {

    @XmlElement(name = "xi_codigo")
    protected String xiCodigo;
    @XmlElement(name = "xc_nombre")
    protected String xcNombre;
    @XmlElement(name = "xi_nivel")
    protected String xiNivel;
    @XmlElement(name = "xi_ind_nal")
    protected String xiIndNal;
    @XmlElement(name = "xi_ind_internal")
    protected String xiIndInternal;
    @XmlElement(name = "xi_ubicacion")
    protected String xiUbicacion;

    /**
     * Gets the value of the xiCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXiCodigo() {
        return xiCodigo;
    }

    /**
     * Sets the value of the xiCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXiCodigo(String value) {
        this.xiCodigo = value;
    }

    /**
     * Gets the value of the xcNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXcNombre() {
        return xcNombre;
    }

    /**
     * Sets the value of the xcNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXcNombre(String value) {
        this.xcNombre = value;
    }

    /**
     * Gets the value of the xiNivel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXiNivel() {
        return xiNivel;
    }

    /**
     * Sets the value of the xiNivel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXiNivel(String value) {
        this.xiNivel = value;
    }

    /**
     * Gets the value of the xiIndNal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXiIndNal() {
        return xiIndNal;
    }

    /**
     * Sets the value of the xiIndNal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXiIndNal(String value) {
        this.xiIndNal = value;
    }

    /**
     * Gets the value of the xiIndInternal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXiIndInternal() {
        return xiIndInternal;
    }

    /**
     * Sets the value of the xiIndInternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXiIndInternal(String value) {
        this.xiIndInternal = value;
    }

    /**
     * Gets the value of the xiUbicacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXiUbicacion() {
        return xiUbicacion;
    }

    /**
     * Sets the value of the xiUbicacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXiUbicacion(String value) {
        this.xiUbicacion = value;
    }

}

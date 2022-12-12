
package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CiudadDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CiudadDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="I_Codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Nivel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ind_Nal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ind_Internal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ubicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CiudadDTO", propOrder = {
    "iCodigo",
    "cNombre",
    "iNivel",
    "iIndNal",
    "iIndInternal",
    "iUbicacion"
})
public class CiudadDTO {

    @XmlElement(name = "I_Codigo")
    protected String iCodigo;
    @XmlElement(name = "C_Nombre")
    protected String cNombre;
    @XmlElement(name = "I_Nivel")
    protected String iNivel;
    @XmlElement(name = "I_Ind_Nal")
    protected String iIndNal;
    @XmlElement(name = "I_Ind_Internal")
    protected String iIndInternal;
    @XmlElement(name = "I_Ubicacion")
    protected String iUbicacion;

    /**
     * Gets the value of the iCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICodigo() {
        return iCodigo;
    }

    /**
     * Sets the value of the iCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICodigo(String value) {
        this.iCodigo = value;
    }

    /**
     * Gets the value of the cNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNombre() {
        return cNombre;
    }

    /**
     * Sets the value of the cNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNombre(String value) {
        this.cNombre = value;
    }

    /**
     * Gets the value of the iNivel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINivel() {
        return iNivel;
    }

    /**
     * Sets the value of the iNivel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINivel(String value) {
        this.iNivel = value;
    }

    /**
     * Gets the value of the iIndNal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIIndNal() {
        return iIndNal;
    }

    /**
     * Sets the value of the iIndNal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIIndNal(String value) {
        this.iIndNal = value;
    }

    /**
     * Gets the value of the iIndInternal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIIndInternal() {
        return iIndInternal;
    }

    /**
     * Sets the value of the iIndInternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIIndInternal(String value) {
        this.iIndInternal = value;
    }

    /**
     * Gets the value of the iUbicacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIUbicacion() {
        return iUbicacion;
    }

    /**
     * Sets the value of the iUbicacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIUbicacion(String value) {
        this.iUbicacion = value;
    }

}

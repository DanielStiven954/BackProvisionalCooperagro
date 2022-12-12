
package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ResponseEntidad complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResponseEntidad"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="BRta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMsjConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LstEntidadBanco" type="{https://ebssas.com/}ArrayOfEntidadDTO" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseEntidad", propOrder = {
    "bRta",
    "sMsjConsulta",
    "lstEntidadBanco"
})
public class ResponseEntidad {

    @XmlElement(name = "BRta")
    protected boolean bRta;
    @XmlElement(name = "SMsjConsulta")
    protected String sMsjConsulta;
    @XmlElement(name = "LstEntidadBanco")
    protected ArrayOfEntidadDTO lstEntidadBanco;

    /**
     * Gets the value of the bRta property.
     * 
     */
    public boolean isBRta() {
        return bRta;
    }

    /**
     * Sets the value of the bRta property.
     * 
     */
    public void setBRta(boolean value) {
        this.bRta = value;
    }

    /**
     * Gets the value of the sMsjConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMsjConsulta() {
        return sMsjConsulta;
    }

    /**
     * Sets the value of the sMsjConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMsjConsulta(String value) {
        this.sMsjConsulta = value;
    }

    /**
     * Gets the value of the lstEntidadBanco property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEntidadDTO }
     *     
     */
    public ArrayOfEntidadDTO getLstEntidadBanco() {
        return lstEntidadBanco;
    }

    /**
     * Sets the value of the lstEntidadBanco property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEntidadDTO }
     *     
     */
    public void setLstEntidadBanco(ArrayOfEntidadDTO value) {
        this.lstEntidadBanco = value;
    }

}

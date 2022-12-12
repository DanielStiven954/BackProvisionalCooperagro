
package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ResponseTiposIdent complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResponseTiposIdent"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="BRta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMsjConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LstTiposIdent" type="{https://ebssas.com/}ArrayOfTipoIdentificacionDTO" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseTiposIdent", propOrder = {
    "bRta",
    "sMsjConsulta",
    "lstTiposIdent"
})
public class ResponseTiposIdent {

    @XmlElement(name = "BRta")
    protected boolean bRta;
    @XmlElement(name = "SMsjConsulta")
    protected String sMsjConsulta;
    @XmlElement(name = "LstTiposIdent")
    protected ArrayOfTipoIdentificacionDTO lstTiposIdent;

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
     * Gets the value of the lstTiposIdent property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTipoIdentificacionDTO }
     *     
     */
    public ArrayOfTipoIdentificacionDTO getLstTiposIdent() {
        return lstTiposIdent;
    }

    /**
     * Sets the value of the lstTiposIdent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTipoIdentificacionDTO }
     *     
     */
    public void setLstTiposIdent(ArrayOfTipoIdentificacionDTO value) {
        this.lstTiposIdent = value;
    }

}

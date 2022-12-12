
package wsmovimientoscygnus_retefuente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for InteresesCert complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="InteresesCert"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSMovimientosCygnus_retefuente}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="s_linea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="s_saldo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="s_atributo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="s_num_radic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InteresesCert", propOrder = {
    "sLinea",
    "sSaldo",
    "sAtributo",
    "sNumRadic"
})
public class InteresesCert
    extends General
{

    @XmlElement(name = "s_linea")
    protected String sLinea;
    @XmlElement(name = "s_saldo")
    protected String sSaldo;
    @XmlElement(name = "s_atributo")
    protected String sAtributo;
    @XmlElement(name = "s_num_radic")
    protected String sNumRadic;

    /**
     * Gets the value of the sLinea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLinea() {
        return sLinea;
    }

    /**
     * Sets the value of the sLinea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLinea(String value) {
        this.sLinea = value;
    }

    /**
     * Gets the value of the sSaldo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSaldo() {
        return sSaldo;
    }

    /**
     * Sets the value of the sSaldo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSaldo(String value) {
        this.sSaldo = value;
    }

    /**
     * Gets the value of the sAtributo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSAtributo() {
        return sAtributo;
    }

    /**
     * Sets the value of the sAtributo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSAtributo(String value) {
        this.sAtributo = value;
    }

    /**
     * Gets the value of the sNumRadic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumRadic() {
        return sNumRadic;
    }

    /**
     * Sets the value of the sNumRadic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumRadic(String value) {
        this.sNumRadic = value;
    }

}

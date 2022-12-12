
package wspersonascygnus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RespuestaCrea complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RespuestaCrea"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSPersonasCygnus}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Resultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="MensajeError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CodigoCygnus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaCrea", propOrder = {
    "resultado",
    "mensajeError",
    "codigoCygnus"
})
public class RespuestaCrea
    extends General
{

    @XmlElement(name = "Resultado")
    protected String resultado;
    @XmlElement(name = "MensajeError")
    protected String mensajeError;
    @XmlElement(name = "CodigoCygnus")
    protected String codigoCygnus;

    /**
     * Gets the value of the resultado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Gets the value of the mensajeError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * Sets the value of the mensajeError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeError(String value) {
        this.mensajeError = value;
    }

    /**
     * Gets the value of the codigoCygnus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCygnus() {
        return codigoCygnus;
    }

    /**
     * Sets the value of the codigoCygnus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCygnus(String value) {
        this.codigoCygnus = value;
    }

}


package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DocumentoCreditoDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentoCreditoDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ITipoDoc" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="SDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ITipoCliente" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="SDescTipoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ITipoDeudor" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="IObligatorio" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentoCreditoDTO", propOrder = {
    "iTipoDoc",
    "sDescripcion",
    "iTipoCliente",
    "sDescTipoCliente",
    "iTipoDeudor",
    "iObligatorio"
})
public class DocumentoCreditoDTO {

    @XmlElement(name = "ITipoDoc")
    protected long iTipoDoc;
    @XmlElement(name = "SDescripcion")
    protected String sDescripcion;
    @XmlElement(name = "ITipoCliente")
    protected long iTipoCliente;
    @XmlElement(name = "SDescTipoCliente")
    protected String sDescTipoCliente;
    @XmlElement(name = "ITipoDeudor")
    protected int iTipoDeudor;
    @XmlElement(name = "IObligatorio")
    protected int iObligatorio;

    /**
     * Gets the value of the iTipoDoc property.
     * 
     */
    public long getITipoDoc() {
        return iTipoDoc;
    }

    /**
     * Sets the value of the iTipoDoc property.
     * 
     */
    public void setITipoDoc(long value) {
        this.iTipoDoc = value;
    }

    /**
     * Gets the value of the sDescripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescripcion() {
        return sDescripcion;
    }

    /**
     * Sets the value of the sDescripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescripcion(String value) {
        this.sDescripcion = value;
    }

    /**
     * Gets the value of the iTipoCliente property.
     * 
     */
    public long getITipoCliente() {
        return iTipoCliente;
    }

    /**
     * Sets the value of the iTipoCliente property.
     * 
     */
    public void setITipoCliente(long value) {
        this.iTipoCliente = value;
    }

    /**
     * Gets the value of the sDescTipoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescTipoCliente() {
        return sDescTipoCliente;
    }

    /**
     * Sets the value of the sDescTipoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescTipoCliente(String value) {
        this.sDescTipoCliente = value;
    }

    /**
     * Gets the value of the iTipoDeudor property.
     * 
     */
    public int getITipoDeudor() {
        return iTipoDeudor;
    }

    /**
     * Sets the value of the iTipoDeudor property.
     * 
     */
    public void setITipoDeudor(int value) {
        this.iTipoDeudor = value;
    }

    /**
     * Gets the value of the iObligatorio property.
     * 
     */
    public int getIObligatorio() {
        return iObligatorio;
    }

    /**
     * Sets the value of the iObligatorio property.
     * 
     */
    public void setIObligatorio(int value) {
        this.iObligatorio = value;
    }

}

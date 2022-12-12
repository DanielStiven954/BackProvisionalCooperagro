
package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DocumentoGenCreditoDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentoGenCreditoDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ITipoDoc" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
@XmlType(name = "DocumentoGenCreditoDTO", propOrder = {
    "iTipoDoc",
    "sDescripcion",
    "iObligatorio"
})
public class DocumentoGenCreditoDTO {

    @XmlElement(name = "ITipoDoc")
    protected int iTipoDoc;
    @XmlElement(name = "SDescripcion")
    protected String sDescripcion;
    @XmlElement(name = "IObligatorio")
    protected int iObligatorio;

    /**
     * Gets the value of the iTipoDoc property.
     * 
     */
    public int getITipoDoc() {
        return iTipoDoc;
    }

    /**
     * Sets the value of the iTipoDoc property.
     * 
     */
    public void setITipoDoc(int value) {
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


package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ResponseLineaCredito complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResponseLineaCredito"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="BRta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ListLineaCredito" type="{https://ebssas.com/}ArrayOfLineaCreditoDTO" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseLineaCredito", propOrder = {
    "bRta",
    "sMsj",
    "listLineaCredito"
})
public class ResponseLineaCredito {

    @XmlElement(name = "BRta")
    protected boolean bRta;
    @XmlElement(name = "SMsj")
    protected String sMsj;
    @XmlElement(name = "ListLineaCredito")
    protected ArrayOfLineaCreditoDTO listLineaCredito;

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
     * Gets the value of the sMsj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMsj() {
        return sMsj;
    }

    /**
     * Sets the value of the sMsj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMsj(String value) {
        this.sMsj = value;
    }

    /**
     * Gets the value of the listLineaCredito property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLineaCreditoDTO }
     *     
     */
    public ArrayOfLineaCreditoDTO getListLineaCredito() {
        return listLineaCredito;
    }

    /**
     * Sets the value of the listLineaCredito property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLineaCreditoDTO }
     *     
     */
    public void setListLineaCredito(ArrayOfLineaCreditoDTO value) {
        this.listLineaCredito = value;
    }

}

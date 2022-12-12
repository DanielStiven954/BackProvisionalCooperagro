
package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ResponseCargo complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResponseCargo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="BRta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ListCargos" type="{https://ebssas.com/}ArrayOfCargoDTO" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseCargo", propOrder = {
    "bRta",
    "sMsg",
    "listCargos"
})
public class ResponseCargo {

    @XmlElement(name = "BRta")
    protected boolean bRta;
    @XmlElement(name = "SMsg")
    protected String sMsg;
    @XmlElement(name = "ListCargos")
    protected ArrayOfCargoDTO listCargos;

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
     * Gets the value of the sMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMsg() {
        return sMsg;
    }

    /**
     * Sets the value of the sMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMsg(String value) {
        this.sMsg = value;
    }

    /**
     * Gets the value of the listCargos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCargoDTO }
     *     
     */
    public ArrayOfCargoDTO getListCargos() {
        return listCargos;
    }

    /**
     * Sets the value of the listCargos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCargoDTO }
     *     
     */
    public void setListCargos(ArrayOfCargoDTO value) {
        this.listCargos = value;
    }

}


package WSAdminCooperagro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ResponseProfesion complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResponseProfesion"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="BRta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ListProfesion" type="{https://ebssas.com/}ArrayOfProfesionDTO" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseProfesion", propOrder = {
    "bRta",
    "sMsg",
    "listProfesion"
})
public class ResponseProfesion {

    @XmlElement(name = "BRta")
    protected boolean bRta;
    @XmlElement(name = "SMsg")
    protected String sMsg;
    @XmlElement(name = "ListProfesion")
    protected ArrayOfProfesionDTO listProfesion;

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
     * Gets the value of the listProfesion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProfesionDTO }
     *     
     */
    public ArrayOfProfesionDTO getListProfesion() {
        return listProfesion;
    }

    /**
     * Sets the value of the listProfesion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProfesionDTO }
     *     
     */
    public void setListProfesion(ArrayOfProfesionDTO value) {
        this.listProfesion = value;
    }

}


package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for Atributos_cuotas complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="Atributos_cuotas"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="n_cod_atr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_nom_atr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Atributos_cuotas", propOrder = {
    "nCodAtr",
    "nNomAtr",
    "nValor"
})
public class AtributosCuotas
    extends General
{

    @XmlElement(name = "n_cod_atr")
    protected String nCodAtr;
    @XmlElement(name = "n_nom_atr")
    protected String nNomAtr;
    @XmlElement(name = "n_valor")
    protected String nValor;

    /**
     * Gets the value of the nCodAtr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNCodAtr() {
        return nCodAtr;
    }

    /**
     * Sets the value of the nCodAtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNCodAtr(String value) {
        this.nCodAtr = value;
    }

    /**
     * Gets the value of the nNomAtr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNNomAtr() {
        return nNomAtr;
    }

    /**
     * Sets the value of the nNomAtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNNomAtr(String value) {
        this.nNomAtr = value;
    }

    /**
     * Gets the value of the nValor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNValor() {
        return nValor;
    }

    /**
     * Sets the value of the nValor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNValor(String value) {
        this.nValor = value;
    }

}

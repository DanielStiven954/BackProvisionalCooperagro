
package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for Liquidacion_cuotas complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="Liquidacion_cuotas"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="n_num_cuo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="f_fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="s_atributos" type="{WSSimuladorCredito}ArrayOfAtributos_cuotas" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Liquidacion_cuotas", propOrder = {
    "nNumCuo",
    "fFecha",
    "sAtributos"
})
public class LiquidacionCuotas
    extends General
{

    @XmlElement(name = "n_num_cuo")
    protected String nNumCuo;
    @XmlElement(name = "f_fecha")
    protected String fFecha;
    @XmlElement(name = "s_atributos")
    protected ArrayOfAtributosCuotas sAtributos;

    /**
     * Gets the value of the nNumCuo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNNumCuo() {
        return nNumCuo;
    }

    /**
     * Sets the value of the nNumCuo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNNumCuo(String value) {
        this.nNumCuo = value;
    }

    /**
     * Gets the value of the fFecha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecha() {
        return fFecha;
    }

    /**
     * Sets the value of the fFecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecha(String value) {
        this.fFecha = value;
    }

    /**
     * Gets the value of the sAtributos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAtributosCuotas }
     *     
     */
    public ArrayOfAtributosCuotas getSAtributos() {
        return sAtributos;
    }

    /**
     * Sets the value of the sAtributos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAtributosCuotas }
     *     
     */
    public void setSAtributos(ArrayOfAtributosCuotas value) {
        this.sAtributos = value;
    }

}


package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for Respuesta complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="Respuesta"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="R_Liquidacion" type="{WSSimuladorCredito}ArrayOfLiquidacion" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_Val_cuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_s_tasa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_s_mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_ValorCuotaAsociado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Respuesta", propOrder = {
    "rLiquidacion",
    "rValCuota",
    "rsTasa",
    "rsMensaje",
    "rValorCuotaAsociado"
})
public class Respuesta
    extends General
{

    @XmlElement(name = "R_Liquidacion")
    protected ArrayOfLiquidacion rLiquidacion;
    @XmlElement(name = "R_Val_cuota")
    protected String rValCuota;
    @XmlElement(name = "R_s_tasa")
    protected String rsTasa;
    @XmlElement(name = "R_s_mensaje")
    protected String rsMensaje;
    @XmlElement(name = "R_ValorCuotaAsociado")
    protected String rValorCuotaAsociado;

    /**
     * Gets the value of the rLiquidacion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLiquidacion }
     *     
     */
    public ArrayOfLiquidacion getRLiquidacion() {
        return rLiquidacion;
    }

    /**
     * Sets the value of the rLiquidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLiquidacion }
     *     
     */
    public void setRLiquidacion(ArrayOfLiquidacion value) {
        this.rLiquidacion = value;
    }

    /**
     * Gets the value of the rValCuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRValCuota() {
        return rValCuota;
    }

    /**
     * Sets the value of the rValCuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRValCuota(String value) {
        this.rValCuota = value;
    }

    /**
     * Gets the value of the rsTasa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRSTasa() {
        return rsTasa;
    }

    /**
     * Sets the value of the rsTasa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRSTasa(String value) {
        this.rsTasa = value;
    }

    /**
     * Gets the value of the rsMensaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRSMensaje() {
        return rsMensaje;
    }

    /**
     * Sets the value of the rsMensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRSMensaje(String value) {
        this.rsMensaje = value;
    }

    /**
     * Gets the value of the rValorCuotaAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRValorCuotaAsociado() {
        return rValorCuotaAsociado;
    }

    /**
     * Sets the value of the rValorCuotaAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRValorCuotaAsociado(String value) {
        this.rValorCuotaAsociado = value;
    }

}

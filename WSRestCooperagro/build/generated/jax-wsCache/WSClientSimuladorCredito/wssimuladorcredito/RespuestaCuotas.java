
package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for Respuesta_cuotas complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="Respuesta_cuotas"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="R_Liquidacion" type="{WSSimuladorCredito}ArrayOfLiquidacion_cuotas" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_s_mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Respuesta_cuotas", propOrder = {
    "rLiquidacion",
    "rsMensaje"
})
public class RespuestaCuotas
    extends General
{

    @XmlElement(name = "R_Liquidacion")
    protected ArrayOfLiquidacionCuotas rLiquidacion;
    @XmlElement(name = "R_s_mensaje")
    protected String rsMensaje;

    /**
     * Gets the value of the rLiquidacion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLiquidacionCuotas }
     *     
     */
    public ArrayOfLiquidacionCuotas getRLiquidacion() {
        return rLiquidacion;
    }

    /**
     * Sets the value of the rLiquidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLiquidacionCuotas }
     *     
     */
    public void setRLiquidacion(ArrayOfLiquidacionCuotas value) {
        this.rLiquidacion = value;
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

}

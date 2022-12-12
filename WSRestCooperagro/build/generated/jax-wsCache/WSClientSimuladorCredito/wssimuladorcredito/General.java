
package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for General complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="General"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}SalFunctionalClass"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="n_plazo_maximo" type="{WSSimuladorCredito}SalDecimal"/&amp;gt;
 *         &amp;lt;element name="df_edad" type="{WSSimuladorCredito}SalDecimal"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "General", propOrder = {
    "nPlazoMaximo",
    "dfEdad"
})
@XmlSeeAlso({
    Respuesta.class,
    RespuestaCrea.class,
    RespuestaRegistro.class,
    RespuestaCuotas.class,
    RespuestaAtr.class,
    Liquidacion.class,
    LiquidacionCuotas.class,
    AtributosCuotas.class,
    LiquidacionAtr.class
})
public class General
    extends SalFunctionalClass
{

    @XmlElement(name = "n_plazo_maximo", required = true)
    protected SalDecimal nPlazoMaximo;
    @XmlElement(name = "df_edad", required = true)
    protected SalDecimal dfEdad;

    /**
     * Gets the value of the nPlazoMaximo property.
     * 
     * @return
     *     possible object is
     *     {@link SalDecimal }
     *     
     */
    public SalDecimal getNPlazoMaximo() {
        return nPlazoMaximo;
    }

    /**
     * Sets the value of the nPlazoMaximo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalDecimal }
     *     
     */
    public void setNPlazoMaximo(SalDecimal value) {
        this.nPlazoMaximo = value;
    }

    /**
     * Gets the value of the dfEdad property.
     * 
     * @return
     *     possible object is
     *     {@link SalDecimal }
     *     
     */
    public SalDecimal getDfEdad() {
        return dfEdad;
    }

    /**
     * Sets the value of the dfEdad property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalDecimal }
     *     
     */
    public void setDfEdad(SalDecimal value) {
        this.dfEdad = value;
    }

}

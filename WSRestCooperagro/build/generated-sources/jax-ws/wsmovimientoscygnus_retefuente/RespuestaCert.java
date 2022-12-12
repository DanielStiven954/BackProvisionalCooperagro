
package wsmovimientoscygnus_retefuente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RespuestaCert complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RespuestaCert"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSMovimientosCygnus_retefuente}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="R_s_mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="R_Liquidacion" type="{WSMovimientosCygnus_retefuente}ArrayOfLiquidacionCert" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Int_Liquidacion" type="{WSMovimientosCygnus_retefuente}ArrayOfInteresesCert" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Aportes_Liq" type="{WSMovimientosCygnus_retefuente}ArrayOfAportesCert" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaCert", propOrder = {
    "rsMensaje",
    "rLiquidacion",
    "intLiquidacion",
    "aportesLiq"
})
public class RespuestaCert
    extends General
{

    @XmlElement(name = "R_s_mensaje")
    protected String rsMensaje;
    @XmlElement(name = "R_Liquidacion")
    protected ArrayOfLiquidacionCert rLiquidacion;
    @XmlElement(name = "Int_Liquidacion")
    protected ArrayOfInteresesCert intLiquidacion;
    @XmlElement(name = "Aportes_Liq")
    protected ArrayOfAportesCert aportesLiq;

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
     * Gets the value of the rLiquidacion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLiquidacionCert }
     *     
     */
    public ArrayOfLiquidacionCert getRLiquidacion() {
        return rLiquidacion;
    }

    /**
     * Sets the value of the rLiquidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLiquidacionCert }
     *     
     */
    public void setRLiquidacion(ArrayOfLiquidacionCert value) {
        this.rLiquidacion = value;
    }

    /**
     * Gets the value of the intLiquidacion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInteresesCert }
     *     
     */
    public ArrayOfInteresesCert getIntLiquidacion() {
        return intLiquidacion;
    }

    /**
     * Sets the value of the intLiquidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInteresesCert }
     *     
     */
    public void setIntLiquidacion(ArrayOfInteresesCert value) {
        this.intLiquidacion = value;
    }

    /**
     * Gets the value of the aportesLiq property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAportesCert }
     *     
     */
    public ArrayOfAportesCert getAportesLiq() {
        return aportesLiq;
    }

    /**
     * Sets the value of the aportesLiq property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAportesCert }
     *     
     */
    public void setAportesLiq(ArrayOfAportesCert value) {
        this.aportesLiq = value;
    }

}


package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="xnum_producto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xc_producto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="sFechaInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="sFechaFin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "xnumProducto",
    "xcProducto",
    "sFechaInicio",
    "sFechaFin"
})
@XmlRootElement(name = "WS_CONSULTAR_MOVIMIENTOS_FECHA")
public class WSCONSULTARMOVIMIENTOSFECHA {

    @XmlElement(name = "xnum_producto")
    protected String xnumProducto;
    @XmlElement(name = "xc_producto")
    protected String xcProducto;
    protected String sFechaInicio;
    protected String sFechaFin;

    /**
     * Gets the value of the xnumProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXnumProducto() {
        return xnumProducto;
    }

    /**
     * Sets the value of the xnumProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXnumProducto(String value) {
        this.xnumProducto = value;
    }

    /**
     * Gets the value of the xcProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXcProducto() {
        return xcProducto;
    }

    /**
     * Sets the value of the xcProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXcProducto(String value) {
        this.xcProducto = value;
    }

    /**
     * Gets the value of the sFechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaInicio() {
        return sFechaInicio;
    }

    /**
     * Sets the value of the sFechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaInicio(String value) {
        this.sFechaInicio = value;
    }

    /**
     * Gets the value of the sFechaFin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaFin() {
        return sFechaFin;
    }

    /**
     * Sets the value of the sFechaFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaFin(String value) {
        this.sFechaFin = value;
    }

}

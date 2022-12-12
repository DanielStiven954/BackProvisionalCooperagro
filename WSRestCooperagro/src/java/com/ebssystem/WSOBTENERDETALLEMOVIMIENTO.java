
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
 *         &amp;lt;element name="cod_operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xc_producto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "codOperation",
    "xcProducto"
})
@XmlRootElement(name = "WS_OBTENER_DETALLE_MOVIMIENTO")
public class WSOBTENERDETALLEMOVIMIENTO {

    @XmlElement(name = "xnum_producto")
    protected String xnumProducto;
    @XmlElement(name = "cod_operation")
    protected String codOperation;
    @XmlElement(name = "xc_producto")
    protected String xcProducto;

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
     * Gets the value of the codOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodOperation() {
        return codOperation;
    }

    /**
     * Sets the value of the codOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodOperation(String value) {
        this.codOperation = value;
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

}

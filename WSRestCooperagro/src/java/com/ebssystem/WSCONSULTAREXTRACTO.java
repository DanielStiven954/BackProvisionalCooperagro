
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
 *         &amp;lt;element name="xi_tipo_iden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="xc_identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "xiTipoIden",
    "xcIdentificacion",
    "xcProducto"
})
@XmlRootElement(name = "WS_CONSULTAR_EXTRACTO")
public class WSCONSULTAREXTRACTO {

    @XmlElement(name = "xi_tipo_iden")
    protected String xiTipoIden;
    @XmlElement(name = "xc_identificacion")
    protected String xcIdentificacion;
    @XmlElement(name = "xc_producto")
    protected String xcProducto;

    /**
     * Gets the value of the xiTipoIden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXiTipoIden() {
        return xiTipoIden;
    }

    /**
     * Sets the value of the xiTipoIden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXiTipoIden(String value) {
        this.xiTipoIden = value;
    }

    /**
     * Gets the value of the xcIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXcIdentificacion() {
        return xcIdentificacion;
    }

    /**
     * Sets the value of the xcIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXcIdentificacion(String value) {
        this.xcIdentificacion = value;
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

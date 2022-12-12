
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
 *         &amp;lt;element name="xi_codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "xiCodigo",
    "xcProducto"
})
@XmlRootElement(name = "WS_CONSULTAR_CREDITOS_TERMINADOS")
public class WSCONSULTARCREDITOSTERMINADOS {

    @XmlElement(name = "xi_codigo")
    protected String xiCodigo;
    @XmlElement(name = "xc_producto")
    protected String xcProducto;

    /**
     * Gets the value of the xiCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXiCodigo() {
        return xiCodigo;
    }

    /**
     * Sets the value of the xiCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXiCodigo(String value) {
        this.xiCodigo = value;
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

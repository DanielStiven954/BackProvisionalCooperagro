
package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ResponseIndicadores complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResponseIndicadores"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="BRta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LstIndicadorCartera" type="{http://www.ebssas.com/}ArrayOfIndicadorCarteraDTO" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LstIndicadorColocacion" type="{http://www.ebssas.com/}ArrayOfIndicadorColocacionDTO" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LstIndicadorVinculacion" type="{http://www.ebssas.com/}ArrayOfIndicadorVinculacionDTO" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LstIndicadorRetiro" type="{http://www.ebssas.com/}ArrayOfIndicadorRetiroDTO" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseIndicadores", propOrder = {
    "bRta",
    "sMsj",
    "lstIndicadorCartera",
    "lstIndicadorColocacion",
    "lstIndicadorVinculacion",
    "lstIndicadorRetiro"
})
public class ResponseIndicadores {

    @XmlElement(name = "BRta")
    protected boolean bRta;
    @XmlElement(name = "SMsj")
    protected String sMsj;
    @XmlElement(name = "LstIndicadorCartera")
    protected ArrayOfIndicadorCarteraDTO lstIndicadorCartera;
    @XmlElement(name = "LstIndicadorColocacion")
    protected ArrayOfIndicadorColocacionDTO lstIndicadorColocacion;
    @XmlElement(name = "LstIndicadorVinculacion")
    protected ArrayOfIndicadorVinculacionDTO lstIndicadorVinculacion;
    @XmlElement(name = "LstIndicadorRetiro")
    protected ArrayOfIndicadorRetiroDTO lstIndicadorRetiro;

    /**
     * Gets the value of the bRta property.
     * 
     */
    public boolean isBRta() {
        return bRta;
    }

    /**
     * Sets the value of the bRta property.
     * 
     */
    public void setBRta(boolean value) {
        this.bRta = value;
    }

    /**
     * Gets the value of the sMsj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMsj() {
        return sMsj;
    }

    /**
     * Sets the value of the sMsj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMsj(String value) {
        this.sMsj = value;
    }

    /**
     * Gets the value of the lstIndicadorCartera property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIndicadorCarteraDTO }
     *     
     */
    public ArrayOfIndicadorCarteraDTO getLstIndicadorCartera() {
        return lstIndicadorCartera;
    }

    /**
     * Sets the value of the lstIndicadorCartera property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIndicadorCarteraDTO }
     *     
     */
    public void setLstIndicadorCartera(ArrayOfIndicadorCarteraDTO value) {
        this.lstIndicadorCartera = value;
    }

    /**
     * Gets the value of the lstIndicadorColocacion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIndicadorColocacionDTO }
     *     
     */
    public ArrayOfIndicadorColocacionDTO getLstIndicadorColocacion() {
        return lstIndicadorColocacion;
    }

    /**
     * Sets the value of the lstIndicadorColocacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIndicadorColocacionDTO }
     *     
     */
    public void setLstIndicadorColocacion(ArrayOfIndicadorColocacionDTO value) {
        this.lstIndicadorColocacion = value;
    }

    /**
     * Gets the value of the lstIndicadorVinculacion property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIndicadorVinculacionDTO }
     *     
     */
    public ArrayOfIndicadorVinculacionDTO getLstIndicadorVinculacion() {
        return lstIndicadorVinculacion;
    }

    /**
     * Sets the value of the lstIndicadorVinculacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIndicadorVinculacionDTO }
     *     
     */
    public void setLstIndicadorVinculacion(ArrayOfIndicadorVinculacionDTO value) {
        this.lstIndicadorVinculacion = value;
    }

    /**
     * Gets the value of the lstIndicadorRetiro property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIndicadorRetiroDTO }
     *     
     */
    public ArrayOfIndicadorRetiroDTO getLstIndicadorRetiro() {
        return lstIndicadorRetiro;
    }

    /**
     * Sets the value of the lstIndicadorRetiro property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIndicadorRetiroDTO }
     *     
     */
    public void setLstIndicadorRetiro(ArrayOfIndicadorRetiroDTO value) {
        this.lstIndicadorRetiro = value;
    }

}

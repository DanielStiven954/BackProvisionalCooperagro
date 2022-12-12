
package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for dato2DTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="dato2DTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Monto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Plazo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FechaUltPag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FecApertura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FecVencimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FecInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FecUltPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="TipoInteres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Tasa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Periodicidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CuotasPagadas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="MontoSolicitado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dato2DTO", propOrder = {
    "monto",
    "plazo",
    "fechaUltPag",
    "estado",
    "fecApertura",
    "fecVencimiento",
    "fecInicio",
    "fecUltPago",
    "tipoInteres",
    "tasa",
    "periodicidad",
    "cuotasPagadas",
    "montoSolicitado"
})
public class Dato2DTO {

    @XmlElement(name = "Monto")
    protected String monto;
    @XmlElement(name = "Plazo")
    protected String plazo;
    @XmlElement(name = "FechaUltPag")
    protected String fechaUltPag;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "FecApertura")
    protected String fecApertura;
    @XmlElement(name = "FecVencimiento")
    protected String fecVencimiento;
    @XmlElement(name = "FecInicio")
    protected String fecInicio;
    @XmlElement(name = "FecUltPago")
    protected String fecUltPago;
    @XmlElement(name = "TipoInteres")
    protected String tipoInteres;
    @XmlElement(name = "Tasa")
    protected String tasa;
    @XmlElement(name = "Periodicidad")
    protected String periodicidad;
    @XmlElement(name = "CuotasPagadas")
    protected String cuotasPagadas;
    @XmlElement(name = "MontoSolicitado")
    protected String montoSolicitado;

    /**
     * Gets the value of the monto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonto(String value) {
        this.monto = value;
    }

    /**
     * Gets the value of the plazo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazo() {
        return plazo;
    }

    /**
     * Sets the value of the plazo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazo(String value) {
        this.plazo = value;
    }

    /**
     * Gets the value of the fechaUltPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaUltPag() {
        return fechaUltPag;
    }

    /**
     * Sets the value of the fechaUltPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaUltPag(String value) {
        this.fechaUltPag = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the fecApertura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecApertura() {
        return fecApertura;
    }

    /**
     * Sets the value of the fecApertura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecApertura(String value) {
        this.fecApertura = value;
    }

    /**
     * Gets the value of the fecVencimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecVencimiento() {
        return fecVencimiento;
    }

    /**
     * Sets the value of the fecVencimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecVencimiento(String value) {
        this.fecVencimiento = value;
    }

    /**
     * Gets the value of the fecInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecInicio() {
        return fecInicio;
    }

    /**
     * Sets the value of the fecInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecInicio(String value) {
        this.fecInicio = value;
    }

    /**
     * Gets the value of the fecUltPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecUltPago() {
        return fecUltPago;
    }

    /**
     * Sets the value of the fecUltPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecUltPago(String value) {
        this.fecUltPago = value;
    }

    /**
     * Gets the value of the tipoInteres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoInteres() {
        return tipoInteres;
    }

    /**
     * Sets the value of the tipoInteres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoInteres(String value) {
        this.tipoInteres = value;
    }

    /**
     * Gets the value of the tasa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasa() {
        return tasa;
    }

    /**
     * Sets the value of the tasa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasa(String value) {
        this.tasa = value;
    }

    /**
     * Gets the value of the periodicidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodicidad() {
        return periodicidad;
    }

    /**
     * Sets the value of the periodicidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodicidad(String value) {
        this.periodicidad = value;
    }

    /**
     * Gets the value of the cuotasPagadas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuotasPagadas() {
        return cuotasPagadas;
    }

    /**
     * Sets the value of the cuotasPagadas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuotasPagadas(String value) {
        this.cuotasPagadas = value;
    }

    /**
     * Gets the value of the montoSolicitado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoSolicitado() {
        return montoSolicitado;
    }

    /**
     * Sets the value of the montoSolicitado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoSolicitado(String value) {
        this.montoSolicitado = value;
    }

}

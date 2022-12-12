
package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for dato3DTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="dato3DTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Num_radicado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fecha_aprob" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Linea_cred" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Monto_aprob" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Cuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Cuota_apor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Saldo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Saldo_apor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fecha_prox_pag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Altura_cuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Linea_apor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fecha_ult_mov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Periocidad_pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Prox_pag_apor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Ult_mov_apor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Linea_aho_vis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Num_cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fecha_aper_cuen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Tasa_cuent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Canje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Saldo_total_cuen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Num_cdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Plazo_cdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Valor_cdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fecha_ini_cdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Tasa_cdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fec_term_cdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Linea_contrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Num_cuenta_contrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fec_aper_contrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Cuota_contrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Saldo_contrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Tasa_contrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fec_prox_pago_contrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Forma_pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Tasa_cred" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Plazo_cred" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Num_aport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dato3DTO", propOrder = {
    "numRadicado",
    "fechaAprob",
    "lineaCred",
    "montoAprob",
    "cuota",
    "cuotaApor",
    "saldo",
    "saldoApor",
    "fechaProxPag",
    "alturaCuota",
    "lineaApor",
    "fechaUltMov",
    "periocidadPago",
    "proxPagApor",
    "ultMovApor",
    "lineaAhoVis",
    "numCuenta",
    "fechaAperCuen",
    "tasaCuent",
    "canje",
    "saldoTotalCuen",
    "numCdat",
    "plazoCdat",
    "valorCdat",
    "fechaIniCdat",
    "tasaCdat",
    "fecTermCdat",
    "lineaContrac",
    "numCuentaContrac",
    "fecAperContrac",
    "cuotaContrac",
    "saldoContrac",
    "tasaContrac",
    "fecProxPagoContrac",
    "formaPago",
    "tasaCred",
    "plazoCred",
    "numAport"
})
public class Dato3DTO {

    @XmlElement(name = "Num_radicado")
    protected String numRadicado;
    @XmlElement(name = "Fecha_aprob")
    protected String fechaAprob;
    @XmlElement(name = "Linea_cred")
    protected String lineaCred;
    @XmlElement(name = "Monto_aprob")
    protected String montoAprob;
    @XmlElement(name = "Cuota")
    protected String cuota;
    @XmlElement(name = "Cuota_apor")
    protected String cuotaApor;
    @XmlElement(name = "Saldo")
    protected String saldo;
    @XmlElement(name = "Saldo_apor")
    protected String saldoApor;
    @XmlElement(name = "Fecha_prox_pag")
    protected String fechaProxPag;
    @XmlElement(name = "Altura_cuota")
    protected String alturaCuota;
    @XmlElement(name = "Linea_apor")
    protected String lineaApor;
    @XmlElement(name = "Fecha_ult_mov")
    protected String fechaUltMov;
    @XmlElement(name = "Periocidad_pago")
    protected String periocidadPago;
    @XmlElement(name = "Prox_pag_apor")
    protected String proxPagApor;
    @XmlElement(name = "Ult_mov_apor")
    protected String ultMovApor;
    @XmlElement(name = "Linea_aho_vis")
    protected String lineaAhoVis;
    @XmlElement(name = "Num_cuenta")
    protected String numCuenta;
    @XmlElement(name = "Fecha_aper_cuen")
    protected String fechaAperCuen;
    @XmlElement(name = "Tasa_cuent")
    protected String tasaCuent;
    @XmlElement(name = "Canje")
    protected String canje;
    @XmlElement(name = "Saldo_total_cuen")
    protected String saldoTotalCuen;
    @XmlElement(name = "Num_cdat")
    protected String numCdat;
    @XmlElement(name = "Plazo_cdat")
    protected String plazoCdat;
    @XmlElement(name = "Valor_cdat")
    protected String valorCdat;
    @XmlElement(name = "Fecha_ini_cdat")
    protected String fechaIniCdat;
    @XmlElement(name = "Tasa_cdat")
    protected String tasaCdat;
    @XmlElement(name = "Fec_term_cdat")
    protected String fecTermCdat;
    @XmlElement(name = "Linea_contrac")
    protected String lineaContrac;
    @XmlElement(name = "Num_cuenta_contrac")
    protected String numCuentaContrac;
    @XmlElement(name = "Fec_aper_contrac")
    protected String fecAperContrac;
    @XmlElement(name = "Cuota_contrac")
    protected String cuotaContrac;
    @XmlElement(name = "Saldo_contrac")
    protected String saldoContrac;
    @XmlElement(name = "Tasa_contrac")
    protected String tasaContrac;
    @XmlElement(name = "Fec_prox_pago_contrac")
    protected String fecProxPagoContrac;
    @XmlElement(name = "Forma_pago")
    protected String formaPago;
    @XmlElement(name = "Tasa_cred")
    protected String tasaCred;
    @XmlElement(name = "Plazo_cred")
    protected String plazoCred;
    @XmlElement(name = "Num_aport")
    protected String numAport;

    /**
     * Gets the value of the numRadicado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRadicado() {
        return numRadicado;
    }

    /**
     * Sets the value of the numRadicado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRadicado(String value) {
        this.numRadicado = value;
    }

    /**
     * Gets the value of the fechaAprob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAprob() {
        return fechaAprob;
    }

    /**
     * Sets the value of the fechaAprob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAprob(String value) {
        this.fechaAprob = value;
    }

    /**
     * Gets the value of the lineaCred property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineaCred() {
        return lineaCred;
    }

    /**
     * Sets the value of the lineaCred property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineaCred(String value) {
        this.lineaCred = value;
    }

    /**
     * Gets the value of the montoAprob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoAprob() {
        return montoAprob;
    }

    /**
     * Sets the value of the montoAprob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoAprob(String value) {
        this.montoAprob = value;
    }

    /**
     * Gets the value of the cuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuota() {
        return cuota;
    }

    /**
     * Sets the value of the cuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuota(String value) {
        this.cuota = value;
    }

    /**
     * Gets the value of the cuotaApor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuotaApor() {
        return cuotaApor;
    }

    /**
     * Sets the value of the cuotaApor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuotaApor(String value) {
        this.cuotaApor = value;
    }

    /**
     * Gets the value of the saldo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldo() {
        return saldo;
    }

    /**
     * Sets the value of the saldo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldo(String value) {
        this.saldo = value;
    }

    /**
     * Gets the value of the saldoApor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoApor() {
        return saldoApor;
    }

    /**
     * Sets the value of the saldoApor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoApor(String value) {
        this.saldoApor = value;
    }

    /**
     * Gets the value of the fechaProxPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaProxPag() {
        return fechaProxPag;
    }

    /**
     * Sets the value of the fechaProxPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaProxPag(String value) {
        this.fechaProxPag = value;
    }

    /**
     * Gets the value of the alturaCuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlturaCuota() {
        return alturaCuota;
    }

    /**
     * Sets the value of the alturaCuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlturaCuota(String value) {
        this.alturaCuota = value;
    }

    /**
     * Gets the value of the lineaApor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineaApor() {
        return lineaApor;
    }

    /**
     * Sets the value of the lineaApor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineaApor(String value) {
        this.lineaApor = value;
    }

    /**
     * Gets the value of the fechaUltMov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaUltMov() {
        return fechaUltMov;
    }

    /**
     * Sets the value of the fechaUltMov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaUltMov(String value) {
        this.fechaUltMov = value;
    }

    /**
     * Gets the value of the periocidadPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriocidadPago() {
        return periocidadPago;
    }

    /**
     * Sets the value of the periocidadPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriocidadPago(String value) {
        this.periocidadPago = value;
    }

    /**
     * Gets the value of the proxPagApor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxPagApor() {
        return proxPagApor;
    }

    /**
     * Sets the value of the proxPagApor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxPagApor(String value) {
        this.proxPagApor = value;
    }

    /**
     * Gets the value of the ultMovApor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltMovApor() {
        return ultMovApor;
    }

    /**
     * Sets the value of the ultMovApor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltMovApor(String value) {
        this.ultMovApor = value;
    }

    /**
     * Gets the value of the lineaAhoVis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineaAhoVis() {
        return lineaAhoVis;
    }

    /**
     * Sets the value of the lineaAhoVis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineaAhoVis(String value) {
        this.lineaAhoVis = value;
    }

    /**
     * Gets the value of the numCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Sets the value of the numCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuenta(String value) {
        this.numCuenta = value;
    }

    /**
     * Gets the value of the fechaAperCuen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAperCuen() {
        return fechaAperCuen;
    }

    /**
     * Sets the value of the fechaAperCuen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAperCuen(String value) {
        this.fechaAperCuen = value;
    }

    /**
     * Gets the value of the tasaCuent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaCuent() {
        return tasaCuent;
    }

    /**
     * Sets the value of the tasaCuent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaCuent(String value) {
        this.tasaCuent = value;
    }

    /**
     * Gets the value of the canje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanje() {
        return canje;
    }

    /**
     * Sets the value of the canje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanje(String value) {
        this.canje = value;
    }

    /**
     * Gets the value of the saldoTotalCuen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoTotalCuen() {
        return saldoTotalCuen;
    }

    /**
     * Sets the value of the saldoTotalCuen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoTotalCuen(String value) {
        this.saldoTotalCuen = value;
    }

    /**
     * Gets the value of the numCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCdat() {
        return numCdat;
    }

    /**
     * Sets the value of the numCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCdat(String value) {
        this.numCdat = value;
    }

    /**
     * Gets the value of the plazoCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazoCdat() {
        return plazoCdat;
    }

    /**
     * Sets the value of the plazoCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazoCdat(String value) {
        this.plazoCdat = value;
    }

    /**
     * Gets the value of the valorCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorCdat() {
        return valorCdat;
    }

    /**
     * Sets the value of the valorCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorCdat(String value) {
        this.valorCdat = value;
    }

    /**
     * Gets the value of the fechaIniCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaIniCdat() {
        return fechaIniCdat;
    }

    /**
     * Sets the value of the fechaIniCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaIniCdat(String value) {
        this.fechaIniCdat = value;
    }

    /**
     * Gets the value of the tasaCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaCdat() {
        return tasaCdat;
    }

    /**
     * Sets the value of the tasaCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaCdat(String value) {
        this.tasaCdat = value;
    }

    /**
     * Gets the value of the fecTermCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecTermCdat() {
        return fecTermCdat;
    }

    /**
     * Sets the value of the fecTermCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecTermCdat(String value) {
        this.fecTermCdat = value;
    }

    /**
     * Gets the value of the lineaContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineaContrac() {
        return lineaContrac;
    }

    /**
     * Sets the value of the lineaContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineaContrac(String value) {
        this.lineaContrac = value;
    }

    /**
     * Gets the value of the numCuentaContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuentaContrac() {
        return numCuentaContrac;
    }

    /**
     * Sets the value of the numCuentaContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuentaContrac(String value) {
        this.numCuentaContrac = value;
    }

    /**
     * Gets the value of the fecAperContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecAperContrac() {
        return fecAperContrac;
    }

    /**
     * Sets the value of the fecAperContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecAperContrac(String value) {
        this.fecAperContrac = value;
    }

    /**
     * Gets the value of the cuotaContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuotaContrac() {
        return cuotaContrac;
    }

    /**
     * Sets the value of the cuotaContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuotaContrac(String value) {
        this.cuotaContrac = value;
    }

    /**
     * Gets the value of the saldoContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoContrac() {
        return saldoContrac;
    }

    /**
     * Sets the value of the saldoContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoContrac(String value) {
        this.saldoContrac = value;
    }

    /**
     * Gets the value of the tasaContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaContrac() {
        return tasaContrac;
    }

    /**
     * Sets the value of the tasaContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaContrac(String value) {
        this.tasaContrac = value;
    }

    /**
     * Gets the value of the fecProxPagoContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecProxPagoContrac() {
        return fecProxPagoContrac;
    }

    /**
     * Sets the value of the fecProxPagoContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecProxPagoContrac(String value) {
        this.fecProxPagoContrac = value;
    }

    /**
     * Gets the value of the formaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the tasaCred property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaCred() {
        return tasaCred;
    }

    /**
     * Sets the value of the tasaCred property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaCred(String value) {
        this.tasaCred = value;
    }

    /**
     * Gets the value of the plazoCred property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazoCred() {
        return plazoCred;
    }

    /**
     * Sets the value of the plazoCred property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazoCred(String value) {
        this.plazoCred = value;
    }

    /**
     * Gets the value of the numAport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAport() {
        return numAport;
    }

    /**
     * Sets the value of the numAport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAport(String value) {
        this.numAport = value;
    }

}

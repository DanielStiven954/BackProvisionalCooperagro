
package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DetalleCta complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DetalleCta"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="INumRadic" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SCodCredi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SNombreLinea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ICodDesti" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SDescDestinac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SMontoSol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DPlazo" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="SValorCuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SFechaUltPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SEstado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IPeriodicidad" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SDescPeriodicidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IFormaPago" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SDescFormaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SValorSaldoCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SFechaProxPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CNumAporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SFechaApertura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SFechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SFechaUltMovimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SCuotaTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SCuotaApo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SSaldoTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IPerPago" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SDescPerPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CDescAporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IEstado" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SNumCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SDescAhorro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SModalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SCalcTasa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ITipoTasa" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="ITipoHis" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SSaldoCanje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DTasaInt" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="DDesvTasa" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="IModalidad" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="ICalcTasa" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SNumCdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SValorCdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="STotalIntCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IPerInt" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SFechaInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SFechaFin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SNumContrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SDescAhorroContrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SSaldoAhorroContrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SCuotaAhorroContrac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ICuotaPag" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SFechaSolicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="BRtaConsulta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="SMjs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SBonosAsig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="INumAparados" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SFechaTer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="INumBeneficiarios" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SEstadoServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetalleCta", propOrder = {
    "iNumRadic",
    "sCodCredi",
    "sNombreLinea",
    "iCodDesti",
    "sDescDestinac",
    "sMontoSol",
    "dPlazo",
    "sValorCuota",
    "sFechaUltPago",
    "sEstado",
    "iPeriodicidad",
    "sDescPeriodicidad",
    "iFormaPago",
    "sDescFormaPago",
    "sValorSaldoCap",
    "sFechaProxPago",
    "cNumAporte",
    "sFechaApertura",
    "sFechaVencimiento",
    "sFechaUltMovimiento",
    "sCuotaTotal",
    "sCuotaApo",
    "sSaldoTotal",
    "iPerPago",
    "sDescPerPago",
    "cDescAporte",
    "iEstado",
    "sNumCuenta",
    "sDescAhorro",
    "sModalidad",
    "sCalcTasa",
    "iTipoTasa",
    "iTipoHis",
    "sSaldoCanje",
    "dTasaInt",
    "dDesvTasa",
    "iModalidad",
    "iCalcTasa",
    "sNumCdat",
    "sValorCdat",
    "sTotalIntCap",
    "iPerInt",
    "sFechaInicio",
    "sFechaFin",
    "sNumContrac",
    "sDescAhorroContrac",
    "sSaldoAhorroContrac",
    "sCuotaAhorroContrac",
    "iCuotaPag",
    "sFechaSolicitud",
    "bRtaConsulta",
    "sMjs",
    "sBonosAsig",
    "iNumAparados",
    "sFechaTer",
    "iNumBeneficiarios",
    "sEstadoServicio"
})
public class DetalleCta {

    @XmlElement(name = "INumRadic")
    protected int iNumRadic;
    @XmlElement(name = "SCodCredi")
    protected String sCodCredi;
    @XmlElement(name = "SNombreLinea")
    protected String sNombreLinea;
    @XmlElement(name = "ICodDesti")
    protected int iCodDesti;
    @XmlElement(name = "SDescDestinac")
    protected String sDescDestinac;
    @XmlElement(name = "SMontoSol")
    protected String sMontoSol;
    @XmlElement(name = "DPlazo")
    protected double dPlazo;
    @XmlElement(name = "SValorCuota")
    protected String sValorCuota;
    @XmlElement(name = "SFechaUltPago")
    protected String sFechaUltPago;
    @XmlElement(name = "SEstado")
    protected String sEstado;
    @XmlElement(name = "IPeriodicidad")
    protected int iPeriodicidad;
    @XmlElement(name = "SDescPeriodicidad")
    protected String sDescPeriodicidad;
    @XmlElement(name = "IFormaPago")
    protected int iFormaPago;
    @XmlElement(name = "SDescFormaPago")
    protected String sDescFormaPago;
    @XmlElement(name = "SValorSaldoCap")
    protected String sValorSaldoCap;
    @XmlElement(name = "SFechaProxPago")
    protected String sFechaProxPago;
    @XmlElement(name = "CNumAporte")
    protected String cNumAporte;
    @XmlElement(name = "SFechaApertura")
    protected String sFechaApertura;
    @XmlElement(name = "SFechaVencimiento")
    protected String sFechaVencimiento;
    @XmlElement(name = "SFechaUltMovimiento")
    protected String sFechaUltMovimiento;
    @XmlElement(name = "SCuotaTotal")
    protected String sCuotaTotal;
    @XmlElement(name = "SCuotaApo")
    protected String sCuotaApo;
    @XmlElement(name = "SSaldoTotal")
    protected String sSaldoTotal;
    @XmlElement(name = "IPerPago")
    protected int iPerPago;
    @XmlElement(name = "SDescPerPago")
    protected String sDescPerPago;
    @XmlElement(name = "CDescAporte")
    protected String cDescAporte;
    @XmlElement(name = "IEstado")
    protected int iEstado;
    @XmlElement(name = "SNumCuenta")
    protected String sNumCuenta;
    @XmlElement(name = "SDescAhorro")
    protected String sDescAhorro;
    @XmlElement(name = "SModalidad")
    protected String sModalidad;
    @XmlElement(name = "SCalcTasa")
    protected String sCalcTasa;
    @XmlElement(name = "ITipoTasa")
    protected int iTipoTasa;
    @XmlElement(name = "ITipoHis")
    protected int iTipoHis;
    @XmlElement(name = "SSaldoCanje")
    protected String sSaldoCanje;
    @XmlElement(name = "DTasaInt")
    protected double dTasaInt;
    @XmlElement(name = "DDesvTasa")
    protected double dDesvTasa;
    @XmlElement(name = "IModalidad")
    protected int iModalidad;
    @XmlElement(name = "ICalcTasa")
    protected int iCalcTasa;
    @XmlElement(name = "SNumCdat")
    protected String sNumCdat;
    @XmlElement(name = "SValorCdat")
    protected String sValorCdat;
    @XmlElement(name = "STotalIntCap")
    protected String sTotalIntCap;
    @XmlElement(name = "IPerInt")
    protected int iPerInt;
    @XmlElement(name = "SFechaInicio")
    protected String sFechaInicio;
    @XmlElement(name = "SFechaFin")
    protected String sFechaFin;
    @XmlElement(name = "SNumContrac")
    protected String sNumContrac;
    @XmlElement(name = "SDescAhorroContrac")
    protected String sDescAhorroContrac;
    @XmlElement(name = "SSaldoAhorroContrac")
    protected String sSaldoAhorroContrac;
    @XmlElement(name = "SCuotaAhorroContrac")
    protected String sCuotaAhorroContrac;
    @XmlElement(name = "ICuotaPag")
    protected int iCuotaPag;
    @XmlElement(name = "SFechaSolicitud")
    protected String sFechaSolicitud;
    @XmlElement(name = "BRtaConsulta")
    protected boolean bRtaConsulta;
    @XmlElement(name = "SMjs")
    protected String sMjs;
    @XmlElement(name = "SBonosAsig")
    protected String sBonosAsig;
    @XmlElement(name = "INumAparados")
    protected int iNumAparados;
    @XmlElement(name = "SFechaTer")
    protected String sFechaTer;
    @XmlElement(name = "INumBeneficiarios")
    protected int iNumBeneficiarios;
    @XmlElement(name = "SEstadoServicio")
    protected String sEstadoServicio;

    /**
     * Gets the value of the iNumRadic property.
     * 
     */
    public int getINumRadic() {
        return iNumRadic;
    }

    /**
     * Sets the value of the iNumRadic property.
     * 
     */
    public void setINumRadic(int value) {
        this.iNumRadic = value;
    }

    /**
     * Gets the value of the sCodCredi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCodCredi() {
        return sCodCredi;
    }

    /**
     * Sets the value of the sCodCredi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCodCredi(String value) {
        this.sCodCredi = value;
    }

    /**
     * Gets the value of the sNombreLinea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNombreLinea() {
        return sNombreLinea;
    }

    /**
     * Sets the value of the sNombreLinea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNombreLinea(String value) {
        this.sNombreLinea = value;
    }

    /**
     * Gets the value of the iCodDesti property.
     * 
     */
    public int getICodDesti() {
        return iCodDesti;
    }

    /**
     * Sets the value of the iCodDesti property.
     * 
     */
    public void setICodDesti(int value) {
        this.iCodDesti = value;
    }

    /**
     * Gets the value of the sDescDestinac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescDestinac() {
        return sDescDestinac;
    }

    /**
     * Sets the value of the sDescDestinac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescDestinac(String value) {
        this.sDescDestinac = value;
    }

    /**
     * Gets the value of the sMontoSol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMontoSol() {
        return sMontoSol;
    }

    /**
     * Sets the value of the sMontoSol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMontoSol(String value) {
        this.sMontoSol = value;
    }

    /**
     * Gets the value of the dPlazo property.
     * 
     */
    public double getDPlazo() {
        return dPlazo;
    }

    /**
     * Sets the value of the dPlazo property.
     * 
     */
    public void setDPlazo(double value) {
        this.dPlazo = value;
    }

    /**
     * Gets the value of the sValorCuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSValorCuota() {
        return sValorCuota;
    }

    /**
     * Sets the value of the sValorCuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSValorCuota(String value) {
        this.sValorCuota = value;
    }

    /**
     * Gets the value of the sFechaUltPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaUltPago() {
        return sFechaUltPago;
    }

    /**
     * Sets the value of the sFechaUltPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaUltPago(String value) {
        this.sFechaUltPago = value;
    }

    /**
     * Gets the value of the sEstado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEstado() {
        return sEstado;
    }

    /**
     * Sets the value of the sEstado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEstado(String value) {
        this.sEstado = value;
    }

    /**
     * Gets the value of the iPeriodicidad property.
     * 
     */
    public int getIPeriodicidad() {
        return iPeriodicidad;
    }

    /**
     * Sets the value of the iPeriodicidad property.
     * 
     */
    public void setIPeriodicidad(int value) {
        this.iPeriodicidad = value;
    }

    /**
     * Gets the value of the sDescPeriodicidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescPeriodicidad() {
        return sDescPeriodicidad;
    }

    /**
     * Sets the value of the sDescPeriodicidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescPeriodicidad(String value) {
        this.sDescPeriodicidad = value;
    }

    /**
     * Gets the value of the iFormaPago property.
     * 
     */
    public int getIFormaPago() {
        return iFormaPago;
    }

    /**
     * Sets the value of the iFormaPago property.
     * 
     */
    public void setIFormaPago(int value) {
        this.iFormaPago = value;
    }

    /**
     * Gets the value of the sDescFormaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescFormaPago() {
        return sDescFormaPago;
    }

    /**
     * Sets the value of the sDescFormaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescFormaPago(String value) {
        this.sDescFormaPago = value;
    }

    /**
     * Gets the value of the sValorSaldoCap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSValorSaldoCap() {
        return sValorSaldoCap;
    }

    /**
     * Sets the value of the sValorSaldoCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSValorSaldoCap(String value) {
        this.sValorSaldoCap = value;
    }

    /**
     * Gets the value of the sFechaProxPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaProxPago() {
        return sFechaProxPago;
    }

    /**
     * Sets the value of the sFechaProxPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaProxPago(String value) {
        this.sFechaProxPago = value;
    }

    /**
     * Gets the value of the cNumAporte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNumAporte() {
        return cNumAporte;
    }

    /**
     * Sets the value of the cNumAporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNumAporte(String value) {
        this.cNumAporte = value;
    }

    /**
     * Gets the value of the sFechaApertura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaApertura() {
        return sFechaApertura;
    }

    /**
     * Sets the value of the sFechaApertura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaApertura(String value) {
        this.sFechaApertura = value;
    }

    /**
     * Gets the value of the sFechaVencimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaVencimiento() {
        return sFechaVencimiento;
    }

    /**
     * Sets the value of the sFechaVencimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaVencimiento(String value) {
        this.sFechaVencimiento = value;
    }

    /**
     * Gets the value of the sFechaUltMovimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaUltMovimiento() {
        return sFechaUltMovimiento;
    }

    /**
     * Sets the value of the sFechaUltMovimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaUltMovimiento(String value) {
        this.sFechaUltMovimiento = value;
    }

    /**
     * Gets the value of the sCuotaTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCuotaTotal() {
        return sCuotaTotal;
    }

    /**
     * Sets the value of the sCuotaTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCuotaTotal(String value) {
        this.sCuotaTotal = value;
    }

    /**
     * Gets the value of the sCuotaApo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCuotaApo() {
        return sCuotaApo;
    }

    /**
     * Sets the value of the sCuotaApo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCuotaApo(String value) {
        this.sCuotaApo = value;
    }

    /**
     * Gets the value of the sSaldoTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSaldoTotal() {
        return sSaldoTotal;
    }

    /**
     * Sets the value of the sSaldoTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSaldoTotal(String value) {
        this.sSaldoTotal = value;
    }

    /**
     * Gets the value of the iPerPago property.
     * 
     */
    public int getIPerPago() {
        return iPerPago;
    }

    /**
     * Sets the value of the iPerPago property.
     * 
     */
    public void setIPerPago(int value) {
        this.iPerPago = value;
    }

    /**
     * Gets the value of the sDescPerPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescPerPago() {
        return sDescPerPago;
    }

    /**
     * Sets the value of the sDescPerPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescPerPago(String value) {
        this.sDescPerPago = value;
    }

    /**
     * Gets the value of the cDescAporte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDescAporte() {
        return cDescAporte;
    }

    /**
     * Sets the value of the cDescAporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDescAporte(String value) {
        this.cDescAporte = value;
    }

    /**
     * Gets the value of the iEstado property.
     * 
     */
    public int getIEstado() {
        return iEstado;
    }

    /**
     * Sets the value of the iEstado property.
     * 
     */
    public void setIEstado(int value) {
        this.iEstado = value;
    }

    /**
     * Gets the value of the sNumCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumCuenta() {
        return sNumCuenta;
    }

    /**
     * Sets the value of the sNumCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumCuenta(String value) {
        this.sNumCuenta = value;
    }

    /**
     * Gets the value of the sDescAhorro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescAhorro() {
        return sDescAhorro;
    }

    /**
     * Sets the value of the sDescAhorro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescAhorro(String value) {
        this.sDescAhorro = value;
    }

    /**
     * Gets the value of the sModalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSModalidad() {
        return sModalidad;
    }

    /**
     * Sets the value of the sModalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSModalidad(String value) {
        this.sModalidad = value;
    }

    /**
     * Gets the value of the sCalcTasa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCalcTasa() {
        return sCalcTasa;
    }

    /**
     * Sets the value of the sCalcTasa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCalcTasa(String value) {
        this.sCalcTasa = value;
    }

    /**
     * Gets the value of the iTipoTasa property.
     * 
     */
    public int getITipoTasa() {
        return iTipoTasa;
    }

    /**
     * Sets the value of the iTipoTasa property.
     * 
     */
    public void setITipoTasa(int value) {
        this.iTipoTasa = value;
    }

    /**
     * Gets the value of the iTipoHis property.
     * 
     */
    public int getITipoHis() {
        return iTipoHis;
    }

    /**
     * Sets the value of the iTipoHis property.
     * 
     */
    public void setITipoHis(int value) {
        this.iTipoHis = value;
    }

    /**
     * Gets the value of the sSaldoCanje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSaldoCanje() {
        return sSaldoCanje;
    }

    /**
     * Sets the value of the sSaldoCanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSaldoCanje(String value) {
        this.sSaldoCanje = value;
    }

    /**
     * Gets the value of the dTasaInt property.
     * 
     */
    public double getDTasaInt() {
        return dTasaInt;
    }

    /**
     * Sets the value of the dTasaInt property.
     * 
     */
    public void setDTasaInt(double value) {
        this.dTasaInt = value;
    }

    /**
     * Gets the value of the dDesvTasa property.
     * 
     */
    public double getDDesvTasa() {
        return dDesvTasa;
    }

    /**
     * Sets the value of the dDesvTasa property.
     * 
     */
    public void setDDesvTasa(double value) {
        this.dDesvTasa = value;
    }

    /**
     * Gets the value of the iModalidad property.
     * 
     */
    public int getIModalidad() {
        return iModalidad;
    }

    /**
     * Sets the value of the iModalidad property.
     * 
     */
    public void setIModalidad(int value) {
        this.iModalidad = value;
    }

    /**
     * Gets the value of the iCalcTasa property.
     * 
     */
    public int getICalcTasa() {
        return iCalcTasa;
    }

    /**
     * Sets the value of the iCalcTasa property.
     * 
     */
    public void setICalcTasa(int value) {
        this.iCalcTasa = value;
    }

    /**
     * Gets the value of the sNumCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumCdat() {
        return sNumCdat;
    }

    /**
     * Sets the value of the sNumCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumCdat(String value) {
        this.sNumCdat = value;
    }

    /**
     * Gets the value of the sValorCdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSValorCdat() {
        return sValorCdat;
    }

    /**
     * Sets the value of the sValorCdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSValorCdat(String value) {
        this.sValorCdat = value;
    }

    /**
     * Gets the value of the sTotalIntCap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTotalIntCap() {
        return sTotalIntCap;
    }

    /**
     * Sets the value of the sTotalIntCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTotalIntCap(String value) {
        this.sTotalIntCap = value;
    }

    /**
     * Gets the value of the iPerInt property.
     * 
     */
    public int getIPerInt() {
        return iPerInt;
    }

    /**
     * Sets the value of the iPerInt property.
     * 
     */
    public void setIPerInt(int value) {
        this.iPerInt = value;
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

    /**
     * Gets the value of the sNumContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumContrac() {
        return sNumContrac;
    }

    /**
     * Sets the value of the sNumContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumContrac(String value) {
        this.sNumContrac = value;
    }

    /**
     * Gets the value of the sDescAhorroContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescAhorroContrac() {
        return sDescAhorroContrac;
    }

    /**
     * Sets the value of the sDescAhorroContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescAhorroContrac(String value) {
        this.sDescAhorroContrac = value;
    }

    /**
     * Gets the value of the sSaldoAhorroContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSaldoAhorroContrac() {
        return sSaldoAhorroContrac;
    }

    /**
     * Sets the value of the sSaldoAhorroContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSaldoAhorroContrac(String value) {
        this.sSaldoAhorroContrac = value;
    }

    /**
     * Gets the value of the sCuotaAhorroContrac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCuotaAhorroContrac() {
        return sCuotaAhorroContrac;
    }

    /**
     * Sets the value of the sCuotaAhorroContrac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCuotaAhorroContrac(String value) {
        this.sCuotaAhorroContrac = value;
    }

    /**
     * Gets the value of the iCuotaPag property.
     * 
     */
    public int getICuotaPag() {
        return iCuotaPag;
    }

    /**
     * Sets the value of the iCuotaPag property.
     * 
     */
    public void setICuotaPag(int value) {
        this.iCuotaPag = value;
    }

    /**
     * Gets the value of the sFechaSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaSolicitud() {
        return sFechaSolicitud;
    }

    /**
     * Sets the value of the sFechaSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaSolicitud(String value) {
        this.sFechaSolicitud = value;
    }

    /**
     * Gets the value of the bRtaConsulta property.
     * 
     */
    public boolean isBRtaConsulta() {
        return bRtaConsulta;
    }

    /**
     * Sets the value of the bRtaConsulta property.
     * 
     */
    public void setBRtaConsulta(boolean value) {
        this.bRtaConsulta = value;
    }

    /**
     * Gets the value of the sMjs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMjs() {
        return sMjs;
    }

    /**
     * Sets the value of the sMjs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMjs(String value) {
        this.sMjs = value;
    }

    /**
     * Gets the value of the sBonosAsig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBonosAsig() {
        return sBonosAsig;
    }

    /**
     * Sets the value of the sBonosAsig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBonosAsig(String value) {
        this.sBonosAsig = value;
    }

    /**
     * Gets the value of the iNumAparados property.
     * 
     */
    public int getINumAparados() {
        return iNumAparados;
    }

    /**
     * Sets the value of the iNumAparados property.
     * 
     */
    public void setINumAparados(int value) {
        this.iNumAparados = value;
    }

    /**
     * Gets the value of the sFechaTer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFechaTer() {
        return sFechaTer;
    }

    /**
     * Sets the value of the sFechaTer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFechaTer(String value) {
        this.sFechaTer = value;
    }

    /**
     * Gets the value of the iNumBeneficiarios property.
     * 
     */
    public int getINumBeneficiarios() {
        return iNumBeneficiarios;
    }

    /**
     * Sets the value of the iNumBeneficiarios property.
     * 
     */
    public void setINumBeneficiarios(int value) {
        this.iNumBeneficiarios = value;
    }

    /**
     * Gets the value of the sEstadoServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEstadoServicio() {
        return sEstadoServicio;
    }

    /**
     * Sets the value of the sEstadoServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEstadoServicio(String value) {
        this.sEstadoServicio = value;
    }

}

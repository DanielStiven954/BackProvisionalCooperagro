
package com.ebssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for datoDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="datoDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Linea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Cupo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fechapago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SFechaUltPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Valorpago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Radicado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Transaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Acumulado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Numapo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Disponible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Plazo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="NumCuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fechafin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Cuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Saldocapital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Concepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Saldo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Numlista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Numdevolucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="TipoTran" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Fecha_ini_cdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SNomAtributo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="STitular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datoDTO", propOrder = {
    "linea",
    "cupo",
    "fechapago",
    "sFechaUltPago",
    "valorpago",
    "radicado",
    "transaccion",
    "acumulado",
    "numapo",
    "disponible",
    "cuenta",
    "nombre",
    "numero",
    "fecha",
    "valor",
    "estado",
    "plazo",
    "numCuota",
    "fechafin",
    "cuota",
    "saldocapital",
    "concepto",
    "saldo",
    "numlista",
    "numdevolucion",
    "codigo",
    "tipoTran",
    "fechaIniCdat",
    "sNomAtributo",
    "sTitular"
})
public class DatoDTO {

    @XmlElement(name = "Linea")
    protected String linea;
    @XmlElement(name = "Cupo")
    protected String cupo;
    @XmlElement(name = "Fechapago")
    protected String fechapago;
    @XmlElement(name = "SFechaUltPago")
    protected String sFechaUltPago;
    @XmlElement(name = "Valorpago")
    protected String valorpago;
    @XmlElement(name = "Radicado")
    protected String radicado;
    @XmlElement(name = "Transaccion")
    protected String transaccion;
    @XmlElement(name = "Acumulado")
    protected String acumulado;
    @XmlElement(name = "Numapo")
    protected String numapo;
    @XmlElement(name = "Disponible")
    protected String disponible;
    @XmlElement(name = "Cuenta")
    protected String cuenta;
    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "Fecha")
    protected String fecha;
    @XmlElement(name = "Valor")
    protected String valor;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "Plazo")
    protected String plazo;
    @XmlElement(name = "NumCuota")
    protected String numCuota;
    @XmlElement(name = "Fechafin")
    protected String fechafin;
    @XmlElement(name = "Cuota")
    protected String cuota;
    @XmlElement(name = "Saldocapital")
    protected String saldocapital;
    @XmlElement(name = "Concepto")
    protected String concepto;
    @XmlElement(name = "Saldo")
    protected String saldo;
    @XmlElement(name = "Numlista")
    protected String numlista;
    @XmlElement(name = "Numdevolucion")
    protected String numdevolucion;
    @XmlElement(name = "Codigo")
    protected String codigo;
    @XmlElement(name = "TipoTran")
    protected String tipoTran;
    @XmlElement(name = "Fecha_ini_cdat")
    protected String fechaIniCdat;
    @XmlElement(name = "SNomAtributo")
    protected String sNomAtributo;
    @XmlElement(name = "STitular")
    protected String sTitular;

    /**
     * Gets the value of the linea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Sets the value of the linea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinea(String value) {
        this.linea = value;
    }

    /**
     * Gets the value of the cupo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCupo() {
        return cupo;
    }

    /**
     * Sets the value of the cupo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCupo(String value) {
        this.cupo = value;
    }

    /**
     * Gets the value of the fechapago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechapago() {
        return fechapago;
    }

    /**
     * Sets the value of the fechapago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechapago(String value) {
        this.fechapago = value;
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
     * Gets the value of the valorpago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorpago() {
        return valorpago;
    }

    /**
     * Sets the value of the valorpago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorpago(String value) {
        this.valorpago = value;
    }

    /**
     * Gets the value of the radicado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRadicado() {
        return radicado;
    }

    /**
     * Sets the value of the radicado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRadicado(String value) {
        this.radicado = value;
    }

    /**
     * Gets the value of the transaccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransaccion() {
        return transaccion;
    }

    /**
     * Sets the value of the transaccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransaccion(String value) {
        this.transaccion = value;
    }

    /**
     * Gets the value of the acumulado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcumulado() {
        return acumulado;
    }

    /**
     * Sets the value of the acumulado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcumulado(String value) {
        this.acumulado = value;
    }

    /**
     * Gets the value of the numapo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumapo() {
        return numapo;
    }

    /**
     * Sets the value of the numapo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumapo(String value) {
        this.numapo = value;
    }

    /**
     * Gets the value of the disponible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisponible() {
        return disponible;
    }

    /**
     * Sets the value of the disponible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisponible(String value) {
        this.disponible = value;
    }

    /**
     * Gets the value of the cuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Sets the value of the cuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuenta(String value) {
        this.cuenta = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the valor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor() {
        return valor;
    }

    /**
     * Sets the value of the valor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor(String value) {
        this.valor = value;
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
     * Gets the value of the numCuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuota() {
        return numCuota;
    }

    /**
     * Sets the value of the numCuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuota(String value) {
        this.numCuota = value;
    }

    /**
     * Gets the value of the fechafin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     * Sets the value of the fechafin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafin(String value) {
        this.fechafin = value;
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
     * Gets the value of the saldocapital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldocapital() {
        return saldocapital;
    }

    /**
     * Sets the value of the saldocapital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldocapital(String value) {
        this.saldocapital = value;
    }

    /**
     * Gets the value of the concepto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Sets the value of the concepto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConcepto(String value) {
        this.concepto = value;
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
     * Gets the value of the numlista property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumlista() {
        return numlista;
    }

    /**
     * Sets the value of the numlista property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumlista(String value) {
        this.numlista = value;
    }

    /**
     * Gets the value of the numdevolucion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumdevolucion() {
        return numdevolucion;
    }

    /**
     * Sets the value of the numdevolucion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumdevolucion(String value) {
        this.numdevolucion = value;
    }

    /**
     * Gets the value of the codigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the tipoTran property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTran() {
        return tipoTran;
    }

    /**
     * Sets the value of the tipoTran property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTran(String value) {
        this.tipoTran = value;
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
     * Gets the value of the sNomAtributo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNomAtributo() {
        return sNomAtributo;
    }

    /**
     * Sets the value of the sNomAtributo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNomAtributo(String value) {
        this.sNomAtributo = value;
    }

    /**
     * Gets the value of the sTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTitular() {
        return sTitular;
    }

    /**
     * Sets the value of the sTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTitular(String value) {
        this.sTitular = value;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Braya
 */
@Entity
@Table(name = "SOLICITUD_CREDITO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCredito.findAll", query = "SELECT s FROM SolicitudCredito s"),
    @NamedQuery(name = "SolicitudCredito.findByICodigo", query = "SELECT s FROM SolicitudCredito s WHERE s.iCodigo = :iCodigo"),
    @NamedQuery(name = "SolicitudCredito.findByINumRadic", query = "SELECT s FROM SolicitudCredito s WHERE s.iNumRadic = :iNumRadic"),
    @NamedQuery(name = "SolicitudCredito.findByICodCredito", query = "SELECT s FROM SolicitudCredito s WHERE s.iCodCredito = :iCodCredito"),
    @NamedQuery(name = "SolicitudCredito.findByFFechaSolicitud", query = "SELECT s FROM SolicitudCredito s WHERE s.fFechaSolicitud = :fFechaSolicitud"),
    @NamedQuery(name = "SolicitudCredito.findByNMontoSolicitud", query = "SELECT s FROM SolicitudCredito s WHERE s.nMontoSolicitud = :nMontoSolicitud"),
    @NamedQuery(name = "SolicitudCredito.findByPlazo", query = "SELECT s FROM SolicitudCredito s WHERE s.plazo = :plazo"),
    @NamedQuery(name = "SolicitudCredito.findByNValorCuota", query = "SELECT s FROM SolicitudCredito s WHERE s.nValorCuota = :nValorCuota"),
    @NamedQuery(name = "SolicitudCredito.findByICodPeriodo", query = "SELECT s FROM SolicitudCredito s WHERE s.iCodPeriodo = :iCodPeriodo"),
    @NamedQuery(name = "SolicitudCredito.findByFFechaCreacion", query = "SELECT s FROM SolicitudCredito s WHERE s.fFechaCreacion = :fFechaCreacion"),
    @NamedQuery(name = "SolicitudCredito.findByFFechaModificacion", query = "SELECT s FROM SolicitudCredito s WHERE s.fFechaModificacion = :fFechaModificacion"),
    @NamedQuery(name = "SolicitudCredito.findByIFormaPago", query = "SELECT s FROM SolicitudCredito s WHERE s.iFormaPago = :iFormaPago"),
    @NamedQuery(name = "SolicitudCredito.findByINumPersonaAfiliar", query = "SELECT s FROM SolicitudCredito s WHERE s.iNumPersonaAfiliar = :iNumPersonaAfiliar")})
public class SolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_SOLICITUD_CREDITO", sequenceName = "SEC_SOLICITUD_CREDITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_SOLICITUD_CREDITO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "I_NUM_RADIC")
    private Long iNumRadic;

    @Column(name = "I_COD_CREDITO")
    private Long iCodCredito;

    @Column(name = "F_FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaSolicitud;

    @Column(name = "N_MONTO_SOLICITUD")
    private BigDecimal nMontoSolicitud;

    @Column(name = "PLAZO")
    private BigInteger plazo;

    @Column(name = "N_VALOR_CUOTA")
    private BigDecimal nValorCuota;

    @Column(name = "I_COD_PERIODO")
    private BigInteger iCodPeriodo;

    @Size(min = 1, max = 2)
    @Column(name = "C_AUTH_CENTRALES_RIESGO")
    private String cAuthCentralesRiesgo;

    @Size(min = 1, max = 2)
    @Column(name = "C_AUTH_DATOS_PERSONALES")
    private String cAuthDatosPersonales;

    @Size(min = 1, max = 2)
    @Column(name = "C_DECLARACION_ORIGEN_FONDOS")
    private String cDeclaracionOrigenFondos;

    @Size(min = 1, max = 2)
    @Column(name = "C_REQUIERE_CODEUDOR")
    private String cRequiereCodeudor;

    @Column(name = "F_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaCreacion;

    @Column(name = "F_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaModificacion;
    
    @Column(name = "I_FORMA_PAGO")
    private Long iFormaPago;
            
    @Column(name = "I_NUM_PERSONA_AFILIAR")
    private Long iNumPersonaAfiliar;

    @OneToMany( mappedBy = "iSolicitudCredito")
    private List<InfoCodeudor> infoCodeudor;

    @OneToMany( mappedBy = "iSolicitudCredito")
    private List<HistoriaSolicitudCredito> historiaSolicitudCreditoList;

    @OneToMany( mappedBy = "iSolicitudCredito")
    private List<DocumentoSolicitudCredito> documentoSolicitudCreditoList;

    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona iPersona;

    @JoinColumn(name = "I_ESTADO_SOLICITUD", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEstadoSolicitudCredito iEstadoSolicitud;

    @JoinColumn(name = "I_USUARIO_MODIFICADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iUsuarioModificador;

    @JoinColumn(name = "I_USUARIO_CREADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuarioCreador;

    @JoinColumn(name = "I_TIPO_PRODUCTO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoProductoSolCredito iTipoProducto;

    @JoinColumn(name = "I_TIPO_CANAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoCanal iTipoCanal;
//
//    @OneToMany( mappedBy = "iSolicitudCredito", fetch = FetchType.EAGER)
//    private List<AceptCondSolCredito> aceptCondSolCreditoList;

    public SolicitudCredito() {
    }

    public SolicitudCredito(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public SolicitudCredito(Long iCodigo, Long iCodCredito, Date fFechaSolicitud, BigDecimal nMontoSolicitud, BigInteger plazo, BigDecimal nValorCuota, BigInteger iCodPeriodo, Date fFechaCreacion, Long iFormaPago, Long iNumPersonaAfiliar) {
        this.iCodigo = iCodigo;
        this.iCodCredito = iCodCredito;
        this.fFechaSolicitud = fFechaSolicitud;
        this.nMontoSolicitud = nMontoSolicitud;
        this.plazo = plazo;
        this.nValorCuota = nValorCuota;
        this.iCodPeriodo = iCodPeriodo;
        this.fFechaCreacion = fFechaCreacion;
        this.iFormaPago= iFormaPago;
        this.iNumPersonaAfiliar= iNumPersonaAfiliar;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getINumRadic() {
        return iNumRadic;
    }

    public void setINumRadic(Long iNumRadic) {
        this.iNumRadic = iNumRadic;
    }

    public Long getICodCredito() {
        return iCodCredito;
    }

    public void setICodCredito(Long iCodCredito) {
        this.iCodCredito = iCodCredito;
    }

    public Date getFFechaSolicitud() {
        return fFechaSolicitud;
    }

    public void setFFechaSolicitud(Date fFechaSolicitud) {
        this.fFechaSolicitud = fFechaSolicitud;
    }

    public BigDecimal getNMontoSolicitud() {
        return nMontoSolicitud;
    }

    public void setNMontoSolicitud(BigDecimal nMontoSolicitud) {
        this.nMontoSolicitud = nMontoSolicitud;
    }

    public BigInteger getPlazo() {
        return plazo;
    }

    public void setPlazo(BigInteger plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getNValorCuota() {
        return nValorCuota;
    }

    public void setNValorCuota(BigDecimal nValorCuota) {
        this.nValorCuota = nValorCuota;
    }

    public BigInteger getICodPeriodo() {
        return iCodPeriodo;
    }

    public void setICodPeriodo(BigInteger iCodPeriodo) {
        this.iCodPeriodo = iCodPeriodo;
    }

    public String getCAuthCentralesRiesgo() {
        return cAuthCentralesRiesgo;
    }

    public void setCAuthCentralesRiesgo(String cAuthCentralesRiesgo) {
        this.cAuthCentralesRiesgo = cAuthCentralesRiesgo;
    }

    public String getCAuthDatosPersonales() {
        return cAuthDatosPersonales;
    }

    public void setCAuthDatosPersonales(String cAuthDatosPersonales) {
        this.cAuthDatosPersonales = cAuthDatosPersonales;
    }

    public String getCDeclaracionOrigenFondos() {
        return cDeclaracionOrigenFondos;
    }

    public void setCDeclaracionOrigenFondos(String cDeclaracionOrigenFondos) {
        this.cDeclaracionOrigenFondos = cDeclaracionOrigenFondos;
    }

    public String getCRequiereCodeudor() {
        return cRequiereCodeudor;
    }

    public void setCRequiereCodeudor(String cRequiereCodeudor) {
        this.cRequiereCodeudor = cRequiereCodeudor;
    }

    public Date getFFechaCreacion() {
        return fFechaCreacion;
    }

    public void setFFechaCreacion(Date fFechaCreacion) {
        this.fFechaCreacion = fFechaCreacion;
    }

    public Date getFFechaModificacion() {
        return fFechaModificacion;
    }

    public void setFFechaModificacion(Date fFechaModificacion) {
        this.fFechaModificacion = fFechaModificacion;
    }

    public Long getiFormaPago() {
        return iFormaPago;
    }

    public void setiFormaPago(Long iFormaPago) {
        this.iFormaPago = iFormaPago;
    }

    public Long getiNumPersonaAfiliar() {
        return iNumPersonaAfiliar;
    }

    public void setiNumPersonaAfiliar(Long iNumPersonaAfiliar) {
        this.iNumPersonaAfiliar = iNumPersonaAfiliar;
    }
    

    @XmlTransient
    public List<InfoCodeudor> getInfoCodeudor() {
        return infoCodeudor;
    }

    public void setInfoCodeudor(List<InfoCodeudor> infoCtaBancoList) {
        this.infoCodeudor = infoCtaBancoList;
    }

    @XmlTransient
    public List<HistoriaSolicitudCredito> getHistoriaSolicitudCreditoList() {
        return historiaSolicitudCreditoList;
    }

    public void setHistoriaSolicitudCreditoList(List<HistoriaSolicitudCredito> historiaSolicitudCreditoList) {
        this.historiaSolicitudCreditoList = historiaSolicitudCreditoList;
    }

    @XmlTransient
    public List<DocumentoSolicitudCredito> getDocumentoSolicitudCreditoList() {
        return documentoSolicitudCreditoList;
    }

    public void setDocumentoSolicitudCreditoList(List<DocumentoSolicitudCredito> documentoSolicitudCreditoList) {
        this.documentoSolicitudCreditoList = documentoSolicitudCreditoList;
    }

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
    }

    public TipoEstadoSolicitudCredito getIEstadoSolicitud() {
        return iEstadoSolicitud;
    }

    public void setIEstadoSolicitud(TipoEstadoSolicitudCredito iEstadoSolicitud) {
        this.iEstadoSolicitud = iEstadoSolicitud;
    }

    public Usuario getIUsuarioModificador() {
        return iUsuarioModificador;
    }

    public void setIUsuarioModificador(Usuario iUsuarioModificador) {
        this.iUsuarioModificador = iUsuarioModificador;
    }

    public Usuario getIUsuarioCreador() {
        return iUsuarioCreador;
    }

    public void setIUsuarioCreador(Usuario iUsuarioCreador) {
        this.iUsuarioCreador = iUsuarioCreador;
    }

    public TipoProductoSolCredito getiTipoProducto() {
        return iTipoProducto;
    }

    public void setiTipoProducto(TipoProductoSolCredito iTipoProducto) {
        this.iTipoProducto = iTipoProducto;
    }

    public TipoCanal getiTipoCanal() {
        return iTipoCanal;
    }

    public void setiTipoCanal(TipoCanal iTipoCanal) {
        this.iTipoCanal = iTipoCanal;
    }

//    @XmlTransient
//    public List<AceptCondSolCredito> getAceptCondSolCreditoList() {
//        return aceptCondSolCreditoList;
//    }
//
//    public void setAceptCondSolCreditoList(List<AceptCondSolCredito> aceptCondSolCreditoList) {
//        this.aceptCondSolCreditoList = aceptCondSolCreditoList;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iCodigo != null ? iCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCredito)) {
            return false;
        }
        SolicitudCredito other = (SolicitudCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitudCredito{" + "iCodigo=" + iCodigo + ", iNumRadic=" + iNumRadic + ", iCodCredito=" + iCodCredito + ", fFechaSolicitud=" + fFechaSolicitud + ", nMontoSolicitud=" + nMontoSolicitud + ", plazo=" + plazo + ", nValorCuota=" + nValorCuota + ", iCodPeriodo=" + iCodPeriodo + ", cAuthCentralesRiesgo=" + cAuthCentralesRiesgo + ", cAuthDatosPersonales=" + cAuthDatosPersonales + ", cDeclaracionOrigenFondos=" + cDeclaracionOrigenFondos + ", cRequiereCodeudor=" + cRequiereCodeudor + ", fFechaCreacion=" + fFechaCreacion + ", fFechaModificacion=" + fFechaModificacion + ", iFormaPago=" + iFormaPago + ", iNumPersonaAfiliar=" + iNumPersonaAfiliar + ", infoCodeudor=" + infoCodeudor + ", iPersona=" + iPersona + ", iEstadoSolicitud=" + iEstadoSolicitud + ", iUsuarioModificador=" + iUsuarioModificador + ", iUsuarioCreador=" + iUsuarioCreador + ", iTipoProducto=" + iTipoProducto + ", iTipoCanal=" + iTipoCanal + '}';
    }

    

}

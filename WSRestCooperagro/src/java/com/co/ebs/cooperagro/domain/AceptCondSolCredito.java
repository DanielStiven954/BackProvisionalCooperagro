/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "ACEPT_COND_SOL_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AceptCondSolCredito.findAll", query = "SELECT a FROM AceptCondSolCredito a"),
    @NamedQuery(name = "AceptCondSolCredito.findByICodigo", query = "SELECT a FROM AceptCondSolCredito a WHERE a.iCodigo = :iCodigo"),
    @NamedQuery(name = "AceptCondSolCredito.findByCAceptaCondiciones", query = "SELECT a FROM AceptCondSolCredito a WHERE a.cAceptaCondiciones = :cAceptaCondiciones"),
    @NamedQuery(name = "AceptCondSolCredito.findByCToken", query = "SELECT a FROM AceptCondSolCredito a WHERE a.cToken = :cToken"),
    @NamedQuery(name = "AceptCondSolCredito.findByCKeyToken", query = "SELECT a FROM AceptCondSolCredito a WHERE a.cKeyToken = :cKeyToken"),
    @NamedQuery(name = "AceptCondSolCredito.findByFFechaInicio", query = "SELECT a FROM AceptCondSolCredito a WHERE a.fFechaInicio = :fFechaInicio"),
    @NamedQuery(name = "AceptCondSolCredito.findByFFechaFin", query = "SELECT a FROM AceptCondSolCredito a WHERE a.fFechaFin = :fFechaFin"),
    @NamedQuery(name = "AceptCondSolCredito.findByCEstado", query = "SELECT a FROM AceptCondSolCredito a WHERE a.cEstado = :cEstado"),
    @NamedQuery(name = "AceptCondSolCredito.findByFFechaCreacion", query = "SELECT a FROM AceptCondSolCredito a WHERE a.fFechaCreacion = :fFechaCreacion"),
    @NamedQuery(name = "AceptCondSolCredito.findByFFechaModificacion", query = "SELECT a FROM AceptCondSolCredito a WHERE a.fFechaModificacion = :fFechaModificacion")})
public class AceptCondSolCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_ACEP_COND_SOL_CRED", sequenceName = "SEC_ACEP_COND_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ACEP_COND_SOL_CRED")
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    
    @Size(max = 2)
    @Column(name = "C_ACEPTA_CONDICIONES")
    private String cAceptaCondiciones;
    
    @Size(max = 1000)
    @Column(name = "C_TOKEN")
    private String cToken;
    
    @Size(max = 100)
    @Column(name = "C_KEY_TOKEN")
    private String cKeyToken;
    
    @Column(name = "F_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaInicio;
    
    @Column(name = "F_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaFin;
    
    @Basic(optional = false)
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @Basic(optional = false)
    @Column(name = "F_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaCreacion;
    
    @Column(name = "F_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaModificacion;
    
    @JoinColumn(name = "I_SOLICITUD_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private SolicitudCredito iSolicitudCredito;
    @JoinColumn(name = "I_USUARIO_MODIFICADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private Usuario iUsuarioModificador;
    @JoinColumn(name = "I_USUARIO_CREADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Usuario iUsuarioCreador;

    public AceptCondSolCredito() {
    }

    public AceptCondSolCredito(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public AceptCondSolCredito(BigDecimal iCodigo, String cEstado, Date fFechaCreacion) {
        this.iCodigo = iCodigo;
        this.cEstado = cEstado;
        this.fFechaCreacion = fFechaCreacion;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCAceptaCondiciones() {
        return cAceptaCondiciones;
    }

    public void setCAceptaCondiciones(String cAceptaCondiciones) {
        this.cAceptaCondiciones = cAceptaCondiciones;
    }

    public String getCToken() {
        return cToken;
    }

    public void setCToken(String cToken) {
        this.cToken = cToken;
    }

    public String getCKeyToken() {
        return cKeyToken;
    }

    public void setCKeyToken(String cKeyToken) {
        this.cKeyToken = cKeyToken;
    }

    public Date getFFechaInicio() {
        return fFechaInicio;
    }

    public void setFFechaInicio(Date fFechaInicio) {
        this.fFechaInicio = fFechaInicio;
    }

    public Date getFFechaFin() {
        return fFechaFin;
    }

    public void setFFechaFin(Date fFechaFin) {
        this.fFechaFin = fFechaFin;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
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

    public SolicitudCredito getISolicitudCredito() {
        return iSolicitudCredito;
    }

    public void setISolicitudCredito(SolicitudCredito iSolicitudCredito) {
        this.iSolicitudCredito = iSolicitudCredito;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iCodigo != null ? iCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AceptCondSolCredito)) {
            return false;
        }
        AceptCondSolCredito other = (AceptCondSolCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.coopechance.domain.AceptCondSolCredito[ iCodigo=" + iCodigo + " ]";
    }
    
}

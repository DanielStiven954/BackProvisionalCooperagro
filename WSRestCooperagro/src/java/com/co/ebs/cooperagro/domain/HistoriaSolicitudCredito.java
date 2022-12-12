/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.domain.Usuario;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Braya
 */
@Entity
@Table(name = "HISTORIA_SOLICITUD_CREDITO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaSolicitudCredito.findAll", query = "SELECT h FROM HistoriaSolicitudCredito h"),
    @NamedQuery(name = "HistoriaSolicitudCredito.findByICodigo", query = "SELECT h FROM HistoriaSolicitudCredito h WHERE h.iCodigo = :iCodigo"),
    @NamedQuery(name = "HistoriaSolicitudCredito.findByCObservacion", query = "SELECT h FROM HistoriaSolicitudCredito h WHERE h.cObservacion = :cObservacion"),
    @NamedQuery(name = "HistoriaSolicitudCredito.findByISolicitudCred", query = "SELECT h FROM HistoriaSolicitudCredito h WHERE h.iSolicitudCredito = :iSolicitudCredito"),
    @NamedQuery(name = "HistoriaSolicitudCredito.findByFFechaHistoria", query = "SELECT h FROM HistoriaSolicitudCredito h WHERE h.fFechaHistoria = :fFechaHistoria"),
    @NamedQuery(name = "HistoriaSolicitudCredito.findByFFechaCreacion", query = "SELECT h FROM HistoriaSolicitudCredito h WHERE h.fFechaCreacion = :fFechaCreacion")})
public class HistoriaSolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_HIST_SOLICITUD_CREDITO", sequenceName = "SEC_HIST_SOLICITUD_CREDITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_HIST_SOLICITUD_CREDITO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(max = 1000)
    @Column(name = "C_OBSERVACION")
    private String cObservacion;

    @Column(name = "F_FECHA_HISTORIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaHistoria;

    @Column(name = "F_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaCreacion;

    @JoinColumn(name = "I_SOLICITUD_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudCredito iSolicitudCredito;

    @JoinColumn(name = "I_ESTADO_SOLICITUD", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEstadoSolicitudCredito iEstadoSolicitud;

    @JoinColumn(name = "I_USUARIO_CREADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuarioCreador;

    public HistoriaSolicitudCredito() {
    }

    public HistoriaSolicitudCredito(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public HistoriaSolicitudCredito(Long iCodigo, Date fFechaHistoria, Date fFechaCreacion) {
        this.iCodigo = iCodigo;
        this.fFechaHistoria = fFechaHistoria;
        this.fFechaCreacion = fFechaCreacion;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCObservacion() {
        return cObservacion;
    }

    public void setCObservacion(String cObservacion) {
        this.cObservacion = cObservacion;
    }

    public Date getFFechaHistoria() {
        return fFechaHistoria;
    }

    public void setFFechaHistoria(Date fFechaHistoria) {
        this.fFechaHistoria = fFechaHistoria;
    }

    public Date getFFechaCreacion() {
        return fFechaCreacion;
    }

    public void setFFechaCreacion(Date fFechaCreacion) {
        this.fFechaCreacion = fFechaCreacion;
    }

    public SolicitudCredito getISolicitudCredito() {
        return iSolicitudCredito;
    }

    public void setISolicitudCredito(SolicitudCredito iSolicitudCredito) {
        this.iSolicitudCredito = iSolicitudCredito;
    }

    public TipoEstadoSolicitudCredito getIEstadoSolicitud() {
        return iEstadoSolicitud;
    }

    public void setIEstadoSolicitud(TipoEstadoSolicitudCredito iEstadoSolicitud) {
        this.iEstadoSolicitud = iEstadoSolicitud;
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
        if (!(object instanceof HistoriaSolicitudCredito)) {
            return false;
        }
        HistoriaSolicitudCredito other = (HistoriaSolicitudCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.wlosomec.domain.HistoriaSolicitudCredito[ iCodigo=" + iCodigo + " ]";
    }

}

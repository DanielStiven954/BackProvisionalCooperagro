/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

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
@Table(name = "DOCUMENTOS_SOLICITUD_CREDITO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoSolicitudCredito.findAll", query = "SELECT d FROM DocumentoSolicitudCredito d"),
    @NamedQuery(name = "DocumentoSolicitudCredito.findByICodigo", query = "SELECT d FROM DocumentoSolicitudCredito d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "DocumentoSolicitudCredito.findByISolicitudCredito", query = "SELECT d FROM DocumentoSolicitudCredito d WHERE d.iSolicitudCredito = :iSolicitudCredito"),
    @NamedQuery(name = "DocumentoSolicitudCredito.findByCObservacion", query = "SELECT d FROM DocumentoSolicitudCredito d WHERE d.cObservacion = :cObservacion"),
    @NamedQuery(name = "DocumentoSolicitudCredito.findByFechaEnvio", query = "SELECT d FROM DocumentoSolicitudCredito d WHERE d.fechaEnvio = :fechaEnvio"),
    @NamedQuery(name = "DocumentoSolicitudCredito.findByCRutaFtp", query = "SELECT d FROM DocumentoSolicitudCredito d WHERE d.cRutaFtp = :cRutaFtp"),
    @NamedQuery(name = "DocumentoSolicitudCredito.findByCNombreDocumento", query = "SELECT d FROM DocumentoSolicitudCredito d WHERE d.cNombreDocumento = :cNombreDocumento"),
    @NamedQuery(name = "DocumentoSolicitudCredito.findByFFechaCreacion", query = "SELECT d FROM DocumentoSolicitudCredito d WHERE d.fFechaCreacion = :fFechaCreacion")})
public class DocumentoSolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_DOC_SOL_CREDITO", sequenceName = "SEC_DOC_SOL_CREDITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DOC_SOL_CREDITO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 1000)
    @Column(name = "C_OBSERVACION")
    private String cObservacion;

    @Column(name = "FECHA_ENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    @Size(min = 1, max = 1000)
    @Column(name = "C_RUTA_FTP")
    private String cRutaFtp;

    @Size(min = 1, max = 500)
    @Column(name = "C_NOMBRE_DOCUMENTO")
    private String cNombreDocumento;

    @Column(name = "F_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaCreacion;

    @JoinColumn(name = "I_SOLICITUD_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudCredito iSolicitudCredito;

    @JoinColumn(name = "I_TIPO_REQ_SOL_CRED", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoRequisitoSolCred iTipoReqSolCred;

    @JoinColumn(name = "I_USUARIO_CREADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuarioCreador;

    public DocumentoSolicitudCredito() {
    }

    public DocumentoSolicitudCredito(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public DocumentoSolicitudCredito(Long iCodigo, String cObservacion, Date fechaEnvio, String cRutaFtp, String cNombreDocumento, Date fFechaCreacion) {
        this.iCodigo = iCodigo;
        this.cObservacion = cObservacion;
        this.fechaEnvio = fechaEnvio;
        this.cRutaFtp = cRutaFtp;
        this.cNombreDocumento = cNombreDocumento;
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

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getCRutaFtp() {
        return cRutaFtp;
    }

    public void setCRutaFtp(String cRutaFtp) {
        this.cRutaFtp = cRutaFtp;
    }

    public String getCNombreDocumento() {
        return cNombreDocumento;
    }

    public void setCNombreDocumento(String cNombreDocumento) {
        this.cNombreDocumento = cNombreDocumento;
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

    public TipoRequisitoSolCred getITipoRequisitoSolCred() {
        return iTipoReqSolCred;
    }

    public void setITipoRequisitoSolCred(TipoRequisitoSolCred iTipoReqSolCred) {
        this.iTipoReqSolCred = iTipoReqSolCred;
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
        if (!(object instanceof DocumentoSolicitudCredito)) {
            return false;
        }
        DocumentoSolicitudCredito other = (DocumentoSolicitudCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.wlosomec.domain.DocumentoSolicitudCredito[ iCodigo=" + iCodigo + " ]";
    }
}

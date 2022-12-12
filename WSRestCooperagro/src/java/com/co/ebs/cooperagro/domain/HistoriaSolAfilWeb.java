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
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "HISTORIA_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaSolAfilWeb.findAll", query = "SELECT h FROM HistoriaSolAfilWeb h")
    , @NamedQuery(name = "HistoriaSolAfilWeb.findByICodigo", query = "SELECT h FROM HistoriaSolAfilWeb h WHERE h.iCodigo = :iCodigo")
    , @NamedQuery(name = "HistoriaSolAfilWeb.findByFFechaRegistro", query = "SELECT h FROM HistoriaSolAfilWeb h WHERE h.fFechaRegistro = :fFechaRegistro")
    , @NamedQuery(name = "HistoriaSolAfilWeb.findByCObservacionRegistro", query = "SELECT h FROM HistoriaSolAfilWeb h WHERE h.cObservacionRegistro = :cObservacionRegistro")
    , @NamedQuery(name = "HistoriaSolAfilWeb.findByFFechaCambioEst", query = "SELECT h FROM HistoriaSolAfilWeb h WHERE h.fFechaCambioEst = :fFechaCambioEst")
    , @NamedQuery(name = "HistoriaSolAfilWeb.findByCObsCambioEst", query = "SELECT h FROM HistoriaSolAfilWeb h WHERE h.cObsCambioEst = :cObsCambioEst")})
public class HistoriaSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_HIS_SOL_AFIL_WEB", sequenceName = "SEQ_HIS_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HIS_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    
    
    @Size(min = 1, max = 2000)
    @Column(name = "C_OBSERVACION_REGISTRO")
    private String cObservacionRegistro;
    @Column(name = "F_FECHA_CAMBIO_EST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaCambioEst;
    @Size(max = 2000)
    @Column(name = "C_OBS_CAMBIO_EST")
    private String cObsCambioEst;
    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;
    @JoinColumn(name = "I_ESTADO_SOLICITUD", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEstadoSolAfilWeb iEstadoSolicitud;

    public HistoriaSolAfilWeb()
    {
    }

    public HistoriaSolAfilWeb(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public HistoriaSolAfilWeb(Long iCodigo, Date fFechaRegistro, String cObservacionRegistro)
    {
        this.iCodigo = iCodigo;
        this.fFechaRegistro = fFechaRegistro;
        this.cObservacionRegistro = cObservacionRegistro;
    }

    public Long getICodigo()
    {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public Date getFFechaRegistro()
    {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro)
    {
        this.fFechaRegistro = fFechaRegistro;
    }

    public String getCObservacionRegistro()
    {
        return cObservacionRegistro;
    }

    public void setCObservacionRegistro(String cObservacionRegistro)
    {
        this.cObservacionRegistro = cObservacionRegistro;
    }

    public Date getFFechaCambioEst()
    {
        return fFechaCambioEst;
    }

    public void setFFechaCambioEst(Date fFechaCambioEst)
    {
        this.fFechaCambioEst = fFechaCambioEst;
    }

    public String getCObsCambioEst()
    {
        return cObsCambioEst;
    }

    public void setCObsCambioEst(String cObsCambioEst)
    {
        this.cObsCambioEst = cObsCambioEst;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb()
    {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb)
    {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
    }

    public TipoEstadoSolAfilWeb getIEstadoSolicitud()
    {
        return iEstadoSolicitud;
    }

    public void setIEstadoSolicitud(TipoEstadoSolAfilWeb iEstadoSolicitud)
    {
        this.iEstadoSolicitud = iEstadoSolicitud;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (iCodigo != null ? iCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaSolAfilWeb)) {
            return false;
        }
        HistoriaSolAfilWeb other = (HistoriaSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.co.ebs.cooperagro.domain.HistoriaSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }
    
}

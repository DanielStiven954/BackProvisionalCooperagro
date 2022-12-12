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
@Table(name = "REV_SEG_SARLAFT_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RevSegSarlaftSolAfilWeb.findAll", query = "SELECT r FROM RevSegSarlaftSolAfilWeb r")
    , @NamedQuery(name = "RevSegSarlaftSolAfilWeb.findByICodigo", query = "SELECT r FROM RevSegSarlaftSolAfilWeb r WHERE r.iCodigo = :iCodigo")
    , @NamedQuery(name = "RevSegSarlaftSolAfilWeb.findByFFechaConsulta", query = "SELECT r FROM RevSegSarlaftSolAfilWeb r WHERE r.fFechaConsulta = :fFechaConsulta")
    , @NamedQuery(name = "RevSegSarlaftSolAfilWeb.findByCResultReporte", query = "SELECT r FROM RevSegSarlaftSolAfilWeb r WHERE r.cResultReporte = :cResultReporte")
    , @NamedQuery(name = "RevSegSarlaftSolAfilWeb.findByINumConsulta", query = "SELECT r FROM RevSegSarlaftSolAfilWeb r WHERE r.iNumConsulta = :iNumConsulta")
    , @NamedQuery(name = "RevSegSarlaftSolAfilWeb.findByCObservacion", query = "SELECT r FROM RevSegSarlaftSolAfilWeb r WHERE r.cObservacion = :cObservacion")})
public class RevSegSarlaftSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_REV_SEG_SOL_AFIL_WEB", sequenceName = "SEQ_REV_SEG_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REV_SEG_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    
    @Column(name = "F_FECHA_CONSULTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaConsulta;
    
    
    @Size(min = 1, max = 2)
    @Column(name = "C_RESULT_REPORTE")
    private String cResultReporte;
    
    
    @Column(name = "I_NUM_CONSULTA")
    private Long iNumConsulta;
    
    
    @Size(min = 1, max = 500)
    @Column(name = "C_OBSERVACION")
    private String cObservacion;
    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    public RevSegSarlaftSolAfilWeb()
    {
    }

    public RevSegSarlaftSolAfilWeb(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public RevSegSarlaftSolAfilWeb(Long iCodigo, Date fFechaConsulta, String cResultReporte, Long iNumConsulta, String cObservacion)
    {
        this.iCodigo = iCodigo;
        this.fFechaConsulta = fFechaConsulta;
        this.cResultReporte = cResultReporte;
        this.iNumConsulta = iNumConsulta;
        this.cObservacion = cObservacion;
    }

    public Long getICodigo()
    {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public Date getFFechaConsulta()
    {
        return fFechaConsulta;
    }

    public void setFFechaConsulta(Date fFechaConsulta)
    {
        this.fFechaConsulta = fFechaConsulta;
    }

    public String getCResultReporte()
    {
        return cResultReporte;
    }

    public void setCResultReporte(String cResultReporte)
    {
        this.cResultReporte = cResultReporte;
    }

    public Long getINumConsulta()
    {
        return iNumConsulta;
    }

    public void setINumConsulta(Long iNumConsulta)
    {
        this.iNumConsulta = iNumConsulta;
    }

    public String getCObservacion()
    {
        return cObservacion;
    }

    public void setCObservacion(String cObservacion)
    {
        this.cObservacion = cObservacion;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb()
    {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb)
    {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
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
        if (!(object instanceof RevSegSarlaftSolAfilWeb)) {
            return false;
        }
        RevSegSarlaftSolAfilWeb other = (RevSegSarlaftSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.co.ebs.cooperagro.domain.RevSegSarlaftSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }

}

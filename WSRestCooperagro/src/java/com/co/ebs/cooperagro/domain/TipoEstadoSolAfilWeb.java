/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "TIPO_ESTADO_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstadoSolAfilWeb.findAll", query = "SELECT t FROM TipoEstadoSolAfilWeb t")
    , @NamedQuery(name = "TipoEstadoSolAfilWeb.findByICodigo", query = "SELECT t FROM TipoEstadoSolAfilWeb t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoEstadoSolAfilWeb.findByCAbreviatura", query = "SELECT t FROM TipoEstadoSolAfilWeb t WHERE t.cAbreviatura = :cAbreviatura")
    , @NamedQuery(name = "TipoEstadoSolAfilWeb.findByCNombre", query = "SELECT t FROM TipoEstadoSolAfilWeb t WHERE t.cNombre = :cNombre")
    , @NamedQuery(name = "TipoEstadoSolAfilWeb.findByCDescripcion", query = "SELECT t FROM TipoEstadoSolAfilWeb t WHERE t.cDescripcion = :cDescripcion")})
public class TipoEstadoSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_TIPO_ESTADO_SOL_AFIL_WEB", sequenceName = "SEQ_TIPO_ESTADO_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_ESTADO_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    
    @Size(min = 1, max = 10)
    @Column(name = "C_ABREVIATURA")
    private String cAbreviatura;
    
    
    @Size(min = 1, max = 40)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    
    
    @Size(min = 1, max = 100)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @OneToMany( mappedBy = "iEstadoSolicitud")
    private List<SolicitudAfiliacionWeb> solicitudAfiliacionWebList;
    
    @OneToMany( mappedBy = "iEstadoSolicitud")
    private List<HistoriaSolAfilWeb> historiaSolAfilWebList;

    public TipoEstadoSolAfilWeb()
    {
    }

    public TipoEstadoSolAfilWeb(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public TipoEstadoSolAfilWeb(Long iCodigo, String cAbreviatura, String cNombre, String cDescripcion)
    {
        this.iCodigo = iCodigo;
        this.cAbreviatura = cAbreviatura;
        this.cNombre = cNombre;
        this.cDescripcion = cDescripcion;
    }

    public Long getICodigo()
    {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public String getCAbreviatura()
    {
        return cAbreviatura;
    }

    public void setCAbreviatura(String cAbreviatura)
    {
        this.cAbreviatura = cAbreviatura;
    }

    public String getCNombre()
    {
        return cNombre;
    }

    public void setCNombre(String cNombre)
    {
        this.cNombre = cNombre;
    }

    public String getCDescripcion()
    {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion)
    {
        this.cDescripcion = cDescripcion;
    }

    @XmlTransient
    public List<SolicitudAfiliacionWeb> getSolicitudAfiliacionWebList()
    {
        return solicitudAfiliacionWebList;
    }

    public void setSolicitudAfiliacionWebList(List<SolicitudAfiliacionWeb> solicitudAfiliacionWebList)
    {
        this.solicitudAfiliacionWebList = solicitudAfiliacionWebList;
    }

    @XmlTransient
    public List<HistoriaSolAfilWeb> getHistoriaSolAfilWebList()
    {
        return historiaSolAfilWebList;
    }

    public void setHistoriaSolAfilWebList(List<HistoriaSolAfilWeb> historiaSolAfilWebList)
    {
        this.historiaSolAfilWebList = historiaSolAfilWebList;
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
        if (!(object instanceof TipoEstadoSolAfilWeb)) {
            return false;
        }
        TipoEstadoSolAfilWeb other = (TipoEstadoSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }
    
}

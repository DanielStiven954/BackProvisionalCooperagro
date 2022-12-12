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
@Table(name = "TIPO_REQUISITO_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRequisitoSolAfilWeb.findAll", query = "SELECT t FROM TipoRequisitoSolAfilWeb t")
    , @NamedQuery(name = "TipoRequisitoSolAfilWeb.findByICodigo", query = "SELECT t FROM TipoRequisitoSolAfilWeb t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoRequisitoSolAfilWeb.findByCNombreRequisito", query = "SELECT t FROM TipoRequisitoSolAfilWeb t WHERE t.cNombreRequisito = :cNombreRequisito")
    , @NamedQuery(name = "TipoRequisitoSolAfilWeb.findByCDescripcion", query = "SELECT t FROM TipoRequisitoSolAfilWeb t WHERE t.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "TipoRequisitoSolAfilWeb.findByCEstado", query = "SELECT t FROM TipoRequisitoSolAfilWeb t WHERE t.cEstado = :cEstado")})
public class TipoRequisitoSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_TIPO_REQ_SOL_AFIL_WEB", sequenceName = "SEQ_TIPO_REQ_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_REQ_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    
    @Size(min = 1, max = 100)
    @Column(name = "C_NOMBRE_REQUISITO")
    private String cNombreRequisito;
    
    @Size(min = 1, max = 100)
    @Column(name = "C_ESTRUCTURA")
    private String cEstructura;
    
    
    @Size(min = 1, max = 200)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    
    
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @OneToMany( mappedBy = "iTipoRequisito")
    private List<DocumentoSolAfilWeb> documentosSolAfilWebList;

    public TipoRequisitoSolAfilWeb()
    {
    }

    public TipoRequisitoSolAfilWeb(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public TipoRequisitoSolAfilWeb(Long iCodigo, String cNombreRequisito, String cDescripcion, String cEstado)
    {
        this.iCodigo = iCodigo;
        this.cNombreRequisito = cNombreRequisito;
        this.cDescripcion = cDescripcion;
        this.cEstado = cEstado;
    }

    public Long getICodigo()
    {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public String getCNombreRequisito()
    {
        return cNombreRequisito;
    }

    public void setCNombreRequisito(String cNombreRequisito)
    {
        this.cNombreRequisito = cNombreRequisito;
    }

    public String getCDescripcion()
    {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion)
    {
        this.cDescripcion = cDescripcion;
    }

    public String getCEstado()
    {
        return cEstado;
    }

    public void setCEstado(String cEstado)
    {
        this.cEstado = cEstado;
    }

    public String getCEstructura() {
        return cEstructura;
    }

    public void setCEstructura(String cEstructura) {
        this.cEstructura = cEstructura;
    }
    
    @XmlTransient
    public List<DocumentoSolAfilWeb> getDocumentosSolAfilWebList()
    {
        return documentosSolAfilWebList;
    }

    public void setDocumentosSolAfilWebList(List<DocumentoSolAfilWeb> documentosSolAfilWebList)
    {
        this.documentosSolAfilWebList = documentosSolAfilWebList;
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
        if (!(object instanceof TipoRequisitoSolAfilWeb)) {
            return false;
        }
        TipoRequisitoSolAfilWeb other = (TipoRequisitoSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.co.ebs.cooperagro.domain.TipoRequisitoSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }
    
}

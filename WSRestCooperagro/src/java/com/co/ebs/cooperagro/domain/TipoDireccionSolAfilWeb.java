/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darkm
 */
@Entity
@Table(name = "TIPO_DIRECCION_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDireccionSolAfilWeb.findAll", query = "SELECT t FROM TipoDireccionSolAfilWeb t")
    , @NamedQuery(name = "TipoDireccionSolAfilWeb.findByICodigo", query = "SELECT t FROM TipoDireccionSolAfilWeb t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoDireccionSolAfilWeb.findByCDescripcion", query = "SELECT t FROM TipoDireccionSolAfilWeb t WHERE t.cDescripcion = :cDescripcion")})
public class TipoDireccionSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    public TipoDireccionSolAfilWeb() {
    }

    public TipoDireccionSolAfilWeb(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoDireccionSolAfilWeb(BigDecimal iCodigo, String cDescripcion) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
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
        if (!(object instanceof TipoDireccionSolAfilWeb)) {
            return false;
        }
        TipoDireccionSolAfilWeb other = (TipoDireccionSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.coopechance.domain.TipoDireccionSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }
    
}

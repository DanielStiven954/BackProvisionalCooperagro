/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
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
@Table(name = "COMP_DIRECCION_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompDireccionSolAfilWeb.findAll", query = "SELECT c FROM CompDireccionSolAfilWeb c order by c.cDescripcion asc")
    , @NamedQuery(name = "CompDireccionSolAfilWeb.findByICodigo", query = "SELECT c FROM CompDireccionSolAfilWeb c WHERE c.iCodigo = :iCodigo")
    , @NamedQuery(name = "CompDireccionSolAfilWeb.findByCDescripcion", query = "SELECT c FROM CompDireccionSolAfilWeb c WHERE c.cDescripcion = :cDescripcion")})
public class CompDireccionSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Size(min = 1, max = 100)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    public CompDireccionSolAfilWeb() {
    }

    public CompDireccionSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public CompDireccionSolAfilWeb(Long iCodigo, String cDescripcion) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
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
        if (!(object instanceof CompDireccionSolAfilWeb)) {
            return false;
        }
        CompDireccionSolAfilWeb other = (CompDireccionSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.coopechance.domain.CompDireccionSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }
    
}

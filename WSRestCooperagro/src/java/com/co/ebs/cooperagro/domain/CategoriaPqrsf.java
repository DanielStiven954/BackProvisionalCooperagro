/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "CATEGORIA_PQRSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaPqrsf.findAll", query = "SELECT c FROM CategoriaPqrsf c"),
    @NamedQuery(name = "CategoriaPqrsf.findByICodigo", query = "SELECT c FROM CategoriaPqrsf c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "CategoriaPqrsf.findByCNombre", query = "SELECT c FROM CategoriaPqrsf c WHERE c.cNombre = :cNombre"),
    @NamedQuery(name = "CategoriaPqrsf.findByCEstado", query = "SELECT c FROM CategoriaPqrsf c WHERE c.cEstado = :cEstado")})
public class CategoriaPqrsf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCategoria", fetch = FetchType.EAGER)
    private List<SubCategoriaPqrsf> subCategoriaPqrsfList;

    public CategoriaPqrsf() {
    }

    public CategoriaPqrsf(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public CategoriaPqrsf(Long iCodigo, String cNombre, String cEstado) {
        this.iCodigo = iCodigo;
        this.cNombre = cNombre;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public List<SubCategoriaPqrsf> getSubCategoriaPqrsfList() {
        return subCategoriaPqrsfList;
    }

    public void setSubCategoriaPqrsfList(List<SubCategoriaPqrsf> subCategoriaPqrsfList) {
        this.subCategoriaPqrsfList = subCategoriaPqrsfList;
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
        if (!(object instanceof CategoriaPqrsf)) {
            return false;
        }
        CategoriaPqrsf other = (CategoriaPqrsf) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.CategoriaPqrsf[ iCodigo=" + iCodigo + " ]";
    }
    
}

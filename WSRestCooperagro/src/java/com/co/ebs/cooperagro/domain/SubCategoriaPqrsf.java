/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "SUB_CATEGORIA_PQRSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCategoriaPqrsf.findAll", query = "SELECT s FROM SubCategoriaPqrsf s"),
    @NamedQuery(name = "SubCategoriaPqrsf.findByICodigo", query = "SELECT s FROM SubCategoriaPqrsf s WHERE s.iCodigo = :iCodigo"),
    @NamedQuery(name = "SubCategoriaPqrsf.findByCNombre", query = "SELECT s FROM SubCategoriaPqrsf s WHERE s.cNombre = :cNombre"),
    @NamedQuery(name = "SubCategoriaPqrsf.findByCEstado", query = "SELECT s FROM SubCategoriaPqrsf s WHERE s.cEstado = :cEstado")})
public class SubCategoriaPqrsf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_SUB_CAT_PQRSF", sequenceName = "SEC_SUB_CAT_PQRSF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_SUB_CAT_PQRSF")
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
    @JoinColumn(name = "I_CATEGORIA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CategoriaPqrsf iCategoria;
    @OneToMany(mappedBy = "iSubCategoria", fetch = FetchType.EAGER)
    private List<Pqrsf> pqrsfList;

    public SubCategoriaPqrsf() {
    }

    public SubCategoriaPqrsf(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public SubCategoriaPqrsf(Long iCodigo, String cNombre, String cEstado) {
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

    public CategoriaPqrsf getICategoria() {
        return iCategoria;
    }

    public void setICategoria(CategoriaPqrsf iCategoria) {
        this.iCategoria = iCategoria;
    }

    @XmlTransient
    public List<Pqrsf> getPqrsfList() {
        return pqrsfList;
    }

    public void setPqrsfList(List<Pqrsf> pqrsfList) {
        this.pqrsfList = pqrsfList;
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
        if (!(object instanceof SubCategoriaPqrsf)) {
            return false;
        }
        SubCategoriaPqrsf other = (SubCategoriaPqrsf) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.SubCategoriaPqrsf[ iCodigo=" + iCodigo + " ]";
    }
    
}

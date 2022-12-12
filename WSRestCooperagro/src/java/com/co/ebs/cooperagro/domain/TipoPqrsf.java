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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author YO
 */
@Entity
@Table(name = "TIPO_PQRSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPqrsf.findAll", query = "SELECT t FROM TipoPqrsf t"),
    @NamedQuery(name = "TipoPqrsf.findByICodigo", query = "SELECT t FROM TipoPqrsf t WHERE t.iCodigo = :iCodigo"),
    @NamedQuery(name = "TipoPqrsf.findByCDescripcion", query = "SELECT t FROM TipoPqrsf t WHERE t.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "TipoPqrsf.findByCEstado", query = "SELECT t FROM TipoPqrsf t WHERE t.cEstado = :cEstado")})
public class TipoPqrsf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_TIPO_PQRSF", sequenceName = "SEC_TIPO_PQRSF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_TIPO_PQRSF")
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Size(max = 1000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Size(max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @OneToMany( mappedBy = "iTipoPqrsf", fetch = FetchType.EAGER)
    private List<Pqrsf> pqrsfList;

    public TipoPqrsf() {
    }

    public TipoPqrsf(Long iCodigo) {
        this.iCodigo = iCodigo;
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

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
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
        if (!(object instanceof TipoPqrsf)) {
            return false;
        }
        TipoPqrsf other = (TipoPqrsf) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.TipoPqrsf[ iCodigo=" + iCodigo + " ]";
    }
    
}

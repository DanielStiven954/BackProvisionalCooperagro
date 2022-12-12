/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Brayan F Silva R
 */
@Entity
@Table(name = "CW_TIPO_ACCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CwTipoAcceso.findAll", query = "SELECT c FROM CwTipoAcceso c")
    , @NamedQuery(name = "CwTipoAcceso.findByICodigo", query = "SELECT c FROM CwTipoAcceso c WHERE c.iCodigo = :iCodigo")
    , @NamedQuery(name = "CwTipoAcceso.findByCDescripcion", query = "SELECT c FROM CwTipoAcceso c WHERE c.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "CwTipoAcceso.findByCEstado", query = "SELECT c FROM CwTipoAcceso c WHERE c.cEstado = :cEstado")})
public class CwTipoAcceso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_CW_TIPO_ACCESO", sequenceName = "SEC_CW_TIPO_ACCESO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CW_TIPO_ACCESO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 100)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    @OneToMany( mappedBy = "iTipoAcceso")
    private Collection<AccesoUsuario> accesoUsuarioCollection;

    public CwTipoAcceso() {
    }

    public CwTipoAcceso(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public CwTipoAcceso(Long iCodigo, String cDescripcion, String cEstado) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cEstado = cEstado;
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
    public Collection<AccesoUsuario> getAccesoUsuarioCollection() {
        return accesoUsuarioCollection;
    }

    public void setAccesoUsuarioCollection(Collection<AccesoUsuario> accesoUsuarioCollection) {
        this.accesoUsuarioCollection = accesoUsuarioCollection;
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
        if (!(object instanceof CwTipoAcceso)) {
            return false;
        }
        CwTipoAcceso other = (CwTipoAcceso) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.CwTipoAcceso[ iCodigo=" + iCodigo + " ]";
    }

}

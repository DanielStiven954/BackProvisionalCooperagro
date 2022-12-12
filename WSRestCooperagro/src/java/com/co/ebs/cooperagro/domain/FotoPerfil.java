/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andrés Sierra
 */
@Entity
@Table(name = "FOTO_PERFIL")
@NamedQueries({
    @NamedQuery(name = "FotoPerfil.findAll", query = "SELECT f FROM FotoPerfil f"),
    @NamedQuery(name = "FotoPerfil.findByICodigo", query = "SELECT f FROM FotoPerfil f WHERE f.iCodigo = :iCodigo"),
    @NamedQuery(name = "FotoPerfil.findByCNombre", query = "SELECT f FROM FotoPerfil f WHERE f.cNombre = :cNombre"),
    @NamedQuery(name = "FotoPerfil.findByCTipo", query = "SELECT f FROM FotoPerfil f WHERE f.cTipo = :cTipo"),
    @NamedQuery(name = "FotoPerfil.findByITamanio", query = "SELECT f FROM FotoPerfil f WHERE f.iTamanio = :iTamanio"),
    @NamedQuery(name = "FotoPerfil.findByFSubida", query = "SELECT f FROM FotoPerfil f WHERE f.fSubida = :fSubida"),
    @NamedQuery(name = "FotoPerfil.findByCEstado", query = "SELECT f FROM FotoPerfil f WHERE f.cEstado = :cEstado")})
public class FotoPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_FTOPERFIL", sequenceName = "SEC_FTOPERFIL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_FTOPERFIL")
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private long iCodigo;
    @Basic(optional = false)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Basic(optional = false)
    @Column(name = "C_TIPO")
    private String cTipo;
    @Basic(optional = false)
    @Column(name = "I_TAMANIO")
    private long iTamanio;
    @Basic(optional = false)
    @Column(name = "F_SUBIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fSubida;
    @Lob
    @Column(name = "B_IMGCLOB")
    private String bImgclob;
    @Basic(optional = false)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @OneToOne(optional = false)
    private Usuario iUsuario;

    public FotoPerfil() {
    }

    public FotoPerfil(long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public FotoPerfil(long iCodigo, String cNombre, String cTipo, long iTamanio, Date fSubida, String cEstado) {
        this.iCodigo = iCodigo;
        this.cNombre = cNombre;
        this.cTipo = cTipo;
        this.iTamanio = iTamanio;
        this.fSubida = fSubida;
        this.cEstado = cEstado;
    }

    public long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getCTipo() {
        return cTipo;
    }

    public void setCTipo(String cTipo) {
        this.cTipo = cTipo;
    }

    public long getITamanio() {
        return iTamanio;
    }

    public void setITamanio(long iTamanio) {
        this.iTamanio = iTamanio;
    }

    public Date getFSubida() {
        return fSubida;
    }

    public void setFSubida(Date fSubida) {
        this.fSubida = fSubida;
    }

    public String getBImgclob() {
        return bImgclob;
    }

    public void setBImgclob(String bImgclob) {
        this.bImgclob = bImgclob;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public Usuario getIUsuario() {
        return iUsuario;
    }

    public void setIUsuario(Usuario iUsuario) {
        this.iUsuario = iUsuario;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotoPerfil)) {
            return false;
        }
        FotoPerfil other = (FotoPerfil) object;
        if (this.iCodigo != other.iCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.FotoPerfil[ iCodigo=" + iCodigo + " ]";
    }
    
}
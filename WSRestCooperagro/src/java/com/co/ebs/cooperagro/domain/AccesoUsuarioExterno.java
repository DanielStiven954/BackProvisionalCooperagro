/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ETHOS-DEV02
 */
@Entity
@Table(name = "ACCESO_USUARIO_EXTERNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccesoUsuarioExterno.findAll", query = "SELECT a FROM AccesoUsuarioExterno a")
    , @NamedQuery(name = "AccesoUsuarioExterno.findByICodigo", query = "SELECT a FROM AccesoUsuarioExterno a WHERE a.iCodigo = :iCodigo")
    , @NamedQuery(name = "AccesoUsuarioExterno.findByITipoIdent", query = "SELECT a FROM AccesoUsuarioExterno a WHERE a.iTipoIdent = :iTipoIdent")
    , @NamedQuery(name = "AccesoUsuarioExterno.findByCIdentificacion", query = "SELECT a FROM AccesoUsuarioExterno a WHERE a.cIdentificacion = :cIdentificacion")
    , @NamedQuery(name = "AccesoUsuarioExterno.findByFAcceso", query = "SELECT a FROM AccesoUsuarioExterno a WHERE a.fAcceso = :fAcceso")
    , @NamedQuery(name = "AccesoUsuarioExterno.findByCEquipo", query = "SELECT a FROM AccesoUsuarioExterno a WHERE a.cEquipo = :cEquipo")
    , @NamedQuery(name = "AccesoUsuarioExterno.findByCEstado", query = "SELECT a FROM AccesoUsuarioExterno a WHERE a.cEstado = :cEstado")})
public class AccesoUsuarioExterno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_ACCESO_USUARIO_EXT", sequenceName = "SEC_ACCESO_USUARIO_EXT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ACCESO_USUARIO_EXT")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
   
    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;

    @Size(min = 1, max = 200)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;

    @Column(name = "F_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fAcceso;

    @Size(max = 200)
    @Column(name = "C_EQUIPO")
    private String cEquipo;
    
    @JoinColumn(name = "I_TIPO_CANAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoCanal iTipoCanal;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    public AccesoUsuarioExterno() {
    }

    public AccesoUsuarioExterno(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public AccesoUsuarioExterno(Long iCodigo, BigInteger iTipoIdent, String cIdentificacion, Date fAcceso, String cEstado) {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.fAcceso = fAcceso;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }


    public BigInteger getITipoIdent() {
        return iTipoIdent;
    }

    public void setITipoIdent(BigInteger iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }


    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public Date getFAcceso() {
        return fAcceso;
    }

    public void setFAcceso(Date fAcceso) {
        this.fAcceso = fAcceso;
    }

    public String getCEquipo() {
        return cEquipo;
    }

    public void setCEquipo(String cEquipo) {
        this.cEquipo = cEquipo;
    }

    public String getCEstado() {
        return cEstado;
    }
    
     public TipoCanal getITipoCanal() {
        return iTipoCanal;
    }

    public void setITipoCanal(TipoCanal iTipoCanal) {
        this.iTipoCanal = iTipoCanal;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
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
        if (!(object instanceof AccesoUsuarioExterno)) {
            return false;
        }
        AccesoUsuarioExterno other = (AccesoUsuarioExterno) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.AccesoUsuarioExterno[ iCodigo=" + iCodigo + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brayan F Silva R
 */
@Entity
@Table(name = "CLAVE_ACCESO_USUARIO_EXTERNO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaveAccesoUsuarioExterno.findAll", query = "SELECT c FROM ClaveAccesoUsuarioExterno c")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByICodigo", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.iCodigo = :iCodigo")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByITipoIdent", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.iTipoIdent = :iTipoIdent")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByCIdentificacion", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.cIdentificacion = :cIdentificacion")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByCClave", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.cClave = :cClave")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByCLlaveSeguridad", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.cLlaveSeguridad = :cLlaveSeguridad")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByFAcceso", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.fAcceso = :fAcceso")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByCEstado", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.cEstado = :cEstado")
    , @NamedQuery(name = "ClaveAccesoUsuarioExterno.findByITipoIdentAndIdentEstado", query = "SELECT c FROM ClaveAccesoUsuarioExterno c WHERE c.cIdentificacion = :cIdentificacion AND c.iTipoIdent = :iTipoIdent AND c.cEstado = :cEstado")}
)
public class ClaveAccesoUsuarioExterno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_CLAVE_ACCESO_USUARIO_EXT", sequenceName = "SEC_CLAVE_ACCESO_USUARIO_EXT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CLAVE_ACCESO_USUARIO_EXT")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;

    @Size(min = 1, max = 200)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;

    @Size(min = 1, max = 4000)
    @Column(name = "C_CLAVE")
    private String cClave;

    @Size(min = 1, max = 100)
    @Column(name = "C_LLAVE_SEGURIDAD")
    private String cLlaveSeguridad;

    @Column(name = "F_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fAcceso;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    public ClaveAccesoUsuarioExterno() {
    }

    public ClaveAccesoUsuarioExterno(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ClaveAccesoUsuarioExterno(Long iCodigo, BigInteger iTipoIdent, String cIdentificacion, String cClave, String cLlaveSeguridad, Date fAcceso, String cEstado) {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.cClave = cClave;
        this.cLlaveSeguridad = cLlaveSeguridad;
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

    public String getCClave() {
        return cClave;
    }

    public void setCClave(String cClave) {
        this.cClave = cClave;
    }

    public String getCLlaveSeguridad() {
        return cLlaveSeguridad;
    }

    public void setCLlaveSeguridad(String cLlaveSeguridad) {
        this.cLlaveSeguridad = cLlaveSeguridad;
    }

    public Date getFAcceso() {
        return fAcceso;
    }

    public void setFAcceso(Date fAcceso) {
        this.fAcceso = fAcceso;
    }

    public String getCEstado() {
        return cEstado;
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
        if (!(object instanceof ClaveAccesoUsuarioExterno)) {
            return false;
        }
        ClaveAccesoUsuarioExterno other = (ClaveAccesoUsuarioExterno) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.ClaveAccesoUsuarioExterno[ iCodigo=" + iCodigo + " ]";
    }
}

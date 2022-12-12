/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SESSION_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SessionUsuario.findAll", query = "SELECT s FROM SessionUsuario s")
    , @NamedQuery(name = "SessionUsuario.findByICodigo", query = "SELECT s FROM SessionUsuario s WHERE s.iCodigo = :iCodigo")
    , @NamedQuery(name = "SessionUsuario.findByCIp", query = "SELECT s FROM SessionUsuario s WHERE s.cIp = :cIp")
    , @NamedQuery(name = "SessionUsuario.findByCHost", query = "SELECT s FROM SessionUsuario s WHERE s.cHost = :cHost")
    , @NamedQuery(name = "SessionUsuario.findByCNavegador", query = "SELECT s FROM SessionUsuario s WHERE s.cNavegador = :cNavegador")
    , @NamedQuery(name = "SessionUsuario.findByFConexion", query = "SELECT s FROM SessionUsuario s WHERE s.fConexion = :fConexion")
    , @NamedQuery(name = "SessionUsuario.findByCEstado", query = "SELECT s FROM SessionUsuario s WHERE s.cEstado = :cEstado")})
public class SessionUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_SESSION_USUARIO", sequenceName = "SEC_SESSION_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_SESSION_USUARIO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Size(min = 1, max = 100)
    @Column(name = "C_IP")
    private String cIp;
  
    @Size(min = 1, max = 400)
    @Column(name = "C_HOST")
    private String cHost;

    @Size(min = 1, max = 400)
    @Column(name = "C_NAVEGADOR")
    private String cNavegador;
    
    @Column(name = "F_CONEXION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fConexion;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @JoinColumn(name = "I_TIPO_CANAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoCanal iTipoCanal;
    
    
    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuario;

    public SessionUsuario() {
    }

    public SessionUsuario(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public SessionUsuario(Long iCodigo, String cIp, String cHost, String cNavegador, Date fConexion, String cEstado) {
        this.iCodigo = iCodigo;
        this.cIp = cIp;
        this.cHost = cHost;
        this.cNavegador = cNavegador;
        this.fConexion = fConexion;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCIp() {
        return cIp;
    }

    public void setCIp(String cIp) {
        this.cIp = cIp;
    }

    public String getCHost() {
        return cHost;
    }

    public void setCHost(String cHost) {
        this.cHost = cHost;
    }

    public String getCNavegador() {
        return cNavegador;
    }

    public void setCNavegador(String cNavegador) {
        this.cNavegador = cNavegador;
    }

    public Date getFConexion() {
        return fConexion;
    }

    public void setFConexion(Date fConexion) {
        this.fConexion = fConexion;
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
    
    public TipoCanal getITipoCanal() {
        return iTipoCanal;
    }

    public void setITipoCanal(TipoCanal iTipoCanal) {
        this.iTipoCanal = iTipoCanal;
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
        if (!(object instanceof SessionUsuario)) {
            return false;
        }
        SessionUsuario other = (SessionUsuario) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.SessionUsuario[ iCodigo=" + iCodigo + " ]";
    }

}

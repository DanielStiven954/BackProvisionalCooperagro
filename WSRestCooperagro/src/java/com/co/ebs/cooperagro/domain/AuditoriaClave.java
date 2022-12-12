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
@Table(name = "AUDITORIA_CLAVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaClave.findAll", query = "SELECT a FROM AuditoriaClave a")
    , @NamedQuery(name = "AuditoriaClave.findByICodigo", query = "SELECT a FROM AuditoriaClave a WHERE a.iCodigo = :iCodigo")
    , @NamedQuery(name = "AuditoriaClave.findByCClave", query = "SELECT a FROM AuditoriaClave a WHERE a.cClave = :cClave")
    , @NamedQuery(name = "AuditoriaClave.findByFFecSistema", query = "SELECT a FROM AuditoriaClave a WHERE a.fFecSistema = :fFecSistema")
    , @NamedQuery(name = "AuditoriaClave.findByCEstado", query = "SELECT a FROM AuditoriaClave a WHERE a.cEstado = :cEstado")})
public class AuditoriaClave implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_AUDITORIA_CLAVE", sequenceName = "SEC_AUDITORIA_CLAVE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_AUDITORIA_CLAVE")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Size(min = 1, max = 550)
    @Column(name = "C_CLAVE")
    private String cClave;
    
    @Column(name = "F_FEC_SISTEMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecSistema;
    
    @Size(max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @JoinColumn(name = "I_TRANSACCION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Transaccion iTransaccion;
    
    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuario;

    public AuditoriaClave() {
    }

    public AuditoriaClave(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public AuditoriaClave(Long iCodigo, String cClave, Date fFecSistema) {
        this.iCodigo = iCodigo;
        this.cClave = cClave;
        this.fFecSistema = fFecSistema;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCClave() {
        return cClave;
    }

    public void setCClave(String cClave) {
        this.cClave = cClave;
    }

    public Date getFFecSistema() {
        return fFecSistema;
    }

    public void setFFecSistema(Date fFecSistema) {
        this.fFecSistema = fFecSistema;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public Transaccion getITransaccion() {
        return iTransaccion;
    }

    public void setITransaccion(Transaccion iTransaccion) {
        this.iTransaccion = iTransaccion;
    }

    public Usuario getIUsuario() {
        return iUsuario;
    }

    public void setIUsuario(Usuario iUsuario) {
        this.iUsuario = iUsuario;
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
        if (!(object instanceof AuditoriaClave)) {
            return false;
        }
        AuditoriaClave other = (AuditoriaClave) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.AuditoriaClave[ iCodigo=" + iCodigo + " ]";
    }

}

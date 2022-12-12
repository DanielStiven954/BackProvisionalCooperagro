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

@Entity
@Table(name = "GESTION_PQRSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionPqrsf.findAll", query = "SELECT g FROM GestionPqrsf g"),
    @NamedQuery(name = "GestionPqrsf.findByICodigo", query = "SELECT g FROM GestionPqrsf g WHERE g.iCodigo = :iCodigo"),
    @NamedQuery(name = "GestionPqrsf.findByCMsjRta", query = "SELECT g FROM GestionPqrsf g WHERE g.cMsjRta = :cMsjRta"),
    @NamedQuery(name = "GestionPqrsf.findByFFechaRegistro", query = "SELECT g FROM GestionPqrsf g WHERE g.fFechaRegistro = :fFechaRegistro"),
    @NamedQuery(name = "GestionPqrsf.findByCIp", query = "SELECT g FROM GestionPqrsf g WHERE g.cIp = :cIp"),
    @NamedQuery(name = "GestionPqrsf.findByCNavegador", query = "SELECT g FROM GestionPqrsf g WHERE g.cNavegador = :cNavegador")})
public class GestionPqrsf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_GESTION_PQRSF", sequenceName = "SEC_GESTION_PQRSF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_GESTION_PQRSF")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Size(max = 4000)
    @Column(name = "C_MSJ_RTA")
    private String cMsjRta;
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    @Size(max = 1000)
    @Column(name = "C_IP")
    private String cIp;
    @Size(max = 100)
    @Column(name = "C_NAVEGADOR")
    private String cNavegador;
    @JoinColumn(name = "I_PQRSF", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pqrsf iPqrsf;
    @JoinColumn(name = "I_USUARIO_CREADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuarioCreador;

    public GestionPqrsf() {
    }

    public GestionPqrsf(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCMsjRta() {
        return cMsjRta;
    }

    public void setCMsjRta(String cMsjRta) {
        this.cMsjRta = cMsjRta;
    }

    public Date getFFechaRegistro() {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro) {
        this.fFechaRegistro = fFechaRegistro;
    }

    public String getCIp() {
        return cIp;
    }

    public void setCIp(String cIp) {
        this.cIp = cIp;
    }

    public String getCNavegador() {
        return cNavegador;
    }

    public void setCNavegador(String cNavegador) {
        this.cNavegador = cNavegador;
    }

    public Pqrsf getIPqrsf() {
        return iPqrsf;
    }

    public void setIPqrsf(Pqrsf iPqrsf) {
        this.iPqrsf = iPqrsf;
    }

    public Usuario getIUsuarioCreador() {
        return iUsuarioCreador;
    }

    public void setIUsuarioCreador(Usuario iUsuarioCreador) {
        this.iUsuarioCreador = iUsuarioCreador;
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
        if (!(object instanceof GestionPqrsf)) {
            return false;
        }
        GestionPqrsf other = (GestionPqrsf) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.GestionPqrsf[ iCodigo=" + iCodigo + " ]";
    }

}

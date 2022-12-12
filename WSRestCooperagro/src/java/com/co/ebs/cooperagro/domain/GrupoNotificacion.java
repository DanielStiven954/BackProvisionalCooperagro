/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Brayan F Silva R
 */
@Entity
@Table(name = "GRUPO_NOTIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoNotificacion.findAll", query = "SELECT g FROM GrupoNotificacion g")
    , @NamedQuery(name = "GrupoNotificacion.findByICodigo", query = "SELECT g FROM GrupoNotificacion g WHERE g.iCodigo = :iCodigo")
    , @NamedQuery(name = "GrupoNotificacion.findByCDescripcion", query = "SELECT g FROM GrupoNotificacion g WHERE g.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "GrupoNotificacion.findByCDetalle", query = "SELECT g FROM GrupoNotificacion g WHERE g.cDetalle = :cDetalle")
    , @NamedQuery(name = "GrupoNotificacion.findByCEstado", query = "SELECT g FROM GrupoNotificacion g WHERE g.cEstado = :cEstado")})
public class GrupoNotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_GRUPO_NOTIFICACION", sequenceName = "SEC_GRUPO_NOTIFICACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_GRUPO_NOTIFICACION")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
   
    @Size(min = 1, max = 50)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    
    @Size(max = 4000)
    @Column(name = "C_DETALLE")
    private String cDetalle;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @OneToMany( mappedBy = "iGrupo")
    private List<NotificacionUsuario> notificacionUsuarioList;

    public GrupoNotificacion() {
    }

    public GrupoNotificacion(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public GrupoNotificacion(Long iCodigo, String cDescripcion, String cEstado) {
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

    public String getCDetalle() {
        return cDetalle;
    }

    public void setCDetalle(String cDetalle) {
        this.cDetalle = cDetalle;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public List<NotificacionUsuario> getNotificacionUsuarioList() {
        return notificacionUsuarioList;
    }

    public void setNotificacionUsuarioList(List<NotificacionUsuario> notificacionUsuarioList) {
        this.notificacionUsuarioList = notificacionUsuarioList;
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
        if (!(object instanceof GrupoNotificacion)) {
            return false;
        }
        GrupoNotificacion other = (GrupoNotificacion) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.GrupoNotificacion[ iCodigo=" + iCodigo + " ]";
    }

}

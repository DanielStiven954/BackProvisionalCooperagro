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
 * @author Brayan F Silva R
 */
@Entity
@Table(name = "NOTIFICACION_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificacionUsuario.findAll", query = "SELECT n FROM NotificacionUsuario n")
    , @NamedQuery(name = "NotificacionUsuario.findByICodigo", query = "SELECT n FROM NotificacionUsuario n WHERE n.iCodigo = :iCodigo")
    , @NamedQuery(name = "NotificacionUsuario.findByCTitulo", query = "SELECT n FROM NotificacionUsuario n WHERE n.cTitulo = :cTitulo")
    , @NamedQuery(name = "NotificacionUsuario.findByCDescripcion", query = "SELECT n FROM NotificacionUsuario n WHERE n.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "NotificacionUsuario.findByIDuracion", query = "SELECT n FROM NotificacionUsuario n WHERE n.iDuracion = :iDuracion")
    , @NamedQuery(name = "NotificacionUsuario.findByFFecha", query = "SELECT n FROM NotificacionUsuario n WHERE n.fFecha = :fFecha")
    , @NamedQuery(name = "NotificacionUsuario.findByCEstado", query = "SELECT n FROM NotificacionUsuario n WHERE n.cEstado = :cEstado")
    , @NamedQuery(name = "NotificacionUsuario.findByUserAndAct", query = "SELECT n FROM NotificacionUsuario n WHERE n.iUsuario = :iUsuario AND n.cEstado = :cEstado")
    , @NamedQuery(name = "NotificacionUsuario.findByUser", query = "SELECT n FROM NotificacionUsuario n WHERE n.iUsuario = :iUsuario")
})
public class NotificacionUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_NOTIFICACION_USUARIO", sequenceName = "SEC_NOTIFICACION_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_NOTIFICACION_USUARIO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 4000)
    @Column(name = "C_TITULO")
    private String cTitulo;

    @Size(min = 1, max = 4000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    @Column(name = "I_DURACION")
    private BigInteger iDuracion;

    @Column(name = "F_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    @JoinColumn(name = "I_GRUPO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GrupoNotificacion iGrupo;

    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iUsuario;

    public NotificacionUsuario() {
    }

    public NotificacionUsuario(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public NotificacionUsuario(Long iCodigo, String cTitulo, String cDescripcion, BigInteger iDuracion, Date fFecha, String cEstado) {
        this.iCodigo = iCodigo;
        this.cTitulo = cTitulo;
        this.cDescripcion = cDescripcion;
        this.iDuracion = iDuracion;
        this.fFecha = fFecha;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCTitulo() {
        return cTitulo;
    }

    public void setCTitulo(String cTitulo) {
        this.cTitulo = cTitulo;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public BigInteger getIDuracion() {
        return iDuracion;
    }

    public void setIDuracion(BigInteger iDuracion) {
        this.iDuracion = iDuracion;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public GrupoNotificacion getIGrupo() {
        return iGrupo;
    }

    public void setIGrupo(GrupoNotificacion iGrupo) {
        this.iGrupo = iGrupo;
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
        if (!(object instanceof NotificacionUsuario)) {
            return false;
        }
        NotificacionUsuario other = (NotificacionUsuario) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.NotificacionUsuario[ iCodigo=" + iCodigo + " ]";
    }

}

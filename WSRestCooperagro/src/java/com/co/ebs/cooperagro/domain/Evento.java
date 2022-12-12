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
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByICodigo", query = "SELECT e FROM Evento e WHERE e.iCodigo = :iCodigo")
    , @NamedQuery(name = "Evento.findByCDescripcion", query = "SELECT e FROM Evento e WHERE e.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "Evento.findByCMensaje", query = "SELECT e FROM Evento e WHERE e.cMensaje = :cMensaje")
    , @NamedQuery(name = "Evento.findByFFecha", query = "SELECT e FROM Evento e WHERE e.fFecha = :fFecha")
    , @NamedQuery(name = "Evento.findByCEquipo", query = "SELECT e FROM Evento e WHERE e.cEquipo = :cEquipo")
    , @NamedQuery(name = "Evento.findByITipoEvento", query = "SELECT e FROM Evento e WHERE e.iTipoEvento = :iTipoEvento")
    , @NamedQuery(name = "Evento.findByCEstado", query = "SELECT e FROM Evento e WHERE e.cEstado = :cEstado")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_EVENTO", sequenceName = "SEC_EVENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_EVENTO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 2000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    @Size(min = 1, max = 4000)
    @Column(name = "C_MENSAJE")
    private String cMensaje;

    @Column(name = "F_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;

    @Size(min = 1, max = 2000)
    @Column(name = "C_EQUIPO")
    private String cEquipo;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    @JoinColumn(name = "I_ORIGEN", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Origen iOrigen;

    @JoinColumn(name = "I_TIPO_EVENTO", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoEvento iTipoEvento;

    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iUsuario;
    
    @JoinColumn(name = "I_TIPO_CANAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoCanal iTipoCanal;

    public Evento() {
    }

    public Evento(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Evento(Long iCodigo, String cDescripcion, String cMensaje, Date fFecha, String cEquipo, TipoEvento iTipoEvento, String cEstado) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cMensaje = cMensaje;
        this.fFecha = fFecha;
        this.cEquipo = cEquipo;
        this.iTipoEvento = iTipoEvento;
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

    public String getCMensaje() {
        return cMensaje;
    }

    public void setCMensaje(String cMensaje) {
        this.cMensaje = cMensaje;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public String getCEquipo() {
        return cEquipo;
    }

    public void setCEquipo(String cEquipo) {
        this.cEquipo = cEquipo;
    }

    public TipoEvento getITipoEvento() {
        return iTipoEvento;
    }

    public void setITipoEvento(TipoEvento iTipoEvento) {
        this.iTipoEvento = iTipoEvento;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public Origen getIOrigen() {
        return iOrigen;
    }

    public void setIOrigen(Origen iOrigen) {
        this.iOrigen = iOrigen;
    }

    public TipoEvento getiTipoEvento() {
        return iTipoEvento;
    }

    public void setiTipoEvento(TipoEvento iTipoEvento) {
        this.iTipoEvento = iTipoEvento;
    }

    public Usuario getiUsuario() {
        return iUsuario;
    }

    public void setiUsuario(Usuario iUsuario) {
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

}

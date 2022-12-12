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
@Table(name = "PREGUNTA_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaUsuario.findAll", query = "SELECT p FROM PreguntaUsuario p")
    , @NamedQuery(name = "PreguntaUsuario.findByICodigo", query = "SELECT p FROM PreguntaUsuario p WHERE p.iCodigo = :iCodigo")
    , @NamedQuery(name = "PreguntaUsuario.findByIOrden", query = "SELECT p FROM PreguntaUsuario p WHERE p.iOrden = :iOrden")
    , @NamedQuery(name = "PreguntaUsuario.findByCRespuesta", query = "SELECT p FROM PreguntaUsuario p WHERE p.cRespuesta = :cRespuesta")
    , @NamedQuery(name = "PreguntaUsuario.findByFInicio", query = "SELECT p FROM PreguntaUsuario p WHERE p.fInicio = :fInicio")
    , @NamedQuery(name = "PreguntaUsuario.findByFFin", query = "SELECT p FROM PreguntaUsuario p WHERE p.fFin = :fFin")
    , @NamedQuery(name = "PreguntaUsuario.findByCEstado", query = "SELECT p FROM PreguntaUsuario p WHERE p.cEstado = :cEstado")
    , @NamedQuery(name = "PreguntaUsuario.findByCLlaveSeguridad", query = "SELECT p FROM PreguntaUsuario p WHERE p.cLlaveSeguridad = :cLlaveSeguridad")})
public class PreguntaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PREGUNTA_USUARIO", sequenceName = "SEC_PREGUNTA_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PREGUNTA_USUARIO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "I_ORDEN")
    private BigInteger iOrden;

    @Size(min = 1, max = 4000)
    @Column(name = "C_RESPUESTA")
    private String cRespuesta;

    @Column(name = "F_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fInicio;

    @Column(name = "F_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFin;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    @Size(min = 1, max = 10)
    @Column(name = "C_LLAVE_SEGURIDAD")
    private String cLlaveSeguridad;

    @JoinColumn(name = "I_PREGUNTA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pregunta iPregunta;

    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuario;

    public PreguntaUsuario() {
    }

    public PreguntaUsuario(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public PreguntaUsuario(Long iCodigo, BigInteger iOrden, String cRespuesta, Date fInicio, Date fFin, String cEstado, String cLlaveSeguridad) {
        this.iCodigo = iCodigo;
        this.iOrden = iOrden;
        this.cRespuesta = cRespuesta;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.cEstado = cEstado;
        this.cLlaveSeguridad = cLlaveSeguridad;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigInteger getIOrden() {
        return iOrden;
    }

    public void setIOrden(BigInteger iOrden) {
        this.iOrden = iOrden;
    }

    public String getCRespuesta() {
        return cRespuesta;
    }

    public void setCRespuesta(String cRespuesta) {
        this.cRespuesta = cRespuesta;
    }

    public Date getFInicio() {
        return fInicio;
    }

    public void setFInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getFFin() {
        return fFin;
    }

    public void setFFin(Date fFin) {
        this.fFin = fFin;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getCLlaveSeguridad() {
        return cLlaveSeguridad;
    }

    public void setCLlaveSeguridad(String cLlaveSeguridad) {
        this.cLlaveSeguridad = cLlaveSeguridad;
    }

    public Pregunta getIPregunta() {
        return iPregunta;
    }

    public void setIPregunta(Pregunta iPregunta) {
        this.iPregunta = iPregunta;
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
        if (!(object instanceof PreguntaUsuario)) {
            return false;
        }
        PreguntaUsuario other = (PreguntaUsuario) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.PreguntaUsuario[ iCodigo=" + iCodigo + " ]";
    }

}

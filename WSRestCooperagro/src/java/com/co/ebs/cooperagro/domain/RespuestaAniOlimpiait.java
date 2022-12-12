/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Braya
 */
@Entity
@Table(name = "RESPUESTA_ANI_OLIMPIAIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespuestaAniOlimpiait.findAll", query = "SELECT r FROM RespuestaAniOlimpiait r"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByICodigo", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.iCodigo = :iCodigo"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCIdTransaccion", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cIdTransaccion = :cIdTransaccion"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCNuip", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cNuip = :cNuip"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCPrimerNombre", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cPrimerNombre = :cPrimerNombre"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCSegundoNombre", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cSegundoNombre = :cSegundoNombre"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCPrimerApellido", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cPrimerApellido = :cPrimerApellido"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCSegundoApellido", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cSegundoApellido = :cSegundoApellido"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCParticula", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cParticula = :cParticula"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCNumeroResolucion", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cNumeroResolucion = :cNumeroResolucion"),
//    @NamedQuery(name = "RespuestaAniOlimpiait.findByCAnioResolucion", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cAnioResolucion = :cAnioResolucion"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCMunicipioExpedicion", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cMunicipioExpedicion = :cMunicipioExpedicion"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCDepartamentoExpedicio", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cDepartamentoExpedicio = :cDepartamentoExpedicio"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByCFechaExpedicion", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.cFechaExpedicion = :cFechaExpedicion"),
    @NamedQuery(name = "RespuestaAniOlimpiait.findByICodErrorDatosCedula", query = "SELECT r FROM RespuestaAniOlimpiait r WHERE r.iCodErrorDatosCedula = :iCodErrorDatosCedula")})
public class RespuestaAniOlimpiait implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_RTA_ANI_OLIMPIAIT", sequenceName = "SEC_RTA_ANI_OLIMPIAIT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_RTA_ANI_OLIMPIAIT")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "C_ID_TRANSACCION")
    private String cIdTransaccion;

    @Column(name = "C_NUIP")
    private String cNuip;

    @Column(name = "C_PRIMER_NOMBRE")
    private String cPrimerNombre;

    @Column(name = "C_SEGUNDO_NOMBRE")
    private String cSegundoNombre;

    @Column(name = "C_PRIMER_APELLIDO")
    private String cPrimerApellido;

    @Column(name = "C_SEGUNDO_APELLIDO")
    private String cSegundoApellido;

    @Column(name = "C_PARTICULA")
    private String cParticula;

    @Column(name = "C_NUMERO_RESOLUCION")
    private String cNumeroResolucion;

    @Column(name = "C_ANIO_RESOLUCION")
    private String cAnioResolucion;

    @Column(name = "C_MUNICIPIO_EXPEDICION")
    private String cMunicipioExpedicion;

    @Column(name = "C_DEPARTAMENTO_EXPEDICION")
    private String cDepartamentoExpedicio;

    @Column(name = "C_FECHA_EXPEDICION")
    private String cFechaExpedicion;

    @Column(name = "I_COD_ERROR_DATOS_CEDULA")
    private BigInteger iCodErrorDatosCedula;
    
    @Column(name = "C_JSON_RTA")
    private String cJsonRta;

    @JoinColumn(name = "I_CONS_ANI_OLIMPIAIT", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private ConsultaAniOlimpiait iConsAniOlimpiait;

    @JoinColumn(name = "I_ESTADO_CEDULA", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private EstadoCedula iEstadoCedula;

    public RespuestaAniOlimpiait() {
    }

    public RespuestaAniOlimpiait(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCIdTransaccion() {
        return cIdTransaccion;
    }

    public void setCIdTransaccion(String cIdTransaccion) {
        this.cIdTransaccion = cIdTransaccion;
    }

    public String getCNuip() {
        return cNuip;
    }

    public void setCNuip(String cNuip) {
        this.cNuip = cNuip;
    }

    public String getCPrimerNombre() {
        return cPrimerNombre;
    }

    public void setCPrimerNombre(String cPrimerNombre) {
        this.cPrimerNombre = cPrimerNombre;
    }

    public String getCSegundoNombre() {
        return cSegundoNombre;
    }

    public void setCSegundoNombre(String cSegundoNombre) {
        this.cSegundoNombre = cSegundoNombre;
    }

    public String getCPrimerApellido() {
        return cPrimerApellido;
    }

    public void setCPrimerApellido(String cPrimerApellido) {
        this.cPrimerApellido = cPrimerApellido;
    }

    public String getCSegundoApellido() {
        return cSegundoApellido;
    }

    public void setCSegundoApellido(String cSegundoApellido) {
        this.cSegundoApellido = cSegundoApellido;
    }

    public String getCParticula() {
        return cParticula;
    }

    public void setCParticula(String cParticula) {
        this.cParticula = cParticula;
    }

    public String getCNumeroResolucion() {
        return cNumeroResolucion;
    }

    public void setCNumeroResolucion(String cNumeroResolucion) {
        this.cNumeroResolucion = cNumeroResolucion;
    }

    public String getCAnioResolucion() {
        return cAnioResolucion;
    }

    public void setCAnioResolucion(String cAnioResolucion) {
        this.cAnioResolucion = cAnioResolucion;
    }

    public String getCMunicipioExpedicion() {
        return cMunicipioExpedicion;
    }

    public void setCMunicipioExpedicion(String cMunicipioExpedicion) {
        this.cMunicipioExpedicion = cMunicipioExpedicion;
    }

    public String getCDepartamentoExpedicio() {
        return cDepartamentoExpedicio;
    }

    public void setCDepartamentoExpedicio(String cDepartamentoExpedicio) {
        this.cDepartamentoExpedicio = cDepartamentoExpedicio;
    }

    public String getCFechaExpedicion() {
        return cFechaExpedicion;
    }

    public void setCFechaExpedicion(String cFechaExpedicion) {
        this.cFechaExpedicion = cFechaExpedicion;
    }

    public BigInteger getICodErrorDatosCedula() {
        return iCodErrorDatosCedula;
    }

    public void setICodErrorDatosCedula(BigInteger iCodErrorDatosCedula) {
        this.iCodErrorDatosCedula = iCodErrorDatosCedula;
    }

    public ConsultaAniOlimpiait getIConsAniOlimpiait() {
        return iConsAniOlimpiait;
    }

    public void setIConsAniOlimpiait(ConsultaAniOlimpiait iConsAniOlimpiait) {
        this.iConsAniOlimpiait = iConsAniOlimpiait;
    }

    public EstadoCedula getIEstadoCedula() {
        return iEstadoCedula;
    }

    public void setIEstadoCedula(EstadoCedula iEstadoCedula) {
        this.iEstadoCedula = iEstadoCedula;
    }

    public String getcJsonRta() {
        return cJsonRta;
    }

    public void setcJsonRta(String cJsonRta) {
        this.cJsonRta = cJsonRta;
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
        if (!(object instanceof RespuestaAniOlimpiait)) {
            return false;
        }
        RespuestaAniOlimpiait other = (RespuestaAniOlimpiait) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebssas.actdatos.domain.RespuestaAniOlimpiait[ iCodigo=" + iCodigo + " ]";
    }

}

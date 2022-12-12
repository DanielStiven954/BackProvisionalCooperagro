/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "REFERENCIAS_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferenciasSolAfilWeb.findAll", query = "SELECT r FROM ReferenciasSolAfilWeb r")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByICodigo", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.iCodigo = :iCodigo")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCTipoReferencia", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cTipoReferencia = :cTipoReferencia")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCNombres", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cNombres = :cNombres")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCApellidos", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cApellidos = :cApellidos")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCIdentificacion", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cIdentificacion = :cIdentificacion")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCDireccionResidencia", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cDireccionResidencia = :cDireccionResidencia")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCNumTelResidencia", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cNumTelResidencia = :cNumTelResidencia")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCNumCelular", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cNumCelular = :cNumCelular")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCEmail", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cEmail = :cEmail")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByCParentesco", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.cParentesco = :cParentesco")
    , @NamedQuery(name = "ReferenciasSolAfilWeb.findByiSolAfiliacionWeb", query = "SELECT r FROM ReferenciasSolAfilWeb r WHERE r.iSolAfiliacionWeb = :iSolAfiliacionWeb")
})
public class ReferenciasSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_REFER_SOL_AFIL_WEB", sequenceName = "SEQ_REFER_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REFER_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 2)
    @Column(name = "C_TIPO_REFERENCIA")
    private String cTipoReferencia;

    @Size(min = 1, max = 100)
    @Column(name = "C_NOMBRES")
    private String cNombres;

    @Size(min = 1, max = 100)
    @Column(name = "C_APELLIDOS")
    private String cApellidos;

    @Size(min = 1, max = 20)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;

    @Size(min = 1, max = 80)
    @Column(name = "C_DIRECCION_RESIDENCIA")
    private String cDireccionResidencia;

    @Size(min = 1, max = 15)
    @Column(name = "C_NUM_TEL_RESIDENCIA")
    private String cNumTelResidencia;

    @Size(min = 1, max = 15)
    @Column(name = "C_NUM_CELULAR")
    private String cNumCelular;

    @Size(min = 1, max = 50)
    @Column(name = "C_EMAIL")
    private String cEmail;

    @Size(min = 1, max = 30)
    @Column(name = "C_PARENTESCO")
    private String cParentesco;
    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    public ReferenciasSolAfilWeb() {
    }

    public ReferenciasSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ReferenciasSolAfilWeb(Long iCodigo, String cTipoReferencia, String cNombres, String cApellidos, String cIdentificacion, String cDireccionResidencia, String cNumTelResidencia, String cNumCelular, String cEmail, String cParentesco) {
        this.iCodigo = iCodigo;
        this.cTipoReferencia = cTipoReferencia;
        this.cNombres = cNombres;
        this.cApellidos = cApellidos;
        this.cIdentificacion = cIdentificacion;
        this.cDireccionResidencia = cDireccionResidencia;
        this.cNumTelResidencia = cNumTelResidencia;
        this.cNumCelular = cNumCelular;
        this.cEmail = cEmail;
        this.cParentesco = cParentesco;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCTipoReferencia() {
        return cTipoReferencia;
    }

    public void setCTipoReferencia(String cTipoReferencia) {
        this.cTipoReferencia = cTipoReferencia;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getCApellidos() {
        return cApellidos;
    }

    public void setCApellidos(String cApellidos) {
        this.cApellidos = cApellidos;
    }

    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public String getCDireccionResidencia() {
        return cDireccionResidencia;
    }

    public void setCDireccionResidencia(String cDireccionResidencia) {
        this.cDireccionResidencia = cDireccionResidencia;
    }

    public String getCNumTelResidencia() {
        return cNumTelResidencia;
    }

    public void setCNumTelResidencia(String cNumTelResidencia) {
        this.cNumTelResidencia = cNumTelResidencia;
    }

    public String getCNumCelular() {
        return cNumCelular;
    }

    public void setCNumCelular(String cNumCelular) {
        this.cNumCelular = cNumCelular;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCParentesco() {
        return cParentesco;
    }

    public void setCParentesco(String cParentesco) {
        this.cParentesco = cParentesco;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb() {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb) {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
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
        if (!(object instanceof ReferenciasSolAfilWeb)) {
            return false;
        }
        ReferenciasSolAfilWeb other = (ReferenciasSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.ReferenciasSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }

}

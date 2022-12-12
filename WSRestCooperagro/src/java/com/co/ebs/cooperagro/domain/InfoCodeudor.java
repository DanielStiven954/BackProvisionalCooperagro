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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brayan F Silva R
 */
@Entity
@Table(name = "INFO_CODEUDOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoCodeudor.findAll", query = "SELECT i FROM InfoCodeudor i"),
    @NamedQuery(name = "InfoCodeudor.findByICodigo", query = "SELECT i FROM InfoCodeudor i WHERE i.iCodigo = :iCodigo"),
    @NamedQuery(name = "InfoCodeudor.findByCNombres", query = "SELECT i FROM InfoCodeudor i WHERE i.cNombres = :cNombres"),
    @NamedQuery(name = "InfoCodeudor.findByCApellidos", query = "SELECT i FROM InfoCodeudor i WHERE i.cApellidos = :cApellidos"),
    @NamedQuery(name = "InfoCodeudor.findByCIdentificacion", query = "SELECT i FROM InfoCodeudor i WHERE i.cIdentificacion = :cIdentificacion"),
    @NamedQuery(name = "InfoCodeudor.findByCNombreEmpresa", query = "SELECT i FROM InfoCodeudor i WHERE i.cNombreEmpresa = :cNombreEmpresa"),
    @NamedQuery(name = "InfoCodeudor.findByCDireccionResidencia", query = "SELECT i FROM InfoCodeudor i WHERE i.cDireccionResidencia = :cDireccionResidencia"),
    @NamedQuery(name = "InfoCodeudor.findByICiudad", query = "SELECT i FROM InfoCodeudor i WHERE i.iCiudad = :iCiudad"),
    @NamedQuery(name = "InfoCodeudor.findByCTelefono", query = "SELECT i FROM InfoCodeudor i WHERE i.cTelefono = :cTelefono"),})
public class InfoCodeudor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_INFO_CODEUDOR", sequenceName = "SEC_INFO_CODEUDOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_INFO_CODEUDOR")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Basic(optional = false)
    @Column(name = "C_NOMBRES")
    private String cNombres;

    @Size(min = 1, max = 500)
    @Column(name = "C_APELLIDOS")
    private String cApellidos;

    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;

    @Size(min = 1, max = 20)
    @Column(name = "C_NOMBRE_EMPRESA")
    private String cNombreEmpresa;

    @Size(min = 1, max = 500)
    @Column(name = "C_DIRECCION_RESIDENCIA")
    private String cDireccionResidencia;
    
    @Column(name = "I_CIUDAD")
    private Long iCiudad;

    @Column(name = "C_TELEFONO")
    @Size(min = 1, max = 500)
    private String cTelefono;

    @JoinColumn(name = "I_SOLICITUD_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudCredito iSolicitudCredito;

    @JoinColumn(name = "I_USUARIO_CREADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario iUsuarioCreador;
    @Column(name = "F_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaCreacion;

    @JoinColumn(name = "I_USUARIO_MODIFICADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iUsuarioModificador;

    @Column(name = "F_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaModificacion;

    public InfoCodeudor() {
    }

    public InfoCodeudor(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public InfoCodeudor(Long iCodigo, String cNombres, String cApellidos, String cIdentificacion, String cNombreEmpresa, String cDireccionResi, long iCiudad, String cTelefono, Date fFechaCreacion) {
        this.iCodigo = iCodigo;
        this.cNombres = cNombres;
        this.cApellidos = cApellidos;
        this.cIdentificacion = cIdentificacion;
        this.cNombreEmpresa = cNombreEmpresa;
        this.cDireccionResidencia = cDireccionResi;
        this.iCiudad = iCiudad;
        this.cTelefono = cTelefono;
        this.fFechaCreacion = fFechaCreacion;
    }

    public Long getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getcNombres() {
        return cNombres;
    }

    public void setcNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getcApellidos() {
        return cApellidos;
    }

    public void setcApellidos(String cApellidos) {
        this.cApellidos = cApellidos;
    }

    public String getcIdentificacion() {
        return cIdentificacion;
    }

    public void setcIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public String getcNombreEmpresa() {
        return cNombreEmpresa;
    }

    public void setcNombreEmpresa(String cNombreEmpresa) {
        this.cNombreEmpresa = cNombreEmpresa;
    }

    public String getcDireccionResidencia() {
        return cDireccionResidencia;
    }

    public void setcDireccionResidencia(String cDireccionResidencia) {
        this.cDireccionResidencia = cDireccionResidencia;
    }

    public Long getiCiudad() {
        return iCiudad;
    }

    public void setiCiudad(Long iCiudad) {
        this.iCiudad = iCiudad;
    }

    public String getcTelefono() {
        return cTelefono;
    }

    public void setcTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    public Date getfFechaCreacion() {
        return fFechaCreacion;
    }

    public void setfFechaCreacion(Date fFechaCreacion) {
        this.fFechaCreacion = fFechaCreacion;
    }

    public Date getfFechaModificacion() {
        return fFechaModificacion;
    }

    public void setfFechaModificacion(Date fFechaModificacion) {
        this.fFechaModificacion = fFechaModificacion;
    }

    public SolicitudCredito getiSolicitudCredito() {
        return iSolicitudCredito;
    }

    public void setiSolicitudCredito(SolicitudCredito iSolicitudCredito) {
        this.iSolicitudCredito = iSolicitudCredito;
    }

    public Usuario getiUsuarioModificador() {
        return iUsuarioModificador;
    }

    public void setiUsuarioModificador(Usuario iUsuarioModificador) {
        this.iUsuarioModificador = iUsuarioModificador;
    }

    public Usuario getiUsuarioCreador() {
        return iUsuarioCreador;
    }

    public void setiUsuarioCreador(Usuario iUsuarioCreador) {
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
        if (!(object instanceof InfoCodeudor)) {
            return false;
        }
        InfoCodeudor other = (InfoCodeudor) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.wlosomec.domain.InfoCtaBanco[ iCodigo=" + iCodigo + " ]";
    }

}

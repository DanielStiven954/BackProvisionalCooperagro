/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "INFO_CONYUGE_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoConyugeSolAfilWeb.findAll", query = "SELECT i FROM InfoConyugeSolAfilWeb i")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByICodigo", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.iCodigo = :iCodigo")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByCNombres", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.cNombres = :cNombres")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByCApellidos", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.cApellidos = :cApellidos")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByITipoIdent", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.iTipoIdent = :iTipoIdent")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByCIdentificacion", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.cIdentificacion = :cIdentificacion")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByCDireccion", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.cDireccion = :cDireccion")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByCNumCelular", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.cNumCelular = :cNumCelular")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByCNumTelefono", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.cNumTelefono = :cNumTelefono")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByICiudadResidencia", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.iCiudadResidencia = :iCiudadResidencia")
    , @NamedQuery(name = "InfoConyugeSolAfilWeb.findByiSolAfiliacionWeb", query = "SELECT i FROM InfoConyugeSolAfilWeb i WHERE i.iSolAfiliacionWeb = :iSolAfiliacionWeb")
})
public class InfoConyugeSolAfilWeb implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "I_TIPO_IDENT")
    private Long iTipoIdent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CIUDAD_RESIDENCIA")
    private Long iCiudadResidencia;
    @Size(max = 200)
    @Column(name = "C_IDENTIFICACION_CONY")
    private String cIdentificacionCony;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_INF_CONY_SOL_AFIL_WEB", sequenceName = "SEQ_INF_CONY_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INF_CONY_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 100)
    @Column(name = "C_NOMBRES")
    private String cNombres;

    @Size(min = 1, max = 100)
    @Column(name = "C_APELLIDOS")
    private String cApellidos;


    @Size(min = 1, max = 20)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;

    @Size(min = 1, max = 60)
    @Column(name = "C_DIRECCION")
    private String cDireccion;

    @Size(min = 1, max = 15)
    @Column(name = "C_NUM_CELULAR")
    private String cNumCelular;

    @Size(min = 1, max = 15)
    @Column(name = "C_NUM_TELEFONO")
    private String cNumTelefono;

    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    public InfoConyugeSolAfilWeb() {
    }

    public InfoConyugeSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public InfoConyugeSolAfilWeb(Long iCodigo, String cNombres, String cApellidos, Long iTipoIdent, String cIdentificacion, String cDireccion, String cNumCelular, String cNumTelefono, Long iCiudadResidencia) {
        this.iCodigo = iCodigo;
        this.cNombres = cNombres;
        this.cApellidos = cApellidos;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.cDireccion = cDireccion;
        this.cNumCelular = cNumCelular;
        this.cNumTelefono = cNumTelefono;
        this.iCiudadResidencia = iCiudadResidencia;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
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

    public Long getITipoIdent() {
        return iTipoIdent;
    }

    public void setITipoIdent(Long iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public String getCDireccion() {
        return cDireccion;
    }

    public void setCDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    public String getCNumCelular() {
        return cNumCelular;
    }

    public void setCNumCelular(String cNumCelular) {
        this.cNumCelular = cNumCelular;
    }

    public String getCNumTelefono() {
        return cNumTelefono;
    }

    public void setCNumTelefono(String cNumTelefono) {
        this.cNumTelefono = cNumTelefono;
    }

    public Long getICiudadResidencia() {
        return iCiudadResidencia;
    }

    public void setICiudadResidencia(Long iCiudadResidencia) {
        this.iCiudadResidencia = iCiudadResidencia;
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
        if (!(object instanceof InfoConyugeSolAfilWeb)) {
            return false;
        }
        InfoConyugeSolAfilWeb other = (InfoConyugeSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InfoConyugeSolAfilWeb{" + "iCodigo=" + iCodigo + ", cNombres=" + cNombres + ", cApellidos=" + cApellidos + ", iTipoIdent=" + iTipoIdent + ", cIdentificacion=" + cIdentificacion + ", cDireccion=" + cDireccion + ", cNumCelular=" + cNumCelular + ", cNumTelefono=" + cNumTelefono + ", iCiudadResidencia=" + iCiudadResidencia + ", iSolAfiliacionWeb=" + iSolAfiliacionWeb + '}';
    }   

    public String getCIdentificacionCony() {
        return cIdentificacionCony;
    }

    public void setCIdentificacionCony(String cIdentificacionCony) {
        this.cIdentificacionCony = cIdentificacionCony;
    }

    
}

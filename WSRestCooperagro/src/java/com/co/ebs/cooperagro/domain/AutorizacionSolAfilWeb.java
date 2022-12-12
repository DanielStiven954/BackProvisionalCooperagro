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
 * @author Administrador
 */
@Entity
@Table(name = "AUTORIZACION_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorizacionSolAfilWeb.findAll", query = "SELECT a FROM AutorizacionSolAfilWeb a"),
    @NamedQuery(name = "AutorizacionSolAfilWeb.findByICodigo", query = "SELECT a FROM AutorizacionSolAfilWeb a WHERE a.iCodigo = :iCodigo"),
    @NamedQuery(name = "AutorizacionSolAfilWeb.findByCAutorizo", query = "SELECT a FROM AutorizacionSolAfilWeb a WHERE a.cAutorizo = :cAutorizo")})
public class AutorizacionSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_AUTORIZACION_SOL_AFIL_WEB", sequenceName = "SEQ_AUTORIZACION_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTORIZACION_SOL_AFIL_WEB")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_AUTORIZO")
    private String cAutorizo;
    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;
    @JoinColumn(name = "I_TIPO_AUTORIZACION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoAutorizacionSolAfilWeb iTipoAutorizacion;

    public AutorizacionSolAfilWeb() {
    }

    public AutorizacionSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public AutorizacionSolAfilWeb(Long iCodigo, String cAutorizo) {
        this.iCodigo = iCodigo;
        this.cAutorizo = cAutorizo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCAutorizo() {
        return cAutorizo;
    }

    public void setCAutorizo(String cAutorizo) {
        this.cAutorizo = cAutorizo;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb() {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb) {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
    }

    public TipoAutorizacionSolAfilWeb getITipoAutorizacion() {
        return iTipoAutorizacion;
    }

    public void setITipoAutorizacion(TipoAutorizacionSolAfilWeb iTipoAutorizacion) {
        this.iTipoAutorizacion = iTipoAutorizacion;
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
        if (!(object instanceof AutorizacionSolAfilWeb)) {
            return false;
        }
        AutorizacionSolAfilWeb other = (AutorizacionSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AutorizacionSolAfilWeb{" + "iCodigo=" + iCodigo + ", cAutorizo=" + cAutorizo + ", iSolAfiliacionWeb=" + iSolAfiliacionWeb + ", iTipoAutorizacion=" + iTipoAutorizacion + '}';
    }

    
}

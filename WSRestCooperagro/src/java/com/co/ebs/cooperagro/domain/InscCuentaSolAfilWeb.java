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
@Table(name = "INSC_CUENTA_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscCuentaSolAfilWeb.findAll", query = "SELECT i FROM InscCuentaSolAfilWeb i"),
    @NamedQuery(name = "InscCuentaSolAfilWeb.findByICodigo", query = "SELECT i FROM InscCuentaSolAfilWeb i WHERE i.iCodigo = :iCodigo"),
    @NamedQuery(name = "InscCuentaSolAfilWeb.findByCNombresTitular", query = "SELECT i FROM InscCuentaSolAfilWeb i WHERE i.cNombresTitular = :cNombresTitular"),
    @NamedQuery(name = "InscCuentaSolAfilWeb.findByCApellidosTitular", query = "SELECT i FROM InscCuentaSolAfilWeb i WHERE i.cApellidosTitular = :cApellidosTitular"),
    @NamedQuery(name = "InscCuentaSolAfilWeb.findByCNumCta", query = "SELECT i FROM InscCuentaSolAfilWeb i WHERE i.cNumCta = :cNumCta"),
    @NamedQuery(name = "InscCuentaSolAfilWeb.findByCNombreBanco", query = "SELECT i FROM InscCuentaSolAfilWeb i WHERE i.cNombreBanco = :cNombreBanco")})
public class InscCuentaSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id   
    @SequenceGenerator(name = "SEQ_INSC_CTA_SOL_AFIL_WEB", sequenceName = "SEQ_INSC_CTA_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INSC_CTA_SOL_AFIL_WEB")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "C_NOMBRES_TITULAR")
    private String cNombresTitular;
    
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "C_APELLIDOS_TITULAR")
    private String cApellidosTitular;
    
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "C_NUM_CTA")
    private String cNumCta;
    
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "C_NOMBRE_BANCO")
    private String cNombreBanco;
    
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_DIA_DEBITO")
    private String cDiaDebito;
    
    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;
    @JoinColumn(name = "I_TIPO_CTA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoCuentaSolAfilWeb iTipoCta;

    public InscCuentaSolAfilWeb() {
    }

    public InscCuentaSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public InscCuentaSolAfilWeb(Long iCodigo, String cNombresTitular, String cApellidosTitular, String cNumCta, String cNombreBanco) {
        this.iCodigo = iCodigo;
        this.cNombresTitular = cNombresTitular;
        this.cApellidosTitular = cApellidosTitular;
        this.cNumCta = cNumCta;
        this.cNombreBanco = cNombreBanco;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombresTitular() {
        return cNombresTitular;
    }

    public void setCNombresTitular(String cNombresTitular) {
        this.cNombresTitular = cNombresTitular;
    }

    public String getCApellidosTitular() {
        return cApellidosTitular;
    }

    public void setCApellidosTitular(String cApellidosTitular) {
        this.cApellidosTitular = cApellidosTitular;
    }

    public String getCNumCta() {
        return cNumCta;
    }

    public void setCNumCta(String cNumCta) {
        this.cNumCta = cNumCta;
    }

    public String getCNombreBanco() {
        return cNombreBanco;
    }

    public String getCDiaDebito() {
        return cDiaDebito;
    }

    public void setCDiaDebito(String cDiaDebito) {
        this.cDiaDebito = cDiaDebito;
    }

    public void setCNombreBanco(String cNombreBanco) {
        this.cNombreBanco = cNombreBanco;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb() {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb) {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
    }

    public TipoCuentaSolAfilWeb getITipoCta() {
        return iTipoCta;
    }

    public void setITipoCta(TipoCuentaSolAfilWeb iTipoCta) {
        this.iTipoCta = iTipoCta;
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
        if (!(object instanceof InscCuentaSolAfilWeb)) {
            return false;
        }
        InscCuentaSolAfilWeb other = (InscCuentaSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.InscCuentaSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }
    
}

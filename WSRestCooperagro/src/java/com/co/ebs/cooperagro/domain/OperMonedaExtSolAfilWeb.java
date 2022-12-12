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
@Table(name = "OPER_MONEDA_EXT_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperMonedaExtSolAfilWeb.findAll", query = "SELECT o FROM OperMonedaExtSolAfilWeb o")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByICodigo", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.iCodigo = :iCodigo")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCRealizaOperMonExt", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cRealizaOperMonExt = :cRealizaOperMonExt")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCDescOperMonExt", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cDescOperMonExt = :cDescOperMonExt")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCPoseeCtaExt", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cPoseeCtaExt = :cPoseeCtaExt")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCNumCta", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cNumCta = :cNumCta")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCNombreBanco", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cNombreBanco = :cNombreBanco")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCMoneda", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cMoneda = :cMoneda")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCCiudad", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cCiudad = :cCiudad")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByCPais", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.cPais = :cPais")
    , @NamedQuery(name = "OperMonedaExtSolAfilWeb.findByiSolAfiliacionWeb", query = "SELECT o FROM OperMonedaExtSolAfilWeb o WHERE o.iSolAfiliacionWeb = :iSolAfiliacionWeb")
})
public class OperMonedaExtSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_OPER_MON_EXT_SOL_AFIL_WEB", sequenceName = "SEQ_OPER_MON_EXT_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OPER_MON_EXT_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 2)
    @Column(name = "C_REALIZA_OPER_MON_EXT")
    private String cRealizaOperMonExt;

    @Size(min = 1, max = 100)
    @Column(name = "C_DESC_OPER_MON_EXT")
    private String cDescOperMonExt;

    @Size(min = 1, max = 2)
    @Column(name = "C_POSEE_CTA_EXT")
    private String cPoseeCtaExt;
    @Size(max = 30)
    @Column(name = "C_NUM_CTA")
    private String cNumCta;
    @Size(max = 60)
    @Column(name = "C_NOMBRE_BANCO")
    private String cNombreBanco;
    @Size(max = 40)
    @Column(name = "C_MONEDA")
    private String cMoneda;
    @Size(max = 70)
    @Column(name = "C_CIUDAD")
    private String cCiudad;
    @Size(max = 70)
    @Column(name = "C_PAIS")
    private String cPais;
    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    public OperMonedaExtSolAfilWeb() {
    }

    public OperMonedaExtSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public OperMonedaExtSolAfilWeb(Long iCodigo, String cRealizaOperMonExt, String cDescOperMonExt, String cPoseeCtaExt) {
        this.iCodigo = iCodigo;
        this.cRealizaOperMonExt = cRealizaOperMonExt;
        this.cDescOperMonExt = cDescOperMonExt;
        this.cPoseeCtaExt = cPoseeCtaExt;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCRealizaOperMonExt() {
        return cRealizaOperMonExt;
    }

    public void setCRealizaOperMonExt(String cRealizaOperMonExt) {
        this.cRealizaOperMonExt = cRealizaOperMonExt;
    }

    public String getCDescOperMonExt() {
        return cDescOperMonExt;
    }

    public void setCDescOperMonExt(String cDescOperMonExt) {
        this.cDescOperMonExt = cDescOperMonExt;
    }

    public String getCPoseeCtaExt() {
        return cPoseeCtaExt;
    }

    public void setCPoseeCtaExt(String cPoseeCtaExt) {
        this.cPoseeCtaExt = cPoseeCtaExt;
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

    public void setCNombreBanco(String cNombreBanco) {
        this.cNombreBanco = cNombreBanco;
    }

    public String getCMoneda() {
        return cMoneda;
    }

    public void setCMoneda(String cMoneda) {
        this.cMoneda = cMoneda;
    }

    public String getCCiudad() {
        return cCiudad;
    }

    public void setCCiudad(String cCiudad) {
        this.cCiudad = cCiudad;
    }

    public String getCPais() {
        return cPais;
    }

    public void setCPais(String cPais) {
        this.cPais = cPais;
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
        if (!(object instanceof OperMonedaExtSolAfilWeb)) {
            return false;
        }
        OperMonedaExtSolAfilWeb other = (OperMonedaExtSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.OperMonedaExtSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }

}

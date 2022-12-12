/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.Date;
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
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "INFO_PENSIONADOS_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoPensionadoSolAfilWeb.findAll", query = "SELECT i FROM InfoPensionadoSolAfilWeb i")
    , @NamedQuery(name = "InfoPensionadoSolAfilWeb.findByICodigo", query = "SELECT i FROM InfoPensionadoSolAfilWeb i WHERE i.iCodigo = :iCodigo")
    , @NamedQuery(name = "InfoPensionadoSolAfilWeb.findByCPensionado", query = "SELECT i FROM InfoPensionadoSolAfilWeb i WHERE i.cPensionado = :cPensionado")
    , @NamedQuery(name = "InfoPensionadoSolAfilWeb.findByCOtraEntidadPension", query = "SELECT i FROM InfoPensionadoSolAfilWeb i WHERE i.cOtraEntidadPension = :cOtraEntidadPension")
    , @NamedQuery(name = "InfoPensionadoSolAfilWeb.findByFFechaPensionado", query = "SELECT i FROM InfoPensionadoSolAfilWeb i WHERE i.fFechaPensionado = :fFechaPensionado")
    , @NamedQuery(name = "InfoPensionadoSolAfilWeb.findByCPoseeOtraPension", query = "SELECT i FROM InfoPensionadoSolAfilWeb i WHERE i.cPoseeOtraPension = :cPoseeOtraPension")
    , @NamedQuery(name = "InfoPensionadoSolAfilWeb.findByCEntidadOtraPension", query = "SELECT i FROM InfoPensionadoSolAfilWeb i WHERE i.cEntidadOtraPension = :cEntidadOtraPension")
    , @NamedQuery(name = "InfoPensionadoSolAfilWeb.findByiSolAfiliacionWeb", query = "SELECT i FROM InfoPensionadoSolAfilWeb i WHERE i.iSolAfiliacionWeb = :iSolAfiliacionWeb")
})
public class InfoPensionadoSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_INF_PENS_SOL_AFIL_WEB", sequenceName = "SEQ_INF_PENS_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INF_PENS_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 5)
    @Column(name = "C_PENSIONADO")
    private String cPensionado;
    @Size(max = 70)
    @Column(name = "C_OTRA_ENTIDAD_PENSION")
    private String cOtraEntidadPension;
    @Column(name = "F_FECHA_PENSIONADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaPensionado;
    @Size(max = 2)
    @Column(name = "C_POSEE_OTRA_PENSION")
    private String cPoseeOtraPension;
    @Size(max = 70)
    @Column(name = "C_ENTIDAD_OTRA_PENSION")
    private String cEntidadOtraPension;

    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    public InfoPensionadoSolAfilWeb() {
    }

    public InfoPensionadoSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public InfoPensionadoSolAfilWeb(Long iCodigo, String cPensionado) {
        this.iCodigo = iCodigo;
        this.cPensionado = cPensionado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCPensionado() {
        return cPensionado;
    }

    public void setCPensionado(String cPensionado) {
        this.cPensionado = cPensionado;
    }

    public String getCOtraEntidadPension() {
        return cOtraEntidadPension;
    }

    public void setCOtraEntidadPension(String cOtraEntidadPension) {
        this.cOtraEntidadPension = cOtraEntidadPension;
    }

    public Date getFFechaPensionado() {
        return fFechaPensionado;
    }

    public void setFFechaPensionado(Date fFechaPensionado) {
        this.fFechaPensionado = fFechaPensionado;
    }

    public String getCPoseeOtraPension() {
        return cPoseeOtraPension;
    }

    public void setCPoseeOtraPension(String cPoseeOtraPension) {
        this.cPoseeOtraPension = cPoseeOtraPension;
    }

    public String getCEntidadOtraPension() {
        return cEntidadOtraPension;
    }

    public void setCEntidadOtraPension(String cEntidadOtraPension) {
        this.cEntidadOtraPension = cEntidadOtraPension;
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
        if (!(object instanceof InfoPensionadoSolAfilWeb)) {
            return false;
        }
        InfoPensionadoSolAfilWeb other = (InfoPensionadoSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.InfoPensionadoSolAfilWeb[ iCodigo=" + iCodigo + " ]";
    }

}

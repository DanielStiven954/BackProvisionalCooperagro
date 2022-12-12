/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Braya
 */
@Entity
@Table(name = "TIPO_ESTADO_SOLICITUD_CREDITO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstadoSolicitudCredito.findAll", query = "SELECT t FROM TipoEstadoSolicitudCredito t")
    , @NamedQuery(name = "TipoEstadoSolicitudCredito.findByICodigo", query = "SELECT t FROM TipoEstadoSolicitudCredito t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoEstadoSolicitudCredito.findByCDescripcion", query = "SELECT t FROM TipoEstadoSolicitudCredito t WHERE t.cDescripcion = :cDescripcion")})
public class TipoEstadoSolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_TIPO_ESTADO_SOL_CREDITO", sequenceName = "SEC_TIPO_ESTADO_SOL_CREDITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_TIPO_ESTADO_SOL_CREDITO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Size(max = 500)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    
    @OneToMany( mappedBy = "iEstadoSolicitud")
    private List<HistoriaSolicitudCredito> historiaSolicitudCreditoList;
    
    @OneToMany( mappedBy = "iEstadoSolicitud")
    private List<SolicitudCredito> solicitudCreditoList;

    public TipoEstadoSolicitudCredito() {
    }

    public TipoEstadoSolicitudCredito(Long iCodigo) {
        this.iCodigo = iCodigo;
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

    @XmlTransient
    public List<HistoriaSolicitudCredito> getHistoriaSolicitudCreditoList() {
        return historiaSolicitudCreditoList;
    }

    public void setHistoriaSolicitudCreditoList(List<HistoriaSolicitudCredito> historiaSolicitudCreditoList) {
        this.historiaSolicitudCreditoList = historiaSolicitudCreditoList;
    }

    @XmlTransient
    public List<SolicitudCredito> getSolicitudCreditoList() {
        return solicitudCreditoList;
    }

    public void setSolicitudCreditoList(List<SolicitudCredito> solicitudCreditoList) {
        this.solicitudCreditoList = solicitudCreditoList;
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
        if (!(object instanceof TipoEstadoSolicitudCredito)) {
            return false;
        }
        TipoEstadoSolicitudCredito other = (TipoEstadoSolicitudCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.wlosomec.domain.TipoEstadoSolicitudCredito[ iCodigo=" + iCodigo + " ]";
    }

}

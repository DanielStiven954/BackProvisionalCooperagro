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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YO
 */
@Entity
@Table(name = "HISTORIA_PQRSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaPqrsf.findAll", query = "SELECT h FROM HistoriaPqrsf h"),
    @NamedQuery(name = "HistoriaPqrsf.findByICodigo", query = "SELECT h FROM HistoriaPqrsf h WHERE h.iCodigo = :iCodigo"),
    @NamedQuery(name = "HistoriaPqrsf.findByCObservacion", query = "SELECT h FROM HistoriaPqrsf h WHERE h.cObservacion = :cObservacion"),
    @NamedQuery(name = "HistoriaPqrsf.findByFRegistro", query = "SELECT h FROM HistoriaPqrsf h WHERE h.fRegistro = :fRegistro")})
public class HistoriaPqrsf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SEC_HISTORIA_PQRSF", sequenceName = "SEC_HISTORIA_PQRSF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_HISTORIA_PQRSF")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Size(max = 4000)
    @Column(name = "C_OBSERVACION")
    private String cObservacion;
    @Column(name = "F_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fRegistro;
    @JoinColumn(name = "I_PQRSF", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pqrsf iPqrsf;
    @JoinColumn(name = "I_EST_PQRSF_OLD", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEstadoPqrsf iEstPqrsfOld;

    public HistoriaPqrsf() {
    }

    public HistoriaPqrsf(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCObservacion() {
        return cObservacion;
    }

    public void setCObservacion(String cObservacion) {
        this.cObservacion = cObservacion;
    }

    public Date getFRegistro() {
        return fRegistro;
    }

    public void setFRegistro(Date fRegistro) {
        this.fRegistro = fRegistro;
    }

    public Pqrsf getIPqrsf() {
        return iPqrsf;
    }

    public void setIPqrsf(Pqrsf iPqrsf) {
        this.iPqrsf = iPqrsf;
    }

    public TipoEstadoPqrsf getIEstPqrsfOld() {
        return iEstPqrsfOld;
    }

    public void setIEstPqrsfOld(TipoEstadoPqrsf iEstPqrsfOld) {
        this.iEstPqrsfOld = iEstPqrsfOld;
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
        if (!(object instanceof HistoriaPqrsf)) {
            return false;
        }
        HistoriaPqrsf other = (HistoriaPqrsf) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.HistoriaPqrsf[ iCodigo=" + iCodigo + " ]";
    }
    
}

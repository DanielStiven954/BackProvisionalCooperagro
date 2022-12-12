/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "CONSULTA_ANI_OLIMPIAIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaAniOlimpiait.findAll", query = "SELECT c FROM ConsultaAniOlimpiait c"),
    @NamedQuery(name = "ConsultaAniOlimpiait.findByICodigo", query = "SELECT c FROM ConsultaAniOlimpiait c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "ConsultaAniOlimpiait.findByITipoIdent", query = "SELECT c FROM ConsultaAniOlimpiait c WHERE c.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "ConsultaAniOlimpiait.findByCIdentificacion", query = "SELECT c FROM ConsultaAniOlimpiait c WHERE c.cIdentificacion = :cIdentificacion"),
    @NamedQuery(name = "ConsultaAniOlimpiait.findByIIdProceso", query = "SELECT c FROM ConsultaAniOlimpiait c WHERE c.iIdProceso = :iIdProceso"),
    @NamedQuery(name = "ConsultaAniOlimpiait.findByFFechaConsulta", query = "SELECT c FROM ConsultaAniOlimpiait c WHERE c.fFechaConsulta = :fFechaConsulta")})
public class ConsultaAniOlimpiait implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iConsAniOlimpiait", fetch = FetchType.EAGER)
    private List<RespuestaAniOlimpiait> respuestaAniOlimpiaitList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @NotNull
    @SequenceGenerator(name = "SEC_CONS_ANI_OLIMPIAIT", sequenceName = "SEC_CONS_ANI_OLIMPIAIT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CONS_ANI_OLIMPIAIT")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @NotNull
    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;
    
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    
    @NotNull
    @Column(name = "I_ID_PROCESO")
    private BigInteger iIdProceso;
    
    @NotNull
    @Column(name = "F_FECHA_CONSULTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaConsulta;

    public ConsultaAniOlimpiait() {
    }

    public ConsultaAniOlimpiait(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ConsultaAniOlimpiait(Long iCodigo, BigInteger iTipoIdent, String cIdentificacion, BigInteger iIdProceso, Date fFechaConsulta) {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.iIdProceso = iIdProceso;
        this.fFechaConsulta = fFechaConsulta;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigInteger getITipoIdent() {
        return iTipoIdent;
    }

    public void setITipoIdent(BigInteger iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public BigInteger getIIdProceso() {
        return iIdProceso;
    }

    public void setIIdProceso(BigInteger iIdProceso) {
        this.iIdProceso = iIdProceso;
    }

    public Date getFFechaConsulta() {
        return fFechaConsulta;
    }

    public void setFFechaConsulta(Date fFechaConsulta) {
        this.fFechaConsulta = fFechaConsulta;
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
        if (!(object instanceof ConsultaAniOlimpiait)) {
            return false;
        }
        ConsultaAniOlimpiait other = (ConsultaAniOlimpiait) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.ConsultaAniOlimpiait[ iCodigo=" + iCodigo + " ]";
    }

    @XmlTransient
    public List<RespuestaAniOlimpiait> getRespuestaAniOlimpiaitList() {
        return respuestaAniOlimpiaitList;
    }

    public void setRespuestaAniOlimpiaitList(List<RespuestaAniOlimpiait> respuestaAniOlimpiaitList) {
        this.respuestaAniOlimpiaitList = respuestaAniOlimpiaitList;
    }
    
}

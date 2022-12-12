/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "ESTADO_CEDULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCedula.findAll", query = "SELECT e FROM EstadoCedula e"),
    @NamedQuery(name = "EstadoCedula.findByICodigo", query = "SELECT e FROM EstadoCedula e WHERE e.iCodigo = :iCodigo"),
    @NamedQuery(name = "EstadoCedula.findByICodigoVigencia", query = "SELECT e FROM EstadoCedula e WHERE e.iCodigoVigencia = :iCodigoVigencia"),
    @NamedQuery(name = "EstadoCedula.findByCDescripcion", query = "SELECT e FROM EstadoCedula e WHERE e.cDescripcion = :cDescripcion")})
public class EstadoCedula implements Serializable {

    @OneToMany(mappedBy = "iEstadoCedula", fetch = FetchType.EAGER)
    private List<RespuestaAniOlimpiait> respuestaAniOlimpiaitList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @NotNull
    @Column(name = "I_CODIGO_VIGENCIA")
    private BigInteger iCodigoVigencia;
    
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    public EstadoCedula() {
    }

    public EstadoCedula(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public EstadoCedula(Long iCodigo, BigInteger iCodigoVigencia, String cDescripcion) {
        this.iCodigo = iCodigo;
        this.iCodigoVigencia = iCodigoVigencia;
        this.cDescripcion = cDescripcion;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigInteger getICodigoVigencia() {
        return iCodigoVigencia;
    }

    public void setICodigoVigencia(BigInteger iCodigoVigencia) {
        this.iCodigoVigencia = iCodigoVigencia;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
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
        if (!(object instanceof EstadoCedula)) {
            return false;
        }
        EstadoCedula other = (EstadoCedula) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.EstadoCedula[ iCodigo=" + iCodigo + " ]";
    }

    @XmlTransient
    public List<RespuestaAniOlimpiait> getRespuestaAniOlimpiaitList() {
        return respuestaAniOlimpiaitList;
    }

    public void setRespuestaAniOlimpiaitList(List<RespuestaAniOlimpiait> respuestaAniOlimpiaitList) {
        this.respuestaAniOlimpiaitList = respuestaAniOlimpiaitList;
    }
    
}

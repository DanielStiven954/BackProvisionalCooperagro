/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ETHOS-DEV02
 */
@Entity
@Table(name = "TIPOS_IMAGENES_PORTAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposImagenesPortal.findAll", query = "SELECT t FROM TiposImagenesPortal t")
    , @NamedQuery(name = "TiposImagenesPortal.findByICodigo", query = "SELECT t FROM TiposImagenesPortal t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TiposImagenesPortal.findByCDescripcion", query = "SELECT t FROM TiposImagenesPortal t WHERE t.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "TiposImagenesPortal.findByIAncho", query = "SELECT t FROM TiposImagenesPortal t WHERE t.iAncho = :iAncho")
    , @NamedQuery(name = "TiposImagenesPortal.findByIAlto", query = "SELECT t FROM TiposImagenesPortal t WHERE t.iAlto = :iAlto")
    , @NamedQuery(name = "TiposImagenesPortal.findByITamanio", query = "SELECT t FROM TiposImagenesPortal t WHERE t.iTamanio = :iTamanio")
    , @NamedQuery(name = "TiposImagenesPortal.findByCEstado", query = "SELECT t FROM TiposImagenesPortal t WHERE t.cEstado = :cEstado")})
public class TiposImagenesPortal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_TIPOS_IMAGENES_PORTAL", sequenceName = "SEC_TIPOS_IMAGENES_PORTAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_TIPOS_IMAGENES_PORTAL")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 4000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    
    @Column(name = "I_ANCHO")
    private BigInteger iAncho;

    @Column(name = "I_ALTO")
    private BigInteger iAlto;

    @Column(name = "I_TAMANIO")
    private BigInteger iTamanio;
    
    @Size(max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @OneToMany( mappedBy = "iTipoImagen")
    private List<ImagenesPortal> imagenesPortalList;

    public TiposImagenesPortal() {
    }

    public TiposImagenesPortal(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TiposImagenesPortal(Long iCodigo, String cDescripcion, BigInteger iAncho, BigInteger iAlto, BigInteger iTamanio) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        this.iTamanio = iTamanio;
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

    public BigInteger getIAncho() {
        return iAncho;
    }

    public void setIAncho(BigInteger iAncho) {
        this.iAncho = iAncho;
    }

    public BigInteger getIAlto() {
        return iAlto;
    }

    public void setIAlto(BigInteger iAlto) {
        this.iAlto = iAlto;
    }

    public BigInteger getITamanio() {
        return iTamanio;
    }

    public void setITamanio(BigInteger iTamanio) {
        this.iTamanio = iTamanio;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public List<ImagenesPortal> getImagenesPortalList() {
        return imagenesPortalList;
    }

    public void setImagenesPortalList(List<ImagenesPortal> imagenesPortalList) {
        this.imagenesPortalList = imagenesPortalList;
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
        if (!(object instanceof TiposImagenesPortal)) {
            return false;
        }
        TiposImagenesPortal other = (TiposImagenesPortal) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.TiposImagenesPortal[ iCodigo=" + iCodigo + " ]";
    }

}

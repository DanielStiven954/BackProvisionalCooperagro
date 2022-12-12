/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author Brayan F Silva R
 */
@Entity
@Table(name = "IMAGENES_PORTAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagenesPortal.findAll", query = "SELECT i FROM ImagenesPortal i")
    , @NamedQuery(name = "ImagenesPortal.findByICodigo", query = "SELECT i FROM ImagenesPortal i WHERE i.iCodigo = :iCodigo")
    , @NamedQuery(name = "ImagenesPortal.findByCDescripcion", query = "SELECT i FROM ImagenesPortal i WHERE i.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "ImagenesPortal.findByIAnchoMax", query = "SELECT i FROM ImagenesPortal i WHERE i.iAnchoMax = :iAnchoMax")
    , @NamedQuery(name = "ImagenesPortal.findByIAltoMax", query = "SELECT i FROM ImagenesPortal i WHERE i.iAltoMax = :iAltoMax")
    , @NamedQuery(name = "ImagenesPortal.findByITamanioMax", query = "SELECT i FROM ImagenesPortal i WHERE i.iTamanioMax = :iTamanioMax")
    , @NamedQuery(name = "ImagenesPortal.findByCEstado", query = "SELECT i FROM ImagenesPortal i WHERE i.cEstado = :cEstado")
    , @NamedQuery(name = "ImagenesPortal.findByCNombreImg", query = "SELECT i FROM ImagenesPortal i WHERE i.cNombreImg = :cNombreImg")
    , @NamedQuery(name = "ImagenesPortal.findByCRutaExt", query = "SELECT i FROM ImagenesPortal i WHERE i.cRutaExt = :cRutaExt")})
public class ImagenesPortal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_IMAGENES_PORTAL", sequenceName = "SEC_IMAGENES_PORTAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_IMAGENES_PORTAL")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 4000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    @Column(name = "I_ANCHO_MAX")
    private BigInteger iAnchoMax;

    @Column(name = "I_ALTO_MAX")
    private BigInteger iAltoMax;

    @Column(name = "I_TAMANIO_MAX")
    private BigInteger iTamanioMax;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    @Size(min = 1, max = 4000)
    @Column(name = "C_NOMBRE_IMG")
    private String cNombreImg;

    @Size(min = 1, max = 4000)
    @Column(name = "C_RUTA_EXT")
    private String cRutaExt;

    @JoinColumn(name = "I_TIPO_IMAGEN", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TiposImagenesPortal iTipoImagen;

    public ImagenesPortal() {
    }

    public ImagenesPortal(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ImagenesPortal(Long iCodigo, String cDescripcion, String cEstado, String cNombreImg, String cRutaExt) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cEstado = cEstado;
        this.cNombreImg = cNombreImg;
        this.cRutaExt = cRutaExt;
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

    public BigInteger getIAnchoMax() {
        return iAnchoMax;
    }

    public void setIAnchoMax(BigInteger iAnchoMax) {
        this.iAnchoMax = iAnchoMax;
    }

    public BigInteger getIAltoMax() {
        return iAltoMax;
    }

    public void setIAltoMax(BigInteger iAltoMax) {
        this.iAltoMax = iAltoMax;
    }

    public BigInteger getITamanioMax() {
        return iTamanioMax;
    }

    public void setITamanioMax(BigInteger iTamanioMax) {
        this.iTamanioMax = iTamanioMax;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getCNombreImg() {
        return cNombreImg;
    }

    public void setCNombreImg(String cNombreImg) {
        this.cNombreImg = cNombreImg;
    }

    public String getCRutaExt() {
        return cRutaExt;
    }

    public void setCRutaExt(String cRutaExt) {
        this.cRutaExt = cRutaExt;
    }

    public TiposImagenesPortal getITipoImagen() {
        return iTipoImagen;
    }

    public void setITipoImagen(TiposImagenesPortal iTipoImagen) {
        this.iTipoImagen = iTipoImagen;
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
        if (!(object instanceof ImagenesPortal)) {
            return false;
        }
        ImagenesPortal other = (ImagenesPortal) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.ImagenesPortal[ iCodigo=" + iCodigo + " ]";
    }

}

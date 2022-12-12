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
import javax.persistence.Lob;
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
@Table(name = "DOCUMENTO_PQRSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoPqrsf.findAll", query = "SELECT d FROM DocumentoPqrsf d"),
    @NamedQuery(name = "DocumentoPqrsf.findByICodigo", query = "SELECT d FROM DocumentoPqrsf d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "DocumentoPqrsf.findByCNombre", query = "SELECT d FROM DocumentoPqrsf d WHERE d.cNombre = :cNombre"),
    @NamedQuery(name = "DocumentoPqrsf.findByCTipoArchivo", query = "SELECT d FROM DocumentoPqrsf d WHERE d.cTipoArchivo = :cTipoArchivo")})
public class DocumentoPqrsf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_DOC_PQRSF", sequenceName = "SEC_DOC_PQRSF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DOC_PQRSF")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "C_BASE64")
    private byte[] cBase64;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_TIPO_ARCHIVO")
    private String cTipoArchivo;
    @JoinColumn(name = "I_PQRSF", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pqrsf iPqrsf;

    public DocumentoPqrsf() {
    }

    public DocumentoPqrsf(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public DocumentoPqrsf(Long iCodigo, String cNombre, byte[] cBase64, String cTipoArchivo) {
        this.iCodigo = iCodigo;
        this.cNombre = cNombre;
        this.cBase64 = cBase64;
        this.cTipoArchivo = cTipoArchivo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public byte[] getCBase64() {
        return cBase64;
    }

    public void setCBase64(byte[] cBase64) {
        this.cBase64 = cBase64;
    }

    public String getCTipoArchivo() {
        return cTipoArchivo;
    }

    public void setCTipoArchivo(String cTipoArchivo) {
        this.cTipoArchivo = cTipoArchivo;
    }

    public Pqrsf getIPqrsf() {
        return iPqrsf;
    }

    public void setIPqrsf(Pqrsf iPqrsf) {
        this.iPqrsf = iPqrsf;
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
        if (!(object instanceof DocumentoPqrsf)) {
            return false;
        }
        DocumentoPqrsf other = (DocumentoPqrsf) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentoPqrsf{" + "iCodigo=" + iCodigo + ", cNombre=" + cNombre + ", cBase64=" + cBase64 + ", cTipoArchivo=" + cTipoArchivo + ", iPqrsf=" + iPqrsf + '}';
    }

}

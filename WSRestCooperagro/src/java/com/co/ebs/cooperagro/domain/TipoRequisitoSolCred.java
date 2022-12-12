/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Brayan F Silva R
 */
@Entity
@Table(name = "TIPO_REQUISITO_SOL_CRED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRequisitoSolCred.findAll", query = "SELECT t FROM TipoRequisitoSolCred t"),
    @NamedQuery(name = "TipoRequisitoSolCred.findByICodigo", query = "SELECT t FROM TipoRequisitoSolCred t WHERE t.iCodigo = :iCodigo"),
    @NamedQuery(name = "TipoRequisitoSolCred.findByCNombreRequisito", query = "SELECT t FROM TipoRequisitoSolCred t WHERE t.cNombreRequisito = :cNombreRequisito"),
    @NamedQuery(name = "TipoRequisitoSolCred.findByCDescripcion", query = "SELECT t FROM TipoRequisitoSolCred t WHERE t.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "TipoRequisitoSolCred.findByITamanioMax", query = "SELECT t FROM TipoRequisitoSolCred t WHERE t.iTamanioMax = :iTamanioMax"),
    @NamedQuery(name = "TipoRequisitoSolCred.findByIOrden", query = "SELECT t FROM TipoRequisitoSolCred t WHERE t.iOrden = :iOrden"),
    @NamedQuery(name = "TipoRequisitoSolCred.findByCObligatorio", query = "SELECT t FROM TipoRequisitoSolCred t WHERE t.cObligatorio = :cObligatorio"),
    @NamedQuery(name = "TipoRequisitoSolCred.findByCEstado", query = "SELECT t FROM TipoRequisitoSolCred t WHERE t.cEstado = :cEstado")})
public class TipoRequisitoSolCred implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_TIPO_REQ_SOL_CRED", sequenceName = "SEC_TIPO_REQ_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_TIPO_REQ_SOL_CRED")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 100)
    @Column(name = "C_NOMBRE_REQUISITO")
    private String cNombreRequisito;

    @Size(min = 1, max = 100)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    @Column(name = "I_TAMANIO_MAX")
    private BigInteger iTamanioMax;

    @Column(name = "I_ORDEN")
    private BigInteger iOrden;

    @Size(max = 2)
    @Column(name = "C_OBLIGATORIO")
    private String cObligatorio;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    @OneToMany( mappedBy = "iTipoReqSolCred")
    private List<DocumentoSolicitudCredito> documentoSolicitudCreditoList;

    public TipoRequisitoSolCred() {
    }

    public TipoRequisitoSolCred(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoRequisitoSolCred(Long iCodigo, String cNombreRequisito, String cDescripcion, String cEstado) {
        this.iCodigo = iCodigo;
        this.cNombreRequisito = cNombreRequisito;
        this.cDescripcion = cDescripcion;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombreRequisito() {
        return cNombreRequisito;
    }

    public void setCNombreRequisito(String cNombreRequisito) {
        this.cNombreRequisito = cNombreRequisito;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public BigInteger getITamanioMax() {
        return iTamanioMax;
    }

    public void setITamanioMax(BigInteger iTamanioMax) {
        this.iTamanioMax = iTamanioMax;
    }

    public BigInteger getIOrden() {
        return iOrden;
    }

    public void setIOrden(BigInteger iOrden) {
        this.iOrden = iOrden;
    }

    public String getCObligatorio() {
        return cObligatorio;
    }

    public void setCObligatorio(String cObligatorio) {
        this.cObligatorio = cObligatorio;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public List<DocumentoSolicitudCredito> getDocumentoSolicitudCreditoList() {
        return documentoSolicitudCreditoList;
    }

    public void setDocumentoSolicitudCreditoList(List<DocumentoSolicitudCredito> documentoSolicitudCreditoList) {
        this.documentoSolicitudCreditoList = documentoSolicitudCreditoList;
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
        if (!(object instanceof TipoRequisitoSolCred)) {
            return false;
        }
        TipoRequisitoSolCred other = (TipoRequisitoSolCred) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.wlosomec.domain.TipoRequisitoSolCred[ iCodigo=" + iCodigo + " ]";
    }

}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PQRSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqrsf.findAll", query = "SELECT p FROM Pqrsf p"),
    @NamedQuery(name = "Pqrsf.findByICodigo", query = "SELECT p FROM Pqrsf p WHERE p.iCodigo = :iCodigo"),
    @NamedQuery(name = "Pqrsf.findByCNumRadic", query = "SELECT p FROM Pqrsf p WHERE p.cNumRadic = :cNumRadic"),
    @NamedQuery(name = "Pqrsf.findByITipoIdent", query = "SELECT p FROM Pqrsf p WHERE p.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "Pqrsf.findByCIdentificacion", query = "SELECT p FROM Pqrsf p WHERE p.cIdentificacion = :cIdentificacion"),
    @NamedQuery(name = "Pqrsf.findByCEmail", query = "SELECT p FROM Pqrsf p WHERE p.cEmail = :cEmail"),
    @NamedQuery(name = "Pqrsf.findByCDescPqrsf", query = "SELECT p FROM Pqrsf p WHERE p.cDescPqrsf = :cDescPqrsf"),
    @NamedQuery(name = "Pqrsf.findByFFechaSolictud", query = "SELECT p FROM Pqrsf p WHERE p.fFechaSolictud = :fFechaSolictud"),
    @NamedQuery(name = "Pqrsf.findByCIp", query = "SELECT p FROM Pqrsf p WHERE p.cIp = :cIp"),
    @NamedQuery(name = "Pqrsf.findByCNavegador", query = "SELECT p FROM Pqrsf p WHERE p.cNavegador = :cNavegador"),
    @NamedQuery(name = "Pqrsf.findByCNombre", query = "SELECT p FROM Pqrsf p WHERE p.cNombre = :cNombre")})
public class Pqrsf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PQRSF", sequenceName = "SEC_PQRSF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PQRSF")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Size(max = 1000)
    @Column(name = "C_NUM_RADIC")
    private String cNumRadic;
    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;
    @Size(max = 20)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    @Size(max = 100)
    @Column(name = "C_EMAIL")
    private String cEmail;
    @Size(max = 4000)
    @Column(name = "C_DESC_PQRSF")
    private String cDescPqrsf;
    @Column(name = "F_FECHA_SOLICTUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaSolictud;
    @Size(max = 1000)
    @Column(name = "C_IP")
    private String cIp;
    @Size(max = 1000)
    @Column(name = "C_NAVEGADOR")
    private String cNavegador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @JoinColumn(name = "I_SUB_CATEGORIA", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubCategoriaPqrsf iSubCategoria;
    @JoinColumn(name = "I_TIPO_CANAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoCanal iTipoCanal;
    @JoinColumn(name = "I_TIPO_ESTADO_PQRSF", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEstadoPqrsf iTipoEstadoPqrsf;
    @JoinColumn(name = "I_TIPO_PQRSF", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoPqrsf iTipoPqrsf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPqrsf", fetch = FetchType.EAGER)
    private List<DocumentoPqrsf> documentoPqrsfList;

    public Pqrsf() {
    }

    public Pqrsf(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Pqrsf(Long iCodigo, String cNombre) {
        this.iCodigo = iCodigo;
        this.cNombre = cNombre;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNumRadic() {
        return cNumRadic;
    }

    public void setCNumRadic(String cNumRadic) {
        this.cNumRadic = cNumRadic;
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

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCDescPqrsf() {
        return cDescPqrsf;
    }

    public void setCDescPqrsf(String cDescPqrsf) {
        this.cDescPqrsf = cDescPqrsf;
    }

    public Date getFFechaSolictud() {
        return fFechaSolictud;
    }

    public void setFFechaSolictud(Date fFechaSolictud) {
        this.fFechaSolictud = fFechaSolictud;
    }

    public String getCIp() {
        return cIp;
    }

    public void setCIp(String cIp) {
        this.cIp = cIp;
    }

    public String getCNavegador() {
        return cNavegador;
    }

    public void setCNavegador(String cNavegador) {
        this.cNavegador = cNavegador;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public SubCategoriaPqrsf getISubCategoria() {
        return iSubCategoria;
    }

    public void setISubCategoria(SubCategoriaPqrsf iSubCategoria) {
        this.iSubCategoria = iSubCategoria;
    }

    public TipoCanal getITipoCanal() {
        return iTipoCanal;
    }

    public void setITipoCanal(TipoCanal iTipoCanal) {
        this.iTipoCanal = iTipoCanal;
    }

    public TipoEstadoPqrsf getITipoEstadoPqrsf() {
        return iTipoEstadoPqrsf;
    }

    public void setITipoEstadoPqrsf(TipoEstadoPqrsf iTipoEstadoPqrsf) {
        this.iTipoEstadoPqrsf = iTipoEstadoPqrsf;
    }

    public TipoPqrsf getITipoPqrsf() {
        return iTipoPqrsf;
    }

    public void setITipoPqrsf(TipoPqrsf iTipoPqrsf) {
        this.iTipoPqrsf = iTipoPqrsf;
    }

    @XmlTransient
    public List<DocumentoPqrsf> getDocumentoPqrsfList() {
        return documentoPqrsfList;
    }

    public void setDocumentoPqrsfList(List<DocumentoPqrsf> documentoPqrsfList) {
        this.documentoPqrsfList = documentoPqrsfList;
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
        if (!(object instanceof Pqrsf)) {
            return false;
        }
        Pqrsf other = (Pqrsf) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.Pqrsf[ iCodigo=" + iCodigo + " ]";
    }
    
}

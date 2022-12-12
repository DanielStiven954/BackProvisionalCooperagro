/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ETHOS-DEV02
 */
@Entity
@Table(name = "PARAMETROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")
    , @NamedQuery(name = "Parametros.findByICodigo", query = "SELECT p FROM Parametros p WHERE p.iCodigo = :iCodigo")
    , @NamedQuery(name = "Parametros.findByCDescripcion", query = "SELECT p FROM Parametros p WHERE p.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "Parametros.findByCValor", query = "SELECT p FROM Parametros p WHERE p.cValor = :cValor")
    , @NamedQuery(name = "Parametros.findByITipoDato", query = "SELECT p FROM Parametros p WHERE p.iTipoDato = :iTipoDato")
    , @NamedQuery(name = "Parametros.findByCEstado", query = "SELECT p FROM Parametros p WHERE p.cEstado = :cEstado")
    , @NamedQuery(name = "Parametros.findByCNombre", query = "SELECT p FROM Parametros p WHERE p.cNombre = :cNombre")})
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PARAMETROS", sequenceName = "SEC_PARAMETROS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PARAMETROS")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Size(min = 1, max = 200)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
     
    @Size(min = 1, max = 200)
    @Column(name = "C_VALOR")
    private String cValor;
      
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @Size(max = 200)
    @Column(name = "C_NOMBRE")
    private String cNombre;

    @JoinColumn(name = "I_TIPO_DATO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoDato iTipoDato;

    public Parametros() {
    }

    public Parametros(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Parametros(Long iCodigo, String cDescripcion, String cValor, BigInteger iTipoDato, String cEstado) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cValor = cValor;
        this.cEstado = cEstado;
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

    public String getCValor() {
        return cValor;
    }

    public void setCValor(String cValor) {
        this.cValor = cValor;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
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
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.Parametros[ iCodigo=" + iCodigo + " ]";
    }

    public TipoDato getITipoDato() {
        return iTipoDato;
    }

    public void setITipoDato(TipoDato iTipoDato) {
        this.iTipoDato = iTipoDato;
    }

}

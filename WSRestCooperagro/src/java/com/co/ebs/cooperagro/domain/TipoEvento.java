/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TIPO_EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t")
    , @NamedQuery(name = "TipoEvento.findByICodigo", query = "SELECT t FROM TipoEvento t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoEvento.findByCDescripcion", query = "SELECT t FROM TipoEvento t WHERE t.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "TipoEvento.findByCEstado", query = "SELECT t FROM TipoEvento t WHERE t.cEstado = :cEstado")})
public class TipoEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_TIPO_EVENTO", sequenceName = "SEC_TIPO_EVENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_TIPO_EVENTO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 50)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
 
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @OneToMany(mappedBy = "iTipoEvento")
    private List<Evento> eventoList;

    public TipoEvento() {
    }

    public TipoEvento(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoEvento(Long iCodigo, String cDescripcion, String cEstado) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
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

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
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
        if (!(object instanceof TipoEvento)) {
            return false;
        }
        TipoEvento other = (TipoEvento) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.TipoEvento[ iCodigo=" + iCodigo + " ]";
    }
    
}

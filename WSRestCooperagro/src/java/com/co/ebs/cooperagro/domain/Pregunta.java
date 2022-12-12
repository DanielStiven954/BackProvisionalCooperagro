/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author ETHOS-DEV02
 */
@Entity
@Table(name = "PREGUNTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByICodigo", query = "SELECT p FROM Pregunta p WHERE p.iCodigo = :iCodigo")
    , @NamedQuery(name = "Pregunta.findByCDescripcion", query = "SELECT p FROM Pregunta p WHERE p.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "Pregunta.findByCEstado", query = "SELECT p FROM Pregunta p WHERE p.cEstado = :cEstado")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PREGUNTA", sequenceName = "SEC_PREGUNTA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PREGUNTA")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Size(min = 1, max = 4000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    
    @OneToMany( mappedBy = "iPregunta")
    private List<PreguntaUsuario> preguntaUsuarioList;

    public Pregunta() {
    }

    public Pregunta(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Pregunta(Long iCodigo, String cDescripcion, String cEstado) {
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
    public List<PreguntaUsuario> getPreguntaUsuarioList() {
        return preguntaUsuarioList;
    }

    public void setPreguntaUsuarioList(List<PreguntaUsuario> preguntaUsuarioList) {
        this.preguntaUsuarioList = preguntaUsuarioList;
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
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.Pregunta[ iCodigo=" + iCodigo + " ]";
    }
    
}

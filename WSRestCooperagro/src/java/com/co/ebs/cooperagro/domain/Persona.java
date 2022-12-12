package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Brian Cardenas
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByICodigo", query = "SELECT p FROM Persona p WHERE p.iCodigo = :iCodigo"),
    @NamedQuery(name = "Persona.findByiTipoIdent", query = "SELECT p FROM Persona p WHERE p.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "Persona.findByCIdentificacion", query = "SELECT p FROM Persona p WHERE p.cIdentificacion = :cIdentificacion and p.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "Persona.findByCEstado", query = "SELECT p FROM Persona p WHERE p.cEstado = :cEstado")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;

    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;

    @Size(min = 1, max = 500)
    @Column(name = "C_NOMBRES")
    private String cNombres;

    @Size(min = 1, max = 500)
    @Column(name = "C_APELLIDOS")
    private String cApellidos;

    @Column(name = "C_ESTADO")
    private String cEstado;

    //Join's
    @OneToMany( mappedBy = "iPersona")
    private List<Usuario> usuarioList;

    @OneToMany( mappedBy = "iPersona")
    private List<SolicitudCredito> solicitudCreditoList;

    //CAMPOS TRANSIENT
    transient private String sMsj;
    transient private Boolean bRta;

    public Persona() {
    }

    public Persona(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Persona(Long iCodigo, BigInteger iTipoIdent, String cIdentificacion, String cEstado) {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.cEstado = cEstado;
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

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getCApellidos() {
        return cApellidos;
    }

    public void setCApellidos(String cApellidos) {
        this.cApellidos = cApellidos;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<SolicitudCredito> getSolicitudCreditoList() {
        return solicitudCreditoList;
    }

    public void setSolicitudCreditoList(List<SolicitudCredito> solicitudCreditoList) {
        this.solicitudCreditoList = solicitudCreditoList;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.Persona[ iCodigo=" + iCodigo + " ]";
    }*/

    @Override
    public String toString() {
        return "Persona{" + "iCodigo=" + iCodigo + ", iTipoIdent=" + iTipoIdent + ", cIdentificacion=" + cIdentificacion + ", cNombres=" + cNombres + ", cApellidos=" + cApellidos + ", cEstado=" + cEstado + ", usuarioList=" + usuarioList + ", solicitudCreditoList=" + solicitudCreditoList + ", sMsj=" + sMsj + ", bRta=" + bRta + '}';
    }
    
    

}

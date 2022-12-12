package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author Brian Cardenas
 */
@Entity
@Table(name = "ACCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a")
    , @NamedQuery(name = "Acceso.findByICodigo", query = "SELECT a FROM Acceso a WHERE a.iCodigo = :iCodigo")
    , @NamedQuery(name = "Acceso.findByCClave", query = "SELECT a FROM Acceso a WHERE a.cClave = :cClave")
    , @NamedQuery(name = "Acceso.findByFInicio", query = "SELECT a FROM Acceso a WHERE a.fInicio = :fInicio")
    , @NamedQuery(name = "Acceso.findByFFin", query = "SELECT a FROM Acceso a WHERE a.fFin = :fFin")
    , @NamedQuery(name = "Acceso.findByIUsuario", query = "SELECT a FROM Acceso a WHERE a.iUsuario = :iUsuario")
    , @NamedQuery(name = "Acceso.findByITransaccion", query = "SELECT a FROM Acceso a WHERE a.iTransaccion = :iTransaccion")
    , @NamedQuery(name = "Acceso.findByCEstado", query = "SELECT a FROM Acceso a WHERE a.cEstado = :cEstado")
    , @NamedQuery(name = "Acceso.findByCLlaveSeguridad", query = "SELECT a FROM Acceso a WHERE a.cLlaveSeguridad = :cLlaveSeguridad")
    , @NamedQuery(name = "findByIUsuarioAndiTransaccion", query = "SELECT a FROM Acceso a WHERE a.iUsuario = :iUsuario AND a.iTransaccion = :iTransaccion")
})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_ACCESO", sequenceName = "SEC_ACCESO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ACCESO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "C_CLAVE")
    private String cClave;

    @Column(name = "F_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fInicio;

    @Column(name = "F_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFin;

    @Column(name = "C_ESTADO")
    private String cEstado;

    @Column(name = "C_LLAVE_SEGURIDAD")
    private String cLlaveSeguridad;

    @JoinColumn(name = "I_TRANSACCION", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)    
    private Transaccion iTransaccion;

    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iUsuario;

    public Acceso() {
    }

    public Acceso(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Acceso(Long iCodigo, String cClave, Date fInicio, BigInteger iUsuario, BigInteger iTransaccion, String cEstado, String cLlaveSeguridad) {
        this.iCodigo = iCodigo;
        this.cClave = cClave;
        this.fInicio = fInicio;
        this.cEstado = cEstado;
        this.cLlaveSeguridad = cLlaveSeguridad;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCClave() {
        return cClave;
    }

    public void setCClave(String cClave) {
        this.cClave = cClave;
    }

    public Date getFInicio() {
        return fInicio;
    }

    public void setFInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getFFin() {
        return fFin;
    }

    public void setFFin(Date fFin) {
        this.fFin = fFin;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getCLlaveSeguridad() {
        return cLlaveSeguridad;
    }

    public void setCLlaveSeguridad(String cLlaveSeguridad) {
        this.cLlaveSeguridad = cLlaveSeguridad;
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
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.Acceso[ iCodigo=" + iCodigo + " ]";
    }

    public Transaccion getITransaccion() {
        return iTransaccion;
    }

    public void setITransaccion(Transaccion iTransaccion) {
        this.iTransaccion = iTransaccion;
    }

    public Usuario getIUsuario() {
        return iUsuario;
    }

    public void setIUsuario(Usuario iUsuario) {
        this.iUsuario = iUsuario;
    }

}

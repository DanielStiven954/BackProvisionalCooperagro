
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brian Cardenas
 */
@Entity
@Table(name = "PREGUNTA_CREA_USU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaCreaUsu.findAll", query = "SELECT p FROM PreguntaCreaUsu p")
    , @NamedQuery(name = "PreguntaCreaUsu.findByICodigo", query = "SELECT p FROM PreguntaCreaUsu p WHERE p.iCodigo = :iCodigo")
    , @NamedQuery(name = "PreguntaCreaUsu.findByCDescripcion", query = "SELECT p FROM PreguntaCreaUsu p WHERE p.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "PreguntaCreaUsu.findByCCampo", query = "SELECT p FROM PreguntaCreaUsu p WHERE p.cCampo = :cCampo")
    , @NamedQuery(name = "PreguntaCreaUsu.findByCEstado", query = "SELECT p FROM PreguntaCreaUsu p WHERE p.cEstado = :cEstado")})
public class PreguntaCreaUsu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PREGUNTA_CREA_USU", sequenceName = "SEC_PREGUNTA_CREA_USU", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PREGUNTA_CREA_USU")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 4000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;

    @Size(min = 1, max = 100)
    @Column(name = "C_CAMPO")
    private String cCampo;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    //TRANSIENT
    transient private List<String> listRtasPreg;

    public PreguntaCreaUsu() {
    }

    public PreguntaCreaUsu(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public PreguntaCreaUsu(Long iCodigo, String cDescripcion, String cCampo, String cEstado) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cCampo = cCampo;
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

    public String getCCampo() {
        return cCampo;
    }

    public void setCCampo(String cCampo) {
        this.cCampo = cCampo;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iCodigo != null ? iCodigo.hashCode() : 0);
        return hash;
    }

    public List<String> getListRtasPreg() {
        return listRtasPreg;
    }

    public void setListRtasPreg(List<String> listRtasPreg) {
        this.listRtasPreg = listRtasPreg;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaCreaUsu)) {
            return false;
        }
        PreguntaCreaUsu other = (PreguntaCreaUsu) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.PreguntaCreaUsu[ iCodigo=" + iCodigo + " ]";
    }

}

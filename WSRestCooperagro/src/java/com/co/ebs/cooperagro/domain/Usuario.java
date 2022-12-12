package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Brian Cardenas
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByICodigo", query = "SELECT u FROM Usuario u WHERE u.iCodigo = :iCodigo"),
    @NamedQuery(name = "Usuario.findByIPersona", query = "SELECT u FROM Usuario u WHERE u.iPersona = :iPersona"),
    @NamedQuery(name = "Usuario.findByIPerfil", query = "SELECT u FROM Usuario u WHERE u.iPerfil = :iPerfil"),
    @NamedQuery(name = "Usuario.findByCEstado", query = "SELECT u FROM Usuario u WHERE u.cEstado = :cEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_USUARIO", sequenceName = "SEC_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_USUARIO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona iPersona;

    @JoinColumn(name = "I_PERFIL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoPerfil iPerfil;

    @Column(name = "C_ESTADO")
    private String cEstado;

    //JOIN
    @OneToMany( mappedBy = "iUsuario")
    private List<PerfilTransaccional> perfilTransaccionalList;

    @OneToMany( mappedBy = "iUsuario")
    private List<Evento> eventoList;

    @OneToMany( mappedBy = "iUsuario")
    private List<AuditoriaClave> auditoriaClaveList;

    @OneToMany( mappedBy = "iUsuario")
    private List<Acceso> accesoList;

    @OneToMany( mappedBy = "iUsuario")
    private List<SessionUsuario> sessionUsuarioList;

    @OneToMany( mappedBy = "iUsuario")
    private List<AccesoUsuario> accesoUsuarioList;

    @OneToMany( mappedBy = "iUsuario")
    private List<NotificacionUsuario> notificacionUsuarioList;

    @OneToMany( mappedBy = "iUsuario")
    private List<PreguntaUsuario> preguntaUsuarioList;

    @OneToMany(mappedBy = "iUsuarioAsesor")
    private List<SolicitudAfiliacionWeb> solicitudAfiliacionWebList;

    @OneToMany( mappedBy = "iUsuarioCreador", fetch = FetchType.EAGER)
    private List<GestionPqrsf> gestionPqrsfList;

    //CAMPOS TRANSIENT
    transient private int cCodMensaje;
    transient private String sMensaje;
    transient private Boolean bRta;

    public Usuario() {
    }

    public Usuario(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Usuario(Long iCodigo, Persona iPersona, TipoPerfil iPerfil, String cEstado, int cCodMensaje, String sMensaje) {
        this.iCodigo = iCodigo;
        this.iPersona = iPersona;
        this.iPerfil = iPerfil;
        this.cEstado = cEstado;
        this.cCodMensaje = cCodMensaje;
        this.sMensaje = sMensaje;
    }

    public String getsMensaje() {
        return sMensaje;
    }

    public void setsMensaje(String sMensaje) {
        this.sMensaje = sMensaje;
    }

    public int getcCodMensaje() {
        return cCodMensaje;
    }

    public void setcCodMensaje(int cCodMensaje) {
        this.cCodMensaje = cCodMensaje;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
    }

    public TipoPerfil getIPerfil() {
        return iPerfil;
    }

    public void setIPerfil(TipoPerfil iPerfil) {
        this.iPerfil = iPerfil;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    @XmlTransient
    public List<PerfilTransaccional> getPerfilTransaccionalList() {
        return perfilTransaccionalList;
    }

    public void setPerfilTransaccionalList(List<PerfilTransaccional> perfilTransaccionalList) {
        this.perfilTransaccionalList = perfilTransaccionalList;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<AuditoriaClave> getAuditoriaClaveList() {
        return auditoriaClaveList;
    }

    public void setAuditoriaClaveList(List<AuditoriaClave> auditoriaClaveList) {
        this.auditoriaClaveList = auditoriaClaveList;
    }

    @XmlTransient
    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    @XmlTransient
    public List<SessionUsuario> getSessionUsuarioList() {
        return sessionUsuarioList;
    }

    public void setSessionUsuarioList(List<SessionUsuario> sessionUsuarioList) {
        this.sessionUsuarioList = sessionUsuarioList;
    }

    @XmlTransient
    public List<AccesoUsuario> getAccesoUsuarioList() {
        return accesoUsuarioList;
    }

    public void setAccesoUsuarioList(List<AccesoUsuario> accesoUsuarioList) {
        this.accesoUsuarioList = accesoUsuarioList;
    }

    @XmlTransient
    public List<NotificacionUsuario> getNotificacionUsuarioList() {
        return notificacionUsuarioList;
    }

    public void setNotificacionUsuarioList(List<NotificacionUsuario> notificacionUsuarioList) {
        this.notificacionUsuarioList = notificacionUsuarioList;
    }

    @XmlTransient
    public List<PreguntaUsuario> getPreguntaUsuarioList() {
        return preguntaUsuarioList;
    }

    public void setPreguntaUsuarioList(List<PreguntaUsuario> preguntaUsuarioList) {
        this.preguntaUsuarioList = preguntaUsuarioList;
    }

    @XmlTransient
    public List<SolicitudAfiliacionWeb> getSolicitudAfiliacionWebList() {
        return solicitudAfiliacionWebList;
    }

    public void setSolicitudAfiliacionWebList(List<SolicitudAfiliacionWeb> solicitudAfiliacionWebList) {
        this.solicitudAfiliacionWebList = solicitudAfiliacionWebList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
        return "com.co.ebs.cooperagro.domain.Usuario[ iCodigo=" + iCodigo + " ]";
    }*/

    @Override
    public String toString() {
        return "Usuario{" + "gestionPqrsfList=" + gestionPqrsfList + ", iCodigo=" + iCodigo + ", iPersona=" + iPersona + ", iPerfil=" + iPerfil + ", cEstado=" + cEstado + ", perfilTransaccionalList=" + perfilTransaccionalList + ", eventoList=" + eventoList + ", auditoriaClaveList=" + auditoriaClaveList + ", accesoList=" + accesoList + ", sessionUsuarioList=" + sessionUsuarioList + ", accesoUsuarioList=" + accesoUsuarioList + ", notificacionUsuarioList=" + notificacionUsuarioList + ", preguntaUsuarioList=" + preguntaUsuarioList + ", solicitudAfiliacionWebList=" + solicitudAfiliacionWebList + ", cCodMensaje=" + cCodMensaje + ", sMensaje=" + sMensaje + ", bRta=" + bRta + '}';
    }
    
    

    @XmlTransient
    public List<GestionPqrsf> getGestionPqrsfList() {
        return gestionPqrsfList;
    }

    public void setGestionPqrsfList(List<GestionPqrsf> gestionPqrsfList) {
        this.gestionPqrsfList = gestionPqrsfList;
    }
}

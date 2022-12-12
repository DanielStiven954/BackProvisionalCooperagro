/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "SOLICITUD_AFILIACION_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudAfiliacionWeb.findAll", query = "SELECT s FROM SolicitudAfiliacionWeb s")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByICodigo", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.iCodigo = :iCodigo")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByFFechaSolicitud", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.fFechaSolicitud = :fFechaSolicitud")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByCTipoIngreso", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.cTipoIngreso = :cTipoIngreso")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByFFechaRetiro", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.fFechaRetiro = :fFechaRetiro")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByFFechaRadicado", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.fFechaRadicado = :fFechaRadicado")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByICiudad", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.iCiudad = :iCiudad")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByFFechaVerfDocs", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.fFechaVerfDocs = :fFechaVerfDocs")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByCObsVerfDocs", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.cObsVerfDocs = :cObsVerfDocs")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByFFechaVerfInf", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.fFechaVerfInf = :fFechaVerfInf")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByCObsVerfInf", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.cObsVerfInf = :cObsVerfInf")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByFFechaVinculacion", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.fFechaVinculacion = :fFechaVinculacion")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByICodAsignado", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.iCodAsignado = :iCodAsignado")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByINumActa", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.iNumActa = :iNumActa")
    , @NamedQuery(name = "SolicitudAfiliacionWeb.findByCComentarios", query = "SELECT s FROM SolicitudAfiliacionWeb s WHERE s.cComentarios = :cComentarios")})
public class SolicitudAfiliacionWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_SOLICITUD_AFILIACION_WEB", sequenceName = "SEQ_SOLICITUD_AFILIACION_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUD_AFILIACION_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "F_FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaSolicitud;
    @Size(max = 5)
    @Column(name = "C_TIPO_INGRESO")
    private String cTipoIngreso;
    @Column(name = "F_FECHA_RETIRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRetiro;
    @Column(name = "F_FECHA_RADICADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRadicado;
    @Column(name = "F_FECHA_VERF_DOCS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaVerfDocs;
    @Size(max = 500)
    @Column(name = "C_OBS_VERF_DOCS")
    private String cObsVerfDocs;
    @Column(name = "F_FECHA_VERF_INF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaVerfInf;
    @Size(max = 500)
    @Column(name = "C_OBS_VERF_INF")
    private String cObsVerfInf;
    @Column(name = "F_FECHA_VINCULACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaVinculacion;
    @Size(max = 500)
    @Column(name = "C_COMENTARIOS")
    private String cComentarios;
    @Size(max = 1000)
    @Column(name = "C_NUM_RADIC")
    private String cNumRadic;
    @Column(name = "I_CIUDAD")
    private Long iCiudad;
    @Column(name = "I_COD_ASIGNADO")
    private Long iCodAsignado;
    @Column(name = "I_NUM_ACTA")
    private Long iNumActa;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<DocumentoSolAfilWeb> documentosSolAfilWebList;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<InfoConyugeSolAfilWeb> infoConyugeSolAfilWebList;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<ActEconomicaSolAfilWeb> actEconomicaSolAfilWebList;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<OperMonedaExtSolAfilWeb> operMonedaExtSolAfilWebList;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<InfoPensionadoSolAfilWeb> infoPensionadosSolAfilWebList;

    @JoinColumn(name = "I_ESTADO_SOLICITUD", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEstadoSolAfilWeb iEstadoSolicitud;

    @JoinColumn(name = "I_USUARIO_ASESOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iUsuarioAsesor;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<HistoriaSolAfilWeb> historiaSolAfilWebList;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<RevSegSarlaftSolAfilWeb> revSegSarlaftSolAfilWebList;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<DatoPersonalSolAfilWeb> datosPersonalesSolAfilWebList;

    @OneToMany( mappedBy = "iSolAfiliacionWeb")
    private List<ReferenciasSolAfilWeb> referenciasSolAfilWebList;
    
    

    public SolicitudAfiliacionWeb() {
    }

    public SolicitudAfiliacionWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public SolicitudAfiliacionWeb(Long iCodigo, Date fFechaSolicitud) {
        this.iCodigo = iCodigo;
        this.fFechaSolicitud = fFechaSolicitud;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Date getFFechaSolicitud() {
        return fFechaSolicitud;
    }

    public void setFFechaSolicitud(Date fFechaSolicitud) {
        this.fFechaSolicitud = fFechaSolicitud;
    }

    public String getCTipoIngreso() {
        return cTipoIngreso;
    }

    public void setCTipoIngreso(String cTipoIngreso) {
        this.cTipoIngreso = cTipoIngreso;
    }

    public Date getFFechaRetiro() {
        return fFechaRetiro;
    }

    public void setFFechaRetiro(Date fFechaRetiro) {
        this.fFechaRetiro = fFechaRetiro;
    }

    public Date getFFechaRadicado() {
        return fFechaRadicado;
    }

    public void setFFechaRadicado(Date fFechaRadicado) {
        this.fFechaRadicado = fFechaRadicado;
    }

    public Long getICiudad() {
        return iCiudad;
    }

    public void setICiudad(Long iCiudad) {
        this.iCiudad = iCiudad;
    }

    public Date getFFechaVerfDocs() {
        return fFechaVerfDocs;
    }

    public void setFFechaVerfDocs(Date fFechaVerfDocs) {
        this.fFechaVerfDocs = fFechaVerfDocs;
    }

    public String getCObsVerfDocs() {
        return cObsVerfDocs;
    }

    public void setCObsVerfDocs(String cObsVerfDocs) {
        this.cObsVerfDocs = cObsVerfDocs;
    }

    public Date getFFechaVerfInf() {
        return fFechaVerfInf;
    }

    public void setFFechaVerfInf(Date fFechaVerfInf) {
        this.fFechaVerfInf = fFechaVerfInf;
    }

    public String getCObsVerfInf() {
        return cObsVerfInf;
    }

    public void setCObsVerfInf(String cObsVerfInf) {
        this.cObsVerfInf = cObsVerfInf;
    }

    public Date getFFechaVinculacion() {
        return fFechaVinculacion;
    }

    public void setFFechaVinculacion(Date fFechaVinculacion) {
        this.fFechaVinculacion = fFechaVinculacion;
    }

    public Long getICodAsignado() {
        return iCodAsignado;
    }

    public void setICodAsignado(Long iCodAsignado) {
        this.iCodAsignado = iCodAsignado;
    }

    public Long getINumActa() {
        return iNumActa;
    }

    public void setINumActa(Long iNumActa) {
        this.iNumActa = iNumActa;
    }

    public String getCComentarios() {
        return cComentarios;
    }

    public void setCComentarios(String cComentarios) {
        this.cComentarios = cComentarios;
    }

    public String getCNumRadic() {
        return cNumRadic;
    }

    public void setCNumRadic(String cNumRadic) {
        this.cNumRadic = cNumRadic;
    }
    
    @XmlTransient
    public List<DocumentoSolAfilWeb> getDocumentosSolAfilWebList() {
        return documentosSolAfilWebList;
    }

    public void setDocumentosSolAfilWebList(List<DocumentoSolAfilWeb> documentosSolAfilWebList) {
        this.documentosSolAfilWebList = documentosSolAfilWebList;
    }

    @XmlTransient
    public List<InfoConyugeSolAfilWeb> getInfoConyugeSolAfilWebList() {
        return infoConyugeSolAfilWebList;
    }

    public void setInfoConyugeSolAfilWebList(List<InfoConyugeSolAfilWeb> infoConyugeSolAfilWebList) {
        this.infoConyugeSolAfilWebList = infoConyugeSolAfilWebList;
    }

    @XmlTransient
    public List<ActEconomicaSolAfilWeb> getActEconomicaSolAfilWebList() {
        return actEconomicaSolAfilWebList;
    }

    public void setActEconomicaSolAfilWebList(List<ActEconomicaSolAfilWeb> actEconomicaSolAfilWebList) {
        this.actEconomicaSolAfilWebList = actEconomicaSolAfilWebList;
    }

    @XmlTransient
    public List<OperMonedaExtSolAfilWeb> getOperMonedaExtSolAfilWebList() {
        return operMonedaExtSolAfilWebList;
    }

    public void setOperMonedaExtSolAfilWebList(List<OperMonedaExtSolAfilWeb> operMonedaExtSolAfilWebList) {
        this.operMonedaExtSolAfilWebList = operMonedaExtSolAfilWebList;
    }

    @XmlTransient
    public List<InfoPensionadoSolAfilWeb> getInfoPensionadosSolAfilWebList() {
        return infoPensionadosSolAfilWebList;
    }

    public void setInfoPensionadosSolAfilWebList(List<InfoPensionadoSolAfilWeb> infoPensionadosSolAfilWebList) {
        this.infoPensionadosSolAfilWebList = infoPensionadosSolAfilWebList;
    }

    public TipoEstadoSolAfilWeb getIEstadoSolicitud() {
        return iEstadoSolicitud;
    }

    public void setIEstadoSolicitud(TipoEstadoSolAfilWeb iEstadoSolicitud) {
        this.iEstadoSolicitud = iEstadoSolicitud;
    }

    public Usuario getIUsuarioAsesor() {
        return iUsuarioAsesor;
    }

    public void setIUsuarioAsesor(Usuario iUsuarioAsesor) {
        this.iUsuarioAsesor = iUsuarioAsesor;
    }

    @XmlTransient
    public List<HistoriaSolAfilWeb> getHistoriaSolAfilWebList() {
        return historiaSolAfilWebList;
    }

    public void setHistoriaSolAfilWebList(List<HistoriaSolAfilWeb> historiaSolAfilWebList) {
        this.historiaSolAfilWebList = historiaSolAfilWebList;
    }

    @XmlTransient
    public List<RevSegSarlaftSolAfilWeb> getRevSegSarlaftSolAfilWebList() {
        return revSegSarlaftSolAfilWebList;
    }

    public void setRevSegSarlaftSolAfilWebList(List<RevSegSarlaftSolAfilWeb> revSegSarlaftSolAfilWebList) {
        this.revSegSarlaftSolAfilWebList = revSegSarlaftSolAfilWebList;
    }

    @XmlTransient
    public List<DatoPersonalSolAfilWeb> getDatosPersonalesSolAfilWebList() {
        return datosPersonalesSolAfilWebList;
    }

    public void setDatosPersonalesSolAfilWebList(List<DatoPersonalSolAfilWeb> datosPersonalesSolAfilWebList) {
        this.datosPersonalesSolAfilWebList = datosPersonalesSolAfilWebList;
    }

    @XmlTransient
    public List<ReferenciasSolAfilWeb> getReferenciasSolAfilWebList() {
        return referenciasSolAfilWebList;
    }

    public void setReferenciasSolAfilWebList(List<ReferenciasSolAfilWeb> referenciasSolAfilWebList) {
        this.referenciasSolAfilWebList = referenciasSolAfilWebList;
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
        if (!(object instanceof SolicitudAfiliacionWeb)) {
            return false;
        }
        SolicitudAfiliacionWeb other = (SolicitudAfiliacionWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitudAfiliacionWeb{" + "iCiudad=" + iCiudad + ", iCodAsignado=" + iCodAsignado + ", iNumActa=" + iNumActa + ", iCodigo=" + iCodigo + ", fFechaSolicitud=" + fFechaSolicitud + ", fFechaVinculacion=" + fFechaVinculacion + ", cComentarios=" + cComentarios + ", iEstadoSolicitud=" + iEstadoSolicitud + '}';
    }
  


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "DATOS_PERSONALES_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatoPersonalSolAfilWeb.findAll", query = "SELECT d FROM DatoPersonalSolAfilWeb d")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByICodigo", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iCodigo = :iCodigo")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCPrimerApellido", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cPrimerApellido = :cPrimerApellido")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCSegundoApellido", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cSegundoApellido = :cSegundoApellido")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCPrimerNombre", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cPrimerNombre = :cPrimerNombre")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCSegundoNombre", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cSegundoNombre = :cSegundoNombre")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByITipoIdent", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iTipoIdent = :iTipoIdent")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCIdentificacion", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cIdentificacion = :cIdentificacion")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByICiudadExpIdent", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iCiudadExpIdent = :iCiudadExpIdent")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByFFechaExpIdent", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.fFechaExpIdent = :fFechaExpIdent")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCGenero", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cGenero = :cGenero")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByFFechaNacimiento", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.fFechaNacimiento = :fFechaNacimiento")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByICiudadNacimiento", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iCiudadNacimiento = :iCiudadNacimiento")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCEstadoCivil", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cEstadoCivil = :cEstadoCivil")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByINumPerCar", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iNumPerCar = :iNumPerCar")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByINivelEstudio", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iNivelEstudio = :iNivelEstudio")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCTitulo", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cTitulo = :cTitulo")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCDireccionResidencia", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cDireccionResidencia = :cDireccionResidencia")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByICiudadResidencia", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iCiudadResidencia = :iCiudadResidencia")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByIDepartamentoResidencia", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iDepartamentoResidencia = :iDepartamentoResidencia")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCBarrio", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cBarrio = :cBarrio")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCNumTelefonoResidencia", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cNumTelefonoResidencia = :cNumTelefonoResidencia")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCNumCelular", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cNumCelular = :cNumCelular")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCEmail", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cEmail = :cEmail")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByITipoVivienda", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iTipoVivienda = :iTipoVivienda")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByIEstrato", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iEstrato = :iEstrato")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByCCursoCooperativismo", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.cCursoCooperativismo = :cCursoCooperativismo")
    , @NamedQuery(name = "DatoPersonalSolAfilWeb.findByiSolAfiliacionWeb", query = "SELECT d FROM DatoPersonalSolAfilWeb d WHERE d.iSolAfiliacionWeb = :iSolAfiliacionWeb")
})
public class DatoPersonalSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_DATOS_PERS_SOL_AFIL_WEB", sequenceName = "SEQ_DATOS_PERS_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DATOS_PERS_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Size(max = 50)
    @Column(name = "C_PRIMER_APELLIDO")
    private String cPrimerApellido;
    @Size(max = 50)
    @Column(name = "C_SEGUNDO_APELLIDO")
    private String cSegundoApellido;
    @Size(max = 50)
    @Column(name = "C_PRIMER_NOMBRE")
    private String cPrimerNombre;
    @Size(max = 50)
    @Column(name = "C_SEGUNDO_NOMBRE")
    private String cSegundoNombre;
    
    
    @Column(name = "I_TIPO_IDENT")
    private Long iTipoIdent;
    
    
    @Size(min = 1, max = 15)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    @Column(name = "I_CIUDAD_EXP_IDENT")
    private Long iCiudadExpIdent;
    @Column(name = "F_FECHA_EXP_IDENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaExpIdent;
    @Size(max = 2)
    @Column(name = "C_GENERO")
    private String cGenero;
    @Column(name = "F_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaNacimiento;
    @Column(name = "I_CIUDAD_NACIMIENTO")
    private Long iCiudadNacimiento;
    @Size(max = 2)
    @Column(name = "C_ESTADO_CIVIL")
    private String cEstadoCivil;
    @Column(name = "I_NUM_PER_CAR")
    private Long iNumPerCar;
    @Column(name = "I_NIVEL_ESTUDIO")
    private Long iNivelEstudio;
    @Size(max = 100)
    @Column(name = "C_TITULO")
    private String cTitulo;
    @Size(max = 150)
    @Column(name = "C_DIRECCION_RESIDENCIA")
    private String cDireccionResidencia;
    @Column(name = "I_CIUDAD_RESIDENCIA")
    private Long iCiudadResidencia;
    @Column(name = "I_DEPARTAMENTO_RESIDENCIA")
    private Long iDepartamentoResidencia;
    @Size(max = 100)
    @Column(name = "C_BARRIO")
    private String cBarrio;
    @Size(max = 15)
    @Column(name = "C_NUM_TELEFONO_RESIDENCIA")
    private String cNumTelefonoResidencia;
    @Size(max = 15)
    @Column(name = "C_NUM_CELULAR")
    private String cNumCelular;
    @Size(max = 100)
    @Column(name = "C_EMAIL")
    private String cEmail;
    @Column(name = "I_TIPO_VIVIENDA")
    private Long iTipoVivienda;
    @Column(name = "I_ESTRATO")
    private Long iEstrato;
    @Size(max = 2)
    @Column(name = "C_CURSO_COOPERATIVISMO")
    private String cCursoCooperativismo;
    
    @Column(name = "I_DEPARTAMENTO_NACIMIENTO")
    private Long iDepartamentoNacimiento;
    @Column(name = "I_NUM_HIJOS_MAYORES_EDAD")
    private Long iNumHijosMayoresEdad;
    @Column(name = "I_NUM_HIJOS_MENORES_EDAD")
    private Long iNumHijosMenoresEdad;
    @Size(max = 255)
    @Column(name = "C_DESTINO_INFORMACION")
    private String cDestinoInformacion;
    
    @Size(max = 2)
    @Column(name = "C_CABEZA_FAMILIA")
    private String cCabezaFamilia;


    
    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    public DatoPersonalSolAfilWeb()
    {
    }

    public DatoPersonalSolAfilWeb(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public DatoPersonalSolAfilWeb(Long iCodigo, Long iTipoIdent, String cIdentificacion)
    {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
    }

    public Long getICodigo()
    {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo)
    {
        this.iCodigo = iCodigo;
    }

    public String getCPrimerApellido()
    {
        return cPrimerApellido;
    }

    public void setCPrimerApellido(String cPrimerApellido)
    {
        this.cPrimerApellido = cPrimerApellido;
    }

    public String getCSegundoApellido()
    {
        return cSegundoApellido;
    }

    public void setCSegundoApellido(String cSegundoApellido)
    {
        this.cSegundoApellido = cSegundoApellido;
    }

    public String getCPrimerNombre()
    {
        return cPrimerNombre;
    }

    public void setCPrimerNombre(String cPrimerNombre)
    {
        this.cPrimerNombre = cPrimerNombre;
    }

    public String getCSegundoNombre()
    {
        return cSegundoNombre;
    }

    public void setCSegundoNombre(String cSegundoNombre)
    {
        this.cSegundoNombre = cSegundoNombre;
    }

    public Long getITipoIdent()
    {
        return iTipoIdent;
    }

    public void setITipoIdent(Long iTipoIdent)
    {
        this.iTipoIdent = iTipoIdent;
    }

    public String getCIdentificacion()
    {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion)
    {
        this.cIdentificacion = cIdentificacion;
    }

    public Long getICiudadExpIdent()
    {
        return iCiudadExpIdent;
    }

    public void setICiudadExpIdent(Long iCiudadExpIdent)
    {
        this.iCiudadExpIdent = iCiudadExpIdent;
    }

    public Date getFFechaExpIdent()
    {
        return fFechaExpIdent;
    }

    public void setFFechaExpIdent(Date fFechaExpIdent)
    {
        this.fFechaExpIdent = fFechaExpIdent;
    }

    public String getCGenero()
    {
        return cGenero;
    }

    public void setCGenero(String cGenero)
    {
        this.cGenero = cGenero;
    }

    public Date getFFechaNacimiento()
    {
        return fFechaNacimiento;
    }

    public void setFFechaNacimiento(Date fFechaNacimiento)
    {
        this.fFechaNacimiento = fFechaNacimiento;
    }

    public Long getICiudadNacimiento()
    {
        return iCiudadNacimiento;
    }

    public void setICiudadNacimiento(Long iCiudadNacimiento)
    {
        this.iCiudadNacimiento = iCiudadNacimiento;
    }

    public String getCEstadoCivil()
    {
        return cEstadoCivil;
    }

    public void setCEstadoCivil(String cEstadoCivil)
    {
        this.cEstadoCivil = cEstadoCivil;
    }

    public Long getINumPerCar()
    {
        return iNumPerCar;
    }

    public void setINumPerCar(Long iNumPerCar)
    {
        this.iNumPerCar = iNumPerCar;
    }

    public Long getINivelEstudio()
    {
        return iNivelEstudio;
    }

    public void setINivelEstudio(Long iNivelEstudio)
    {
        this.iNivelEstudio = iNivelEstudio;
    }

    public String getCTitulo()
    {
        return cTitulo;
    }

    public void setCTitulo(String cTitulo)
    {
        this.cTitulo = cTitulo;
    }

    public String getCDireccionResidencia()
    {
        return cDireccionResidencia;
    }

    public void setCDireccionResidencia(String cDireccionResidencia)
    {
        this.cDireccionResidencia = cDireccionResidencia;
    }

    public Long getICiudadResidencia()
    {
        return iCiudadResidencia;
    }

    public void setICiudadResidencia(Long iCiudadResidencia)
    {
        this.iCiudadResidencia = iCiudadResidencia;
    }

    public Long getIDepartamentoResidencia()
    {
        return iDepartamentoResidencia;
    }

    public void setIDepartamentoResidencia(Long iDepartamentoResidencia)
    {
        this.iDepartamentoResidencia = iDepartamentoResidencia;
    }

    public String getCBarrio()
    {
        return cBarrio;
    }

    public void setCBarrio(String cBarrio)
    {
        this.cBarrio = cBarrio;
    }

    public String getCNumTelefonoResidencia()
    {
        return cNumTelefonoResidencia;
    }

    public void setCNumTelefonoResidencia(String cNumTelefonoResidencia)
    {
        this.cNumTelefonoResidencia = cNumTelefonoResidencia;
    }

    public String getCNumCelular()
    {
        return cNumCelular;
    }

    public void setCNumCelular(String cNumCelular)
    {
        this.cNumCelular = cNumCelular;
    }

    public String getCEmail()
    {
        return cEmail;
    }

    public void setCEmail(String cEmail)
    {
        this.cEmail = cEmail;
    }

    public Long getITipoVivienda()
    {
        return iTipoVivienda;
    }

    public void setITipoVivienda(Long iTipoVivienda)
    {
        this.iTipoVivienda = iTipoVivienda;
    }

    public Long getIEstrato()
    {
        return iEstrato;
    }

    public void setIEstrato(Long iEstrato)
    {
        this.iEstrato = iEstrato;
    }

    public String getCCursoCooperativismo()
    {
        return cCursoCooperativismo;
    }

    public void setCCursoCooperativismo(String cCursoCooperativismo)
    {
        this.cCursoCooperativismo = cCursoCooperativismo;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb()
    {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb)
    {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
    }

    public Long getIDepartamentoNacimiento() {
        return iDepartamentoNacimiento;
    }

    public void setIDepartamentoNacimiento(Long iDepartamentoNacimiento) {
        this.iDepartamentoNacimiento = iDepartamentoNacimiento;
    }

    public Long getINumHijosMayoresEdad() {
        return iNumHijosMayoresEdad;
    }

    public void setINumHijosMayoresEdad(Long iNumHijosMayoresEdad) {
        this.iNumHijosMayoresEdad = iNumHijosMayoresEdad;
    }

    public Long getINumHijosMenoresEdad() {
        return iNumHijosMenoresEdad;
    }

    public void setINumHijosMenoresEdad(Long iNumHijosMenoresEdad) {
        this.iNumHijosMenoresEdad = iNumHijosMenoresEdad;
    }

    public String getCDestinoInformacion() {
        return cDestinoInformacion;
    }

    public void setCDestinoInformacion(String cDestinoInformacion) {
        this.cDestinoInformacion = cDestinoInformacion;
    }
    
    public String getCCabezaFamilia() {
        return cCabezaFamilia;
    }

    public void setCCabezaFamilia(String cabezaFamilia) {
        this.cCabezaFamilia = cabezaFamilia;
    }
    
    

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (iCodigo != null ? iCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatoPersonalSolAfilWeb)) {
            return false;
        }
        DatoPersonalSolAfilWeb other = (DatoPersonalSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatoPersonalSolAfilWeb{" + "iCodigo=" + iCodigo + ", cPrimerApellido=" + cPrimerApellido + ", cSegundoApellido=" + cSegundoApellido + ", cPrimerNombre=" + cPrimerNombre + ", cSegundoNombre=" + cSegundoNombre + ", iTipoIdent=" + iTipoIdent + ", cIdentificacion=" + cIdentificacion + ", iCiudadExpIdent=" + iCiudadExpIdent + ", fFechaExpIdent=" + fFechaExpIdent + ", cGenero=" + cGenero + ", fFechaNacimiento=" + fFechaNacimiento + ", iCiudadNacimiento=" + iCiudadNacimiento + ", cEstadoCivil=" + cEstadoCivil + ", iNumPerCar=" + iNumPerCar + ", iNivelEstudio=" + iNivelEstudio + ", cTitulo=" + cTitulo + ", cDireccionResidencia=" + cDireccionResidencia + ", iCiudadResidencia=" + iCiudadResidencia + ", iDepartamentoResidencia=" + iDepartamentoResidencia + ", cBarrio=" + cBarrio + ", cNumTelefonoResidencia=" + cNumTelefonoResidencia + ", cNumCelular=" + cNumCelular + ", cEmail=" + cEmail + ", iTipoVivienda=" + iTipoVivienda + ", iEstrato=" + iEstrato + ", cCursoCooperativismo=" + cCursoCooperativismo + ", iDepartamentoNacimiento=" + iDepartamentoNacimiento + ", iNumHijosMayoresEdad=" + iNumHijosMayoresEdad + ", iNumHijosMenoresEdad=" + iNumHijosMenoresEdad + ", cDestinoInformacion=" + cDestinoInformacion + ", cCabezaFamilia=" + cCabezaFamilia + '}';
    }

   
    
}

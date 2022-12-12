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
@Table(name = "ACT_ECONOMICA_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActEconomicaSolAfilWeb.findAll", query = "SELECT a FROM ActEconomicaSolAfilWeb a")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByICodigo", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.iCodigo = :iCodigo")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByITipoActEconomica", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.iTipoActEconomica = :iTipoActEconomica")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCOtraActividadEcono", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cOtraActividadEcono = :cOtraActividadEcono")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCNombreEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cNombreEmpresa = :cNombreEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCActEcoEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cActEcoEmpresa = :cActEcoEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCOtraActEconoEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cOtraActEconoEmpresa = :cOtraActEconoEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByNSalario", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.nSalario = :nSalario")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCDireccionEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cDireccionEmpresa = :cDireccionEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCNumTelEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cNumTelEmpresa = :cNumTelEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByICiudadEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.iCiudadEmpresa = :iCiudadEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByIDepartamentoEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.iDepartamentoEmpresa = :iDepartamentoEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByFFechaIngresoEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.fFechaIngresoEmpresa = :fFechaIngresoEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCCargoActual", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cCargoActual = :cCargoActual")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCEmailEmpresa", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cEmailEmpresa = :cEmailEmpresa")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByITipoContrato", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.iTipoContrato = :iTipoContrato")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByFFechaVencContrato", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.fFechaVencContrato = :fFechaVencContrato")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCServidorPublico", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cServidorPublico = :cServidorPublico")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCManejoRecPublicos", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cManejoRecPublicos = :cManejoRecPublicos")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCIngresosAdicionales", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cIngresosAdicionales = :cIngresosAdicionales")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByCConceptoIngresosAdi", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.cConceptoIngresosAdi = :cConceptoIngresosAdi")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByNValorActivos", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.nValorActivos = :nValorActivos")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByNValorPasivos", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.nValorPasivos = :nValorPasivos")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByNValorPatrimonio", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.nValorPatrimonio = :nValorPatrimonio")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByNPrctAportesObl", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.nPrctAportesObl = :nPrctAportesObl")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByNValorAporte", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.nValorAporte = :nValorAporte")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByITipoPago", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.iTipoPago = :iTipoPago")
    , @NamedQuery(name = "ActEconomicaSolAfilWeb.findByiSolAfiliacionWeb", query = "SELECT a FROM ActEconomicaSolAfilWeb a WHERE a.iSolAfiliacionWeb = :iSolAfiliacionWeb")
})
public class ActEconomicaSolAfilWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_ACT_ECON_SOL_AFIL_WEB", sequenceName = "SEQ_ACT_ECON_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACT_ECON_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "I_TIPO_ACT_ECONOMICA")
    private Long iTipoActEconomica;
    
    @Size(max = 50)
    @Column(name = "C_OTRA_ACTIVIDAD_ECONO")
    private String cOtraActividadEcono;

    @Size(min = 1, max = 100)
    @Column(name = "C_NOMBRE_EMPRESA")
    private String cNombreEmpresa;

    @Size(min = 1, max = 5)
    @Column(name = "C_ACT_ECO_EMPRESA")
    private String cActEcoEmpresa;

    @Size(max = 50)
    @Column(name = "C_OTRA_ACT_ECONO_EMPRESA")
    private String cOtraActEconoEmpresa;

    @Column(name = "N_SALARIO")
    private Long nSalario;

    @Column(name = "N_INGRESOS_ADICIONALES")
    private Long nIngresosAdicionales;
    
    @Column(name = "N_GASTOS")
    private Long nGastos;
    
    @Column(name = "N_EGRESOS")
    private Long nEgresos;
    
    @Size(min = 1, max = 100)
    @Column(name = "C_DIRECCION_EMPRESA")
    private String cDireccionEmpresa;

    @Size(min = 1, max = 15)
    @Column(name = "C_NUM_TEL_EMPRESA")
    private String cNumTelEmpresa;

    @Column(name = "I_CIUDAD_EMPRESA")
    private Long iCiudadEmpresa;

    @Column(name = "I_DEPARTAMENTO_EMPRESA")
    private Long iDepartamentoEmpresa;

    @Column(name = "F_FECHA_INGRESO_EMPRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaIngresoEmpresa;

    @Size(min = 1, max = 80)
    @Column(name = "C_CARGO_ACTUAL")
    private String cCargoActual;
    
    @Size(min = 1, max = 80)
    @Column(name = "C_PROFESION")
    private String cProfesion;

    @Size(min = 1, max = 100)
    @Column(name = "C_EMAIL_EMPRESA")
    private String cEmailEmpresa;

    @Column(name = "I_TIPO_CONTRATO")
    private Long iTipoContrato;

    @Column(name = "F_FECHA_VENC_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaVencContrato;

    @Size(min = 1, max = 2)
    @Column(name = "C_SERVIDOR_PUBLICO")
    private String cServidorPublico;

    @Size(min = 1, max = 2)
    @Column(name = "C_MANEJO_REC_PUBLICOS")
    private String cManejoRecPublicos;

    @Size(min = 1, max = 2)
    @Column(name = "C_INGRESOS_ADICIONALES")
    private String cIngresosAdicionales;
    
    @Size(min = 1, max = 2)
    @Column(name = "C_DECLARACION_RENTA")
    private String cDeclaracionRenta;
    
    @Size(max = 80)
    @Column(name = "C_CONCEPTO_INGRESOS_ADI")
    private String cConceptoIngresosAdi;

    @Column(name = "N_VALOR_ACTIVOS")
    private Long nValorActivos;

    @Column(name = "N_VALOR_PASIVOS")
    private Long nValorPasivos;

    @Column(name = "N_VALOR_PATRIMONIO")
    private Long nValorPatrimonio;

    @Column(name = "N_PRCT_APORTES_OBL")
    private Long nPrctAportesObl;

    @Column(name = "N_VALOR_APORTE")
    private Long nValorAporte;

    @Column(name = "I_TIPO_PAGO")
    private Long iTipoPago;

    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    public ActEconomicaSolAfilWeb() {
    }

    public Long getNIngresosAdicionales() {
        return nIngresosAdicionales;
    }

    public void setNIngresosAdicionales(Long nIngresosAdicionales) {
        this.nIngresosAdicionales = nIngresosAdicionales;
    }

    public Long getNGastos() {
        return nGastos;
    }

    public void setNGastos(Long nGastos) {
        this.nGastos = nGastos;
    }

    public Long getNEgresos() {
        return nEgresos;
    }

    public void setNEgresos(Long nEgresos) {
        this.nEgresos = nEgresos;
    }
    
    public ActEconomicaSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ActEconomicaSolAfilWeb(Long iCodigo, Long iTipoActEconomica, String cNombreEmpresa, String cActEcoEmpresa, Long nSalario, String cDireccionEmpresa, String cNumTelEmpresa, Long iCiudadEmpresa, Long iDepartamentoEmpresa, Date fFechaIngresoEmpresa, String cCargoActual, String cEmailEmpresa, Long iTipoContrato, String cServidorPublico, String cManejoRecPublicos, String cIngresosAdicionales, Long nValorActivos, Long nValorPasivos, Long nValorPatrimonio, Long nPrctAportesObl, Long nValorAporte, Long iTipoPago, String cProfesion) {
        this.iCodigo = iCodigo;
        this.iTipoActEconomica = iTipoActEconomica;
        this.cNombreEmpresa = cNombreEmpresa;
        this.cActEcoEmpresa = cActEcoEmpresa;
        this.nSalario = nSalario;
        this.cDireccionEmpresa = cDireccionEmpresa;
        this.cNumTelEmpresa = cNumTelEmpresa;
        this.iCiudadEmpresa = iCiudadEmpresa;
        this.iDepartamentoEmpresa = iDepartamentoEmpresa;
        this.fFechaIngresoEmpresa = fFechaIngresoEmpresa;
        this.cCargoActual = cCargoActual;
        this.cProfesion = cProfesion;
        this.cEmailEmpresa = cEmailEmpresa;
        this.iTipoContrato = iTipoContrato;
        this.cServidorPublico = cServidorPublico;
        this.cManejoRecPublicos = cManejoRecPublicos;
        this.cIngresosAdicionales = cIngresosAdicionales;
        this.nValorActivos = nValorActivos;
        this.nValorPasivos = nValorPasivos;
        this.nValorPatrimonio = nValorPatrimonio;
        this.nPrctAportesObl = nPrctAportesObl;
        this.nValorAporte = nValorAporte;
        this.iTipoPago = iTipoPago;
    }

    public String getCDeclaracionRenta() {
        return cDeclaracionRenta;
    }

    public void setCDeclaracionRenta(String cDeclaracionRenta) {
        this.cDeclaracionRenta = cDeclaracionRenta;
    }

    
    
    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getITipoActEconomica() {
        return iTipoActEconomica;
    }

    public void setITipoActEconomica(Long iTipoActEconomica) {
        this.iTipoActEconomica = iTipoActEconomica;
    }

    public String getCOtraActividadEcono() {
        return cOtraActividadEcono;
    }

    public void setCOtraActividadEcono(String cOtraActividadEcono) {
        this.cOtraActividadEcono = cOtraActividadEcono;
    }

    public String getCNombreEmpresa() {
        return cNombreEmpresa;
    }

    public void setCNombreEmpresa(String cNombreEmpresa) {
        this.cNombreEmpresa = cNombreEmpresa;
    }

    public String getCActEcoEmpresa() {
        return cActEcoEmpresa;
    }

    public void setCActEcoEmpresa(String cActEcoEmpresa) {
        this.cActEcoEmpresa = cActEcoEmpresa;
    }

    public String getCOtraActEconoEmpresa() {
        return cOtraActEconoEmpresa;
    }

    public void setCOtraActEconoEmpresa(String cOtraActEconoEmpresa) {
        this.cOtraActEconoEmpresa = cOtraActEconoEmpresa;
    }

    public Long getNSalario() {
        return nSalario;
    }

    public void setNSalario(Long nSalario) {
        this.nSalario = nSalario;
    }

    public String getCDireccionEmpresa() {
        return cDireccionEmpresa;
    }

    public void setCDireccionEmpresa(String cDireccionEmpresa) {
        this.cDireccionEmpresa = cDireccionEmpresa;
    }

    public String getCNumTelEmpresa() {
        return cNumTelEmpresa;
    }

    public void setCNumTelEmpresa(String cNumTelEmpresa) {
        this.cNumTelEmpresa = cNumTelEmpresa;
    }

    public Long getICiudadEmpresa() {
        return iCiudadEmpresa;
    }

    public void setICiudadEmpresa(Long iCiudadEmpresa) {
        this.iCiudadEmpresa = iCiudadEmpresa;
    }

    public Long getIDepartamentoEmpresa() {
        return iDepartamentoEmpresa;
    }

    public void setIDepartamentoEmpresa(Long iDepartamentoEmpresa) {
        this.iDepartamentoEmpresa = iDepartamentoEmpresa;
    }

    public Date getFFechaIngresoEmpresa() {
        return fFechaIngresoEmpresa;
    }

    public void setFFechaIngresoEmpresa(Date fFechaIngresoEmpresa) {
        this.fFechaIngresoEmpresa = fFechaIngresoEmpresa;
    }

    public String getCCargoActual() {
        return cCargoActual;
    }

    public void setCCargoActual(String cCargoActual) {
        this.cCargoActual = cCargoActual;
    }

    public String getCEmailEmpresa() {
        return cEmailEmpresa;
    }

    public void setCEmailEmpresa(String cEmailEmpresa) {
        this.cEmailEmpresa = cEmailEmpresa;
    }

    public Long getITipoContrato() {
        return iTipoContrato;
    }

    public void setITipoContrato(Long iTipoContrato) {
        this.iTipoContrato = iTipoContrato;
    }

    public Date getFFechaVencContrato() {
        return fFechaVencContrato;
    }

    public void setFFechaVencContrato(Date fFechaVencContrato) {
        this.fFechaVencContrato = fFechaVencContrato;
    }

    public String getCServidorPublico() {
        return cServidorPublico;
    }

    public void setCServidorPublico(String cServidorPublico) {
        this.cServidorPublico = cServidorPublico;
    }

    public String getCManejoRecPublicos() {
        return cManejoRecPublicos;
    }

    public void setCManejoRecPublicos(String cManejoRecPublicos) {
        this.cManejoRecPublicos = cManejoRecPublicos;
    }

    public String getCIngresosAdicionales() {
        return cIngresosAdicionales;
    }

    public void setCIngresosAdicionales(String cIngresosAdicionales) {
        this.cIngresosAdicionales = cIngresosAdicionales;
    }

    public String getCConceptoIngresosAdi() {
        return cConceptoIngresosAdi;
    }

    public void setCConceptoIngresosAdi(String cConceptoIngresosAdi) {
        this.cConceptoIngresosAdi = cConceptoIngresosAdi;
    }

    public Long getNValorActivos() {
        return nValorActivos;
    }

    public void setNValorActivos(Long nValorActivos) {
        this.nValorActivos = nValorActivos;
    }

    public Long getNValorPasivos() {
        return nValorPasivos;
    }

    public void setNValorPasivos(Long nValorPasivos) {
        this.nValorPasivos = nValorPasivos;
    }

    public Long getNValorPatrimonio() {
        return nValorPatrimonio;
    }

    public void setNValorPatrimonio(Long nValorPatrimonio) {
        this.nValorPatrimonio = nValorPatrimonio;
    }

    public Long getNPrctAportesObl() {
        return nPrctAportesObl;
    }

    public void setNPrctAportesObl(Long nPrctAportesObl) {
        this.nPrctAportesObl = nPrctAportesObl;
    }

    public Long getNValorAporte() {
        return nValorAporte;
    }

    public void setNValorAporte(Long nValorAporte) {
        this.nValorAporte = nValorAporte;
    }

    public Long getITipoPago() {
        return iTipoPago;
    }

    public void setITipoPago(Long iTipoPago) {
        this.iTipoPago = iTipoPago;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb() {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb) {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
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
        if (!(object instanceof ActEconomicaSolAfilWeb)) {
            return false;
        }
        ActEconomicaSolAfilWeb other = (ActEconomicaSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    public String getCProfesion() {
        return cProfesion;
    }

    public void setCProfesion(String cProfesion) {
        this.cProfesion = cProfesion;
    }

    @Override
    public String toString() {
        return "ActEconomicaSolAfilWeb{" + "iCodigo=" + iCodigo + ", iTipoActEconomica=" + iTipoActEconomica + ", cOtraActividadEcono=" + cOtraActividadEcono + ", cNombreEmpresa=" + cNombreEmpresa + ", cActEcoEmpresa=" + cActEcoEmpresa + ", cOtraActEconoEmpresa=" + cOtraActEconoEmpresa + ", nSalario=" + nSalario + ", cDireccionEmpresa=" + cDireccionEmpresa + ", cNumTelEmpresa=" + cNumTelEmpresa + ", iCiudadEmpresa=" + iCiudadEmpresa + ", iDepartamentoEmpresa=" + iDepartamentoEmpresa + ", fFechaIngresoEmpresa=" + fFechaIngresoEmpresa + ", cCargoActual=" + cCargoActual + ", cProfesion=" + cProfesion + ", cEmailEmpresa=" + cEmailEmpresa + ", iTipoContrato=" + iTipoContrato + ", fFechaVencContrato=" + fFechaVencContrato + ", cServidorPublico=" + cServidorPublico + ", cManejoRecPublicos=" + cManejoRecPublicos + ", cIngresosAdicionales=" + cIngresosAdicionales + ", cConceptoIngresosAdi=" + cConceptoIngresosAdi + ", nValorActivos=" + nValorActivos + ", nValorPasivos=" + nValorPasivos + ", nValorPatrimonio=" + nValorPatrimonio + ", nPrctAportesObl=" + nPrctAportesObl + ", nValorAporte=" + nValorAporte + ", iTipoPago=" + iTipoPago + ", iSolAfiliacionWeb=" + iSolAfiliacionWeb + '}';
    }
    
   

}

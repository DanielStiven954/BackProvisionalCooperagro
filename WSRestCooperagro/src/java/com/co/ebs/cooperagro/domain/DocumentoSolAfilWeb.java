/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author JONATHAN RUGE
 */
@Entity
@Table(name = "DOCUMENTOS_SOL_AFIL_WEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoSolAfilWeb.findAll", query = "SELECT d FROM DocumentoSolAfilWeb d"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByICodigo", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByCBase64", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.cBase64 = :cBase64"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByCNombreDocumento", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.cNombreDocumento = :cNombreDocumento"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByCCumplimiento", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.cCumplimiento = :cCumplimiento"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByFFechaDocumento", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.fFechaDocumento = :fFechaDocumento"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByCObservacion", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.cObservacion = :cObservacion"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByCCumpleDocumentacion", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.cCumpleDocumentacion = :cCumpleDocumentacion"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByFFechaRevDoc", query = "SELECT d FROM DocumentoSolAfilWeb d WHERE d.fFechaRevDoc = :fFechaRevDoc"),
    @NamedQuery(name = "DocumentoSolAfilWeb.findByiSolAfiliacionWeb", query = "SELECT d FROM InfoPensionadoSolAfilWeb d WHERE d.iSolAfiliacionWeb = :iSolAfiliacionWeb")
})
public class DocumentoSolAfilWeb implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "C_BASE64")
    private byte[] cBase64;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_DOCS_SOL_AFIL_WEB", sequenceName = "SEQ_DOCS_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOCS_SOL_AFIL_WEB")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 500)
    @Column(name = "C_NOMBRE_DOCUMENTO")
    private String cNombreDocumento;

    @Size(max = 2)
    @Column(name = "C_CUMPLIMIENTO")
    private String cCumplimiento;

    @Column(name = "F_FECHA_DOCUMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaDocumento;

    @Size(max = 500)
    @Column(name = "C_OBSERVACION")
    private String cObservacion;

    @Size(max = 2)
    @Column(name = "C_CUMPLE_DOCUMENTACION")
    private String cCumpleDocumentacion;

    @Column(name = "F_FECHA_REV_DOC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRevDoc;
    
    @Size(max = 10)
    @Column(name = "C_TIPO_ARCHIVO")
    private String cTipoArchivo;

    @JoinColumn(name = "I_SOL_AFILIACION_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudAfiliacionWeb iSolAfiliacionWeb;

    @JoinColumn(name = "I_TIPO_REQUISITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoRequisitoSolAfilWeb iTipoRequisito;

    public DocumentoSolAfilWeb() {
    }

    public String getCTipoArchivo() {
        return cTipoArchivo;
    }

    public void setCTipoArchivo(String cTipoArchivo) {
        this.cTipoArchivo = cTipoArchivo;
    }

    public DocumentoSolAfilWeb(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public DocumentoSolAfilWeb(Long iCodigo, Date fFechaDocumento) {
        this.iCodigo = iCodigo;
        this.fFechaDocumento = fFechaDocumento;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

   /* public BLOB getCBase64() {
        return cBase64;
    }

    public void setCBase64(BLOB cBase64) {
        this.cBase64 = cBase64;
    }*/

    public String getCNombreDocumento() {
        return cNombreDocumento;
    }

    public void setCNombreDocumento(String cNombreDocumento) {
        this.cNombreDocumento = cNombreDocumento;
    }

    public String getCCumplimiento() {
        return cCumplimiento;
    }

    public void setCCumplimiento(String cCumplimiento) {
        this.cCumplimiento = cCumplimiento;
    }

    public Date getFFechaDocumento() {
        return fFechaDocumento;
    }

    public void setFFechaDocumento(Date fFechaDocumento) {
        this.fFechaDocumento = fFechaDocumento;
    }

    public String getCObservacion() {
        return cObservacion;
    }

    public void setCObservacion(String cObservacion) {
        this.cObservacion = cObservacion;
    }

    public String getCCumpleDocumentacion() {
        return cCumpleDocumentacion;
    }

    public void setCCumpleDocumentacion(String cCumpleDocumentacion) {
        this.cCumpleDocumentacion = cCumpleDocumentacion;
    }

    public Date getFFechaRevDoc() {
        return fFechaRevDoc;
    }

    public void setFFechaRevDoc(Date fFechaRevDoc) {
        this.fFechaRevDoc = fFechaRevDoc;
    }

    public SolicitudAfiliacionWeb getISolAfiliacionWeb() {
        return iSolAfiliacionWeb;
    }

    public void setISolAfiliacionWeb(SolicitudAfiliacionWeb iSolAfiliacionWeb) {
        this.iSolAfiliacionWeb = iSolAfiliacionWeb;
    }

    public TipoRequisitoSolAfilWeb getITipoRequisito() {
        return iTipoRequisito;
    }

    public void setITipoRequisito(TipoRequisitoSolAfilWeb iTipoRequisito) {
        this.iTipoRequisito = iTipoRequisito;
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
        if (!(object instanceof DocumentoSolAfilWeb)) {
            return false;
        }
        DocumentoSolAfilWeb other = (DocumentoSolAfilWeb) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentoSolAfilWeb{" + "iCodigo=" + iCodigo + ", cNombreDocumento=" + cNombreDocumento + ", cCumplimiento=" + cCumplimiento + ", fFechaDocumento=" + fFechaDocumento + ", cObservacion=" + cObservacion + ", cCumpleDocumentacion=" + cCumpleDocumentacion + ", fFechaRevDoc=" + fFechaRevDoc + ", iSolAfiliacionWeb=" + iSolAfiliacionWeb + ", iTipoRequisito=" + iTipoRequisito + '}';
    }

    public byte[] getCBase64() {
        return cBase64;
    }

    public void setCBase64(byte[] cBase64) {
        this.cBase64 = cBase64;
    }

    

}

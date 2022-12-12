package com.co.ebs.cooperagro.request;

import com.co.ebs.cooperagro.domain.DocumentoPqrsf;

/**
 *
 * @author YO
 */
public class RequestRegistrarPQRSF {

    private int iTipoIdent;
    private String cIdentificacion;
    private String cNombre;
    private String cEmail;
    private int iTipoPqrsf;
    private Long iSubCategoriaPqrsf;
    private String SDescPqrsf;
    private int iTipoCanal;
    private DocumentoPqrsf documentoPqrsf;
    private String cIp;
    private String cNavegador;

    public int getiTipoIdent() {
        return iTipoIdent;
    }

    public void setiTipoIdent(int iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getcIdentificacion() {
        return cIdentificacion;
    }

    public void setcIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public int getiTipoPqrsf() {
        return iTipoPqrsf;
    }

    public void setiTipoPqrsf(int iTipoPqrsf) {
        this.iTipoPqrsf = iTipoPqrsf;
    }

    public String getSDescPqrsf() {
        return SDescPqrsf;
    }

    public void setSDescPqrsf(String SDescPqrsf) {
        this.SDescPqrsf = SDescPqrsf;
    }

    public int getiTipoCanal() {
        return iTipoCanal;
    }

    public void setiTipoCanal(int iTipoCanal) {
        this.iTipoCanal = iTipoCanal;
    }

    public String getcIp() {
        return cIp;
    }

    public void setcIp(String cIp) {
        this.cIp = cIp;
    }

    public String getcNavegador() {
        return cNavegador;
    }

    public void setcNavegador(String cNavegador) {
        this.cNavegador = cNavegador;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public Long getiSubCategoriaPqrsf() {
        return iSubCategoriaPqrsf;
    }

    public void setiSubCategoriaPqrsf(Long iSubCategoriaPqrsf) {
        this.iSubCategoriaPqrsf = iSubCategoriaPqrsf;
    }

    public DocumentoPqrsf getDocumentoPqrsf() {
        return documentoPqrsf;
    }

    public void setDocumentoPqrsf(DocumentoPqrsf documentoPqrsf) {
        this.documentoPqrsf = documentoPqrsf;
    }

    @Override
    public String toString() {
        return "RequestRegistrarPQRSF{" + "iTipoIdent=" + iTipoIdent + ", cIdentificacion=" + cIdentificacion + ", cNombre=" + cNombre + ", cEmail=" + cEmail + ", iTipoPqrsf=" + iTipoPqrsf + ", iSubCategoriaPqrsf=" + iSubCategoriaPqrsf + ", SDescPqrsf=" + SDescPqrsf + ", iTipoCanal=" + iTipoCanal + ", documentoPqrsf=" + documentoPqrsf + ", cIp=" + cIp + ", cNavegador=" + cNavegador + '}';
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

/**
 *
 * @author YO
 */
public class RequestGenerarDocPersona {

    private String ITipo;
    private String CIdentificacion;
    private String SMes;
    private String SAnio;
    private String STipoDoc;

    public String getITipo() {
        return ITipo;
    }

    public void setITipo(String ITipo) {
        this.ITipo = ITipo;
    }

    public String getCIdentificacion() {
        return CIdentificacion;
    }

    public void setCIdentificacion(String CIdentificacion) {
        this.CIdentificacion = CIdentificacion;
    }

    public String getSMes() {
        return SMes;
    }

    public void setSMes(String SMes) {
        this.SMes = SMes;
    }

    public String getSTipoDoc() {
        return STipoDoc;
    }

    public void setSTipoDoc(String STipoDoc) {
        this.STipoDoc = STipoDoc;
    }

    public String getSAnio() {
        return SAnio;
    }

    public void setSAnio(String SAnio) {
        this.SAnio = SAnio;
    }

    @Override
    public String toString() {
        return "RequestGenerarDocPersona{" + "ITipo=" + ITipo + ", CIdentificacion=" + CIdentificacion + ", SMes=" + SMes + ", SAnio=" + SAnio + ", STipoDoc=" + STipoDoc + '}';
    }
    
    

}

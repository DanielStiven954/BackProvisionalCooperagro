/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

/**
 *
 * @author Brayan F Silva R
 */
public class ResponsePHPGeneraDocsPDF {

    Boolean Flag;
    String Msg;

    String DocSolicitado;
    String RutaArchivo;
    String NombreArchivo;

    public Boolean getFlag() {
        return Flag;
    }

    public void setFlag(Boolean Flag) {
        this.Flag = Flag;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getDocSolicitado() {
        return DocSolicitado;
    }

    public void setDocSolicitado(String DocSolicitado) {
        this.DocSolicitado = DocSolicitado;
    }

    public String getRutaArchivo() {
        return RutaArchivo;
    }

    public void setRutaArchivo(String RutaArchivo) {
        this.RutaArchivo = RutaArchivo;
    }

    public String getNombreArchivo() {
        return NombreArchivo;
    }

    public void setNombreArchivo(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
    }

}

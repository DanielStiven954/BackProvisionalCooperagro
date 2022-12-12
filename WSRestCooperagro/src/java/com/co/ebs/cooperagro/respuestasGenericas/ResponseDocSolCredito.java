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
public class ResponseDocSolCredito {

    private Long iCodigo;
    private Long iCodTipoReqSolCred;
    private String sNombreTipoReqSolCred;
    private String sDescTipoReqSolCred;
    private String sObligTipoReqSolCred;
    private String sRutaFTP;
    private String sNombreArchivo;

    public Long getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getiCodTipoReqSolCred() {
        return iCodTipoReqSolCred;
    }

    public void setiCodTipoReqSolCred(Long iCodTipoReqSolCred) {
        this.iCodTipoReqSolCred = iCodTipoReqSolCred;
    }

    public String getsNombreTipoReqSolCred() {
        return sNombreTipoReqSolCred;
    }

    public void setsNombreTipoReqSolCred(String sNombreTipoReqSolCred) {
        this.sNombreTipoReqSolCred = sNombreTipoReqSolCred;
    }

    public String getsDescTipoReqSolCred() {
        return sDescTipoReqSolCred;
    }

    public void setsDescTipoReqSolCred(String sDescTipoReqSolCred) {
        this.sDescTipoReqSolCred = sDescTipoReqSolCred;
    }

    public String getsRutaFTP() {
        return sRutaFTP;
    }

    public void setsRutaFTP(String sRutaFTP) {
        this.sRutaFTP = sRutaFTP;
    }

    public String getsNombreArchivo() {
        return sNombreArchivo;
    }

    public void setsNombreArchivo(String sNombreArchivo) {
        this.sNombreArchivo = sNombreArchivo;
    }

    public String getsObligTipoReqSolCred() {
        return sObligTipoReqSolCred;
    }

    public void setsObligTipoReqSolCred(String sObligTipoReqSolCred) {
        this.sObligTipoReqSolCred = sObligTipoReqSolCred;
    }

}

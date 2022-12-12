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
public class ResponseCambioEstadoSolCred {

    private Boolean bRta;
    private String sMsj;
    private Long iCodTipoEstadoSolCred;
    private String sDescEstado;

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public Long getiCodTipoEstadoSolCred() {
        return iCodTipoEstadoSolCred;
    }

    public void setiCodTipoEstadoSolCred(Long iCodTipoEstadoSolCred) {
        this.iCodTipoEstadoSolCred = iCodTipoEstadoSolCred;
    }

    public String getsDescEstado() {
        return sDescEstado;
    }

    public void setsDescEstado(String sDescEstado) {
        this.sDescEstado = sDescEstado;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class ResponseOlvidoClave {

    private int iCodigo;
    private Boolean bRta;
    private String sMsj;

    private List<metodoEnvioOlvidoClave> metodosEnvioInfoClave;

    public int getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(int iCodigo) {
        this.iCodigo = iCodigo;
    }

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

    public List<metodoEnvioOlvidoClave> getMetodosEnvioInfoClave() {
        return metodosEnvioInfoClave;
    }

    public void setMetodosEnvioInfoClave(List<metodoEnvioOlvidoClave> metodosEnvioInfoClave) {
        this.metodosEnvioInfoClave = metodosEnvioInfoClave;
    }

}

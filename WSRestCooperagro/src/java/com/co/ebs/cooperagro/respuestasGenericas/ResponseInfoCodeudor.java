/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.InfoCodeudor;

/**
 *
 * @author Brayan F Silva R
 */
public class ResponseInfoCodeudor {

    private Boolean bRta;
    private String sMsj;
    private InfoCodeudor infoCodeud;

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

    public InfoCodeudor getInfoCodeud() {
        return infoCodeud;
    }

    public void setInfoCodeud(InfoCodeudor infoCodeud) {
        this.infoCodeud = infoCodeud;
    }

    
    
    
    
}

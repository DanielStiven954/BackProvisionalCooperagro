/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

import java.util.Date;

/**
 *
 * @author Brayan Silva
 */
public class RequestValdIdentSolAfil {

    private Long iTipoIdent;
    private String sNumIdent;
    private Date sFechaExp;

    public Long getiTipoIdent() {
        return iTipoIdent;
    }

    public void setiTipoIdent(Long iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getsNumIdent() {
        return sNumIdent;
    }

    public void setsNumIdent(String sNumIdent) {
        this.sNumIdent = sNumIdent;
    }

    public Date getsFechaExp() {
        return sFechaExp;
    }

    public void setsFechaExp(Date sFechaExp) {
        this.sFechaExp = sFechaExp;
    }

    @Override
    public String toString() {
        return "RequestValdIdentSolAfil{" + "iTipoIdent=" + iTipoIdent + ", sNumIdent=" + sNumIdent + ", sFechaExp=" + sFechaExp + '}';
    }
    
    

}

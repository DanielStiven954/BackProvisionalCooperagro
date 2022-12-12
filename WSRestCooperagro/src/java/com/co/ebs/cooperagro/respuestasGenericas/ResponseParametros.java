/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

/**
 *
 * @author Jonathan Ruge
 */
public class ResponseParametros {
    private boolean flag;
    private String sMsg;
    private String alfanumerico;
    private String cantMaxDig;
    private String canMinDig;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getsMsg() {
        return sMsg;
    }

    public void setsMsg(String sMsg) {
        this.sMsg = sMsg;
    }

    public String getAlfanumerico() {
        return alfanumerico;
    }

    public void setAlfanumerico(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    public String getCantMaxDig() {
        return cantMaxDig;
    }

    public void setCantMaxDig(String cantMaxDig) {
        this.cantMaxDig = cantMaxDig;
    }

    public String getCanMinDig() {
        return canMinDig;
    }

    public void setCanMinDig(String canMinDig) {
        this.canMinDig = canMinDig;
    }

    

    
    
}

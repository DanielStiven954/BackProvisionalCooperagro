/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

/**
 *
 * @author Braya
 */
public class ResponseAuthAPI {

    private Boolean bRta;
    private String sMsg;
    private String sToken;

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsg() {
        return sMsg;
    }

    public void setsMsg(String sMsg) {
        this.sMsg = sMsg;
    }

    public String getsToken() {
        return sToken;
    }

    public void setsToken(String sToken) {
        this.sToken = sToken;
    }

}

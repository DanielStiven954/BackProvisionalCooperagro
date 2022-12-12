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
public class metodoEnvioOlvidoClave {

    private int iCodMetodoEnvio;
    private String sDescMetodoEnvio;
    private String sValidaMetodo;
    private String sDestinoEnvioClave;

    public int getiCodMetodoEnvio() {
        return iCodMetodoEnvio;
    }

    public void setiCodMetodoEnvio(int iCodMetodoEnvio) {
        this.iCodMetodoEnvio = iCodMetodoEnvio;
    }

    public String getsDescMetodoEnvio() {
        return sDescMetodoEnvio;
    }

    public void setsDescMetodoEnvio(String sDescMetodoEnvio) {
        this.sDescMetodoEnvio = sDescMetodoEnvio;
    }

    public String getsDestinoEnvioClave() {
        return sDestinoEnvioClave;
    }

    public void setsDestinoEnvioClave(String sDestinoEnvioClave) {
        this.sDestinoEnvioClave = sDestinoEnvioClave;
    }

    public String getsValidaMetodo() {
        return sValidaMetodo;
    }

    public void setsValidaMetodo(String sValidaMetodo) {
        this.sValidaMetodo = sValidaMetodo;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

/**
 *
 * @author Brayan F Silva R
 */
public class ResponseSendSMS {

    private String cliente;
    private String lote_id;
    private String fecha_recepcion;
    private int resultado;
    private int resultado_t;
    private int sms_procesados;
    private String referencia;
    private String ip;
    private int flash;

//    private List<infoSendSMS> sms;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getLote_id() {
        return lote_id;
    }

    public void setLote_id(String lote_id) {
        this.lote_id = lote_id;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getResultado_t() {
        return resultado_t;
    }

    public void setResultado_t(int resultado_t) {
        this.resultado_t = resultado_t;
    }

    public int getSms_procesados() {
        return sms_procesados;
    }

    public void setSms_procesados(int sms_procesados) {
        this.sms_procesados = sms_procesados;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getFlash() {
        return flash;
    }

    public void setFlash(int flash) {
        this.flash = flash;
    }

//    public List<infoSendSMS> getSms() {
//        return sms;
//    }
//
//    public void setSms(List<infoSendSMS> sms) {
//        this.sms = sms;
//    }
}

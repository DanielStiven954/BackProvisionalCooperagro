/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

/**
 *
 * @author Administrador
 */
public class RequestSimuladorCredito {

    private String tPago;
    private String sMonto;
    private String sNroCuota;
    private String sCodCredito;
    private String sIdentificacion;
    private String xsFormaPeriodicidad;

    public String gettPago() {
        return tPago;
    }

    public void settPago(String tPago) {
        this.tPago = tPago;
    }

    public String getsMonto() {
        return sMonto;
    }

    public void setsMonto(String sMonto) {
        this.sMonto = sMonto;
    }

    public String getsNroCuota() {
        return sNroCuota;
    }

    public void setsNroCuota(String sNroCuota) {
        this.sNroCuota = sNroCuota;
    }

    public String getsCodCredito() {
        return sCodCredito;
    }

    public void setsCodCredito(String sCodCredito) {
        this.sCodCredito = sCodCredito;
    }

    public String getsIdentificacion() {
        return sIdentificacion;
    }

    public void setsIdentificacion(String sIdentificacion) {
        this.sIdentificacion = sIdentificacion;
    }

    public String getXsFormaPeriodicidad() {
        return xsFormaPeriodicidad;
    }

    public void setXsFormaPeriodicidad(String xsFormaPeriodicidad) {
        this.xsFormaPeriodicidad = xsFormaPeriodicidad;
    }

    @Override
    public String toString() {
        return "RequestSimuladorCredito{" + "tPago=" + tPago + ", sMonto=" + sMonto + ", sNroCuota=" + sNroCuota + ", sCodCredito=" + sCodCredito + ", sIdentificacion=" + sIdentificacion + ", xsFormaPeriodicidad=" + xsFormaPeriodicidad + '}';
    }

    

}

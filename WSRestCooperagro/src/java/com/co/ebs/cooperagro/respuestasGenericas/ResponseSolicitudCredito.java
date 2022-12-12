/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.SolicitudCredito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ResponseSolicitudCredito {

    private boolean flag;
    private long codigoRadicado;
    private String sMsg;
    private List<SolicitudCredito> listaSolicitud;
    private List<SolicitudCreditoRta> listaSolicitudCreditoRta;

    public ResponseSolicitudCredito() {
        listaSolicitud = new ArrayList<>();
        listaSolicitudCreditoRta = new ArrayList<>();
    }

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

    public long getCodigoRadicado() {
        return codigoRadicado;
    }

    public void setCodigoRadicado(long codigoRadicado) {
        this.codigoRadicado = codigoRadicado;
    }

    public List<SolicitudCreditoRta> getListaSolicitudCreditoRta() {
        return listaSolicitudCreditoRta;
    }

    public void setListaSolicitudCreditoRta(List<SolicitudCreditoRta> listaSolicitudCreditoRta) {
        this.listaSolicitudCreditoRta = listaSolicitudCreditoRta;
    }

    public List<SolicitudCredito> getListaSolicitud() {
        return listaSolicitud;
    }

    public void setListaSolicitud(List<SolicitudCredito> listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }
}

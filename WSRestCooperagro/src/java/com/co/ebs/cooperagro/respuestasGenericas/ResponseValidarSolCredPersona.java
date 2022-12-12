/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.SolicitudCredito;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class ResponseValidarSolCredPersona {

    private Boolean bRtaSolCredDlg;
    private Boolean bRtaSolCredNew;
    private String sMsj;
    private List<SolicitudCredito> listaSolicitud;

    public Boolean getbRtaSolCredDlg() {
        return bRtaSolCredDlg;
    }

    public void setbRtaSolCredDlg(Boolean bRtaSolCredDlg) {
        this.bRtaSolCredDlg = bRtaSolCredDlg;
    }

    public Boolean getbRtaSolCredNew() {
        return bRtaSolCredNew;
    }

    public void setbRtaSolCredNew(Boolean bRtaSolCredNew) {
        this.bRtaSolCredNew = bRtaSolCredNew;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public List<SolicitudCredito> getListaSolicitud() {
        return listaSolicitud;
    }

    public void setListaSolicitud(List<SolicitudCredito> listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }

}

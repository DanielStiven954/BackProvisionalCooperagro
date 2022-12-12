/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.NotificacionUsuarioR;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class ResponseNotificacionUsuario {
    
    private int iCodigo;
    private Boolean bRta;
    private String sMsj;
    private List<NotificacionUsuarioR> listNotificacionUsuario;

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

    public List<NotificacionUsuarioR> getListNotificacionUsuario() {
        return listNotificacionUsuario;
    }

    public void setListNotificacionUsuario(List<NotificacionUsuarioR> listNotificacionUsuario) {
        this.listNotificacionUsuario = listNotificacionUsuario;
    }
    
    
}

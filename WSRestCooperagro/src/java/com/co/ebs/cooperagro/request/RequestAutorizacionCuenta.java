/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.InscCuentaSolAfilWeb;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class RequestAutorizacionCuenta {

    private RequestAutorizacionSolAfilWeb listAutorizaciones;
    private InscCuentaSolAfilWeb cuentaSolAfilWeb;

    public RequestAutorizacionSolAfilWeb getListAutorizaciones() {
        return listAutorizaciones;
    }

    public void setListAutorizaciones(RequestAutorizacionSolAfilWeb listAutorizaciones) {
        this.listAutorizaciones = listAutorizaciones;
    }

    public InscCuentaSolAfilWeb getCuentaSolAfilWeb() {
        return cuentaSolAfilWeb;
    }

    public void setCuentaSolAfilWeb(InscCuentaSolAfilWeb cuentaSolAfilWeb) {
        this.cuentaSolAfilWeb = cuentaSolAfilWeb;
    }
}

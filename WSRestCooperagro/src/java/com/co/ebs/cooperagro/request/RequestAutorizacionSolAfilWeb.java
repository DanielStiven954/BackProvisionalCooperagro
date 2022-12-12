/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public class RequestAutorizacionSolAfilWeb {
    
    private String CIp;
    private String CNavegador;
    private List<AutorizacionSolAfilWeb> listAutorizaciones;

    public String getCIp() {
        return CIp;
    }

    public void setCIp(String CIp) {
        this.CIp = CIp;
    }

    public String getCNavegador() {
        return CNavegador;
    }

    public void setCNavegador(String CNavegador) {
        this.CNavegador = CNavegador;
    }

    public List<AutorizacionSolAfilWeb> getListAutorizaciones() {
        return listAutorizaciones;
    }

    public void setListAutorizaciones(List<AutorizacionSolAfilWeb> listAutorizaciones) {
        this.listAutorizaciones = listAutorizaciones;
    }
    
    
    
    
}

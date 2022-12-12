/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.CompDireccionSolAfilWeb;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class ResponseCompDireccion {
    private boolean flag;
    private String msm;
    List<CompDireccionSolAfilWeb> listaCompDireccion;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsm() {
        return msm;
    }

    public void setMsm(String msm) {
        this.msm = msm;
    }

    public List<CompDireccionSolAfilWeb> getListaCompDireccion() {
        return listaCompDireccion;
    }

    public void setListaCompDireccion(List<CompDireccionSolAfilWeb> listaCompDireccion) {
        this.listaCompDireccion = listaCompDireccion;
    }
    
}
